
package controller;

import businesslayer.ItemListingService;
import businesslayer.NavigationHelper;
import dataaccesslayer.DAO;
import dataaccesslayer.ItemListingDaoImpl;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ItemListingDTO;

/**
 *
 * @author Glily
 */
@WebServlet(name = "ClaimControllerServlet", urlPatterns = {"/claim/*"})
public class ClaimControllerServlet extends HttpServlet {    
    private final ItemListingService dataService = new ItemListingService();
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
        switch(action)
        {
            case "/claim":
                NavigationHelper.goTo(request,response,"/views/donation/claim.jsp");
                break;
            case "/claims":
                NavigationHelper.goTo(request,response,"/views/donation/claims.jsp");
                break;
            default:
                String itemType = request.getParameter("itemType");
                String expireDays = request.getParameter("expireDays");
                request.setAttribute("viewModel", dataService.buidDonationViewModel(itemType, expireDays));
                NavigationHelper.goTo(request,response,"/views/donation/list.jsp");
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
