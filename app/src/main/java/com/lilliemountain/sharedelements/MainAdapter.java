package com.lilliemountain.sharedelements;


import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainHolder> {
    List<String> string, string1;
    public MainAdapter(List<String> strings,List<String> strings1)
    {
        this.string=strings;
        this.string1=strings1;
    }
    @NonNull
    @Override
    public MainHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_main,viewGroup,false);
        return new MainHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainHolder mainHolder, int i) {
        mainHolder.textView.setText(string.get(i));
        mainHolder.textView1.setText(string1.get(i));
    }

    @Override
    public int getItemCount() {
        return string.size();
    }

    public class MainHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView,textView1;
        public MainHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imageView);
            textView=itemView.findViewById(R.id.textView);
            textView1=itemView.findViewById(R.id.textView1);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), DetailActivity.class);
                    intent.putExtra("s",textView.getText().toString());
                    intent.putExtra("ss",textView1.getText().toString());
//                    Pair<View, String> p1 = Pair.create((View)imageView, "profile");
//                    Pair<View, String> p2 = Pair.create((View)textView, "textview");
//                    Pair<View, String> p3 = Pair.create((View)textView1, "textview1");
                    Activity activity=(Activity)v.getContext();
                    ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(activity, (View)imageView, "imageview");

//                    ActivityOptionsCompat options = ActivityOptionsCompat.
//                            makeSceneTransitionAnimation(activity, p1, p2, p3);
                    v.getContext().startActivity(intent, options.toBundle());
                }
            });
        }
    }
}
