<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="icon" type="image/png" href="../../images/icons/gdfgd.png"/>
    <!-- Bootstrap -->
    <link href="../../vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="../../vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- Custom Theme Style -->
    <link href="../../build/css/custom.min.css" rel="stylesheet">


    <style>
        .large-btn {
            height: 90px;
            width: 100%;
            font-family: "Playfair Display", Georgia, "Times New Roman", serif;
            font-weight: bolder;
            font-size: 27px;

        }

        .large-btn:hover {
            color: #0f0f0f;
        }
    </style>

    <!-- Datatables -->
    <link href="../../vendors/datatables.net-bs/css/dataTables.bootstrap.min.css" rel="stylesheet">
    <link href="../../vendors/datatables.net-buttons-bs/css/buttons.bootstrap.min.css" rel="stylesheet">
    <link href="../../vendors/datatables.net-fixedheader-bs/css/fixedHeader.bootstrap.min.css" rel="stylesheet">
    <link href="../../vendors/datatables.net-responsive-bs/css/responsive.bootstrap.min.css" rel="stylesheet">

</head>

<body class="nav-md" style="cursor: pointer">
<div class="container body">
    <div class="main_container">

        <!-- Side header -->
        <div class="col-md-3 left_col">
            <div class="left_col scroll-view">
                <div class="navbar nav_title" style="border: 0;">
                    <a href="dashboard" class="site_title"> <img style="margin-top: -0px; width: 40px;height: 40px"
                                                                 src="../../images/favicon.ico"><span
                            style="margin-top: 20px;">&nbsp;Hotel Hareesha!</span></a>
                </div>

                <div class="clearfix"></div>

                <!-- menu profile quick info -->
                <div class="profile clearfix">
                    <div class="profile_pic" style=" width: 80px;height: 80px">
                        <img src="../../images/icons/gdfgd.png" alt="..." class="img-circle profile_img">
                    </div>
                    <div class="profile_info">
                        <span>Welcome,</span>
                        <h2> Wusitha</h2>
                    </div>
                </div>
                <!-- /menu profile quick info -->

                <br/>

                <!-- sidebar menu -->
                <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
                    <div class="menu_section">
                        <h3>General</h3>
                        <ul class="nav side-menu">
                            <li><a><i class="fa fa-home"></i> Home <span class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu">
                                    <li><a href="dashboard">Dashboard</a></li>
                                </ul>
                            </li>
                            <li><a><i class="fa fa-tasks"></i> Front Desk <span class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu">
                                    <li><a href="reservations">Reservation</a></li>
                                    <li><a href="banquets">BanquetManagement</a></li>
                                </ul>
                            </li>
                            <li><a><i class="fa fa-cutlery"></i> Food and Beverage<span
                                    class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu">
                                    <li><a href="foodAndBeverage"> Food & Bev </a></li>
                                </ul>
                            </li>
                            <li><a><i class="fa fa-life-buoy"></i> House Keeping <span
                                    class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu">
                                    <li><a href="housekeeping">Room Manage</a></li>
                                </ul>
                            </li>
                            <li><a><i class="fa fa-paw"></i> Kitchen<span
                                    class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu">
                                    <li><a href="kitchen">Kitchen Manage</a></li>
                                </ul>
                            </li>
                            <li><a><i class="fa fa-shopping-cart"></i> Inventory<span
                                    class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu">
                                    <li><a href="inventory">Inventory Manage</a></li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                    <div class="menu_section">
                        <h3>Live On</h3>
                        <ul class="nav side-menu">
                            <li><a><i class="fa fa-gear"></i> Manage System<span
                                    class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu">
                                    <li><a href="manage">Manager</a></li>
                                    <li><a href="hr">HR</a></li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                    <div class="menu_section">
                        <h3>Live On</h3>
                        <ul class="nav side-menu">
                            <li><a><i class="fa fa-anchor"></i> Additional Pages <span
                                    class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu">
                                    <li><a href="contacts">Contacts</a></li>
                                    <li><a href="profile">Profile</a></li>
                                </ul>
                            </li>
                            <li><a><i class="fa fa-ge"></i> Extras <span class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu">
                                    <li><a href="login">Login Page</a></li>
                                    <li><a href="pricing">Pricing Tables</a></li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="sidebar-footer hidden-small">
                    <a data-toggle="tooltip" data-placement="top" title="Settings">
                        <span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
                    </a>
                    <a data-toggle="tooltip" data-placement="top" title="FullScreen">
                        <span class="glyphicon glyphicon-fullscreen" aria-hidden="true"></span>
                    </a>
                    <a data-toggle="tooltip" data-placement="top" title="Lock">
                        <span class="glyphicon glyphicon-eye-close" aria-hidden="true"></span>
                    </a>
                    <a data-toggle="tooltip" data-placement="top" title="Logout" href="login">
                        <span class="glyphicon glyphicon-off" aria-hidden="true"></span>
                    </a>
                </div>
                <!-- /menu footer buttons -->
            </div>
        </div>
        <!--jsp:include page="sideHeader.jsp"/>
        <-- /Side header -->

        <!-- Top header -->
        <!--jsp:include page="topHeader.jsp"/>

        <-- /Top header -->
        <div class="top_nav">
            <div class="nav_menu">
                <div class="nav toggle">
                    <a id="menu_toggle"><i class="fa fa-bars"></i></a>
                </div>
                <nav class="nav navbar-nav">
                    <ul class=" navbar-right">
                        <li class="nav-item dropdown open" style="padding-left: 15px;">
                            <a href="javascript:;" class="user-profile dropdown-toggle" aria-haspopup="true"
                               id="navbarDropdown" data-toggle="dropdown" aria-expanded="false">
                                <img src="../../images/icons/gdfgd.png" alt="">User
                            </a>
                            <div class="dropdown-menu dropdown-usermenu pull-right" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="javascript:;"> Profile</a>
                                <a class="dropdown-item" href="javascript:;">
                                    <span class="badge bg-red pull-right">50%</span>
                                    <span>Settings</span>
                                </a>
                                <a class="dropdown-item" href="javascript:;">Help</a>
                                <a class="dropdown-item" href="/"><i class="fa fa-sign-out pull-right"></i> Log Out</a>
                            </div>
                        </li>

                    </ul>
                </nav>
            </div>
        </div>


        <!-- page content -->
        <div class="right_col" role="main">
            <div class="">
                <div class="page-title">
                    <div class="title_left">
                        <h3>Banquet Order</h3>
                    </div>
                </div>
            </div>

            <!--Content//////////////////////////////////////////////////////////////////-->
            <div class="col-sm-12 col-md-12 col-lg-12 col-xl-12">

                <div class="col-sm-12 col-md-12 col-lg-7 col-xl-7">
                    <div class="col-sm-12 col-md-12 col-lg-12 col-xl-12">
                        <!--Order items form-------------------------------------------------------------------->

                        <div class="row">
                            <div class="col-md-12 col-sm-12 ">
                                <div class="x_panel">
                                    <div class="x_title">
                                        <h2>Order Food Items Form <small>(Banquet food order)</small></h2>
                                        <ul class="nav navbar-right panel_toolbox">
                                            <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                                            </li>
                                            <li class="dropdown">
                                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                                                   aria-haspopup="true" aria-expanded="false"><i
                                                        class="fa fa-wrench"></i></a>
                                            </li>
                                        </ul>
                                        <div class="clearfix"></div>
                                    </div>
                                    <div class="col-sm-12 col-md-12 col-lg-6 col-xl-6">
                                        <div class="x_content">
                                            <br/>
                                            <form id="demo-form2" data-parsley-validate
                                                  class="form-horizontal form-label-left">

                                                <div class=" form-group">
                                                    <label class=" label-align"
                                                           for="first-name">ItemName: <span
                                                            class="required">*  &nbsp;</span>
                                                    </label>
                                                    <div class=" ">
                                                        <input type="text" id="first-name" required="required"
                                                               class="form-control ">
                                                    </div>
                                                </div>
                                                <div class=" form-group">
                                                    <label class="label-align"
                                                           for="last-name">Quantity: <span class="required">* &nbsp; &nbsp; &nbsp;</span>
                                                    </label>
                                                    <div class="">
                                                        <input type="text" id="last-name" name="last-name"
                                                               required="required"
                                                               class="form-control">
                                                    </div>
                                                </div>

                                                <div class=" form-group">
                                                    <div class=" ">
                                                        <button type="submit" class="btn btn-dark">+ Add</button>
                                                        <button class="btn btn-outline-dark" type="reset">Reset</button>

                                                    </div>
                                                </div>

                                            </form>
                                        </div>
                                    </div>

                                    <div class="col-sm-12 col-md-12 col-lg-6 col-xl-6"
                                         style="background-color: lightyellow">

                                        <h5>Ordered Items...</h5>
                                        <ul>
                                            <li><b>Cake</b></li>
                                            <li><b>Bacon & Cheddar Mini Quiches</b></li>
                                            <li><b>Cheese</b></li>
                                        </ul>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="col-sm-12 col-md-12 col-lg-6 col-xl-6">


                        <div class="row">
                            <div class="x_panel">
                                <div class="x_title">
                                    <h2>Banquet Food Orders</h2>
                                    <ul class="nav navbar-right panel_toolbox">
                                        <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                                        </li>
                                        <li class="dropdown">
                                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                                               aria-expanded="false"><i class="fa fa-wrench"></i></a>
                                        </li>
                                    </ul>
                                    <div class="clearfix"></div>
                                </div>
                                <div class="x_content">
                                    <div class="row">
                                        <div class="col-sm-12">
                                            <div class="card-box table-responsive">
                                                <table id="datatable-buttons1"
                                                       class="table table-striped table-bordered">
                                                    <thead class="thead-light">
                                                    <tr>
                                                        <th>Order ID</th>
                                                        <th>Date</th>
                                                        <th>Food Pack</th>
                                                        <th></th>

                                                    </tr>

                                                    </thead>
                                                    <tbody>
                                                    <tr>
                                                        <td>001</td>
                                                        <td>2020/08/25</td>
                                                        <td>Birthday Pack</td>
                                                        <td>
                                                            <i style="font-size: 20px" class="fa fa-plus-square"></i>
                                                        </td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>


                    <!--/Order items form------------------------------------------------------------------->

                    <!--Food Item list table---------------------------------------------------------------->

                    <!--/Food Item list table--------------------------------------------------------------->


                    <!--Ordered Food Item list table---------------------------------------------------------------->
                    <div class="col-12 col-sm-12 col-md-4 col-lg-6 col-xl-6">
                        <div class="row">
                            <div class="x_panel">
                                <div class="x_title">
                                    <h2>Ordered Food Items
                                        <small>list</small>
                                    </h2>
                                    <ul class="nav navbar-right panel_toolbox">
                                        <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                                        </li>
                                        <li class="dropdown">
                                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                                               aria-expanded="false"><i class="fa fa-wrench"></i></a>
                                        </li>
                                    </ul>
                                    <div class="clearfix"></div>
                                </div>
                                <div class="x_content">
                                    <div class="row">
                                        <div class="col-sm-12">
                                            <div class="card-box table-responsive">
                                                <table id="datatable-buttons2"
                                                       class="table table-striped table-bordered">
                                                    <thead class="thead-light">
                                                    <tr>
                                                        <th>Id</th>
                                                        <th>ItemName</th>
                                                        <th>Quantity</th>
                                                        <th></th>

                                                    </tr>

                                                    </thead>
                                                    <tbody>
                                                    <tr>
                                                        <td>001</td>
                                                        <td>Potato</td>
                                                        <td>200</td>
                                                        <td>

                                                            <i style="font-size: 20px" class="fa fa-trash"></i>

                                                        </td>
                                                    </tr>

                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-sm-12 col-md-12 col-lg-5 col-xl-5">
                    <div class="col-12 col-sm-12 col-md-12 col-lg-12 col-xl-12">
                        <div class="row">
                            <div class="x_panel">
                                <div class="x_title">
                                    <h2>Find Food Items
                                        <small>list</small>
                                    </h2>
                                    <ul class="nav navbar-right panel_toolbox">
                                        <li><a class="collapse-link"></a>
                                        </li>
                                        <li class="dropdown">
                                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                                               aria-expanded="false"><i class="fa fa-wrench"></i></a>
                                        </li>
                                    </ul>
                                    <div class="clearfix"></div>
                                </div>
                                <div class="x_content">
                                    <div class="row">
                                        <div class="col-sm-12">
                                            <div class="card-box table-responsive">
                                                <table style="text-align: center" id="datatable-buttons"
                                                       class="table table-striped table-bordered">
                                                    <thead class="thead-light">
                                                    <tr>
                                                        <th>Id</th>
                                                        <th>Item Name</th>
                                                        <th></th>

                                                    </tr>

                                                    </thead>
                                                    <tbody>
                                                    <tr>
                                                        <td>001</td>
                                                        <td>Potato</td>
                                                        <td>

                                                            <i style="font-size: 20px" class="fa fa-plus-square"></i>

                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td>002</td>
                                                        <td>Potato2</td>
                                                        <td>

                                                            <i style="font-size: 20px" class="fa fa-plus-square"></i>

                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td>003</td>
                                                        <td>Potato3</td>
                                                        <td>

                                                            <i style="font-size: 20px" class="fa fa-plus-square"></i>

                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td>004</td>
                                                        <td>Potato4</td>
                                                        <td>

                                                            <i style="font-size: 20px" class="fa fa-plus-square"></i>

                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td>005</td>
                                                        <td>Potato5</td>
                                                        <td>

                                                            <i style="font-size: 20px" class="fa fa-plus-square"></i>

                                                        </td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <%--               /////////////////////////////////////////////////////////////////////////////////////--%>


            </div>
        </div>
        <!--/Ordered Food Item list table--------------------------------------------------------------->


        <!--/Content/////////////////////////////////////////////////////////////////-->


    </div>
    <!-- /page content -->


    <!-- footer content -->
    <!--jsp:include page="footer.jsp"/-->
    <footer>
        <div class="pull-right">
            Copyright © Hotel Management 2020.<a href="https://rivinduchamath.github.io/pro/">Created by Rivindu
            Wijayarathna</a>
        </div>
        <div class="clearfix">

            <!-- /footer content -->


        </div>
    </footer>
</div>


<!-- jQuery -->
<script src="../../vendors/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap -->
<script src="../../vendors/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
<!-- Custom Theme Scripts -->
<script src="../../build/js/custom.min.js"></script>

<!-- Datatables -->
<script src="../../vendors/datatables.net/js/jquery.dataTables.min.js"></script>
<script src="../../vendors/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>

<!--%--Responsive Table--%-->
<script src="../../vendors/datatables.net-responsive/js/dataTables.responsive.min.js"></script>
<script src="../../vendors/datatables.net-responsive-bs/js/responsive.bootstrap.js"></script>
</body>
</html>