<%-- 
    Document   : edit
    Created on : Mar 31, 2024, 11:08:50 a.m.
    Author     : liyingguo
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
          <link rel="stylesheet" type="text/css" href="${ctx}/resources/css/demeter.css">
        <title>Inventory-Edit Item</title>
    </head>
    <body>
        <a href="javascript:history.back()">Back to Items List</a>
        <div class="main-container">
            <div class="main-section">    
             <h3>Edit Item</h3>
                <form method="post">
                    <input type="hidden" name="itemId" value="${viewModel.item.itemId}">
                    <label for="itemName">Item Name:</label><br>
                    <input type="text" id="itemName" name="itemName" value="${viewModel.item.itemName}"><br><br>

                    <label for="unit">Unit:</label><br>
                    <input type="text" id="unit" name="unit" value="${viewModel.item.unit}"><br><br>

                    <label for="locationId">Location:</label><br>
                    <select id="locationId" name="locationId">
                        <c:forEach var="location" items="${viewModel.locations}">
                            <option value="${location.locationId}" ${location.locationId == viewModel.item.locationId ? 'selected' : ''}>${location.address}</option>
                        </c:forEach>
                    </select><br><br>

                    <label for="createDate">Create Date:</label><br>
                    <input type="datetime-local" id="createDate" name="createDate" value="${viewModel.item.createDate}"><br><br>

                    <label for="userId">User:</label><br>
                    <select id="userId" name="userId">
                        <c:forEach var="user" items="${viewModel.users}">
                            <option value="${user.userId}" ${user.userId == viewModel.item.userId ? 'selected' : ''}>${user.name}</option>
                        </c:forEach>
                    </select><br><br>

                    <label for="itemTypeId">Item Type:</label><br>
                    <select id="itemTypeId" name="itemTypeId">
                        <c:forEach var="type" items="${viewModel.types}">
                            <option value="${type.itemTypeId}" ${type.itemTypeId == viewModel.item.itemTypeId ? 'selected' : ''}>${type.itemTypeName}</option>
                        </c:forEach>
                    </select><br><br>

                    <label for="quantity">Quantity:</label><br>
                    <input type="number" id="quantity" name="quantity" value="${viewModel.item.quantity}"><br><br>

                    <label for="expirDate">Expiry Date:</label><br>
                    <input type="datetime-local" id="expirDate" name="expirDate" value="${viewModel.item.expirDate}"><br><br>

                    <label for="price">Price:</label><br>
                    <input type="number" id="price" name="price" step="0.01" value="${viewModel.item.price}"><br><br>

                    <label for="status">Status:</label><br>
                    <select id="status" name="status">
                        <c:forEach var="option" items="${viewModel.statusOptions}">
                            <option value="${option.symbol}" ${option.symbol == viewModel.item.status ? 'selected' : ''}>${option.text}</option>
                        </c:forEach>
                    </select><br><br>

                    <label for="statusDate">Status Date:</label><br>
                    <input type="datetime-local" id="statusDate" name="statusDate" value="${viewModel.item.statusDate}"><br><br>

                    <input type="submit" value="Update">
                </form>
            </div>
         </div>
    </body>
</script>
</html>
