/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package businesslayer;

import dataaccesslayer.DAO;
import dataaccesslayer.ItemDaoImpl;
import dataaccesslayer.LocationDaoImpl;
import dataaccesslayer.UserDaoImpl;
import java.util.ArrayList;
import java.util.List;
import model.ItemDTO;
import model.LocationDTO;
import model.UserDTO;
import viewmodel.InventoryViewModel;
import static viewmodel.InventoryViewModel.Item.convertFrom;

/**
 *
 * @author liyingguo
 */
public class InventoryService {
    private final DAO<ItemDTO> itemDao = new ItemDaoImpl();
    private final DAO<LocationDTO> locationDao = new LocationDaoImpl();
    private final DAO<UserDTO> userDao = new UserDaoImpl();

    public List<InventoryViewModel.Item> RetrieveAllItems() {
        List<InventoryViewModel.Item> result =new ArrayList<>();
        List<ItemDTO> items = itemDao.RetrieveAll();
        items.forEach(item->{
            InventoryViewModel.Item viewItem = convertFrom(item);
            LocationDTO location = locationDao.Retrieve(item.getLocationId());
            if(location != null)
            {
                viewItem.setLocation(location.getAddress());
            }
            
            UserDTO user = userDao.Retrieve(item.getUserId());
            if(location != null)
            {
                viewItem.setUserName(user.getName());
            }
            
            result.add(viewItem);
        });
        return result;
    }


    
    
}
