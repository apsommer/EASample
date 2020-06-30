package com.sommerengineering.easample.location;

import android.util.Log;
import androidx.lifecycle.MutableLiveData;
import com.sommerengineering.easample.BuildConfig;
import com.sommerengineering.easample.EASample;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Repository manages the network API calls and retrieval from db cache. It supplies data to the ViewModel via exposure
 * of a LiveData observable.
 */

public class LocationRepo implements Callback<Root> {

    // dependency
    LocationRetrofit apiInterface;
    @Inject LocationRepo(LocationRetrofit apiInterface) {
        this.apiInterface = apiInterface;
    }

    // livedata is an observable that automatically respects its observers' lifecycles
    MutableLiveData<List<Location>> mutableLiveData =  new MutableLiveData<>();

    // viewmodel requests formatted POJO's
    public MutableLiveData<List<Location>> requestLocations() {

        // todo logic to initialize observable with data from db cache
        //  afterward initialization update cache in background if needed

        // make the API the call asynchronously
        apiInterface.getLocations("Token " + BuildConfig.TOKEN).enqueue(this);

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

            // assign the list of location to the observable
            mutableLiveData.setValue(model.getLocations());

        // failure, the response finished but has an error
        } else {
            try {
                Log.e(EASample.TAG, "onResponse > " + response.errorBody().string());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // failure, the response was interrupted by an error
    @Override
    public void onFailure(Call<Root> call, Throwable t) {
        Log.e(EASample.TAG, "onFailure > " + t.getMessage());
    }
}
