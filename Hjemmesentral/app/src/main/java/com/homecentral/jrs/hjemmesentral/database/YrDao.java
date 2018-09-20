package com.homecentral.jrs.hjemmesentral.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.homecentral.jrs.hjemmesentral.model.yr.WeatherData;

@Dao
public interface YrDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(WeatherData weatherData);

    @Query("DELETE FROM yr_weather_data")
    void deleteAll();

    @Query("SELECT * FROM yr_weather_data")
    LiveData<WeatherData> getWeatherData();
}