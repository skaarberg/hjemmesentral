package com.homecentral.jrs.hjemmesentral.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.homecentral.jrs.hjemmesentral.database.YrRepository;
import com.homecentral.jrs.hjemmesentral.model.yr.LongTermWeatherData;

public class YrViewModel extends AndroidViewModel {

    private YrRepository mRepository;

    private LiveData<LongTermWeatherData> mWeatherData;

    public YrViewModel (Application application) {
        super(application);
        mRepository = new YrRepository(application);
        mWeatherData = mRepository.getWeatherData();
    }

    public LiveData<LongTermWeatherData> getWeatherData() { return mWeatherData; }

    public void insert(LongTermWeatherData weatherData) { mRepository.insert(weatherData); }
}