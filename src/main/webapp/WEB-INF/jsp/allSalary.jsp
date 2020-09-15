<%--
  Created by IntelliJ IDEA.
  User: Chanuka
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>

<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Employee Management </title>
    <link href="../../vendors/iCheck/skins/flat/green.css" rel="stylesheet">
    <!-- Bootstrap -->
    <link href="../../vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="../../vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="../../vendors/nprogress/nprogress.css" rel="stylesheet">
    <!-- iCheck -->
    <link href="../../vendors/iCheck/skins/flat/green.css" rel="stylesheet">
    <link rel="icon" type="image/png" href="../../images/icons/gdfgd.png"/>
    <!-- Bootstrap -->
    <link href="../../vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="../../vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="../../vendors/nprogress/nprogress.css" rel="stylesheet">
    <!-- iCheck -->
    <link href="../../vendors/iCheck/skins/flat/green.css" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="../../build/css/custom.min.css" rel="stylesheet">
    <link href="cdn.datatables.net/1.10.20/css/jquery.dataTables.min.css">
    <link href="../../vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="../../vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="../../vendors/nprogress/nprogress.css" rel="stylesheet">
    <!-- iCheck -->
    <link href="../../vendors/iCheck/skins/flat/green.css" rel="stylesheet">
    <!-- Datatables -->

    <link href="../../vendors/datatables.net-bs/css/dataTables.bootstrap.min.css" rel="stylesheet">
    <link href="../../vendors/datatables.net-buttons-bs/css/buttons.bootstrap.min.css" rel="stylesheet">
    <link href="../../vendors/datatables.net-fixedheader-bs/css/fixedHeader.bootstrap.min.css" rel="stylesheet">
    <link href="../../vendors/datatables.net-responsive-bs/css/responsive.bootstrap.min.css" rel="stylesheet">
    <link href="../../vendors/datatables.net-scroller-bs/css/scroller.bootstrap.min.css" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="../../build/css/custom.min.css" rel="stylesheet">
    <link href="../../css/common.css" rel="stylesheet">
    <!-- Custom Theme Style -->
    <link href="../../build/css/custom.min.css" rel="stylesheet">



</head>

<body class="nav-md" style="cursor: pointer">

<div class="container body">
    <div class="container body">
        <div class="main_container">
            <div class="col-md-3 left_col">
                <div class="left_col scroll-view">
                    <div class="navbar nav_title" style="border: 0;">
                        <a href="Dashboard" class="site_title"> <img style="margin-top: -0px; width: 40px;height: 40px"
                                                                     src="../../images/favicon.ico"><span
                                style="margin-top: 20px;">&nbsp;Four Seasons!</span></a>
                    </div>

                    <div class="clearfix"></div>

                    <!-- menu profile quick info -->
                    <div class="profile clearfix">
                        <div class="profile_pic" style=" width: 80px;height: 80px">
                            <img src="../../images/icons/${loggerName.pic}" alt="..." class="img-circle profile_img">
                        </div>
                        <div class="profile_info">
                            <span>Welcome,</span>
                            <h2> ${loggerName.name}</h2>
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
                                        <li><a href="Dashboard">Dashboard</a></li>
                                    </ul>
                                </li>
                                <li><a><i class="fa fa-edit"></i> Employee <span class="fa fa-chevron-down"></span></a>
                                    <ul class="nav child_menu">
                                        <li><a href="tables_dynamic">Employee Manage</a></li>
                                        <li><a href="attendance">Attendance</a></li>
                                        <li><a href="salary">Salary Manage</a></li>
                                    </ul>
                                </li>
                                <li><a><i class="fa fa-desktop"></i>Project<span
                                        class="fa fa-chevron-down"></span></a>
                                    <ul class="nav child_menu">
                                        <li><a href="projects">Projects</a></li>
                                    </ul>
                                </li>
                                <li><a><i class="fa fa-table"></i> Notice <span class="fa fa-chevron-down"></span></a>
                                    <ul class="nav child_menu">
                                        <li><a href="notice">View All</a></li>
                                    </ul>
                                </li>
                            </ul>
                        </div>
                        <div class="menu_section">
                            <h3>Live On</h3>
                            <ul class="nav side-menu">
                                <li><a><i class="fa fa-user"></i> Employee Data <span
                                        class="fa fa-chevron-down"></span></a>
                                    <ul class="nav child_menu">
                                        <li><a href="contacts">Contacts</a></li>
                                        <li><a href="profile">Profile</a></li>
                                    </ul>
                                </li>
                                <li><a><i class="fa fa-windows"></i> Extras <span class="fa fa-chevron-down"></span></a>
                                    <ul class="nav child_menu">
                                        <li><a href="media_gallery">View Images</a></li>
                                        <li><a href="calendar">Calendar</a></li>
                                        <li><a href="e_commerce">E-commerce</a></li>
                                        <li><a href="pricing_tables">Pricing Tables</a></li>
                                        <li><a href="login">Login Page</a></li>
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

            <!-- top navigation -->
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
                                    <img src="../../images/icons/${loggerName.pic}" alt="">${loggerName.name}
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
            <!-- /top navigation -->

        <!-- page content -->
        <div class="right_col" role="main">
            <div class="">

                    <div class="col-md-12 col-sm-12 ">
                        <div class="x_panel">
                            <div class="x_title">
                                <h2>All Salaries List
                                    <small>Salary List Page</small>
                                </h2>
                                <ul class="nav navbar-right panel_toolbox">
                                    <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                                    </li>
                                    <li class="dropdown">
                                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                                           aria-expanded="false"><i class="fa fa-wrench"></i></a>
                                        <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                                            <a class="dropdown-item" href="#">Settings 1</a>
                                            <a class="dropdown-item" href="#">Settings 2</a>
                                        </div>
                                    </li>
                                    <li><a class="close-link"><i class="fa fa-close"></i></a>
                                    </li>
                                </ul>
                                <div class="clearfix"></div>
                            </div>
                            <div class="x_content">
                                <div class="row">
                                    <div class="col-sm-12">
                                        <div class="card-box table-responsive">
                                            <p class="text-muted font-13 m-b-30">
                                                The User Table Provide To Find Data Of Users.If You Want Edit OR Remove User You Can Find
                                                User And Just Click On User Row.
                                            </p>
                                            <table id="datatable-buttons" class="table table-striped table-bordered">
                                                <thead class="thead-light">
                                                <tr>
                                                    <th>Salary ID</th>
                                                    <th>Employee ID</th>
                                                    <th>Employee Name</th>
                                                    <th>Basic Salary</th>
                                                    <th>Bonus</th>
                                                    <th>Income Tax</th>
                                                    <th>OT Hours</th>
                                                    <th>OT Rate</th>
                                                </tr>

                                                </thead>
                                                <tbody>
                                                <c:forEach items="${listEmployeesTableSalarya}" var="e">
                                                    <tr>
                                                        <td>${e.salaryId}</td>
                                                        <td>${e.employeeID.idNo}</td>
                                                        <td>${e.employeeID.name}</td>
                                                        <td>${e.basicSalary}</td>
                                                        <td>${e.bonus}</td>
                                                        <td>${e.incomeTax}</td>
                                                        <td>${e.otHours}</td>
                                                        <td>${e.otRate}</td>
                                                            </tr>
                                                </c:forEach>
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
            </div>
        </div>
        <!-- /page content -->

        <!-- footer content -->
        <footer>
            <div class="pull-right">
                Copyright © Employee Management 2020.<a href="https://rivinduchamath.github.io/pro/">Created by Chanuka
                Mullevidana</a>
            </div>
            <div class="clearfix"></div>
        </footer>
        <!-- /footer content -->
    </div>
</div>

<!-- jQuery -->
<script src="../../vendors/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap -->
<script src="../../vendors/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
<!-- FastClick -->
<script src="../../vendors/fastclick/lib/fastclick.js"></script>
<!-- NProgress -->
<script src="../../vendors/nprogress/nprogress.js"></script>
<!-- jQuery custom content scroller -->
<script src="../../vendors/malihu-custom-scrollbar-plugin/jquery.mCustomScrollbar.concat.min.js"></script>

<!-- Custom Theme Scripts -->
<script src="../../build/js/custom.min.js"></script>
</body>
</html>