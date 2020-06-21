package com.sommerengineering.easample.location;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sommerengineering.easample.R;
import com.sommerengineering.easample.databinding.LocationsBinding;

import java.util.List;

public class LocationFragment extends Fragment {

    final String TAG = getClass().getSimpleName() + " ~~ ";
    private LocationViewModel viewModel;
    private LocationsBinding binding;

    public static LocationFragment newInstance() {
        return new LocationFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // inflate the layout and get reference to auto-generated view binding class
        binding = LocationsBinding.inflate(getLayoutInflater());
        View root = binding.getRoot();
        // setContentView(view);

        // turn on progress wheel
        binding.progressBar.setVisibility(View.VISIBLE);

        return inflater.inflate(R.layout.locations, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // viewmodel instance created only the very first time system calls onCreate
        // all other instances of activity (orientation change) receive this same viewmodel instance
        viewModel = new ViewModelProvider(this).get(LocationViewModel.class);

        // observe the livedata observable to receive any changes to its data
        // todo getActivity may return null?
        viewModel.getLocations().observe(getActivity(), new Observer<List<Location>>() {

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