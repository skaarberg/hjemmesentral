package com.homecentral.jrs.hjemmesentral.scheduler;

import android.support.annotation.NonNull;

import com.homecentral.jrs.hjemmesentral.database.RuterRepository;
import com.homecentral.jrs.hjemmesentral.network.ruter.RuterNetworkUtil;
import com.homecentral.jrs.hjemmesentral.network.ruter.RuterUtil;

import java.io.IOException;

import androidx.work.Worker;

public class DeparturesWorker extends Worker{

    @NonNull
    @Override
    public Worker.Result doWork() {
        RuterUtil.deleteDepartures(getApplicationContext());
        return RuterUtil.fetchRealTimeData(getApplicationContext()) ? Worker.Result.SUCCESS : Worker.Result.FAILURE;
    }
}