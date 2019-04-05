package ca.cois2240group20.grocerymanagementapp.view_models;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

<<<<<<< HEAD
import ca.cois2240group20.grocerymanagementapp.database.Tables.FoodTileInfoGroceryList;
import ca.cois2240group20.grocerymanagementapp.database.Tables.FoodTileInfoInventory;
=======
import ca.cois2240group20.grocerymanagementapp.database.entities.FoodTileInfoGroceryList;
import ca.cois2240group20.grocerymanagementapp.database.entities.FoodTileInfoInventory;
>>>>>>> 2c84a427757f680022f6749e9a0644357a3212b2

public class SharedViewModel extends ViewModel {
    // Todo: Write comment explaining why I need lists separate from the live data
<<<<<<< HEAD
    //Invetory List Table
    private List<FoodTileInfoInventory> inventoryData;
    public MutableLiveData<List<FoodTileInfoInventory>> inventoryLiveData;

    //Grocery List Table
=======
    private List<FoodTileInfoInventory> inventoryData;
    private MutableLiveData<List<FoodTileInfoInventory>> inventoryLiveData;

>>>>>>> 2c84a427757f680022f6749e9a0644357a3212b2
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

<<<<<<< HEAD
=======
    public List<FoodTileInfoInventory> getAllInventory() {
        return inventoryData;
    }

>>>>>>> 2c84a427757f680022f6749e9a0644357a3212b2
    public LiveData<List<FoodTileInfoGroceryList>> getGroceryListData() {
        if (groceryListLiveData == null) {
            groceryListData = new ArrayList<FoodTileInfoGroceryList>();
            groceryListLiveData = new MutableLiveData<List<FoodTileInfoGroceryList>>();
        }
        return groceryListLiveData;
    }

<<<<<<< HEAD
=======
    public List<FoodTileInfoGroceryList> getAllGroceryList() {
        return groceryListData;
    }

>>>>>>> 2c84a427757f680022f6749e9a0644357a3212b2
    public void addInventory(FoodTileInfoInventory foodTile) {
        inventoryData.add(foodTile);
        inventoryLiveData.setValue(inventoryData);
    }

    public void removeInventory(int index) {
        inventoryData.remove(index);
        inventoryLiveData.setValue(inventoryData);
    }

<<<<<<< HEAD
=======
    public void editInventory(FoodTileInfoInventory data, int index) {
        inventoryData.set(index, data);
        inventoryLiveData.setValue(inventoryData);
    }

>>>>>>> 2c84a427757f680022f6749e9a0644357a3212b2
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

<<<<<<< HEAD
=======
    public void editGroceryList(FoodTileInfoGroceryList data, int index) {
        groceryListData.set(index, data);
        groceryListLiveData.setValue(groceryListData);
    }

>>>>>>> 2c84a427757f680022f6749e9a0644357a3212b2
    public FoodTileInfoGroceryList accessGroceryList(int index) {
        return groceryListData.get(index);
    }
}
