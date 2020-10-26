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
            <!-- Side header -->
            <jsp:include page="sideHeader.jsp"/>
            <!-- /Side header -->

            <!-- Top header -->
            <jsp:include page="topHeader.jsp"/>
            <!-- /Top header -->


        <!-- page content -->
        <div class="right_col" role="main">
            <div class="">

                    <div class="col-md-12 col-sm-12 ">
                        <div class="x_panel">
                            <div class="x_title">
                                <h2>All Salaries List
                                    <small>Salary List Page</small>
                                </h2>
                                <div class="col-md-2 col-sm-2">
                                <a href="salary">
                                    <button type='submit' class="btn btn-secondary" style="width: 50%;float: right"
                                            value="Register">
                                       <i class="fa fa-reply"></i> Back
                                    </button>
                                </a>
                                </div>
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
                                                        <td>${e.employeeID}</td>
                                                        <td>${e.employeeName}</td>
                                                        <td>${e.basicSalary}</td>
                                                        <td>${e.otHours}</td>
                                                        <td>${e.employeeID}</td>
                                                        <td>${e.otHours}</td>
                                                        <td>${e.otHours}</td>
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