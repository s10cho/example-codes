package com.spring.sample.command.line.runner.with.multi.thread.service;

import com.spring.sample.command.line.runner.with.multi.thread.domain.MyData;

public interface MyProcessor {

    void send(MyData myData);
}
