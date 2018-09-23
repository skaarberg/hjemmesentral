package com.homecentral.jrs.hjemmesentral.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.homecentral.jrs.hjemmesentral.R;
import com.homecentral.jrs.hjemmesentral.util.DateUtil;
import com.homecentral.jrs.hjemmesentral.util.PreferenceHelper;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UpdateBar extends RelativeLayout {

    public interface UpdateButtonListener{
        void updateClicked();
    }

    public interface SwitchFragmentButtonListener{
        void switchFragmentClicked();
    }

    LayoutInflater mInflater;
    UpdateButtonListener mUpdateButtonListener;
    SwitchFragmentButtonListener mSwitchFragmentButtonListener;

    @BindView(R.id.btn_update) ImageButton mBtnUpdate;
    @BindView(R.id.btn_next) ImageButton mBtnSwitchFragment;
    @BindView(R.id.txt_updated) TextView mTxtUpdate;
    @BindView(R.id.txt_update_bar_header) TextView mTxtHeader;
    @BindView(R.id.progress_bar) ProgressBar mProgressBar;

    public UpdateBar(Context context) {
        super(context);
        mInflater = LayoutInflater.from(context);

        init();
    }

    public UpdateBar(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);
        mInflater = LayoutInflater.from(context);
        init();
    }

    public UpdateBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        mInflater = LayoutInflater.from(context);
        init();
    }

    private void init()
    {
        View v = mInflater.inflate(R.layout.update_bar, this, true);
        ButterKnife.bind(this, v);

        mBtnUpdate.setOnClickListener(v1 -> mUpdateButtonListener.updateClicked());
        mBtnSwitchFragment.setOnClickListener(v12 -> mSwitchFragmentButtonListener.switchFragmentClicked());
    }

    public void setUpdateButtonListener(UpdateButtonListener listener, int titleResourceId){
        mUpdateButtonListener = listener;
        mBtnUpdate.setVisibility(VISIBLE);
        mTxtHeader.setText(titleResourceId);
    }

    public void setSwitchFragmentButtonListener(SwitchFragmentButtonListener listener){
        mSwitchFragmentButtonListener = listener;
        mBtnSwitchFragment.setVisibility(VISIBLE);
    }

    public void updateUpdateTime(Context context, PreferenceHelper.PrefName prefName){
        Log.d("RuterUtil", "setting text: " + DateUtil.getHoursMinutes(PreferenceHelper.getDateTime(context, prefName)));
        mTxtUpdate.setText(DateUtil.getHoursMinutes(PreferenceHelper.getDateTime(context, prefName)));
        mTxtUpdate.invalidate();
        loadFinished();
    }

    public void loadStarted(){
        mBtnUpdate.setVisibility(INVISIBLE);
        mProgressBar.setVisibility(VISIBLE);
    }

    public void loadFinished(){
        mBtnUpdate.setVisibility(VISIBLE);
        mProgressBar.setVisibility(GONE);
    }
}
