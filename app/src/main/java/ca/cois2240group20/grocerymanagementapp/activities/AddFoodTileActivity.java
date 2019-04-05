package ca.cois2240group20.grocerymanagementapp.activities;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;
import java.util.Date;

import ca.cois2240group20.grocerymanagementapp.R;
<<<<<<< HEAD
import ca.cois2240group20.grocerymanagementapp.database.Tables.FoodTileInfoInventory;
=======
import ca.cois2240group20.grocerymanagementapp.database.entities.FoodTileInfoGroceryList;
import ca.cois2240group20.grocerymanagementapp.database.entities.FoodTileInfoInventory;
>>>>>>> 2c84a427757f680022f6749e9a0644357a3212b2
import ca.cois2240group20.grocerymanagementapp.utility.Utility;

public class AddFoodTileActivity extends FragmentActivity {
    private static final String TAG = "AddFoodTileActivity";
    private EditText mDisplayProduct;
    private EditText mDisplayQuantity;
    private EditText mDisplayPrice;
    private EditText mDisplayPurchaseDate;
    private EditText mDisplayExpiryDate;
    private DatePickerDialog.OnDateSetListener mPurchaseDateSetListener;
    private DatePickerDialog.OnDateSetListener mExpiryDateSetListener;

<<<<<<< HEAD
    private FoodTileInfoInventory data;

=======
>>>>>>> 2c84a427757f680022f6749e9a0644357a3212b2
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_food_tile);

        // This grabs the intent that launched the activity. It will provide info about
        // what actions to perform
        final Intent launchIntent = getIntent();

        mDisplayProduct = (EditText) findViewById(R.id.addProduct);
        mDisplayQuantity = (EditText) findViewById(R.id.addQuantity);
        mDisplayPrice = (EditText) findViewById(R.id.addPrice);
        mDisplayPurchaseDate = (EditText) findViewById(R.id.addPurchaseDate);
        mDisplayExpiryDate = (EditText) findViewById(R.id.addExpiryDate);

        // If this activity was launched from an edit button listener, we want to pre-populate
        // the UI with the data of the food tile being edited
        FoodTileInfoInventory inventoryToBeEdited;
        FoodTileInfoGroceryList groceryToBeEdited;

        if (launchIntent.getStringExtra("edit") != null) {
            if (launchIntent.getStringExtra("edit").equals("Inventory")) {
                inventoryToBeEdited = launchIntent.getParcelableExtra("FoodTileInfoInventory");
                mDisplayProduct.setText(Utility.trySetString(inventoryToBeEdited.getProduct()));
                String purchaseDateText = Utility.trySetDateString(inventoryToBeEdited.getPurchaseDate());
                mDisplayPurchaseDate.setText(purchaseDateText);
                String expiryDateText = Utility.trySetDateString(inventoryToBeEdited.getExpiryDate());
                mDisplayExpiryDate.setText(expiryDateText);
                String priceText = Utility.trySetString(inventoryToBeEdited.getPrice().toString());
                mDisplayPrice.setText(priceText);
                String quantityText = Utility.trySetString(inventoryToBeEdited.getQuantity().toString());
                mDisplayQuantity.setText(quantityText);
            }
            else if (launchIntent.getStringExtra("edit").equals("GroceryList")) {
                groceryToBeEdited = launchIntent.getParcelableExtra("FoodTileInfoGroceryList");
                mDisplayProduct.setText(Utility.trySetString(groceryToBeEdited.getProduct()));
                String purchaseDateText = Utility.trySetDateString(groceryToBeEdited.getPurchaseDate());
                mDisplayPurchaseDate.setText(purchaseDateText);
                String expiryDateText = Utility.trySetDateString(groceryToBeEdited.getExpiryDate());
                mDisplayExpiryDate.setText(expiryDateText);
                String priceText = Utility.trySetString(groceryToBeEdited.getPrice().toString());
                mDisplayPrice.setText(priceText);
                String quantityText = Utility.trySetString(groceryToBeEdited.getQuantity().toString());
                mDisplayQuantity.setText(quantityText);
            }
            else {
                Log.d(TAG, "Edit was launched with improper data");
            }
        }

        // The next few lines of code set up the DatePickerDialog widgets, along with listeners to
        // display the proper dates selected in the purchase date and expiry date text fields

        mDisplayPurchaseDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        AddFoodTileActivity.this,
                        R.style.Theme_AppCompat,
                        mPurchaseDateSetListener,
                        year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.GRAY));
                dialog.show();
            }
        });

        mDisplayExpiryDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        AddFoodTileActivity.this,
                        R.style.Theme_AppCompat,
                        mExpiryDateSetListener,
                        year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.GRAY));
                dialog.show();
            }
        });

        mPurchaseDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month += 1;
                String date = month + "/" + dayOfMonth + "/" + year;
                mDisplayPurchaseDate.setText(date);
            }
        };

        mExpiryDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month += 1;
                String date = month + "/" + dayOfMonth + "/" + year;
                mDisplayExpiryDate.setText(date);
            }
        };

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fabAddInventory);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Packages up all of the data input by the user into a FoodTileInfo object, to
                // be sent back to MainActivity

                String product = Utility.trySetString(mDisplayProduct.getText().toString());
                Date purchaseDate = Utility.tryParseDate(mDisplayPurchaseDate.getText().toString());
                Date expiryDate = Utility.tryParseDate((mDisplayExpiryDate.getText().toString()));
                Double price = Utility.tryParseDouble(mDisplayPrice.getText().toString());
                int quantity = Utility.tryParseInt(mDisplayQuantity.getText().toString());

<<<<<<< HEAD
                data = new FoodTileInfoInventory(product, purchaseDate, expiryDate, price, quantity);

                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                intent.putExtra("FoodTileInfoInventory", data);
                intent.putExtra("method", "addInventory");
                // intent.setFlags(Intent.);
                startActivity(intent);
=======
                Intent intent = new Intent(getBaseContext(), MainActivity.class);

                // Depending on which fragment sent the intent (InventoryFragment or GroceryListFragment)
                // a new intent will be sent back to MainActivity, with extra information to tell
                // MainActivity whether to call addInventory or addGroceryList

                if (launchIntent.getStringExtra("method") != null) {
                    if (launchIntent.getStringExtra("method").equals("Inventory")) {
                        FoodTileInfoInventory data = new FoodTileInfoInventory(product, purchaseDate,
                                expiryDate, price, quantity);
                        intent.putExtra("FoodTileInfoInventory", data);
                        intent.putExtra("method", "addInventory");
                        startActivity(intent);
                    } else if (launchIntent.getStringExtra("method").equals("GroceryList")) {
                        FoodTileInfoGroceryList data = new FoodTileInfoGroceryList(product, purchaseDate,
                                expiryDate, price, quantity);
                        intent.putExtra("FoodTileInfoGroceryList", data);
                        intent.putExtra("method", "addGroceryList");
                        startActivity(intent);
                    } else {
                        // If the intent that launched this activity was not launched by either
                        // Inventory or GroceryList, then an error occurred that should be handled
                        // by MainActivity. This shouldn't happen, but just in case
                        Log.d(TAG, "Error adding food tile");
                        intent.putExtra("method", "error");
                        startActivity(intent);
                    }
                }

                // If the activity was launched from an edit button, this code will execute instead
                if (launchIntent.getStringExtra("edit") != null) {
                    int indexBeingEdited = launchIntent.getIntExtra("index", -1);
                    if (launchIntent.getStringExtra("edit").equals("Inventory")) {
                        FoodTileInfoInventory data = new FoodTileInfoInventory(product, purchaseDate,
                                expiryDate, price, quantity);
                        intent.putExtra("FoodTileInfoInventory", data);
                        intent.putExtra("edit", "editInventory");
                        intent.putExtra("index", indexBeingEdited);
                        startActivity(intent);
                    } else if (launchIntent.getStringExtra("edit").equals("GroceryList")) {
                        FoodTileInfoGroceryList data = new FoodTileInfoGroceryList(product, purchaseDate,
                                expiryDate, price, quantity);
                        intent.putExtra("FoodTileInfoGroceryList", data);
                        intent.putExtra("edit", "editGroceryList");
                        intent.putExtra("index", indexBeingEdited);
                        startActivity(intent);
                    } else {
                        intent.putExtra("edit", "error");
                        startActivity(intent);
                    }
                }
>>>>>>> 2c84a427757f680022f6749e9a0644357a3212b2
            }
        });
    }
}
