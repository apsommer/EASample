package com.sommerengineering.retrofit;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class ViewUI extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // required by system, load a saved bundle if it exists
        super.onCreate(savedInstanceState);

        // inflate the layout, creates the UI on the device from the passed XML
        setContentView(R.layout.activity_main);

        // todo request data from viewmodel
    }

}
