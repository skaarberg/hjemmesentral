package com.homecentral.jrs.hjemmesentral.network;

import com.homecentral.jrs.hjemmesentral.model.yr.LongTermWeatherData;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetYrDataService {

    @GET("varsel.xml")
    Call<LongTermWeatherData> getWeatherData();

}
