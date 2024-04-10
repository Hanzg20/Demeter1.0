/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

import java.util.ArrayList;
import java.util.List;
import model.ItemDTO;
import model.ItemTypeDTO;
import model.SubscriptionDTO;

/**
 *
 * @author Glily
 */
public class SubscriptionViewModelItem {
    private List<SubscriptionViewModelItem> items = new ArrayList<>();
    private List<ItemTypeDTO> typeOptions = new ArrayList<>(); 
    
    public static SubscriptionViewModelItem convertFrom(SubscriptionDTO subscriptionDTO, ItemDTO itemDTO) {
        SubscriptionViewModelItem result = new SubscriptionViewModelItem();

        return result;
    }
}
