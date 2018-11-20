package com.homecentral.jrs.hjemmesentral.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.homecentral.jrs.hjemmesentral.R
import com.homecentral.jrs.hjemmesentral.scheduler.HomeCentralWorkManager
import com.homecentral.jrs.hjemmesentral.util.RotateScreenUtil
import kotlinx.android.synthetic.main.activity_main.*
import android.os.PowerManager
import android.annotation.TargetApi
import android.content.Context
import android.util.Log
import com.homecentral.jrs.hjemmesentral.util.ScreenUtil
import android.view.WindowManager




class MainActivity : ScreenAutoOffActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Settings.Global.putInt(getContentResolver(), Settings.Global.STAY_ON_WHILE_PLUGGED_IN, 0);

        RotateScreenUtil.rotateScreen(root_container, this)

        HomeCentralWorkManager.scheduleSyncWeather(true);
        HomeCentralWorkManager.scheduleSyncLines(this);
        HomeCentralWorkManager.scheduleSyncDepartures(this, false, false);

        //ScreenUtil.turnOffScreen(getSystemService(Context.POWER_SERVICE) as PowerManager?)

        val lp = window.attributes
        lp.screenBrightness = 0.51f
        window.attributes = lp
    }
}
