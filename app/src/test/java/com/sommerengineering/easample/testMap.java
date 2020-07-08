package com.sommerengineering.easample;

import android.util.Log;

import androidx.fragment.app.Fragment;
import androidx.hilt.Assisted;

import com.sommerengineering.easample.map.MapInterface;
import com.sommerengineering.easample.ui.MapFragment;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;
import org.mockito.stubbing.OngoingStubbing;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class testMap {

    // initialize Mockito
    @Before public void prepare() { MockitoAnnotations.initMocks(this); }
    @Rule public MockitoRule rule = MockitoJUnit.rule();

    // create a mock map interface for use with @Test when/then pattern
    @Mock
    MapInterface mockMap;

    // create vanilla, new default instance of map fragment
    @InjectMocks
    MapFragment realMap;

    @Test
    public void someTest() {

        // when "this method is called on mock" then "return this value"
        when(mockMap.getMapType()).thenReturn(42);

        // very the real map interface matches the mocked response
        Assert.assertEquals(realMap.getMapType(), mockMap.getMapType());
    }
}
