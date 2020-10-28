
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
    <link rel="stylesheet" href="../../onlineRestaurant/restaurant/css/responsiveslides.css" />
    <script type="text/javascript" src="../../onlineRestaurant/restaurant/js/jquery-1.6.js" ></script>
    <script type="text/javascript" src="../../onlineRestaurant/restaurant/js/cufon-yui.js"></script>
    <script type="text/javascript" src="../../onlineRestaurant/restaurant/js/cufon-replace.js"></script>
    <script type="text/javascript" src="../../onlineRestaurant/restaurant/js/Forum_400.font.js"></script>
    <script type="text/javascript" src="../../onlineRestaurant/restaurant/js/jquery.easing.1.3.js"></script>
    <script type="text/javascript" src="../../onlineRestaurant/restaurant/js/tms-0.3.js"></script>
    <script type="text/javascript" src="../../onlineRestaurant/restaurant/js/tms_presets.js"></script>
    <script type="text/javascript" src="../../onlineRestaurant/restaurant/js/script.js"></script>
    <script type="text/javascript" src="../../onlineRestaurant/restaurant/js/atooltip.jquery.js"></script>
    <script type="text/javascript" src="../../onlineRestaurant/restaurant/js/css3-mediaqueries.js"></script>
    <script src="../../onlineRestaurant/restaurant/js/responsiveslides.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script>
        // Check browser support
        if (typeof(Storage) !== "undefined") {
            // Store
            localStorage.setItem("lastname", "Smith");
            // Retrieve
            document.getElementById("result").innerHTML = localStorage.getItem("lastname");
        } else {
            document.getElementById("result").innerHTML = "Sorry, your browser does not support Web Storage...";
        }
    </script>
    <script>
        $(function () {
            $("#slidez").responsiveSlides({
                auto: true,
                pager: false,
                nav: true,
                speed: 500,
                maxwidth: 960,
                namespace: "centered-btns"
            });
        });
    </script>

    <script type="text/javascript" src="../../onlineRestaurant/restaurant/js/html5.js"></script>
    <style type="text/css">
        .slider_bg {behavior:url(../../onlineRestaurant/restaurant/js/PIE.htc)}
    </style>

    <!--[if lt IE 7]>
    <div style='clear:both;text-align:center;position:relative'>
        <a href="http://www.microsoft.com/windows/internet-explorer/default.aspx?ocid=ie6_countdown_bannercode"><img src="http://storage.ie6countdown.com/assets/100/images/banners/warning_bar_0000_us.jpg" border="0" alt="" /></a>
    </div>
    <![endif]-->
</head>
<body id="page1">
<div class="body6">
    <div class="body1">
        <div class="body5">
            <div class="main zerogrid">
                <!-- header -->
                <header>
                    <h1><a   style="position: relative;left: -50px;top: -30px"  href="/onlineOrder" id="logo"><img src="../../onlineRestaurant/restaurant/images/logo.png"/></a></h1>
                    <nav>
                        <ul id="top_nav">
                            <li><a href="#"><img src="../../onlineRestaurant/restaurant/images/icon_2.gif" alt=""></a></li>
                            <li class="end"><a href="onlineCustomer"><i class="fa fa-user" style="color: rgba(255,255,255,0.91); font-size:20px;">
                                LogIn ${loggerId.name}

                            </i></a></li>

                        </ul>
                    </nav>
                    <nav>
                        <ul id="menu">
                            <li class="active"><a href="onlineDashboard">Dashboard</a></li>
                            <li><a href="onlineOrder">Order</a></li>
                            <li><a href="onlineTable">Table</a></li>
                            <li><a href="about">About Us</a></li>
                            <li><a href="onlineContact">Contacts</a></li>
                        </ul>
                    </nav>
                </header>
                <!-- / header -->
                <!-- content -->
                <article id="content">
                    <div class="slider_bg">
                        <div class="slider">
                            <ul class="items">
                                <li>
                                    <img src="../../onlineRestaurant/restaurant/images/img1.jpg" alt="">
                                    <div class="banner">
                                        <strong>Italian<span>Fettuccine</span></strong>
                                        <b>Dish of the Day</b>
                                        <p>
											<span>For Italian Food Lovers<br>
											Try some delicious italian fettuccine made by our food specialists</span>
                                        </p>
                                    </div>
                                </li>
                                <li>
                                    <img src="../../onlineRestaurant/restaurant/images/img2.jpg" alt="">
                                    <div class="banner">
                                        <strong>Succulent<span>meat</span></strong>
                                        <b>Dish of the Day</b>
                                        <p>
											<span>For meat lovers<br>
											Try some spicy and sweet meat with some baked potatoes</span>
                                        </p>
                                    </div>
                                </li>
                                <li>
                                    <img src="../../onlineRestaurant/restaurant/images/img3.jpg" alt="">
                                    <div class="banner">
                                        <strong>French-Style<span>Tartlet</span></strong>
                                        <b>Dish of the Day</b>
                                        <p>
											<span>For French Food Lovers<br>
											Try some Tartlets with cheese sauce with you family</span>
                                        </p>
                                    </div>
                                </li>
                            </ul>
                        </div>
                        <div class="slider-response">
                            <div class="rslides_container">
                                <ul class="rslides" id="slidez">
                                    <li><img src="../../onlineRestaurant/restaurant/images/img1.jpg" alt=""></li>
                                    <li><img src="../../onlineRestaurant/restaurant/images/img2.jpg" alt=""></li>
                                    <li><img src="../../onlineRestaurant/restaurant/images/img3.jpg" alt=""></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="wrap">
                        <section class="col-1-3"><div class="wrap-col">
                            <div class="box">
                                <div>
                                    <h2>Welcome <span>to Us!</span></h2>
                                    <figure><img src="../../onlineRestaurant/restaurant/images/page1_img1.jpg" alt="" ></figure>
                                    <p class="pad_bot1">Hotel <a href="http://blog.templatemonster.com/2011/08/01/free-website-template-jquery-slider-typography-restaurant/" class="list_1">Hareesha</a> Resort offers accommodations in Yakkalamulla with free WiFi and a spa center. The resort has an outdoor pool and views of the pool, and guests can enjoy a drink at the bar. Free private parking is available on site.</p>
                                    <a href="#" class="button1">Read More</a>
                                </div>
                            </div>
                        </div></section>
                        <section class="col-1-3"><div class="wrap-col">
                            <div class="box">
                                <div>
                                    <h2>About <span>Us</span></h2>
                                    <figure><img src="../../onlineRestaurant/restaurant/images/page1_img2.jpg" alt="" ></figure>
                                    <p class="pad_bot1">For more information: <br>Visit: <a href="/home"> Hareesha Online Reservations</a> <br> Email: hotelhareesha@gmail.com</a> <br> call: 011 -2976284 <br> fax: 011-2976284 <br> customer hotline: 077-7890438</p>
                                    <a href="#" class="button1">Read More</a>
                                </div>
                            </div>
                        </div></section>
                        <section class="col-1-3"><div class="wrap-col">
                            <div class="box">
                                <div>
                                    <h2>Our <span>Services</span></h2>
                                    <figure><img src="../../onlineRestaurant/restaurant/images/page1_img3.jpg" alt="" ></figure>
                                    <ul class="list1 pad_bot1">
                                        <li><a href="#">Hall reservations for your special days</a></li>
                                        <li><a href="#">Vacation facility with our great customer service</a></li>
                                        <li><a href="#">Delicious food to your doorsteps</a></li>
                                        <li><a href="#">Reserve your tables for breakfast, lunch & dinner</a></li>
                                    </ul>
                                    <a href="#" class="button1">Read More</a>
                                </div>
                            </div>
                        </div></section>
                    </div>
                </article>
            </div>
        </div>
    </div>
</div>
<div class="body2">
    <div class="main zerogrid">
        <article id="content2">
            <div class="wrapper">
                <section class="col-2-3">
                    <h2>Upcoming Events</h2>
                    <div class="wrapper">
                        <div class="col-1-2"><div class="wrap-col">
                            <div class="wrapper pad_bot2">
                                <figure class="left marg_right1"><img src="../../onlineRestaurant/restaurant/images/page1_img4.jpg" alt=""></figure>
                                <p>
                                    <a href="#">20.11.14. Happy Halloween</a><br>
                                    Halloween Party with Halloween Special Foods
                                </p>
                            </div>
                            <div class="wrapper">
                                <figure class="left marg_right1"><img src="../../onlineRestaurant/restaurant/images/page1_img5.jpg" alt=""></figure>
                                <p>
                                    <a href="#">20.12.25. Merry Christmas</a><br>
                                    Christmas Special Food with Loving Santa
                                </p>
                            </div>
                        </div></div>
                        <div class="col-1-2"><div class="wrap-col">
                            <div class="wrapper pad_bot2">
                                <figure class="left marg_right1"><img src="../../onlineRestaurant/restaurant/images/page1_img6.jpg" alt=""></figure>
                                <p>
                                    <a href="#">20.11.06.Anniversary</a><br>
                                    Hotel Hareesha's Anniversary Party.
                                </p>
                            </div>
                            <div class="wrapper">
                                <figure class="left marg_right1"><img src="../../onlineRestaurant/restaurant/images/page1_img7.jpg" alt=""></figure>
                                <p>
                                    <a href="#">20.12.31. Happy New Year</a> <br>
                                    Start your New year With Our Food.
                                </p>
                            </div>
                        </div></div>
                    </div>
                </section>
                <section class="col-1-3"><div class="wrap-col">
                    <h2>Testimonials</h2>
                    <ul class="testimonials">
                        <li class="row">
                            <span>1</span>
                            <p>
                                “Very Friendly staff and very fast service in any circumstances”
                                <img src="../../onlineRestaurant/restaurant/images/signature1.jpg" alt="">
                            </p>
                        </li>
                        <li class="row">
                            <span>2</span>
                            <p>
                                “Nice location and staff considering about customer satisfaction always”
                                <img src="../../onlineRestaurant/restaurant/images/signature2.jpg" alt="">
                            </p>
                        </li>
                        <li class="row">
                            <span>3</span>
                            <p>
                                “Cool and carlm place to visit." <br>
                                <img src="../../onlineRestaurant/restaurant/images/signature3.jpg" alt="">
                            </p>
                        </li>
                    </ul>
                </div></section>
            </div>
        </article>
        <!-- / content -->
    </div>
</div>
<div class="body3">

    <div class="main zerogrid">
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