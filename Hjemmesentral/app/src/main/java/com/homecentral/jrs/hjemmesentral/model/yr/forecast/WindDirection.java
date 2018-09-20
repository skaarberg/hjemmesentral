package com.homecentral.jrs.hjemmesentral.model.yr.forecast;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

@Root(name = "windDirection", strict = false)
public class WindDirection {

    @Attribute(name="deg", required = false)
    String deg;

    @Attribute(name="code", required = false)
    String code;

    @Attribute(name="name", required = false)
    String name;

    public String getDeg() {
        return deg;
    }

    public void setDeg(String deg) {
        this.deg = deg;
    }
}
