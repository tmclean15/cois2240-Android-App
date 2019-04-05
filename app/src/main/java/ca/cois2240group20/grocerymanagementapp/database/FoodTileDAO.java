package ca.cois2240group20.grocerymanagementapp.database;

//Room Database Import
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.persistence.room.*;

<<<<<<< HEAD
import ca.cois2240group20.grocerymanagementapp.database.Tables.*;
import ca.cois2240group20.grocerymanagementapp.view_models.SharedViewModel;
=======
import ca.cois2240group20.grocerymanagementapp.database.entities.*;
>>>>>>> 2c84a427757f680022f6749e9a0644357a3212b2

//Util Import
import java.util.ArrayList;
import java.util.List;

//Data Access Object, executes querys on the FoodTile entity (table)
@Dao
public interface FoodTileDAO {
    //Query

    //Get EVERYTHING from inventory
    @Query("SELECT * FROM Inventory")
    List<FoodTileInfoInventory> getAllInventory();
<<<<<<< HEAD
=======

    //Get EVERYTHING from Grocery
    @Query("SELECT * FROM Grocery")
    List<FoodTileInfoGroceryList> getAllGrocery();
>>>>>>> 2c84a427757f680022f6749e9a0644357a3212b2

    //Get EVERYTHING from Grocery
    @Query("SELECT * FROM Grocery")
    List<FoodTileInfoGroceryList> getAllGrocery();

    //Update Inventory table onClose for persistence
    //First delete current Inventory Table
    @Query("DELETE FROM Inventory")
    List<FoodTileInfoInventory> deleteInventory();
    //Insert pass liveData list to insert into table
    @Insert
<<<<<<< HEAD
    void insertInventory(LiveData<List<FoodTileInfoInventory>> inventoryLiveData);

    //Update Grocery List table onClose
    //First Delete current Grocery Table
    @Query("DELETE FROM Inventory")
    List<FoodTileInfoGroceryList> deleteGroceryList();
    //Insert New Live Data
    @Insert
    void insertGroceryList(LiveData<List<FoodTileInfoGroceryList>> groceryListLiveData);
=======
    void insertTile(FoodTileInfoInventory... foodTiles);

    //Delete Tile with specific ID
    @Delete
    void deleteTile(FoodTileInfoInventory foodTiles);
>>>>>>> 2c84a427757f680022f6749e9a0644357a3212b2


}