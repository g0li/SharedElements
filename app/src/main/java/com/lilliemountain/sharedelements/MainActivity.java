package com.lilliemountain.sharedelements;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Explode;
import android.view.Window;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        getWindow().setExitTransition(new Explode());
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.rec);
        setTitle("Mozart's Symphonies");
        List<String> sss=new ArrayList<>();
        List<String> s=new ArrayList<>();
        sss.add("Symphony No. 1 in E-flat major, K. 16: I. Allegro molto");
        sss.add("Symphony No. 1 in E-flat major, K. 16: II. Andante");
        sss.add("Symphony No. 1 in E-flat major, K. 16: III. Presto");
        sss.add("Symphony No. 4 in D major, K. 19: I. Allegro");
        sss.add("Symphony No. 6 in F major, K. 43: I. Allegro");
        sss.add("Symphony No. 8 in D major, K. 48: IV. Allegro molto");

        s.add("Jaap ter Lindan, Mozart Akademie");
        s.add("Jaap ter Lindan, Mozart Akademie");
        s.add("Jaap ter Lindan, Mozart Akademie");
        s.add("Jaap ter Lindan, Mozart Akademie");
        s.add("Jaap ter Lindan, Mozart Akademie");
            s.add("Jaap ter Lindan, Mozart Akademie");
            MainAdapter mA=new MainAdapter(sss,s);
            recyclerView.setAdapter(mA);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onBackPressed() {
    }
}
