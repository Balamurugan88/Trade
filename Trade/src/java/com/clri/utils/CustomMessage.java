/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clri.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author Balamurugan
 */
public class CustomMessage {

    private static final String PROP_FILE_NAME = "message.properties";
    private static Properties props;

    public static Properties getMessage() throws IOException {
        InputStream is
                = Queries.class.getResourceAsStream(PROP_FILE_NAME);
        if (is == null) {
            throw new IOException("Unable to load property file: " + PROP_FILE_NAME);
        }
        //singleton
        if (props == null) {
            props = new Properties();
            try {
                props.load(is);
            } catch (IOException e) {
                throw new IOException("Unable to load property file: " + PROP_FILE_NAME + "\n" + e.getMessage());
            }
        }
        return props;
    }

    public static String getMessage(String query) throws IOException  {
        return getMessage().getProperty(query);
    }

}
