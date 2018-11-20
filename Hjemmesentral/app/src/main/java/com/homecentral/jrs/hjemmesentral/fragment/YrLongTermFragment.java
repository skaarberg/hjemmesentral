package com.homecentral.jrs.hjemmesentral.fragment;

import android.app.Fragment;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.homecentral.jrs.hjemmesentral.R;
import com.homecentral.jrs.hjemmesentral.activity.MainActivity;
import com.homecentral.jrs.hjemmesentral.activity.WeatherDetailsActivity;
import com.homecentral.jrs.hjemmesentral.adapter.YrLongtermAdapter;
import com.homecentral.jrs.hjemmesentral.model.yr.forecast.Time;
import com.homecentral.jrs.hjemmesentral.scheduler.HomeCentralWorkManager;
import com.homecentral.jrs.hjemmesentral.util.PreferenceHelper;
import com.homecentral.jrs.hjemmesentral.view.UpdateBar;
import com.homecentral.jrs.hjemmesentral.viewmodel.YrViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;

public class YrLongTermFragment extends Fragment implements YrLongtermAdapter.OnWeatherClickListener, UpdateBar.UpdateButtonListener, UpdateBar.SwitchFragmentButtonListener{

    private YrLongtermAdapter mAdapter;
    private YrViewModel mYrViewModel;

    @BindView(R.id.update_bar) UpdateBar updateBar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_yr, container, false);
        ButterKnife.bind(this, root);

        RecyclerView rv = root.findViewById(R.id.recyclerView);
        mAdapter = new YrLongtermAdapter(getContext(), this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        rv.setLayoutManager(layoutManager);
        DividerItemDecoration itemDecoration = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
        rv.addItemDecoration(itemDecoration);
        rv.setAdapter(mAdapter);

        MainActivity mainActivity = (MainActivity) getActivity();
        mYrViewModel = ViewModelProviders.of(mainActivity).get(YrViewModel.class);

        mYrViewModel.getLongtermWeatherData().observe(mainActivity, weatherdata -> {
            if(weatherdata != null) {
                mAdapter.setWeatherData(weatherdata.getForecast().getTabular());
                updateBar.updateUpdateTime(getContext(), PreferenceHelper.PrefName.RUTER_REALTIME_PREVIOUS_FETCH_TIME);
            }
        });

        updateBar.setUpdateButtonListener(this, R.string.header_long_term_weather);
        updateBar.setSwitchFragmentButtonListener(this);

        return root;
    }

    @Override
    public void onClick(Time time) {
        getActivity().startActivity(WeatherDetailsActivity.Companion.newIntent(getActivity(), time));
    }

    @Override
    public void updateClicked() {
        HomeCentralWorkManager.scheduleSyncWeather(false);
        updateBar.loadStarted();
    }

    @Override
    public void switchFragmentClicked() {

    }
}
