package controller;

import businesslayer.ItemsService;
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
import viewmodel.ListingViewModelItem;

/**
 *
 * @author Glily
 */
@WebServlet(name = "SurplusItemControllerServlet", urlPatterns = {"/surplus/*"})
public class SurplusItemControllerServlet extends HttpServlet {

    private final ItemsService dataService = new ItemsService();

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
            case "/donate":
            case "/sale":
                String idForView = request.getParameter("id");
                if (idForView == null) {
                    NavigationHelper.HandleError(response, new Exception("Bad Reqeust with not id."));
                } else {
                    ListingViewModelItem item = dataService.buidListingViewModelItem(Integer.parseInt(idForView));
                    if (item == null) {
                        NavigationHelper.HandleError(response, new Exception("Bad Reqeust. Item not found"));
                    } else {
                        request.setAttribute("item", item);
                        if ("/donate".equals(action)) {
                            NavigationHelper.goTo(request, response, "/views/surplus/donate.jsp");
                        } else {
                            NavigationHelper.goTo(request, response, "/views/surplus/sale.jsp");
                        }
                    }
                }
                break;
            default:
                String itemType = request.getParameter("itemType");
                String expireDays = request.getParameter("expireDays");
                request.setAttribute("viewModel", dataService.buidListingViewModel(itemType, expireDays));
                NavigationHelper.goTo(request, response, "/views/surplus/list.jsp");
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
            String discount = request.getParameter("discountRate");
            if ((action.equals("/donate") || action.equals("/sale")) && id == null
                    || (action.equals("/sale") && discount == null)) {
                NavigationHelper.HandleError(response, new Exception("Open Failed. Missing id"));
            } else {
                switch (action) {
                    case "/donate":
                    case "/sale":
                        boolean successSubmit = false;
                        if(action.equals("/donate"))
                        {
                            successSubmit = dataService.donate(Integer.parseInt(id));
                        }else if(action.equals("/sale"))
                        {
                            
                            successSubmit = dataService.sale(Integer.parseInt(id), Double.parseDouble(discount));
                        }
                        else
                        {
                             NavigationHelper.HandleError(response, new Exception("Failed. Invalid request"));
                        }
                        
                        if (successSubmit) {
                            response.sendRedirect("/surplus/");
                        } else {
                            NavigationHelper.HandleError(response, new Exception("Failed. Please retry"));
                        }
                        break;

                    default:
                        break;

                }
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
