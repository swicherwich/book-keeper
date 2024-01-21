package com.bookkeeping.service.alarms.rules;

import com.bookkeeping.service.alarms.AlarmServiceApplication;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

public class RuleMapper {

    private RuleMapper() {
    }

    public static List<AlarmRule> map(String path) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(getFileFromResource(path), new TypeReference<>() {});
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    private static URL getFileFromResource(String fileName) throws URISyntaxException {
        ClassLoader classLoader = AlarmServiceApplication.class.getClassLoader();
        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            return resource;
        }

    }
}
