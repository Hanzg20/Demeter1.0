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
 * @author liyingguo
 */
public class DonationViewModel {

    private List<DonationViewModelItem> items = new ArrayList<>();
    private List<ItemTypeDTO> typeOptions = new ArrayList<>();

    public List<DonationViewModelItem> getItems() {
        return items;
    }
    
    public List<ItemTypeDTO> getTypeOptions() {
        return typeOptions;
    }

    public void setTypeOptions(List<ItemTypeDTO> typeOptions) {
        this.typeOptions = typeOptions;
    }

    public void setItems(List<DonationViewModelItem> items) {
        this.items = items;
    }
    
}
