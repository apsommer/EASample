package com.sommerengineering.easample.location;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.sommerengineering.easample.location.Location;

import java.util.List;

/**
 * ViewModel requests data from the Repository and stores the result in an observable LiveData.
 */
public class LocationModel extends ViewModel {

    final String TAG = getClass().getSimpleName() + " ~~ ";

    // reference to repo and livedata observable it contains
    private LocationRepo repository;
    private MutableLiveData<List<Location>> mutableLiveData;

    // pass repo in constructor for dependency injection
    public LocationModel() {
        repository = new LocationRepo();
    }

    // called by the view to access observable in the repo (abstraction layer)
    public LiveData<List<Location>> getLocations() {

        if (mutableLiveData == null) {
            mutableLiveData = repository.requestLocations();
        }
        return mutableLiveData;
    }
}
