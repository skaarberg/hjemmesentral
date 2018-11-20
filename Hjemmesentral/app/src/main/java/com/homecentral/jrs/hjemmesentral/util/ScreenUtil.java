package com.homecentral.jrs.hjemmesentral.util;

import android.app.Activity;
import android.os.CountDownTimer;
import android.view.WindowManager;

import com.homecentral.jrs.hjemmesentral.application.HjemmesentralApplication;

public class ScreenUtil {

    private static CountDownTimer countDownTimer;

    private static CountDownTimer getTimerInstance(Activity activity){

        if(countDownTimer == null) {
            countDownTimer = new CountDownTimer(15000, 1000) {

                public void onTick(long millisUntilFinished) {
                }

                public void onFinish() {
                    turnOffScreen(activity);
                }

            };
        }
        else {
            countDownTimer.cancel();
        }
        return countDownTimer;
    }

    public static void turnOnScreen(Activity activity){
        WindowManager.LayoutParams lp = activity.getWindow().getAttributes();
        lp.screenBrightness = 0.50f;
        activity.getWindow().setAttributes( lp );

        getTimerInstance(activity).start();
        HjemmesentralApplication.getInstance().setScreenIsActivated(true);
    }

    private static void turnOffScreen(Activity activity){
        WindowManager.LayoutParams lp = activity.getWindow().getAttributes();
        lp.screenBrightness = 0.01f;
        activity.getWindow().setAttributes( lp );
        HjemmesentralApplication.getInstance().setScreenIsActivated(false);
    }
}
