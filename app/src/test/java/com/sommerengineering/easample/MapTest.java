package com.sommerengineering.easample;

import android.util.Log;

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
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class MapTest {

    // initialize Mockito
    @Before
    public void prepare() {
        MockitoAnnotations.initMocks(this);
    }

    // initialize Mockito
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    MapInterface mockMapInteface;

    // initialize the mocked object
    @InjectMocks
    MapFragment mockMapFragment;

    @Test
    public void someTest() {

        // interface with of the mocked object
        int type = mockMapFragment.getMapType();
        Assert.assertEquals(type, 42);
    }
}
