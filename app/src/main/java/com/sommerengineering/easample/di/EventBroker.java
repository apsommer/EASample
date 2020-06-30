package com.sommerengineering.easample.di;

import android.view.View;

import androidx.navigation.Navigation;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.FragmentComponent;
import dagger.hilt.android.scopes.FragmentScoped;

@InstallIn(FragmentComponent.class)
@Module
public final class EventBroker {

    @Provides
    @FragmentScoped
    static OnMapReadyCallback provideMapCallback() {

        return map -> {

            // zoom to San Diego street level
            LatLng sanDiego = new LatLng(32.72, -117.16);
            map.addMarker(new MarkerOptions().position(sanDiego).title("Marker in San Diego"));
            map.moveCamera(CameraUpdateFactory.newLatLng(sanDiego));
            map.setMinZoomPreference(10.0f);
        };
    }

    @Provides
    static View.OnClickListener provideNextDestination() {
        return view -> Navigation.findNavController(view).navigate(FeatureFlag.action);
    }
}
