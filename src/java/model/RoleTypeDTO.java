
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
