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
public class NotifictionViewModel {
    private List<NotifictionViewModelItem> items = new ArrayList<>();
    private List<ItemTypeDTO> typeOptions = new ArrayList<>();    

    public List<NotifictionViewModelItem> getItems() {
        return items;
    }

    public void setItems(List<NotifictionViewModelItem> items) {
        this.items = items;
    }

    public List<ItemTypeDTO> getTypeOptions() {
        return typeOptions;
    }

    public void setTypeOptions(List<ItemTypeDTO> typeOptions) {
        this.typeOptions = typeOptions;
    }
    
    
}
