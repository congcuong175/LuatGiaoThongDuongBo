package com.example.luatgiaothong.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.lottie.animation.content.Content;
import com.example.luatgiaothong.Entity.DeThi;
import com.example.luatgiaothong.R;

import java.util.List;

public class DethiAdapter extends BaseAdapter {
    List<DeThi> deThiList;
    private int layout;
    private Context context;

    public DethiAdapter(List<DeThi> deThiList, int layout, Context context) {
        this.deThiList = deThiList;
        this.layout = layout;
        this.context = context;
    }

    @Override
    public int getCount() {
        return deThiList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view=inflater.inflate(layout,null);

        ImageView avatarDeThi=view.findViewById(R.id.avatarDeThi);
        TextView titleDeThi=view.findViewById(R.id.titleDeThi);
        TextView tvTimeThi=view.findViewById(R.id.tvTimeThi);
        TextView tvLamBai=view.findViewById(R.id.tvLamBai);

        DeThi deThi=deThiList.get(i);
        titleDeThi.setText("Đề số "+deThi.getMaDe());
        tvTimeThi.setText(deThi.getThoiGian());
        return view;
    }
}
