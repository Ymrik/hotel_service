package com.umarbariev.projects.hotel_service.util.converters;

import com.fasterxml.jackson.databind.ObjectMapper;

public class BasicConverter {
    public final static ObjectMapper objectMapper = new ObjectMapper();

    public static <T> T convert(Object object, Class<T> clazz) {
        return objectMapper.convertValue(object, clazz);
    }
}
