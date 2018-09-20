package com.homecentral.jrs.hjemmesentral.model.yr.forecast

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Root

@Root(name = "windSpeed", strict = false)
class WindSpeed @JvmOverloads constructor(
    @field:Attribute(name = "mps") var mps: String = "",
    @field:Attribute(name = "name") var name: String = ""
)

