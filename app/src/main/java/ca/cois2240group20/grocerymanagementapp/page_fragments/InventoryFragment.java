package ca.cois2240group20.grocerymanagementapp.page_fragments;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import ca.cois2240group20.grocerymanagementapp.activities.AddFoodTileActivity;
import ca.cois2240group20.grocerymanagementapp.adapters_and_viewholders.InventoryViewHolder;
import ca.cois2240group20.grocerymanagementapp.database.FoodTileDAO;
import ca.cois2240group20.grocerymanagementapp.utility.FoodTileInfo;
import ca.cois2240group20.grocerymanagementapp.R;
import ca.cois2240group20.grocerymanagementapp.adapters_and_viewholders.InventoryAdapter;
import ca.cois2240group20.grocerymanagementapp.view_models.SharedViewModel;


public class InventoryFragment extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private SharedViewModel model;

    // Just some dummy data
    /*Date date = new Date();
    FoodTileInfo tile1 = new FoodTileInfo("apples", date, date, 20.00, 5);
    FoodTileInfo tile2 = new FoodTileInfo("apples", date, date, 20.00, 5);
    FoodTileInfo tile3 = new FoodTileInfo("apples", date, date, 20.00, 5);
    List<FoodTileInfo> data = new ArrayList<>(Arrays.asList(tile1,tile2,tile3));*/

    @Override
    public View onCreateView(LayoutInflater inflater,
                             final ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_inventory, container, false);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.inventory_recycler_view);

        // This setting will improve performance as the layout size of the RecyclerView will not
        // change with changes in content
        recyclerView.setHasFixedSize(true);

        // Gets view model, that will persist for lifecycle of MainActivity
        model = ViewModelProviders.of(getActivity()).get(SharedViewModel.class);

        // Set up layout manager
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        // Set adapter for recycler view
        adapter = new InventoryAdapter(model.getAllInventory(), recyclerView, model);
        recyclerView.setAdapter(adapter);

        // Create the observer which updates the UI when live data in view model changes
        final Observer<List<FoodTileInfo>> observer = new Observer<List<FoodTileInfo>>() {
            @Override
            public void onChanged(@Nullable final List<FoodTileInfo> newData) {
                // TODO: Update the UI
                adapter = new InventoryAdapter(newData, recyclerView, model);
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();

            }
        };

        // Observe the live data in the view model
        model.getInventoryData().observe(this, observer);

        // Outlines the behaviour of the floating action button
        FloatingActionButton fab = (FloatingActionButton) rootView.findViewById(R.id.fabInventory);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), AddFoodTileActivity.class);
                intent.putExtra("method", "Inventory");
                startActivity(intent);
            }
        });
        return rootView;
    }
}
