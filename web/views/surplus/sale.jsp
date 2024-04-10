<%-- 
    Document   : sale
    Created on : Mar 31, 2024, 11:40:19 a.m.
    Author     : liyingguo
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Set to Donate</title>
        <jsp:include page="/resources/layout/_css.jsp"/>
        <link rel="stylesheet" href="${ctx}/resources/css/datapicker/bootstrap-datepicker.css">
       <style>
        .error-message {
            color: red;
        }
    </style>
    <script>
        function validateDiscount() {
            var discountRateInput = document.getElementById("discountRate");
            var discountRate = parseFloat(discountRateInput.value);

            var errorMessageElement = document.getElementById("error-message");
            if (isNaN(discountRate) || discountRate < 0 || discountRate > 100) {
                errorMessageElement.innerHTML = "Please enter a valid discount rate between 0 and 100.";
                return false;
            } else {
                errorMessageElement.innerHTML = ""; // Clear error message
            }
            return true;
        }

        function allowOnlyNumeric(event) {
            // Allow only numeric input
            var charCode = (event.which) ? event.which : event.keyCode;
            if (charCode > 31 && (charCode < 48 || charCode > 57)) {
                event.preventDefault();
            }
        }
    </script>
</head>
<body>
    <a href="javascript:history.back()">Back to Listing</a>
    <h2>Set Item to Sale </h2>
    <div class="wrapper wrapper-content">
        <div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-content">
                        <table border="2">
                            <thead>
                                <tr>
                                    <th>Field</th>
                                    <th>Value</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>Item ID</td>
                                    <td>${item.itemId}</td>
                                </tr>
                                <tr>
                                    <td>Item Name</td>
                                    <td>${item.itemName}</td>
                                </tr>
                                <tr>
                                    <td>Unit</td>
                                    <td>${item.unit}</td>
                                </tr>
                                <tr>
                                    <td>Location</td>
                                    <td>${item.location}</td>
                                </tr>
                                <tr>
                                    <td>Create Date</td>
                                    <td>${item.createDate}</td>
                                </tr>
                                <tr>
                                    <td>User</td>
                                    <td>${item.userName}</td>
                                </tr>
                                <tr>
                                    <td>Item Type</td>
                                    <td>${item.itemType}</td>
                                </tr>
                                <tr>
                                    <td>Quantity</td>
                                    <td>${item.quantity}</td>
                                </tr>
                                <tr>
                                    <td>Expiry Date</td>
                                    <td>${item.expirDate}</td>
                                </tr>
                                <tr>
                                    <td>Price</td>
                                    <td>${item.price}</td>
                                </tr>
                                <tr>
                                    <td>Status</td>
                                    <td>${item.status}</td>
                                </tr>
                                <tr>
                                    <td>Status Date</td>
                                    <td>${item.statusDate}</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>      
                </div>
            </div>

        </div>

        <form method="post" onsubmit="return validateDiscount()">
        <label for="discountRate">Discount Rate:</label>
        <input type="text" id="discountRate" name="discountRate" placeholder="e.g., 0.9, 0.65" required onkeypress="allowOnlyNumeric(event)">
        <span id="error-message" class="error-message"></span><br><br>
            <input type="submit" name="action" value="Set to sale ">
        </form>
    </div>
    <!-- Include JavaScript files if needed -->
    <script>
        function convertPercentage() {
            var discountInput = document.getElementById("discountRate");
            var discountValue = discountInput.value.trim();
            if (discountValue.slice(-1) !== "%") {
                // If percentage sign is missing, add it
                discountValue += "%";
                discountInput.value = discountValue;
            }
            // Convert percentage to decimal before form submission
            var decimalValue = parseFloat(discountValue) / 100;
            discountInput.value = decimalValue.toFixed(2); // Keeping it to two decimal places
        }
    </script>

</body>
</html>

