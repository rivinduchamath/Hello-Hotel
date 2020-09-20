<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="../../onlineRestaurant/restaurant/css/reset.css" type="text/css" media="all">
    <link rel="stylesheet" href="../../onlineRestaurant/restaurant/css/layout.css" type="text/css" media="all">
    <link rel="stylesheet" href="../../onlineRestaurant/restaurant/css/style.css" type="text/css" media="all">
    <link rel="stylesheet" href="../../onlineRestaurant/restaurant/css/zerogrid.css" type="text/css" media="all">
    <link rel="stylesheet" href="../../onlineRestaurant/restaurant/css/responsive.css" type="text/css" media="all">
    <script type="text/javascript" src="../../onlineRestaurant/restaurant/js/jquery-1.6.js"></script>
    <script type="text/javascript" src="../../onlineRestaurant/restaurant/js/cufon-yui.js"></script>
    <script type="text/javascript" src="../../onlineRestaurant/restaurant/js/cufon-replace.js"></script>
    <script type="text/javascript" src="../../onlineRestaurant/restaurant/js/Forum_400.font.js"></script>
    <script type="text/javascript" src="../../onlineRestaurant/restaurant/js/atooltip.jquery.js"></script>
    <script type="text/javascript" src="../../onlineRestaurant/restaurant/js/css3-mediaqueries.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script type="text/javascript" src="../../onlineRestaurant/restaurant/js/html5.js"></script>
    <style type="text/css">
        .slider_bg {
            behavior: url(../../onlineRestaurant/restaurant/js/PIE.htc)
        }
    </style>

    <!--[if lt IE 7]>
    <div style='clear:both;text-align:center;position:relative'>
        <a href="http://www.microsoft.com/windows/internet-explorer/default.aspx?ocid=ie6_countdown_bannercode"><img
                src="http://storage.ie6countdown.com/assets/100/images/banners/warning_bar_0000_us.jpg" border="0"
                alt=""/></a>
    </div>
    <![endif]-->
</head>
<body id="page2">
<div class="body6">
    <div class="body1">
        <div class="main zerogrid">
            <!-- header -->
            <header>
                <h1><a href="onlineDashboard" style="position: relative;left: -50px;top: -30px" id="logo"><img
                        src="../../onlineRestaurant/restaurant/images/logo.png"/></a></h1>
                <nav>
                    <ul id="top_nav">
                        <li><a href="onlineDashboard"><img src="../../onlineRestaurant/restaurant/images/icon_1.gif"
                                                           alt=""></a></li>
                        <li><a href="#"><img src="../../onlineRestaurant/restaurant/images/icon_2.gif" alt=""></a></li>
                        <li class="end"><a href="onlineCustomer"><i class="fa fa-user"
                                                                    style="color: rgba(255,255,255,0.91); font-size:20px;">
                            LogIn</i></a></li>
                    </ul>
                </nav>
                <nav>
                    <ul id="menu">
                        <li><a href="onlineDashboard">Dashboard</a></li>
                        <li><a href="onlineOrder">Order</a></li>
                        <li class="active"><a href="onlineTable">Table</a></li>
                        <li><a href="#">About Us</a></li>
                        <li><a href="onlineContact">Contacts</a></li>
                    </ul>
                </nav>
            </header>
            <!-- / header -->
            <!-- content -->
            <article id="content">
                <div class="wrap">
                    <section class="col-1-3">
                        <div class="wrap-col">
                            <div class="box">
                                <div>
                                    <h2>Did You <span>Know</span></h2>
                                    <figure><img src="../../onlineRestaurant/restaurant/images/page2_img1.jpg" alt="">
                                    </figure>
                                    <p class="pad_bot1">Neque porro quisquam est, qui dolor- em ipsum qudolor sitamet
                                        consectetur adipisci velit, sed quia non numquam eius modi tempora incidunt.</p>
                                    <a href="#" class="button1">Read More</a>
                                </div>
                            </div>
                        </div>
                    </section>
                    <section class="col-1-3">
                        <div class="wrap-col">
                            <div class="box">
                                <div>
                                    <h2 class="letter_spacing">Types<span> of Cuisine</span></h2>
                                    <ul class="list1 pad_bot1">
                                        <li><a href="#">Lorem ipsum dolor sit amet</a></li>
                                        <li><a href="#">Consectetur adipisicing elit sed</a></li>
                                        <li><a href="#">Eiusmod tempor incididunt labore</a></li>
                                        <li><a href="#">Ut enim ad minim veniam</a></li>
                                        <li><a href="#">Quis nostrud exercation ullamco </a></li>
                                        <li><a href="#">Laboris nisi ut aliquip</a></li>
                                        <li><a href="#">Commodo consequat aute </a></li>
                                        <li><a href="#">Irure dolor in reprehenderit</a></li>
                                        <li><a href="#">Voluptate velit esse cillum dolore</a></li>
                                    </ul>
                                    <a href="#" class="button1">Proposal for You</a>
                                </div>
                            </div>
                        </div>
                    </section>
                    <section class="col-1-3">
                        <div class="wrap-col">
                            <div class="box">
                                <div>
                                    <h2>Dish <span>of the Day</span></h2>
                                    <figure><img src="../../onlineRestaurant/restaurant/images/page2_img2.jpg" alt="">
                                    </figure>
                                    <p class="pad_bot1">At vero eos et accusamus et iusto odio dignissimos ducimus qui
                                        blanditiis praesentium voluptatum deleniti atque corrupti quos.</p>
                                    <a href="#" class="button1">Read More</a>
                                </div>
                            </div>
                        </div>
                    </section>
                </div>
            </article>
        </div>
    </div>
</div>
<div class="body2">
    <div class="main zerogrid">
        <article id="content2">
            <div class="wrapper">
                <section>
                    <h2>Available Tables</h2>
                    <h5>Please Select </h5>
                    <div class="wrapper">

                        <button href="#" class="col-1-1 button1x1" id="submitButton"> Submit</button>
                        <br>
                        <table id="reservationTable">

                            <tbody>
                            <c:forEach items="${loadAllTables}" var="e">
                                <tr>
                                    <div class="col-1-4">
                                        <div class="wrap-col">
                                            <div class="wrapper pad_bot1" id="#0001">
                                                <figure style="   width: 140px;height: 140px;" class="pad_bot1"><img
                                                        src="../../onlineRestaurant/restaurant/images/pngwave.png"
                                                        alt=""></figure>

                                                <h5 onclick="myFunction(${e.tableId})" style=""><span id="selectedTableId" style="font-size: 20px">${e.tableId} </span><a
                                                        class="button1x">+</a></h5>
                                            </div>
                                        </div>
                                    </div>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </section>
            </div>
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
                <section class="col-2-3">
                    <div class="wrap-col">
                        <h3>Hot-line: <span>+94 778 7999 40</span></h3>
                        Designed by <a rel="nofollow" href="" target="_blank">Team Reliance</a> | <a
                            href="https://github.com/rivinduchamath/Hello-Hotel" title="free website templates">Project
                        ITP</a>
                    </div>
                </section>
                <section class="col-1-3">
                    <div class="wrap-col">
                        <h3>Follow Us </h3>
                        <ul id="icons">
                            <li><a href="#" class="normaltip" title="Facebook"><img
                                    src="../../onlineRestaurant/restaurant/images/icon1.gif" alt=""></a></li>
                            <li><a href="#" class="normaltip" title="Linkedin"><img
                                    src="../../onlineRestaurant/restaurant/images/icon2.gif" alt=""></a></li>
                            <li><a href="#" class="normaltip" title="Twitter"><img
                                    src="../../onlineRestaurant/restaurant/images/icon3.gif" alt=""></a></li>
                            <li><a href="#" class="normaltip" title="Delicious"><img
                                    src="../../onlineRestaurant/restaurant/images/icon4.gif" alt=""></a></li>
                            <li><a href="#" class="normaltip" title="Technorati"><img
                                    src="../../onlineRestaurant/restaurant/images/icon5.gif" alt=""></a></li>
                        </ul>
                    </div>
                </section>
            </div>
            <!-- {%FOOTER_LINK} -->
        </footer>
        <!-- / footer -->
    </div>

</div>
<script type="text/javascript"> Cufon.now(); </script>
<script src="../../vendors/jquery/dist/jquery.min.js"></script>
<script>
    $(window).scroll(function () {
        if ($(document).scrollTop() > 224) {
            $(".button1x1").show();
        } else {
            $(".button1x1").hide();
        }
    });
</script>
<script>
    var selectedRow = null;
    function myFunction(x) {
        selectedRow = $(this)


    }

</script>



<script src="../../js/addOnlineTable.js"></script>
</body>
</html>