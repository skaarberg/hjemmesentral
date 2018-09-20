package com.homecentral.jrs.hjemmesentral.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.homecentral.jrs.hjemmesentral.R;
import com.homecentral.jrs.hjemmesentral.model.yr.forecast.Precipitation;
import com.homecentral.jrs.hjemmesentral.model.yr.forecast.Symbol;
import com.homecentral.jrs.hjemmesentral.model.yr.forecast.Temperature;
import com.homecentral.jrs.hjemmesentral.model.yr.forecast.Time;
import com.homecentral.jrs.hjemmesentral.model.yr.forecast.WindDirection;
import com.homecentral.jrs.hjemmesentral.model.yr.forecast.WindSpeed;

import org.joda.time.DateTime;

import java.util.List;
import java.util.Locale;

public class YrAdapter extends RecyclerView.Adapter<YrAdapter.WeatherViewHolder> {

    public interface OnWeatherClickListener{
        void onClick(Time time);
    }

    public final static Locale NORWEGIAN_LOCALE = new Locale("no", "NO");

    class WeatherViewHolder extends RecyclerView.ViewHolder {
        private Time mSpecificForecast;

        private final TextView txtHeader;
        private final TextView txtTime;
        private final ImageView imgSymbol;
        private final TextView txtTemperature;
        private final TextView txtRain;
        private final TextView txtWind;

        private WeatherViewHolder(View itemView) {
            super(itemView);
            txtHeader = itemView.findViewById(R.id.txt_header);
            txtTime = itemView.findViewById(R.id.txt_time);
            imgSymbol = itemView.findViewById(R.id.img_symbol);
            txtTemperature = itemView.findViewById(R.id.txt_temperature);
            txtRain = itemView.findViewById(R.id.txt_rain);
            txtWind = itemView.findViewById(R.id.txt_wind);
        }

        public void setHeader(boolean isFirst){
            if(Integer.parseInt(mSpecificForecast.getPeriod()) == 0 || isFirst) {
                DateTime currentTime = new DateTime(mSpecificForecast.getFrom());
                txtHeader.setText(currentTime.dayOfWeek().getAsText(NORWEGIAN_LOCALE).toUpperCase());
                txtHeader.setVisibility(View.VISIBLE);
            }
        }
    }

    private final Context mContext;
    private final LayoutInflater mInflater;
    private List<Time> mForecast;
    private OnWeatherClickListener mOnWeatherClickListener;

    public YrAdapter(Context context, OnWeatherClickListener onWeatherClickListener) {
        mContext = context;
        mInflater = LayoutInflater.from(mContext);
        mOnWeatherClickListener = onWeatherClickListener;
    }

    @Override
    public WeatherViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.yr_view_holder, parent, false);
        return new WeatherViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherViewHolder holder, int position) {
        holder.setIsRecyclable(false);
        holder.mSpecificForecast = mForecast.get(position);
        holder.setHeader(position == 0);
        holder.txtTime.setText(getTimeString(holder.mSpecificForecast.getFrom(), holder.mSpecificForecast.getTo()));
        holder.imgSymbol.setImageResource(getSymbolResource(holder.mSpecificForecast.getSymbol()));
        holder.txtTemperature.setText(getTemperatureString(holder.mSpecificForecast.getTemperature()));

        double amount = Double.parseDouble(holder.mSpecificForecast.getPrecipitation().getValue());
        if(amount > 0){
            holder.txtRain.setText(getPrecipitationString(holder.mSpecificForecast.getPrecipitation()));
        } else {
            holder.txtRain.setVisibility(View.GONE);
        }

        holder.txtWind.setText(getWindString(holder.mSpecificForecast.getWindSpeed(), holder.mSpecificForecast.getWindDirection()));

        holder.itemView.setOnClickListener(v -> startWeatherDetails(holder.mSpecificForecast));
    }

    public void setWeatherData(List<Time> forecast){
        mForecast = forecast;
        notifyDataSetChanged();
    }
    @Override
    public int getItemCount() {
        if(mForecast != null) {
            return mForecast.size();
        } else {
            return 0;
        }
    }

    private String getTemperatureString(Temperature temperature){
        return temperature.getValue() + "˚";
    }

    private int getSymbolResource(Symbol symbol){
        String drawableName = "y" + symbol.getVar();
        return mContext.getResources().getIdentifier(drawableName, "drawable", mContext.getPackageName());
    }

    private String getPrecipitationString(Precipitation precipitation){
        double amount = Double.parseDouble(precipitation.getValue());
        if(amount > 0){
            return amount + " mm";
        } else {
            return null;
        }
    }

    private String getWindString(WindSpeed windSpeed, WindDirection windDirection){
        //double amount = Double.parseDouble(windSpeed.getMps());
        return windSpeed.getMps() + " " + windSpeed.getName();
    }

    private String getTimeString(String from, String to){
        DateTime dateFrom = new DateTime(from);
        DateTime dateTo = new DateTime(to);
        return dateFrom.hourOfDay().getAsString() + " - " + dateTo.hourOfDay().getAsString();
    }

    private void startWeatherDetails(Time time) {
        mOnWeatherClickListener.onClick(time);
    }
}