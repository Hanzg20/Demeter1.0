<%-- 
    Document   : home.jsp
    Created on : Apr 5, 2024, 11:50:30 PM
    Author     : Youjun Qin
--%>

<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Food Waste Reduction Platform</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha2/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <!-- Custom CSS -->
    <link rel="stylesheet" href="${ctx}/resources/css/style.css"> 
    <style>
        .flashing-banner {
            width: 100%;
            height: 200px;
            overflow: hidden;
            position: relative;
            white-space: nowrap;
        }
        .flashing-banner img {
            width: 100%;
            height: 100%;
            display: inline-block;
            animation: bannerAnimation 18s infinite;
        }
        @keyframes bannerAnimation {
            0% {
                transform: translateX(0%);
            }
            20% {
                transform: translateX(-100%);
            }
            40% {
                transform: translateX(-200%);
            }
            60% {
                transform: translateX(-300%);
            }
            80% {
                transform: translateX(-400%);
            }
            100% {
                transform: translateX(-500%);
            }
        }
    </style>
</head>
<body>

<!-- Flashing Banner -->
<div class="flashing-banner">
    <img src="${ctx}/resources/img/grain1920200.gif" alt="Grain">
    <img src="${ctx}/resources/img/corn1920200.jpg" alt="Corn">
    <img src="${ctx}/resources/img/patato1920200.jpg" alt="Potato">
    <img src="${ctx}/resources/img/rice1920200.jpg" alt="Rice">
    <img src="${ctx}/resources/img/hunger1920200.jpg" alt="Hunger">
    <img src="${ctx}/resources/img/planet1920200.jpg" alt="Planet">
</div>

<!-- Main Picture with Buttons -->
<section class="hero bg-cover bg-center py-5" style="background-image: url('${ctx}/resources/img/breadfood.jpg'); position: relative;">
    <div class="container py-5 text-center">
        <h1 class="display-4 text-white mb-4" style="background-color: rgba(0, 100, 0, 0.5); padding: 10px;">Reduce Food Waste. <span style="color: yellow;">Feed the World.</span></h1>
        <p class="lead text-white mb-4" style="background-color: rgba(0, 100, 0, 0.6); padding: 10px;">Join us in our mission to create a sustainable future by connecting farmers, consumers, and charity organizations.</p>
        <a href="#about" class="btn btn-primary btn-lg mt-3" style="position: absolute; bottom: 20px; right: 20px;">Learn More</a>
    </div>
    <div style="position: absolute; bottom: 20px; center: 20px;">
        <a href="#login" class="btn btn-primary mx-2">Login</a>
        <a href="#subscription" class="btn btn-primary mx-2">Subscription</a>
    </div>
</section>


<!-- Navbar -->
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container">
    <a class="navbar-brand" href="#">
      <img src="${ctx}/resources/img/demeter1.png" alt="Food Waste Reduction Platform" width="206">
    </a>
    <div class="d-flex">
        <a href="#login" class="btn btn-primary mx-2">Login</a>
        <a href="#subscription" class="btn btn-primary mx-2">Subscription</a>
    </div
  </div>
</nav>

<!-- About Section -->
<section id="about" class="py-5">
  <div class="container">
    <div class="row">
      <div class="col-lg-6">
        <h2 class="display-4 mb-4">About Us</h2>
        <p class="lead">At the Food Waste Reduction Platform, we believe in utilizing technology to tackle one of the most pressing issues of our time: food waste.</p>
        <p>We connect food retailers with surplus food to consumers and charitable organizations, ensuring that no edible food goes to waste.</p>
      </div>
      <div class="col-lg-6">
        <img src="${ctx}/resources/img/feedhungry800.jpg" alt="About Us" class="img-fluid rounded">
      </div>
    </div>
  </div>
</section>

<!-- Bootstrap Bundle with Popper -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha2/js/bootstrap.min.js"></script>
</body>
</html>