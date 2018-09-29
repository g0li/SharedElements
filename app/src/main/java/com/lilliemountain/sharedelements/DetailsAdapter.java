package com.lilliemountain.sharedelements;


import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class DetailsAdapter extends RecyclerView.Adapter<DetailsAdapter.DetailsHolder> {
    List<String> string, string1;
    public DetailsAdapter(List<String> strings, List<String> strings1)
    {
        this.string=strings;
        this.string1=strings1;
    }
    @NonNull
    @Override
    public DetailsHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_details,viewGroup,false);
        return new DetailsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DetailsHolder detailsHolder, int i) {
        detailsHolder.textView.setText(string.get(i));
        detailsHolder.textView1.setText(string1.get(i));
    }

    @Override
    public int getItemCount() {
        return string.size();
    }

    public class DetailsHolder extends RecyclerView.ViewHolder {
        TextView textView,textView1;
        public DetailsHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.textView);
            textView1=itemView.findViewById(R.id.textView1);

        }
    }
}
