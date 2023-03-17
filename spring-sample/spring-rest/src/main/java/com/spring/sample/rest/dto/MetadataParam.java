package com.spring.sample.rest.dto;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MetadataParam extends ArrayList<String> {

    public Metadata toMetadata() {
        Metadata metadata = new Metadata();
        stream().map(KeyValue::new)
            .forEach(metadata::add);
        return metadata;
    }
}
