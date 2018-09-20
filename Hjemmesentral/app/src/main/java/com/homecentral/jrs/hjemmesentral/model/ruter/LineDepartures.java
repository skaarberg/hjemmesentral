package com.homecentral.jrs.hjemmesentral.model.ruter;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class LineDepartures implements Comparable<LineDepartures> {

    private String mLine;
    private String mName;
    private List<Deviation> mDeviations;
    private List<Departure> mDepartures;

    public LineDepartures(String line, String name){
        mLine = line;
        mName = name;
        mDepartures = new ArrayList<>();
        mDeviations = new ArrayList<>();
    }

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public List<Departure> getDepartures() {
        return mDepartures;
    }

    public void setDepartures(List<Departure> mDepartures) {
        this.mDepartures = mDepartures;
    }

    public void addDeparture(Departure departure){
        mDepartures.add(departure);
        if(departure.getExtensions().getDeviations().size() > 0) {
            for (final Deviation deviation : departure.getExtensions().getDeviations()) {

                if(!mDeviations.stream().anyMatch(t -> t.getID().equals(deviation.getID()))){
                    mDeviations.add(deviation);
                }
            }
        }
    }

    public String getLine() {
        return mLine;
    }

    public void setLine(String mLine) {
        this.mLine = mLine;
    }

    public List<Deviation> getDeviations() {
        return mDeviations;
    }

    public void setDeviations(List<Deviation> deviations) {
        this.mDeviations = deviations;
    }

    public boolean hasDeviations(){
        return mDeviations != null && mDeviations.size() > 0;
    }

    @Override
    public int compareTo(@NonNull LineDepartures o) {
        if (Integer.parseInt(mLine) > Integer.parseInt(o.getLine())) {
            return 1;
        }
        else if (Integer.parseInt(mLine) < Integer.parseInt(o.getLine())) {
            return -1;
        }
        else {
            return 0;
        }
    }
}
