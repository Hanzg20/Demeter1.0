
package dataaccesslayer;

import static dataaccesslayer.SubscriptionDaoImpl.SQL_RETRIEVE_ALL;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.NotificationDTO;
import model.SubscriptionDTO;

/**
 *
 * @author Glily
 */

public class NotificationDaoImpl extends DAOImpl<NotificationDTO> {

    final static String SQL_INSERT = "INSERT INTO notification (user_id, message, timestamp, status) VALUES (?, ?, ?, ?)";
    final static String SQL_DELETE_ALL = "DELETE FROM notification";
    final static String SQL_DELETE = "DELETE FROM notification WHERE noti_id = ?";
    final static String SQL_UPDATE = "UPDATE notification SET user_id=?, message=?, timestamp=?, status=? WHERE noti_id = ?";
    final static String SQL_RETRIEVE = "SELECT noti_id,user_id, message, timestamp, status FROM notification WHERE noti_id = ?";
    final static String SQL_RETRIEVE_ALL = "SELECT noti_id,user_id, message, timestamp, status FROM notification";
    
    @Override
    public int insert(NotificationDTO notification) {
          try {
            return MyDataSource.execute(SQL_INSERT, notification.getUserId(), notification.getMessage(), notification.getTimestamp(), notification.getStatus());
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    @Override
    public int delete(Serializable id) {
        try {
            if (id == null) {
                return MyDataSource.execute(SQL_DELETE_ALL);
            } else {
                return MyDataSource.execute(SQL_DELETE, id);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    @Override
    public int update(NotificationDTO notification) {

        try {
            return MyDataSource.execute(SQL_UPDATE, notification.getUserId(), notification.getMessage(), notification.getTimestamp(), notification.getStatus());
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    @Override
    public NotificationDTO Retrieve(Serializable id) {
        try (Connection connection = MyDataSource.getConnection(); PreparedStatement statement = MyDataSource.prepareStatement(connection,SQL_RETRIEVE, id); 
                ResultSet resultSet = statement.executeQuery()
                ) {
            if (resultSet.next()) {
                NotificationDTO notification = new NotificationDTO();
                notification.setNotiId(resultSet.getInt("noti_id"));
                notification.setUserId(resultSet.getInt("user_id"));
                notification.setMessage(resultSet.getString("message"));
                notification.setTimestamp(resultSet.getLong("timestamp"));
                notification.setStatus(resultSet.getString("status"));
                return notification;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<NotificationDTO> RetrieveAll() {
        List<NotificationDTO> notifications = new ArrayList<>();
        try (Connection connection = MyDataSource.getConnection(); PreparedStatement statement = MyDataSource.prepareStatement(connection,SQL_RETRIEVE_ALL); ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                NotificationDTO notification = new NotificationDTO();
                notification.setNotiId(resultSet.getInt("noti_id"));
                notification.setUserId(resultSet.getInt("user_id"));
                notification.setMessage(resultSet.getString("message"));
                notification.setTimestamp(resultSet.getLong("timestamp"));
                notification.setStatus(resultSet.getString("status"));
                notifications.add(notification);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return notifications;
    }
    
    public List<NotificationDTO> RetrieveList(int userId, String itemType) {
        List<NotificationDTO> items = new ArrayList<>();
        try (Connection connection = MyDataSource.getConnection(); PreparedStatement statement = prepareStatement(connection,SQL_RETRIEVE_ALL,userId, itemType); 
                ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                NotificationDTO notification = new NotificationDTO();
                notification.setNotiId(resultSet.getInt("noti_id"));
                notification.setUserId(resultSet.getInt("user_id"));
                notification.setMessage(resultSet.getString("message"));
                notification.setTimestamp(resultSet.getLong("timestamp"));
                notification.setStatus(resultSet.getString("status"));
                items.add(notification);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return items;
    }

    //todo the following need a join table sql
    private PreparedStatement prepareStatement(Connection connection,String sql,int userId, String itemTypeFilte) throws SQLException {
        StringBuilder queryBuilder = new StringBuilder(sql);
        queryBuilder.append(" AND user_id = "+userId);
        boolean validItemTypeFilter = itemTypeFilte != null && !itemTypeFilte.isEmpty();        
        if (validItemTypeFilter) {
            queryBuilder.append(" AND Item_type = ?");
        }

        PreparedStatement statement = MyDataSource.prepareStatement(connection,queryBuilder.toString());
        int parameterIndex = 1;
        if (validItemTypeFilter) {
            statement.setInt(parameterIndex++, Integer.parseInt(itemTypeFilte));
        }

        return statement;
    }
}


