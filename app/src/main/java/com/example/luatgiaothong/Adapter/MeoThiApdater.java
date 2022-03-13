package com.example.luatgiaothong.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.luatgiaothong.Entity.MeoThi;
import com.example.luatgiaothong.R;
import com.ramotion.foldingcell.FoldingCell;

import java.util.ArrayList;

public class MeoThiApdater extends RecyclerView.Adapter<MeoThiApdater.MeoThiViewHolder> {
    private Context mContext;
    private ArrayList<MeoThi> meoThis;

    public MeoThiApdater(Context mContext) {
        this.mContext = mContext;

    }
    public void setData(ArrayList<MeoThi> meos)
    {
        this.meoThis=meos;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MeoThiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_meothi,parent,false);
        return new MeoThiViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MeoThiViewHolder holder, int position) {
        MeoThi meoThi=meoThis.get(position);
        if(meoThi==null){
            return;
        }
        holder.tvTitle.setText(meoThi.getTitle());
        holder.tvContent.setText(meoThi.getContent());
        holder.foldingCell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.foldingCell.toggle(false);
            }
        });
    }

    @Override
    public int getItemCount() {
        if(meoThis==null){
            return 0;
        }
        else {
            return meoThis.size();
        }

    }

    public class MeoThiViewHolder extends RecyclerView.ViewHolder {
        private FoldingCell foldingCell;
        private TextView tvTitle, tvContent;

        public MeoThiViewHolder(@NonNull View itemView) {
            super(itemView);
            foldingCell = itemView.findViewById(R.id.folding_cell);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvContent = itemView.findViewById(R.id.tv_content);

        }
    }
}
