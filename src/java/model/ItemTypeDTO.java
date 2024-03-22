
package model;

/**
 *
 * @author Glily
 */
public class ItemTypeDTO {
    private int itemId;
    private String typeName;

    public ItemTypeDTO(int itemId, String typeName) {
        this.itemId = itemId;
        this.typeName = typeName;
    }

    public ItemTypeDTO() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
    
}
