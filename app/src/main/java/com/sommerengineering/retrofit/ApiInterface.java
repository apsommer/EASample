package com.sommerengineering.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Simple interface definition that represents the relative portion of the API endpoint. The base URL is used when
 * instantiating the Retrofit object in the View.
 */
public interface ApiInterface {

    @GET ("changes/")
    Call<List<DataModel>> loadChanges(@Query("q") String status);
}
