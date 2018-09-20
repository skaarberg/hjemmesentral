package com.homecentral.jrs.hjemmesentral.model.yr

import com.homecentral.jrs.hjemmesentral.model.yr.forecast.Time
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Root(name = "forecast", strict = false)
class Forecast @JvmOverloads constructor(
    @field:ElementList(name = "tabular") var tabular: List<Time>? = null
)