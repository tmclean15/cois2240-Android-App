package ca.cois2240group20.grocerymanagementapp.view_models;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import ca.cois2240group20.grocerymanagementapp.database.Tables.FoodTileInfoGroceryList;
import ca.cois2240group20.grocerymanagementapp.database.Tables.FoodTileInfoInventory;

public class SharedViewModel extends ViewModel {

    // Todo: Write comment explaining why I need lists separate from the live data
    //Invetory List Table
    private List<FoodTileInfoInventory> inventoryData;
    public MutableLiveData<List<FoodTileInfoInventory>> inventoryLiveData;

    //Grocery List Table
    private List<FoodTileInfoGroceryList> groceryListData;
    private MutableLiveData<List<FoodTileInfoGroceryList>> groceryListLiveData;

    public LiveData<List<FoodTileInfoInventory>> getInventoryData() {
        if (inventoryLiveData == null) {
            inventoryData = new ArrayList<FoodTileInfoInventory>();
            inventoryLiveData = new MutableLiveData<List<FoodTileInfoInventory>>();
        }
        return inventoryLiveData;
    }
    public void setInventoryData(List<FoodTileInfoInventory> data) {
        inventoryData = data;
        inventoryLiveData.setValue(data);
    }
    public void setGroceryData(List<FoodTileInfoGroceryList> data){
        groceryListData = data;
        groceryListLiveData.setValue(data);
    }

    public LiveData<List<FoodTileInfoGroceryList>> getGroceryListData() {
        if (groceryListLiveData == null) {
            groceryListData = new ArrayList<FoodTileInfoGroceryList>();
            groceryListLiveData = new MutableLiveData<List<FoodTileInfoGroceryList>>();
        }
        return groceryListLiveData;
    }

    public void addInventory(FoodTileInfoInventory foodTile) {
        inventoryData.add(foodTile);
        inventoryLiveData.setValue(inventoryData);
    }

    public void removeInventory(int index) {
        inventoryData.remove(index);
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

    public FoodTileInfoGroceryList accessGroceryList(int index) {
        return groceryListData.get(index);
    }
}
