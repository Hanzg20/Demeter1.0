/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package businesslayer;

import dataaccesslayer.DAO;
import dataaccesslayer.DataSource;
import dataaccesslayer.ItemDaoImpl;
import dataaccesslayer.ItemListingDaoImpl;
import dataaccesslayer.ItemTypeDaoImpl;
import dataaccesslayer.LocationDaoImpl;
import dataaccesslayer.UserDaoImpl;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import model.ItemDTO;
import model.ItemListingDTO;
import model.ItemTypeDTO;
import model.LocationDTO;
import model.UserDTO;
import viewmodel.OrderViewModel;
import viewmodel.OrderViewModelItem;

/**
 *
 * @author Glily
 */
public class TransactionService {

        final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    private final ItemDaoImpl itemDao = new ItemDaoImpl();
    private final DAO<LocationDTO> locationDao = new LocationDaoImpl();
    private final DAO<UserDTO> userDao = new UserDaoImpl();
    private final DAO<ItemTypeDTO> typeDao = new ItemTypeDaoImpl();

    private final ItemListingDaoImpl itemListingDao = new ItemListingDaoImpl();
    protected DataSource dataSource = DataSource.getInstance();


    public OrderViewModel buidOrderViewModel(String itemType, String expireDays) {
        OrderViewModel viewModel = new OrderViewModel();
        viewModel.setItems(retrieveSaleItemList(itemType, expireDays));
        viewModel.setTypeOptions(typeDao.RetrieveAll());
        return viewModel;
    }
    
    private List<OrderViewModelItem> retrieveSaleItemList(String itemType, String daysExpireDays) {
        List<OrderViewModelItem> result = new ArrayList<>();
        List<ItemListingDTO> items = itemListingDao.RetrieveList(false,itemType, daysExpireDays);
        items.forEach(listingItem -> {
            ItemDTO item = itemDao.Retrieve(listingItem.getItemId());
            if (item != null) {
                OrderViewModelItem viewItem = OrderViewModelItem.convertFrom(listingItem, item,
                        typeDao.Retrieve(item.getItemTypeId()), locationDao.Retrieve(item.getLocationId()));
                result.add(viewItem);
            }
        });
        return result;
    }
    
}
