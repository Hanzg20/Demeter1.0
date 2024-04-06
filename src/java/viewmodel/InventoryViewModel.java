/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import model.EnumStatusType;
import model.ItemDTO;
import model.ItemTypeDTO;

/**
 *
 * @author liyingguo
 */
public class InventoryViewModel {

    private List<ItemDetail> items = new ArrayList<>();
    private List<ItemTypeDTO> typeOptions = new ArrayList<>();

    public List<ItemDetail> getItems() {
        return items;
    }
    
    public EnumStatusType[] getStatusOptions()
    {
        return EnumStatusType.values();
    }

    public List<ItemTypeDTO> getTypeOptions() {
        return typeOptions;
    }

    public void setTypeOptions(List<ItemTypeDTO> typeOptions) {
        this.typeOptions = typeOptions;
    }

    public void setItems(List<ItemDetail> items) {
        this.items = items;
    }
    
}
