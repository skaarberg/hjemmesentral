package com.homecentral.jrs.hjemmesentral.util;

import android.content.Context;
import android.content.SharedPreferences;

import org.joda.time.DateTime;

public class PreferenceHelper {

    private final static String DATA_NAME = "preferences";

    private enum Type {INTEGER, STRING, BOOLEAN, DATETIME}
    public enum PrefName {

        // RUTER
        RUTER_BASE_DATA_PREVIOUS_FETCH_TIME(Type.DATETIME),
        RUTER_REALTIME_PREVIOUS_FETCH_TIME(Type.DATETIME),

        // YR
        YR_PREVIOUS_FETCH_TIME(Type.DATETIME),

        CONNECTION_TEST_STATUS(Type.STRING);

        private final Type type;

        PrefName(Type type){
            this.type = type;
        }

        public Type getType(){
            return type;
        }
    }

    public static boolean getBoolean(Context context, PrefName name, boolean defaultValue){
        if (name.getType() != Type.BOOLEAN){
            throw new IllegalArgumentException();
        }
        return getPref(context).getBoolean(name.name(), defaultValue);
    }

    public static void writeBoolean(Context context, PrefName name, boolean value) {
        if (name.getType() != Type.BOOLEAN) {
            throw new IllegalArgumentException();
        }
        getPref(context).edit().putBoolean(name.name(), value).apply();
    }

    public static String getString(Context context, PrefName name){
        return getString(context, name, null);
    }

    public static String getString(Context context, PrefName name, String defaultValue){
        if (name.getType() != Type.STRING){
            throw new IllegalArgumentException();
        }
        return getPref(context).getString(name.name(), defaultValue);
    }

    public static void writeString(Context context, PrefName name, String value) {
        if (name.getType() != Type.STRING) {
            throw new IllegalArgumentException();
        }
        getPref(context).edit().putString(name.name(), value).apply();
    }

    public static int getInt(Context context, PrefName name){
        if (name.getType() != Type.INTEGER){
            throw new IllegalArgumentException();
        }
        return getPref(context).getInt(name.name(), -1);
    }

    public static void writeInt(Context context, PrefName name, int value) {
        if (name.getType() != Type.INTEGER) {
            throw new IllegalArgumentException();
        }
        getPref(context).edit().putInt(name.name(), value).apply();
    }

    public static DateTime getDateTime(Context context, PrefName name){
        if (name.getType() != Type.DATETIME){
            throw new IllegalArgumentException();
        }
        long dt = getPref(context).getLong(name.name(), -1);
        if(dt > 0){
            return new DateTime(dt);
        }
        return null;
    }

    public static void writeDateTime(Context context, PrefName name, DateTime value) {
        if (name.getType() != Type.DATETIME) {
            throw new IllegalArgumentException();
        }
        getPref(context).edit().putLong(name.name(), value == null ? - 1 : value.getMillis()).apply();
    }

    public static void registerListener(Context context, SharedPreferences.OnSharedPreferenceChangeListener listener) {
        getPref(context).registerOnSharedPreferenceChangeListener(listener);
    }

    public static void unregisterListener(Context context, SharedPreferences.OnSharedPreferenceChangeListener listener) {
        getPref(context).unregisterOnSharedPreferenceChangeListener(listener);
    }

    private static SharedPreferences getPref(Context context){
        return context.getSharedPreferences(DATA_NAME, Context.MODE_PRIVATE);
    }

    public static SharedPreferences getSharedPreferences(Context context){
        return context.getSharedPreferences(DATA_NAME, Context.MODE_PRIVATE);
    }
}
