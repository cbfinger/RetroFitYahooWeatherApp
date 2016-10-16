package com.bryce.yahooweatherapp;

import com.google.gson.JsonObject;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by Bryce on 10/13/16.
 */

public interface YahooWeatherInterface {

    @GET("v1/public/yql")
    Call<JsonObject> getWeather(@QueryMap Map<String, String> queryMap);

    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://query.yahooapis.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

}
