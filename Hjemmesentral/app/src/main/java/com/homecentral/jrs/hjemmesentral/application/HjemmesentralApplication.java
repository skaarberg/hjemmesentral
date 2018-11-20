package com.homecentral.jrs.hjemmesentral.application;

import android.app.Application;

import com.facebook.stetho.Stetho;

import net.danlew.android.joda.JodaTimeAndroid;

public class HjemmesentralApplication extends Application {

    private static HjemmesentralApplication application;

    private boolean mScreenIsActivated;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        Stetho.initializeWithDefaults(this);
        JodaTimeAndroid.init(this);
    }

    public static HjemmesentralApplication getInstance(){
        return application;
    }

    public void setScreenIsActivated(boolean activated){
        mScreenIsActivated = activated;
    }

    public boolean screenIsActivated(){
        return mScreenIsActivated;
    }
}
