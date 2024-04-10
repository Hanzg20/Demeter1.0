/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package businesslayer;

import dataaccesslayer.RoleDaoImpl;
import dataaccesslayer.UserDaoImpl;
import java.util.ArrayList;
import java.util.List;
import model.UserDTO;
import model.ItemTypeDTO;
import model.LocationDTO;
import model.RoleDTO;
import model.UserDTO;
import viewmodel.UserViewModel;
import viewmodel.UserViewModelItem;
import static viewmodel.UserViewModelItem.convertFrom;
import viewmodel.UserViewModelItem;

/**
 *
 * @author Liying Guo
 */
public class UserService {
    private static final UserDaoImpl userDao = new UserDaoImpl();
    private static final RoleDaoImpl roleDao = new RoleDaoImpl();
    
     private List<UserViewModelItem> retrieveUserList() {
        List<UserViewModelItem> result = new ArrayList<>();
        List<UserDTO> users = userDao.RetrieveAll();
        users.forEach(item -> {
            result.add(UserViewModelItem.convertFrom(item, roleDao.Retrieve(item.getRoleId())));
        });
        return result;
    }

    public UserViewModel buidUserViewModel() {
        UserViewModel viewModel = new UserViewModel();
        viewModel.setItems(retrieveUserList());
        viewModel.setRoleOptions(roleDao.RetrieveAll());
        return viewModel;
    }
}
