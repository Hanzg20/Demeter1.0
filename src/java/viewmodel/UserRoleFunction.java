/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

import java.util.ArrayList;
import java.util.List;
import model.EnumSysFunctionURL;
import model.RoleDTO;
import model.SysFunctionDTO;
import model.UserDTO;
import model.UserFunctionDTO;

/**
 *
 * @author liyingguo
 */
public class UserRoleFunction {

    private int userId;
    private String name;
    private String roleName;
    private String email;

    private SysFunctionURL[] functionURLs;

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

    public SysFunctionURL[] getFunctionURLs() {
        return functionURLs;
    }

    public void setFunctionURLs(SysFunctionURL[] functionURLs) {
        this.functionURLs = functionURLs;
    }
    
    public static UserRoleFunction convertFrom(UserDTO userDTO,RoleDTO roleDTO, SysFunctionDTO[] sysFunctionDTOs) {
        if(roleDTO != null && sysFunctionDTOs!= null && sysFunctionDTOs.length>0)
        {
            UserRoleFunction userRoleFunction = new UserRoleFunction();
            userRoleFunction.setName(userDTO.getName());
            userRoleFunction.setEmail(userDTO.getEmail());
            userRoleFunction.setUserId(userDTO.getUserId());
            userRoleFunction.setRoleName(roleDTO.getRoleName());
            SysFunctionURL[] sysFunctionURL =new SysFunctionURL[sysFunctionDTOs.length];
            for (int i = 0; i < sysFunctionDTOs.length; i++) {
                SysFunctionDTO sysFunctionDTO = sysFunctionDTOs[i];
                sysFunctionURL[i] = new SysFunctionURL(sysFunctionDTO, EnumSysFunctionURL.fromSysFunctionId(sysFunctionDTO.getFuncId()).getSysFunctionUrl());
            }
            userRoleFunction.setFunctionURLs(sysFunctionURL);
            return userRoleFunction;
        }
        return null;
    }
    
    public static class SysFunctionURL {
        private int funcId;
        private String funcName;
        private String sysFunctionUrl;

        private SysFunctionURL(SysFunctionDTO sysFunctionDTO, String sysFunctionUrl) {
            this.funcId = sysFunctionDTO.getFuncId();
            this.funcName = sysFunctionDTO.getFuncName();
            this.sysFunctionUrl = sysFunctionUrl;
        }

        public int getFuncId() {
            return funcId;
        }

        public void setFuncId(int funcId) {
            this.funcId = funcId;
        }

        public String getFuncName() {
            return funcName;
        }

        public void setFuncName(String funcName) {
            this.funcName = funcName;
        }

        public String getSysFunctionUrl() {
            return sysFunctionUrl;
        }

        public void setSysFunctionUrl(String sysFunctionUrl) {
            this.sysFunctionUrl = sysFunctionUrl;
        }
    }
}
