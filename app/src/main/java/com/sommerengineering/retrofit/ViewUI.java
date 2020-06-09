package com.sommerengineering.retrofit;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ViewUI extends AppCompatActivity implements Callback<List<DataModel>> {

    // constants
    final String BASE_URL = "https://git.eclipse.org/r/";
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
        ApiInterface gerritApi = retrofit.create(ApiInterface.class);
        Call<List<DataModel>> call = gerritApi.loadChanges("status:open");

        // make the API the call asynchronously
        call.enqueue(this);
    }

    // callback triggered on API response
    @Override
    public void onResponse(Call<List<DataModel>> call, Response<List<DataModel>> response) {

        // success
        if (response.isSuccessful()) {

            // todo
            List<DataModel> changes = response.body();
            changes.forEach(change -> Log.e(TAG, change.getSubject()));

        // failure, the response finished but has an error
        } else {
            System.out.println(response.errorBody());
        }
    }

    // failure, the response was interrupted by an error
    @Override
    public void onFailure(Call<List<DataModel>> call, Throwable t) {
        t.printStackTrace();
    }
}
