package com.homecentral.jrs.hjemmesentral.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.homecentral.jrs.hjemmesentral.R;

public class TestActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Settings.System.putString(getContentResolver(), Settings.System.SCREEN_OFF_TIMEOUT, "-1");
    }

    @Nullable
    @Override
    public View onCreateView(String name, Context context, AttributeSet attrs) {
        setContentView(R.layout.activity_main);
        return super.onCreateView(name, context, attrs);
    }
}
