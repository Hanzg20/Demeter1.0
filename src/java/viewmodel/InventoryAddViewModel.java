/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

import java.util.ArrayList;
import java.util.List;
import model.EnumStatusType;
import model.ItemTypeDTO;
import model.LocationDTO;
import model.UserDTO;

/**
 *
 * @author liyingguo
 */
 public class InventoryAddViewModel {
    private List<LocationDTO>locations = new ArrayList<>();
    private List<UserDTO>users=new ArrayList<>();
    private List<ItemTypeDTO>types=new ArrayList<>();
    public List<LocationDTO> getLocations() {
        return locations;
    }

    public void setLocations(List<LocationDTO> locations) {
        this.locations = locations;
    }

    public List<UserDTO> getUsers() {
        return users;
    }

    public void setUsers(List<UserDTO> users) {
        this.users = users;
    }

    public List<ItemTypeDTO> getTypes() {
        return types;
    }

    public void setTypes(List<ItemTypeDTO> types) {
        this.types = types;
    }
    
    public EnumStatusType[] getStatusOptions()
    {
        return EnumStatusType.values();
    }
}
