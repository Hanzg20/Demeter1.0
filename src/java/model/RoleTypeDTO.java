
package model;

/**
 *
 * @author Glily
 */
public class RoleTypeDTO {
    private int typeId;
    private String roleType; 
    
    public RoleTypeDTO(int typeId, String roleType) {
        this.typeId = typeId;
        this.roleType = roleType;
    }

    public RoleTypeDTO() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }
    
    
    
}
