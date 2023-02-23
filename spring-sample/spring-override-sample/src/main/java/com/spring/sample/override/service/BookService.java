package com.spring.sample.override.service;

import org.springframework.stereotype.Service;

@Service
public class BookService {

    public String getBookName() {
        return "Spring boot";
    }
}
