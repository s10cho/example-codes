package com.spring.web.lang.resource.service;

import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Locale;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class I18nService {

    public String find(Locale locale) {
        try {
            Path path = Paths.get(new ClassPathResource("i18n/%s.json".formatted(locale)).getURI());
            return Files.readString(path);
        } catch (FileNotFoundException e) {
            return find(new Locale("default"));
        } catch (Exception e) {
            log.error("Not found.", e);
            return "Not found.";
        }
    }
}
