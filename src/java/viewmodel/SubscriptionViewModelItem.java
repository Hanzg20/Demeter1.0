/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

import java.util.ArrayList;
import java.util.List;
import model.ItemDTO;
import model.ItemTypeDTO;
import model.NotificationDTO;
import model.SubscriptionDTO;

/**
 *
 * @author Glily
 */
public class SubscriptionViewModelItem {
    private int subsId;
    private int userId;
    private String notiMethod;
    private String itemLocation;
    private double itemPrice;
    private String itemTypeName;

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

    public String getItemTypeName() {
        return itemTypeName;
    }

    public void setItemTypeName(String itemTypeName) {
        this.itemTypeName = itemTypeName;
    }
    
    public static SubscriptionViewModelItem convertFrom(SubscriptionDTO dto,ItemTypeDTO itemTypeDTO)
    {
        SubscriptionViewModelItem result = new SubscriptionViewModelItem();
        result.setItemLocation(dto.getItemLocation());
        result.setItemPrice(dto.getItemPrice());
        result.setItemTypeName(itemTypeDTO.getItemTypeName());
        result.setNotiMethod(dto.getNotiMethod());
        result.setSubsId(dto.getSubsId());
        result.setUserId(dto.getUserId());
        return result;
    }
}
