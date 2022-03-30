package com.example.ddm_api;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.ddm_api.api.JsonplaceholderAPI;
import com.example.ddm_api.model.Todo;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonplaceholderAPI service = retrofit.create(JsonplaceholderAPI.class);

        service.getTodo("3").enqueue(new Callback<Todo>() {
            @Override
            public void onResponse(Call<Todo> call, Response<Todo> response) {
                Log.d("MAIN","TODO OK");
            }

            @Override
            public void onFailure(Call<Todo> call, Throwable t) {
                Log.d("MAIN","TODO KO");
            }
        });

        service.getTodos().enqueue(new Callback<List<Todo>>() {
            @Override
            public void onResponse(Call<List<Todo>> call, Response<List<Todo>> response) {
                Log.d("MAIN","TODO OK LISTA");
            }

            @Override
            public void onFailure(Call<List<Todo>> call, Throwable t) {
                Log.d("MAIN","TODO KO LISTA");
            }
        });
    }
}