/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package businesslayer;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author liyingguo
 */
public class NavigationHelper {

    public static void goTo(HttpServletRequest request, HttpServletResponse response, String path) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher(path);
        dispatcher.forward(request, response);
    }

    public static void HandleError(HttpServletResponse response, Exception exception) {

        // Set an appropriate error code (e.g., 500 for internal server error)
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);

        // Set the content type to indicate that an error message will be sent
        response.setContentType("text/plain");

        if (exception != null) {
            exception.printStackTrace();
            try {
                // Write the error message to the response
                response.getWriter().write("An error occurred: " + exception.getMessage());
            } catch (IOException ex) {
                exception.printStackTrace();
            }
        }
    }

    public static void back(HttpServletRequest request,HttpServletResponse response) {
        // Redirect the user back to the previous page
        String referer = request.getHeader("referer");
        try {
            response.sendRedirect(referer);
        } catch (IOException ex) {
            HandleError(response, ex);
        }
    }
}
