package com.sommerengineering.easample.location.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Simple POJO that Retrofit automatically creates from the API response.
 */

public class Location {

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
