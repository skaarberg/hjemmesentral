package com.homecentral.jrs.hjemmesentral.database;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.homecentral.jrs.hjemmesentral.model.ruter.Extensions;
import com.homecentral.jrs.hjemmesentral.model.ruter.MonitoredVehicleJourney;
import com.homecentral.jrs.hjemmesentral.model.ruter.Stop;
import com.homecentral.jrs.hjemmesentral.model.ruter.StopVisitNote;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

public class RuterConverter {

    @TypeConverter
    public static List<Stop> stringToStopList(String data) {
        if (data == null) {
            return Collections.emptyList();
        }

        Type listType = new TypeToken<List<Stop>>() {}.getType();
        Gson gson = new Gson();
        return gson.fromJson(data, listType);
    }

    @TypeConverter
    public static String someObjectListToString(List<Stop> someObjects) {
        Gson gson = new Gson();
        return gson.toJson(someObjects);
    }

    //MonitoredVehicleJourney
    //Extensions
    @TypeConverter
    public static MonitoredVehicleJourney stringToMonitoredVehicleJourney(String data) {
        if (data == null) {
            return null;
        }

        Type listType = new TypeToken<MonitoredVehicleJourney>() {}.getType();
        Gson gson = new Gson();
        return gson.fromJson(data, listType);
    }

    @TypeConverter
    public static String someObjectListToString(MonitoredVehicleJourney someObjects) {
        Gson gson = new Gson();
        return gson.toJson(someObjects);
    }

    @TypeConverter
    public static Extensions stringToExtensions(String data) {
        if (data == null) {
            return null;
        }

        Type listType = new TypeToken<Extensions>() {}.getType();
        Gson gson = new Gson();
        return gson.fromJson(data, listType);
    }

    @TypeConverter
    public static String someObjectListToString(Extensions someObjects) {
        Gson gson = new Gson();
        return gson.toJson(someObjects);
    }

    @TypeConverter
    public static List<StopVisitNote> stringToStopVisitNoteList(String data) {
        if (data == null) {
            return Collections.emptyList();
        }

        Type listType = new TypeToken<List<Object>>() {}.getType();
        Gson gson = new Gson();
        return gson.fromJson(data, listType);
    }

    @TypeConverter
    public static String stopVisitNoteListToString(List<StopVisitNote> someObjects) {
        Gson gson = new Gson();
        return gson.toJson(someObjects);
    }
}
