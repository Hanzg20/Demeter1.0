
package controller;

import dataaccesslayer.DAO;
import dataaccesslayer.ItemDaoImpl;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ItemDTO;

/**
 *
 * @author Glily
 */
@WebServlet(name = "InventoryControllerServlet", urlPatterns = {"/inventory/*"})
public class InventoryControllerServlet extends HttpServlet {

        private DAO<ItemDTO> itemDao = new ItemDaoImpl();
    

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
            case "/items":
                List<ItemDTO> items = itemDao.RetrieveAll();
                request.setAttribute("items", items);
                goTo(request,response,"/inventoryItems.jsp");
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

    private void goTo(HttpServletRequest request, HttpServletResponse response,String path) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher(path);
        dispatcher.forward(request, response);
    }
}
