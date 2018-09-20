package com.homecentral.jrs.hjemmesentral.model.yr.forecast

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Root

@Root(strict = false, name="precipitation")
data class Precipitation @JvmOverloads constructor(
    @field:Attribute(name = "value") var value: String = ""
)

