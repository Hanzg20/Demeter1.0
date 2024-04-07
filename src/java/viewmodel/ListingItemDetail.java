/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

import java.sql.Timestamp;
import model.EnumStatusType;
import model.ItemDTO;

/**
 *
 * @author hanzg
 */
public class ListingItemDetail {
    
    private int itemId;
    private String itemName;
    private String unit;
    private String location;
    private Timestamp createDate;
    private String userName;
    private String itemType;
    private int quantity;
    private Timestamp expirDate;
    private double price;
    private String status;
    private Timestamp statusDate;

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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
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

    public static ListingItemDetail convertFrom(ItemDTO dto) {
        ListingItemDetail result = new ListingItemDetail();
        result.setItemId(dto.getItemId());
        result.setItemName(dto.getItemName());
        result.setUnit(dto.getUnit());
        result.setCreateDate(dto.getCreateDate());
        result.setQuantity(dto.getQuantity());
        result.setExpirDate(dto.getExpirDate());
        result.setPrice(dto.getPrice());
        result.setStatus(EnumStatusType.fromSymbol(dto.getStatus()).getText());
        result.setStatusDate(dto.getStatusDate());
        return result;
    }
    
}
