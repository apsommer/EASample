package com.sommerengineering.easample.location;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

/**
 * Simple interface definition that represents the relative portion of the API endpoint. The base URL is used when
 * instantiating the Retrofit object.
 */
public interface LocationRetrofit {

    @GET ("location")
    Call<Root> getLocations(@Header("Authorization") String token);
}
