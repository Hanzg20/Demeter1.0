/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

import java.util.ArrayList;
import java.util.List;
import model.ItemDTO;

/**
 *
 * @author liyingguo
 */
public class InventoryViewModel {

    private List<InventoryViewModel.Item> items = new ArrayList<>();

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
    
    public static class Item {

        private int itemId;
        private String itemName;
        private String unit;
        private String location;
        private long createDate;
        private String userName;
        private int itemType;
        private int quantity;
        private long expirDate;
        private double price;
        private String status;
        private long statusDate;

        public int getItemId() {
            return itemId;
        }

        public void setItemId(int itemId) {
            this.itemId = itemId;
        }

        public String getItemName() {
            return itemName;
        }

        public void setItemName(String itemName) {
            this.itemName = itemName;
        }

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public long getCreateDate() {
            return createDate;
        }

        public void setCreateDate(long createDate) {
            this.createDate = createDate;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public int getItemType() {
            return itemType;
        }

        public void setItemType(int itemType) {
            this.itemType = itemType;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public long getExpirDate() {
            return expirDate;
        }

        public void setExpirDate(long expirDate) {
            this.expirDate = expirDate;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public long getStatusDate() {
            return statusDate;
        }

        public void setStatusDate(long statusDate) {
            this.statusDate = statusDate;
        }

        public static Item convertFrom(ItemDTO dto) {
            InventoryViewModel.Item result = new InventoryViewModel.Item();
            return result;
        }

    }
}
