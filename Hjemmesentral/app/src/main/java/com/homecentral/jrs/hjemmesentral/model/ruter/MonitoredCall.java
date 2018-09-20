
package com.homecentral.jrs.hjemmesentral.model.ruter;

import android.arch.persistence.room.Entity;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "VisitNumber",
    "VehicleAtStop",
    "DestinationDisplay",
    "AimedArrivalTime",
    "ExpectedArrivalTime",
    "AimedDepartureTime",
    "ExpectedDepartureTime",
    "DeparturePlatformName"
})
@Entity
public class MonitoredCall {

    @JsonProperty("VisitNumber")
    private Integer visitNumber;
    @JsonProperty("VehicleAtStop")
    private Boolean vehicleAtStop;
    @JsonProperty("DestinationDisplay")
    private String destinationDisplay;
    @JsonProperty("AimedArrivalTime")
    private String aimedArrivalTime;
    @JsonProperty("ExpectedArrivalTime")
    private String expectedArrivalTime;
    @JsonProperty("AimedDepartureTime")
    private String aimedDepartureTime;
    @JsonProperty("ExpectedDepartureTime")
    private String expectedDepartureTime;
    @JsonProperty("DeparturePlatformName")
    private String departurePlatformName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("VisitNumber")
    public Integer getVisitNumber() {
        return visitNumber;
    }

    @JsonProperty("VisitNumber")
    public void setVisitNumber(Integer visitNumber) {
        this.visitNumber = visitNumber;
    }

    @JsonProperty("VehicleAtStop")
    public Boolean getVehicleAtStop() {
        return vehicleAtStop;
    }

    @JsonProperty("VehicleAtStop")
    public void setVehicleAtStop(Boolean vehicleAtStop) {
        this.vehicleAtStop = vehicleAtStop;
    }

    @JsonProperty("DestinationDisplay")
    public String getDestinationDisplay() {
        return destinationDisplay;
    }

    @JsonProperty("DestinationDisplay")
    public void setDestinationDisplay(String destinationDisplay) {
        this.destinationDisplay = destinationDisplay;
    }

    @JsonProperty("AimedArrivalTime")
    public String getAimedArrivalTime() {
        return aimedArrivalTime;
    }

    @JsonProperty("AimedArrivalTime")
    public void setAimedArrivalTime(String aimedArrivalTime) {
        this.aimedArrivalTime = aimedArrivalTime;
    }

    @JsonProperty("ExpectedArrivalTime")
    public String getExpectedArrivalTime() {
        return expectedArrivalTime;
    }

    @JsonProperty("ExpectedArrivalTime")
    public void setExpectedArrivalTime(String expectedArrivalTime) {
        this.expectedArrivalTime = expectedArrivalTime;
    }

    @JsonProperty("AimedDepartureTime")
    public String getAimedDepartureTime() {
        return aimedDepartureTime;
    }

    @JsonProperty("AimedDepartureTime")
    public void setAimedDepartureTime(String aimedDepartureTime) {
        this.aimedDepartureTime = aimedDepartureTime;
    }

    @JsonProperty("ExpectedDepartureTime")
    public String getExpectedDepartureTime() {
        return expectedDepartureTime;
    }

    @JsonProperty("ExpectedDepartureTime")
    public void setExpectedDepartureTime(String expectedDepartureTime) {
        this.expectedDepartureTime = expectedDepartureTime;
    }

    @JsonProperty("DeparturePlatformName")
    public String getDeparturePlatformName() {
        return departurePlatformName;
    }

    @JsonProperty("DeparturePlatformName")
    public void setDeparturePlatformName(String departurePlatformName) {
        this.departurePlatformName = departurePlatformName;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
