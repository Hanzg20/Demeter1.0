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

import java.sql.Timestamp;

public class ItemDTO {

    private int itemId;
    private String itemName;
    private String unit;
    private int locationId;
    private Timestamp createDate;
    private int userId;
    private int itemTypeId;
    private int quantity;
    private Timestamp expirDate;
    private double price;
    private String status;
    private Timestamp statusDate;

//    public ItemDTO(String itemName, String unit, int locationId, Timestamp createDate, int userId, int itemType, int quantity, Timestamp expirDate, double price, String status, Timestamp statusDate) {
//        this(0, itemName, unit, locationId, createDate, userId, itemType, quantity, expirDate, price, status, statusDate);
//
//    }

    public ItemDTO(int itemId, String itemName, String unit, int locationId, Timestamp createDate, int userId, int itemType, int quantity, Timestamp expirDate, double price, String status, Timestamp statusDate) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.unit = unit;
        this.locationId = locationId;
        this.createDate = createDate;
        this.userId = userId;
        this.itemTypeId = itemType;
        this.quantity = quantity;
        this.expirDate = expirDate;
        this.price = price;
        this.status = status;
        this.statusDate = statusDate;

    }

    public ItemDTO() {
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

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getItemTypeId() {
        return itemTypeId;
    }

    public void setItemTypeId(int itemType) {
        this.itemTypeId = itemType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Timestamp getExpirDate() {
        return expirDate;
    }

    public void setExpirDate(Timestamp expirDate) {
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

    public Timestamp getStatusDate() {
        return statusDate;
    }

    public void setStatusDate(Timestamp statusDate) {
        this.statusDate = statusDate;
    }
}
