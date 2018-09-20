package com.homecentral.jrs.hjemmesentral.util;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import com.fasterxml.jackson.module.kotlin.KotlinModule;

public class JacksonHelper {
    private static ObjectMapper sObjectMapper;
    private static JsonFactory sJsonFactory;

    public static ObjectMapper getInstance() {
        if (sObjectMapper == null) {
            sObjectMapper = new ObjectMapper()
                    .setPropertyNamingStrategy(PropertyNamingStrategy.UPPER_CAMEL_CASE)
                    .registerModule(new JodaModule())
                    .registerModule(new KotlinModule());
            sObjectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        }
        return sObjectMapper;
    }

    public static JsonFactory getJsonFactory() {
        if (sJsonFactory == null) {
            sJsonFactory = new JsonFactory();
        }
        return sJsonFactory;
    }
}
