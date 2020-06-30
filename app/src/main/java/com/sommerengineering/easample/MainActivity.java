package com.sommerengineering.easample;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.NavHostController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint // creates activity level dependency container
public class MainActivity extends FragmentActivity {

    final String TAG = getClass().getSimpleName() + " ~~ ";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // layout defines the host fragment
        setContentView(R.layout.navigation);

        // log a message when navigating to new destination
        Navigation.findNavController(this, R.id.host_fragment).addOnDestinationChangedListener(
                (controller, destination, args) ->
                Log.d(TAG, "navigated to: " + getResources().getResourceName(destination.getId())));
    }
}
