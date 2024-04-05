package model;

import java.sql.Timestamp;

/**
 *
 * @author hanzg
 */
public class UserDTO {
    private int userId;
    private String name;
    private int roleId;
    private String email;
    private String password;
    
    public UserDTO() {
        // Default constructor
    }

   public UserDTO(int userId, String username, String email, String password) {
        this.userId = userId;
        this.name = username;
        this.email = email;
        this.password = password;
    }


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String username) {
        this.name = username;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
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

}
