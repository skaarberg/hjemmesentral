package com.homecentral.jrs.hjemmesentral.fragment;

import android.app.Fragment;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.homecentral.jrs.hjemmesentral.R;
import com.homecentral.jrs.hjemmesentral.activity.MainActivity;
import com.homecentral.jrs.hjemmesentral.adapter.DepartureAdapter;
import com.homecentral.jrs.hjemmesentral.adapter.YrAdapter;
import com.homecentral.jrs.hjemmesentral.model.ruter.Departure;
import com.homecentral.jrs.hjemmesentral.model.ruter.Line;
import com.homecentral.jrs.hjemmesentral.model.ruter.LineDepartures;
import com.homecentral.jrs.hjemmesentral.network.ruter.RuterUtil;
import com.homecentral.jrs.hjemmesentral.scheduler.HomeCentralWorkManager;
import com.homecentral.jrs.hjemmesentral.util.DepartureUtil;
import com.homecentral.jrs.hjemmesentral.util.PreferenceHelper;
import com.homecentral.jrs.hjemmesentral.view.UpdateBar;
import com.homecentral.jrs.hjemmesentral.viewmodel.RuterViewModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RuterFragment extends Fragment implements UpdateBar.UpdateButtonListener {

    private DepartureAdapter mAdapter;
    private RuterViewModel mRuterViewModel;

    @BindView(R.id.update_bar) UpdateBar updateBar;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_ruter, container, false);
        ButterKnife.bind(this, root);

        RecyclerView rv = root.findViewById(R.id.ruterRecyclerView);
        mAdapter = new DepartureAdapter(getContext());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        rv.setLayoutManager(layoutManager);
        DividerItemDecoration itemDecoration = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
        rv.addItemDecoration(itemDecoration);
        rv.setAdapter(mAdapter);

        final MainActivity mainActivity = (MainActivity) getActivity();
        mRuterViewModel = ViewModelProviders.of(mainActivity).get(RuterViewModel.class);

        mRuterViewModel.getDepartures().observe(mainActivity, departures -> {
            if(departures != null && departures.size() > 0) {
                mAdapter.setDepartures(DepartureUtil.getLineDepartures(departures));
                updateBar.updateUpdateTime(getContext(), PreferenceHelper.PrefName.RUTER_REALTIME_PREVIOUS_FETCH_TIME);
            }
        });

        updateBar.setUpdateButtonListener(this, R.string.header_departures);

        //getActivity().getWindow().addFlags(WindowManager.LayoutParams.SCREEN);

        return root;
    }

    @Override
    public void updateClicked() {
        updateBar.loadStarted();
        HomeCentralWorkManager.scheduleSyncDepartures(getContext(), false, true);
    }
}
