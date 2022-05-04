package com.example.luatgiaothong.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.luatgiaothong.Entity.DeThi;
import com.example.luatgiaothong.R;

import java.util.List;

public class BienBaoAdapter extends BaseAdapter {
    List<String> deThiList;
    private int layout;
    private Context context;

    public BienBaoAdapter(List<String> deThiList, int layout, Context context) {
        this.deThiList = deThiList;
        this.layout = layout;
        this.context = context;
    }

    public void setData(List<String> deThiList) {
        this.deThiList = deThiList;
        notifyDataSetChanged();
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
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout, null);


        return view;
    }
}