package com.homecentral.jrs.hjemmesentral.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;

import com.homecentral.jrs.hjemmesentral.util.ScreenUtil;

public class ScreenAutoOffActivity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        int i = 0;
        ScreenUtil.turnOnScreen(this);
        super.onCreate(savedInstanceState);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        ScreenUtil.turnOnScreen(this);
        return super.dispatchTouchEvent(event);
    }
}
