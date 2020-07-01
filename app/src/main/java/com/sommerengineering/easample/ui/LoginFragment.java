package com.sommerengineering.easample.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.sommerengineering.easample.R;
import com.sommerengineering.easample.databinding.LoginBinding;
import com.sommerengineering.easample.FeatureFlag;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class LoginFragment extends Fragment {

    // dependency
    @Inject View.OnClickListener listener;

    // framework view binding
    private LoginBinding binding;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {

        // inflate the layout and get reference to auto-generated view binding class
        binding = LoginBinding.inflate(getLayoutInflater());

        // set injected click listener to button
        binding.loginButton.setOnClickListener(listener);

        // toggle the switch changes color and button target
        binding.toggle.setOnCheckedChangeListener((view, isChecked) -> {

            // navigate to location before map
            if (isChecked) {
                binding.toggle.setTextColor(getResources().getColor(R.color.colorPrimary));
                FeatureFlag.action = R.id.location_action;
            }

            // navigate directly to map
            else {
                binding.toggle.setTextColor(getResources().getColor(android.R.color.black));
                FeatureFlag.action = R.id.map_action;
            }
        });

        return binding.getRoot();
    }
}
