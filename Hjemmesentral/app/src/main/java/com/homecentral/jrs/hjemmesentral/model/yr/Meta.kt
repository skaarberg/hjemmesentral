package com.homecentral.jrs.hjemmesentral.model.yr

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "meta", strict = false)
class Meta @JvmOverloads constructor(
    @field:Element(name = "lastupdate") private var lastUpdate: String = "",
    @field:Element(name = "nextupdate") private var nextUpdate: String = ""
)
