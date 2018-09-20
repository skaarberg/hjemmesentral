package com.homecentral.jrs.hjemmesentral.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.homecentral.jrs.hjemmesentral.R;
import com.homecentral.jrs.hjemmesentral.model.ruter.Departure;
import com.homecentral.jrs.hjemmesentral.model.ruter.Line;
import com.homecentral.jrs.hjemmesentral.util.ColorUtil;
import com.homecentral.jrs.hjemmesentral.util.TextUtil;

import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DeparturesForLineAdapter extends RecyclerView.Adapter<DeparturesForLineAdapter.DepartureViewHolder> {

    public final static Locale NORWEGIAN_LOCALE = new Locale("no", "NO");

    class DepartureViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.txt_time) TextView txtTime;

        private Departure departure;

        private DepartureViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    private final Context mContext;
    private final LayoutInflater mInflater;
    private List<Departure> mDepartures;

    public DeparturesForLineAdapter(Context context) {
        mContext = context;
        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public DepartureViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.list_item_departure, parent, false);
        return new DepartureViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull DepartureViewHolder holder, int position) {
        holder.departure = mDepartures.get(position);
        holder.txtTime.setText(TextUtil.getCountdownText(
                mContext,
                holder.departure.getMonitoredVehicleJourney().getMonitoredCall().getExpectedArrivalTime(),
                holder.departure.getMonitoredVehicleJourney().getMonitored()));
        holder.txtTime.setTextColor(ColorUtil.getColorForDeparture(mContext, holder.departure));
        //holder.txtTime.setBackgroundColor();
    }

    public void setDepartures(List<Departure> departures){
        mDepartures = departures;
        notifyDataSetChanged();
    }
    @Override
    public int getItemCount() {
        if(mDepartures != null) {
            return mDepartures.size();
        } else {
            return 0;
        }
    }
}