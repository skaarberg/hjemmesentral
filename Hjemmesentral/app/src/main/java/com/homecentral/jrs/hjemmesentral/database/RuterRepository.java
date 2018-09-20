package com.homecentral.jrs.hjemmesentral.database;

import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.homecentral.jrs.hjemmesentral.model.ruter.Departure;
import com.homecentral.jrs.hjemmesentral.model.ruter.Line;
import com.homecentral.jrs.hjemmesentral.model.ruter.LineDepartures;

import java.util.ArrayList;
import java.util.List;

public class RuterRepository {

    private static String TAG = "RuterRepository";

    private RuterDao mRuterDao;
    private LiveData<List<Line>> mLines;
    private LiveData<List<Line>> mLocalLines;
    private LiveData<List<Departure>> mDepartures;

    public RuterRepository(Context context) {
        RuterDatabase db = RuterDatabase.getDatabase(context);
        mRuterDao = db.ruterDao();
        mLines = mRuterDao.getLines();
        mDepartures = mRuterDao.getDepartures();
    }

    public LiveData<List<Line>> getLines() {
        return mLines;
    }

    public LiveData<List<Line>> getLocalLines(List<Departure> departures) {
        if(departures != null && departures.size() > 0) {
            if(mLocalLines != null) {
                mLocalLines.getValue().clear();
            }
            for (Departure lineDeparture : departures) {
                mLocalLines.getValue().add(mRuterDao.getLineForName(lineDeparture.getMonitoredVehicleJourney().getLineRef()).getValue());
            }
        }
        return mLocalLines;
    }

    public void insertLines(List<Line> lines) {
        new insertLinesAsyncTask(mRuterDao).execute(lines);
    }

    public LiveData<List<Departure>> getDepartures() {
        return mDepartures;
    }

    public void insertDepartures(List<Departure> departures) {
        new insertDeparturesAsyncTask(mRuterDao).execute(departures);
    }

    private static class insertLinesAsyncTask extends AsyncTask<List<Line>, Void, Void> {

        private RuterDao mAsyncTaskDao;

        insertLinesAsyncTask(RuterDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final List<Line>... params) {
            mAsyncTaskDao.insertLines(params[0]);
            Log.d(TAG, "inserted " + params[0].size() + " lines");
            return null;
        }
    }

    private static class insertDeparturesAsyncTask extends AsyncTask<List<Departure>, Void, Void> {

        private RuterDao mAsyncTaskDao;

        insertDeparturesAsyncTask(RuterDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final List<Departure>... params) {
            mAsyncTaskDao.insertDepartures(params[0]);
            Log.d(TAG, "inserted " + params[0].size() + " departures");
            return null;
        }
    }

    public void deleteDepartures(){
        new deleteDeparturesAsyncTask(mRuterDao).execute();
    }

    private static class deleteDeparturesAsyncTask extends AsyncTask<Void, Void, Void> {

        private RuterDao mAsyncTaskDao;

        deleteDeparturesAsyncTask(RuterDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Void... params) {
            Log.d(TAG, "deleted ALL departures");
            mAsyncTaskDao.deleteAllDepartures();
            return null;
        }
    }

    public LiveData<Line> getLine(String name) {
        return mRuterDao.getLineForName(name);
    }
}
