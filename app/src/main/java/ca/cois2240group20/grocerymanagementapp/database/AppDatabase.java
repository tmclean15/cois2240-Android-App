package ca.cois2240group20.grocerymanagementapp.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

<<<<<<< HEAD
import ca.cois2240group20.grocerymanagementapp.database.Tables.FoodTileInfoGroceryList;
import ca.cois2240group20.grocerymanagementapp.database.Tables.FoodTileInfoInventory; //Entity
=======
import ca.cois2240group20.grocerymanagementapp.database.entities.FoodTileInfoGroceryList;
import ca.cois2240group20.grocerymanagementapp.database.entities.FoodTileInfoInventory; //Entity
>>>>>>> 2c84a427757f680022f6749e9a0644357a3212b2


@Database(entities = {FoodTileInfoInventory.class, FoodTileInfoGroceryList.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    //Database variable
    private static AppDatabase appDatabase = null;

    //Data Access Object
    public abstract FoodTileDAO foodTileDAO();
}