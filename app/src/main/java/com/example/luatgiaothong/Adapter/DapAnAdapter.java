package com.example.luatgiaothong.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.luatgiaothong.Entity.DapAnEntity;
import com.example.luatgiaothong.R;

import java.util.List;

public class DapAnAdapter extends BaseAdapter {
    List<DapAnEntity> dapAnEntityList;
    private int layout;
    private Context context;
    int selectedIndex = -1;

    public void setSelectedIndex(int index){

        selectedIndex = index;
    }
    public DapAnAdapter(List<DapAnEntity> dapAnEntityList, int layout, Context context) {
        this.dapAnEntityList = dapAnEntityList;
        this.layout = layout;
        this.context = context;
    }

    @Override
    public int getCount() {
        return dapAnEntityList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
    int a=0;
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view=inflater.inflate(layout,null);
        TextView textView=view.findViewById(R.id.tv_cautraloi);
        DapAnEntity dapAnEntity=dapAnEntityList.get(i);
        textView.setText(dapAnEntity.getDapAN());
        RadioButton rbSelect = (RadioButton) view
                .findViewById(R.id.rdo_chondapan);

        if(selectedIndex == i){
            rbSelect.setChecked(true);

        }
        else{
            rbSelect.setChecked(false);
        }
        return view;
    }
    public int kiemTraDA(){
        if(dapAnEntityList.get(selectedIndex).getKiemTra()){
return 1;
        }
        else {
            return 0;
        }

    }
}
