package com.sommerengineering.easample.location.model;

import com.google.gson.annotations.SerializedName;
import com.sommerengineering.easample.location.model.Location;

import java.util.List;

/**
 * Simple POJO that Retrofit automatically creates from the API response.
 */
public class Root {

    // hierarchy of this POJO and response JSON must match
    // JSON fields can be omitted
    // retrofit automatically maps the JSON array to List<>
    // continue with more POJOs as needed
    @SerializedName("data")
    private List<Location> locations;
    public List<Location> getLocations() { return locations;}
    public void setLocations(List<Location> locations) { this.locations = locations; }
}