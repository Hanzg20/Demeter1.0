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
import model.TransactionDTO;

/**
 *
 * @author liyingguo
 */
public class ClaimViewModelItem {
    
    private int listingId;
    private Timestamp listingDate; 
    private int itemId;
    private String itemName;
    private String unit;
    private String itemTypeName;
    private int quantity;
    private Timestamp expirDate;   
    private String address;
    private Timestamp tranDate;

   
    public int getListingId() {
        return listingId;
    }

    public void setListingId(int listingId) {
        this.listingId = listingId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
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

    public Timestamp getTranDate() {
        return tranDate;
    }

    public void setTranDate(Timestamp tranDate) {
        this.tranDate = tranDate;
    }
    
    

    public static ClaimViewModelItem convertFrom(TransactionDTO transactionDTO,ItemListingDTO itemListingDTO,
            ItemDTO itemDTO, ItemTypeDTO itemTypeDTO, LocationDTO locationDTO) 
    {
        ClaimViewModelItem result = new ClaimViewModelItem();
        result.setListingId(itemListingDTO.getListingId());
        result.setListingDate(itemListingDTO.getListingDate());
        result.setItemId(itemDTO.getItemId());
        result.setItemName(itemDTO.getItemName());
        result.setUnit(itemDTO.getUnit());
        result.setItemTypeName(itemTypeDTO.getItemTypeName());
        result.setQuantity(transactionDTO.getQuantity());
        result.setExpirDate(itemDTO.getExpirDate());
        result.setAddress(locationDTO.getAddress());
        result.setTranDate(transactionDTO.getTranDate());
              
        return result;
    }

}
