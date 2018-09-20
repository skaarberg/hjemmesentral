package com.homecentral.jrs.hjemmesentral.model.yr.forecast

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Root

@Root(name = "symbol", strict = false)
data class Symbol @JvmOverloads constructor(
    @field:Attribute(name = "name") var name: String = "",
    @field:Attribute(name = "var") var `var`: String = ""
)
