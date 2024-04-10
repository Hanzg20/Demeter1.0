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
    private int itemTypeName;
    
    public static SubscriptionViewModelItem convertFrom(NotificationDTO notificationDTO,ItemDTO itemDTO)
    {
        SubscriptionViewModelItem result = new SubscriptionViewModelItem();
        
        return result;
    }
}
