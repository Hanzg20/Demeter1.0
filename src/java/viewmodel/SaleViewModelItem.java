/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

import java.sql.Timestamp;
import model.ItemDTO;
import model.ItemListingDTO;
import model.ItemTypeDTO;
import model.LocationDTO;

/**
 *
 * @author liyingguo
 */
public class SaleViewModelItem {

    private int listingId;
    private Timestamp listingDate;   
    private String itemName;
    private String unit;
    private String itemTypeName;
    private int quantity;
    private Timestamp expirDate;   
    private String address;
    private double discountRate;
    

    public int getListingId() {
        return listingId;
    }

    public void setListingId(int listingId) {
        this.listingId = listingId;
    }

    public Timestamp getListingDate() {
        return listingDate;
    }

    public void setListingDate(Timestamp listingDate) {
        this.listingDate = listingDate;
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

    public String getItemTypeName() {
        return itemTypeName;
    }

    public void setItemTypeName(String itemTypeName) {
        this.itemTypeName = itemTypeName;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }
    
    

    public static SaleViewModelItem convertFrom(ItemListingDTO itemListingDTO,
            ItemDTO itemDTO, ItemTypeDTO itemTypeDTO, LocationDTO locationDTO) 
    {
        SaleViewModelItem result = new SaleViewModelItem();
        result.setListingId(itemListingDTO.getListingId());
        result.setListingDate(itemListingDTO.getListingDate());
        result.setItemName(itemDTO.getItemName());
        result.setUnit(itemDTO.getUnit());
        result.setItemTypeName(itemTypeDTO.getItemTypeName());
        result.setQuantity(itemDTO.getQuantity());
        result.setExpirDate(itemDTO.getExpirDate());
        result.setAddress(locationDTO.getAddress());
        result.setDiscountRate(itemListingDTO.getDiscountRate());
              
        return result;
    }

}
