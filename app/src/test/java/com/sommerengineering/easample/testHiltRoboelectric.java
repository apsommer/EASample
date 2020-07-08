package com.sommerengineering.easample;

import org.junit.Rule;
import org.junit.rules.TestRule;
import org.robolectric.annotation.Config;

import dagger.hilt.android.testing.HiltAndroidRule;
import dagger.hilt.android.testing.HiltAndroidTest;
import dagger.hilt.android.testing.HiltTestApplication;

@HiltAndroidTest // generate Hilt components for use in this test
@Config(application = HiltTestApplication.class)
public class testHiltRoboelectric {

    @Rule // manage component states and perform injection when needed
    // other rules (Mockito) can also be combined here
    public HiltAndroidRule rule = new HiltAndroidRule(this);

    //
}
