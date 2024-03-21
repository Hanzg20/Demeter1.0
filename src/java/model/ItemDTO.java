/**
 * File name: ItemDTO.java
 * Author: Liying Guo, 040858257
 * Course: CST8288 OOP with Design Patterns
 * Assignment: Final Project
 * Date: 2024-03-21
 * Professor: Gustavo Adami
 * Purpose: database entity to keep Item record
 */
package model;

public class ItemDTO {
    
    private int itemId;
    private String itemName;
    private String unit;
    private int locationId;
    private long createDate;
    private int userId;
    private int itemType;
    private int quantity;
    private long expirDate;
    private double price;
    private String status;
    private long statusDate;

    
    public ItemDTO(int itemId, String itemName, String unit, int locationId, long createDate, int userId, int itemType, int quantity, long expirDate, double price, String status, long statusDate) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.unit = unit;
        this.locationId = locationId;
        this.createDate  = createDate;
        this.userId = userId;
        this.itemType = itemType;
        this.quantity = quantity;
        this.expirDate = expirDate;
        this.price = price;
        this.status = status;
        this.statusDate = statusDate;
        
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(long createDate) {
        this.createDate = createDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getItemType() {
        return itemType;
    }

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public long getExpirDate() {
        return expirDate;
    }

    public void setExpirDate(long expirDate) {
        this.expirDate = expirDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getStatusDate() {
        return statusDate;
    }

    public void setStatusDate(long statusDate) {
        this.statusDate = statusDate;
    }
    
   


    
}



    