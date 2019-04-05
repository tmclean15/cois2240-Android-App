package ca.cois2240group20.grocerymanagementapp.activities;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

import ca.cois2240group20.grocerymanagementapp.R;
import ca.cois2240group20.grocerymanagementapp.adapters_and_viewholders.PagerAdapter;
import ca.cois2240group20.grocerymanagementapp.database.AppDatabase;
import ca.cois2240group20.grocerymanagementapp.database.Tables.FoodTileInfoGroceryList;
import ca.cois2240group20.grocerymanagementapp.database.Tables.FoodTileInfoInventory;
import ca.cois2240group20.grocerymanagementapp.view_models.SharedViewModel;
import ca.cois2240group20.grocerymanagementapp.utility.App;

public class MainActivity extends AppCompatActivity {
    // The viewPager is the main layout widget that will show all the different page fragments
    ViewPager viewPager;
    // The pagerAdapter is what handles which pages get shown in the viewPager
    PagerAdapter pagerAdapter;
    // View model is a shared state among the activity and its associated fragments
    SharedViewModel model;

    private AppDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set up view model for this activity. It will be used to share data with page fragments
        model = ViewModelProviders.of(this).get(SharedViewModel.class);

        //Get Data from Database - Inventory
        database = App.getAppDataBase();
        //load inventory
        List<FoodTileInfoInventory> inventory = database.foodTileDAO().getAllInventory();
        model.setInventoryData(inventory);
        //load grocery list
        List<FoodTileInfoGroceryList> grocery = database.foodTileDAO().getAllGrocery();
        model.setGroceryData(grocery);

        pagerAdapter = new PagerAdapter(getSupportFragmentManager(), 3);
        viewPager = (ViewPager) findViewById(R.id.pager);
        viewPager.setAdapter(pagerAdapter);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            toolbar.setTitle(R.string.app_name);
            setSupportActionBar(toolbar);
        }

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        // A tab listener is needed to specify which actions to take when the user selects a tab
        TabLayout.OnTabSelectedListener listener = new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                // Uses the pagerAdapter getItem() to determine what fragment is at the position of the selected tab
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                // Nothing really needs to be done here. We could potentially hide the page,
                // but that wouldn't be particularly useful to the user. This method needs to exist
                // either way to satisfy the TabListener abstract class methods.
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                // Similarly, nothing really needs to be done.
            }
        };

        tabLayout.addOnTabSelectedListener(listener);

        // This next few lines of code sets up a listener for our viewPager that changes tabs
        // when the user swipes through pages on their phone.
        viewPager.addOnPageChangeListener(
                new ViewPager.SimpleOnPageChangeListener() {
                    @Override
                    public void onPageSelected(int position) {
                        // When swiping between pages, select the
                        // corresponding tab.
                        viewPager.setCurrentItem(position);
                    }
                });

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

    }

    // This callback will be called if AddFoodTileActivity sends an intent with user data for new
    // product to be added
    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        if(intent.getStringExtra("method").equals("addInventory")) {
            addInventory();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    private void addInventory() {
        FoodTileInfoInventory newInvData = getIntent().getParcelableExtra("FoodTileInfoInventory");
        model.addInventory(newInvData);
    }

    //onStop saves data altered in SharedViewModel by clearing old data from tables and inserting
    // new data from livedata
    @Override
    protected void onStop(){
        super.onStop();

        //Update tables in database (inventory)
        //Delete current contents
        database.foodTileDAO().deleteInventory();
        //Insert Live Data into new table
        LiveData<List<FoodTileInfoInventory>> inventory = model.getInventoryData();
        database.foodTileDAO().insertInventory(inventory);

        //Update tables in database (grocery)
        //delete current contents
        database.foodTileDAO().deleteGroceryList();
        //Insert Live Data into new table
        LiveData<List<FoodTileInfoGroceryList>> grocery = model.getGroceryListData();
        database.foodTileDAO().insertGroceryList(grocery);

    }
}

