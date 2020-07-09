package com.sommerengineering.easample.ui;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.sommerengineering.easample.R;
import com.sommerengineering.easample.map.MapInterface;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MapFragment extends Fragment implements MapInterface {

    GoogleMap map;

    SupportMapFragment mapFragment;

    @Override
    public int getMapType() {

        if (map == null) return 42;
        return map.getMapType();
    }

    // map callback
    private OnMapReadyCallback callback = googleMap -> {

        this.map = googleMap;

        // center map on San Diego
        LatLng sanDiego = new LatLng(32.72, -117.16);
        map.addMarker(new MarkerOptions().position(sanDiego).title("Marker in San Diego"));
        map.moveCamera(CameraUpdateFactory.newLatLng(sanDiego));
        map.setMinZoomPreference(10.0f);

    };

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.map, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) executeAsync();
    }

    public void executeAsync() {
        mapFragment.getMapAsync(callback);
    }

    public SupportMapFragment getMapFragment() {
        return mapFragment;
    }

    public GoogleMap getMap() {
        return map;
    }
}