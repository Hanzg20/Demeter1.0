
package model;

/**
 *
 * @author Glily
 */
public class ItemTypeDTO {
    private int itemTypeId;
    private String itemTypeName;

    public ItemTypeDTO(int itemId, String typeName) {
        this.itemTypeId = itemId;
        this.itemTypeName = typeName;
    }

    public ItemTypeDTO() {
    }

    public int getItemTypeId() {
        return itemTypeId;
    }

    public void setItemTypeId(int itemId) {
        this.itemTypeId = itemId;
    }

    public String getItemTypeName() {
        return itemTypeName;
    }

    public void setItemTypeName(String typeName) {
        this.itemTypeName = typeName;
    }
    
}
