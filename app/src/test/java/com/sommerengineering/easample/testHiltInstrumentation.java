package com.sommerengineering.easample;

import org.junit.Rule;
import org.junit.rules.TestRule;

import dagger.hilt.android.testing.HiltAndroidRule;
import dagger.hilt.android.testing.HiltAndroidTest;

@HiltAndroidTest
public class testHiltInstrumentation {

    @Rule
    public HiltAndroidRule rule = new HiltAndroidRule(this);

    //
}
