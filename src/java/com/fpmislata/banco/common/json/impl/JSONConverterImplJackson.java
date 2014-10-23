package com.fpmislata.banco.common.json.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fpmislata.banco.common.json.JSONConverter;
import java.io.IOException;

public class JSONConverterImplJackson implements JSONConverter {

    @Override
    public String toJSON(Object object) throws RuntimeException {
        try {
            return new ObjectMapper().writeValueAsString(object);
        } catch (JsonProcessingException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public <T> T fromJSON(String json, Class<T> className) throws RuntimeException {
        try {
            return (T) new ObjectMapper().readValue(json, className);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
