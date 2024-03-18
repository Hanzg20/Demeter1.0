package businesslayer;

import java.sql.SQLException;
import java.util.List;
import model.UserDto;
import dataaccesslayer.UserDaoImpl;

public class UserBusinessLogic {
    private UserDaoImpl userDao;

    public UserBusinessLogic() {
        this.userDao = new UserDaoImpl();
    }

    public void addUser(UserDto user) throws SQLException {
        userDao.insert(user);
    }

    public List<UserDto> getAllUsers() throws SQLException {
        return userDao.findAll();
    }

    // Add more methods for user-related business logic as needed
}
