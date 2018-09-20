package com.homecentral.jrs.hjemmesentral.database;

import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.os.AsyncTask;

import com.homecentral.jrs.hjemmesentral.model.yr.LongTermWeatherData;

public class YrRepository {

    private YrDao mYrDao;
    private LiveData<LongTermWeatherData> mWeatherdata;

    public YrRepository(Context context) {
        YrDatabase db = YrDatabase.getDatabase(context);
        mYrDao = db.yrDao();
        mWeatherdata = mYrDao.getWeatherData();
    }

    public LiveData<LongTermWeatherData> getWeatherData() {
        return mWeatherdata;
    }

    public void insert (LongTermWeatherData weatherData) {
        new insertAsyncTask(mYrDao).execute(weatherData);
    }

    private static class insertAsyncTask extends AsyncTask<LongTermWeatherData, Void, Void> {

        private YrDao mAsyncTaskDao;

        insertAsyncTask(YrDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final LongTermWeatherData... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
