package dataaccesslayer;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import model.ItemDTO;

public class ItemDaoImpl extends DAOImpl<ItemDTO> {

    final static String SQL_INSERT = "INSERT INTO item (Item_name, Unit, Location_id, Create_date, User_id, Item_type, Quantity, Expir_date, Price, Status, Status_date) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    final static String SQL_DELETE_ALL = "DELETE FROM item";
    final static String SQL_DELETE = "DELETE FROM item WHERE item_id = ?";
    final static String SQL_UPDATE = "UPDATE item SET Item_name=?, Unit=?, Location_id=?, Create_date=?, User_id=?, Item_type=?, Quantity=?, Expir_date=?, Price=?, Status=?, Status_date=? WHERE item_id = ?";
    final static String SQL_RETRIEVE = "SELECT item_id, Item_name, Unit, Location_id, Create_date, User_id, Item_type, Quantity, Expir_date, Price, Status, Status_date FROM item WHERE item_id = ?";
    final static String SQL_RETRIEVE_ALL = "SELECT * FROM item Where 1=1";

    @Override
    public int insert(ItemDTO item) {

        try {
            return dataSource.execute(SQL_INSERT, item.getItemName(), item.getUnit(), item.getLocationId(), item.getCreateDate(), item.getUserId(), item.getItemTypeId(), item.getQuantity(), item.getExpirDate(), item.getPrice(), item.getStatus(), item.getStatusDate());
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
            return dataSource.execute(SQL_UPDATE, item.getItemName(), item.getUnit(), item.getLocationId(), item.getCreateDate(), item.getUserId(), item.getItemTypeId(), item.getQuantity(), item.getExpirDate(), item.getPrice(), item.getStatus(), item.getStatusDate(),item.getItemId());
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    @Override
    public ItemDTO Retrieve(Serializable id) {
        try (PreparedStatement statement = dataSource.prepareStatement(SQL_RETRIEVE, id); ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                ItemDTO item = new ItemDTO();
                item.setItemId(resultSet.getInt("item_id"));
                item.setItemName(resultSet.getString("Item_name"));
                item.setUnit(resultSet.getString("Unit"));
                item.setLocationId(resultSet.getInt("Location_id"));
                item.setCreateDate(resultSet.getTimestamp("Create_date"));
                item.setUserId(resultSet.getInt("User_id"));
                item.setItemTypeId(resultSet.getInt("Item_type"));
                item.setQuantity(resultSet.getInt("Quantity"));
                item.setExpirDate(resultSet.getTimestamp("Expir_date"));
                item.setPrice(resultSet.getDouble("Price"));
                item.setStatus(resultSet.getString("Status"));
                item.setStatusDate(resultSet.getTimestamp("Status_date"));
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
        try (PreparedStatement statement = dataSource.prepareStatement(SQL_RETRIEVE_ALL); ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                ItemDTO item = new ItemDTO();
                item.setItemId(resultSet.getInt("item_id"));
                item.setItemName(resultSet.getString("Item_name"));
                item.setUnit(resultSet.getString("Unit"));
                item.setLocationId(resultSet.getInt("Location_id"));
                item.setCreateDate(resultSet.getTimestamp("Create_date"));
                item.setUserId(resultSet.getInt("User_id"));
                item.setItemTypeId(resultSet.getInt("Item_type"));
                item.setQuantity(resultSet.getInt("Quantity"));
                item.setExpirDate(resultSet.getTimestamp("Expir_date"));
                item.setPrice(resultSet.getDouble("Price"));
                item.setStatus(resultSet.getString("Status"));
                item.setStatusDate(resultSet.getTimestamp("Status_date"));
                items.add(item);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return items;
    }

    public List<ItemDTO> RetrieveList(String itemType, String status, String daysExpireDaysLessThan) {
        List<ItemDTO> items = new ArrayList<>();
        try (PreparedStatement statement = prepareStatement(SQL_RETRIEVE_ALL, itemType, status, daysExpireDaysLessThan); ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                ItemDTO item = new ItemDTO();
                item.setItemId(resultSet.getInt("item_id"));
                item.setItemName(resultSet.getString("Item_name"));
                item.setUnit(resultSet.getString("Unit"));
                item.setLocationId(resultSet.getInt("Location_id"));
                item.setCreateDate(resultSet.getTimestamp("Create_date"));
                item.setUserId(resultSet.getInt("User_id"));
                item.setItemTypeId(resultSet.getInt("Item_type"));
                item.setQuantity(resultSet.getInt("Quantity"));
                item.setExpirDate(resultSet.getTimestamp("Expir_date"));
                item.setPrice(resultSet.getDouble("Price"));
                item.setStatus(resultSet.getString("Status"));
                item.setStatusDate(resultSet.getTimestamp("Status_date"));
                items.add(item);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return items;
    }

    private PreparedStatement prepareStatement(String sql, String itemTypeFilte, String statusFilter, String expireDayFilter) throws SQLException {
        StringBuilder queryBuilder = new StringBuilder(sql);
        boolean validItemTypeFilter = itemTypeFilte != null && !itemTypeFilte.isEmpty();
        if (validItemTypeFilter) {
            queryBuilder.append(" AND Item_type = ?");
        }

        boolean validStatusFilter = statusFilter != null && !statusFilter.isEmpty();
        if (validStatusFilter) {
            queryBuilder.append(" AND Status = ?");
        }

        boolean validExpireDayFilter = expireDayFilter != null && !expireDayFilter.isEmpty();
        if (validExpireDayFilter) {
            queryBuilder.append(" AND Expir_date < ?");
        }

        PreparedStatement statement = dataSource.prepareStatement(queryBuilder.toString());
        int parameterIndex = 1;
        if (validItemTypeFilter) {
            statement.setInt(parameterIndex++, Integer.parseInt(itemTypeFilte));
        }
        if (validStatusFilter) {
            statement.setString(parameterIndex++, statusFilter);
        }
        if (validExpireDayFilter) {
            // Get the current UTC timestamp
            Instant now = Instant.now();
            int days = Integer.parseInt(expireDayFilter);

            // Add 7 days to the current timestamp
            Instant sevenDaysLater = now.plusSeconds( days* 24 * 60 * 60);

            // Convert the Instant to java.sql.Timestamp
            Timestamp timestamp = Timestamp.from(sevenDaysLater);
            statement.setTimestamp(parameterIndex++, timestamp );
        }

        return statement;
    }
}
