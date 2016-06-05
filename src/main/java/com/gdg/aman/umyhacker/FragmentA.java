package com.gdg.aman.umyhacker;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.VideoView;


public class FragmentA extends Fragment {

  /*  ImageView image1, image2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_a, container, false);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        image1 = (ImageView) getActivity().findViewById(R.id.imageView);
        image2 = (ImageView) getActivity().findViewById(R.id.imageView2);
        image1.setImageResource(R.drawable.first);
        image2.setImageResource(R.drawable.second);

        image1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), VideoScreen.class);
                intent.putExtra("first_type", "f1");
                intent.setFlags(1);
                startActivityForResult(intent, 10);
            }
        });
        image2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), VideoScreen.class);
                intent.putExtra("second_type", "f2");
                intent.setFlags(2);
                startActivityForResult(intent, 11);
            }
        });
    }*/
}
