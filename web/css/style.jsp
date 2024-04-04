<%-- 
    Document   : style.jsp
    Created on : Mar 24, 2024, 11:48:37 PM
    Author     : hanzg
--%>

<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%-- CSS styles for the entire application --%>

<%
    // Define variables for colors or other dynamic properties
    String primaryColor = "#c0e6e6"; // Light blue-green color
    String secondaryColor = "#0077b3"; // Darker blue-green color
%>


<!-- Rest of your CSS styles -->
/* Resetting default margin and padding for better consistency */
body, h1, h2, h3, p, ul, ol {
    margin: 0;
    padding: 0;
}

/* Global styles */
body {
    font-family: Arial, sans-serif;
    background-color: #f4f4f4;
}

.container {
    max-width: 1200px;
    margin: 0 auto;
    padding: 20px;
}

/* Header styles */
.header {
    background-color: #fff;
    border-bottom: 1px solid #ddd;
    padding: 20px 0;
}

/* Navigation styles */
.navbar {
    background-color: #933;
    padding: 10px 0;
}

/* Footer styles */
.footer {
    background-color: #533;
    color: #fff;
    padding: 20px 0;
    text-align: center;
}

/* Sidebar styles */
.sidebar {
    background-color:#833;
    width: 250px;
    padding: 20px;
    float: left;
    height: 100%;
}

/* Main content styles */
.main-content {
    padding: 20px;
    overflow: hidden;
}

/* IFrame styles */
iframe {
    width: calc(100% - 300px);
    height: 500px;
    border: none;
    background-image: url('../images/bg.jpg'); /* Adjust the path */
    background-size: cover;
    background-position: center;
}


