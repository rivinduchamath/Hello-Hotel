<%--
  Created by IntelliJ IDEA.
  User: Rivindu Chamath
  Date: 21-May-20
  Time: 2:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
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
        <jsp:include page="sideHeader.jsp"/>
        <!-- /Side header -->

        <!-- Top header -->
        <jsp:include page="topHeader.jsp"/>
        <!-- /Top header -->


        <!-- page content -->
        <div class="right_col" role="main">
            <div class="">
                <div class="page-title">
                    <div class="title_left">
                        <h3>Daily Food Order Report</h3>
                    </div>
                </div>
            </div>


            <div class="col-sm-12 col-md-12 col-lg-12 col-xl-12">
                <div class="col-sm-12 col-md-2 col-lg-2 col-xl-2">
                    <a href="/kitchen">
                        <button type="button" class="large-btn btn btn-dark" style="height: 50px" ><i class="fa fa-mail-reply">
                            Back</i>
                        </button>
                    </a>
                </div>
                <div class="col-sm-12 col-md-12 col-lg-12 col-xl-12">
                    <hr>
                </div>
            </div>
            <div class="col-sm-12 col-md-12 col-lg-12 col-xl-12">
                <div class="row">
                    <div class="x_panel">
                        <div class="x_title">
                            <h2>Daily Food Order Report</h2>
                            <ul class="nav navbar-right panel_toolbox">
                                <li><a class="collapse-link"></a>
                                </li>
                                <li class="dropdown">
                                    <a aria-expanded="false" class="dropdown-toggle" data-toggle="dropdown"
                                       href="#"
                                       role="button"><i class="fa fa-wrench"></i></a>
                                </li>
                            </ul>
                            <div class="clearfix"></div>
                        </div>
                        <div class="x_content">
                            <div class="row">
                                <div class="col-sm-12">
                                    <div class="card-box table-responsive">
                                        <table class="table table-striped table-bordered"
                                               id="datatable-buttons2"
                                               style="text-align: center">
                                            <thead class="thead-light">
                                            <tr>
                                                <th>Item Name</th>
                                                <th>Selling Rate</th>
                                                <th>Unit price</th>
                                                <th>Requested Quantity</th>
                                                <th>Total Value</th>
                                            </tr>

                                            </thead>
                                            <tbody>
                                            <!-------------------------------------------- -->
                                            <tr>
                                                <td>Fried rice</td>
                                                <td>26.32%</td>
                                                <td>200.00</td>
                                                <td>25</td>
                                                <td>5000.00</td>
                                            </tr>
                                            <tr>
                                                <td>Chicken Kottu</td>
                                                <td>52.63%</td>
                                                <td>300.00</td>
                                                <td>50</td>
                                                <td>15000.0</td>
                                            </tr>
                                            <tr>
                                                <td>Burger</td>
                                                <td>21.05%</td>
                                                <td>150.00</td>
                                                <td>20</td>
                                                <td>3000.00</td>
                                            </tr>
                                            <!-------------------------------------------- -->
                                            <c:forEach items="${loadMenuItemTable}" var="item">
                                                <tr>
                                                    <td>${item.menuId}</td>
                                                    <td>${item.name}</td>
                                                    <td>${item.type}</td>
                                                    <td>
                                                        <a href="foodPackage/${item.menuId}">
                                                            <input type="button" value="Manage">
                                                        </a>
                                                    </td>

                                                    <td>
                                                        <a href="deleteFoodPackage/${item.menuId}">
                                                            <i class="fa fa-trash" style="font-size: 20px"></i>
                                                        </a>
                                                    </td>
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

    <jsp:include page="footer.jsp"/>
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