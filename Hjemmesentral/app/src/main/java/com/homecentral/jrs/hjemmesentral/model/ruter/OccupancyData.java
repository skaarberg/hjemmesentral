
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
    "OccupancyAvailable",
    "OccupancyPercentage"
})
@Entity
public class OccupancyData {

    @JsonProperty("OccupancyAvailable")
    private Boolean occupancyAvailable;
    @JsonProperty("OccupancyPercentage")
    private Integer occupancyPercentage;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("OccupancyAvailable")
    public Boolean getOccupancyAvailable() {
        return occupancyAvailable;
    }

    @JsonProperty("OccupancyAvailable")
    public void setOccupancyAvailable(Boolean occupancyAvailable) {
        this.occupancyAvailable = occupancyAvailable;
    }

    @JsonProperty("OccupancyPercentage")
    public Integer getOccupancyPercentage() {
        return occupancyPercentage;
    }

    @JsonProperty("OccupancyPercentage")
    public void setOccupancyPercentage(Integer occupancyPercentage) {
        this.occupancyPercentage = occupancyPercentage;
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
