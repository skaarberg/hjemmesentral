package com.homecentral.jrs.hjemmesentral.model.yr.forecast;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

@Root(name = "symbol", strict = false)
public class Symbol {

    @Attribute(name="name", required = false)
    String name;

    @Attribute(name="var", required = false)
    String var;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVar() {
        return var;
    }

    public void setVar(String var) {
        this.var = var;
    }
}
