package com.sommerengineering.easample.login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.sommerengineering.easample.R;
import com.sommerengineering.easample.databinding.LoginBinding;

public class LoginFragment extends Fragment {

    final String TAG = getClass().getSimpleName() + " ~~ ";
    private LoginBinding binding;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        // inflate the layout and get reference to auto-generated view binding class
        binding = LoginBinding.inflate(getLayoutInflater());
        View root = binding.getRoot();
        // setContentView(view);

        // set button click listener
        Button button = binding.login;
        button.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.map_action));

        // todo this toggle will be in FeatureFlag class
        SwitchCompat toggle = binding.toggle;
        toggle.setOnCheckedChangeListener((view, isChecked) -> {

            int action;

            // navigate to location before map
            if (isChecked) {
                toggle.setTextColor(getResources().getColor(R.color.colorPrimary));
                button.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.location_action));
            }

            // navigate directly to map
            else {
                toggle.setTextColor(getResources().getColor(android.R.color.black));
                button.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.map_action));
            }
        });
        // todo end FeatureFlag class

        return root;
    }
}
