package com.homecentral.jrs.hjemmesentral.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.homecentral.jrs.hjemmesentral.database.YrRepository;
import com.homecentral.jrs.hjemmesentral.model.yr.WeatherData;

public class YrViewModel extends AndroidViewModel {

    private YrRepository mRepository;

    private LiveData<WeatherData> mWeatherData;

    public YrViewModel (Application application) {
        super(application);
        mRepository = new YrRepository(application);
        mWeatherData = mRepository.getWeatherData();
    }

    public LiveData<WeatherData> getWeatherData() { return mWeatherData; }

    public void insert(WeatherData weatherData) { mRepository.insert(weatherData); }
}