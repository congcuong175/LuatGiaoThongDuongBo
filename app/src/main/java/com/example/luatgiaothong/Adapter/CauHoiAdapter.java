package com.example.luatgiaothong.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.luatgiaothong.Entity.CauHoiEntity;
import com.example.luatgiaothong.Entity.MeoThi;
import com.example.luatgiaothong.R;
import com.ramotion.foldingcell.FoldingCell;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CauHoiAdapter extends RecyclerView.Adapter<CauHoiAdapter.CauHoiViewHolder>{
    private Context mContext;
    private ArrayList<CauHoiEntity> cauHoiEntities;

    public CauHoiAdapter(Context mContext) {
        this.mContext = mContext;
    }
    public void setData(ArrayList<CauHoiEntity> cauHoiEntities)
    {
        this.cauHoiEntities=cauHoiEntities;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CauHoiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cauhoi,parent,false);
        return new CauHoiAdapter.CauHoiViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull CauHoiViewHolder holder, @SuppressLint("RecyclerView") int position) {
        CauHoiEntity cauHoiEntity=cauHoiEntities.get(position);

        if(cauHoiEntity==null){
            return;
        }
        holder.tv_CauHoi.setText("Câu "+cauHoiEntity.getMaCH()+": " +cauHoiEntity.getNoiDung());
        if(cauHoiEntity.getHinhAnh()!=null && !cauHoiEntity.getHinhAnh().equals("")){
            holder.img_CauHoi.setVisibility(View.VISIBLE);
            Glide.with(mContext).load(cauHoiEntity.getHinhAnh()).into(holder.img_CauHoi);
        }
        else {
            holder.img_CauHoi.setVisibility(View.GONE);
        }
        DapAnAdapter adapter=new DapAnAdapter(cauHoiEntity.getDapAnEntities(),R.layout.item_cautraloi,mContext);
        holder.list_CauTRL.setAdapter(adapter);
        holder.list_CauTRL.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                adapter.setSelectedIndex(i);
                adapter.notifyDataSetChanged();
                if(adapter.kiemTraDA()==1){
                    cauHoiEntities.get(position).setKtdung(true);
                }
                else {
                    cauHoiEntities.get(position).setKtdung(false);
                }
            }
        });
    }
    public int getCauTraLoiDung(){
        int dem=0;
        for(CauHoiEntity ch: cauHoiEntities){
            if(ch.isKtdung()){
                dem++;
            }
        }
        return dem;
    }

    @Override
    public int getItemCount() {
        if(cauHoiEntities==null){
            return 0;
        }
        else {
            return cauHoiEntities.size();
        }
    }


    public class CauHoiViewHolder extends RecyclerView.ViewHolder {
       private TextView tv_CauHoi;
       private ImageView img_CauHoi;
       private ListView list_CauTRL;

        public CauHoiViewHolder(@NonNull View itemView) {
            super(itemView);
           tv_CauHoi=itemView.findViewById(R.id.tv_cauhoi);
           img_CauHoi=itemView.findViewById(R.id.img_cauhoi);
           list_CauTRL=itemView.findViewById(R.id.lv_cautraloi);

        }
    }
}
