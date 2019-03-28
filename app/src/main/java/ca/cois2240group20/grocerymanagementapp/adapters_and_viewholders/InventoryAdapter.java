package ca.cois2240group20.grocerymanagementapp.adapters_and_viewholders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ca.cois2240group20.grocerymanagementapp.FoodTileInfo;
import ca.cois2240group20.grocerymanagementapp.R;
import ca.cois2240group20.grocerymanagementapp.page_fragments.InventoryFragment;

public class InventoryAdapter extends RecyclerView.Adapter<InventoryViewHolder> {
    private FoodTileInfo[] foodTileData;

    public InventoryAdapter(FoodTileInfo[] data) {
        foodTileData = data;
    }


    @NonNull
    @Override
    public InventoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = (View) LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.food_tile_layout, viewGroup, false);
        return new InventoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InventoryViewHolder holder, int position) {
        View foodTileView = holder.foodTile;
        TextView product = foodTileView.findViewById(R.id.product);
        product.setText(foodTileData[position].getProduct());
        TextView expiry = foodTileView.findViewById(R.id.expiry);
        expiry.setText(foodTileData[position].getExpiryDate().toString());
        TextView quantity = foodTileView.findViewById(R.id.quantity);
        quantity.setText(Integer.toString(foodTileData[position].getQuantity()));
        TextView foodGroup = foodTileView.findViewById(R.id.foodgroup);
        foodGroup.setText(foodTileData[position].getFoodGroup());

    }

    @Override
    public int getItemCount() {
        return foodTileData.length;
    }
}
