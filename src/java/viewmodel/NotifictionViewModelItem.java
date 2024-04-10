/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

import model.ItemDTO;
import model.NotificationDTO;
import model.SubscriptionDTO;

/**
 *
 * @author Glily
 */
public class NotifictionViewModelItem {
    private int subsId;
    private int userId;
    private String notiMethod;
    private String itemLocation;
    private double itemPrice;
    private int itemTypeName;

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

    public int getItemTypeName() {
        return itemTypeName;
    }

    public void setItemTypeName(int itemTypeName) {
        this.itemTypeName = itemTypeName;
    }

    
    public static NotifictionViewModelItem convertFrom(NotificationDTO notifictionDTO,ItemDTO itemDTO)
    {
        NotifictionViewModelItem result = new NotifictionViewModelItem();
        
        return result;
    }
    
}
