package model;

/**
 * Data transfer object for subscription information.
 * Represents a subscription with subscription ID, user ID, notification method,
 * item location, item price, and item type ID.
 * 
 * @author Glily
 */
public class SubscriptionDTO {
    private int subsId;
    private int userId;
    private String notiMethod;
    private String itemLocation;
    private double itemPrice;
    private int itemTypeId;

    /**
     * Constructs a SubscriptionDTO with the specified parameters.
     * 
     * @param subsId The subscription ID
     * @param userId The user ID
     * @param notiMethod The notification method
     * @param itemLocation The item location
     * @param itemPrice The item price
     * @param itemTypeId The item type ID
     */
    public SubscriptionDTO(int subsId, int userId, String notiMethod, String itemLocation, double itemPrice, int itemTypeId) {
        this.subsId = subsId;
        this.userId = userId;
        this.notiMethod = notiMethod;
        this.itemLocation = itemLocation;
        this.itemPrice = itemPrice;
        this.itemTypeId = itemTypeId;
    }

    /**
     * Constructs an empty SubscriptionDTO.
     */
    public SubscriptionDTO() {
    }

    // Getters and setters

    public int getSubsId() {
        return subsId;
    }

    public void setSubsId(int subsId) {
        this.subsId = subsId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getNotiMethod() {
        return notiMethod;
    }

    public void setNotiMethod(String notiMethod) {
        this.notiMethod = notiMethod;
    }

    public String getItemLocation() {
        return itemLocation;
    }

    public void setItemLocation(String itemLocation) {
        this.itemLocation = itemLocation;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getItemTypeId() {
        return itemTypeId;
    }

    public void setItemTypeId(int itemTypeId) {
        this.itemTypeId = itemTypeId;
    }
}
