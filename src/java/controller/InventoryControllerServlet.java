package controller;

import businesslayer.InventoryService;
import businesslayer.NavigationHelper;
import dataaccesslayer.DAO;
import dataaccesslayer.ItemDaoImpl;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
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
        switch (action) {
            case "/add":
                request.setAttribute("viewModel", dataService.buidInventoryAddViewModel());
                NavigationHelper.goTo(request, response, "/views/inventory/add.jsp");
                break;
            case "/edit":
                String idForEdit = request.getParameter("id");
                if (idForEdit == null) {
                    NavigationHelper.HandleError(response, new Exception("Bad Reqeust with not id."));
                } else {
                    request.setAttribute("viewModel", dataService.buidInventoryEditViewModel(Integer.parseInt(idForEdit)));
                    NavigationHelper.goTo(request, response, "/views/inventory/edit.jsp");
                }

                break;
            case "/view":
                String idForView = request.getParameter("id");
                if (idForView == null) {
                    NavigationHelper.HandleError(response, new Exception("Bad Reqeust with not id."));
                } else {
                    InventoryViewModel.Item item = dataService.buidInventoryViewModelItem(Integer.parseInt(idForView));
                    if (item == null) {
                        NavigationHelper.HandleError(response, new Exception("Bad Reqeust. Item not found"));
                    } else {
                        request.setAttribute("item", item);
                        NavigationHelper.goTo(request, response, "/views/inventory/view.jsp");
                    }

                }

                break;
            default:
                String itemType = request.getParameter("itemType");
                String status = request.getParameter("status");
                String expireDays = request.getParameter("expireDays");
                request.setAttribute("viewModel", dataService.buidInventoryViewModel(itemType, status, expireDays));
                NavigationHelper.goTo(request, response, "/views/inventory/list.jsp");
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
            if ((action.equals("/edit")||action.equals("/view")) && id == null) {
                NavigationHelper.HandleError(response, new Exception("Open Failed. Missing id"));
            } else {
                switch (action) {
                    case "/add":
                    case "/edit":
                        if (dataService.saveItemWithRequest(request) == 0) {
                            NavigationHelper.HandleError(response, new Exception("Failed. Please try again"));
                        } else {
                            response.sendRedirect("/inventory/");
                        }

                        break;
                    case "/view":
                        String submitAction = request.getParameter("action");
                        boolean successSubmit = false;
                        switch (submitAction) {
                            case "delete":
                                successSubmit = dataService.delete(id);
                                break;
                            case "flag":
                                successSubmit = dataService.flag(id);
                                break;
                            default:
                                NavigationHelper.HandleError(response, new Exception("Failed. Action not found"));
                                return;
                        }
                        if (successSubmit) {
                            response.sendRedirect("/inventory/");
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
