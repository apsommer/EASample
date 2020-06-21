package com.sommerengineering.easample.location;

import android.util.Log;
import androidx.lifecycle.MutableLiveData;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sommerengineering.easample.BuildConfig;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Repository manages the network API calls and retrieval from db cache. It supplies data to the ViewModel via exposure
 * of a LiveData observable.
 */
public class LocationRepo implements Callback<Root> {

    // constants
    final String TAG = getClass().getSimpleName() + " ~~ ";
    final String BASE_URL = "https://api-stage.greenlotstest.com/ocpi/cpo/2.1.1/";

    // livedata is an observable that automatically respects its observers' lifecycles
    MutableLiveData<List<Location>> mutableLiveData = new MutableLiveData<>();

    // viewmodel requests formatted POJO's
    public MutableLiveData<List<Location>> requestLocations() {

        // todo look in cache


        // converter between JSON <--> Java POJO
        Gson gson = new GsonBuilder()
                .setLenient() // relax the conditions for what the parser considers valid JSON syntax
                .create();

        // initialize retrofit with the JSON parser and base URL
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        // associate the API interface to the Retrofit object
        LocationRetrofit apiInterface = retrofit.create(LocationRetrofit.class);
        Call<Root> call = apiInterface.getLocations("Token " + BuildConfig.TOKEN);

        // make the API the call asynchronously
        call.enqueue(this);

        // return the observable (empty until async call finishes)
        return mutableLiveData;
    }

    // callback triggered on API response
    @Override
    public void onResponse(Call<Root> call, Response<Root> response) {

        // success
        if (response.isSuccessful()) {

            // response body holds the converted POJO
            Root model = response.body();

            // assign the list of locations to the observable
            mutableLiveData.setValue(model.getLocations());

        // failure, the response finished but has an error
        } else {
            Log.e(TAG, response.errorBody().toString());
        }
    }

    // failure, the response was interrupted by an error
    @Override
    public void onFailure(Call<Root> call, Throwable t) {
        Log.e(TAG, t.getMessage());
    }
}
