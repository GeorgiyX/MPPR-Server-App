package com.example.cpuselectionasistant.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.ArrayMap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cpuselectionasistant.R;
import com.example.cpuselectionasistant.utils.ServerAPI;
import com.example.cpuselectionasistant.utils.Utils;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.SeekBarProgressChange;
import org.androidannotations.annotations.ViewById;


@EFragment
public class UserChooseFragment extends Fragment {

    // TODO: Add some TextViews!

    @ViewById(R.id.cache_sb)
    public SeekBar mCacheSb;
    @ViewById(R.id.cache_tv)
    public TextView mCacheTv;

    @ViewById(R.id.embedded_sp)
    public Spinner mEmbeddedSpin;
    @ViewById(R.id.embedded_tv)
    public TextView mEmbeddedTv;

    @ViewById(R.id.tbt_sp)
    public Spinner mTBTSpin;
    @ViewById(R.id.tbt_tv)
    public TextView mTBTTv;

    @ViewById(R.id.ivt_sp)
    public Spinner mIVTSpin;
    @ViewById(R.id.ivt_tv)
    public TextView mIVTTv;

    @ViewById(R.id.tdp_sb)
    public SeekBar mTDPSb;
    @ViewById(R.id.tdp_tv)
    public TextView mTDPTv;

    @ViewById(R.id.t_sb)
    public SeekBar mTemperatureSb;
    @ViewById(R.id.t_tv)
    public TextView mTemperatureTv;

    @ViewById(R.id.freq_et)
    public EditText mFreqEt;

    @ViewById(R.id.num_of_cores_sb)
    public SeekBar mNumOfCoresSb;
    @ViewById(R.id.num_of_cores_tv)
    public TextView mNumOfCoresTv;

    @ViewById(R.id.lithography_sb)
    public SeekBar mLithographySb;
    @ViewById(R.id.lithography_tv)
    public TextView mLithographyTv;

    @ViewById(R.id.launch_date_et)
    public EditText mLaunchDateEt;

    @ViewById(R.id.status_sp)
    public Spinner mStatusSpin;
    @ViewById(R.id.status_tv)
    public TextView mStatusTv;

    @ViewById(R.id.segment_sp)
    public Spinner mSegmentSpin;
    @ViewById(R.id.segment_tv)
    public TextView mSegmentTv;

    @ViewById(R.id.predict_tv)
    public TextView mPredictTv;

    @ViewById(R.id.try_again_btn)
    public ImageButton mTryAgainBtn;

    @ViewById(R.id.send_to_server_btn)
    public Button mSendBtn;

    @ViewById(R.id.welcome_tv)
    public TextView mWelcomeTv;

    private OnFragmentInteractionListener mListener;

    private ArrayMap<SeekBar, TextView> mViewsHashMap;
    private ArrayMap<TextView, Integer> mIDsHashMap;

    public UserChooseFragment() {
        // Required empty public constructor
    }


    private void initArraysMap() {
        mViewsHashMap = new ArrayMap<>();
        mViewsHashMap.put(mCacheSb, mCacheTv);
        mViewsHashMap.put(mLithographySb, mLithographyTv);
        mViewsHashMap.put(mTDPSb, mTDPTv);
        mViewsHashMap.put(mTemperatureSb, mTemperatureTv);
        mViewsHashMap.put(mNumOfCoresSb, mNumOfCoresTv);

        mIDsHashMap = new ArrayMap<>();
        mIDsHashMap.put(mCacheTv, R.string.cache);
        mIDsHashMap.put(mLithographyTv, R.string.lithography_nm);
        mIDsHashMap.put(mTDPTv, R.string.tdp_20w);
        mIDsHashMap.put(mTemperatureTv, R.string.t_100_c);
        mIDsHashMap.put(mNumOfCoresTv, R.string.nb_of_cores);

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // Также можно заменить аннотациями
        return inflater.inflate(R.layout.fragment_user_choose, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();

        // Refresh the state of the +1 button each time the activity receives focus.
//        mPlusOneButton.initialize(PLUS_ONE_URL, PLUS_ONE_REQUEST_CODE);
        initArraysMap();
        hideAllViewsAndSetBtnText();
        mWelcomeTv.setVisibility(View.VISIBLE);
    }

    int mCurrentClick = 0;

    // TODO (G) Выглядит не очень..
    private void hideAllViewsAndSetBtnText() {
        mWelcomeTv.setVisibility(View.INVISIBLE);
        mCacheSb.setVisibility(View.GONE);
        mCacheTv.setVisibility(View.GONE);
        mEmbeddedSpin.setVisibility(View.GONE);
        mTBTSpin.setVisibility(View.GONE);
        mIVTSpin.setVisibility(View.GONE);
        mTDPSb.setVisibility(View.GONE);
        mTDPTv.setVisibility(View.GONE);
        mTemperatureSb.setVisibility(View.GONE);
        mTemperatureTv.setVisibility(View.GONE);
        mFreqEt.setVisibility(View.GONE);
        mNumOfCoresSb.setVisibility(View.GONE);
        mNumOfCoresTv.setVisibility(View.GONE);
        mLithographySb.setVisibility(View.GONE);
        mLithographyTv.setVisibility(View.GONE);
        mLaunchDateEt.setVisibility(View.GONE);
        mStatusSpin.setVisibility(View.GONE);
        mSegmentSpin.setVisibility(View.GONE);
        mPredictTv.setVisibility(View.GONE);
        mTryAgainBtn.setVisibility(View.GONE);
        mEmbeddedTv.setVisibility(View.GONE);
        mTBTTv.setVisibility(View.GONE);
        mIVTTv.setVisibility(View.GONE);
        mSegmentTv.setVisibility(View.GONE);
        mStatusTv.setVisibility(View.GONE);
    }

    @SeekBarProgressChange({R.id.lithography_sb, R.id.num_of_cores_sb, R.id.t_sb, R.id.cache_sb, R.id.tdp_sb})
    public void onSeekBarProgressChange(SeekBar seekBar, int progress) {
        TextView textView = mViewsHashMap.get(seekBar);
        textView.setText(String.format("%s %s.", this.getResources().getString(mIDsHashMap.get(textView)), String.valueOf(progress)));
    }

    @Click(R.id.try_again_btn)
    public void onTryAgainButtonPressed() {
        mCurrentClick = 0;
        mSendBtn.setEnabled(true);
        mPredictTv.setText(this.getResources().getText(R.string.computing));
        onMainButtonPressed();
    }

    public void setPredict(String value) {
        mTryAgainBtn.setVisibility(View.VISIBLE);
        mPredictTv.setText(value);
    }

    public void setAPIError() {
        mPredictTv.setText(this.getResources().getText(R.string.error));
        mSendBtn.setEnabled(true);
        mSendBtn.setText(this.getResources().getText(R.string.send_to_server));
        mCurrentClick = 12;
    }


    @Click(R.id.send_to_server_btn)
    public void onMainButtonPressed() {
        Log.v("===DEBUG===", "Click");
        hideAllViewsAndSetBtnText();
        switch (mCurrentClick) {
            case 0:
                mSendBtn.setText(this.getResources().getText(R.string.next));
                mCacheSb.setVisibility(View.VISIBLE);
                mCacheTv.setVisibility(View.VISIBLE);
                break;
            case 1:
                mEmbeddedSpin.setVisibility(View.VISIBLE);
                mEmbeddedTv.setVisibility(View.VISIBLE);
                break;
            case 2:
                mTBTSpin.setVisibility(View.VISIBLE);
                mTBTTv.setVisibility(View.VISIBLE);
                break;
            case 3:
                mIVTSpin.setVisibility(View.VISIBLE);
                mIVTTv.setVisibility(View.VISIBLE);
                break;
            case 4:
                mTDPSb.setVisibility(View.VISIBLE);
                mTDPTv.setVisibility(View.VISIBLE);
                break;
            case 5:
                mTemperatureSb.setVisibility(View.VISIBLE);
                mTemperatureTv.setVisibility(View.VISIBLE);
                break;
            case 6:
                mFreqEt.setVisibility(View.VISIBLE);
                break;
            case 7:
                if (mFreqEt.getText().toString().equals("") || !Utils.isNumber(mFreqEt.getText().toString())) {
                    Toast.makeText(getActivity(), "Plz specify CPU freq or enter valid value!", Toast.LENGTH_LONG).show();
                    mCurrentClick--;
                    onMainButtonPressed();
                    return;
                }
                mNumOfCoresSb.setVisibility(View.VISIBLE);
                mNumOfCoresTv.setVisibility(View.VISIBLE);
                break;
            case 8:
                mLithographySb.setVisibility(View.VISIBLE);
                mLithographyTv.setVisibility(View.VISIBLE);
                break;
            case 9:
                mLaunchDateEt.setVisibility(View.VISIBLE);
                break;
            case 10:
                if (mLaunchDateEt.getText().toString().equals("")) {
                    Toast.makeText(getActivity(), "Plz specify launch date or enter valid value!", Toast.LENGTH_LONG).show();
                    mCurrentClick--;
                    onMainButtonPressed();
                    return;
                }
                mStatusSpin.setVisibility(View.VISIBLE);
                mStatusTv.setVisibility(View.VISIBLE);
                break;
            case 11:
                mSegmentSpin.setVisibility(View.VISIBLE);
                mSegmentTv.setVisibility(View.VISIBLE);
                mSendBtn.setText(this.getResources().getText(R.string.send_to_server));
                break;
            case 12:
                mPredictTv.setText(this.getResources().getText(R.string.computing));
                mPredictTv.setVisibility(View.VISIBLE);
                mSendBtn.setEnabled(false);
                if (mListener != null) {
                    ServerAPI.UserChoose userChoose = new ServerAPI.UserChoose();
                    userChoose.setCache((double) mCacheSb.getProgress());
                    userChoose.setEmbeddedOptionsAvailable(mEmbeddedSpin.getSelectedItem().toString());
                    userChoose.setIntelTurboBoostTechnology(mTBTSpin.getSelectedItem().toString());
                    userChoose.setIntelVirtualizationTechnology(mIVTSpin.getSelectedItem().toString());
                    userChoose.setLaunchDate(mLaunchDateEt.getText().toString());
                    userChoose.setLithography((double) mLithographySb.getProgress());
                    userChoose.setStatus(mStatusSpin.getSelectedItem().toString());
                    userChoose.setVerticalSegment(mSegmentSpin.getSelectedItem().toString());
                    userChoose.setNbOfCores((double) mNumOfCoresSb.getProgress());
                    userChoose.setTDP((double) mTDPSb.getProgress());
                    userChoose.setT(mTemperatureSb.getProgress());
                    userChoose.setProcessorBaseFrequency(Double.valueOf(mFreqEt.getText().toString()));
                    mListener.onFragmentInteraction(userChoose);
                }
            default:
                break;
        }
        Log.v("===DEBUG===", "increment");
        mCurrentClick++;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
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

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(ServerAPI.UserChoose userChoose);
    }

}
