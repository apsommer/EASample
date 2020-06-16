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

public class ViewUI extends AppCompatActivity {

//    // constants
//    final String BASE_URL = "https://api-stage.greenlotstest.com/ocpi/cpo/2.1.1/";
//    final String TAG = getClass().getSimpleName() + " ~~ "; // prefer this ~~ to easily filter logcat

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // required by system, load a saved bundle if it exists
        super.onCreate(savedInstanceState);

        // inflate the layout, creates the UI on the device from the passed XML
        setContentView(R.layout.activity_main);

        // todo request data from viewmodel
    }

}
