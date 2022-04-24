package com.example.luatgiaothong;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.luatgiaothong.Adapter.PictureAdapter;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator2;


public class HomeFragment extends Fragment {
    Home home;
    PictureAdapter adapter;
    List<Integer>arrayList=new ArrayList<>();
    LinearLayout linearThiSatHach,lnlout_meoThi,ln_hoclythuyet;
    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        home= (Home) getActivity();
        arrayList.add(R.drawable.santruonglai);
        arrayList.add(R.drawable.maytinh);
        arrayList.add(R.drawable.iconcaccausai);
        arrayList.add(R.drawable.santruonglai);
        arrayList.add(R.drawable.maytinh);
        arrayList.add(R.drawable.iconcaccausai);
        arrayList.add(R.drawable.santruonglai);
        arrayList.add(R.drawable.maytinh);
        arrayList.add(R.drawable.iconcaccausai);
        arrayList.add(R.drawable.santruonglai);
        linearThiSatHach=view.findViewById(R.id.linearThiSatHach);
        lnlout_meoThi=view.findViewById(R.id.lnlout_meoThi);
        ln_hoclythuyet=view.findViewById(R.id.ln_hoclythuyet);
        linearThiSatHach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_blankFragment_to_menuDeThiFragment);

           //     Navigation.findNavController(getActivity(),R.id.nav_host_fragment_content_display_man).navigate(R.id.menuDeThiFragment);
            }
        });
        lnlout_meoThi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_HomeFragment_to_meoThiFragment);

            }
        });
        ln_hoclythuyet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_HomeFragment_to_hocLyThuyet);
            }
        });

        adapter=new PictureAdapter(arrayList,home);
        RecyclerView recyclerView=view.findViewById(R.id.listAnh);
        recyclerView.setLayoutManager(new LinearLayoutManager(home, RecyclerView.HORIZONTAL, false));
        recyclerView.setAdapter(adapter);
        recyclerView.smoothScrollToPosition(6); //Cuộn tới vị trí
        PagerSnapHelper pagerSnapHelper = new PagerSnapHelper();
        pagerSnapHelper.attachToRecyclerView(recyclerView);
        CircleIndicator2 indicator = view.findViewById(R.id.indicator);
        indicator.attachToRecyclerView(recyclerView, pagerSnapHelper);


    }
}