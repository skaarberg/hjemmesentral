package com.homecentral.jrs.hjemmesentral.database;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.homecentral.jrs.hjemmesentral.model.yr.Forecast;
import com.homecentral.jrs.hjemmesentral.model.yr.Links;
import com.homecentral.jrs.hjemmesentral.model.yr.Meta;
import com.homecentral.jrs.hjemmesentral.model.yr.Observations;

import java.lang.reflect.Type;

public class WeatherdataConverter {

    @TypeConverter
    public static Forecast stringToForecast(String data) {
        if (data == null) {
            return null;
        }

        Type listType = new TypeToken<Forecast>() {}.getType();
        Gson gson = new Gson();
        return gson.fromJson(data, listType);
    }

    @TypeConverter
    public static String someObjectListToString(Forecast someObjects) {
        Gson gson = new Gson();
        return gson.toJson(someObjects);
    }

    @TypeConverter
    public static Links stringToLinks(String data) {
        if (data == null) {
            return null;
        }

        Type listType = new TypeToken<Links>() {}.getType();
        Gson gson = new Gson();
        return gson.fromJson(data, listType);
    }

    @TypeConverter
    public static String someObjectListToString(Links someObjects) {
        Gson gson = new Gson();
        return gson.toJson(someObjects);
    }

    @TypeConverter
    public static Meta stringToMeta(String data) {
        if (data == null) {
            return null;
        }

        Type listType = new TypeToken<Meta>() {}.getType();
        Gson gson = new Gson();
        return gson.fromJson(data, listType);
    }

    @TypeConverter
    public static String someObjectListToString(Meta someObjects) {
        Gson gson = new Gson();
        return gson.toJson(someObjects);
    }

    @TypeConverter
    public static Observations stringToObservations(String data) {
        if (data == null) {
            return null;
        }

        Type listType = new TypeToken<Observations>() {}.getType();
        Gson gson = new Gson();
        return gson.fromJson(data, listType);
    }

    @TypeConverter
    public static String someObjectListToString(Observations someObjects) {
        Gson gson = new Gson();
        return gson.toJson(someObjects);
    }
}
