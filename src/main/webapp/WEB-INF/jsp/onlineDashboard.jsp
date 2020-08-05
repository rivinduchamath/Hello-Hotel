
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
    <!--[if lt IE 9]>
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
<body id="page1">
<div class="body6">
    <div class="body1">
        <div class="body5">
            <div class="main zerogrid">
                <!-- header -->
                <header>
                    <h1><a href="/onlineOrder" id="logo"><img src="../../onlineRestaurant/restaurant/images/logo.png"/></a></h1>
                    <nav>
                        <ul id="top_nav">
                            <li><a href="onlineOrder"><img src="images/icon_1.gif" alt=""></a></li>
                            <li><a href="#"><img src="../../onlineRestaurant/restaurant/images/icon_2.gif" alt=""></a></li>
                            <li class="end"><a href="Contacts.html"><img src="../../onlineRestaurant/restaurant/images/icon_3.gif" alt=""></a></li>
                        </ul>
                    </nav>
                    <nav>
                        <ul id="menu">
                            <li class="active"><a href="onlineOrder">Restaurant</a></li>
                            <li><a href="onlineTable">Table</a></li>
                            <li><a href="Wine.html">Wine List</a></li>
                            <li><a href="CookBook.html">CookBook</a></li>
                            <li><a href="Contacts.html">Contacts</a></li>
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
											<span>Lorem ipsum dolamet consectetur<br>
											adipisicing elit, sed do eiusmod tempor aliqua enim ad minim veniam, quis nosinci- didunt ut labore et dolore.</span>
                                        </p>
                                    </div>
                                </li>
                                <li>
                                    <img src="../../onlineRestaurant/restaurant/images/img2.jpg" alt="">
                                    <div class="banner">
                                        <strong>succulent<span>meat</span></strong>
                                        <b>Dish of the Day</b>
                                        <p>
											<span>Lorem ipsum dolamet consectetur <br>
											adipisicing elit, sed do eiusmod tempor aliqua enim ad minim veniam, quis nosinci- didunt ut labore et dolore.</span>
                                        </p>
                                    </div>
                                </li>
                                <li>
                                    <img src="../../onlineRestaurant/restaurant/images/img3.jpg" alt="">
                                    <div class="banner">
                                        <strong>French-Style<span>Tartlet</span></strong>
                                        <b>Dish of the Day</b>
                                        <p>
											<span>Lorem ipsum dolamet consectetur <br>
											adipisicing elit, sed do eiusmod tempor aliqua enim ad minim veniam, quis nosinci- didunt ut labore et dolore.</span>
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
                                    <p class="pad_bot1">This <a href="http://blog.templatemonster.com/2011/08/01/free-website-template-jquery-slider-typography-restaurant/" class="list_1">Deliccio Template</a> goes with two packages – with PSD source files and without them. PSD source is available for free for the registered members.</p>
                                    <a href="#" class="button1">Read More</a>
                                </div>
                            </div>
                        </div></section>
                        <section class="col-1-3"><div class="wrap-col">
                            <div class="box">
                                <div>
                                    <h2>About <span>Us</span></h2>
                                    <figure><img src="../../onlineRestaurant/restaurant/images/page1_img2.jpg" alt="" ></figure>
                                    <p class="pad_bot1">This is one of <a href="http://blog.templatemonster.com/free-website-templates/" target="_blank">free website templates</a> created by TemplateMonster.com team. This website template is optimized for 1024x768 screen res.</p>
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
                                        <li><a href="#">Lorem ipsum dolor sit amet</a></li>
                                        <li><a href="#">Consectetur adipisicing elit sed</a></li>
                                        <li><a href="#">Eiusmod tempor incididunt labore</a></li>
                                        <li><a href="#">Ut enim ad minim veniam</a></li>
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
                                    <a href="#">20.07. Sed perspiciatis</a><br>
                                    Unde omnis iste natus error volu accusantium doloremque.
                                </p>
                            </div>
                            <div class="wrapper">
                                <figure class="left marg_right1"><img src="../../onlineRestaurant/restaurant/images/page1_img5.jpg" alt=""></figure>
                                <p>
                                    <a href="#">18.07. Quasi architecto</a><br>
                                    Beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem.
                                </p>
                            </div>
                        </div></div>
                        <div class="col-1-2"><div class="wrap-col">
                            <div class="wrapper pad_bot2">
                                <figure class="left marg_right1"><img src="../../onlineRestaurant/restaurant/images/page1_img6.jpg" alt=""></figure>
                                <p>
                                    <a href="#">11.07. Laudaum totam</a><br>
                                    Rem aperiam, eaque ipsa quae ab illo inventore veritatis.
                                </p>
                            </div>
                            <div class="wrapper">
                                <figure class="left marg_right1"><img src="../../onlineRestaurant/restaurant/images/page1_img7.jpg" alt=""></figure>
                                <p>
                                    <a href="#">09.07. Volups asrnatur</a> <br>
                                    Aut odit aut fugit, sed quia consequuntur magni dolores eos qui.
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
                                “Remperam eaquepsa quae abillo inventore vertatis.”
                                <img src="../../onlineRestaurant/restaurant/images/signature1.jpg" alt="">
                            </p>
                        </li>
                        <li class="row">
                            <span>2</span>
                            <p>
                                “Quasi arctecto beatae vitae dicta sunt explicabo.”
                                <img src="../../onlineRestaurant/restaurant/images/signature2.jpg" alt="">
                            </p>
                        </li>
                        <li class="row">
                            <span>3</span>
                            <p>
                                “Nemo enim ipsam volupta<br>
                                tem quia voluptas.”<img src="../../onlineRestaurant/restaurant/images/signature3.jpg" alt="">
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
                    <h3>Toll Free: <span>1-800 123 45 67</span></h3>
                    Designed by <a rel="nofollow" href="http://www.TemplateMonster.com/" target="_blank">TemplateMonster</a> | <a href="https://www.zerotheme.com" title="free website templates">ZEROTHEME</a>
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