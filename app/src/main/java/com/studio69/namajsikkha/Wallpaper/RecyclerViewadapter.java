package com.studio69.namajsikkha.Wallpaper;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.studio69.namajsikkha.R;

import java.util.List;

public class RecyclerViewadapter extends RecyclerView.Adapter<RecyclerViewadapter.ImageViewHolder> {

    List<CustomsItem> customItemsList;

    Context context;

    public RecyclerViewadapter(List<CustomsItem> customItemsList, Context context) {
        this.customItemsList = customItemsList;
        this.context = context;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater=LayoutInflater.from(context);
        View view=layoutInflater.inflate(R.layout.custom_layout,parent,false);

        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {

        Glide.with(context).load(customItemsList.get(position).getUrl()).diskCacheStrategy(DiskCacheStrategy.ALL).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return customItemsList.size();
    }




    public class ImageViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView imageView;

        public ImageViewHolder(@NonNull View itemView) {

            super(itemView);
            imageView=itemView.findViewById(R.id.image_id);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

            Intent intent=new Intent(context, ViewActivity.class);
            intent.putExtra("images",customItemsList.get(getAdapterPosition()).getUrl());
            context.startActivity(intent);

        }
    }
}

