
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
    "DataFrameRef",
    "DatedVehicleJourneyRef"
})
@Entity
public class FramedVehicleJourneyRef {

    @JsonProperty("DataFrameRef")
    private String dataFrameRef;
    @JsonProperty("DatedVehicleJourneyRef")
    private String datedVehicleJourneyRef;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("DataFrameRef")
    public String getDataFrameRef() {
        return dataFrameRef;
    }

    @JsonProperty("DataFrameRef")
    public void setDataFrameRef(String dataFrameRef) {
        this.dataFrameRef = dataFrameRef;
    }

    @JsonProperty("DatedVehicleJourneyRef")
    public String getDatedVehicleJourneyRef() {
        return datedVehicleJourneyRef;
    }

    @JsonProperty("DatedVehicleJourneyRef")
    public void setDatedVehicleJourneyRef(String datedVehicleJourneyRef) {
        this.datedVehicleJourneyRef = datedVehicleJourneyRef;
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
