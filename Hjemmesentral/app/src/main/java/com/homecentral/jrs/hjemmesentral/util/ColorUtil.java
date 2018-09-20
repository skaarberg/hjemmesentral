package com.homecentral.jrs.hjemmesentral.util;

import android.content.Context;
import android.graphics.Color;

import com.homecentral.jrs.hjemmesentral.R;
import com.homecentral.jrs.hjemmesentral.model.ruter.Departure;

public class ColorUtil {

    public static int getColorForLine(Departure departure) {
        return Color.parseColor("#" + departure.getExtensions().getLineColour());
    }

    public static int getColorForDeparture(Context context, Departure departure){
        if(!departure.getMonitoredVehicleJourney().getMonitored()
                || !departure.getExtensions().getOccupancyData().getOccupancyAvailable()){
            return context.getColor(R.color.colorTextBlack);
        }
        int occupancyPercentage = departure.getExtensions().getOccupancyData().getOccupancyPercentage();
        if(occupancyPercentage < 20){
            return context.getColor(R.color.colorTextGreen);
        }
        else if(occupancyPercentage > 20 && occupancyPercentage < 50){
            return context.getColor(R.color.colorTextYellow);
        }
        else {
            return context.getColor(R.color.colorTextRed);
        }
    }
}
