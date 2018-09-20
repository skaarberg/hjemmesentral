package com.homecentral.jrs.hjemmesentral.scheduler;

import android.support.annotation.NonNull;

import com.homecentral.jrs.hjemmesentral.network.yr.YrNetworkUtil;

import java.io.IOException;

import androidx.work.Worker;

public class YrWorker extends Worker {

    @NonNull
    @Override
    public Worker.Result doWork() {
        try {
            YrNetworkUtil.fetchYrData(getApplicationContext());
            return Worker.Result.SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return Worker.Result.FAILURE;
        }
    }
}
