package ca.cois2240group20.grocerymanagementapp;

import java.util.Currency;
import java.util.Date;

public class FoodTileInfo {
    private String product;
    private Date purchaseDate;
    private Date expiryDate;
    private Double price;
    private int quantity;
    private String foodGroup;

    public FoodTileInfo(String product, Date purchaseDate, Date expiryDate, Double price,
                        int quantity, String foodGroup) {
        this.product = product;
        this.purchaseDate = purchaseDate;
        this.expiryDate = expiryDate;
        this.price = price;
        this.quantity = quantity;
        this.foodGroup = foodGroup;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getFoodGroup() {
        return foodGroup;
    }

    public void setFoodGroup(String foodGroup) {
        this.foodGroup = foodGroup;
    }
}
