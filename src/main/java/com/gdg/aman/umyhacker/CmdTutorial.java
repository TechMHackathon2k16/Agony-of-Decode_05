package com.gdg.aman.umyhacker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class CmdTutorial extends Activity {

    ImageView cmdTutorial;
    String s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cmd_tutorial);
        s = "f1";

        cmdTutorial = (ImageView) findViewById(R.id.cmdTutorial);
        cmdTutorial.setImageResource(R.drawable.cmdtutorial);

        cmdTutorial.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(CmdTutorial.this, VideoScreen.class);
                intent.putExtra("cmd_type", s);
                startActivity(intent);
            }
        });
    }
}
