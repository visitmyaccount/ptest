/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rm.config.util;

import java.util.Properties;

/**
 *
 * @author sivakrishna.k
 */
public class ConfigUtil {

    protected static Properties properties = new Properties();

    public boolean init(String filePath) {
        return true;
    }

    public static Properties getProperties() {
        return properties;
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static String getProperty(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }
}
