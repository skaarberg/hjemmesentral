package com.homecentral.jrs.hjemmesentral.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

import com.homecentral.jrs.hjemmesentral.model.yr.LongTermWeatherData;

@Database(entities = {LongTermWeatherData.class}, version = 3)
@TypeConverters(WeatherdataConverter.class)
public abstract class YrDatabase extends RoomDatabase {

    private static YrDatabase INSTANCE;

    public abstract YrDao yrDao();

    public static YrDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (YrDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            YrDatabase.class, "yr_long_term_weather_data")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}