/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package businesslayer;

import dataaccesslayer.DAO;
import dataaccesslayer.MyDataSource;
import dataaccesslayer.ItemDaoImpl;
import dataaccesslayer.ItemListingDaoImpl;
import dataaccesslayer.ItemTypeDaoImpl;
import dataaccesslayer.LocationDaoImpl;
import dataaccesslayer.TransactionDaoImpl;
import dataaccesslayer.UserDaoImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import model.EnumStatusType;
import model.EnumTransactionType;
import model.ItemDTO;
import model.ItemListingDTO;
import model.ItemTypeDTO;
import model.LocationDTO;
import model.TransactionDTO;
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
    private final TransactionDaoImpl transationDao = new TransactionDaoImpl();



    public OrderViewModel buidOrderViewModel(int userId, String itemTypeId, String expireDays) {
        OrderViewModel viewModel = new OrderViewModel();
        viewModel.setItems(retrieveOrderItemList(userId,itemTypeId, expireDays));
        viewModel.setTypeOptions(typeDao.RetrieveAll());
        return viewModel;
    }
    
    private List<OrderViewModelItem> retrieveOrderItemList(int userId,String itemType, String daysExpireDays) {
        List<TransactionDTO> items = transationDao.RetrieveList(userId);
        List<OrderViewModelItem> result = new ArrayList<>();
        items.forEach(transactionDTO -> {
            ItemListingDTO listingItem = itemListingDao.Retrieve(transactionDTO.getListingId());
            if (listingItem != null) {
                ItemDTO item = itemDao.Retrieve(listingItem.getItemId());
                if (item != null && (itemType == null || "".equals(itemType) || Integer.parseInt(itemType)==item.getItemTypeId())) {
                    OrderViewModelItem viewItem = OrderViewModelItem.convertFrom(transactionDTO,listingItem, item,
                            typeDao.Retrieve(item.getItemTypeId()), locationDao.Retrieve(item.getLocationId()));
                    result.add(viewItem);
                }
            }

        });
        return result;
    }
    
    public boolean buy(int userId, int listingId, int quantity) {
        ItemListingDTO listingItem = itemListingDao.Retrieve(listingId);
        if (listingItem != null) {
            ItemDTO item = itemDao.Retrieve(listingItem.getItemId());
            if (item != null && item.getQuantity() >= quantity) {
                item.setQuantity(item.getQuantity() - quantity);
                if (item.getQuantity() == 0) {
                    item.setStatus(EnumStatusType.SOLD.getSymbol());
                    item.setStatusDate(Timestamp.from(Instant.now()));
                }
                TransactionDTO transactionDTO = new TransactionDTO(0, EnumTransactionType.PURCHASE.getValue(), listingId, userId, quantity, Timestamp.from(Instant.now()));
                try (
                        Connection connection = MyDataSource.getConnection(); 
                        PreparedStatement statement1 = itemDao.prepareUpdateStatement(connection,item); PreparedStatement statement2 = transationDao.prepareInsertStatement(connection,transactionDTO)) {
                    // Executing both statements
                    statement1.executeUpdate();
                    statement2.executeUpdate();
                    // Committing the transaction                    
                    return true;

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }

        return false;
    }

    public boolean donate(int userId, int quantity, int listingId) {
        ItemListingDTO listingItem = itemListingDao.Retrieve(listingId);
        if (listingItem != null) {
            ItemDTO item = itemDao.Retrieve(listingItem.getItemId());
            if (item != null && item.getQuantity() >= quantity) {
                item.setQuantity(item.getQuantity() - quantity);
                if (item.getQuantity() == 0) {
                    item.setStatus(EnumStatusType.SOLD.getSymbol());
                    item.setStatusDate(Timestamp.from(Instant.now()));
                }
                TransactionDTO transactionDTO = new TransactionDTO(0, EnumTransactionType.CLAIM.getValue(), listingId, userId, quantity, Timestamp.from(Instant.now()));
                try (
                        Connection connection = MyDataSource.getConnection(); PreparedStatement statement1 = itemDao.prepareUpdateStatement(connection, item); PreparedStatement statement2 = transationDao.prepareInsertStatement(connection, transactionDTO)) {
                    // Executing both statements
                    statement1.executeUpdate();
                    statement2.executeUpdate();
                    // Committing the transaction                    
                    return true;

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }

        return false;
    }
}
