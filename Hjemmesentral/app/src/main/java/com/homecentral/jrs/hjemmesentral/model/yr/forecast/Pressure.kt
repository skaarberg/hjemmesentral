package com.homecentral.jrs.hjemmesentral.model.yr.forecast

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Root

@Root(name = "pressure", strict = false)
data class Pressure @JvmOverloads constructor(
    @field:Attribute(name = "value") var value: String = "",
    @field:Attribute(name = "unit") var unit: String = ""
)
