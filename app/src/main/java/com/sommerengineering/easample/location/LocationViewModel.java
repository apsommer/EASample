package com.sommerengineering.easample.location;

import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.sommerengineering.easample.location.model.Location;

import java.util.List;

/**
 * ViewModel requests data from the Repository and stores the result in an observable LiveData.
 */
public class LocationViewModel extends ViewModel {

    // dependency
    LocationRepo repository;
    @ViewModelInject LocationViewModel(LocationRepo repository) {
        this.repository = repository;
    }

    // livedata is an observable that automatically respects its observers' lifecycles
    MutableLiveData<List<Location>> mutableLiveData;

    // called by the view to access observable in the repo (abstraction layer)
    public LiveData<List<Location>> getLocations() {

        if (mutableLiveData == null) {
            mutableLiveData = repository.requestLocations();
        }
        return mutableLiveData;
    }
}
