package com.homecentral.jrs.hjemmesentral.database;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.homecentral.jrs.hjemmesentral.model.yr.Forecast;
import com.homecentral.jrs.hjemmesentral.model.yr.Link;
import com.homecentral.jrs.hjemmesentral.model.yr.Meta;

import java.lang.reflect.Type;
import java.util.List;

public class WeatherdataConverter {

    @TypeConverter
    public String fromOptionValuesList(List<Link> links) {
        if (links == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<Link>>() {
        }.getType();
        String json = gson.toJson(links, type);
        return json;
    }

    @TypeConverter
    public List<Link> toOptionValuesList(String linksString) {
        if (linksString == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<Link>>() {
        }.getType();
        List<Link> links = gson.fromJson(linksString, type);
        return links;
    }

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
}
