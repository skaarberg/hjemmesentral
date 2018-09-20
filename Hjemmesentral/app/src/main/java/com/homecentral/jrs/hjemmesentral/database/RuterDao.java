package com.homecentral.jrs.hjemmesentral.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.homecentral.jrs.hjemmesentral.model.ruter.Departure;
import com.homecentral.jrs.hjemmesentral.model.ruter.Line;
import com.homecentral.jrs.hjemmesentral.model.ruter.LineDepartures;

import java.util.List;

@Dao
public interface RuterDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertLines(List<Line> lines);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertDepartures(List<Departure> departures);

    @Query("DELETE FROM departures")
    void deleteAllDepartures();

    @Query("SELECT * FROM lines")
    LiveData<List<Line>> getLines();

    @Query("SELECT * FROM lines WHERE lines.name LIKE :name")
    LiveData<Line> getLineForName(String name);

    @Query("SELECT * FROM departures")
    LiveData<List<Departure>> getDepartures();
/*
    @Query("SELECT * FROM departures where departures.monitoredVehicleJourney")
    LiveData<List<Departure>> getDeparturesForLine(String line);
    */
}