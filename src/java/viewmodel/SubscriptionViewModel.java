/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

import java.util.ArrayList;
import java.util.List;
import model.ItemTypeDTO;

/**
 *
 * @author Glily
 */
public class SubscriptionViewModel {
        private List<SubscriptionViewModelItem> items = new ArrayList<>();
    private List<ItemTypeDTO> typeOptions = new ArrayList<>();    

    public List<SubscriptionViewModelItem> getItems() {
        return items;
    }

    public void setItems(List<SubscriptionViewModelItem> items) {
        this.items = items;
    }

    public List<ItemTypeDTO> getTypeOptions() {
        return typeOptions;
    }

    public void setTypeOptions(List<ItemTypeDTO> typeOptions) {
        this.typeOptions = typeOptions;
    }
    

}
