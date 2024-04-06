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
<!-- About Section -->
<section id="about" class="py-5">
  <div class="container">
    <div class="row">
      <div class="col-lg-6">
        <h2 class="display-4 mb-4">About Food Waste Reduction Platform</h2>
        <p class="lead">At our Food Waste Reduction Platform, you can join us to reduce food waste together .</p>
    <p>As a food retailer, we will try out best to avoid of wasting surplus food. We use this platform to connect farmers,consumers and charity organizations to ensure that no edible food goes to waste.</p>
  
          <ul>
    <li>
        <img src="${ctx}/resources/img/farmer100icon.png" alt="Farmer Icon" style="width: 20px; height: 20px;">
        <strong>For farmer, food supplier:</strong> 
        Please register at our platform and donate your surplus food to support our Canadian, to save our planet.
    </li><br>
    <li>
        <img src="${ctx}/resources/img/consumer100.png" alt="Consumer Icon" style="width: 20px; height: 20px;">
        <strong>For consumer:</strong> 
        After you're registered as our member, we encourage you to do subscription. We will send you the list of surplus food from time to time. We will offer big discounts.
    </li><br>
    <li>
        <img src="${ctx}/resources/img/charity100icon.png" alt="Charity Icon" style="width: 20px; height: 20px;">
        <strong>For charity organizations:</strong> 
        Please register your role as charity, and click subscription. You can make a claim for donation food according to the surplus food list.
    </li><br>
</ul>
         
        <h3 class="mt-5" style="background-color: rgba(0, 100, 0, 0);">The Hungry People and Wasted Food in Canada:</h3>
       <h4>
    <ul>
        <li><strong>Finding 1:</strong> In March 2023, there were over 1.9 million visits to food banks in Canada, which set a record at the time.</li><br>
        <li><strong>Finding 2:</strong> This year’s food bank usage represents a 78.5 per cent increase compared to March 2019.</li><br>
        <li><strong>Finding 3:</strong> One-third of food bank clients are children.</li><br>
        <li><strong>Finding 4:</strong> Canadian Statistics: Canadians create over 50 million tonnes of food waste every year. </li><br>
        <li><strong>Finding 5:</strong> UN Food Waste Index: from 2021, the average Canadian household wastes 79 kilograms of food every year. </li><br>
        <li><strong>Finding 6:</strong> National Zero Waste Council: in 2022, the amount of food wasted by the average household in Canada is 140 kilograms. Wasting this much food costs households over $1,300 per year. </li>
    </ul>
    


    
       </h4>

      </div>
      <div class="col-lg-6">
        <img src="${ctx}/resources/img/feedhungry800.jpg" alt="FeedHungryChildren" class="img-fluid rounded">
        <img src="${ctx}/resources/img/donationbox600.jpg" alt="FeedHungryChildren" class="img-fluid rounded">
      </div>
    </div>
  </div>
</section>
      
<!-- Footer-->
<footer class="bg-dark text-white py-4">
    <div class="container text-center">
        <p>&copy; 2024 Food Waste Reduction Platform. All rights reserved by XXX store.</p>
        <div class="social-icons mt-3"> <!-- Added mt-3 class for top margin -->
            <a href="#" class="text-white me-3 mr-3"><i class="fab fa-facebook-f"></i></a> <!-- Added mr-3 class for right margin -->
            <a href="#" class="text-white me-3 mr-3"><i class="fab fa-twitter"></i></a> <!-- Added mr-3 class for right margin -->
            <a href="#" class="text-white"><i class="fab fa-instagram"></i></a>
        </div>
    </div>
</footer>

<!-- Bootstrap Bundle with Popper -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha2/js/bootstrap.min.js"></script>
</body>
</html>