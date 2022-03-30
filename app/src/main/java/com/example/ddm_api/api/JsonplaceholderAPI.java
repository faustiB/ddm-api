package com.example.ddm_api.api;

import com.example.ddm_api.model.Todo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface JsonplaceholderAPI {
    @GET("todos/{todoID}")
    Call<Todo> getTodo(@Path("todoID") String todoID );


    @GET("todos/")
    Call<List<Todo>> getTodos();


}
