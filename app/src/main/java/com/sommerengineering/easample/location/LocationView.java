package com.sommerengineering.easample.location;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.view.View;

import com.sommerengineering.easample.databinding.LocationBinding;

import java.util.List;

/**
 * The View (activity/fragment) only interacts with the UI, it observes the LiveData observable that is instantiated
 * in the Repository and passed to the ViewModel.
 */
public class LocationView extends AppCompatActivity {

    final String TAG = getClass().getSimpleName() + " ~~ ";

    private LocationBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // required by system, load a saved bundle if it exists
        super.onCreate(savedInstanceState);

        // inflate the layout and get reference to auto-generated view binding class
        binding = LocationBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        // turn on progress wheel
        binding.progressBar.setVisibility(View.VISIBLE);

        // viewmodel instance created only the very first time system calls onCreate
        // all other instances of activity (orientation change) receive this same viewmodel instance
        LocationModel viewmodel = new ViewModelProvider(this).get(LocationModel.class);

        // observe the livedata observable to receive any changes to its data
        viewmodel.getLocations().observe(this, new Observer<List<Location>>() {

            // called if target livedata observable is non null
            @Override
            public void onChanged(List<Location> locations) {

                // turn off the progress wheel
                binding.progressBar.setVisibility(View.INVISIBLE);

                // concatenate all data into a single string
                String output = "";
                for (Location location : locations) {
                    output += "\n" + location.getId() + "\n" + location.getName() + "\n" + location.getAddress() + "\n";
                }

                // display the retrieved data in the UI
                binding.textview.setText(output);
            }
        });
    }
}
