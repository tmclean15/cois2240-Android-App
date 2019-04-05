package ca.cois2240group20.grocerymanagementapp.activities;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;
import java.util.Date;

import ca.cois2240group20.grocerymanagementapp.R;
import ca.cois2240group20.grocerymanagementapp.database.Tables.FoodTileInfoInventory;
import ca.cois2240group20.grocerymanagementapp.utility.Utility;

public class AddFoodTileActivity extends FragmentActivity {
    private EditText mDisplayProduct;
    private EditText mDisplayQuantity;
    private EditText mDisplayPrice;
    private EditText mDisplayPurchaseDate;
    private EditText mDisplayExpiryDate;
    private DatePickerDialog.OnDateSetListener mPurchaseDateSetListener;
    private DatePickerDialog.OnDateSetListener mExpiryDateSetListener;

    private FoodTileInfoInventory data;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_food_tile);

        mDisplayProduct = (EditText) findViewById(R.id.addProduct);
        mDisplayQuantity = (EditText) findViewById(R.id.addQuantity);
        mDisplayPrice = (EditText) findViewById(R.id.addPrice);
        mDisplayPurchaseDate = (EditText) findViewById(R.id.addPurchaseDate);
        mDisplayExpiryDate = (EditText) findViewById(R.id.addExpiryDate);

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
                String product = Utility.trySetString(mDisplayProduct.getText().toString());
                Date purchaseDate = Utility.tryParseDate(mDisplayPurchaseDate.getText().toString());
                Date expiryDate = Utility.tryParseDate((mDisplayExpiryDate.getText().toString()));
                Double price = Utility.tryParseDouble(mDisplayPrice.getText().toString());
                int quantity = Utility.tryParseInt(mDisplayQuantity.getText().toString());

                data = new FoodTileInfoInventory(product, purchaseDate, expiryDate, price, quantity);

                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                intent.putExtra("FoodTileInfoInventory", data);
                intent.putExtra("method", "addInventory");
                // intent.setFlags(Intent.);
                startActivity(intent);
            }
        });
    }
}
