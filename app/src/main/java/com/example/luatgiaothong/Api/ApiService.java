package com.example.luatgiaothong.Api;

import com.airbnb.lottie.L;
import com.example.luatgiaothong.Entity.CapNhat;
import com.example.luatgiaothong.Entity.CauHoiEntity;
import com.example.luatgiaothong.Entity.ChiTietDe;
import com.example.luatgiaothong.Entity.DapAnEntity;
import com.example.luatgiaothong.Entity.DeThi;
import com.example.luatgiaothong.Entity.LoaiCH;
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
    @GET("api/CAUHOIs")
    Call<List<CauHoiEntity>> getCH();
    @GET("api/DAPANs")
    Call<List<DapAnEntity>> getDA();
    @GET("api/LOAICAUHOIs")
    Call<List<LoaiCH>> getLCH();
    @GET("api/CHITIETDEs")
    Call<List<ChiTietDe>> getCTD();
    @GET("api/CAPNHATs")
    Call<CapNhat> getCN();


    @GET("api/BODEs")
    Call<List<DeThi>> getDuLieuBD();
    @GET("api/CHITIETDEs/TaoDe")
    Call<List<ChiTietDe>> TaoDe(@Query("bd")int bd);
    @GET("api/MEOTHIs")
    Call<List<MeoThi>> getDuLieuMeoThi();
    @GET("api/values/getCauHoiByBoDe")
    Call<List<CauHoiEntity>> getDuLieuByBoDe(@Query("id") int id);

}
