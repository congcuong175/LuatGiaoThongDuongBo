package com.example.luatgiaothong;

import static com.example.luatgiaothong.Common.Common.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.luatgiaothong.Adapter.PictureAdapter;
import com.example.luatgiaothong.Api.ApiService;
import com.example.luatgiaothong.Entity.CapNhat;
import com.example.luatgiaothong.Entity.CauHoiEntity;
import com.example.luatgiaothong.Entity.ChiTietDe;
import com.example.luatgiaothong.Entity.DapAnEntity;
import com.example.luatgiaothong.Entity.DeThi;
import com.example.luatgiaothong.Entity.LoaiCH;
import com.example.luatgiaothong.Entity.MeoThi;
import com.example.luatgiaothong.Sqlite.DataHelper;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator2;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeFragment extends Fragment {
    Home home;
    PictureAdapter adapter;
    public static DataHelper db;
    List<Integer>arrayList=new ArrayList<>();
    LinearLayout linearThiSatHach,lnlout_meoThi,ln_hoclythuyet,ln_bienbao,ln_tracuu;
    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }
    CapNhat cn;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        home= (Home) getActivity();
        db=new DataHelper(getActivity());

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
        ln_bienbao=view.findViewById(R.id.ln_bienbao);
        linearThiSatHach=view.findViewById(R.id.linearThiSatHach);
        lnlout_meoThi=view.findViewById(R.id.lnlout_meoThi);
        ln_tracuu=view.findViewById(R.id.ln_tracuu);
        showDialog();
       // updateDuLieu();
        if(checkInternetConnection()){
            ApiService.apiservice.getCN().enqueue(new Callback<CapNhat>() {
                @Override
                public void onResponse(Call<CapNhat> call, Response<CapNhat> response) {
                   if(response.body()!=null){
                       if(db.getCapNhat().getMACN()!=response.body().getMACN()) {
                           showDiaglogCN();
                               cn=response.body();
                       }
                   }
                }

                @Override
                public void onFailure(Call<CapNhat> call, Throwable t) {

                }
            });
        }
        ln_hoclythuyet=view.findViewById(R.id.ln_hoclythuyet);
        linearThiSatHach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_blankFragment_to_menuDeThiFragment);

           //     Navigation.findNavController(getActivity(),R.id.nav_host_fragment_content_display_man).navigate(R.id.menuDeThiFragment);
            }
        });
        ln_tracuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_HomeFragment_to_traCuuFragment);

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
        ln_bienbao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_HomeFragment_to_bienBaoFragment);

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
    void showDialog(){
        dialog=new Dialog(getActivity());
        dialog.setContentView(R.layout.itemloaddata);
        dialog.setCancelable(true);
        Window window=dialog.getWindow();
        if(window==null){
            return;
        }
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        WindowManager.LayoutParams layoutParams=window.getAttributes();
        layoutParams.gravity= Gravity.CENTER;
        window.setAttributes(layoutParams);
    }
    void updateDuLieu(){
        db.deleteAllCH();
        db.deleteAllDA();
        db.deleteAllLCH();
        db.deleteAllBODE();
        db.deleteAllCTD();
        db.deleteAllMeo();
        ApiService.apiservice.getCH().enqueue(new Callback<List<CauHoiEntity>>() {
           @Override
           public void onResponse(Call<List<CauHoiEntity>> call, Response<List<CauHoiEntity>> response) {
               if(response.body()!=null){
                   for (CauHoiEntity ch : response.body()){
                       db.insertCH(ch);
                   }
               }
           }

           @Override
           public void onFailure(Call<List<CauHoiEntity>> call, Throwable t) {

           }
       });
        ApiService.apiservice.getDA().enqueue(new Callback<List<DapAnEntity>>() {
            @Override
            public void onResponse(Call<List<DapAnEntity>> call, Response<List<DapAnEntity>> response) {
                if(response.body()!=null){
                    for (DapAnEntity da : response.body()){
                        db.insertDA(da);
                    }
                    dialog.dismiss();
                }
            }

            @Override
            public void onFailure(Call<List<DapAnEntity>> call, Throwable t) {

            }
        });
        ApiService.apiservice.getLCH().enqueue(new Callback<List<LoaiCH>>() {
            @Override
            public void onResponse(Call<List<LoaiCH>> call, Response<List<LoaiCH>> response) {
                if(response.body()!=null){
                    for (LoaiCH lch : response.body()){
                        db.insertLCH(lch);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<LoaiCH>> call, Throwable t) {

            }
        });
        ApiService.apiservice.getCTD().enqueue(new Callback<List<ChiTietDe>>() {
            @Override
            public void onResponse(Call<List<ChiTietDe>> call, Response<List<ChiTietDe>> response) {
                if(response.body()!=null){
                    for (ChiTietDe lch : response.body()){
                        db.insertCTD(lch);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<ChiTietDe>> call, Throwable t) {

            }
        });
        ApiService.apiservice.getDuLieuBD().enqueue(new Callback<List<DeThi>>() {
            @Override
            public void onResponse(Call<List<DeThi>> call, Response<List<DeThi>> response) {
                if(response.body()!=null){
                    for(DeThi dt:response.body()){
                        db.insertDT(dt);
                    }
                    }
            }

            @Override
            public void onFailure(Call<List<DeThi>> call, Throwable t) {

            }
        });
        ApiService.apiservice.getDuLieuMeoThi().enqueue(new Callback<List<MeoThi>>() {
            @Override
            public void onResponse(Call<List<MeoThi>> call, Response<List<MeoThi>> response) {
                if(response.body()!=null){
                    for(MeoThi mt: response.body()){
                        db.insertMT(mt);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<MeoThi>> call, Throwable t) {

            }
        });
    }
    private boolean checkInternetConnection() {
        ConnectivityManager connManager =
                (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connManager.getActiveNetworkInfo();

        if (networkInfo == null) {
            return false;
        }

        if (!networkInfo.isConnected()) {

            return false;
        }

        if (!networkInfo.isAvailable()) {

            return false;
        }
        return true;
    }
    private void showDiaglogCN() {
        Dialog dialog1 = new Dialog(getActivity());
        dialog1.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog1.setContentView(R.layout.dialog_capnhat);
        dialog1.show();
        dialog1.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog1.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog1.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog1.getWindow().setGravity(Gravity.CENTER);
        Button button = dialog1.findViewById(R.id.btn_capnhat);
        Button btn_luckhac=dialog1.findViewById(R.id.btn_luckhac);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkInternetConnection()){
                    db.insertCN(cn);
                    updateDuLieu();
                    dialog1.dismiss();
                    dialog.show();

                }
            }
        });
        btn_luckhac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog1.dismiss();
            }
        });


    }
}