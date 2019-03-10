package ca.cois2240group20.grocerymanagementapp.array_adapters;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import ca.cois2240group20.grocerymanagementapp.FoodTileInfo;
import ca.cois2240group20.grocerymanagementapp.R;

/*
This class is used by the ListItem view to generate view items in list format, from an array passed
as an argument. There is a pre-build ArrayAdapter class, however its default behaviour is to take
an array of strings, and generate list items with a toString() method. The purpose of this class is
to add some custom behaviour. It will allow list items to be generated with our custom food_tile_layout
ViewGroup, based on user info passed as a FoodTileInfo object.
*/

public class InventoryArrayAdapter extends ArrayAdapter<FoodTileInfo> {
    private final Context context;
    private final FoodTileInfo[] info;

    public InventoryArrayAdapter(Context context, FoodTileInfo[] info) {
        super(context, -1, info);
        this.context = context;
        this.info = info;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View foodTileView = inflater.inflate(R.layout.food_tile_layout, parent, false);
    }
}
