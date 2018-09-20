
package com.homecentral.jrs.hjemmesentral.model.ruter;

import android.arch.persistence.room.Entity;

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
    "IsHub",
    "OccupancyData",
    "Deviations",
    "LineColour",
    "DepartureNamePreMapping"
})
@Entity
public class Extensions {

    @JsonProperty("IsHub")
    private Boolean isHub;
    @JsonProperty("OccupancyData")
    private OccupancyData occupancyData;
    @JsonProperty("Deviations")
    private List<Deviation> deviations = null;
    @JsonProperty("LineColour")
    private String lineColour;
    @JsonProperty("DepartureNamePreMapping")
    private String departureNamePreMapping;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("IsHub")
    public Boolean getIsHub() {
        return isHub;
    }

    @JsonProperty("IsHub")
    public void setIsHub(Boolean isHub) {
        this.isHub = isHub;
    }

    @JsonProperty("OccupancyData")
    public OccupancyData getOccupancyData() {
        return occupancyData;
    }

    @JsonProperty("OccupancyData")
    public void setOccupancyData(OccupancyData occupancyData) {
        this.occupancyData = occupancyData;
    }

    @JsonProperty("Deviations")
    public List<Deviation> getDeviations() {
        return deviations;
    }

    @JsonProperty("Deviations")
    public void setDeviations(List<Deviation> deviations) {
        this.deviations = deviations;
    }

    @JsonProperty("LineColour")
    public String getLineColour() {
        return lineColour;
    }

    @JsonProperty("LineColour")
    public void setLineColour(String lineColour) {
        this.lineColour = lineColour;
    }

    @JsonProperty("DepartureNamePreMapping")
    public String getDepartureNamePreMapping() {
        return departureNamePreMapping;
    }

    @JsonProperty("DepartureNamePreMapping")
    public void setDepartureNamePreMapping(String departureNamePreMapping) {
        this.departureNamePreMapping = departureNamePreMapping;
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
