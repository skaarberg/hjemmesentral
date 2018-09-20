package com.homecentral.jrs.hjemmesentral.scheduler;

import android.support.annotation.NonNull;

import com.homecentral.jrs.hjemmesentral.network.ruter.RuterNetworkUtil;
import com.homecentral.jrs.hjemmesentral.network.ruter.RuterUtil;

import java.io.IOException;

import androidx.work.Worker;

public class LinesWorker extends Worker {

    @NonNull
    @Override
    public Worker.Result doWork() {
        return RuterUtil.fetchLines(getApplicationContext()) ? Worker.Result.SUCCESS : Worker.Result.FAILURE;
    }
}