package com.spring.sample.command.line.runner.with.multi.thread.service;

import java.util.List;

import com.spring.sample.command.line.runner.with.multi.thread.domain.MyData;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MyProcessorThread implements Runnable {

    private MyProcessor myService;

    private List<MyData> myDataList;

    @Override
    public void run() {
        myDataList.forEach(myService::send);
    }
}
