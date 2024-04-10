/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

import java.sql.Timestamp;
import model.EnumStatusType;
import model.ItemDTO;
import model.RoleDTO;
import model.UserDTO;

/**
 *
 * @author liyingguo
 */
public class UserViewModelItem {
    
    private int userId;
    private String name;
    private String roleName;
    private String email;
    private String password;
    

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public static UserViewModelItem convertFrom(UserDTO userDTO, RoleDTO roleDTO) {
        UserViewModelItem result = new UserViewModelItem();
        result.setUserId(userDTO.getUserId());
        result.setName(userDTO.getName());
        result.setRoleName(roleDTO.getRoleName());
        result.setEmail(userDTO.getEmail());
        result.setPassword(userDTO.getPassword());
        
        return result;
    }
    
}
