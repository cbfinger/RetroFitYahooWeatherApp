package com.bryce.yahooweatherapp.model_classes;

import com.google.gson.JsonObject;

/**
 * Created by Bryce on 10/15/16.
 */

public class YWImageInfo {
    public String title;
    public int width;
    public int height;
    public String link;
    public String imageLocationURl;

    public YWImageInfo(JsonObject ywInfo) {
        this.title = ywInfo.get("title").getAsString();
        this.width = ywInfo.get("width").getAsInt();
        this.height = ywInfo.get("height").getAsInt();
        this.link = ywInfo.get("link").toString();
        this.imageLocationURl = ywInfo.get("url").getAsString();
    }
}
