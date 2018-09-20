package com.homecentral.jrs.hjemmesentral.network.ruter;

import android.content.Context;
import android.util.Log;

import com.homecentral.jrs.hjemmesentral.database.RuterRepository;
import com.homecentral.jrs.hjemmesentral.model.ruter.Departure;
import com.homecentral.jrs.hjemmesentral.model.ruter.Line;
import com.homecentral.jrs.hjemmesentral.scheduler.HomeCentralWorkManager;
import com.homecentral.jrs.hjemmesentral.util.PreferenceHelper;

import org.joda.time.DateTime;

import java.io.IOException;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class RuterUtil {

    private static String LINES_URL = "https://reisapi.ruter.no/line/GetLinesRuterExtended";

    public static boolean fetchLines(Context context){
        try {
            List<Line> lines = RuterParser.parseBaseData(getContentFromUrl(LINES_URL));
            RuterRepository ruterRepository = new RuterRepository(context);
            if (lines.size() > 0) {
                ruterRepository.insertLines(lines);
            }
            PreferenceHelper.writeDateTime(context, PreferenceHelper.PrefName.RUTER_BASE_DATA_PREVIOUS_FETCH_TIME, DateTime.now());
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static String REALTIME_BASE_URL = "http://reisapi.ruter.no/stopvisit/getdepartures/";
    private static int STOP_ID_STROEMSVEIEN = 3010641;
    private static int STOP_ID_JORDAL = 3010640;

    public static boolean fetchRealTimeData(final Context context){
        try{
            Log.d("RuterUtil", "started sync");
            final RuterRepository ruterRepository = new RuterRepository(context);

            List<Departure> departures = RuterParser.parseRealtimeData(getContentFromUrl(REALTIME_BASE_URL + STOP_ID_STROEMSVEIEN));
            departures.addAll(RuterParser.parseRealtimeData(getContentFromUrl(REALTIME_BASE_URL + STOP_ID_JORDAL)));
            if (departures.size() > 0) {
                ruterRepository.insertDepartures(departures);
            }

            PreferenceHelper.writeDateTime(context, PreferenceHelper.PrefName.RUTER_REALTIME_PREVIOUS_FETCH_TIME, DateTime.now());
            HomeCentralWorkManager.scheduleSyncDepartures(context, true);
            Log.d("RuterUtil", "sync completed");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void deleteDepartures(Context context){
        final RuterRepository ruterRepository = new RuterRepository(context);
        ruterRepository.deleteDepartures();
    }

    private static String getContentFromUrl(String url) throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(url)
                .get()
                .addHeader("content-type", "application/json")
                .build();

        Response response = client.newCall(request).execute();
        if (response.body() != null) {
            return response.body().string();
        }
        return null;
    }
}
