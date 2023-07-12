package com.example;

import com.example.biz.service.BizService;
import com.example.util.PartitionIdGenerator;
import com.example.util.ThreadUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.LongStream;

@Slf4j
public class App {

    public static final BizService BIZ_SERVICE = new BizService();

    public static void main(String[] args) throws InterruptedException {
        int partitionCount = 10;
        int processCount = 50;

        ExecutorService executorService = Executors.newFixedThreadPool(partitionCount);
        CountDownLatch countDownLatch = new CountDownLatch(processCount);
        PartitionIdGenerator.setPartitionSize(partitionCount);

        long start = System.currentTimeMillis();
        LongStream.range(0, countDownLatch.getCount()).<Runnable>mapToObj(i -> () -> {
            String threadName = "partition-thread-" + PartitionIdGenerator.generateByPartitionKey(i);
            Thread.currentThread().setName(threadName);

            BIZ_SERVICE.process();
            countDownLatch.countDown();
        }).forEach(executorService::execute);

        ThreadUtil.check();

        countDownLatch.await();
        executorService.shutdown();
        log.info("[App] elapsed time {}(ms)", System.currentTimeMillis() - start);
    }


}
