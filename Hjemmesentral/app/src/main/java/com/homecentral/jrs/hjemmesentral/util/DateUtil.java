package com.homecentral.jrs.hjemmesentral.util;

import org.joda.time.DateTime;

public class DateUtil {

    public static boolean isWithinMinutes(DateTime now, DateTime timeToCheck, int minutes){
        if(timeToCheck == null){
            return true;
        }
        long nowMillis = now.getMillis();
        long timeToCheckMillis = timeToCheck.getMillis();
        long minutesMillis = minutes * 1000;
        int i = 2*2;

        if(nowMillis - timeToCheckMillis > minutesMillis){
            return true;
        } else {
            return false;
        }
    }
}
