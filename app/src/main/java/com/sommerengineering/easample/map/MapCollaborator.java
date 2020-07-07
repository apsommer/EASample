package com.sommerengineering.easample.map;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.sommerengineering.easample.ui.MapFragment;

public class MapCollaborator {

    public static int ERROR_CODE = 1;

    public void executeAsyncMap(SupportMapFragment mapFragment, MapCallback mapCallback) {

        try { mapFragment.getMapAsync(googleMap -> mapCallback.onSuccess(googleMap)); }
        catch (Exception e) { mapCallback.onFail(ERROR_CODE); }
    }
}
