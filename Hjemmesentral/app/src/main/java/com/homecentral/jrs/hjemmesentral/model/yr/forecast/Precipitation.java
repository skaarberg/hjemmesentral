package com.homecentral.jrs.hjemmesentral.model.yr.forecast;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

@Root(name = "precipitation", strict = false)
public class Precipitation {

    @Attribute(name="value", required = false)
    String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
