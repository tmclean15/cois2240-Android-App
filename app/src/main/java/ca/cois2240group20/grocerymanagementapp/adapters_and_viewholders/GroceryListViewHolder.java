package ca.cois2240group20.grocerymanagementapp.adapters_and_viewholders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class GroceryListViewHolder extends RecyclerView.ViewHolder {

    public View foodTile;

    public GroceryListViewHolder(@NonNull View view) {
        super(view);
        foodTile = view;
    }
}
