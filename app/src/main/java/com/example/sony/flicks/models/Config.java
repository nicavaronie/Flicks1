package com.example.sony.flicks.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Config {
    // the base url for loading images
    String imageBaseUrl;
    // the poster size to use when fetching images, part of the url
    String posterSize;
    // the backdrop size to use when fetching images
    String backdropSize;
    private JSONArray images;
    // parse the backdrop sizes and use the option at index 1 or w780 as a fallback
    JSONArray backdropSizeOptions = images.getJSONArray("backdrop_sizes");
    backdropSize = backdropSizesOptions.optString(1, "w780");

    public Config(JSONObject object) throws JSONException {
        JSONObject images = object.getJSONObject("secure_base_url");
        // get the image base url
        imageBaseUrl = images.getString("secure_base_url");
        // get the poster size
        JSONArray posterSizeOptions = images.getJSONArray("poster_sizes");
        // use the position at index 3 or w342 as a fallback
        posterSize = posterSizeOptions.optString(3, "w342");
    }
    // helper method for creating urls
    public String getImageUrl(String size, String path){
        return String.format("%s%s%s", imageBaseUrl,size, path);// concatenate all three
    }
    public String getImageBaseUrl() {
        return imageBaseUrl;
    }

    public String getPosterSize() {
        return posterSize;
    }

    public String getBackdropSize() {
        return backdropSize;
    }
}
