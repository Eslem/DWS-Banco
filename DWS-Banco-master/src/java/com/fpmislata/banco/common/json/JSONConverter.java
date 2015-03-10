package com.fpmislata.banco.common.json;

public interface JSONConverter {
    public String toJSON(Object object) throws RuntimeException;
    
    public <T> T fromJSON(String json, Class<T> className) throws RuntimeException;
}
