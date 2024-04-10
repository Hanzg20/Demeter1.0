<%-- 
    Document   : add
    Created on : Mar 31, 2024, 11:08:33 a.m.
    Author     : ZhAOGUO HAN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri= "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
          <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
          <link rel="stylesheet" type="text/css" href="${ctx}/resources/css/demeter.css">
          <title>Add Subscription</title>
       </head>
<body>
        <a href="javascript:history.back()">Back to Subscription List</a>
        <div class="main-container">
                <div class="main-section">
                    <h3>Add Subscription</h3>
                    <label for="userId">Subscriber</label>
                    <input type="text" id="userId" name="userId" required>

                    <label for="notiMethod">Notification Method:</label>
                    <input type="text" id="notiMethod" name="notiMethod" required>

                    <label for="itemLocation">Location:</label>
                    <select id="itemLocation" name="itemLocation" required>
                        <option value="1">Ottawa Central Market</option>
                        <option value="2">Ottawa Community Kitchen</option>
                        <option value="3">Ottawa Food Bank</option>
                        <!-- Add more options as needed -->
                    </select>

                    <label for="itemPrice">Item Price:</label>
                    <input type="text" id="itemPrice" name="itemPrice" required>

                    <label for="itemTypeId">Item Type ID:</label>
                    <select id="itemTypeId" name="itemTypeId" required>
                        <option value="1">Vegetable1</option>
                        <option value="2">Bakery</option>
                        <option value="3">Canned</option>
                        <option value="4">Dairy</option>
                        <option value="5">Meat</option>
                        <option value="6">Pasta and Rice</option>
                        <option value="7">Vegetable2</option>
                        <option value="8">Snacks</option>
                        <!-- Add more options as needed -->
                    </select>


                        <input type="submit" value="Add">
                </form>
          </div>
       </div>
</body>
</html>
