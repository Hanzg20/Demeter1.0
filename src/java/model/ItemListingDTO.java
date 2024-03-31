/**
 * File name: ItemDTO.java
 * Author: Liying Guo, 040858257
 * Course: CST8288 OOP with Design Patterns
 * Assignment: Final Project
 * Date: 2024-03-21
 * Professor: Gustavo Adami
 * Purpose: database entity to keep Item_listing record
 */
package model;

/**
 *
 * @author Glily
 */
public class ItemListingDTO {
    private int listingId;
    private int itemId;
    private String isDonation;
    private double discountRate;
    private long listingDate;
    
    public ItemListingDTO(int listingId, int itemId, String isDonation, double discountRate, long listingDate) {
        this.listingId = listingId;
        this.itemId = itemId;
        this.isDonation = isDonation;
        this.discountRate = discountRate;
        this.listingDate = listingDate;
    }

    public ItemListingDTO() {
    }

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

    public String getIsDonation() {
        return isDonation;
    }

    public void setIsDonation(String isDonation) {
        this.isDonation = isDonation;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }

    public long getListingDate() {
        return listingDate;
    }

    public void setListingDate(long listingDate) {
        this.listingDate = listingDate;
    }
    
        
}
