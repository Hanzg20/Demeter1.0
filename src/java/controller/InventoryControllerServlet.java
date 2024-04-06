
package controller;

import businesslayer.InventoryService;
import businesslayer.NavigationHelper;
import dataaccesslayer.DAO;
import dataaccesslayer.ItemDaoImpl;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ItemDTO;
import viewmodel.InventoryViewModel;

/**
 *
 * @author Glily
 */
@WebServlet(name = "InventoryControllerServlet", urlPatterns = {"/inventory/*"})
public class InventoryControllerServlet extends HttpServlet {

        private final InventoryService dataService = new InventoryService();
    

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
            case "/add":
                request.setAttribute("viewModel", dataService.buidInventoryAddViewModel());
                NavigationHelper.goTo(request,response,"/views/inventory/add.jsp");
                break;
            case "/edit":
                NavigationHelper.goTo(request,response,"/views/inventory/edit.jsp");
                break;
            case "/view":
                NavigationHelper.goTo(request,response,"/views/inventory/view.jsp");
                break;
            default:
                String itemType = request.getParameter("itemType");
                String status = request.getParameter("status");
                String expireDays = request.getParameter("expireDays");
                request.setAttribute("viewModel", dataService.buidInventoryViewModel(itemType,status,expireDays));
                NavigationHelper.goTo(request,response,"/views/inventory/list.jsp");
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
