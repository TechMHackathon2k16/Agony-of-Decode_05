package com.gdg.aman.umyhacker;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

public class CustomLinuxOs extends Activity {

    ImageView atomFirst, chickenEggProb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_linux_os);

        atomFirst = (ImageView) findViewById(R.id.atomFirstTest);
        chickenEggProb = (ImageView) findViewById(R.id.chickenEggProblem);
        atomFirst.setImageResource(R.drawable.atomfirsttest);
        chickenEggProb.setImageResource(R.drawable.chickeneggproblem);
    }
}
