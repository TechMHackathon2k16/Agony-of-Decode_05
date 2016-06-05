package com.gdg.aman.umyhacker;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

public class RecentUpload extends Activity {

    ImageView image1, image2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recent_upload);

        image1 = (ImageView) findViewById(R.id.imageView);
        image2 = (ImageView) findViewById(R.id.imageView2);
        image1.setImageResource(R.drawable.to_delete_windows_old);
        image2.setImageResource(R.drawable.limited_wifi);
    }
}
