package com.homecentral.jrs.hjemmesentral.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.homecentral.jrs.hjemmesentral.database.RuterRepository;
import com.homecentral.jrs.hjemmesentral.model.ruter.Departure;
import com.homecentral.jrs.hjemmesentral.model.ruter.Line;
import com.homecentral.jrs.hjemmesentral.model.ruter.LineDepartures;

import java.util.List;

public class RuterViewModel extends AndroidViewModel {

    private RuterRepository mRepository;

    private LiveData<List<Line>> mLines;
    private LiveData<List<Departure>> mDepartures;

    public RuterViewModel (Application application) {
        super(application);
        mRepository = new RuterRepository(application);
        mLines = mRepository.getLines();
        mDepartures = mRepository.getDepartures();
    }

    public LiveData<List<Line>> getLines() {
        return mLines;
    }

    public LiveData<List<Departure>> getDepartures() { return mDepartures; }
}
