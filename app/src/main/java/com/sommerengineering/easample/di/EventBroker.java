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
import dagger.hilt.android.components.ActivityComponent;
import dagger.hilt.android.components.FragmentComponent;
import dagger.hilt.android.scopes.ActivityScoped;
import dagger.hilt.android.scopes.FragmentScoped;

@InstallIn(ActivityComponent.class)
@Module
public final class EventBroker {

    // todo this does not keep the map in memory? still seeing map refresh
    @Provides
    @ActivityScoped
    static OnMapReadyCallback provideMapCallback() {

        return map -> {

            // todo this should be user current location
            LatLng sanDiego = new LatLng(32.72, -117.16);
            map.addMarker(new MarkerOptions().position(sanDiego).title("Marker in San Diego"));
            map.moveCamera(CameraUpdateFactory.newLatLng(sanDiego));
            map.setMinZoomPreference(10.0f);
        };
    }


}
