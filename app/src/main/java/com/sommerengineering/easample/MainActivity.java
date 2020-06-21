package com.sommerengineering.easample;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.fragment.NavHostFragment;

public class MainActivity extends FragmentActivity {

    final String TAG = getClass().getSimpleName() + " ~~ ";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation);

        NavHostFragment hostFragment = (NavHostFragment) getSupportFragmentManager()
                .findFragmentById(R.id.host_fragment);

        NavController navController = hostFragment.getNavController();
        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController controller, @NonNull NavDestination destination, @Nullable Bundle args) {
                Log.d(TAG, "navigated to: " + getResources().getResourceName(destination.getId()));
            }
        });
    }
}
