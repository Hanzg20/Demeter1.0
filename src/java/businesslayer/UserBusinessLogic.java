package businesslayer;

import java.sql.SQLException;
import java.util.List;
import model.UserDTO;
import dataaccesslayer.UserDaoImpl;

public class UserBusinessLogic {
    private UserDaoImpl userDao;

    public UserBusinessLogic() {
        this.userDao = new UserDaoImpl();
    }

    public void addUser(UserDTO user) throws SQLException {
        userDao.insert(user);
    }

    public List<UserDTO> getAllUsers() throws SQLException {
        return userDao.findAll();
    }

    // Add more methods for user-related business logic as needed
}
