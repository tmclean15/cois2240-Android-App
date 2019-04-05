package ca.cois2240group20.grocerymanagementapp.database.entities;

import android.arch.persistence.room.*;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

import ca.cois2240group20.grocerymanagementapp.utility.DateConverter;

@Entity (tableName = "Inventory")
@TypeConverters(DateConverter.class)
public class FoodTileInfoInventory implements Parcelable {
    @PrimaryKey(autoGenerate = true) //Will auto make primary Key
    private Integer id;
    //Non-Identifying columns
    @ColumnInfo(name = "product")
    private String product;
    @ColumnInfo(name = "purchaseDate")
    private Date purchaseDate;
    @ColumnInfo(name = "expiryDate")
    private Date expiryDate;
    @ColumnInfo(name = "price")
    private Double price;
    @ColumnInfo(name = "quantity")
    private Integer quantity;

    public FoodTileInfoInventory(String product, Date purchaseDate, Date expiryDate, Double price,
                                 int quantity) {
        this.product = product;
        this.purchaseDate = purchaseDate;
        this.expiryDate = expiryDate;
        this.price = price;
        this.quantity = quantity;
    }


    protected FoodTileInfoInventory(Parcel in) {
        product = in.readString();
        setPurchaseDate(in.readLong() == -1 ? null : new Date(in.readLong()));
        setExpiryDate(in.readLong() == -1 ? null : new Date(in.readLong()));
        price = in.readDouble();
        quantity = in.readInt();
    }

    public static final Creator<FoodTileInfoInventory> CREATOR = new Creator<FoodTileInfoInventory>() {
        @Override
        public FoodTileInfoInventory createFromParcel(Parcel in) {
            return new FoodTileInfoInventory(in);
        }

        @Override
        public FoodTileInfoInventory[] newArray(int size) {
            return new FoodTileInfoInventory[size];
        }
    };

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(product);
        dest.writeLong(getPurchaseDate() != null ? getPurchaseDate().getTime() : -1);
        dest.writeLong(getExpiryDate() != null ? getExpiryDate().getTime() : -1);
        dest.writeDouble(price == null ? 0 : price);
        dest.writeInt(quantity == null ? 0 : quantity);
    }


}