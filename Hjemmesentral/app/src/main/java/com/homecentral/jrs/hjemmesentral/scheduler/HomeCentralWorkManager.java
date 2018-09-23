package com.homecentral.jrs.hjemmesentral.scheduler;

import android.content.Context;

import com.homecentral.jrs.hjemmesentral.util.PreferenceHelper;

import org.joda.time.DateTime;

import java.util.concurrent.TimeUnit;

import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;

public class HomeCentralWorkManager{

    private static String REQUEST_TAG_YR_SINGLE = "yr_single";
    private static String REQUEST_TAG_YR_PERIODIC = "yr_periodic";
    private static String REQUEST_TAG_RUTER_BASE_DATA = "ruter_base_data";
    private static String REQUEST_TAG_RUTER_DEPARTURES = "ruter_base_departures";

    public static void scheduleSyncWeather(boolean isPeriodic){

        if(isPeriodic) {
            final PeriodicWorkRequest periodicWorkRequest =
                    new PeriodicWorkRequest.Builder(YrWorker.class, 1200000, TimeUnit.MILLISECONDS)
                            .addTag(REQUEST_TAG_YR_PERIODIC)
                            .build();

            WorkManager.getInstance().cancelAllWorkByTag(REQUEST_TAG_YR_PERIODIC);
            WorkManager.getInstance().enqueue(periodicWorkRequest);
        }
        else {
            WorkManager.getInstance().cancelAllWorkByTag(REQUEST_TAG_YR_SINGLE);

            OneTimeWorkRequest workRequest =
                    new OneTimeWorkRequest.Builder(YrWorker.class)
                            .addTag(REQUEST_TAG_YR_SINGLE)
                            .build();
            WorkManager.getInstance().enqueue(workRequest);
        }
    }

    public static void scheduleSyncLines(Context context){
        DateTime previousSync = PreferenceHelper.getDateTime(context, PreferenceHelper.PrefName.RUTER_BASE_DATA_PREVIOUS_FETCH_TIME);
        if(previousSync == null || DateTime.now().getMillis() - previousSync.getMillis() > (1000 * 60 * 60 * 24)) {
            final PeriodicWorkRequest periodicWorkRequest =
                    new PeriodicWorkRequest.Builder(LinesWorker.class, (1000 * 60 * 60 * 24), TimeUnit.MILLISECONDS)
                            .addTag(REQUEST_TAG_RUTER_BASE_DATA)
                            .build();

            WorkManager.getInstance().cancelAllWorkByTag(REQUEST_TAG_RUTER_BASE_DATA);
            WorkManager.getInstance().enqueue(periodicWorkRequest);
        }
    }

    public static void scheduleSyncDepartures(Context context, boolean delay, boolean force){
        DateTime previousSync = PreferenceHelper.getDateTime(context, PreferenceHelper.PrefName.RUTER_BASE_DATA_PREVIOUS_FETCH_TIME);
        if(previousSync == null || DateTime.now().getMillis() - previousSync.getMillis() > (1000 * 60) || force) {
            WorkManager.getInstance().cancelAllWorkByTag(REQUEST_TAG_RUTER_DEPARTURES);

            OneTimeWorkRequest workRequest =
                    new OneTimeWorkRequest.Builder(DeparturesWorker.class)
                            .addTag(REQUEST_TAG_RUTER_DEPARTURES)
                            .setInitialDelay(delay ? 1 : 0, TimeUnit.MINUTES)
                            .build();
            WorkManager.getInstance().enqueue(workRequest);
        }
    }
}
