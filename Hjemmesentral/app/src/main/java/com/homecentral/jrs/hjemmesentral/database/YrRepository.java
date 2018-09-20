package com.homecentral.jrs.hjemmesentral.database;

import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.os.AsyncTask;

import com.homecentral.jrs.hjemmesentral.model.yr.WeatherData;

public class YrRepository {

    private YrDao mYrDao;
    private LiveData<WeatherData> mWeatherdata;

    public YrRepository(Context context) {
        YrDatabase db = YrDatabase.getDatabase(context);
        mYrDao = db.yrDao();
        mWeatherdata = mYrDao.getWeatherData();
    }

    public LiveData<WeatherData> getWeatherData() {
        return mWeatherdata;
    }

    public void insert (WeatherData weatherData) {
        new insertAsyncTask(mYrDao).execute(weatherData);
    }

    private static class insertAsyncTask extends AsyncTask<WeatherData, Void, Void> {

        private YrDao mAsyncTaskDao;

        insertAsyncTask(YrDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final WeatherData... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
