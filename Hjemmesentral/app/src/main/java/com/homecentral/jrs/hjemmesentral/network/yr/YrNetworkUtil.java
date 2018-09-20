package com.homecentral.jrs.hjemmesentral.network.yr;

import android.content.Context;

import com.homecentral.jrs.hjemmesentral.database.YrRepository;
import com.homecentral.jrs.hjemmesentral.model.yr.LongTermWeatherData;
import com.homecentral.jrs.hjemmesentral.network.APIClient;
import com.homecentral.jrs.hjemmesentral.network.GetYrDataService;
import com.homecentral.jrs.hjemmesentral.util.PreferenceHelper;

import org.joda.time.DateTime;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class YrNetworkUtil {

    public static void fetchYrData(final Context context) {

        GetYrDataService service = APIClient.getClient().create(GetYrDataService.class);
        Call<LongTermWeatherData> call = service.getWeatherData();
        call.enqueue(new Callback<LongTermWeatherData>() {
                         @Override
                         public void onResponse(Call<LongTermWeatherData> call, Response<LongTermWeatherData> response) {
                             YrRepository yrRepository = new YrRepository(context);
                             yrRepository.insert(response.body());
                             PreferenceHelper.writeDateTime(context, PreferenceHelper.PrefName.YR_PREVIOUS_FETCH_TIME, DateTime.now());
                         }

                         @Override
                         public void onFailure(Call<LongTermWeatherData> call, Throwable t) {
                             int i = 2*2;
                             //Todo: vis feilmelding
                         }
                     });
    }
}
