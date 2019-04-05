package ca.cois2240group20.grocerymanagementapp.view_models;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import ca.cois2240group20.grocerymanagementapp.utility.FoodTileInfo;

public class SharedViewModel extends ViewModel {
    // Todo: Write comment explaining why I need lists separate from the live data
    private List<FoodTileInfo> inventoryData;
    private MutableLiveData<List<FoodTileInfo>> inventoryLiveData;

    private List<FoodTileInfo> groceryListData;
    private MutableLiveData<List<FoodTileInfo>> groceryListLiveData;

    public LiveData<List<FoodTileInfo>> getInventoryData() {
        if (inventoryLiveData == null) {
            inventoryData = new ArrayList<FoodTileInfo>();
            inventoryLiveData = new MutableLiveData<List<FoodTileInfo>>();
        }
        return inventoryLiveData;
    }

    public List<FoodTileInfo> getAllInventory() {
        return inventoryData;
    }

    public LiveData<List<FoodTileInfo>> getGroceryListData() {
        if (groceryListLiveData == null) {
            groceryListData = new ArrayList<FoodTileInfo>();
            groceryListLiveData = new MutableLiveData<List<FoodTileInfo>>();
        }
        return groceryListLiveData;
    }

    public List<FoodTileInfo> getAllGroceryList() {
        return groceryListData;
    }

    public void addInventory(FoodTileInfo foodTile) {
        inventoryData.add(foodTile);
        inventoryLiveData.setValue(inventoryData);
    }

    public void removeInventory(int index) {
        inventoryData.remove(index);
        inventoryLiveData.setValue(inventoryData);
    }

    public FoodTileInfo accessInventory(int index) {
        return inventoryData.get(index);
    }

    public void addGroceryList(FoodTileInfo foodTile) {
        groceryListData.add(foodTile);
        groceryListLiveData.setValue(groceryListData);
    }

    public void removeGroceryList(int index) {
        groceryListData.remove(index);
        groceryListLiveData.setValue(groceryListData);
    }

    public FoodTileInfo accessGroceryList(int index) {
        return groceryListData.get(index);
    }
}
