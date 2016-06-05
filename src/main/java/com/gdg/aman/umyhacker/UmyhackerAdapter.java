package com.gdg.aman.umyhacker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by MANOJ on 02-06-2016.
 */
public class UmyhackerAdapter extends ArrayAdapter<UmyhackerPojo> {

    ImageView database;


  /*  private LayoutInflater inflater;

    public static class ViewHolder
    {
        public final TextView name;
        public final ImageView image;

        public ViewHolder(View view)
        {
            name = (TextView) view.findViewById(R.id.name);
            image = (ImageView) view.findViewById(R.id.image);
        }
    }

    public UmyhackerAdapter(Context context, List<UmyhackerPojo> items)
    {
        super(context, R.layout.row_layout, items);
        inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View view = convertView;
        if (view == null)
        {
            LayoutInflater vi = LayoutInflater.from(getContext());
            view = vi.inflate(R.layout.row_layout, null);
        }

        final ViewHolder viewHolder = new ViewHolder(view);
        UmyhackerPojo umyhackerPojo = getItem(position);

        viewHolder.name.setText(umyhackerPojo.getName());
        viewHolder.image.setImageResource(umyhackerPojo.getImages());

        return view;
    }*/

    private LayoutInflater inflater;

    public static class ViewHolder
    {
        public final TextView name1;
        public final ImageView image1;
        public final TextView name2;
        public final ImageView image2;

        public ViewHolder(View view)
        {
            name1 = (TextView) view.findViewById(R.id.name1);
            image1 = (ImageView) view.findViewById(R.id.image1);
            name2 = (TextView) view.findViewById(R.id.name2);
            image2 = (ImageView) view.findViewById(R.id.image2);
        }
    }

    public UmyhackerAdapter(Context context, List<UmyhackerPojo> items)
    {
        super(context, R.layout.row_layout, items);
        inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {

      /*  if (convertView == null)
        {
            ViewHolder viewHolder;
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_layout, parent, false);
            viewHolder = new ViewHolder(convertView);
            viewHolder.image2 = (ImageView) convertView.findViewById(R.id.image2);
        }*/

        View view = convertView;
        if (view == null)
        {
            LayoutInflater vi = LayoutInflater.from(getContext());
            view = vi.inflate(R.layout.row_layout, null);
        }
        final ViewHolder viewHolder = new ViewHolder(view);
        UmyhackerPojo umyhackerPojo = getItem(position);

        viewHolder.name1.setText(umyhackerPojo.getName1());
        viewHolder.name2.setText(umyhackerPojo.getName2());
        viewHolder.image1.setImageResource(umyhackerPojo.getImage1());
        viewHolder.image2.setImageResource(umyhackerPojo.getImage2());
        return view;
    }
}
