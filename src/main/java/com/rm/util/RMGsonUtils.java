/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rm.util;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import java.io.IOException;

/**
 *
 * @author sivakrishna.k
 */
public class RMGsonUtils {

    private static Gson normatlGson = new Gson();

    public static String toJson(Object object, Class objectClass) {
        return normatlGson.toJson(object, objectClass);
    }
    
    public static <T extends Object> T fromJson(String jsonString, Class<T> objectClass) throws JsonSyntaxException {

        try {
            return normatlGson.getAdapter(objectClass).fromJson(jsonString);
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new JsonSyntaxException(ex);
        }

    }
}
