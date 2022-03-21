package com.example.luatgiaothong;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.luatgiaothong.Adapter.CauHoiAdapter;
import com.example.luatgiaothong.Adapter.PictureAdapter;
import com.example.luatgiaothong.Entity.CauHoiEntity;
import com.example.luatgiaothong.Entity.DapAnEntity;

import java.util.ArrayList;
import java.util.List;


public class ThiFragment extends Fragment {
LinearLayout btn_dialogsheet;
CauHoiAdapter cauhoiAdapter;
TextView tv_ketthucbaithi;
    ArrayList<CauHoiEntity> arrayList=new ArrayList<>();
    public ThiFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_thi, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btn_dialogsheet=view.findViewById(R.id.ln_bottom_sheet);
        btn_dialogsheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDiaglog();
            }
        });
        tv_ketthucbaithi=view.findViewById(R.id.tv_ketthucbaithi);
        List<DapAnEntity>dapAnEntityList=new ArrayList<>();
        dapAnEntityList.add(new DapAnEntity(1,"A Súc vật thiện 1",true));
        dapAnEntityList.add(new DapAnEntity(2,"B Súc vật thiện 2",false));
        dapAnEntityList.add(new DapAnEntity(3,"C Súc vật thiện 3",false));
        arrayList.add(new CauHoiEntity(1,"Thiện là súc vật?","https://scontent.fhan5-3.fna.fbcdn.net/v/t39.30808-6/240587368_2665743627052756_506045393396876329_n.jpg?_nc_cat=106&ccb=1-5&_nc_sid=09cbfe&_nc_ohc=ErSf6vogMs0AX8OzA-t&_nc_ht=scontent.fhan5-3.fna&oh=00_AT_ePqTO7aj50ejWVszapd_4Ttq5EgtWM1y0bd963u188A&oe=623CDB19",dapAnEntityList));
        arrayList.add(new CauHoiEntity(1,"Thiện là súc vật?",null,dapAnEntityList));
        arrayList.add(new CauHoiEntity(1,"Thiện là súc vật?",null,dapAnEntityList));
        arrayList.add(new CauHoiEntity(1,"Thiện là súc vật?",null,dapAnEntityList));
        cauhoiAdapter=new CauHoiAdapter(getActivity());
        cauhoiAdapter.setData(arrayList);
        tv_ketthucbaithi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),cauhoiAdapter.getCauTraLoiDung()+"",Toast.LENGTH_SHORT).show();
            }
        });
        RecyclerView recyclerView=view.findViewById(R.id.listCauhoi);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));
        recyclerView.setAdapter(cauhoiAdapter);
        PagerSnapHelper pagerSnapHelper = new PagerSnapHelper();
        pagerSnapHelper.attachToRecyclerView(recyclerView);
    }
    private void showDiaglog(){
        Dialog dialog=new Dialog(getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.bottomsheet);
        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations=R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);
    }
}