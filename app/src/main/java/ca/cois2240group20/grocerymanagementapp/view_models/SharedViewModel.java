package ca.cois2240group20.grocerymanagementapp.view_models;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import ca.cois2240group20.grocerymanagementapp.FoodTileInfo;

public class SharedViewModel extends ViewModel {
    private MutableLiveData<FoodTileInfo> data;

    public LiveData<FoodTileInfo> getData() {
        if (data == null) {
            data = new MutableLiveData<FoodTileInfo>();
        }
        return data;
    }
}
