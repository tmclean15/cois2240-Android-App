package ca.cois2240group20.grocerymanagementapp;

import java.util.Currency;
import java.util.Date;

public class FoodTileInfo {
    private String product;
    private Date purchaseDate;
    private Date expiryDate;
    private Double price;
    private int quantity;
    private FoodGroup group;



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

    public FoodGroup getGroup() {
        return group;
    }

    public void setGroup(FoodGroup group) {
        this.group = group;
    }
}
