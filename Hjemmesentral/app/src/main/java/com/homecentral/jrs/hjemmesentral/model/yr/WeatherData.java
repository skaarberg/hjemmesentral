package com.homecentral.jrs.hjemmesentral.model.yr;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Entity(tableName = "yr_weather_data")
@Root(name = "weatherdata", strict = false)
public class WeatherData {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @Element(name = "links")
    private Links links;

    @Element(name = "meta")
    private Meta meta;

    @Element(name = "forecast")
    private Forecast forecast;

    @Element(name = "observations")
    private Observations observations;

    public WeatherData(){};

    public Integer getId() {
        return id;
    }

    public void setId(Integer iD) {
        this.id = iD;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public Forecast getForecast() {
        return forecast;
    }

    public void setForecast(Forecast forecast) {
        this.forecast = forecast;
    }

    public Observations getObservations() {
        return observations;
    }

    public void setObservations(Observations observations) {
        this.observations = observations;
    }
}
