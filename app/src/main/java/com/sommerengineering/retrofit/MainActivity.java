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

public class MainActivity extends AppCompatActivity implements Callback<List<Change>> {

    final String BASE_URL = "https://git.eclipse.org/r/";
    final String TAG = getClass().getSimpleName() + " ~~ ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // required by system, load a saved bundle if exists
        super.onCreate(savedInstanceState);

        // inflate the layout
        setContentView(R.layout.activity_main);

        // converter between JSON <--> Java POJO
        Gson gson = new GsonBuilder()
                .setLenient() // relax the conditions for what the parser considers valid JSON
                .create();

        // initialize retrofit with the JSON parser and base URL
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        // associate retrofit to the API interface
        GerritApi gerritApi = retrofit.create(GerritApi.class);
        Call<List<Change>> call = gerritApi.loadChanges("status:open");

        // make the API the call asynchronously
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<List<Change>> call, Response<List<Change>> response) {

        // success
        if (response.isSuccessful()) {

            // extract the list of changed text from the response
            List<Change> changes = response.body();

            // todo
            changes.forEach(change -> Log.e(TAG, change.getSubject()));

        // failure, the response finished but has an error
        } else {
            System.out.println(response.errorBody());
        }
    }

    // failure, the response was not generated due to error
    @Override
    public void onFailure(Call<List<Change>> call, Throwable t) {
        t.printStackTrace();
    }
}
