
package dataaccesslayer;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.LocationDTO;

/**
 *
 * @author Glily
 */

public class LocationDaoImpl extends DAOImpl<LocationDTO> {

    final static String SQL_INSERT = "INSERT INTO location (Location_name, Address) VALUES (?, ?)";
    final static String SQL_DELETE_ALL = "DELETE FROM location";
    final static String SQL_DELETE = "DELETE FROM location WHERE Location_id = ?";
    final static String SQL_UPDATE = "UPDATE location SET Location_name = ?, Address= ? WHERE Location_id = ?";
    final static String SQL_RETRIEVE = "SELECT * FROM location WHERE Location_id = ?";
    final static String SQL_RETRIEVE_ALL = "SELECT * FROM location";
    
    @Override
    public int insert(LocationDTO location) {
          try {
            return MyDataSource.execute(SQL_INSERT, location.getLocationName(), location.getAddress());
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
    public int update(LocationDTO location) {

        try {
            return MyDataSource.execute(SQL_UPDATE, location.getLocationName(), location.getAddress());
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    @Override
    public LocationDTO Retrieve(Serializable id) {
        try (Connection connection = MyDataSource.getConnection(); PreparedStatement statement = MyDataSource.prepareStatement(connection,SQL_RETRIEVE, id); 
                ResultSet resultSet = statement.executeQuery()
                ) {
            if (resultSet.next()) {
                LocationDTO location = new LocationDTO();
                location.setLocationId(resultSet.getInt("Location_id"));
                location.setLocationName(resultSet.getString("Location_name"));
                location.setAddress(resultSet.getString("Address"));
                return location;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<LocationDTO> RetrieveAll() {
        List<LocationDTO> locations = new ArrayList<>();
        try (Connection connection = MyDataSource.getConnection(); PreparedStatement statement = MyDataSource.prepareStatement(connection,SQL_RETRIEVE_ALL); ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                LocationDTO location = new LocationDTO();
                location.setLocationId(resultSet.getInt("Location_id"));
                location.setLocationName(resultSet.getString("Location_name"));
                location.setAddress(resultSet.getString("Address"));
                locations.add(location);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return locations;
    }
}


