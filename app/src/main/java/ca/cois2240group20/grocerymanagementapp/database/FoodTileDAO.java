package ca.cois2240group20.grocerymanagementapp.database;

//Room Database Import
import android.arch.persistence.room.*;

import ca.cois2240group20.grocerymanagementapp.utility.FoodTileInfo;

//Util Import
import java.util.List;

//Data Access Object, executes querys on the FoodTile entity (table)
@Dao
public interface FoodTileDAO {
    //Query

    //Get EVERYTHING
    @Query("SELECT * FROM FoodTileInfo")
    List<FoodTileInfo> getAll();

    //Insert New Food Tile
    @Insert
    void insertTile(FoodTileInfo... foodTiles);

    //Delete Tile with specific ID
    @Delete
    void deleteTile(FoodTileInfo foodTiles);


}
