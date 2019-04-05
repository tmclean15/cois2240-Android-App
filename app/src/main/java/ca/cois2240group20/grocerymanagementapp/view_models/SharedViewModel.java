package ca.cois2240group20.grocerymanagementapp.view_models;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import ca.cois2240group20.grocerymanagementapp.database.entities.FoodTileInfoGroceryList;
import ca.cois2240group20.grocerymanagementapp.database.entities.FoodTileInfoInventory;

public class SharedViewModel extends ViewModel {
    // Todo: Write comment explaining why I need lists separate from the live data
    private List<FoodTileInfoInventory> inventoryData;
    private MutableLiveData<List<FoodTileInfoInventory>> inventoryLiveData;

    private List<FoodTileInfoGroceryList> groceryListData;
    private MutableLiveData<List<FoodTileInfoGroceryList>> groceryListLiveData;

    public LiveData<List<FoodTileInfoInventory>> getInventoryData() {
        if (inventoryLiveData == null) {
            inventoryData = new ArrayList<FoodTileInfoInventory>();
            inventoryLiveData = new MutableLiveData<List<FoodTileInfoInventory>>();
        }
        return inventoryLiveData;
    }

    public List<FoodTileInfoInventory> getAllInventory() {
        return inventoryData;
    }

    public LiveData<List<FoodTileInfoGroceryList>> getGroceryListData() {
        if (groceryListLiveData == null) {
            groceryListData = new ArrayList<FoodTileInfoGroceryList>();
            groceryListLiveData = new MutableLiveData<List<FoodTileInfoGroceryList>>();
        }
        return groceryListLiveData;
    }

    public List<FoodTileInfoGroceryList> getAllGroceryList() {
        return groceryListData;
    }

    public void addInventory(FoodTileInfoInventory foodTile) {
        inventoryData.add(foodTile);
        inventoryLiveData.setValue(inventoryData);
    }

    public void removeInventory(int index) {
        inventoryData.remove(index);
        inventoryLiveData.setValue(inventoryData);
    }

    public void editInventory(FoodTileInfoInventory data, int index) {
        inventoryData.set(index, data);
        inventoryLiveData.setValue(inventoryData);
    }

    public FoodTileInfoInventory accessInventory(int index) {
        return inventoryData.get(index);
    }

    public void addGroceryList(FoodTileInfoGroceryList foodTile) {
        groceryListData.add(foodTile);
        groceryListLiveData.setValue(groceryListData);
    }

    public void removeGroceryList(int index) {
        groceryListData.remove(index);
        groceryListLiveData.setValue(groceryListData);
    }

    public void editGroceryList(FoodTileInfoGroceryList data, int index) {
        groceryListData.set(index, data);
        groceryListLiveData.setValue(groceryListData);
    }

    public FoodTileInfoGroceryList accessGroceryList(int index) {
        return groceryListData.get(index);
    }
}
