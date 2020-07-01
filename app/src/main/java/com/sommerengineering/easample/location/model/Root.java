package com.sommerengineering.easample.location.model;

import com.google.gson.annotations.SerializedName;
import com.sommerengineering.easample.location.model.Location;

import java.util.List;

/**
 * Simple POJO that Retrofit automatically creates from the API response.
 */
public class Root {

    // consider the location endpoint at https://api-stage.greenlotstest.com/ocpi/cpo/2.1.1/locations
    // the hierarchy of this POJO and the response JSON must match
    // JSON fields can be omitted as long as the hierarchy is respected

    // retrofit maps the JSON array "data" to a Java List<> named "location"
    // the list holds Location objects, and we can continue with more and more POJO classes as needed
    @SerializedName("data")
    private List<Location> locations;
    public List<Location> getLocations() { return locations;}
    public void setLocations(List<Location> locations) { this.locations = locations; }
}
