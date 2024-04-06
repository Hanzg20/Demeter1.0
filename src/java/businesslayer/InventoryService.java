/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package businesslayer;

import dataaccesslayer.DAO;
import dataaccesslayer.ItemDaoImpl;
import dataaccesslayer.ItemTypeDaoImpl;
import dataaccesslayer.LocationDaoImpl;
import dataaccesslayer.UserDaoImpl;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import model.EnumStatusType;
import model.ItemDTO;
import model.ItemTypeDTO;
import model.LocationDTO;
import model.UserDTO;
import viewmodel.InventoryAddViewModel;
import viewmodel.InventoryEditViewModel;
import viewmodel.InventoryViewModel;
import viewmodel.ItemDetail;
import static viewmodel.ItemDetail.convertFrom;

/**
 *
 * @author liyingguo
 */
public class InventoryService {

    final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    private final ItemDaoImpl itemDao = new ItemDaoImpl();
    private final DAO<LocationDTO> locationDao = new LocationDaoImpl();
    private final DAO<UserDTO> userDao = new UserDaoImpl();
    private final DAO<ItemTypeDTO> typeDao = new ItemTypeDaoImpl();

    private List<ItemDetail> retrieveList(String itemType, String status, String daysExpireDays) {
        List<ItemDetail> result = new ArrayList<>();
        List<ItemDTO> items = itemDao.RetrieveList(itemType, status, daysExpireDays);
        items.forEach(item -> {
            ItemDetail viewItem = convertFrom(item);
            LocationDTO location = locationDao.Retrieve(item.getLocationId());
            if (location != null) {
                viewItem.setLocation(location.getAddress());
            }

            UserDTO user = userDao.Retrieve(item.getUserId());
            if (user != null) {
                viewItem.setUserName(user.getName());
            }

            ItemTypeDTO type = typeDao.Retrieve(item.getItemTypeId());

            if (type != null) {
                viewItem.setItemType(type.getItemTypeName());
            }

            result.add(viewItem);
        });
        return result;
    }

    public ItemDetail buidInventoryViewModelItem(int id) {
        ItemDTO item = itemDao.Retrieve(id);
        if (item != null) {
            ItemDetail viewItem = convertFrom(item);
            LocationDTO location = locationDao.Retrieve(item.getLocationId());
            if (location != null) {
                viewItem.setLocation(location.getAddress());
            }

            UserDTO user = userDao.Retrieve(item.getUserId());
            if (user != null) {
                viewItem.setUserName(user.getName());
            }

            ItemTypeDTO type = typeDao.Retrieve(item.getItemTypeId());

            if (type != null) {
                viewItem.setItemType(type.getItemTypeName());
            }

            return viewItem;
        }
        return null;
    }

    public InventoryViewModel buidInventoryViewModel(String itemType, String status, String daysExpireDays) {
        InventoryViewModel viewModel = new InventoryViewModel();
        viewModel.setItems(retrieveList(itemType, status, daysExpireDays));
        viewModel.setTypeOptions(typeDao.RetrieveAll());
        return viewModel;
    }

    public InventoryAddViewModel buidInventoryAddViewModel() {
        InventoryAddViewModel viewModel = new InventoryAddViewModel();
        setOptions(viewModel);
        return viewModel;
    }

    public InventoryAddViewModel buidInventoryEditViewModel(int id) {
        InventoryEditViewModel viewModel = new InventoryEditViewModel();
        setOptions(viewModel);
        viewModel.setItem(itemDao.Retrieve(id));
        return viewModel;
    }

    private void setOptions(InventoryAddViewModel viewModel) {
        viewModel.setLocations(locationDao.RetrieveAll());
        viewModel.setTypes(typeDao.RetrieveAll());
        viewModel.setUsers(userDao.RetrieveAll());
    }

    public int add(ItemDTO itemDTO) {
        return itemDao.insert(itemDTO);
    }

    public int saveItemWithRequest(HttpServletRequest request) throws ParseException {
        ItemDTO item = convertRequestToItem(request);
        if (item.getItemId() == 0) {
            return itemDao.insert(item);
        } else {
            return itemDao.update(item);
        }
    }

    private ItemDTO convertRequestToItem(HttpServletRequest request) throws ParseException {
        // Retrieve form data 
        String id = request.getParameter("id");
        String itemName = request.getParameter("itemName");
        String unit = request.getParameter("unit");
        int locationId = Integer.parseInt(request.getParameter("locationId"));
        String createDate = request.getParameter("createDate");
        Date createDateTime = dateFormat.parse(createDate.replace("T", " "));
        Timestamp createTimestamp = new Timestamp(createDateTime.getTime());

        int userId = Integer.parseInt(request.getParameter("userId"));
        int itemTypeId = Integer.parseInt(request.getParameter("itemTypeId"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String expirDate = request.getParameter("expirDate");
        Date expirDateTime = dateFormat.parse(expirDate.replace("T", " "));
        Timestamp expirTimestamp = new Timestamp(expirDateTime.getTime());

        double price = Double.parseDouble(request.getParameter("price"));
        String status = request.getParameter("status");
        String statusDate = request.getParameter("statusDate");
        Date statusDateTime = dateFormat.parse(statusDate.replace("T", " "));
        Timestamp statusDateTimestamp = new Timestamp(statusDateTime.getTime());
        return new ItemDTO((id == null) ? 0 : Integer.parseInt(id), itemName, unit, locationId, createTimestamp, userId, itemTypeId, quantity, expirTimestamp, price, status, statusDateTimestamp);
    }

    public boolean delete(String id) {
        return itemDao.delete(id)!=0;
    }

    public boolean flag(String id) {
        ItemDTO item = itemDao.Retrieve(id);
//        if (item != null) {
//            item.setStatus( EnumStatusType.);
//            itemDao.
//        }
        
        return false;
    }
}
