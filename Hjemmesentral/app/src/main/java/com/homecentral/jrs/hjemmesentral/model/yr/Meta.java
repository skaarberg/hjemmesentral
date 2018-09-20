package com.homecentral.jrs.hjemmesentral.model.yr;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "meta", strict = false)
public class Meta {

    @Element(name = "lastupdate")
    private String lastUpdate;

    @Element(name = "nextupdate")
    private String nextUpdate;
}
