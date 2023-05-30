package com.spring.web.lang.resource.controller;

import java.util.Locale;

import com.spring.web.lang.resource.service.I18nService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("i18n")
public class I18nController {

    private final I18nService langService;

    @GetMapping("{local}")
    public String find(
        @PathVariable("local") Locale locale
    ) {
        return langService.find(locale);
    }
}
