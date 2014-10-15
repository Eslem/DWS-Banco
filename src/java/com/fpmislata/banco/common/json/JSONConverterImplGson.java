/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fpmislata.banco.common.json;

import com.google.gson.Gson;

/**
 *
 * @author eslem
 */
public class JSONConverterImplGson implements JSONConverter{

    @Override
    public String toJSON(Object obj) {
        Gson gson = new Gson();
        return gson.toJson(obj);
    }

    @Override
    public Object fromJSON(String json, Class clazz) {
        Gson gson = new Gson();
        return gson.fromJson(json, clazz);
    }
    
}
