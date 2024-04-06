
package dataaccesslayer;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.ItemTypeDTO;

/**
 *
 * @author Glily
 */

public class ItemTypeDaoImpl extends DAOImpl<ItemTypeDTO> {

    final static String SQL_INSERT = "INSERT INTO item_type (Item_type_name) VALUES (?, ?)";
    final static String SQL_DELETE_ALL = "DELETE FROM item_type";
    final static String SQL_DELETE = "DELETE FROM item_type WHERE Item_type_id = ?";
    final static String SQL_UPDATE = "UPDATE item_type SET Item_type_name=? WHERE Item_type_id = ?";
    final static String SQL_RETRIEVE = "SELECT Item_type_id,Item_type_name FROM item_type WHERE Item_type_id = ?";
    final static String SQL_RETRIEVE_ALL = "SELECT Item_type_id,Item_type_name FROM item_type";
    
    @Override
    public int insert(ItemTypeDTO itemType) {

        try {
            return dataSource.execute(SQL_INSERT, itemType.getItemTypeName());
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
    public int update(ItemTypeDTO itemType) {

        try {
            return dataSource.execute(SQL_UPDATE, itemType.getItemTypeName());
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    @Override
    public ItemTypeDTO Retrieve(Serializable id) {
        try (PreparedStatement statement = dataSource.prepareStatement(SQL_RETRIEVE, id); 
                ResultSet resultSet = statement.executeQuery()
                ) {
            if (resultSet.next()) {
                ItemTypeDTO itemType = new ItemTypeDTO();
                itemType.setItemTypeId(resultSet.getInt("Item_type_id"));
                itemType.setItemTypeName(resultSet.getString("Item_type_name"));
                return itemType;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<ItemTypeDTO> RetrieveAll() {
        List<ItemTypeDTO> itemTypes = new ArrayList<>();
        try (PreparedStatement statement = dataSource.prepareStatement(SQL_RETRIEVE_ALL); ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                ItemTypeDTO itemType = new ItemTypeDTO();
                itemType.setItemTypeId(resultSet.getInt("Item_type_id"));
                itemType.setItemTypeName(resultSet.getString("Item_type_name"));
                itemTypes.add(itemType);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return itemTypes;
    }
}


