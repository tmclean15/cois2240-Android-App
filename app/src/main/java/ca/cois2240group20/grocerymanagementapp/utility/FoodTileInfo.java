package ca.cois2240group20.grocerymanagementapp.utility;

import android.arch.persistence.room.*;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.Currency;
import java.util.Date;

@Entity
@TypeConverters(DateConverter.class)
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

    public FoodTileInfo(String product, Date purchaseDate, Date expiryDate, Double price,
                        int quantity) {
        this.product = product;
        this.purchaseDate = purchaseDate;
        this.expiryDate = expiryDate;
        this.price = price;
        this.quantity = quantity;
    }


    protected FoodTileInfo(Parcel in) {
        product = in.readString();
        int isPurchaseDateNull = in.readInt();
        long purchaseDateLong = in.readLong();
        if (isPurchaseDateNull == 0) {
            purchaseDate = null;
        } else {
            purchaseDate = new Date(purchaseDateLong);
        }
        int isExpiryDateNull = in.readInt();
        long expiryDateLong = in.readLong();
        if (isExpiryDateNull == 0) {
            expiryDate = null;
        } else {
            expiryDate = new Date(expiryDateLong);
        }
        //purchaseDate = in.readLong() == -1 ? null : new Date(in.readLong());
        //expiryDate = in.readLong() == -1 ? null : new Date(in.readLong());
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
        int isPurchaseDateNull = (getPurchaseDate() == null) ? 0 : 1;
        long purchaseDateLong = (getPurchaseDate() == null) ? 0 : getPurchaseDate().getTime();
        dest.writeInt(isPurchaseDateNull);
        dest.writeLong(purchaseDateLong);
        int isExpiryDateNull = (getExpiryDate() == null) ? 0 : 1;
        long expiryDateLong = (getExpiryDate() == null) ? 0 : getExpiryDate().getTime();
        dest.writeInt(isExpiryDateNull);
        dest.writeLong(expiryDateLong);
        dest.writeDouble(price == null ? 0 : price);
        dest.writeInt(quantity == null ? 0 : quantity);
    }

}
