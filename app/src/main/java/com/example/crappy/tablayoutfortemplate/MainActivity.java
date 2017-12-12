package com.example.crappy.tablayoutfortemplate;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TabHost;

public class MainActivity extends AppCompatActivity {
    TabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabHost = findViewById(R.id.tabHost);
        tabHost.setup();
        //Tab 1
        TabHost.TabSpec spec = tabHost.newTabSpec(getResources().getString(R.string.tab1_title_name));
        spec.setContent(R.id.tab1);
        spec.setIndicator(getResources().getString(R.string.tab1_title_name));
        tabHost.addTab(spec);

        //tab2
        spec = tabHost.newTabSpec(getResources().getString(R.string.tab2_title_name));
        spec.setContent(R.id.tab2);
        spec.setIndicator(getResources().getString(R.string.tab2_title_name));
        tabHost.addTab(spec);

        //tab3
        spec = tabHost.newTabSpec(getResources().getString(R.string.tab3_title_name));
        spec.setContent(R.id.tab3);
        spec.setIndicator(getResources().getString(R.string.tab3_title_name));
        tabHost.addTab(spec);


        // Event
        tabHost.setOnTabChangedListener(new AnimationTabListener(this,tabHost));

    }
}
