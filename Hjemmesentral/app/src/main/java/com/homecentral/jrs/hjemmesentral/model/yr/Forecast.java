package com.homecentral.jrs.hjemmesentral.model.yr;

import com.homecentral.jrs.hjemmesentral.model.yr.forecast.Time;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "forecast", strict = false)
public class Forecast {

    @ElementList(name="tabular")
    private List<Time> tabular;

    public List<Time> getTabular() {
        return tabular;
    }

    public void setTabular(List<Time> tabular) {
        this.tabular = tabular;
    }
}
