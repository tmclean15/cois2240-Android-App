package ca.cois2240group20.grocerymanagementapp.adapters_and_viewholders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import ca.cois2240group20.grocerymanagementapp.utility.FoodTileInfo;
import ca.cois2240group20.grocerymanagementapp.R;
import ca.cois2240group20.grocerymanagementapp.utility.Utility;

public class InventoryAdapter extends RecyclerView.Adapter<InventoryViewHolder> {
    private List<FoodTileInfo> foodTileData;

    public InventoryAdapter(List<FoodTileInfo> data) {
        foodTileData = data;
    }


    @NonNull
    @Override
    public InventoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = (View) LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.food_tile_layout_test, viewGroup, false);
        return new InventoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InventoryViewHolder holder, int position) {
        View foodTileView = holder.foodTile;
        TextView product = foodTileView.findViewById(R.id.product);
        product.setText(Utility.trySetString(foodTileData.get(position).getProduct()));
        TextView expiry = foodTileView.findViewById(R.id.expiry);
        expiry.setText(Utility.trySetDateString(foodTileData.get(position).getExpiryDate()));
        TextView quantity = foodTileView.findViewById(R.id.quantity);
        quantity.setText(Utility.trySetString(Integer.toString(foodTileData.get(position).getQuantity())));

    }

    @Override
    public int getItemCount() {
        return foodTileData.size();
    }
}
