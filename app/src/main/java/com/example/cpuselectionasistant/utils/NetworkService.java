package com.example.cpuselectionasistant.utils;

import okhttp3.HttpUrl;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkService {
    private static final String BASE_URL = "http://192.168.43.42:5000";
    private static final NetworkService ourInstance = new NetworkService();
    private Retrofit mRetrofit;

    public static NetworkService getInstance() {
        return ourInstance;
    }

    private NetworkService() {
        mRetrofit = new Retrofit.Builder().baseUrl(new HttpUrl.Builder().scheme("http")
                .host("192.168.43.42").port(5000).build())
                .addConverterFactory(GsonConverterFactory.create()).build();
    }

    public ServerAPI getAPI() {
        return mRetrofit.create(ServerAPI.class);
    }
}
