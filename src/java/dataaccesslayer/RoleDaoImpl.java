
package dataaccesslayer;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.RoleDTO;

/**
 *
 * @author Glily
 */

public class RoleDaoImpl extends DAOImpl<RoleDTO> {

    final static String SQL_INSERT = "INSERT INTO role (Role_name, Role_type) VALUES (?, ?)";
    final static String SQL_DELETE_ALL = "DELETE FROM role";
    final static String SQL_DELETE = "DELETE FROM role WHERE Role_id = ?";
    final static String SQL_UPDATE = "UPDATE role SET Role_name=?, Role_type=? WHERE Role_id = ?";
    final static String SQL_RETRIEVE = "SELECT * FROM role WHERE Role_id = ?";
    final static String SQL_RETRIEVE_ALL = "SELECT * FROM role";
    
    @Override
    public int insert(RoleDTO role) {
          try {
            return dataSource.execute(SQL_INSERT, role.getRoleName(), role.getRoleTypeId());
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
    public int update(RoleDTO role) {

        try {
            return dataSource.execute(SQL_UPDATE, role.getRoleName(), role.getRoleTypeId());
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    @Override
    public RoleDTO Retrieve(Serializable id) {
        try (PreparedStatement statement = dataSource.prepareStatement(SQL_RETRIEVE, id); 
                ResultSet resultSet = statement.executeQuery()
                ) {
            if (resultSet.next()) {
                RoleDTO role = new RoleDTO();
                role.setRoleId(resultSet.getInt("Role_id"));
                role.setRoleName(resultSet.getString("Role_name"));
                role.setRoleTypeId(resultSet.getInt("Role_type"));
                return role;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<RoleDTO> RetrieveAll() {
        List<RoleDTO> roles = new ArrayList<>();
        try (PreparedStatement statement = dataSource.prepareStatement(SQL_RETRIEVE_ALL); ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
               RoleDTO role = new RoleDTO();
               role.setRoleId(resultSet.getInt("Role_id"));
               role.setRoleName(resultSet.getString("Role_name"));
               role.setRoleTypeId(resultSet.getInt("Role_type"));
               roles.add(role);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return roles;
    }
}


