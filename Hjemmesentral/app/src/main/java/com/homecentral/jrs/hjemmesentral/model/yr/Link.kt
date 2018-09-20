package com.homecentral.jrs.hjemmesentral.model.yr

import org.simpleframework.xml.Attribute

data class Link @JvmOverloads constructor(
    @field:Attribute(name = "id") var id: String = "",
    @field:Attribute(name = "url") var url: String = ""
)
