package com.example.luatgiaothong;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.luatgiaothong.Adapter.MeoThiApdater;
import com.example.luatgiaothong.Api.ApiService;
import com.example.luatgiaothong.Entity.MeoThi;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MeoThiFragment extends Fragment {

    public MeoThiFragment() {
        // Required empty public constructor
    }
    RecyclerView rcvMeoThi;
    MeoThiApdater apdater;
    ArrayList<MeoThi> meoThis=new ArrayList<>();
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ApiService.apiservice.getDuLieuMeoThi().enqueue(new Callback<List<MeoThi>>() {
            @Override
            public void onResponse(Call<List<MeoThi>> call, Response<List<MeoThi>> response) {
                for(MeoThi mt: response.body()){
                    meoThis.add(mt);
                }
                apdater.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<MeoThi>> call, Throwable t) {

            }
        });
        rcvMeoThi=view.findViewById(R.id.rcv_meoThi);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());
        rcvMeoThi.setLayoutManager(linearLayoutManager);
        rcvMeoThi.setFocusable(false);
        apdater=new MeoThiApdater(getActivity());
        apdater.setData(meoThis);
        rcvMeoThi.setAdapter(apdater);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_meo_thi, container, false);
    }
}