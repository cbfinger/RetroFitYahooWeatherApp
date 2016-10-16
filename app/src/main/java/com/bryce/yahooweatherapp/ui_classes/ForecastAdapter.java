package com.bryce.yahooweatherapp.ui_classes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bryce.yahooweatherapp.R;
import com.bryce.yahooweatherapp.model_classes.Forecast;

import java.util.ArrayList;

/**
 * Created by Bryce on 10/15/16.
 */

public class ForecastAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mInflater;
    private ArrayList<Forecast> mDataSource;

    public ForecastAdapter(Context context, ArrayList<Forecast> items) {
        mContext = context;
        mDataSource = items;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mDataSource.size();
    }

    @Override
    public Object getItem(int position) {
        return mDataSource.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get view for row item and retrieve elements

        View rowView = mInflater.inflate(R.layout.forecast_item_row, parent, false);
        TextView titleTextView =
                (TextView) rowView.findViewById(R.id.forecast_list_title);
        TextView subtitleTextView =
                (TextView) rowView.findViewById(R.id.forecast_list_subtitle);

        Forecast forecast = (Forecast) getItem(position);


        titleTextView.setText(forecast.date);
        subtitleTextView.setText(forecast.weatherType);

        return rowView;
    }

}
