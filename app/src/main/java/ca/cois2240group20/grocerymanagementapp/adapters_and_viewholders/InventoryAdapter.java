package ca.cois2240group20.grocerymanagementapp.adapters_and_viewholders;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

import ca.cois2240group20.grocerymanagementapp.activities.AddFoodTileActivity;
import ca.cois2240group20.grocerymanagementapp.database.entities.FoodTileInfoGroceryList;
import ca.cois2240group20.grocerymanagementapp.database.entities.FoodTileInfoInventory;
import ca.cois2240group20.grocerymanagementapp.R;
import ca.cois2240group20.grocerymanagementapp.utility.Utility;
import ca.cois2240group20.grocerymanagementapp.view_models.SharedViewModel;

public class InventoryAdapter extends RecyclerView.Adapter<InventoryViewHolder> {
    private List<FoodTileInfoInventory> foodTileData;
    private RecyclerView recyclerView;
    private SharedViewModel model;

    public InventoryAdapter(List<FoodTileInfoInventory> data, RecyclerView recycler, SharedViewModel viewModel) {
        foodTileData = data;
        recyclerView = recycler;
        model = viewModel;
    }


    @NonNull
    @Override
    public InventoryViewHolder onCreateViewHolder(@NonNull final ViewGroup viewGroup, int i) {
        View view = (View) LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.food_tile_layout, viewGroup, false);
        ImageButton removeButton = (ImageButton) view.findViewById(R.id.removeItem);
        removeButton.setOnClickListener(removeListener);
        ImageButton editButton = (ImageButton) view.findViewById(R.id.editItem);
        editButton.setOnClickListener(editListener);
        return new InventoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final InventoryViewHolder holder, int position) {
        // When a food tile is created, the UI gets set with data from FoodTileData objects
        View foodTileView = holder.foodTile;
        TextView product = foodTileView.findViewById(R.id.product);
        product.setText(Utility.trySetString(foodTileData.get(position).getProduct()));
        TextView expiry = foodTileView.findViewById(R.id.expiry);
        expiry.setText(Utility.trySetDateString(foodTileData.get(position).getExpiryDate()));
        TextView quantity = foodTileView.findViewById(R.id.quantity);
        quantity.setText(Utility.trySetString(Integer.toString(foodTileData.get(position).getQuantity())));
        TextView price = foodTileView.findViewById(R.id.price);
        price.setText(Utility.trySetString(Double.toString(foodTileData.get(position).getPrice())));

    }

    @Override
    public int getItemCount() {
        if (foodTileData == null) return 0;
        else return foodTileData.size();
    }

    private void notifyChange() {
        this.notifyDataSetChanged();
    }

    // Used for remove button
    View.OnClickListener removeListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            RecyclerView.ViewHolder holder = recyclerView.findContainingViewHolder(view);
            int indexOfFoodTile = holder.getAdapterPosition();
            FoodTileInfoInventory inventoryData = model.accessInventory(indexOfFoodTile);
            FoodTileInfoGroceryList groceryData = new FoodTileInfoGroceryList(inventoryData.getProduct(),
                    inventoryData.getPurchaseDate(), inventoryData.getExpiryDate(),
                    inventoryData.getPrice(), inventoryData.getQuantity());
            model.addGroceryList(groceryData);
            model.removeInventory(indexOfFoodTile);
            notifyChange();
        }
    };

    // Used for edit button
    View.OnClickListener editListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            RecyclerView.ViewHolder holder = recyclerView.findContainingViewHolder(view);
            int indexOfFoodTile = holder.getAdapterPosition();
            FoodTileInfoInventory dataOfFoodTile = model.accessInventory(indexOfFoodTile);
            Intent intent = new Intent(view.getContext(), AddFoodTileActivity.class);
            intent.putExtra("FoodTileInfoInventory", dataOfFoodTile);
            intent.putExtra("index", indexOfFoodTile);
            intent.putExtra("edit", "Inventory");
            view.getContext().startActivity(intent);
        }
    };
}
