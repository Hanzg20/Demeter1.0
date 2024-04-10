
package dataaccesslayer;

import static dataaccesslayer.ItemListingDaoImpl.SQL_INSERT;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import model.ItemListingDTO;
import model.TransactionDTO;

/**
 *
 * @author Glily
 */

public class TransactionDaoImpl extends DAOImpl<TransactionDTO> {

    final static String SQL_INSERT = "INSERT INTO transaction (Tran_type_id, Listing_id, User_id, Quantity, Tran_date) VALUES (?, ?, ?, ?, ?)";
    final static String SQL_DELETE_ALL = "DELETE FROM transaction";
    final static String SQL_DELETE = "DELETE FROM transaction WHERE Tran_id = ?";
    final static String SQL_UPDATE = "UPDATE transaction SET Tran_type_id=?, Listing_id=?, User_id=?, Quantity=?, Tran_date=? WHERE Tran_id = ?";
    final static String SQL_RETRIEVE = "SELECT Tran_type_id, Listing_id, User_id, Quantity, Tran_date FROM transaction WHERE Tran_id = ?";
    final static String SQL_RETRIEVE_ALL = "SELECT Tran_id, Tran_type_id, Listing_id, User_id, Quantity, Tran_date FROM transaction Where 1=1";
    
    @Override
    public int insert(TransactionDTO transaction) {
          try {
            return MyDataSource.execute(SQL_INSERT, transaction.getTranTypeId(), transaction.getListingId(), transaction.getUserId(), transaction.getQuantity(), transaction.getTranDate());
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
    public int update(TransactionDTO transaction) {

        try {
            return MyDataSource.execute(SQL_UPDATE, transaction.getTranTypeId(), transaction.getListingId(), transaction.getUserId(), transaction.getQuantity(), transaction.getTranDate());
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    @Override
    public TransactionDTO Retrieve(Serializable id) {
        try (Connection connection = MyDataSource.getConnection(); PreparedStatement statement = MyDataSource.prepareStatement(connection,SQL_RETRIEVE, id); 
                ResultSet resultSet = statement.executeQuery()
                ) {
            if (resultSet.next()) {
                TransactionDTO transaction = new TransactionDTO();
                transaction.setTranId(resultSet.getInt("Tran_id"));
                transaction.setTranTypeId(resultSet.getInt("Tran_type_id"));
                transaction.setListingId(resultSet.getInt("Listing_id"));
                transaction.setUserId(resultSet.getInt("User_id"));
                transaction.setQuantity(resultSet.getInt("Quantity")); 
                transaction.setTranDate(resultSet.getTimestamp("Tran_date")); 
                return transaction;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<TransactionDTO> RetrieveAll() {
        List<TransactionDTO> transactions = new ArrayList<>();
        try (Connection connection = MyDataSource.getConnection(); PreparedStatement statement = MyDataSource.prepareStatement(connection,SQL_RETRIEVE_ALL); ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                TransactionDTO transaction = new TransactionDTO();
                transaction.setTranId(resultSet.getInt("Tran_id"));
                transaction.setTranTypeId(resultSet.getInt("Tran_type_id"));
                transaction.setListingId(resultSet.getInt("Listing_id"));
                transaction.setUserId(resultSet.getInt("User_id"));
                transaction.setQuantity(resultSet.getInt("Quantity")); 
                transaction.setTranDate(resultSet.getTimestamp("Tran_date")); 
                transactions.add(transaction);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return transactions;
    }
    
    public PreparedStatement prepareInsertStatement(Connection connection,TransactionDTO transaction) throws SQLException {
        return MyDataSource.prepareStatement(connection,SQL_INSERT, transaction.getTranTypeId(), transaction.getListingId(), transaction.getUserId(), transaction.getQuantity(), transaction.getTranDate());
    }

    public List<TransactionDTO> RetrieveList(int userId) {
        List<TransactionDTO> transactions = new ArrayList<>();
        try (Connection connection = MyDataSource.getConnection(); PreparedStatement statement = prepareStatement(connection,SQL_RETRIEVE_ALL,userId); ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                TransactionDTO transaction = new TransactionDTO();
                transaction.setTranId(resultSet.getInt("Tran_id"));
                transaction.setTranTypeId(resultSet.getInt("Tran_type_id"));
                transaction.setListingId(resultSet.getInt("Listing_id"));
                transaction.setUserId(resultSet.getInt("User_id"));
                transaction.setQuantity(resultSet.getInt("Quantity")); 
                transaction.setTranDate(resultSet.getTimestamp("Tran_date")); 
                transactions.add(transaction);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return transactions;
    }
    
    private PreparedStatement prepareStatement(Connection connection,String sql,int userId) throws SQLException {
        StringBuilder queryBuilder = new StringBuilder(sql);
        queryBuilder.append(" AND User_id= ?");
        
        PreparedStatement statement = MyDataSource.prepareStatement(connection,queryBuilder.toString());
        int parameterIndex = 1;
        statement.setInt(parameterIndex++, userId);
        

        return statement;
    }
}


