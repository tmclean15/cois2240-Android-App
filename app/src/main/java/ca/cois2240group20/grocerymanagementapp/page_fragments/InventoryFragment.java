package ca.cois2240group20.grocerymanagementapp.page_fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Date;

import ca.cois2240group20.grocerymanagementapp.FoodTileInfo;
import ca.cois2240group20.grocerymanagementapp.R;
import ca.cois2240group20.grocerymanagementapp.adapters_and_viewholders.InventoryAdapter;

public class InventoryFragment extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    Date date = new Date();
    FoodTileInfo tile1 = new FoodTileInfo("apples", date, date, 20.00, 5, "fruit");
    FoodTileInfo tile2 = new FoodTileInfo("apples", date, date, 20.00, 5, "fruit");
    FoodTileInfo tile3 = new FoodTileInfo("apples", date, date, 20.00, 5, "fruit");
    FoodTileInfo[] data = new FoodTileInfo[] {tile1,tile2,tile3};

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_inventory, container, false); // ** Should I attach to root?
        recyclerView = (RecyclerView) rootView.findViewById(R.id.inventory_recycler_view);

        // This setting will improve performance as the layout size of the RecyclerView will not
        // change with changes in content
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        adapter = new InventoryAdapter(data);
        recyclerView.setAdapter(adapter);

        return rootView;

    }

}
