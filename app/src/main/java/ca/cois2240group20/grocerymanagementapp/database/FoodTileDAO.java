package ca.cois2240group20.grocerymanagementapp.database;

//Room Database Import
import android.arch.persistence.room.*;

import ca.cois2240group20.grocerymanagementapp.database.entities.*;

//Util Import
import java.util.List;

//Data Access Object, executes querys on the FoodTile entity (table)
@Dao
public interface FoodTileDAO {
    //Query

    //Get EVERYTHING from inventory
    @Query("SELECT * FROM Inventory")
    List<FoodTileInfoInventory> getAllInventory();

    //Get EVERYTHING from Grocery
    @Query("SELECT * FROM Grocery")
    List<FoodTileInfoGroceryList> getAllGrocery();

    //Insert New Food Tile
    @Insert
    void insertTile(FoodTileInfoInventory... foodTiles);

    //Delete Tile with specific ID
    @Delete
    void deleteTile(FoodTileInfoInventory foodTiles);


}