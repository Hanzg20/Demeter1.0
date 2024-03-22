
package dataaccesslayer;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.SysFunctionDTO;

/**
 *
 * @author Glily
 */

public class SysFunctionDaoImpl extends DAOImpl<SysFunctionDTO> {

    final static String SQL_INSERT = "INSERT INTO sysfunction (function_name) VALUES (?)";
    final static String SQL_DELETE_ALL = "DELETE FROM sysfunction";
    final static String SQL_DELETE = "DELETE FROM sysfunction WHERE function_id = ?";
    final static String SQL_UPDATE = "UPDATE sysfunction SET function_name=? WHERE function_id = ?";
    final static String SQL_RETRIEVE = "SELECT * FROM sysfunction WHERE function_id = ?";
    final static String SQL_RETRIEVE_ALL = "SELECT * FROM sysfunction";
    
    @Override
    public int insert(SysFunctionDTO sysFunction) {
          try {
            return dataSource.execute(SQL_INSERT, sysFunction.getFuncName());
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
    public int update(SysFunctionDTO sysFunction) {

        try {
            return dataSource.execute(SQL_UPDATE, sysFunction.getFuncName());
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    @Override
    public SysFunctionDTO Retrieve(Serializable id) {
        try (PreparedStatement statement = dataSource.prepareStatement(SQL_RETRIEVE, id); 
                ResultSet resultSet = statement.executeQuery()
                ) {
            if (resultSet.next()) {
                SysFunctionDTO sysFunction = new SysFunctionDTO();
                sysFunction.setFuncId(resultSet.getInt("function_id"));
                sysFunction.setFuncName(resultSet.getString("function_name"));               
                return sysFunction;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<SysFunctionDTO> RetrieveAll() {
        List<SysFunctionDTO> sysFunctions = new ArrayList<>();
        try (PreparedStatement statement = dataSource.query(SQL_RETRIEVE_ALL); ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                 SysFunctionDTO sysFunction = new SysFunctionDTO();
                sysFunction.setFuncId(resultSet.getInt("function_id"));
                sysFunction.setFuncName(resultSet.getString("function_name"));  
                sysFunctions.add(sysFunction);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return sysFunctions;
    }
}


