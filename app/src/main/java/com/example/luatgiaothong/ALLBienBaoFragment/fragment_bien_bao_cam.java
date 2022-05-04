package com.example.luatgiaothong.ALLBienBaoFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.luatgiaothong.Adapter.BienBaoAdapter;
import com.example.luatgiaothong.R;

import java.util.ArrayList;

public class fragment_bien_bao_cam extends Fragment {
    ListView lv_biencam;
    BienBaoAdapter adapter;
    ArrayList<String>arrayList;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_bien_bao_cam,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        lv_biencam=view.findViewById(R.id.lv_biencam);
        arrayList=new ArrayList<>();
        arrayList.add("12");
        arrayList.add("12");
        arrayList.add("12");
        arrayList.add("12");
        arrayList.add("12");
        arrayList.add("12");
        adapter=new BienBaoAdapter(arrayList, R.layout.item_bien_bao,getActivity());
        lv_biencam.setAdapter(adapter);
    }
}
