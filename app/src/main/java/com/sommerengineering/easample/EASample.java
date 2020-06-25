package com.sommerengineering.easample;

import android.app.Application;
import dagger.hilt.android.HiltAndroidApp;

@HiltAndroidApp // triggers Hilt code generation, including base class as app-level dependency container
public class EASample extends Application {
}
