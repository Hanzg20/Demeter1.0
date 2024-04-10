package controller;

import businesslayer.NavigationHelper;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import businesslayer.UserService;


@WebServlet(name = "UserControllerServlet", urlPatterns = {"/user/*"})
public class UserControllerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    UserService dataServices = new UserService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String action = request.getPathInfo();

        switch (action) {
            case "/edit":
                String idForEdit = request.getParameter("id");
                if (idForEdit == null) {
                    NavigationHelper.HandleError(response, new Exception("Bad Reqeust with not id."));
                } else {
                    request.setAttribute("viewModel", dataServices.buidUserEditViewModel(Integer.parseInt(idForEdit)));
                    NavigationHelper.goTo(request, response, "/views/inventory/edit.jsp");
                }

                break;
            default:
                String role = request.getParameter("role");
                request.setAttribute("viewModel", dataServices.buidUserViewModel());
                NavigationHelper.goTo(request, response, "/views/user/list.jsp");
                break;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
