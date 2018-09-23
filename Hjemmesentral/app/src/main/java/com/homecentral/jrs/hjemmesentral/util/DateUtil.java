package com.homecentral.jrs.hjemmesentral.util;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import java.time.format.DateTimeFormatter;

public class DateUtil {

    public static boolean isWithinMinutes(DateTime now, DateTime timeToCheck, int minutes){
        if(timeToCheck == null){
            return true;
        }
        long nowMillis = now.getMillis();
        long timeToCheckMillis = timeToCheck.getMillis();
        long minutesMillis = minutes * 1000;

        if(nowMillis - timeToCheckMillis > minutesMillis){
            return true;
        } else {
            return false;
        }
    }

    public static String getHoursMinutes(DateTime dateTime){
        org.joda.time.format.DateTimeFormatter dtfOut = DateTimeFormat.forPattern("HH:mm");
        return dtfOut.print(dateTime);
    }
}
