package dataaccesslayer;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.ItemDTO;

public class ItemDaoImpl extends DAOImpl<ItemDTO> {

    final static String SQL_INSERT = "INSERT INTO item (Item_name, Unit, Location_id, Create_date, User_id, Item_type, Quantity, Expir_date, Price, Status, Status_date) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    final static String SQL_DELETE_ALL = "DELETE FROM item";
    final static String SQL_DELETE = "DELETE FROM item WHERE item_id = ?";
    final static String SQL_UPDATE = "UPDATE item SET Item_name=?, Unit=?, Location_id=?, Create_date=?, User_id=?, Item_type=?, Quantity=?, Expir_date=?, Price=?, Status=?, Status_date=?";
    final static String SQL_RETRIEVE = "SELECT * FROM item WHERE item_id = ?";
    final static String SQL_RETRIEVE_ALL = "SELECT * FROM item";
    
    @Override
    public int insert(ItemDTO item) {

        try {
            return dataSource.execute(SQL_INSERT, item.getItemName(), item.getUnit(), item.getLocationId(), item.getCreateDate(), item.getUserId(), item.getItemType(), item.getQuantity(), item.getExpirDate(), item.getPrice(), item.getStatus(), item.getStatusDate());
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    @Override
    public int delete(Serializable id) {
        try {
            if (id == null) {
                return dataSource.execute(SQL_DELETE_ALL);
            } else {
                return dataSource.execute(SQL_DELETE, id);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    @Override
    public int update(ItemDTO item) {

        try {
            return dataSource.execute(SQL_UPDATE, item.getItemName(), item.getUnit(), item.getLocationId(), item.getCreateDate(), item.getUserId(), item.getItemType(), item.getQuantity(), item.getExpirDate(), item.getPrice(), item.getStatus(), item.getStatusDate());
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    @Override
    public ItemDTO Retrieve(Serializable id) {
        try (PreparedStatement statement = dataSource.prepareStatement(SQL_RETRIEVE, id); 
                ResultSet resultSet = statement.executeQuery()
                ) {
            if (resultSet.next()) {
                ItemDTO item = new ItemDTO();
                item.setItemId(resultSet.getInt("item_id"));
                item.setItemName(resultSet.getString("Item_name"));
                item.setUnit(resultSet.getString("Unit"));
                item.setLocationId(resultSet.getInt("Location_id"));
                item.setCreateDate(resultSet.getLong("Create_date"));
                item.setUserId(resultSet.getInt("User_id"));
                item.setItemType(resultSet.getInt("Item_type"));
                item.setQuantity(resultSet.getInt("Quantity"));
                item.setExpirDate(resultSet.getInt("Expir_date"));
                item.setPrice(resultSet.getDouble("Price"));
                item.setStatus(resultSet.getString("Status"));
                item.setStatusDate(resultSet.getLong("Status_date"));
                return item;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<ItemDTO> RetrieveAll() {
        List<ItemDTO> items = new ArrayList<>();
        try (PreparedStatement statement = dataSource.query(SQL_RETRIEVE_ALL); ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                ItemDTO item = new ItemDTO();
                item.setItemId(resultSet.getInt("item_id"));
                item.setItemName(resultSet.getString("Item_name"));
                item.setUnit(resultSet.getString("Unit"));
                item.setLocationId(resultSet.getInt("Location_id"));
                item.setCreateDate(resultSet.getLong("Create_date"));
                item.setUserId(resultSet.getInt("User_id"));
                item.setItemType(resultSet.getInt("Item_type"));
                item.setQuantity(resultSet.getInt("Quantity"));
                item.setExpirDate(resultSet.getInt("Expir_date"));
                item.setPrice(resultSet.getDouble("Price"));
                item.setStatus(resultSet.getString("Status"));
                item.setStatusDate(resultSet.getLong("Status_date"));
                items.add(item);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return items;
    }
}
