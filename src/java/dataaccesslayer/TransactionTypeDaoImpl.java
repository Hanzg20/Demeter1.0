
package dataaccesslayer;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.TransactionTypeDTO;

/**
 *
 * @author Glily
 */

public class TransactionTypeDaoImpl extends DAOImpl<TransactionTypeDTO> {

    final static String SQL_INSERT = "INSERT INTO transaction_type (Tran_type_name) VALUES (?)";
    final static String SQL_DELETE_ALL = "DELETE FROM transaction_type";
    final static String SQL_DELETE = "DELETE FROM transaction_type WHERE Tran_type_id=?";
    final static String SQL_UPDATE = "UPDATE transaction_type SET Tran_type_name =? WHERE Tran_type_id=?";
    final static String SQL_RETRIEVE = "SELECT * FROM transaction_type WHERE Tran_type_id=?";
    final static String SQL_RETRIEVE_ALL = "SELECT * FROM transaction_type";
    
    @Override
    public int insert(TransactionTypeDTO transactionType) {
          try {
            return MyDataSource.execute(SQL_INSERT, transactionType.getTranTypeName());
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
    public int update(TransactionTypeDTO transactionType) {

        try {
            return MyDataSource.execute(SQL_UPDATE, transactionType.getTranTypeName());
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    @Override
    public TransactionTypeDTO Retrieve(Serializable id) {
        try (Connection connection = MyDataSource.getConnection(); PreparedStatement statement = MyDataSource.prepareStatement(connection,SQL_RETRIEVE, id); 
                ResultSet resultSet = statement.executeQuery()
                ) {
            if (resultSet.next()) {
                TransactionTypeDTO transactionType = new TransactionTypeDTO();
                transactionType.setTranTypeId(resultSet.getInt("Tran_type_id"));
                transactionType.setTranTypeName(resultSet.getString("Tran_type_name"));
                return transactionType;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<TransactionTypeDTO> RetrieveAll() {
        List<TransactionTypeDTO> transactionTypes = new ArrayList<>();
        try (Connection connection = MyDataSource.getConnection(); PreparedStatement statement = MyDataSource.prepareStatement(connection,SQL_RETRIEVE_ALL); ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                TransactionTypeDTO transactionType = new TransactionTypeDTO();
                transactionType.setTranTypeId(resultSet.getInt("Tran_type_id"));
                transactionType.setTranTypeName(resultSet.getString("Tran_type_name"));
                transactionTypes.add(transactionType);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return transactionTypes;
    }
}


