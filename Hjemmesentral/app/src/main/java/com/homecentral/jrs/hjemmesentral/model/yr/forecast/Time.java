package com.homecentral.jrs.hjemmesentral.model.yr.forecast;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;


@Root(name = "time", strict = false)
public class Time {

    @Attribute(name = "from")
    private String from;

    @Attribute(name = "to")
    private String to;

    @Attribute(name = "period")
    private String period;

    @Element(name = "symbol", required = false)
    private Symbol symbol;

    @Element(name = "precipitation", required = false)
    private Precipitation precipitation;

    @Element(name = "windDirection", required = false)
    private WindDirection windDirection;

    @Element(name = "windSpeed", required = false)
    private WindSpeed windSpeed;

    @Element(name = "temperature", required = false)
    private Temperature temperature;

    @Element(name = "pressure", required = false)
    private Pressure pressure;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public Precipitation getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(Precipitation precipitation) {
        this.precipitation = precipitation;
    }

    public WindDirection getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(WindDirection windDirection) {
        this.windDirection = windDirection;
    }

    public WindSpeed getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(WindSpeed windSpeed) {
        this.windSpeed = windSpeed;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }

    public Pressure getPressure() {
        return pressure;
    }

    public void setPressure(Pressure pressure) {
        this.pressure = pressure;
    }
}
