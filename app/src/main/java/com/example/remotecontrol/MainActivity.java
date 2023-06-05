package com.example.remotecontrol;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.remotecontrol.databinding.ActivityMainBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "TAG";
    ActivityMainBinding binding;
    private ESP32Service esp32Service;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        esp32Service = RetrofitClient.getClient().create(ESP32Service.class);

        binding.acceptBTN.setOnClickListener(view -> {

            unlockLock();


        });

        binding.declineBTN.setOnClickListener(view -> {

            lockLock();

        });

        binding.doorbellBTN.setOnClickListener(view -> {

            doorBell();

        });


    }

    private void unlockLock() {

        Call<String> unlockCall = esp32Service.unlock();
        unlockCall.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.d("TAG", "onResponse: "+response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.d(TAG, "onFailure: "+t);
            }
        });


    }

    private void lockLock() {

        Call<String> lockCall = esp32Service.lock();
        lockCall.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.d("TAG", "onResponse: "+response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

                Log.d(TAG, "onFailure: "+t);
            }
        });


    }

    private void doorBell() {
        Call<String> ringCall = esp32Service.ring();
        ringCall.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.d("TAG", "onResponse: "+response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.d(TAG, "onFailure: "+t);
            }
        });
    }
}