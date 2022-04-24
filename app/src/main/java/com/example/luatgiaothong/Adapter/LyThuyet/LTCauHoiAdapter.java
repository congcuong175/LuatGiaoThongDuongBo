package com.example.luatgiaothong.Adapter.LyThuyet;


import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.luatgiaothong.Adapter.DapAnAdapter;
import com.example.luatgiaothong.Entity.CauHoiEntity;
import com.example.luatgiaothong.Entity.DapAnEntity;
import com.example.luatgiaothong.Entity.MeoThi;
import com.example.luatgiaothong.HocLyThuyet;
import com.example.luatgiaothong.R;
import com.example.luatgiaothong.ThiFragment;
import com.ramotion.foldingcell.FoldingCell;
import com.squareup.picasso.Picasso;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LTCauHoiAdapter extends RecyclerView.Adapter<LTCauHoiAdapter.LTCauHoiViewHolder>{
    private Context mContext;
    private ArrayList<CauHoiEntity> cauHoiEntities;
    public LTDapAnAdapter adapter;
    public LTCauHoiAdapter(Context mContext) {
        this.mContext = mContext;
    }
    public void setData(ArrayList<CauHoiEntity> cauHoiEntities)
    {
        this.cauHoiEntities=cauHoiEntities;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public LTCauHoiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cauhoi,parent,false);
        return new LTCauHoiViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull LTCauHoiViewHolder holder, @SuppressLint("RecyclerView") int position) {
        CauHoiEntity cauHoiEntity=cauHoiEntities.get(position);

        if(cauHoiEntity==null){
            return;
        }
        holder.tv_CauHoi.setText("Câu "+cauHoiEntity.getMaCH()+": " +cauHoiEntity.getNoiDung());
        holder.tv_cauhoiso.setText("Câu hỏi "+(position+1)+"/"+cauHoiEntities.size());
        if(cauHoiEntity.getHinhAnh()!=null && !cauHoiEntity.getHinhAnh().equals("")){
            holder.img_CauHoi.setVisibility(View.VISIBLE);
            Glide.with(mContext).load(cauHoiEntity.getHinhAnh()).into(holder.img_CauHoi);
        }
        else {
            holder.img_CauHoi.setVisibility(View.GONE);
        }
        adapter=new LTDapAnAdapter(cauHoiEntity.getDapAnEntities());
        holder.list_CauTRL.setAdapter(adapter);
        holder.list_CauTRL.setLayoutManager(new LinearLayoutManager(mContext, RecyclerView.VERTICAL, false));
        holder.ln_bottom_sheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDiaglog();
            }
        });
    }
    public int getCauTraLoiDung(){
        int dem=0;
        for(CauHoiEntity ch: cauHoiEntities){
            for(DapAnEntity da: ch.getDapAnEntities()){
                if(da.getKiemTra()){
                    if(da.getDapAnChoose()==1){
                        dem++;
                    }
                }
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


    public class LTCauHoiViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_CauHoi,tv_cauhoiso;
        private ImageView img_CauHoi;
        private RecyclerView list_CauTRL;
        private LinearLayout ln_bottom_sheet;
        public LTCauHoiViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_CauHoi=itemView.findViewById(R.id.tv_cauhoi);
            tv_cauhoiso=itemView.findViewById(R.id.tv_cauhoiso);
            img_CauHoi=itemView.findViewById(R.id.img_cauhoi);
            list_CauTRL=itemView.findViewById(R.id.lv_cautraloi);
            ln_bottom_sheet=itemView.findViewById(R.id.ln_bottom_sheet);

        }
    }
    private void showDiaglog(){
        Dialog dialog=new Dialog(mContext);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.bottomsheet);
        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations=R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);
        GridView grv_listCauHoi=dialog.findViewById(R.id.grv_listCauHoi);
        List<Integer> arr=new LinkedList<>();
        for (int i=0;i<cauHoiEntities.size();i++)
        {
            arr.add(i+1);
        }
        ArrayAdapter<Integer> adapter=new ArrayAdapter<>(mContext, android.R.layout.simple_list_item_1,arr);
        grv_listCauHoi.setAdapter(adapter);
        //adapter.notifyDataSetChanged();
        grv_listCauHoi.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                HocLyThuyet.scolltoPager(i);
                dialog.hide();
            }
        });
    }
}

