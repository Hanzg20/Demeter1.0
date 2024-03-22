
package dataaccesslayer;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.ItemListingDTO;

/**
 *
 * @author Glily
 */

public class ItemListingDaoImpl extends DAOImpl<ItemListingDTO> {

    final static String SQL_INSERT = "INSERT INTO item_listing (Item_id, Is_donation, Discount_rate, Listing_date) VALUES (?, ?, ?, ?, ?)";
    final static String SQL_DELETE_ALL = "DELETE FROM item_listing";
    final static String SQL_DELETE = "DELETE FROM item_listing WHERE Listing_id = ?";
    final static String SQL_UPDATE = "UPDATE item_listing SET Item_id=?, Is_donation=?, Discount_rate=?, Listing_date=? WHERE Listing_id = ?";
    final static String SQL_RETRIEVE = "SELECT * FROM item_listing WHERE Listing_id = ?";
    final static String SQL_RETRIEVE_ALL = "SELECT * FROM item_listing";
    
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
        try (PreparedStatement statement = dataSource.prepareStatement(SQL_RETRIEVE, id); 
                ResultSet resultSet = statement.executeQuery()
                ) {
            if (resultSet.next()) {
                ItemListingDTO itemListing = new ItemListingDTO();
                itemListing.setListingId(resultSet.getInt("Listing_id"));
                itemListing.setItemId(resultSet.getInt("Item_id"));
                itemListing.setIsDonation(resultSet.getString("Is_donation"));
                itemListing.setDiscountRate(resultSet.getDouble("Discount_rate"));
                itemListing.setListingDate(resultSet.getLong("Listing_date"));
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
                ItemListingDTO itemListing = new ItemListingDTO();
                 itemListing.setListingId(resultSet.getInt("Listing_id"));
                itemListing.setItemId(resultSet.getInt("Item_id"));
                itemListing.setIsDonation(resultSet.getString("Is_donation"));
                itemListing.setDiscountRate(resultSet.getDouble("Discount_rate"));
                itemListing.setListingDate(resultSet.getLong("Listing_date"));
                itemListings.add(itemListing);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return itemListings;
    }
}


