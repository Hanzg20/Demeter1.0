
package controller;

import businesslayer.AuthService;
import businesslayer.NavigationHelper;
import businesslayer.SubscriptionService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Glily
 */
@WebServlet(name = "SubscriptionControllerServlet", urlPatterns = {"/notification/*"})
public class SubscriptionControllerServlet extends HttpServlet {    
    AuthService authService = new AuthService();

    private final SubscriptionService dataService = new SubscriptionService();
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getPathInfo();
        switch (action) {
            default:
                if (authService.isLoggedIn(request)) {
                    String itemType = request.getParameter("itemType");
                    request.setAttribute("viewModel", dataService.buidSubscriptionViewModel(authService.getUserId(request), itemType));
                    NavigationHelper.goTo(request, response, "/views/subscription/list.jsp");
                } else {
                    NavigationHelper.HandleError(response, new Exception("Bad Reqeust with not login user."));
                }

                break;

        }

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
