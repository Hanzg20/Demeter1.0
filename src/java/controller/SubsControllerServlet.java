package controller;

import businesslayer.SubsService;
import businesslayer.NavigationHelper;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class SubsControllerServlet
 */
@WebServlet(name = "SubsControllerServlet", urlPatterns = {"/subs/*"})
public class SubsControllerServlet extends HttpServlet {

    private final SubsService subsService;

    public SubsControllerServlet() {
        this.subsService = new SubsService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getPathInfo();
        switch (action) {
            case "/add":
               // request.setAttribute("viewModel", subsService.addSubs(subscription));
                NavigationHelper.goTo(request, response, "/views/subs/add.jsp");
                break;
            case "/edit":
                String idForEdit = request.getParameter("id");
             /*         if (idForEdit == null) {
                    NavigationHelper.HandleError(response, exception);
                    handleError(response, new Exception("Bad Request with no ID."));
                } else {
                 //   request.setAttribute("viewModel", subsService.buildSubsEditViewModel(Integer.parseInt(idForEdit)));
                    NavigationHelper.goTo(request, response, "/views/subs/edit.jsp");
                }*/
                break;
            default:
                request.setAttribute("viewModel", subsService.buidSubsViewModel());
                NavigationHelper.goTo(request, response, "/views/subs/list.jsp");
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
