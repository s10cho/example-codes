package com.spring.sample.command.line.runner.with.multi.thread.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MyData {

    private String name;

    public static MyData of(String name) {
        return new MyData(name);
    }

    public static MyData of(int name) {
        return new MyData(Integer.toString(name));
    }


    public static void main(String[] args) {
        MyData sample = new MyData("sample");
        System.out.println("sample = " + sample);
    }
}
