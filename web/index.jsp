
<%--
  Created by Netbean
  User: hanzg
  Date: 2024/4/01
  Time: 20:54
  To change this use File | Settings | File Templates.
--%>
<%@page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">
    <title>Demeter FWRP</title>
     <!-- Include Bootstrap CSS -->
    <jsp:include page="${ctx}/resources/layout/_css.jsp"/>
    <jsp:include page="/resources/layout/_script.jsp"/>

<script>
$(document).ready(function() {
    // Function to handle tab clicks
    function handleTabClick(tab) {
        var url = tab.attr("data-id"); // Get the URL from data-id attribute
        var title = tab.text(); // Get the title from link text
        
        // Load the content of the clicked link into the iframe
        $("iframe.J_iframe").attr("src", url);
        
        // Update the title of the page
        $(".navbar-brand").text(title);
        
        // Highlight the active tab
        $(".J_menuTab").removeClass("active"); // Remove active class from all tabs
        tab.addClass("active"); // Add active class to the clicked tab
    }

    // Add click event listener to all J_menuTab links except for Home tab
    $(".J_menuTab:not([data-id='${ctx}/home/'])").on("click", function(e) {
        e.preventDefault(); // Prevent default behavior
        handleTabClick($(this)); // Handle the tab click
    });

    // Handle click for Home tab separately
    $(".J_menuTab[data-id='${ctx}/home/']").on("click", function(e) {
        // Prevent default behavior
        e.preventDefault();
        // Highlight the active tab
        $(".J_menuTab").removeClass("active");
        $(this).addClass("active");
        // Update the title of the page
        $(".navbar-brand").text($(this).text());
    });

    // Restore the active tab when the page loads
    var activeTab = $(".J_menuTab.active");
    handleTabClick(activeTab);
});
</script>

</head>

<body class="fixed-sidebar full-height-layout gray-bg" style="overflow:hidden">
<div id="wrapper">
<!--Left navigation-->
     <!-- Left navigation -->
        <nav class="navbar-default navbar-static-side" role="navigation">
            <div class="nav-close"><i class="fa fa-times-circle"></i></div>
            <div class="sidebar-collapse">
                <ul class="nav" id="side-menu">
                    <li class="nav-header">
                        <div class="dropdown profile-element">
                            <span><img alt="image" class="img-circle" src="${ctx}/resources/img/user/profile_small.jpg" /></span>
                        </div>
                        <div class="logo-element">H+</div>
                    </li>

                    <li>
                        <a href="#">
                            <i class="fa fa-user"></i>
                            <span class="nav-label">User</span>
                            <span class="fa arrow"></span>
                        </a>
                        <ul class="nav nav-second-level">
                            <!--  <li><a class="J_menuItem" href="${ctx}/auth/login">Login</a></li> -->
                              <li><a class="J_menuItem" href="${ctx}/auth/profile" >Profile</a></li>

                            <li><a class="J_menuItem" href="${ctx}/auth/register">Register</a></li> 
                            <li><a class="J_menuItem" href="${ctx}/user/">User Lists</a></li> 
                        </ul>
                    </li>

                    <li>
                        <a href="#">
                            <i class="fa fa-home"></i>
                            <span class="nav-label">Items   </span>
                            <span class="fa arrow"></span>
                        </a>
                        <ul class="nav nav-second-level">
                            <!-- Add target="_blank" to open links in new tab -->
                    <!---  <li><a class="J_menuItem" href="${ctx}/inventory/">Inventory</a></li>
                            <li><a class="J_menuItem" href="${ctx}/surplus/">Listing </a></li>
                            <li><a class="J_menuItem" href="${ctx}/sale/">On Sale</a></li>
                            <li><a class="J_menuItem" href="${ctx}/order/">My Orders</a></li>
                            <li><a class="J_menuItem" href="${ctx}/donation/">On Donation</a></li>
                            <li><a class="J_menuItem" href="${ctx}/claim/">My Claims</a></li>
                            <li><a class="J_menuItem" href="${ctx}/subs/">Subscription</a></li> -->
                            <c:if test="${not empty sessionScope.userRoleFunction 
                                          and not empty sessionScope.userRoleFunction.functionURLs 
                                          and fn:length(sessionScope.userRoleFunction.functionURLs) > 0}">
                                <c:forEach var="item" items="${sessionScope.userRoleFunction.functionURLs}">
                                    <li>
                                        <a class="J_menuItem" href="${ctx}/<c:out value="${item.sysFunctionUrl }" />/" target="_blank" data-index="0"><c:out value="${item.funcName }" /></a>
                                    </li>
                                </c:forEach>
                            </c:if>
                        </ul>
                    </li>
                </ul>
            </div>
        </nav>

<!--End of left navigation-->
     <!--Start the right part-->
     <div id="page-wrapper" class="gray-bg dashbard-1">
        <div class="row border-bottom">
            <nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
                <div class="navbar-header"><a class="navbar-minimalize minimalize-styl-2 btn btn-primary " href="#"><i class="fa fa-bars"></i> </a>
                </div>

                <ul class="nav navbar-top-links navbar-right">
                    <li class="dropdown hidden-xs">
                        <a class="right-sidebar-toggle" aria-expanded="false">
                            <i class="fa fa-tasks"></i> Topics & Rankings
                        </a>
                    </li>
                </ul>
            </nav>
        </div>
                
        <div class="row content-tabs">
            <button class="roll-nav roll-left J_tabLeft"><i class="fa fa-backward"></i>
            </button>

          <nav class="page-tabs J_menuTabs">
                <div class="page-tabs-content">
                   <a href="javascript:;" class="active J_menuTab" data-id="${ctx}/home/">Home</a>

                </div>
            </nav>

            <button class="roll-nav roll-right J_tabRight"><i class="fa fa-forward"></i>
            </button>

            <div class="btn-group roll-nav roll-right">
                <button class="dropdown J_tabClose" data-toggle="dropdown">Close<span class="caret"></span>

                </button>
                <ul role="menu" class="dropdown-menu dropdown-menu-right">
                    <li class="J_tabShowActive"><a>Locate the current tab</a>
                    </li>
                    <li class="divider"></li>
                    <li class="J_tabCloseAll"><a>Close all tabs</a>
                    </li>
                    <li class="J_tabCloseOther"><a>Close other tabs</a>
                    </li>
                </ul>
            </div>
                 <c:choose>
                        <c:when test="${not empty sessionScope.userRoleFunction}">
                            <a href="${ctx}/auth/logout" class="roll-nav roll-right J_tabExit"><i class="fa fa fa-sign-out"></i> Exit</a>
                        </c:when>
                        <c:otherwise>
                            <a href="${ctx}/auth/login" class="roll-nav roll-right J_tabExit"><i class="fa fa fa-sign-out"></i> Login</a>
                        </c:otherwise>
                </c:choose>
        </div>
        <div class="row J_mainContent" id="content-main">
                <iframe class="J_iframe" name="iframe0" width="100%" height="100%" src="${ctx}home/" frameborder="0" data-id="${ctx}inventory/" seamless>
                </iframe>
         </div>
    <div class="footer" style="text-align: center; color: gray;">
            <div  >    © 2024 <a href="" target="_blank">"www Demeter.com"</a></div>
    </div>
    </div>
<!--End of the right part-->
     <!--Start right sidebar-->
    <div id="right-sidebar">
        <div class="sidebar-container">

            <ul class="nav nav-tabs navs-3">

                <li class="active">
                    <a data-toggle="tab" href="#tab-1">
                        <i class="fa fa-gear"></i> theme
                    </a>
                </li>
                <li class="">
                    <a data-toggle="tab" href="#tab-2">
                       Claimed rankings
                    </a>
                </li>
                <li>
                    <a data-toggle="tab" href="#tab-3">
                        Purchased ranking
                    </a>
                </li>
            </ul>

            <div class="tab-content">
                <div id="tab-1" class="tab-pane active">
                    <div class="sidebar-title">
                        <h3> <i class="fa fa-comments-o"></i>Theme Settings</h3>
                        <small><i class="fa fa-tim"></i> ou can select and preview the layout and style of the theme from here. These settings will be saved locally and will be applied directly the next time you open it.</small>
                    </div>
                    <div class="skin-setttings">
                        <div class="title">Theme settings</div>
                        <div class="setings-item">
                            <span>Collapse left menu</span>
                            <div class="switch">
                                <div class="onoffswitch">
                                    <input type="checkbox" name="collapsemenu" class="onoffswitch-checkbox" id="collapsemenu">
                                    <label class="onoffswitch-label" for="collapsemenu">
                                        <span class="onoffswitch-inner"></span>
                                        <span class="onoffswitch-switch"></span>
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="setings-item">
                            <span>Fixed top</span>

                            <div class="switch">
                                <div class="onoffswitch">
                                    <input type="checkbox" name="fixednavbar" class="onoffswitch-checkbox" id="fixednavbar">
                                    <label class="onoffswitch-label" for="fixednavbar">
                                        <span class="onoffswitch-inner"></span>
                                        <span class="onoffswitch-switch"></span>
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="setings-item">
                                <span>
                 fixed width
                    </span>
                            <div class="switch">
                                <div class="onoffswitch">
                                    <input type="checkbox" name="boxedlayout" class="onoffswitch-checkbox" id="boxedlayout">
                                    <label class="onoffswitch-label" for="boxedlayout">
                                        <span class="onoffswitch-inner"></span>
                                        <span class="onoffswitch-switch"></span>
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="title">Skin selection</div>
                        <div class="setings-item default-skin nb">
                                <span class="skin-name ">
                         <a href="#" class="s-skin-0">
                           Default skin
                         </a>
                    </span>
                        </div>
                        <div class="setings-item blue-skin nb">
                                <span class="skin-name ">
                        <a href="#" class="s-skin-1">
                         blue theme
                        </a>
                    </span>
                        </div>
                        <div class="setings-item yellow-skin nb">
                                <span class="skin-name ">
                        <a href="#" class="s-skin-3">
                          yellow/purple theme
                        </a>
                    </span>
                        </div>
                    </div>
                </div>
                <div id="tab-2" class="tab-pane">
                     <h5>Ranking Claimed by Charity Organizations</h5>
                     <ol>
                         <li>Apples - 100 units claimed</li>
                         <li>Oranges - 80 units claimed</li>
                         <li>Bananas - 70 units claimed</li>
                         <li>Carrots - 60 units claimed</li>
                         <li>Broccoli - 50 units claimed</li>
                         <li>Cucumbers - 40 units claimed</li>
                         <li>Potatoes - 30 units claimed</li>
                         <li>Tomatoes - 20 units claimed</li>
                         <!-- Add more ranking items as needed -->
                     </ol>
                 </div>
                 <div id="tab-3" class="tab-pane">
                     <%-- Adding ranking for the food items purchased by consumers --%>
                     <h5>Ranking Purchased by Consumers</h5>
                     <ol>
                         <li>Strawberries - 200 units purchased</li>
                         <li>Blueberries - 180 units purchased</li>
                         <li>Grapes - 150 units purchased</li>
                         <li>Lettuce - 130 units purchased</li>
                         <li>Spinach - 120 units purchased</li>
                         <li>Peppers - 100 units purchased</li>
                         <li>Cabbage - 80 units purchased</li>
                         <li>Mushrooms - 60 units purchased</li>
                         <!-- Add more ranking items as needed -->
                     </ol>
                 </div>
            </div>
        </div>
    </div>
<!--End of right sidebar-->
</div>


</body>

</html>
