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
    <script type="text/javascript" src="../../onlineRestaurant/restaurant/js/jquery-1.6.js"></script>
    <script type="text/javascript" src="../../onlineRestaurant/restaurant/js/cufon-yui.js"></script>
    <script type="text/javascript" src="../../onlineRestaurant/restaurant/js/cufon-replace.js"></script>
    <script type="text/javascript" src="../../onlineRestaurant/restaurant/js/Forum_400.font.js"></script>
    <script type="text/javascript" src="../../onlineRestaurant/restaurant/js/atooltip.jquery.js"></script>
    <script type="text/javascript" src="../../onlineRestaurant/restaurant/js/css3-mediaqueries.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script type="text/javascript" src="js/html5.js"></script>
    <style type="text/css">
        .slider_bg {
            behavior: url(../../onlineRestaurant/restaurant/js/PIE.htc)
        }
    </style>
    <![endif]-->
    <!--[if lt IE 7]>
    <div style='clear:both;text-align:center;position:relative'>
        <a href="http://www.microsoft.com/windows/internet-explorer/default.aspx?ocid=ie6_countdown_bannercode"><img
                src="http://storage.ie6countdown.com/assets/100/images/banners/warning_bar_0000_us.jpg" border="0"
                alt=""/></a>
    </div>
    <![endif]-->
    <link href="../../vendors/datatables.net-bs/css/dataTables.bootstrap.min.css" rel="stylesheet">
    <link href="../../vendors/datatables.net-buttons-bs/css/buttons.bootstrap.min.css" rel="stylesheet">
    <link href="../../vendors/datatables.net-fixedheader-bs/css/fixedHeader.bootstrap.min.css" rel="stylesheet">
    <link href="../../vendors/datatables.net-responsive-bs/css/responsive.bootstrap.min.css" rel="stylesheet">
</head>
<body id="page4">
<div class="body6">
    <div class="body1">
        <div class="main zerogrid">
            <!-- header -->
            <header>
                <h1><a href="index.html" style="position: relative;left: -50px;top: -30px" id="logo"><img
                        src="../../onlineRestaurant/restaurant/images/logo.png"/></a></h1>
                <nav>
                    <ul id="top_nav">
                        <li><a href="index.html"><img src="../../onlineRestaurant/restaurant/images/icon_1.gif" alt=""></a>
                        </li>
                        <li><a href="#"><img src="../../onlineRestaurant/restaurant/images/icon_2.gif" alt=""></a></li>
                        <li class="end"><a href="onlineCustomer"><i class="fa fa-user"
                                                                    style="color: rgba(255,255,255,0.91); font-size:20px;">
                            LogIn ${loggerId.name}
                        </i></a></li>
                    </ul>
                </nav>
                <nav>
                    <ul id="menu">
                        <li><a href="onlineDashboard">Dashboard</a></li>
                        <li class="active"><a href="onlineOrder">Order</a></li>
                        <li><a href="onlineTable">Table</a></li>
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
                                    <h2>Recent <span>Recipes</span></h2>
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
                                    <a href="#" class="button1">Read More</a>
                                </div>
                            </div>
                        </div>
                    </section>
                    <section class="col-1-3">
                        <div class="wrap-col">
                            <div class="box">
                                <div>
                                    <h2>Your <span>Benefit</span></h2>
                                    <figure><img src="../../onlineRestaurant/restaurant/images/page4_img1.jpg" alt="">
                                    </figure>
                                    <p class="pad_bot1">Ut enim ad minima veniam, quis nos- trum exercitationem ullam
                                        corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur.</p>
                                    <a href="#" class="button1">Read More</a>
                                </div>
                            </div>
                        </div>
                    </section>
                    <section class="col-1-3">
                        <div class="wrap-col">
                            <div class="box">
                                <div>
                                    <h2 class="pad_bot1">Our <span>Standards</span></h2>
                                    <p class="pad_bot1">
                                        <strong>1. At vero eos et accusamus</strong><br>
                                        Iusto odio dignissimos ducimus qui blanditiis praesentium.<br>
                                        <strong>2. Voluptatum deleniti atque</strong><br>
                                        Corrupti quos dolores et quas molestias excepturi sint occaecati.<br>
                                        <strong>3. Cupiditate non provident</strong><br>
                                        Similique suculpa qui officia deserunt mollitia animi, id est.
                                    </p>
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
            <section>
                <div class="wrapper">
                    <div class="col-2-5">
                        <div class="wrap-col">
                            <h2>Food Items</h2>
                            <table id="dataTablesButton1">

                                <c:forEach items="${loadAllFoods}" var="e">
                                    <tr>
                                        <td>
                                            <figure class="pad_bot1 left marg_right1"><img
                                                    src="../../onlineRestaurant/restaurant/images/page4_img2.jpg"
                                                    alt=""></figure>
                                        </td>
                                        <td style="color: #e02b2b;position: absolute"> ${e.itemName}</td>
                                        <td><br>

                                            <button id="btnAdd1"
                                                    style="width: 40px;height: 40px;background-color: #bbb7b7; border-radius: 5px"
                                                    type="button"><i class="fa fa-plus"></i></button>
                                        </td>
                                        <td><br>Unite Price : ${e.unitePrice}</td>
                                        <td style="display: none" >${e.itemId}</td>
                                        <td style="display: none" >${e.unitePrice}</td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </div>
                    </div>

                    <div class="col-3-5">
                        <div class="wrap-col mag-1">
                            <h2>Food Order</h2>
                            <form>
                                <div class="form-group">
                                    <label >&nbsp;&nbsp;
                                        &nbsp;&nbsp;&nbsp;&nbsp;Item Id</label>
                                    <input style="" type="text" class="form-control"
                                           required="required" readonly name="itemId"
                                           id="itemCode" placeholder="Item Id"/>
                                </div>
                                <div class="form-group"style="top: 10px; position: relative;">
                                    <label style="width: 10%">Item Name</label>
                                    <input type="text" class="form-control"
                                           required="required"readonly name="itemId"
                                           id="itemName" placeholder="Item Name"/>
                                </div>
                                <div class="form-group" style="top: 20px;position: relative; ">
                                    <label >&nbsp;&nbsp;
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        &nbsp;&nbsp;&nbsp;&nbsp;Qty</label>
                                    <input type="number" class="form-control"
                                           required="required" name="itemId"
                                           id="qty" placeholder="Item Qty"/>
                                </div>
                                <div class="form-group" style="display: none;">
                                    <input type="hidden" class="form-control"
                                           required="required"readonly name="itemId"
                                           id="price" placeholder="Item Price"/>
                                </div>
                                <button type='button' class="btn btn-primary"
                                        style="left:70px;top: 30px; position: relative;
                                        height:25px;color:white;width: 20%;background-color: #a5113b" id="btnAdd"
                                        value="Register">
                                    Add
                                </button>
                            </form><br>

                            <div class="x_content">

                                            <table style="position:relative;top: 20px;text-align: center">
                                                <thead class="thead-light">
                                                <tr>
                                                    <th style="width: 10%">ItemId</th>
                                                    <th style="width: 20%">Name</th>
                                                    <th style="width: 10%">Price</th>
                                                    <th style="width: 10%">Qty</th>
                                                    <th style="width: 20%">Total</th>
                                                    <th style="width: 10%">Delete</th>
                                                </tr>

                                                </thead>
                                                <tbody id="tblOrder">
                                                </tbody>
                                            </table>

                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </article>
        <!-- / content -->
    </div>
    <form method="POST" action="saveOnlineOrder" name="saveOnlineOrder">
        <input style="display: none" type="text" id="itemPay" name="orderData">
        <ul class="nav navbar-right panel_toolbox">
            <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
            </li>
            <button type="submit" value="Register"
                    style="font-weight: bold;color: #41a8a5;" ; onclick="getValue()"
                    class="btn btn-success "> Pay <i class="fa fa-file-image-o"></i>
            </button>
        </ul>
    </form>
</div>
<div class="body3">

    <div class="main zerogrid">
        <!-- footer --><!-- footer -->
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
<!-- jQuery -->
<script src="../../vendors/jquery/dist/jquery.min.js"></script>
<script type="text/javascript"> Cufon.now(); </script>

<script src="../../js/onlineOrders.js"></script>

</body>
</html>