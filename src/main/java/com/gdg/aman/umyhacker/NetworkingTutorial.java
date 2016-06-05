package com.gdg.aman.umyhacker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class NetworkingTutorial extends Activity {

    String s1, s2, s3, s4;

    ListView networkingListView;
    public static List<NetworkingBean> items = new ArrayList<>();
    ArrayAdapter<NetworkingBean> myArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_networking_tutorial);

        createData();

        networkingListView = (ListView) findViewById(R.id.networkingListView);
        myArrayAdapter = new NetworkingTutorialAdapter(NetworkingTutorial.this, items);
        networkingListView.setAdapter(myArrayAdapter);

        s1 = "f2";
        s2 = "f3";
        s3 = "f4";
        s4 = "f5";

        networkingListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                if ( position == 0)
                {
                    Intent intent = new Intent(NetworkingTutorial.this, VideoScreen.class);
                    intent.putExtra("first_type_networking", s1);
                    startActivity(intent);
                }
                if ( position == 1)
                {
                    Intent intent = new Intent(NetworkingTutorial.this, VideoScreen.class);
                    intent.putExtra("second_type_networking", s2);
                    startActivity(intent);
                }
                if ( position == 2)
                {
                    Intent intent = new Intent(NetworkingTutorial.this, VideoScreen.class);
                    intent.putExtra("third_type_networking", s3);
                    startActivity(intent);
                }
                if ( position == 3)
                {
                    Intent intent = new Intent(NetworkingTutorial.this, VideoScreen.class);
                    intent.putExtra("fourth_type_networking", s4);
                    startActivity(intent);
                }
            }
        });

    }

    public void createData()
    {
        NetworkingBean bean1 = new NetworkingBean(R.drawable.virtualprivatenetwork, "Virtual Private network");
        NetworkingBean bean2 = new NetworkingBean(R.drawable.accessblockedsitevpn, "How to access blocked site");
        NetworkingBean bean3 = new NetworkingBean(R.drawable.bandwidthnetworking, "Bandwidth in networking?");
        NetworkingBean bean4 = new NetworkingBean(R.drawable.tcpvsudp, "TCP vs UDP");

        items.add(bean1);
        items.add(bean2);
        items.add(bean3);
        items.add(bean4);

    }
}
