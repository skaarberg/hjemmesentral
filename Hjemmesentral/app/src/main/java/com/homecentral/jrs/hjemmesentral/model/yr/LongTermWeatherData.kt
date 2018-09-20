package com.homecentral.jrs.hjemmesentral.model.yr

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import org.simpleframework.xml.Attribute

import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Entity(tableName = "yr_long_term_weather_data")
@Root(name = "weatherdata", strict = false)
data class LongTermWeatherData @JvmOverloads constructor(

    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    @field:ElementList(name = "links") var links: List<Link>? = null,
    @field:Element(name = "meta") var meta: Meta? = null,
    @field:Element(name = "forecast") var forecast: Forecast? = null
)

