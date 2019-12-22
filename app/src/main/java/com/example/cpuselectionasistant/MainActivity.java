package com.example.cpuselectionasistant;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.cpuselectionasistant.fragments.UserChooseFragment;
import com.example.cpuselectionasistant.fragments.UserChooseFragment_;
import com.example.cpuselectionasistant.utils.NetworkService;
import com.example.cpuselectionasistant.utils.ServerAPI;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements UserChooseFragment.OnFragmentInteractionListener {

    public static final String FRAGMENT_NAME = "user_choose_fragment";
    private UserChooseFragment_ mFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mFragment = new UserChooseFragment_();
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_fl, mFragment).commit();

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
//        getSupportFragmentManager().putFragment(outState, FRAGMENT_NAME, mFragment);
    }

    @Override
    public void onFragmentInteraction(ServerAPI.UserChoose userChoose) {

        NetworkService.getInstance().getAPI().getPredict(userChoose).enqueue(new Callback<ServerAPI.Predict>() {
            @Override
            public void onResponse(Call<ServerAPI.Predict> call, Response<ServerAPI.Predict> response) {
                ServerAPI.Predict predict = response.body();
                assert predict != null;
                mFragment.setPredict(predict.getCpuSeries());
                Toast.makeText(getApplicationContext(), predict.getCpuSeries(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<ServerAPI.Predict> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Api error...", Toast.LENGTH_LONG).show();
                mFragment.setAPIError();
            }
        });
    }
}
