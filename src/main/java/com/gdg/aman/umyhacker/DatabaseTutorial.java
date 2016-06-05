package com.gdg.aman.umyhacker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class DatabaseTutorial extends Activity {

    ImageView databasetutorial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_tutorial);

        databasetutorial = (ImageView) findViewById(R.id.databaseTutorial);
        databasetutorial.setImageResource(R.drawable.databasetutorial);

        databasetutorial.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(DatabaseTutorial.this, VideoScreen.class);
                intent.putExtra("second_type", "f2");
                intent.setFlags(1);
                startActivity(intent);
            }
        });
    }
}
