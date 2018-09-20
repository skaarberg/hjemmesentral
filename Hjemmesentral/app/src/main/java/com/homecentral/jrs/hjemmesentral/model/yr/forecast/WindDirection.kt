package com.homecentral.jrs.hjemmesentral.model.yr.forecast

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Root

@Root(name = "windDirection", strict = false)
data class WindDirection @JvmOverloads constructor(
    @field:Attribute(name = "deg") var deg: String = "",
    @field:Attribute(name = "code") var code: String = "",
    @field:Attribute(name = "name") var name: String = ""
)