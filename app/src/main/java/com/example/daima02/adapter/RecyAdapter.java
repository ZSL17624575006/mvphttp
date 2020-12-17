package com.example.daima02.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.daima02.R;
import com.example.daima02.data.AnewsListBean;

import java.util.List;

public class RecyAdapter extends RecyclerView.Adapter<RecyAdapter.ViewHolder> {
    private Context context;
    private List<AnewsListBean.NewsBean> newslist;

    public RecyAdapter(Context context, List<AnewsListBean.NewsBean> newslist) {
        this.context = context;
        this.newslist = newslist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_item1, null, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        AnewsListBean.NewsBean newsDTO = newslist.get(position);
        holder.name.setText(newsDTO.getContent());
        holder.title.setText(newsDTO.getTile());
        Glide.with(holder.image).load(newsDTO.getImageUrl()).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return newslist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView image;
        private final TextView title;
        private final TextView name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.item1_image);
            title = itemView.findViewById(R.id.item1_title);
            name = itemView.findViewById(R.id.item1_name);
        }
    }
}
