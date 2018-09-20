package com.homecentral.jrs.hjemmesentral.util;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.content.Context;
import android.support.annotation.Nullable;

import com.homecentral.jrs.hjemmesentral.database.RuterRepository;
import com.homecentral.jrs.hjemmesentral.model.ruter.Departure;
import com.homecentral.jrs.hjemmesentral.model.ruter.Line;
import com.homecentral.jrs.hjemmesentral.model.ruter.LineDepartures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DepartureUtil {

    public enum DepartureDirection{
        FIRST(1),
        SECOND(2);

        private final int mDirection;

        DepartureDirection(int departureDirection) {
            mDirection = departureDirection;
        }

        public int getDirection() {
            return mDirection;
        }

        public static DepartureDirection newInstance(int direction) {
            for (DepartureDirection departureDirection : DepartureDirection.values()) {
                if (departureDirection.getDirection() == direction) {
                    return departureDirection;
                }
            }
            return DepartureDirection.FIRST;
        }
    }

    public static HashMap<String, String> getAvailableLinesForDepartures(List<Departure> departures){
        HashMap<String, String> lines = new HashMap<>();
        for (Departure departure : departures) {
            String name = departure.getMonitoredVehicleJourney().getLineRef() + " " + departure.getMonitoredVehicleJourney().getDestinationName();
            if(!lines.containsKey(name)){
                lines.put(name, departure.getMonitoredVehicleJourney().getLineRef());
            }
        }

        return lines;
    }

    public static List<LineDepartures> getLineDepartures(List<Departure> departures){
        if(departures.size() > 0) {
            HashMap<String, String> lines = getAvailableLinesForDepartures(departures);
            List<LineDepartures> lineDepartures = new ArrayList<>();
            for (String lineName : lines.keySet()) {
                lineDepartures.add(new LineDepartures(lines.get(lineName), lineName));
            }

            Collections.sort(lineDepartures);

            for (LineDepartures departure : lineDepartures) {
                getDeparturesForLine(departure, departures);
            }
            return lineDepartures;
        }
        return null;
    }

    public static LineDepartures getDeparturesForLine(LineDepartures lineDepartures, List<Departure> departures){
        for (Departure departure : departures) {
            if(lineDepartures.getName().equals(departure.toString())){
                lineDepartures.addDeparture(departure);
            }
        }
        return lineDepartures;
    }

    public static List<Line> getLocalLines(Context context, List<Departure> departures, List<Line> lines){
        if(departures == null || lines == null || departures.size() == 0 || lines.size() == 0){
            return null;
        }
        final List<Line> localLines = new ArrayList<>();

        RuterRepository mRepository = new RuterRepository(context);


        for (LineDepartures departure : getLineDepartures(departures)) {
            mRepository.getLine(departure.getLine()).observe((LifecycleOwner)context, new Observer<Line>() {
                @Override
                public void onChanged(@Nullable Line line) {
                    localLines.add(line);
                }
            });
        }
        return localLines;
    }
}
