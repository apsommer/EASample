package com.sommerengineering.easample.di;

import android.content.Context;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sommerengineering.easample.location.LocationRetrofit;
import com.sommerengineering.easample.location.LocationViewModel;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;
import dagger.hilt.android.qualifiers.ActivityContext;
import dagger.hilt.android.scopes.ActivityScoped;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@InstallIn(ActivityComponent.class)
@Module
public final class NetworkModule {

    @Provides
    // scope annotation does not make sense here because the ViewModelProvider always returns
    // the same instance of viewmodel, it is already activity scoped
    static LocationViewModel provideViewModel(@ActivityContext Context context) {

        // viewmodel instance created only the very first time system calls onCreate
        // all other instances of activity (orientation change) receive this same viewmodel instance
        return new ViewModelProvider((ViewModelStoreOwner) context).get(LocationViewModel.class);
    }

    @Provides
    @ActivityScoped
    static LocationRetrofit provideLocationRetrofit() {

        // converter between JSON <--> Java POJO
        Gson gson = new GsonBuilder()
                .setLenient() // relax the conditions for what the parser considers valid JSON syntax
                .create();

        // initialize retrofit with the JSON parser and base URL
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api-stage.greenlotstest.com/ocpi/cpo/2.1.1/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(LocationRetrofit.class);
    }
}
