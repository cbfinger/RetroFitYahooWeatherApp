package com.bryce.yahooweatherapp.ui_classes;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.bryce.yahooweatherapp.R;
import com.bryce.yahooweatherapp.YahooWeatherInterface;
import com.bryce.yahooweatherapp.model_classes.Channel;
import com.bryce.yahooweatherapp.model_classes.Forecast;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ForecastActivity extends AppCompatActivity {

    public static String LOG_TAG = "Weather Retrieval";
    private Context forecastContext;
    private ListView forecastListView;
    private ArrayList<Forecast> forecastList;
    private Channel weatherChannel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forcast);
        retrieveWeatherInformation("Nome, Ak");
        forecastContext = this;
        forecastListView = (ListView) findViewById(R.id.weekly_forecast_list);
        forecastListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Forecast selectedForecast = forecastList.get(position);

                Intent detailIntent = new Intent(forecastContext, ForecastDetailActivity.class);

                detailIntent.putExtra("date", selectedForecast.date);
                detailIntent.putExtra("code", selectedForecast.code);
                String highTempString = new Integer(selectedForecast.highTemp).toString();
                detailIntent.putExtra("highTemp", highTempString);
                String lowTempString = new Integer(selectedForecast.lowTemp).toString();
                detailIntent.putExtra("lowTemp", lowTempString);
                detailIntent.putExtra("weatherType", selectedForecast.weatherType);
                detailIntent.putExtra("tempUnit", weatherChannel.units.temperature);
                detailIntent.putExtra("yahooImageURL", weatherChannel.ywImageInfo.imageLocationURl);

                startActivity(detailIntent);
            }
        });

        EditText searchTextFeild = (EditText) findViewById(R.id.search_text);
        searchTextFeild.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction()==KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                    String locationString = ((EditText) findViewById(R.id.search_text)).getText().toString();
                    retrieveWeatherInformation(locationString);
                    return true;
                }
                return false;
            }
        });


    }

    public void retrieveWeatherInformation (String location){
        String query = String.format("select * from weather.forecast where woeid in (select woeid from geo.places(1) where text=\"%s\")", location);
        Map<String, String> data = new HashMap<>();
        data.put("format", "json");
        data.put("q", query);
        YahooWeatherInterface weatherService = YahooWeatherInterface.retrofit.create(YahooWeatherInterface.class);
        final Call<JsonObject> weatherInfo = weatherService.getWeather(data);
        weatherInfo.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                Log.d(LOG_TAG, "Reached this place");
                if (!response.isSuccessful()) {
                    Log.d(LOG_TAG, "No Success");
                }

                JsonObject query = response.body().getAsJsonObject("query");
                int resultsCount = query.get("count").getAsInt();
                if (resultsCount == 0){
                    Toast toast = Toast.makeText(getApplicationContext(), getString(R.string.no_locations_found), Toast.LENGTH_LONG);
                    toast.show();
                    return;
                }else{
                    JsonObject results = query.getAsJsonObject("results");

                    weatherChannel = new Channel(results.getAsJsonObject("channel"));
                    String titleString = weatherChannel.location.city + ", " + weatherChannel.location.region + ", " + weatherChannel.location.country;
                    setTitle(titleString);

                    forecastList = weatherChannel.item.forecasts;
    
                    ForecastAdapter adapter = new ForecastAdapter(forecastContext, forecastList);
                    forecastListView.setAdapter(adapter);
                }


            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {

                    Log.d(LOG_TAG, "Failed");
            }
        });


    }
}
