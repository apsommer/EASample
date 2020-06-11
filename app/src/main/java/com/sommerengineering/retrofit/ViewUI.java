package com.sommerengineering.retrofit;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ViewUI extends AppCompatActivity implements Callback<DataModel> {

    // constants
    final String BASE_URL = "https://api-stage.greenlotstest.com/ocpi/cpo/2.1.1/";
    final String TAG = getClass().getSimpleName() + " ~~ "; // prefer this ~~ to easily filter logcat

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // required by system, load a saved bundle if it exists
        super.onCreate(savedInstanceState);

        // inflate the layout, creates the UI on the device from the passed XML
        setContentView(R.layout.activity_main);

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
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        Call<DataModel> call = apiInterface.getLocations("Token " + BuildConfig.TOKEN);

        // make the API the call asynchronously
        call.enqueue(this);
    }

    // callback triggered on API response
    @Override
    public void onResponse(Call<DataModel> call, Response<DataModel> response) {

        // success
        if (response.isSuccessful()) {


            DataModel model = response.body();
            List<Location> locations = model.getLocations();

            locations.forEach( location -> {
                Log.d(TAG, location.getId());
                Log.d(TAG, location.getName());
                Log.d(TAG, location.getAddress());
            });

        // failure, the response finished but has an error
        } else {
            System.out.println(response.errorBody());
        }
    }

    // failure, the response was interrupted by an error
    @Override
    public void onFailure(Call<DataModel> call, Throwable t) {
        t.printStackTrace();
    }
}
