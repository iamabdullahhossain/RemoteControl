package com.example.remotecontrol;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static final String ESP32_BASE_URL = "http://192.168.0.106/"; // Replace with your ESP32 IP address

    private static Retrofit retrofit = null;



    public static Retrofit getClient() {

        if (retrofit == null) {

            OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder()
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .readTimeout(30, TimeUnit.SECONDS)
                    .writeTimeout(30, TimeUnit.SECONDS);
            OkHttpClient httpClient = httpClientBuilder.build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(ESP32_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient)
                    .build();
        }
        return retrofit;
    }

}
