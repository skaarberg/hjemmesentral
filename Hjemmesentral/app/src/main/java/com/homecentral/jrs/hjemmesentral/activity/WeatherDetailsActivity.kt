package com.homecentral.jrs.hjemmesentral.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.homecentral.jrs.hjemmesentral.R
import com.homecentral.jrs.hjemmesentral.model.yr.forecast.Time

class WeatherDetailsActivity : AppCompatActivity(){

    companion object {

        private val WEATHER_DETAILS_FROM = "weatherDetailsFrom"
        private val WEATHER_DETAILS_TO = "weatherDetailsTo"

        fun newIntent(context: Context, time: Time) : Intent {
            val intent = Intent(context, WeatherDetailsActivity::class.java)
            intent.putExtra(WEATHER_DETAILS_FROM, time.from)
            intent.putExtra(WEATHER_DETAILS_TO, time.to)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather_details)
    }
}