package com.sommerengineering.easample.di;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sommerengineering.easample.location.LocationRetrofit;

import java.io.IOException;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@InstallIn(ApplicationComponent.class)
@Module
public final class NetworkModule {

    @Provides
    static String provideBaseUrl() {
        return "https://api-stage.greenlotstest.com/ocpi/cpo/2.1.1/";
    }

    @Provides
    static OkHttpClient provideOkHttpClient() {
        return new OkHttpClient();
    }

    @Provides
    static Gson provideGson() {
        return new GsonBuilder().setLenient().create();
    }

    @Provides
    static Converter.Factory provideGsonConverterFactory(Gson gson) {
        return GsonConverterFactory.create(gson);
    }

    @Provides
    static Retrofit provideRetrofit(String baseUrl, OkHttpClient client, Converter.Factory factory) {
        return new Retrofit.Builder().baseUrl(baseUrl).client(client).addConverterFactory(factory).build();
    }

    @Provides
    static LocationRetrofit provideLocationRetrofit(Retrofit retrofit) {
        return retrofit.create(LocationRetrofit.class);
    }
}
