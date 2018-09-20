package com.homecentral.jrs.hjemmesentral.network.yr;

import android.content.Context;

import com.homecentral.jrs.hjemmesentral.database.YrRepository;
import com.homecentral.jrs.hjemmesentral.model.yr.WeatherData;
import com.homecentral.jrs.hjemmesentral.network.APIClient;
import com.homecentral.jrs.hjemmesentral.network.GetYrDataService;
import com.homecentral.jrs.hjemmesentral.util.DateUtil;
import com.homecentral.jrs.hjemmesentral.util.PreferenceHelper;

import org.joda.time.DateTime;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class YrNetworkUtil {

    private static String API_BASE_URL = "http://www.yr.no/sted/Norge/Oslo/Oslo/Galgeberg/varsel.xml";

    public static void fetchYrData(final Context context) throws IOException {

        // Has recently fetched, will not do again yet
        if(!DateUtil.isWithinMinutes(DateTime.now(), PreferenceHelper.getDateTime(context, PreferenceHelper.PrefName.YR_PREVIOUS_FETCH_TIME), 20)){
            return;
        }

        GetYrDataService service = APIClient.getClient().create(GetYrDataService.class);
        Call<WeatherData> call = service.getWeatherData();
        call.enqueue(new Callback<WeatherData>() {
                         @Override
                         public void onResponse(Call<WeatherData> call, Response<WeatherData> response) {
                             int i = 2 * 2;
                             YrRepository yrRepository = new YrRepository(context);
                             yrRepository.insert(response.body());
                             PreferenceHelper.writeDateTime(context, PreferenceHelper.PrefName.YR_PREVIOUS_FETCH_TIME, DateTime.now());
                         }
                         //progressDoalog.dismiss();
                         //generateDataList(response.body());

                         @Override
                         public void onFailure(Call<WeatherData> call, Throwable t) {
                             int i = 2 * 2;
                             //progressDoalog.dismiss();
                             //Toast.makeText(MainActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
                         }
                     });

        /*
        final URL url = new URL("http://polman.herokuapp.com/api/forecast?url=http://www.yr.no/sted/Norge/Oslo/Oslo/Galgeberg/varsel.xml&num=10&jsonp=myCallback");
        final WeatherData[] weatherdata = {null};
        new AsyncTask<Void, Void, Void>() {

            @Override
            protected Void doInBackground(Void... voids) {
                try {
                    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                    try {
                        InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                        String callback = "myCallback(";
                        InputStreamReader r = new InputStreamReader(in);
                        r.skip(callback.length());
                        weatherdata[0] = JacksonHelper.getInstance().readValue(r, WeatherData.class);
                    } finally {
                        urlConnection.disconnect();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                YrRepository yrRepository = new YrRepository(context);
                if(weatherdata.length > 0 && weatherdata[0] != null)
                yrRepository.insert(weatherdata[0]);
                PreferenceHelper.writeDateTime(context, PreferenceHelper.PrefName.YR_PREVIOUS_FETCH_TIME, DateTime.now());
            }
        }.execute();
        */
    }
}
