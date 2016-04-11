package com.example.android.sunshine.app;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WeatherDataParser {

    /**
     * Given a string of the form returned by the api call:
     * http://api.openweathermap.org/data/2.5/forecast/daily?q=94043&mode=json&units=metric&cnt=7
     * retrieve the maximum temperature for the day indicated by dayIndex
     * (Note: 0-indexed, so 0 would refer to the first day).
     */
    public static double getMaxTemperatureForDay(String weatherJsonStr, int dayIndex)
            throws JSONException {
        // TODO: add parsing code here
        double maxTemp = 0.0;
        JSONObject joRoot = new JSONObject(weatherJsonStr);

        JSONArray ja = new JSONArray();
        ja = joRoot.optJSONArray("list");
        JSONObject joDay = new JSONObject();
        joDay = ja.getJSONObject(dayIndex);
        JSONObject joTemp = new JSONObject();
        joTemp = joDay.getJSONObject("temp");
        maxTemp = joTemp.getDouble("max");

        return maxTemp;
    }

}

