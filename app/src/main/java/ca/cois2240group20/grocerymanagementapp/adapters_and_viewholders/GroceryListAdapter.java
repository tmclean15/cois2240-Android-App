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

import ca.cois2240group20.grocerymanagementapp.R;
import ca.cois2240group20.grocerymanagementapp.activities.AddFoodTileActivity;
import ca.cois2240group20.grocerymanagementapp.utility.FoodTileInfo;
import ca.cois2240group20.grocerymanagementapp.utility.Utility;
import ca.cois2240group20.grocerymanagementapp.view_models.SharedViewModel;

public class GroceryListAdapter extends RecyclerView.Adapter<GroceryListViewHolder> {
    private List<FoodTileInfo> foodTileData;
    private RecyclerView recyclerView;
    private SharedViewModel model;

    public GroceryListAdapter(List<FoodTileInfo> data, RecyclerView recycler, SharedViewModel viewModel) {
        foodTileData = data;
        recyclerView = recycler;
        model = viewModel;
    }


    @NonNull
    @Override
    public GroceryListViewHolder onCreateViewHolder(@NonNull final ViewGroup viewGroup, int i) {
        View view = (View) LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.food_tile_layout_test, viewGroup, false);
        ImageButton removeButton = (ImageButton) view.findViewById(R.id.removeItem);
        removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RecyclerView.ViewHolder holder = recyclerView.findContainingViewHolder(view);
                int indexOfFoodTile = holder.getAdapterPosition();
                model.removeGroceryList(indexOfFoodTile);
                notifyChange();
            }
        });
        return new GroceryListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final GroceryListViewHolder holder, int position) {
        // When a food tile is created, the text in the view gets set with data from FoodTileData objects
        View foodTileView = holder.foodTile;
        TextView product = foodTileView.findViewById(R.id.product);
        product.setText(Utility.trySetString(foodTileData.get(position).getProduct()));
        TextView expiry = foodTileView.findViewById(R.id.expiry);
        expiry.setText(Utility.trySetDateString(foodTileData.get(position).getExpiryDate()));
        TextView quantity = foodTileView.findViewById(R.id.quantity);
        quantity.setText(Utility.trySetString(Integer.toString(foodTileData.get(position).getQuantity())));
        TextView price = foodTileView.findViewById(R.id.price);
        price.setText(Utility.trySetString(Double.toString(foodTileData.get(position).getPrice())));

        ImageButton removeButton = (ImageButton) foodTileView.findViewById(R.id.removeItem);
        removeButton.setOnClickListener(removeListener);
        ImageButton editButton = (ImageButton) foodTileView.findViewById(R.id.editItem);
        editButton.setOnClickListener(editListener);
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
            model.removeGroceryList(indexOfFoodTile);
            notifyChange();
        }
    };

    // Used for edit button
    View.OnClickListener editListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            RecyclerView.ViewHolder holder = recyclerView.findContainingViewHolder(view);
            int indexOfFoodTile = holder.getAdapterPosition();
            FoodTileInfo dataOfFoodTile = model.accessGroceryList(indexOfFoodTile);
            Intent intent = new Intent(view.getContext(), AddFoodTileActivity.class);
            intent.putExtra("FoodTileInfo", dataOfFoodTile);
            intent.putExtra("index", indexOfFoodTile);
            intent.putExtra("edit", "GroceryList");
            view.getContext().startActivity(intent);
        }
    };
}
