package com.bryce.yahooweatherapp.ui_classes;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bryce.yahooweatherapp.R;
import com.squareup.picasso.Picasso;

public class ForecastDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forecast_detail);

        //Retrieve intent extras
        Intent intent = this.getIntent();
        String date = intent.getExtras().getString("date");
        String code = intent.getExtras().getString("code");
        String highTemp = intent.getExtras().getString("highTemp");
        String lowTemp = intent.getExtras().getString("lowTemp");
        String weatherType = intent.getExtras().getString("weatherType");
        String tempUnit = intent.getExtras().getString("tempUnit");
        String yahooImageUrl = intent.getExtras().getString("yahooImageURL");

        //Set up UI
        setTitle(date);
        TextView weatherTypeTextView = (TextView) findViewById(R.id.weather_type_view);
        weatherTypeTextView.setText(weatherType);
        int resourceId = getResources().getIdentifier("drawable/icon_" + code, null, getPackageName());

        @SuppressWarnings("deprecation")
        Drawable weatherIconDrawable = getResources().getDrawable(resourceId);
        ImageView weatherTypeView = (ImageView) findViewById(R.id.weather_type_image_view);
        weatherTypeView.setImageDrawable(weatherIconDrawable);
        TextView highTempTextView = (TextView) findViewById(R.id.high_temp_text_view);
        String highTempUnit = "High: " + highTemp + tempUnit;
        highTempTextView.setText(highTempUnit);
        TextView lowTempTextView = (TextView) findViewById(R.id.low_temp_text_view);
        String lowTempUnit = "Low: " + lowTemp + tempUnit;
        lowTempTextView.setText(lowTempUnit);

        ImageView yahooImageView = (ImageView) findViewById(R.id.yahoo_image_view);
        Picasso.with(this).load(yahooImageUrl).placeholder(R.mipmap.ic_launcher).into(yahooImageView);

    }
}
