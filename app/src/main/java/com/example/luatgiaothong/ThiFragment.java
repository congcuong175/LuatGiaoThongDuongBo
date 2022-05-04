package com.example.luatgiaothong;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.os.CountDownTimer;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.luatgiaothong.Adapter.CauHoiAdapter;
import com.example.luatgiaothong.Adapter.PictureAdapter;
import com.example.luatgiaothong.Api.ApiService;
import com.example.luatgiaothong.Entity.CauHoiEntity;
import com.example.luatgiaothong.Entity.DapAnEntity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.luatgiaothong.HomeFragment.db;
import static com.example.luatgiaothong.MenuDeThiFragment.dethu;
import static com.example.luatgiaothong.Common.Common.dialog;

public class ThiFragment extends Fragment {
    CauHoiAdapter cauhoiAdapter;
    TextView tv_ketthucbaithi, tv_tieude, tv_time;
    public static int click = 0;
    static RecyclerView recyclerView;
    List<CauHoiEntity> arrayList = new ArrayList<>();

    CountDownTimer countDownTimer;

    public ThiFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_thi, container, false);
    }

    int time = 1320000;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tv_ketthucbaithi = view.findViewById(R.id.tv_ketthucbaithi);
        tv_tieude = view.findViewById(R.id.tv_tieude);
        tv_tieude.setText("Đề " + dethu);
        tv_time = view.findViewById(R.id.tv_time);
        cauhoiAdapter = new CauHoiAdapter(getActivity());
        click = 1;
        countDownTimer = new CountDownTimer(time, 1000) {
            @Override
            public void onTick(long l) {
                tv_time.setText((l / (1000 * 60)) + ":" + (l / 1000) % 60);
            }

            @Override
            public void onFinish() {
                showDiaglog();
            }
        };
        arrayList= db.getBoDe(dethu);
        cauhoiAdapter.setData(arrayList);
        countDownTimer.start();
//        ApiService.apiservice.getDuLieuByBoDe(dethu).enqueue(new Callback<List<CauHoiEntity>>() {
//            @Override
//            public void onResponse(Call<List<CauHoiEntity>> call, Response<List<CauHoiEntity>> response) {
//                if(response.body()!=null){
//
//                    for (CauHoiEntity ch : response.body()) {
//                        arrayList.add(ch);
//                    }
//                    cauhoiAdapter.notifyDataSetChanged();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<CauHoiEntity>> call, Throwable t) {
//                Log.e("Lỗi gì đó", t.toString());
//                dialog.dismiss();
//                Toast.makeText(getActivity(), "Server Lỗi", Toast.LENGTH_SHORT).show();
//            }
//        });



        tv_ketthucbaithi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click = 0;
                //Toast.makeText(getActivity(),cauhoiAdapter.getCauTraLoiDung()+"",Toast.LENGTH_SHORT).show();
                showDiaglog();
                countDownTimer.cancel();
            }
        });
        recyclerView = view.findViewById(R.id.listCauhoi);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));
        recyclerView.setAdapter(cauhoiAdapter);
        recyclerView.setHasFixedSize(true);
        PagerSnapHelper pagerSnapHelper = new PagerSnapHelper();
        pagerSnapHelper.attachToRecyclerView(recyclerView);

    }

    public static void scolltoPager(int i) {
        recyclerView.smoothScrollToPosition(i); //Cuộn tới vị trí
    }


    private void showDiaglog() {
        Dialog dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_ketthucbaithi);
        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.CENTER);
        Button button = dialog.findViewById(R.id.btn_trove);
        TextView tv_notikq = dialog.findViewById(R.id.tv_notikq);
        TextView tv_notisocau = dialog.findViewById(R.id.tv_notisocau);
        if (cauhoiAdapter.getCauTraLoiDung() > 31) {
            tv_notikq.setText("Chúc mừng bạn^^");
        } else {
            tv_notikq.setText("Bạn chượt rùi!!!");
        }

        tv_notisocau.setText(cauhoiAdapter.getCauTraLoiDung() + "/35");
        Button button2 = dialog.findViewById(R.id.btn_xemlai);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.hide();
                click = 0;
                cauhoiAdapter.notifyDataSetChanged();
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click = 1;
                arrayList.clear();
                arrayList=db.getBoDe(dethu);
                cauhoiAdapter.setData(arrayList);
                recyclerView.smoothScrollToPosition(0);
                countDownTimer.start();
                dialog.hide();
            }
        });
    }
}