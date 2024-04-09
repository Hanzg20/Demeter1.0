package dataaccesslayer;

import static dataaccesslayer.ItemDaoImpl.SQL_RETRIEVE_ALL;
import static dataaccesslayer.ItemDaoImpl.SQL_UPDATE;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import model.ItemDTO;
import model.ItemListingDTO;

/**
 *
 * @author Glily
 */
public class ItemListingDaoImpl extends DAOImpl<ItemListingDTO> {

    final static String SQL_INSERT = "INSERT INTO item_listing (Item_id, Is_donation, Discount_rate, Listing_date) VALUES (?, ?, ?, ?)";
    final static String SQL_DELETE_ALL = "DELETE FROM item_listing";
    final static String SQL_DELETE = "DELETE FROM item_listing WHERE Listing_id = ?";
    final static String SQL_UPDATE = "UPDATE item_listing SET Item_id=?, Is_donation=?, Discount_rate=?, Listing_date=? WHERE Listing_id = ?";
    final static String SQL_RETRIEVE = "SELECT Listing_id, Item_id, Is_donation, Discount_rate, Listing_date FROM item_listing WHERE Listing_id = ?";
    final static String SQL_RETRIEVE_ALL = "SELECT Listing_id,  Item_id, Is_donation, Discount_rate, Listing_date FROM item_listing Where 1=1";

    @Override
    public int insert(ItemListingDTO item_listing) {

        try {
            return dataSource.execute(SQL_INSERT, item_listing.getItemId(), item_listing.getIsDonation(), item_listing.getDiscountRate(), item_listing.getListingDate());
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
    public int update(ItemListingDTO itemListing) {

        try {
            return dataSource.execute(SQL_UPDATE, itemListing.getItemId(), itemListing.getIsDonation(), itemListing.getDiscountRate(), itemListing.getListingDate());
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    @Override
    public ItemListingDTO Retrieve(Serializable id) {
        try (PreparedStatement statement = dataSource.prepareStatement(SQL_RETRIEVE, id); ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                ItemListingDTO itemListing = new ItemListingDTO();
                itemListing.setListingId(resultSet.getInt("Listing_id"));
                itemListing.setItemId(resultSet.getInt("Item_id"));
                itemListing.setIsDonation(resultSet.getBoolean("Is_donation"));
                itemListing.setDiscountRate(resultSet.getDouble("Discount_rate"));
                itemListing.setListingDate(resultSet.getTimestamp("Listing_date"));
                return itemListing;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<ItemListingDTO> RetrieveAll() {
        List<ItemListingDTO> itemListings = new ArrayList<>();
        try (PreparedStatement statement = dataSource.prepareStatement(SQL_RETRIEVE_ALL); ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                ItemListingDTO item = new ItemListingDTO();
                item.setListingId(resultSet.getInt("Listing_id"));
                item.setItemId(resultSet.getInt("Item_id"));
                item.setIsDonation(resultSet.getBoolean("Is_donation"));
                if (resultSet.getObject("Discount_rate") != null) {
                    item.setDiscountRate(resultSet.getDouble("Discount_rate"));
                }
                //itemListing.setListingDate(resultSet.getLong("Listing_date"));
                itemListings.add(item);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return itemListings;
    }

    public List<ItemListingDTO> RetrieveList(boolean isDonation, String itemType, String daysExpireDaysLessThan) {
        List<ItemListingDTO> items = new ArrayList<>();
        try (PreparedStatement statement = prepareStatement(SQL_RETRIEVE_ALL,isDonation, itemType, daysExpireDaysLessThan); 
                ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                ItemListingDTO item = new ItemListingDTO();
                item.setListingId(resultSet.getInt("Listing_id"));
                item.setItemId(resultSet.getInt("Item_id"));
                item.setIsDonation(resultSet.getBoolean("Is_donation"));
                if (resultSet.getObject("Discount_rate") != null) {
                    item.setDiscountRate(resultSet.getDouble("Discount_rate"));
                }
                item.setListingDate(resultSet.getTimestamp("Listing_date"));
                items.add(item);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return items;
    }

    //todo the following need a join table sql
    private PreparedStatement prepareStatement(String sql,boolean isDonation, String itemTypeFilte, String expireDayFilter) throws SQLException {
        StringBuilder queryBuilder = new StringBuilder(sql);
        queryBuilder.append(" AND Is_donation = "+((isDonation)?"true":"false"));
        boolean validItemTypeFilter = itemTypeFilte != null && !itemTypeFilte.isEmpty();        
        if (validItemTypeFilter) {
            queryBuilder.append(" AND Item_type = ?");
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
        
        if (validExpireDayFilter) {
            // Get the current UTC timestamp
            Instant now = Instant.now();
            int days = Integer.parseInt(expireDayFilter);

            // Add 7 days to the current timestamp
            Instant sevenDaysLater = now.plusSeconds(days * 24 * 60 * 60);

            // Convert the Instant to java.sql.Timestamp
            Timestamp timestamp = Timestamp.from(sevenDaysLater);
            statement.setTimestamp(parameterIndex++, timestamp);
        }

        return statement;
    }

    public PreparedStatement prepareInsertStatement(ItemListingDTO item_listing) throws SQLException {
        return dataSource.prepareStatement(SQL_INSERT, item_listing.getItemId(), item_listing.getIsDonation(), item_listing.getDiscountRate(), item_listing.getListingDate());
    }
}
