
package model;

/**
 *
 * @author Glily
 */
public class UserFunctionDTO {
    private int funcId;
    private int roleId;

    public UserFunctionDTO(int funcId, int roleId) {
        this.funcId = funcId;
        this.roleId = roleId;
    }

    public int getFuncId() {
        return funcId;
    }

    public void setFuncId(int funcId) {
        this.funcId = funcId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
    
}
