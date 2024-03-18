package dataaccesslayer;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.UserDto;

public class UserDaoImpl implements DAO<UserDto> {

    @Override
 public int insert(UserDto user) {
    String sql = "INSERT INTO user (Name, Role_id, Email, Password) VALUES (?, ?, ?, ?)";
    
    DataSource dataSource = new DataSource();

    try {
        return dataSource.executeUpdate(sql, user.getUsername(), user.getRoleId(), user.getEmail(), user.getPassword());
    } catch (Exception ex) {
        ex.printStackTrace();
        return 0;
    }
}

    @Override
    public int delete(Serializable id) {
        String sql = (Integer) id == 0 ? "DELETE FROM user" : "DELETE FROM user WHERE user_id = ?";
        
        try {
            return DataSource.executeUpdate(sql, id);
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }
    }

 @Override
public int update(UserDto user) {
    String sql = "UPDATE user SET Name = ?, Role_id = ?, Email = ? WHERE user_id = ?";

    try {
        return DataSource.executeUpdate(sql, user.getUsername(), user.getRoleId(), user.getEmail(), user.getUserId());
    } catch (Exception ex) {
        ex.printStackTrace();
        return 0;
    }
}


@Override
public UserDto findById(Serializable id) {
    String sql = "SELECT * FROM user WHERE user_id = ?";
    
    try {
        ResultSet resultSet = DataSource.executeQuery(sql, id);
        if (resultSet.next()) {
            UserDto user = new UserDto();
            user.setUserId(resultSet.getInt("user_id"));
            user.setEmail(resultSet.getString("first_name"));
            user.setRoleId(resultSet.getInt("role_id"));
            return user;
        }
    } catch (Exception ex) {
        ex.printStackTrace();
    }
    return null;
}

    @Override
    public List<UserDto> findAll() {
        List<UserDto> users = new ArrayList<>();
        String sql = "SELECT * FROM user";
        
        try {
            ResultSet resultSet = DataSource.executeQuery(sql);
            while (resultSet.next()) {
                UserDto user = new UserDto();
               user.setUserId(resultSet.getInt("user_id"));
                user.setEmail(resultSet.getString("first_name"));
                user.setRoleId(resultSet.getInt("role_id"));
                users.add(user);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return users;
    }
}
