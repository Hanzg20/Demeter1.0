package businesslayer;

import dataaccesslayer.DAO;
import dataaccesslayer.RoleDaoImpl;
import dataaccesslayer.SysFunctionDaoImpl;
import java.sql.SQLException;
import java.util.List;
import model.UserDTO;
import dataaccesslayer.UserDaoImpl;
import dataaccesslayer.UserFunctionDaoImpl;
import javax.servlet.http.HttpServletRequest;
import model.RoleDTO;
import model.SysFunctionDTO;
import model.UserFunctionDTO;
import viewmodel.UserRoleFunction;

public class AuthService {
    private UserDaoImpl userDao= new UserDaoImpl();
    private DAO<RoleDTO> roleDao = new RoleDaoImpl();
    private SysFunctionDaoImpl functionDao = new SysFunctionDaoImpl();
    private UserFunctionDaoImpl userFunctionDao = new UserFunctionDaoImpl();

    public void addUser(UserDTO user) throws SQLException {
        userDao.insert(user);
    }

    public List<UserDTO> getAllUsers() throws SQLException {
        return userDao.RetrieveAll();
    }

    // Add more methods for userDTO-related business logic as needed

    public boolean login(HttpServletRequest request) {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        UserDTO userDTO = userDao.RetrieveByEmail(email);
        if (userDTO != null) {
            boolean isValidPassword = userDTO.getPassword().equals(password);

            if (isValidPassword) {
                List<UserFunctionDTO> userFunctionDTOs = userFunctionDao.RetrieveAllByRoleId(userDTO.getRoleId());
                if (!userFunctionDTOs.isEmpty()) {
                    SysFunctionDTO[] sysFunctionDTOs = new SysFunctionDTO[userFunctionDTOs.size()];
                    for (int i = 0; i < userFunctionDTOs.size(); i++) {
                        SysFunctionDTO sysFunctionDTO = functionDao.Retrieve(userFunctionDTOs.get(i).getFuncId());
                        if (sysFunctionDTO != null) {
                            sysFunctionDTOs[i] = sysFunctionDTO;
                        } else {
                            return false;
                        }
                    }
                    UserRoleFunction userRoleFunction = UserRoleFunction.convertFrom(userDTO, roleDao.Retrieve(userDTO.getRoleId()), sysFunctionDTOs);
                    request.getSession().setAttribute("userRoleFunction", userRoleFunction);
                    return true;
                }
            }
        }
       
        
        return false;
    }
    
    public boolean isLoggedIn(HttpServletRequest request)
    {
        return request.getSession().getAttribute("userRoleFunction") != null;
    }
    
    public String getFirstPath(HttpServletRequest request)
    {
        
        if(request.getSession().getAttribute("userRoleFunction") != null)
        {
            UserRoleFunction.SysFunctionURL[] getFunctionURLs = ((UserRoleFunction)request.getSession().getAttribute("userRoleFunction")).getFunctionURLs();
            if(getFunctionURLs.length>0)
            {
                return getFunctionURLs[0].getSysFunctionUrl();
            }
        }
        return null;
    }
    
    public int getUserId(HttpServletRequest request) {
        if (request.getSession().getAttribute("userRoleFunction") != null) {
            return ((UserRoleFunction) request.getSession().getAttribute("userRoleFunction")).getUserId();
        }
        
        return 0;
    }
    
    public String getUserName(HttpServletRequest request) {
        if (request.getSession().getAttribute("userRoleFunction") != null) {
            return ((UserRoleFunction) request.getSession().getAttribute("userRoleFunction")).getName();
        }
        
        return null;
    }
}
