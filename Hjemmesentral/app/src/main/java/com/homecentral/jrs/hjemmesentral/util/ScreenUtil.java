package com.homecentral.jrs.hjemmesentral.util;

import android.annotation.TargetApi;
import android.os.PowerManager;
import android.util.Log;

public class ScreenUtil {

    //private PowerManager mPowerManager;
    //private PowerManager.WakeLock mWakeLock;

    public static void turnOnScreen(PowerManager powerManager){
        // turn on screen
        Log.v("ProximityActivity", "ON!");
        PowerManager.WakeLock wakeLock = powerManager.newWakeLock(PowerManager.SCREEN_BRIGHT_WAKE_LOCK | PowerManager.ACQUIRE_CAUSES_WAKEUP, "RuterUtil:tag");
        wakeLock.acquire(10*60*1000L /*10 minutes*/);
    }

    @TargetApi(21) //Suppress lint error for PROXIMITY_SCREEN_OFF_WAKE_LOCK
    public static void turnOffScreen(PowerManager powerManager){
        // turn off screen
        Log.v("ProximityActivity", "OFF!");
        PowerManager.WakeLock wakeLock = powerManager.newWakeLock(PowerManager.PROXIMITY_SCREEN_OFF_WAKE_LOCK, "RuterUtil:tag");
        wakeLock.acquire(10*60*1000L /*10 minutes*/);
    }

}
