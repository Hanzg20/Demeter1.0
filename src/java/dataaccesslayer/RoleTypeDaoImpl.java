
package dataaccesslayer;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.RoleTypeDTO;

/**
 *
 * @author Glily
 */

public class RoleTypeDaoImpl extends DAOImpl<RoleTypeDTO> {

    final static String SQL_INSERT = "INSERT INTO role_type (Role_type_name) VALUES (?)";
    final static String SQL_DELETE_ALL = "DELETE FROM role_type";
    final static String SQL_DELETE = "DELETE FROM role_type WHERE Role_type_id = ?";
    final static String SQL_UPDATE = "UPDATE role_type SET Role_type_name=? WHERE Role_type_id = ?";
    final static String SQL_RETRIEVE = "SELECT * FROM role_type WHERE Role_type_id  = ?";
    final static String SQL_RETRIEVE_ALL = "SELECT * FROM role_type";
    
    @Override
    public int insert(RoleTypeDTO roleType) {
          try {
            return dataSource.execute(SQL_INSERT, roleType.getRoleType());
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
    public int update(RoleTypeDTO roleType) {

        try {
            return dataSource.execute(SQL_UPDATE, roleType.getRoleType());
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    @Override
    public RoleTypeDTO Retrieve(Serializable id) {
        try (PreparedStatement statement = dataSource.prepareStatement(SQL_RETRIEVE, id); 
                ResultSet resultSet = statement.executeQuery()
                ) {
            if (resultSet.next()) {
                RoleTypeDTO roleType = new RoleTypeDTO();
                roleType.setTypeId(resultSet.getInt("Role_type_id"));
                roleType.setRoleType(resultSet.getString("Role_type_name"));
                return roleType;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<RoleTypeDTO> RetrieveAll() {
        List<RoleTypeDTO> roleTypes = new ArrayList<>();
        try (PreparedStatement statement = dataSource.prepareStatement(SQL_RETRIEVE_ALL); ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
               RoleTypeDTO roleType = new RoleTypeDTO();
               roleType.setTypeId(resultSet.getInt("Role_type_id"));
               roleType.setRoleType(resultSet.getString("Role_type_name"));
               roleTypes.add(roleType);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return roleTypes;
    }
}


