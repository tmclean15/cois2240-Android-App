package ca.cois2240group20.grocerymanagementapp.utility;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.content.Context;

import ca.cois2240group20.grocerymanagementapp.database.AppDatabase;

/*
* The purpose of this class is to have a method getContext() that can provide the context
* of the app to classes (such as adapters) that can't access the app context internally.
* It's a bit of a hack solution, but it works well.
* */

public class App extends Application {

    private static Context mContext;
    private static AppDatabase database;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        database = Room.databaseBuilder(mContext, AppDatabase.class, "database").build();
    }

    public Context getContext() {
        return mContext;
    }

    public static AppDatabase getAppDataBase() {
        return database;
    }
}
