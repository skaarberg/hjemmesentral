package com.homecentral.jrs.hjemmesentral.fragment;

import android.app.Fragment;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.homecentral.jrs.hjemmesentral.R;
import com.homecentral.jrs.hjemmesentral.activity.MainActivity;
import com.homecentral.jrs.hjemmesentral.adapter.DepartureAdapter;
import com.homecentral.jrs.hjemmesentral.adapter.YrAdapter;
import com.homecentral.jrs.hjemmesentral.model.ruter.Departure;
import com.homecentral.jrs.hjemmesentral.model.ruter.Line;
import com.homecentral.jrs.hjemmesentral.model.ruter.LineDepartures;
import com.homecentral.jrs.hjemmesentral.network.ruter.RuterUtil;
import com.homecentral.jrs.hjemmesentral.util.DepartureUtil;
import com.homecentral.jrs.hjemmesentral.viewmodel.RuterViewModel;

import java.util.List;

public class RuterFragment extends Fragment {

    private DepartureAdapter mAdapter;
    private RuterViewModel mRuterViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_ruter, container, false);

        RecyclerView rv = root.findViewById(R.id.ruterRecyclerView);
        mAdapter = new DepartureAdapter(getContext());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        rv.setLayoutManager(layoutManager);
        DividerItemDecoration itemDecoration = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
        rv.addItemDecoration(itemDecoration);
        rv.setAdapter(mAdapter);

        final MainActivity mainActivity = (MainActivity) getActivity();
        mRuterViewModel = ViewModelProviders.of(mainActivity).get(RuterViewModel.class);

        mRuterViewModel.getDepartures().observe(mainActivity, new Observer<List<Departure>>() {
            @Override
            public void onChanged(@Nullable final List<Departure> departures) {
                if(departures != null && departures.size() > 0) {
                    mAdapter.setDepartures(DepartureUtil.getLineDepartures(departures));
                }
            }
        });
        return root;
    }

}
