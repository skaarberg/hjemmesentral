package com.homecentral.jrs.hjemmesentral.network.ruter

import android.content.Context
import android.util.Log
import com.android.volley.AuthFailureError
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.VolleyLog
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.homecentral.jrs.hjemmesentral.database.RuterRepository

import com.homecentral.jrs.hjemmesentral.util.DateUtil
import com.homecentral.jrs.hjemmesentral.util.PreferenceHelper

import org.joda.time.DateTime
import org.json.JSONObject

import java.io.IOException

object RuterNetworkUtil {

    private val REALTIME_BASE_URL = "http://reisapi.ruter.no/stopvisit/getdepartures/"
    public val STOP_ID_STROEMSVEIEN = 3010641;
    public val STOP_ID_JORDAL = 3010640;

    @Throws(IOException::class)
    public fun fetchLines(context: Context) {

        /*
        // Has recently fetched, will not do again yet
        if (!DateUtil.isWithinMinutes(DateTime.now(), PreferenceHelper.getDateTime(context, PreferenceHelper.PrefName.RUTER_BASE_DATA_PREVIOUS_FETCH_TIME), 1440)) {
            return
        }
        */

        // Instantiate the RequestQueue.
        val queue = Volley.newRequestQueue(context)
        val url = "http://reisapi.ruter.no/line/GetLinesRuterExtended"

        // Request newIntent string response from the provided URL.
        val jsonObjReq = object : StringRequest(Method.GET, url,
                Response.Listener<String> { response ->
                    val lines = RuterParser.parseBaseData(response)
                    val ruterRepository = RuterRepository(context)
                    if (lines.size > 0)
                        ruterRepository.insertLines(lines)
                    PreferenceHelper.writeDateTime(context, PreferenceHelper.PrefName.RUTER_BASE_DATA_PREVIOUS_FETCH_TIME, DateTime.now())
                },
                Response.ErrorListener {
                    val i = 2 * 2;
                }) {
            @Throws(AuthFailureError::class)
            override fun getHeaders(): Map<String, String> {
                val headers = HashMap<String, String>()
                headers.put("Content-Type", "application/json")
                return headers
            }
        }
        queue.add(jsonObjReq)
    }

    @Throws(IOException::class)
    fun fetchRealTimeData(context: Context, stopId: Int) {

        // Has recently fetched, will not do again yet
        if (!DateUtil.isWithinMinutes(DateTime.now(), PreferenceHelper.getDateTime(context, PreferenceHelper.PrefName.RUTER_REALTIME_PREVIOUS_FETCH_TIME), 1440)) {
            return
        }

        // Instantiate the RequestQueue.
        val queue = Volley.newRequestQueue(context)
        val ruterRepository = RuterRepository(context)
        val url = REALTIME_BASE_URL + stopId

        /*
        val request = StringRequest(Request.Method.GET, url,
                Response.Listener<String> { response ->
                    val departures = RuterParser.parseRealtimeData(response)
                    if (departures.size > 0) {
                        ruterRepository.insertDepartures(departures)
                    }
                    PreferenceHelper.writeDateTime(context, PreferenceHelper.PrefName.RUTER_REALTIME_PREVIOUS_FETCH_TIME, DateTime.now())
                },
                Response.ErrorListener {
                    val i = 2*2;
                }
        )
        queue.add(request)
*/
        val TAG = RuterNetworkUtil::class.java.simpleName
        val jsonObjReq = object : StringRequest(Method.GET, url,
                Response.Listener<String> { response ->
                    Log.d(TAG, "/post request OK! Response: $response")
                    val departures = RuterParser.parseRealtimeData(response)
                    if (departures.size > 0) {
                        ruterRepository.insertDepartures(departures)
                    }
                    PreferenceHelper.writeDateTime(context, PreferenceHelper.PrefName.RUTER_REALTIME_PREVIOUS_FETCH_TIME, DateTime.now())
                },
                Response.ErrorListener { error ->
                    VolleyLog.e(TAG, "/post request fail! Error: ${error.message}")

                }) {
            @Throws(AuthFailureError::class)
            override fun getHeaders(): Map<String, String> {
                val headers = HashMap<String, String>()
                headers.put("Content-Type", "application/json")
                return headers
            }
        }

        queue.add(jsonObjReq)
    }
}
