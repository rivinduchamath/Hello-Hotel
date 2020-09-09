
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Restaurant</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="../../onlineRestaurant/restaurant/css/reset.css" type="text/css" media="all">
    <link rel="stylesheet" href="../../onlineRestaurant/restaurant/css/layout.css" type="text/css" media="all">
    <link rel="stylesheet" href="../../onlineRestaurant/restaurant/css/style.css" type="text/css" media="all">
    <link rel="stylesheet" href="../../onlineRestaurant/restaurant/css/zerogrid.css" type="text/css" media="all">
    <link rel="stylesheet" href="../../onlineRestaurant/restaurant/css/responsive.css" type="text/css" media="all">
    <link rel="stylesheet" href="../../onlineRestaurant/restaurant/css/contactform.css" type="text/css" media="all">
    <script type="text/javascript" src="../../onlineRestaurant/restaurant/js/jquery-1.6.js" ></script>
    <script type="text/javascript" src="../../onlineRestaurant/restaurant/js/cufon-yui.js"></script>
    <script type="text/javascript" src="../../onlineRestaurant/restaurant/js/cufon-replace.js"></script>
    <script type="text/javascript" src="../../onlineRestaurant/restaurant/js/Forum_400.font.js"></script>
    <script type="text/javascript" src="../../onlineRestaurant/restaurant/js/atooltip.jquery.js"></script>
    <script type="text/javascript" src="../../onlineRestaurant/restaurant/js/css3-mediaqueries.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script type="text/javascript" src="../../onlineRestaurant/restaurant/js/html5.js"></script>
    <style type="text/css">
        .slider_bg {behavior:url(../../onlineRestaurant/restaurant/js/PIE.htc)}
    </style>
    <![endif]-->
    <!--[if lt IE 7]>
    <div style='clear:both;text-align:center;position:relative'>
        <a href="http://www.microsoft.com/windows/internet-explorer/default.aspx?ocid=ie6_countdown_bannercode"><img src="http://storage.ie6countdown.com/assets/100/images/banners/warning_bar_0000_us.jpg" border="0" alt="" /></a>
    </div>
    <![endif]-->
</head>
<body id="page5">
<div class="body6">
    <div class="body1">
        <div class="main zerogrid">
            <!-- header -->
            <header>
                <h1><a href="/onlineDashboard" style="position: relative;left: -50px;top: -30px"id="logo"><img src="../../onlineRestaurant/restaurant/images/logo.png"/></a></h1>
                <nav>
                    <ul id="top_nav">
                        <li><a href="onlineDashboard"><img src="../../onlineRestaurant/restaurant/images/icon_1.gif" alt=""></a></li>
                        <li><a href="#"><img src="../../onlineRestaurant/restaurant/images/icon_2.gif" alt=""></a></li>
                        <li class="end"><a href="onlineCustomer"><i class="fa fa-user" style="color: rgba(255,255,255,0.91); font-size:20px;"> LogIn ${loggerId.name}</i></a></li>
                    </ul>
                </nav>
                <nav>
                    <ul id="menu">
                        <li class=""><a href="onlineDashboard">Dashboard</a></li>
                        <li><a href="onlineOrder">Order</a></li>
                        <li class="active"><a href="onlineTable">Table</a></li>
                        <li><a href="#">About Us</a></li>
                        <li ><a href="onlineContact">Contacts</a></li>
                    </ul>
                </nav>
            </header>
            <!-- / header -->
            <!-- content -->
            <article id="content">
                <div class="wrap">
                    <div class="box">
                        <div>
                            <h2 class="letter_spacing">Table <span> Reservation</span></h2>

                            <div id="contact_form">
                                <strong>Hello !! You can Check Available Tables.</strong>
                                <form name="form1" id="ff" action="checkTimeForTable">
                                    <label>
                                        Date:
                                        <input type="date" placeholder="Booking Date" name="date" id="name" required>
                                    </label>

                                    <label>
                                        Time In:
                                        <input type="time" placeholder="In Time" name="startTime" id="email" required>
                                    </label>

                                    <label>
                                        Time Out:
                                        <input type="time" placeholder="Out Time" name="endTime" id="message">                                    </label>

                                    <input class="sendButton" type="submit" name="Submit" value="Check">

                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </article>
        </div>
    </div>
</div>
<div class="body2">
    <div class="main zerogrid">
        <article id="content2">
            <section>
                <div class="wrapper">
                    <div class="col-1-3"><div class="wrap-col">
                        <h2>Our Contacts</h2>
                        <div class="wrapper pad_bot1">
                            <p>Sed ut perspiciatis unde omnis iunatus doloremque laudantium.</p>
                            <p class="address">
                                Marmora Road, Glasgow, D04 89GR.<br>
                                <span>Freephone:</span>   +94 778 7999 40<br>
                                <span>Telephone:</span>    +94 778 7999 405<br>
                                <span>E-mail:</span>             <a href="">npminside@gmail.com</a>
                            </p>
                        </div>
                    </div></div>
                    <div class="col-2-3"><div class="wrap-col mag-1">
                        <h2>Miscellaneous Info</h2>
                        <p>
                            Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
                        </p>
                        Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum. Sed ut perspiciatis unde omnis iste natus error.
                    </div></div>
                </div>
            </section>
        </article>
        <!-- / content -->
    </div>
</div>
<div class="body3">

    <div class="main zerogrid">
        <!-- footer -->
        <!-- footer -->
        <footer>
            <div class="wrapper">
                <section class="col-2-3"><div class="wrap-col">
                    <h3>Hot-line: <span>+94 778 7999 40</span></h3>
                    Designed by <a rel="nofollow" href="" target="_blank">Team Reliance</a> | <a href="https://github.com/rivinduchamath/Hello-Hotel" title="free website templates">Project ITP</a>
                </div></section>
                <section class="col-1-3"><div class="wrap-col">
                    <h3>Follow Us </h3>
                    <ul id="icons">
                        <li><a href="#" class="normaltip" title="Facebook"><img src="../../onlineRestaurant/restaurant/images/icon1.gif" alt=""></a></li>
                        <li><a href="#" class="normaltip" title="Linkedin"><img src="../../onlineRestaurant/restaurant/images/icon2.gif" alt=""></a></li>
                        <li><a href="#" class="normaltip" title="Twitter"><img src="../../onlineRestaurant/restaurant/images/icon3.gif" alt=""></a></li>
                        <li><a href="#" class="normaltip" title="Delicious"><img src="../../onlineRestaurant/restaurant/images/icon4.gif" alt=""></a></li>
                        <li><a href="#" class="normaltip" title="Technorati"><img src="../../onlineRestaurant/restaurant/images/icon5.gif" alt=""></a></li>
                    </ul>
                </div></section>
            </div>
            <!-- {%FOOTER_LINK} -->
        </footer>
        <!-- / footer -->
    </div>

</div>
<script type="text/javascript"> Cufon.now(); </script>
</body>
</html>