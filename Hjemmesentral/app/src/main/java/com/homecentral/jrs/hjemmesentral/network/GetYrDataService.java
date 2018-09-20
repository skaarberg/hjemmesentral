package com.homecentral.jrs.hjemmesentral.network;

import com.homecentral.jrs.hjemmesentral.model.yr.WeatherData;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetYrDataService {

    @GET("varsel.xml")
    Call<WeatherData> getWeatherData();

}
