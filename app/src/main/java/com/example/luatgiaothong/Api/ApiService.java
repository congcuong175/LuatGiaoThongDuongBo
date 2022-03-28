package com.example.luatgiaothong.Api;

import com.example.luatgiaothong.Entity.CauHoiEntity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    Gson gson=new GsonBuilder()
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .create();
    ApiService apiservice=new Retrofit.Builder()
            .baseUrl("http://10.40.9.169:44444/api/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiService.class);
    @GET("Values")
    Call<List<CauHoiEntity>> getDuLieu();
}
