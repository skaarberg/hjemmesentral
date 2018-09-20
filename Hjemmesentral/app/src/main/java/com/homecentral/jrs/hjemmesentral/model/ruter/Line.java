
package com.homecentral.jrs.hjemmesentral.model.ruter;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Stop",
    "ID",
    "Name",
    "Transportation",
    "LineColour"
})
@Entity(tableName = "lines")
public class Line {

    @JsonProperty("Stop")
    private List<Stop> stops = null;
    @JsonProperty("ID")
    @PrimaryKey
    private Integer iD;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("Transportation")
    private Integer transportation;
    @JsonProperty("LineColour")
    private String lineColour;

    @JsonProperty("Stops")
    public List<Stop> getStops() {
        return stops;
    }

    @JsonProperty("Stops")
    public void setStops(List<Stop> stops) {
        this.stops = stops;
    }

    @JsonProperty("ID")
    public Integer getID() {
        return iD;
    }

    @JsonProperty("ID")
    public void setID(Integer iD) {
        this.iD = iD;
    }

    @JsonProperty("Name")
    public String getName() {
        return name;
    }

    @JsonProperty("Name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("Transportation")
    public Integer getTransportation() {
        return transportation;
    }

    @JsonProperty("Transportation")
    public void setTransportation(Integer transportation) {
        this.transportation = transportation;
    }

    @JsonProperty("LineColour")
    public String getLineColour() {
        return lineColour;
    }

    @JsonProperty("LineColour")
    public void setLineColour(String lineColour) {
        this.lineColour = lineColour;
    }

    @Override
    public boolean equals(Object obj) {
        Line line = (Line)obj;
        if(line.getName().equals(name)){
            return true;
        }
        return false;
    }
}
