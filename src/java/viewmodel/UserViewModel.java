/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

import java.util.ArrayList;
import java.util.List;
import model.EnumStatusType;
import model.RoleDTO;

/**
 *
 * @author liyingguo
 */
public class UserViewModel {

    private List<UserViewModelItem> items = new ArrayList<>();
    private List<RoleDTO> roleOptions = new ArrayList<>();

    public List<UserViewModelItem> getItems() {
        return items;
    }
    
    public EnumStatusType[] getStatusOptions()
    {
        return EnumStatusType.values();
    }

    public List<RoleDTO> getRoleOptions() {
        return roleOptions;
    }

    public void setTypeOptions(List<RoleDTO> roleOptions) {
        this.roleOptions = roleOptions;
    }

    public void setItems(List<UserViewModelItem> items) {
        this.items = items;
    }
    
}
