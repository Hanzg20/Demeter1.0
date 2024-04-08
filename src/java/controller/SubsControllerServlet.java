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
                // Set any necessary attributes for the add view
                NavigationHelper.goTo(request, response, "/views/subs/add.jsp");
                break;
            case "/edit":
                String idForEdit = request.getParameter("id");
                if (idForEdit == null) {
                    NavigationHelper.HandleError(response, new Exception("Bad Request with no ID."));
                } else {
                    // Set attributes for the edit view
                    // Example: request.setAttribute("viewModel", subsService.buildSubsEditViewModel(Integer.parseInt(idForEdit)));
                    NavigationHelper.goTo(request, response, "/views/subs/edit.jsp");
                }
                break;
            default:
                // Set attributes for the list view
                request.setAttribute("viewModel", subsService.buidSubsViewModel());
                NavigationHelper.goTo(request, response, "/views/subs/list.jsp");
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Handle POST requests (e.g., form submissions) for adding/editing subscriptions
        // Extract form data, validate, and perform corresponding actions
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
