package com.homecentral.jrs.hjemmesentral.activity

import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.support.v7.app.AppCompatActivity
import com.homecentral.jrs.hjemmesentral.R
import com.homecentral.jrs.hjemmesentral.fragment.YrFragment
import com.homecentral.jrs.hjemmesentral.scheduler.HomeCentralWorkManager
import com.homecentral.jrs.hjemmesentral.util.RotateScreenUtil
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), YrFragment.OnFragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Settings.Global.putInt(getContentResolver(), Settings.Global.STAY_ON_WHILE_PLUGGED_IN, 0);

        RotateScreenUtil.rotateScreen(root_container, this)

        HomeCentralWorkManager.scheduleSyncWeather();
        HomeCentralWorkManager.scheduleSyncLines(this);
        HomeCentralWorkManager.scheduleSyncDepartures(this, false);
    }

    override fun onFragmentInteraction(uri: Uri?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
