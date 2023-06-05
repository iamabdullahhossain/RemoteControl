package com.example.remotecontrol;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ESP32Service {

//    @GET("/{action}")
//    Call<Void> performAction(@Path("action") String action);

    @GET("/unlock")
    Call<String> unlock();

    @GET("/lock")
    Call<String> lock();

    @GET("/ring")
    Call<String> ring();

}
