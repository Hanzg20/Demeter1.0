package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businesslayer.UserBusinessLogic;
import model.UserDTO;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserBusinessLogic userBusinessLogic = new UserBusinessLogic();
        List<UserDTO> users = null;

        try {
            users = userBusinessLogic.getAllUsers();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        request.setAttribute("users", users);

        RequestDispatcher dispatcher = request.getRequestDispatcher("views/users.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        addUser(request, response);

        doGet(request, response);
    }

    private void addUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserBusinessLogic userBusinessLogic = new UserBusinessLogic();
        String username = request.getParameter("username");
        int roleId = Integer.parseInt(request.getParameter("roleId"));
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        // String CreateDate = request.getParameter("password");

        UserDTO user = new UserDTO();
        user.setUsername(username);
        user.setRoleId(roleId);
        user.setEmail(email);
        user.setPassword(password);
      //  user.setCreateDate(CreateDate);

        try {
            userBusinessLogic.addUser(user);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
