package com.sommerengineering.easample.di;

import android.view.View;

import androidx.navigation.Navigation;

import com.sommerengineering.easample.FeatureFlag;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;

@InstallIn(ActivityComponent.class)
@Module
public class Router {

    @Provides
    static View.OnClickListener provideNextDestination() {
        return view -> Navigation.findNavController(view).navigate(FeatureFlag.action);
    }
}
