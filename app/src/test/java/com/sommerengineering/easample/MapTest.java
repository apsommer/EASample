package com.sommerengineering.easample;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.model.LatLng;
import com.sommerengineering.easample.map.MapCallback;
import com.sommerengineering.easample.map.MapCollaborator;
import com.sommerengineering.easample.ui.MapFragment;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class MapTest {

    // initialize Mockito
    @Before public void prepare() { MockitoAnnotations.initMocks(this); }
    @Rule public MockitoRule rule = MockitoJUnit.rule();

    // CUT = class under test
    @InjectMocks
    MapFragment mapFragment;

    @Mock
    MapCollaborator mockCollaborator;

    @Mock
    GoogleMap googleMap;

    @Captor
    ArgumentCaptor<MapCallback> callbackArgumentCaptor;

    // @Spy is rarely used relative to mock ... useful for legacy code.

    @Test
    public void someTest() {

        mapFragment.delegate();

    }
}
