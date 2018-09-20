package com.homecentral.jrs.hjemmesentral.util;

import android.content.Context;

import com.homecentral.jrs.hjemmesentral.R;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;

public class TextUtil {
    public static String getCountdownText(Context context, String time, boolean confirmed){
        DateTime dateTime = new DateTime(time, DateTimeZone.getDefault());
        int minutes = (int) ((dateTime.getMillis() - DateTime.now().getMillis()) / 60000);
        if(!confirmed || minutes > 15){
            return DateTimeFormat.forPattern("HH:mm").print(dateTime);
        }
        else {
            if (minutes > 0) {
                return context.getString(R.string.departure_time_minutes, minutes);
            }
            else {
                return context.getString(R.string.departure_time_now);
            }
        }
    }
}
