package com.bd.testimoniidi.Adapter;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bd.testimoniidi.*;
import com.bd.testimoniidi.model.RecyclerData;

import java.util.List;

public class AdapterReview extends RecyclerView.Adapter<AdapterReview.ViewHolder> {

    public class ViewHolder extends RecyclerView.ViewHolder {
        public View list_item;
        public TextView txtNama;
        public TextView txtUlasan;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            list_item = (View) itemView.findViewById(R.id.cardView);
            txtNama = (TextView) itemView.findViewById(R.id.txtNama);
            txtUlasan = (TextView) itemView.findViewById(R.id.txtUlasan);
        }
    }

    private List<RecyclerData> mRecyclerData;
    public AdapterReview(List<RecyclerData> data){
        mRecyclerData = data;
    }

    @NonNull
    @Override
    public AdapterReview.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context =parent.getContext();
        LayoutInflater inflater =LayoutInflater.from(context);

        View contactView = inflater.inflate(R.layout.list_item, parent, false);

        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterReview.ViewHolder holder, int position) {
        final RecyclerData data = mRecyclerData.get(position);

        TextView txtTitle = holder.txtNama;
        txtTitle.setText(data.getNama());
        TextView txtDescription = holder.txtUlasan;
        txtDescription.setText(data.getUlasan());

        holder.list_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), AddReview.class);
                i.putExtra("1234", data.getNama().toString());
                i.putExtra("123", data.getUlasan().toString());
                v.getContext().startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mRecyclerData.size();
    }

}
