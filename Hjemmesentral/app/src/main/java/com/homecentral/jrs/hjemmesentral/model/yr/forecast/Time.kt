package com.homecentral.jrs.hjemmesentral.model.yr.forecast

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "time", strict = false)
class Time @JvmOverloads constructor(
    @field:Attribute(name = "from") var from: String = "",
    @field:Attribute(name = "to") var to: String = "",
    @field:Attribute(name = "period") var period: String = "",
    @field:Element(name = "symbol", required = false) var symbol: Symbol? = null,
    @field:Element(name = "precipitation", required = false) var precipitation: Precipitation? = null,
    @field:Element(name = "windDirection", required = false) var windDirection: WindDirection? = null,
    @field:Element(name = "windSpeed", required = false) var windSpeed: WindSpeed? = null,
    @field:Element(name = "temperature", required = false) var temperature: Temperature? = null,
    @field:Element(name = "pressure", required = false) var pressure: Pressure? = null
)
