package com.ahmadrosid.belajarrealm.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ahmadrosid.belajarrealm.R;
import com.ahmadrosid.belajarrealm.models.DataModel;

import java.util.ArrayList;

/**
 * Created by ocittwo on 1/19/16.
 */
public class AdapterArticle extends RecyclerView.Adapter<AdapterArticle.ViewHolder> {


    private final OnItemClickListener listener;
    private ArrayList<DataModel> data;

    public AdapterArticle(ArrayList<DataModel> data, OnItemClickListener listener) {
        this.data = data;
        this.listener = listener;
    }

    @Override
    public AdapterArticle.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_artikel, null);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(AdapterArticle.ViewHolder holder, int position) {
        holder.click(data.get(position), listener);
        holder.tvId.setText(String.valueOf(data.get(position).getId()));
        holder.title.setText(data.get(position).getTitle());
        holder.description.setText(data.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvId, title, description;

        public ViewHolder(View itemView) {
            super(itemView);
            tvId = (TextView) itemView.findViewById(R.id.tvId);
            title = (TextView) itemView.findViewById(R.id.tvTitle);
            description = (TextView) itemView.findViewById(R.id.tvDescription);
        }

        public void click(final DataModel dataModel, final OnItemClickListener listener){
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClick(dataModel);
                }
            });
        }
    }

    public interface OnItemClickListener{
        void onClick(DataModel item);
    }

}
