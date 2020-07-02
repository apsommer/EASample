package com.sommerengineering.easample.di;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
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

/**
 * This class acts receiver and broadcaster for app-level events. Disparate features of the app may communicate
 * with one another through this mechanism.
 */
@InstallIn(ActivityComponent.class)
@Module
public final class EventBroker {

    // list of livedata observables to which observers may subscribe

}
