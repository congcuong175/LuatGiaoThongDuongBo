package com.example.luatgiaothong;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.luatgiaothong.Adapter.DethiAdapter;
import com.example.luatgiaothong.Api.ApiService;
import com.example.luatgiaothong.Entity.ChiTietDe;
import com.example.luatgiaothong.Entity.DeThi;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import static com.example.luatgiaothong.Common.Common.dialog;
import static com.example.luatgiaothong.Home.layout;
import static com.example.luatgiaothong.HomeFragment.db;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MenuDeThiFragment extends Fragment {
    List<DeThi>deThis;
    DethiAdapter adapter;
    ListView listView;

    FloatingActionButton floatingActionButton;
    public MenuDeThiFragment() {
        // Required empty public constructor
    }
    public static int dethu;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listView=view.findViewById(R.id.lv_deThi);
        floatingActionButton=view.findViewById(R.id.floatingActionButton);
        layout.setVisibility(View.GONE);
        deThis=new ArrayList();

        adapter=new DethiAdapter(deThis,R.layout.item_dethi,getActivity());
        listView.setAdapter(adapter);
        deThis=db.getAll();
        adapter.setData(deThis);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                dethu=deThis.get(i).getMaDe();
                Navigation.findNavController(view).navigate(R.id.action_menuDeThiFragment_to_thiFragment2);
            }
        });
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DeThi dt=new DeThi();
                dialog.show();
                dt.setMaDe(db.getAll().size()+1);
                dt.setGhiChu("");
                db.insertDT(dt);
                ApiService.apiservice.TaoDe(db.getAll().size()).enqueue(new Callback<List<ChiTietDe>>() {
                    @Override
                    public void onResponse(Call<List<ChiTietDe>> call, Response<List<ChiTietDe>> response) {
                        if(response.body()!=null){
                            dialog.dismiss();
                            for (ChiTietDe ctd :response.body()
                            ) {
                                db.insertCTD(ctd);
                            }
                        }
                        deThis=db.getAll();
                        adapter.setData(deThis);
                    }

                    @Override
                    public void onFailure(Call<List<ChiTietDe>> call, Throwable t) {

                    }
                });
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu_de_thi, container, false);
    }

}