package com.sommerengineering.easample;

import android.os.Build;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.testing.FragmentScenario;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.SupportMapFragment;
import com.sommerengineering.easample.ui.MapFragment;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowApplication;

import dagger.hilt.android.testing.HiltAndroidRule;
import dagger.hilt.android.testing.HiltAndroidTest;
import dagger.hilt.android.testing.HiltTestApplication;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;

@HiltAndroidTest // generate Hilt components for use in this test
@Config(application = HiltTestApplication.class, sdk = Build.VERSION_CODES.O_MR1) // alternatively can be set in roboelectric.properties
@RunWith(RobolectricTestRunner.class)
public class testHiltRoboelectric {

    int mapType;
    SupportMapFragment supportMapFragment;
    GoogleMap googleMap;

    @Rule // manage component states and perform injection when needed
    public HiltAndroidRule rule = new HiltAndroidRule(this);
    // other rules like MockitoRule can also be combined here

    //
    @Before
    public void prepare() {

        // attaches the fragment to an activity's root view controller
        // the containing test activity is otherwise empty
        FragmentScenario scenario = FragmentScenario.launchInContainer(MapFragment.class);
        scenario.onFragment(new FragmentScenario.FragmentAction() {
            @Override
            public void perform(@NonNull Fragment fragment) {

                MapFragment mapFragment = (MapFragment) fragment;
                supportMapFragment = mapFragment.getMapFragment();
                mapFragment.executeAsync();
                ShadowApplication.runBackgroundTasks();
                mapType = mapFragment.getMapType();
                googleMap = mapFragment.getMap();

                MapView view;
            }
        });
    }

    @Test
    public void test() {

        // todo I have to stop my valiant attempt here. Using roboelectric shadows has essentially
        //   no resources to reference and is an obscure area of the library. To test maps a full
        //   blown instrumented UI test is needed. The map is returned via a play-services conduit.
        //   Services are not accessible to Roboelectric, extending their shadows is the only way.

        System.out.println("~~" + mapType);
        assertThat(supportMapFragment, notNullValue());
        assertThat(googleMap, notNullValue());
    }
}
