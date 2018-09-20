package com.homecentral.jrs.hjemmesentral.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.homecentral.jrs.hjemmesentral.model.yr.LongTermWeatherData;

@Dao
public interface YrDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(LongTermWeatherData weatherData);

    @Query("DELETE FROM yr_long_term_weather_data")
    void deleteAll();

    @Query("SELECT * FROM yr_long_term_weather_data")
    LiveData<LongTermWeatherData> getWeatherData();
}