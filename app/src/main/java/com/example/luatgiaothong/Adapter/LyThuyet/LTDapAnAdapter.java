package com.example.luatgiaothong.Adapter.LyThuyet;


import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.luatgiaothong.Entity.DapAnEntity;
import com.example.luatgiaothong.Entity.MeoThi;
import com.example.luatgiaothong.R;
import com.ramotion.foldingcell.FoldingCell;

import java.util.ArrayList;
import java.util.List;
import static com.example.luatgiaothong.ThiFragment.click;
public class LTDapAnAdapter extends RecyclerView.Adapter<LTDapAnAdapter.LTDapAnViewHolder> {
    List<DapAnEntity> dapAnEntityList;
    public LTDapAnAdapter(List<DapAnEntity> dapAnEntityList) {
        this.dapAnEntityList = dapAnEntityList;
    }

    @NonNull
    @Override
    public LTDapAnViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cautraloi,parent,false);
        return new LTDapAnViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LTDapAnViewHolder holder, @SuppressLint("RecyclerView") int position) {
        DapAnEntity dapAnEntity=dapAnEntityList.get(position);
        if(dapAnEntity==null){
            return;
        }
        holder.textView.setText(dapAnEntity.getDapAN());

            if(dapAnEntity.getDapAnChoose()==1){
                holder.rbSelect.setChecked(true);
                if(dapAnEntity.getKiemTra()){
                    holder.textView.setTextColor(Color.RED);
                }
                else{
                    holder.textView.setTextColor(Color.BLACK);
                }
            }
            else{
                holder.rbSelect.setChecked(false);
            }


        holder.ln_cautrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    for(int i=0;i<dapAnEntityList.size();i++){
                        if(dapAnEntity.getMaDA()==dapAnEntityList.get(i).getMaDA()){
                            dapAnEntityList.get(i).setDapAnChoose(1);
                        }
                        else{
                            dapAnEntityList.get(i).setDapAnChoose(0);
                        }
                    }

                notifyDataSetChanged();
            }
        });

    }

    @Override
    public int getItemCount() {

        return dapAnEntityList.size();

    }
    public class LTDapAnViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        RadioButton rbSelect;
        LinearLayout ln_cautrl;
        public LTDapAnViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.tv_cautraloi);
            rbSelect= itemView.findViewById(R.id.rdo_chondapan);
            ln_cautrl=itemView.findViewById(R.id.ln_cautrl);
        }
    }
}
