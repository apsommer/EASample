package com.sommerengineering.easample.ui;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.sommerengineering.easample.R;
import com.sommerengineering.easample.map.MapCollaborator;
import com.sommerengineering.easample.map.MapCallback;

import dagger.hilt.android.AndroidEntryPoint;

import static com.sommerengineering.easample.EASample.TAG;

@AndroidEntryPoint
public class MapFragment extends Fragment implements MapCallback {

    SupportMapFragment mapFragment;
    MapCollaborator mapCollaborator;
    GoogleMap googleMap;

    @Override
    public void onSuccess(GoogleMap googleMap) {
        this.googleMap = googleMap;
        Log.e(TAG, "onSuccess");
    }

    @Override
    public void onFail(int code) {
        Log.e(TAG, "onFail");
    }

    public void delegate() {
        mapCollaborator.executeAsyncMap(mapFragment, this);
    }

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

        mapCollaborator = new MapCollaborator();

        // get reference to pre-defined map fragment via its layout
        mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment == null) return;

        delegate();
    }
}