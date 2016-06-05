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
 * Created by MANOJ on 03-06-2016.
 */
public class NetworkingTutorialAdapter extends ArrayAdapter<NetworkingBean> {

    private LayoutInflater inflater;

    public static class ViewHolder
    {
        public final TextView networkingName;
        public final ImageView networkingImages;

        public ViewHolder(View view)
        {
            networkingName = (TextView) view.findViewById(R.id.nameNetworkingRowLayout);
            networkingImages = (ImageView) view.findViewById(R.id.imageNetworkingRowLayout);
        }
    }

    public NetworkingTutorialAdapter(Context context, List<NetworkingBean> items)
    {
        super(context, R.layout.row_layout_networking, items);
        inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View view = convertView;
        if (view == null)
        {
            LayoutInflater vi = LayoutInflater.from(getContext());
            view = vi.inflate(R.layout.row_layout_networking, null);
        }
        final ViewHolder viewHolder = new ViewHolder(view);
        NetworkingBean networkingBean = getItem(position);

        viewHolder.networkingName.setText(networkingBean.getNetworkingBeanName());
        viewHolder.networkingImages.setImageResource(networkingBean.getNetworkingBeanImages());
        return view;
    }
}
