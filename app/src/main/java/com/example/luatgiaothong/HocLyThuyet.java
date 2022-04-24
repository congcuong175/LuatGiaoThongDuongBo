package com.example.luatgiaothong;

import static com.example.luatgiaothong.Home.layout;
import static com.example.luatgiaothong.MenuDeThiFragment.dethu;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.luatgiaothong.Adapter.CauHoiAdapter;
import com.example.luatgiaothong.Adapter.LyThuyet.LTCauHoiAdapter;
import com.example.luatgiaothong.Api.ApiService;
import com.example.luatgiaothong.Entity.CauHoiEntity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HocLyThuyet extends Fragment {
    LTCauHoiAdapter cauHoiAdapter;
    ArrayList<CauHoiEntity> arrayList = new ArrayList<>();
    static RecyclerView recyclerView;
    public HocLyThuyet() {
        // Required empty public constructor
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        cauHoiAdapter = new LTCauHoiAdapter(getActivity());
        layout.setVisibility(View.GONE);
        cauHoiAdapter.setData(arrayList);
        ApiService.apiservice.getDuLieu().enqueue(new Callback<List<CauHoiEntity>>() {
            @Override
            public void onResponse(Call<List<CauHoiEntity>> call, Response<List<CauHoiEntity>> response) {
                for (CauHoiEntity ch : response.body()) {
                    arrayList.add(ch);
                }
                cauHoiAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<CauHoiEntity>> call, Throwable t) {

            }
        });
        recyclerView = view.findViewById(R.id.listCauLyThuyet);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));
        recyclerView.setAdapter(cauHoiAdapter);
        recyclerView.setHasFixedSize(true);
        PagerSnapHelper pagerSnapHelper = new PagerSnapHelper();
        pagerSnapHelper.attachToRecyclerView(recyclerView);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hoc_ly_thuyet, container, false);
    }
    public static void scolltoPager(int i) {
        recyclerView.smoothScrollToPosition(i); //Cuộn tới vị trí
    }
}