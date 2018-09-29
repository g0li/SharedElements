package com.lilliemountain.sharedelements;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Explode;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class DetailActivity extends AppCompatActivity {
    TextView textView,textView1;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        getWindow().setEnterTransition(new Explode());
        setContentView(R.layout.activity_detail);
        textView=findViewById(R.id.textView);
        textView1=findViewById(R.id.textView1);
        textView.setText(getIntent().getStringExtra("s"));
        textView1.setText(getIntent().getStringExtra("ss"));
        setTitle(getIntent().getStringExtra("s"));

        textView1.setVisibility(View.VISIBLE);
        textView1.setAlpha(0.0f);
        textView1.animate()
                .translationY(textView1.getHeight())
                .alpha(1.0f)
                .setListener(null);

        textView.setVisibility(View.VISIBLE);
        textView.setAlpha(0.0f);
        textView.animate()
                .translationY(textView1.getHeight())
                .alpha(1.0f)
                .setListener(null);


        List<String> sss=new ArrayList<>();
        List<String> s=new ArrayList<>();
        sss.add("Trivia");
        sss.add("Goofs");
        sss.add("Quotes");
        sss.add("Crazy Credits");
        sss.add("Connections");
        sss.add("Soundtracks");

        s.add("The film crossed worldwide Box Office collection of $1 Billion in a record time of 11 days after its release. This is the sixth Marvel movie to make this much.");
        s.add("Featured in Avengers: Infinity War - Strange Alchemy (2018)");
        s.add("Black Panther Theme \n" + "Written by Ludwig Göransson ");
        s.add("The first time we see Tony Stark, he is walking with Pepper Potts in a park, discussing. Tony has a hoodie on his shoulders, its sleeves tied in a knot covering the miniature arc reactor on his chest. During their exchange, Pepper unties the knot to talk about the device on Tony's chest. Right after that, cutting from a three-quarters shot to a close up on Tony, the hoodie disappears and is nowhere to be seen for the remainder of the scene, up till the moment we are taken inside the Sanctum Sanctorum.");
        s.add("[first lines] \n" + "Asgardian Distress Call: This is the Asgardian refugee vessel Statesman. We are under assault. I repeat, we are under assault. The engines are dead, life support failing. Requesting aid from any vessel within range. We are 22 jump points out of Asgard. Our crew is made up of Asgardian families. We have very few soldiers here. This is not a warcraft. I repeat, this is not a warcraft! ");
        s.add("The closing credits appear over a black background. The film title appears at the end, and crumbles into ash.");
        recyclerView=findViewById(R.id.rec);

        DetailsAdapter dA=new DetailsAdapter(sss,s);
        recyclerView.setAdapter(dA);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                supportFinishAfterTransition();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        supportFinishAfterTransition();
    }
}
