package ca.cois2240group20.grocerymanagementapp.page_fragments;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import ca.cois2240group20.grocerymanagementapp.activities.AddFoodTileActivity;
import ca.cois2240group20.grocerymanagementapp.adapters_and_viewholders.GroceryListAdapter;
import ca.cois2240group20.grocerymanagementapp.R;
import ca.cois2240group20.grocerymanagementapp.database.entities.FoodTileInfoGroceryList;
import ca.cois2240group20.grocerymanagementapp.view_models.SharedViewModel;

public class GroceryListFragment extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private SharedViewModel model;

    /*// Just some dummy data
    Date date = new Date();
    FoodTileInfo tile1 = new FoodTileInfo("apples", date, date, 20.00, 5);
    FoodTileInfo tile2 = new FoodTileInfo("apples", date, date, 20.00, 5);
    FoodTileInfo tile3 = new FoodTileInfo("apples", date, date, 20.00, 5);
    List<FoodTileInfo> data = new ArrayList<>(Arrays.asList(tile1,tile2,tile3));*/

    @Override
    public View onCreateView(final LayoutInflater inflater,
                             final ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_grocerylist, container, false);

        // Gets view model, that will persist for lifecycle of MainActivity.
        model = ViewModelProviders.of(getActivity()).get(SharedViewModel.class);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.grocerylist_recycler_view);

        // This setting will improve performance as the layout size of the RecyclerView will not
        // change with changes in content
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        adapter = new GroceryListAdapter(model.getAllGroceryList(), recyclerView, model);
        recyclerView.setAdapter(adapter);

        // Create the observer which updates the UI when live data in view model changes
        final Observer<List<FoodTileInfoGroceryList>> observer = new Observer<List<FoodTileInfoGroceryList>>() {
            @Override
            public void onChanged(@Nullable List<FoodTileInfoGroceryList> newData) {
                adapter = new GroceryListAdapter(newData, recyclerView, model);
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        };

        // Observe the live data in the view model
        model.getGroceryListData().observe(this, observer);

        FloatingActionButton fab = (FloatingActionButton) rootView.findViewById(R.id.fabGroceryList);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), AddFoodTileActivity.class);
                intent.putExtra("method", "GroceryList");
                startActivity(intent);
            }
        });

        return rootView;
    }
}
