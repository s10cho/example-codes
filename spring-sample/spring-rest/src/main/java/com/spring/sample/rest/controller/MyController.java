package com.spring.sample.rest.controller;

import java.util.HashMap;
import java.util.Map;

import com.spring.sample.rest.dto.MetadataParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("my")
public class MyController {

    @GetMapping
    public ResponseEntity<?> sample(
        @RequestParam(required = false, defaultValue = "") String id,
        @RequestParam(required = false, defaultValue = "") String type,
        @RequestParam(required = false, defaultValue = "") MetadataParam metadata
    ) {
        log.debug("id = " + id);
        log.debug("type = " + type);
        log.debug("metadata.toMetadata() = " + metadata.toMetadata());

        Map<String, Object> body = new HashMap<>();
        body.put("id", id);
        body.put("type", type);
        body.put("metadata", metadata.toMetadata());
        return ResponseEntity.ok().body(body);
    }
}
