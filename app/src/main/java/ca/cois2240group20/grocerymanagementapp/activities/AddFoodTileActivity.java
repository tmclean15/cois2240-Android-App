package ca.cois2240group20.grocerymanagementapp.activities;

import android.app.DatePickerDialog;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import ca.cois2240group20.grocerymanagementapp.R;
import ca.cois2240group20.grocerymanagementapp.utility.FoodTileInfo;
import ca.cois2240group20.grocerymanagementapp.utility.Utility;
import ca.cois2240group20.grocerymanagementapp.view_models.SharedViewModel;

public class AddFoodTileActivity extends FragmentActivity {
    private EditText mDisplayProduct;
    private EditText mDisplayQuantity;
    private EditText mDisplayPrice;
    private EditText mDisplayPurchaseDate;
    private EditText mDisplayExpiryDate;
    private DatePickerDialog.OnDateSetListener mPurchaseDateSetListener;
    private DatePickerDialog.OnDateSetListener mExpiryDateSetListener;

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
        FoodTileInfo dataToBeEdited;
        if (launchIntent.getStringExtra("edit") != null) {
            dataToBeEdited = launchIntent.getParcelableExtra("FoodTileInfo");
            mDisplayProduct.setText(Utility.trySetString(dataToBeEdited.getProduct()));
            String purchaseDateText = Utility.trySetDateString(dataToBeEdited.getPurchaseDate());
            mDisplayPurchaseDate.setText(purchaseDateText);
            String expiryDateText = Utility.trySetDateString(dataToBeEdited.getExpiryDate());
            mDisplayExpiryDate.setText(expiryDateText);
            String priceText = Utility.trySetString(dataToBeEdited.getPrice().toString());
            mDisplayPrice.setText(priceText);
            String quantityText = Utility.trySetString(dataToBeEdited.getQuantity().toString());
            mDisplayQuantity.setText(quantityText);
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

                FoodTileInfo data = new FoodTileInfo(product, purchaseDate, expiryDate, price, quantity);

                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                intent.putExtra("FoodTileInfo", data);

                // Depending on which fragment sent the intent (InventoryFragment or GroceryListFragment)
                // a new intent will be sent back to MainActivity, with extra information to tell
                // MainActivity whether to call addInventory or addGroceryList

                if (launchIntent.getStringExtra("method") != null) {
                    if (launchIntent.getStringExtra("method").equals("Inventory")) {
                        intent.putExtra("method", "addInventory");
                        startActivity(intent);
                    } else if (launchIntent.getStringExtra("method").equals("GroceryList")) {
                        intent.putExtra("method", "addGroceryList");
                        startActivity(intent);
                    } else {
                        // If the intent that launched this activity was not launched by either
                        // Inventory or GroceryList, then an error occurred that should be handled
                        // by MainActivity. This shouldn't happen, but just in case
                        intent.putExtra("method", "error");
                        startActivity(intent);
                    }
                }

                // If the activity was launched from an edit button, this code will execute instead
                if (launchIntent.getStringExtra("edit") != null) {
                    int indexBeingEdited = launchIntent.getIntExtra("index", -1);
                    if (launchIntent.getStringExtra("edit").equals("Inventory")) {
                        intent.putExtra("edit", "editInventory");
                        intent.putExtra("index", indexBeingEdited);
                        startActivity(intent);
                    }
                    else if (launchIntent.getStringExtra("edit").equals("GroceryList")) {
                        intent.putExtra("edit", "editGroceryList");
                        intent.putExtra("index", indexBeingEdited);
                        startActivity(intent);
                    }
                    else {
                        intent.putExtra("edit", "error");
                        startActivity(intent);
                    }
                }
            }
        });
    }
}
