package com.example.luatgiaothong.Api;

import com.example.luatgiaothong.Entity.CauHoiEntity;
import com.example.luatgiaothong.Entity.DeThi;
import com.example.luatgiaothong.Entity.MeoThi;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    Gson gson=new GsonBuilder()
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .create();
    ApiService apiservice=new Retrofit.Builder()
            .baseUrl("https://webluat.conveyor.cloud/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiService.class);
    @GET("api/values/getALLCauHoi")
    Call<List<CauHoiEntity>> getDuLieu();
    @GET("api/values/getCauHoiByBoDe")
    Call<List<CauHoiEntity>> getDuLieuByBoDe(@Query("id") int id);

    @GET("api/bodes/getALLBode")
    Call<List<DeThi>> getDuLieuBD();
    @GET("api/MeoThis")
    Call<List<MeoThi>> getDuLieuMeoThi();
}
