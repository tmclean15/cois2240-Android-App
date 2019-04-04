package ca.cois2240group20.grocerymanagementapp.utility;

import android.arch.persistence.room.*;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.Currency;
import java.util.Date;

@Entity
public class FoodTileInfo implements Parcelable {
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

    public FoodTileInfo(Integer id, String product, Date purchaseDate, Date expiryDate, Double price,
                        int quantity) {
        this.id = id;
        this.product = product;
        this.purchaseDate = purchaseDate;
        this.expiryDate = expiryDate;
        this.price = price;
        this.quantity = quantity;
    }


    protected FoodTileInfo(Parcel in) {
        product = in.readString();
        setPurchaseDate(in.readLong() == -1 ? null : new Date(in.readLong()));
        setExpiryDate(in.readLong() == -1 ? null : new Date(in.readLong()));
        price = in.readDouble();
        quantity = in.readInt();
    }

    public static final Creator<FoodTileInfo> CREATOR = new Creator<FoodTileInfo>() {
        @Override
        public FoodTileInfo createFromParcel(Parcel in) {
            return new FoodTileInfo(in);
        }

        @Override
        public FoodTileInfo[] newArray(int size) {
            return new FoodTileInfo[size];
        }
    };

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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
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
