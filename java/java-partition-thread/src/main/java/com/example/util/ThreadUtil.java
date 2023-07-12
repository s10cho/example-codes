package com.example.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ThreadUtil {

    public static final ThreadMXBean THREAD_MX_BEAN = ManagementFactory.getThreadMXBean();

    public static void check() {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        int maxThreads = THREAD_MX_BEAN.getThreadCount();
        int peakThreads = THREAD_MX_BEAN.getPeakThreadCount();
        long totalStartedThreads = THREAD_MX_BEAN.getTotalStartedThreadCount();

        log.info("number of processors available: {}", availableProcessors);
        log.info("Total number of threads (the number of threads currently running): {}", maxThreads);
        log.info("max threads (maximum number of concurrently spawned threads): {}", peakThreads);
        log.info("Total number of threads started: {}", totalStartedThreads);
    }
}
