
package model;

/**
 *
 * @author Glily
 */
public class RoleDTO {
    private int roleId;
    private String roleName;
    private int roleTypeId;

    public RoleDTO(int roleId, String roleName, int roleTypeId) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.roleTypeId = roleTypeId;
    }

    public RoleDTO() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public int getRoleTypeId() {
        return roleTypeId;
    }

    public void setRoleTypeId(int roleTypeId) {
        this.roleTypeId = roleTypeId;
    }
    
    
}
