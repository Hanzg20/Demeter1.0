package dataaccesslayer;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.UserFunctionDTO;

public class UserFunctionDaoImpl extends DAOImpl<UserFunctionDTO> {

    final static String SQL_INSERT = "INSERT INTO user_function (role_id,function_id) VALUES (?,?)";
    final static String SQL_DELETE_ALL = "DELETE FROM user_function";
    final static String SQL_DELETE = "DELETE FROM user_function WHERE function_id  = ? AND role_id = ?";
    final static String SQL_UPDATE = "UPDATE user_function SET role_id = ? WHERE function_id  = ? AND role_id = ?";
    final static String SQL_RETRIEVE = "SELECT role_id,function_id FROM user_function WHERE function_id  = ? AND role_id = ?";
    final static String SQL_RETRIEVE_ALL = "SELECT role_id,function_id FROM user_function";
    final static String SQL_RETRIEVE_ALL_BY_ROLE = "SELECT role_id,function_id FROM user_function WHERE role_id = ?";
    @Override
    public int insert(UserFunctionDTO userFunction) {

        try {
            return MyDataSource.execute(SQL_INSERT, userFunction.getRoleId(),userFunction.getFuncId());
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
                return 0;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    @Override
    public UserFunctionDTO Retrieve(Serializable id) {
        try (Connection connection = MyDataSource.getConnection(); PreparedStatement statement = MyDataSource.prepareStatement(connection,SQL_RETRIEVE, id); 
                ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                UserFunctionDTO userFunction = new UserFunctionDTO();
                userFunction.setFuncId(resultSet.getInt("function_id"));
                userFunction.setRoleId(resultSet.getInt("role_id"));
                return userFunction;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<UserFunctionDTO> RetrieveAll() {
        List<UserFunctionDTO> userFunctions = new ArrayList<>();
        try (Connection connection = MyDataSource.getConnection(); PreparedStatement statement = MyDataSource.prepareStatement(connection,SQL_RETRIEVE_ALL); ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                UserFunctionDTO userFunction = new UserFunctionDTO();
                userFunction.setFuncId(resultSet.getInt("function_id"));
                userFunction.setRoleId(resultSet.getInt("role_id"));
                userFunctions.add(userFunction);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return userFunctions;
    }

    public List<UserFunctionDTO> RetrieveAllByRoleId(int roleId) {
        List<UserFunctionDTO> userFunctions = new ArrayList<>();
        try (Connection connection = MyDataSource.getConnection(); PreparedStatement statement = MyDataSource.prepareStatement(connection,SQL_RETRIEVE_ALL_BY_ROLE,roleId); ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                UserFunctionDTO userFunction = new UserFunctionDTO();
                userFunction.setFuncId(resultSet.getInt("function_id"));
                userFunction.setRoleId(resultSet.getInt("role_id"));
                userFunctions.add(userFunction);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return userFunctions;
    }
}
