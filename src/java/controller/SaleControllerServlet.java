package controller;

import businesslayer.AuthService;
import businesslayer.ItemListingService;
import businesslayer.NavigationHelper;
import businesslayer.TransactionService;
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
import viewmodel.InventoryViewModelItem;
import viewmodel.ListingViewModelItem;
import viewmodel.SaleViewModelItem;

/**
 *
 * @author Glily
 */
@WebServlet(name = "SaleControllerServlet", urlPatterns = {"/sale/*"})
public class SaleControllerServlet extends HttpServlet {
    AuthService dataService = new AuthService();

    private final ItemListingService itemListingService = new ItemListingService();
    private final TransactionService transactionService = new TransactionService();
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
            case "/order":
                String idForView = request.getParameter("id");
                if (idForView == null) {
                    NavigationHelper.HandleError(response, new Exception("Bad Reqeust with not id."));
                } else {
                    SaleViewModelItem item = itemListingService.buidSaleViewModelItem(Integer.parseInt(idForView));
                    if (item == null) {
                        NavigationHelper.HandleError(response, new Exception("Bad Reqeust. Item not found"));
                    } else {
                        request.setAttribute("item", item);
                        NavigationHelper.goTo(request, response, "/views/sale/order.jsp");
                    }

                }
                break;
//            case "/orders":
//                NavigationHelper.goTo(request, response, "/views/sale/orders.jsp");
//                break;
            default:
                String itemType = request.getParameter("itemType");
                String expireDays = request.getParameter("expireDays");
                request.setAttribute("viewModel", itemListingService.buidSaleViewModel(itemType, expireDays));
                NavigationHelper.goTo(request, response, "/views/sale/list.jsp");
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
        String action = request.getPathInfo();
        try {
            String id = request.getParameter("id");
            switch (action) {
                    case "/order":
                        String quantity = request.getParameter("quantity");
                        boolean successSubmit = false;
                        if(dataService.isLoggedIn(request) && quantity != null)
                        {
                           successSubmit = transactionService.buy(dataService.getUserId(request),Integer.parseInt(id),Integer.parseInt(quantity));
                        }

                        if (successSubmit) {
                            response.sendRedirect("/sale/");
                        } else {
                            NavigationHelper.HandleError(response, new Exception("Failed. Please retry"));
                        }
                        break;

                default:
                    NavigationHelper.HandleError(response, new Exception("Failed. Invalid request"));
                    break;

                }

            // Perform add operation
            // Example: call a service method to add the item
            // addItem(itemName, unit, locationId, createDate, userId, itemTypeId, quantity, expirDate, price, status, statusDate);
            // Redirect the user to a successSubmit page or back to the previous page
            // Example: response.sendRedirect("successSubmit.jsp");
        } catch (Exception e) {
            NavigationHelper.HandleError(response, e);
        }
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
