package com.example.daima02.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.daima02.R;
import com.example.daima02.data.AstudentBean;

import java.util.List;

public class RecyclAdapter extends RecyclerView.Adapter<RecyclAdapter.ViewHolder> {
    private Context context;
    private List<AstudentBean.StudenlistBean> studenlist;

    public RecyclAdapter(Context context, List<AstudentBean.StudenlistBean> studen) {
        this.context = context;
        this.studenlist = studen;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_item2, null, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        AstudentBean.StudenlistBean studenlistDTO = studenlist.get(position);
        holder.title.setText("姓名："+studenlistDTO.getName());
        holder.name1.setText("机试成绩："+studenlistDTO.getSkill()+"分");
        holder.name2.setText("理论成绩："+studenlistDTO.getTheory()+"分");

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                studenlist.remove(position);
                notifyDataSetChanged();
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return studenlist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView title;
        private final TextView name1;
        private final TextView name2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.item2_1);
            name1 = itemView.findViewById(R.id.item2_2);
            name2 = itemView.findViewById(R.id.item2_3);
        }
    }
}
