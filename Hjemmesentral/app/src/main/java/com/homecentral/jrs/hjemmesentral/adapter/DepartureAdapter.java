package com.homecentral.jrs.hjemmesentral.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.homecentral.jrs.hjemmesentral.R;
import com.homecentral.jrs.hjemmesentral.model.ruter.Deviation;
import com.homecentral.jrs.hjemmesentral.model.ruter.LineDepartures;
import com.homecentral.jrs.hjemmesentral.util.ColorUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DepartureAdapter extends RecyclerView.Adapter<DepartureAdapter.DepartureViewHolder> {

    class DepartureViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.txt_header) TextView txtHeader;
        @BindView(R.id.img_message) ImageButton btnMessage;
        @BindView(R.id.rv_departures) RecyclerView rvDepartures;
        @BindView(R.id.header_container) RelativeLayout headerContainer;

        private LineDepartures lineDepartures;

        private DepartureViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    private final Context mContext;
    private final LayoutInflater mInflater;
    private List<LineDepartures> mAllLineDepartures;

    public DepartureAdapter(Context context) {
        mContext = context;
        mInflater = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public DepartureViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.ruter_list_item, parent, false);
        return new DepartureViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final DepartureViewHolder holder, int position) {
        holder.lineDepartures = mAllLineDepartures.get(position);
        holder.txtHeader.setText(holder.lineDepartures.getName());
        DeparturesForLineAdapter adapter = new DeparturesForLineAdapter(mContext);
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        holder.rvDepartures.setLayoutManager(layoutManager);
        DividerItemDecoration itemDecoration = new DividerItemDecoration(mContext, DividerItemDecoration.VERTICAL);
        holder.rvDepartures.addItemDecoration(itemDecoration);
        adapter.setDepartures(holder.lineDepartures.getDepartures());
        holder.rvDepartures.setAdapter(adapter);
        holder.headerContainer.setBackgroundColor(ColorUtil.getColorForLine(holder.lineDepartures.getDepartures().get(0)));
        holder.btnMessage.setVisibility(holder.lineDepartures.hasDeviations() ? View.VISIBLE : View.GONE);
        holder.btnMessage.setOnClickListener(v -> displayMessage(holder.lineDepartures.getDepartures().get(0).getExtensions().getDeviations()));
    }

    public void setDepartures(List<LineDepartures> departures){
        mAllLineDepartures = departures;
        notifyDataSetChanged();
    }
    @Override
    public int getItemCount() {
        if(mAllLineDepartures != null) {
            return mAllLineDepartures.size();
        } else {
            return 0;
        }
    }

    private void displayMessage(List<Deviation> deviations) {
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        StringBuilder sb = new StringBuilder();
        for (Deviation deviation : deviations) {
            sb.append(deviation.getHeader());
            if(deviations.indexOf(deviation) != deviations.size() - 1) {
                sb.append("\n");
            }
        }
        builder.setMessage(sb.toString());
        builder.create().show();
    }
}