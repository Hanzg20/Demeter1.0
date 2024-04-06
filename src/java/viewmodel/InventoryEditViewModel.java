/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

import model.ItemDTO;

/**
 *
 * @author liyingguo
 */
public class InventoryEditViewModel extends InventoryAddViewModel{
    private ItemDTO item;

    public ItemDTO getItem() {
        return item;
    }

    public void setItem(ItemDTO item) {
        this.item = item;
    }
    
}
