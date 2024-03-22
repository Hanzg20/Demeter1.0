
package dataaccesslayer;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.SubscriptionDTO;

/**
 *
 * @author Glily
 */

public class SubscriptionDaoImpl extends DAOImpl<SubscriptionDTO> {

    final static String SQL_INSERT = "INSERT INTO subscription (user_id, Notific_method, Item_location, Item_price, Item_type) VALUES (?, ?, ?, ?, ?)";
    final static String SQL_DELETE_ALL = "DELETE FROM subscription";
    final static String SQL_DELETE = "DELETE FROM subscription WHERE subs_id = ?";
    final static String SQL_UPDATE = "UPDATE subscription SET user_id=?, Notific_method=?, Item_location=?, Item_price=?, Item_type=? WHERE subs_id = ?";
    final static String SQL_RETRIEVE = "SELECT * FROM subscription WHERE subs_id = ?";
    final static String SQL_RETRIEVE_ALL = "SELECT * FROM subscription";
    
    @Override
    public int insert(SubscriptionDTO subscription) {
          try {
            return dataSource.execute(SQL_INSERT, subscription.getUserId(), subscription.getNotiMethod(), subscription.getItemLocation(), subscription.getItemPrice(), subscription.getItemTypeId());
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
    public int update(SubscriptionDTO subscription) {

        try {
            return dataSource.execute(SQL_UPDATE, subscription.getUserId(), subscription.getNotiMethod(), subscription.getItemLocation(), subscription.getItemPrice(), subscription.getItemTypeId());
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    @Override
    public SubscriptionDTO Retrieve(Serializable id) {
        try (PreparedStatement statement = dataSource.prepareStatement(SQL_RETRIEVE, id); 
                ResultSet resultSet = statement.executeQuery()
                ) {
            if (resultSet.next()) {
                SubscriptionDTO subscription = new SubscriptionDTO();
                subscription.setSubsId(resultSet.getInt("subs_id"));
                subscription.setUserId(resultSet.getInt("user_id"));
                subscription.setNotiMethod(resultSet.getString("Notific_method"));
                subscription.setItemLocation(resultSet.getString("Item_location"));
                subscription.setItemPrice(resultSet.getDouble("Item_price"));
                subscription.setItemTypeId(resultSet.getInt("Item_type"));
                return subscription;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<SubscriptionDTO> RetrieveAll() {
        List<SubscriptionDTO> subscriptions = new ArrayList<>();
        try (PreparedStatement statement = dataSource.prepareStatement(SQL_RETRIEVE_ALL); ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                SubscriptionDTO subscription = new SubscriptionDTO();
                subscription.setSubsId(resultSet.getInt("subs_id"));
                subscription.setUserId(resultSet.getInt("user_id"));
                subscription.setNotiMethod(resultSet.getString("Notific_method"));
                subscription.setItemLocation(resultSet.getString("Item_location"));
                subscription.setItemPrice(resultSet.getDouble("Item_price"));
                subscription.setItemTypeId(resultSet.getInt("Item_type"));
                subscriptions.add(subscription);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return subscriptions;
    }
}


