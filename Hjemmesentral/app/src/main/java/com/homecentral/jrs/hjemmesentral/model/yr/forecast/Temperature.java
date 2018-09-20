package com.homecentral.jrs.hjemmesentral.model.yr.forecast;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

@Root(name = "temperature", strict = false)
public class Temperature {

    @Attribute(name="unit", required = false)
    String unit;

    @Attribute(name="value", required = false)
    String value;

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
