package com.homecentral.jrs.hjemmesentral.model.yr.forecast;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

@Root(name = "windSpeed", strict = false)
public class WindSpeed {

    @Attribute(name="mps", required = false)
    String mps;

    @Attribute(name="name", required = false)
    String name;

    public String getMps() {
        return mps;
    }

    public void setMps(String mps) {
        this.mps = mps;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
