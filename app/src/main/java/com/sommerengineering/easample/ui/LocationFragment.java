package com.sommerengineering.easample.ui;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.sommerengineering.easample.R;
import com.sommerengineering.easample.databinding.LocationBinding;
import com.sommerengineering.easample.location.Location;
import com.sommerengineering.easample.location.LocationViewModel;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint // generates fragment container
public class LocationFragment extends Fragment {

    // no dependencies (viewmodel provided by framework ViewModelProvider)
    @Inject LocationViewModel viewModel;

    // framework view binding
    private LocationBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // inflate the layout and get reference to auto-generated view binding class
        binding = LocationBinding.inflate(getLayoutInflater());

        // turn on progress wheel
        binding.progressBar.setVisibility(View.VISIBLE);

        // next button navigates to map destination
        binding.nextButton.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.map_action));

        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // viewmodel instance created only the very first time system calls onCreate
        // all other instances of activity (orientation change) receive this same viewmodel instance

        // observe the livedata observable to receive any changes to its data
        // called if target livedata observable is non null
        viewModel.getLocations().observe(getActivity(), locations -> {

            // turn off the progress wheel
            binding.progressBar.setVisibility(View.INVISIBLE);

            // concatenate all data into a single string
            String output = "";
            for (Location location : locations) {
                output += "\n" + location.getId() + "\n" + location.getName() + "\n" + location.getAddress() + "\n";
            }

            // display the retrieved data in the UI
            binding.textview.setText(output);
        });
    }
}