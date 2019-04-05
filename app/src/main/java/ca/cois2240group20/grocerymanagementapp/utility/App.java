package ca.cois2240group20.grocerymanagementapp.utility;

import android.app.Application;
import android.content.Context;

/*
* The purpose of this class is to have a method getContext() that can provide the context
* of the app to classes (such as adapters) that can't access the app context internally.
* It's a bit of a hack solution, but it works well.
* */

public class App extends Application {

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;


    }

    public static Context getContext() {
        return mContext;
    }
}
