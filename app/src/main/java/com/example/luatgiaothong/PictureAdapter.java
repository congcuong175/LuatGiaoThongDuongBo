package com.example.luatgiaothong;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PictureAdapter extends RecyclerView.Adapter<PictureAdapter.Picture_viewhoder> {
    List<Integer> list;
    Context context;

    public PictureAdapter(List<Integer> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Picture_viewhoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.imageadapter,parent,false);
        return new Picture_viewhoder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Picture_viewhoder holder, int position) {
       // Picasso.get().load(list.get(position)).into(holder.img_voucher);
       holder.img_voucher.setImageResource(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Picture_viewhoder extends RecyclerView.ViewHolder {

        ImageView img_voucher;
        public Picture_viewhoder(@NonNull View itemView) {
            super(itemView);
            img_voucher=itemView.findViewById(R.id.img);
        }
    }
}
