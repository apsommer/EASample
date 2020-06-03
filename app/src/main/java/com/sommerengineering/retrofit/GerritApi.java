package com.sommerengineering.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Simple interface definition that represents the relative portion of the API endpoint
 */
public interface GerritApi {

    @GET
    Call<List<Change>> loadChanges(@Query("q") String status);
}
