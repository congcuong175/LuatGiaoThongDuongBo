package com.example.luatgiaothong.Adapter;

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
import static com.example.luatgiaothong.ThiFragment.click;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.luatgiaothong.Entity.CauHoiEntity;
import com.example.luatgiaothong.Entity.DapAnEntity;
import com.example.luatgiaothong.Entity.MeoThi;
import com.example.luatgiaothong.R;
import com.example.luatgiaothong.ThiFragment;
import com.ramotion.foldingcell.FoldingCell;
import com.squareup.picasso.Picasso;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class CauHoiAdapter extends RecyclerView.Adapter<CauHoiAdapter.CauHoiViewHolder>{
    private Context mContext;
    private List<CauHoiEntity> cauHoiEntities;
    public DapAnAdapter adapter;
    public CauHoiAdapter(Context mContext) {
        this.mContext = mContext;
    }
    public void setData(List<CauHoiEntity> cauHoiEntities)
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
        holder.tv_CauHoi.setText("Câu "+(position+1)+": " +cauHoiEntity.getNoiDung());
        holder.tv_cauhoiso.setText("Câu hỏi "+(position+1)+"/"+cauHoiEntities.size());
        if(cauHoiEntity.getHinhAnh()!=null && !cauHoiEntity.getHinhAnh().equals("")){
            holder.img_CauHoi.setVisibility(View.VISIBLE);
            Glide.with(mContext).load(cauHoiEntity.getHinhAnh()).into(holder.img_CauHoi);
        }
        else {
            holder.img_CauHoi.setVisibility(View.GONE);
        }
        adapter=new DapAnAdapter(cauHoiEntity.getDapAnEntities());
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


    public class CauHoiViewHolder extends RecyclerView.ViewHolder {
       private TextView tv_CauHoi,tv_cauhoiso;
       private ImageView img_CauHoi;
       private RecyclerView list_CauTRL;
       private LinearLayout ln_bottom_sheet;
        public CauHoiViewHolder(@NonNull View itemView) {
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
            Integer[] arr=new Integer[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35};
            ArrayAdapter<Integer> adapter=new ArrayAdapter<>(mContext, android.R.layout.simple_list_item_1,arr);
            grv_listCauHoi.setAdapter(adapter);
            grv_listCauHoi.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    ThiFragment.scolltoPager(i);
                    dialog.hide();
                }
            });
    }
}
