package ca.cois2240group20.grocerymanagementapp.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import ca.cois2240group20.grocerymanagementapp.utility.FoodTileInfo; //Entity
import ca.cois2240group20.grocerymanagementapp.database.FoodTileDAO; //Data Access Object



@Database(entities = {FoodTileInfo.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    //Database variable
    private static AppDatabase appDatabase = null;

    //Create database object
    public static AppDatabase getInstance(Context context) {
        if (appDatabase == null) {
            appDatabase = Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class, "Grocery").build();
        }
        return appDatabase;
    }

    //Data Access Object
    public abstract FoodTileDAO foodTileDOA();
}