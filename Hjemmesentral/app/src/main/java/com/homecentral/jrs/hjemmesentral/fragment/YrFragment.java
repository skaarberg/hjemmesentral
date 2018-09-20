package com.homecentral.jrs.hjemmesentral.fragment;

import android.app.Fragment;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.net.Uri;
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
import com.homecentral.jrs.hjemmesentral.adapter.YrAdapter;
import com.homecentral.jrs.hjemmesentral.model.yr.forecast.Time;
import com.homecentral.jrs.hjemmesentral.viewmodel.YrViewModel;

public class YrFragment extends Fragment implements YrAdapter.OnWeatherClickListener {

    private YrAdapter mAdapter;
    private YrViewModel mYrViewModel;
    private OnFragmentInteractionListener mListener;

    public static YrFragment newInstance() {
        YrFragment fragment = new YrFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_yr, container, false);

        RecyclerView rv = root.findViewById(R.id.recyclerView);
        mAdapter = new YrAdapter(getContext(), this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        rv.setLayoutManager(layoutManager);
        DividerItemDecoration itemDecoration = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
        rv.addItemDecoration(itemDecoration);
        rv.setAdapter(mAdapter);

        MainActivity mainActivity = (MainActivity) getActivity();
        mYrViewModel = ViewModelProviders.of(mainActivity).get(YrViewModel.class);

        mYrViewModel.getWeatherData().observe(mainActivity, weatherdata -> {
            if(weatherdata != null) {
                mAdapter.setWeatherData(weatherdata.getForecast().getTabular());
            }
        });

        return root;
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }

    @Override
    public void onClick(Time time) {
        getActivity().startActivity(WeatherDetailsActivity.Companion.newIntent(getActivity(), time));
    }
}
