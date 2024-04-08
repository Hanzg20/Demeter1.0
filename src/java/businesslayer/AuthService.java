package businesslayer;

import dataaccesslayer.DAO;
import dataaccesslayer.RoleDaoImpl;
import java.sql.SQLException;
import java.util.List;
import model.UserDTO;
import dataaccesslayer.UserDaoImpl;
import model.RoleDTO;

public class AuthService {
    private UserDaoImpl userDao= new UserDaoImpl();
    private DAO<RoleDTO> roleDao = new RoleDaoImpl();


    public void addUser(UserDTO user) throws SQLException {
        userDao.insert(user);
    }

    public List<UserDTO> getAllUsers() throws SQLException {
        return userDao.RetrieveAll();
    }

    // Add more methods for user-related business logic as needed
}
