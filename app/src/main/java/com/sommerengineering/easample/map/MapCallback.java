package com.sommerengineering.easample.map;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;

import okhttp3.Response;

public interface MapCallback {
    public void onSuccess(GoogleMap map);
    public void onFail(int code);
}
