package com.sommerengineering.sample;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Simple POJO that Retrofit automatically creates from the API response.
 */
class DataModel {

    // consider the locations endpoint at https://api-stage.greenlotstest.com/ocpi/cpo/2.1.1/locations
    // the hierarchy of this POJO and the response JSON must match
    // JSON fields can be omitted as long as the hierarchy is respected

    // retrofit maps the JSON array "data" to a Java List<> named "locations"
    // the list holds Location objects, and we can continue with more and more POJO classes as needed
    @SerializedName("data")
    private List<Location> locations;
    public List<Location> getLocations() { return locations;}
    public void setLocations(List<Location> locations) { this.locations = locations; }
}

class Location {

    // for this class the Java attribute names are the same as JSON keys, so no need for the @SerializedName annotation
    // getters and setters of the same name as the attribute are required, strict naming convention

    private String id;
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    private String name;
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    private String address;
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
}
