
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
    "LineRef",
    "DirectionRef",
    "FramedVehicleJourneyRef",
    "PublishedLineName",
    "DirectionName",
    "OperatorRef",
    "OriginName",
    "OriginRef",
    "DestinationRef",
    "DestinationName",
    "OriginAimedDepartureTime",
    "DestinationAimedArrivalTime",
    "Monitored",
    "InCongestion",
    "Delay",
    "TrainBlockPart",
    "BlockRef",
    "VehicleRef",
    "VehicleMode",
    "VehicleJourneyName",
    "MonitoredCall",
    "VehicleFeatureRef"
})
@Entity
public class MonitoredVehicleJourney {

    @JsonProperty("LineRef")
    private String lineRef;
    @JsonProperty("DirectionRef")
    private String directionRef;
    @JsonProperty("FramedVehicleJourneyRef")
    private FramedVehicleJourneyRef framedVehicleJourneyRef;
    @JsonProperty("PublishedLineName")
    private String publishedLineName;
    @JsonProperty("DirectionName")
    private String directionName;
    @JsonProperty("OperatorRef")
    private String operatorRef;
    @JsonProperty("OriginName")
    private String originName;
    @JsonProperty("OriginRef")
    private String originRef;
    @JsonProperty("DestinationRef")
    private String destinationRef;
    @JsonProperty("DestinationName")
    private String destinationName;
    @JsonProperty("OriginAimedDepartureTime")
    private String originAimedDepartureTime;
    @JsonProperty("DestinationAimedArrivalTime")
    private String destinationAimedArrivalTime;
    @JsonProperty("Monitored")
    private Boolean monitored;
    @JsonProperty("InCongestion")
    private Boolean inCongestion;
    @JsonProperty("Delay")
    private String delay;
    @JsonProperty("TrainBlockPart")
    private Object trainBlockPart;
    @JsonProperty("BlockRef")
    private String blockRef;
    @JsonProperty("VehicleRef")
    private String vehicleRef;
    @JsonProperty("VehicleMode")
    private Integer vehicleMode;
    @JsonProperty("VehicleJourneyName")
    private String vehicleJourneyName;
    @JsonProperty("MonitoredCall")
    private MonitoredCall monitoredCall;
    @JsonProperty("VehicleFeatureRef")
    private String vehicleFeatureRef;

    @JsonProperty("LineRef")
    public String getLineRef() {
        return lineRef;
    }

    @JsonProperty("LineRef")
    public void setLineRef(String lineRef) {
        this.lineRef = lineRef;
    }

    @JsonProperty("DirectionRef")
    public String getDirectionRef() {
        return directionRef;
    }

    @JsonProperty("DirectionRef")
    public void setDirectionRef(String directionRef) {
        this.directionRef = directionRef;
    }

    @JsonProperty("FramedVehicleJourneyRef")
    public FramedVehicleJourneyRef getFramedVehicleJourneyRef() {
        return framedVehicleJourneyRef;
    }

    @JsonProperty("FramedVehicleJourneyRef")
    public void setFramedVehicleJourneyRef(FramedVehicleJourneyRef framedVehicleJourneyRef) {
        this.framedVehicleJourneyRef = framedVehicleJourneyRef;
    }

    @JsonProperty("PublishedLineName")
    public String getPublishedLineName() {
        return publishedLineName;
    }

    @JsonProperty("PublishedLineName")
    public void setPublishedLineName(String publishedLineName) {
        this.publishedLineName = publishedLineName;
    }

    @JsonProperty("DirectionName")
    public String getDirectionName() {
        return directionName;
    }

    @JsonProperty("DirectionName")
    public void setDirectionName(String directionName) {
        this.directionName = directionName;
    }

    @JsonProperty("OperatorRef")
    public String getOperatorRef() {
        return operatorRef;
    }

    @JsonProperty("OperatorRef")
    public void setOperatorRef(String operatorRef) {
        this.operatorRef = operatorRef;
    }

    @JsonProperty("OriginName")
    public String getOriginName() {
        return originName;
    }

    @JsonProperty("OriginName")
    public void setOriginName(String originName) {
        this.originName = originName;
    }

    @JsonProperty("OriginRef")
    public String getOriginRef() {
        return originRef;
    }

    @JsonProperty("OriginRef")
    public void setOriginRef(String originRef) {
        this.originRef = originRef;
    }

    @JsonProperty("DestinationRef")
    public String getDestinationRef() {
        return destinationRef;
    }

    @JsonProperty("DestinationRef")
    public void setDestinationRef(String destinationRef) {
        this.destinationRef = destinationRef;
    }

    @JsonProperty("DestinationName")
    public String getDestinationName() {
        return destinationName;
    }

    @JsonProperty("DestinationName")
    public void setDestinationName(String destinationName) {
        this.destinationName = destinationName;
    }

    @JsonProperty("OriginAimedDepartureTime")
    public String getOriginAimedDepartureTime() {
        return originAimedDepartureTime;
    }

    @JsonProperty("OriginAimedDepartureTime")
    public void setOriginAimedDepartureTime(String originAimedDepartureTime) {
        this.originAimedDepartureTime = originAimedDepartureTime;
    }

    @JsonProperty("DestinationAimedArrivalTime")
    public String getDestinationAimedArrivalTime() {
        return destinationAimedArrivalTime;
    }

    @JsonProperty("DestinationAimedArrivalTime")
    public void setDestinationAimedArrivalTime(String destinationAimedArrivalTime) {
        this.destinationAimedArrivalTime = destinationAimedArrivalTime;
    }

    @JsonProperty("Monitored")
    public Boolean getMonitored() {
        return monitored;
    }

    @JsonProperty("Monitored")
    public void setMonitored(Boolean monitored) {
        this.monitored = monitored;
    }

    @JsonProperty("InCongestion")
    public Boolean getInCongestion() {
        return inCongestion;
    }

    @JsonProperty("InCongestion")
    public void setInCongestion(Boolean inCongestion) {
        this.inCongestion = inCongestion;
    }

    @JsonProperty("Delay")
    public String getDelay() {
        return delay;
    }

    @JsonProperty("Delay")
    public void setDelay(String delay) {
        this.delay = delay;
    }

    @JsonProperty("TrainBlockPart")
    public Object getTrainBlockPart() {
        return trainBlockPart;
    }

    @JsonProperty("TrainBlockPart")
    public void setTrainBlockPart(Object trainBlockPart) {
        this.trainBlockPart = trainBlockPart;
    }

    @JsonProperty("BlockRef")
    public String getBlockRef() {
        return blockRef;
    }

    @JsonProperty("BlockRef")
    public void setBlockRef(String blockRef) {
        this.blockRef = blockRef;
    }

    @JsonProperty("VehicleRef")
    public String getVehicleRef() {
        return vehicleRef;
    }

    @JsonProperty("VehicleRef")
    public void setVehicleRef(String vehicleRef) {
        this.vehicleRef = vehicleRef;
    }

    @JsonProperty("VehicleMode")
    public Integer getVehicleMode() {
        return vehicleMode;
    }

    @JsonProperty("VehicleMode")
    public void setVehicleMode(Integer vehicleMode) {
        this.vehicleMode = vehicleMode;
    }

    @JsonProperty("VehicleJourneyName")
    public String getVehicleJourneyName() {
        return vehicleJourneyName;
    }

    @JsonProperty("VehicleJourneyName")
    public void setVehicleJourneyName(String vehicleJourneyName) {
        this.vehicleJourneyName = vehicleJourneyName;
    }

    @JsonProperty("MonitoredCall")
    public MonitoredCall getMonitoredCall() {
        return monitoredCall;
    }

    @JsonProperty("MonitoredCall")
    public void setMonitoredCall(MonitoredCall monitoredCall) {
        this.monitoredCall = monitoredCall;
    }

    @JsonProperty("VehicleFeatureRef")
    public String getVehicleFeatureRef() {
        return vehicleFeatureRef;
    }

    @JsonProperty("VehicleFeatureRef")
    public void setVehicleFeatureRef(String vehicleFeatureRef) {
        this.vehicleFeatureRef = vehicleFeatureRef;
    }
}
