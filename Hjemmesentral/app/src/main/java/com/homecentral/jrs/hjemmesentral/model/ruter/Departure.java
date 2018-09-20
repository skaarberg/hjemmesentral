
package com.homecentral.jrs.hjemmesentral.model.ruter;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "RecordedAtTime",
    "MonitoringRef",
    "MonitoredVehicleJourney",
    "Extensions",
    "StopVisitNote"
})
@Entity(tableName = "departures")
public class Departure {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @JsonProperty("RecordedAtTime")
    private String recordedAtTime;
    @JsonProperty("MonitoringRef")
    private String monitoringRef;
    @JsonProperty("MonitoredVehicleJourney")
    private MonitoredVehicleJourney monitoredVehicleJourney;
    @JsonProperty("Extensions")
    private Extensions extensions;
    @JsonProperty("StopVisitNote")
    private List<StopVisitNote> stopVisitNote = null;

    @JsonProperty("RecordedAtTime")
    public String getRecordedAtTime() {
        return recordedAtTime;
    }

    @JsonProperty("RecordedAtTime")
    public void setRecordedAtTime(String recordedAtTime) {
        this.recordedAtTime = recordedAtTime;
    }

    @JsonProperty("MonitoringRef")
    public String getMonitoringRef() {
        return monitoringRef;
    }

    @JsonProperty("MonitoringRef")
    public void setMonitoringRef(String monitoringRef) {
        this.monitoringRef = monitoringRef;
    }

    @JsonProperty("MonitoredVehicleJourney")
    public MonitoredVehicleJourney getMonitoredVehicleJourney() {
        return monitoredVehicleJourney;
    }

    @JsonProperty("MonitoredVehicleJourney")
    public void setMonitoredVehicleJourney(MonitoredVehicleJourney monitoredVehicleJourney) {
        this.monitoredVehicleJourney = monitoredVehicleJourney;
    }

    @JsonProperty("Extensions")
    public Extensions getExtensions() {
        return extensions;
    }

    @JsonProperty("Extensions")
    public void setExtensions(Extensions extensions) {
        this.extensions = extensions;
    }

    @JsonProperty("StopVisitNote")
    public List<StopVisitNote> getStopVisitNote() {
        return stopVisitNote;
    }

    @JsonProperty("StopVisitNote")
    public void setStopVisitNote(List<StopVisitNote> stopVisitNote) {
        this.stopVisitNote = stopVisitNote;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return monitoredVehicleJourney.getLineRef() + " " + monitoredVehicleJourney.getDestinationName();
    }
}
