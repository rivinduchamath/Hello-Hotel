
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<html lang="en">
<head>
    <meta content="text/html; charset=UTF-8" http-equiv="Content-Type">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta content="IE=edge" http-equiv="X-UA-Compatible">
    <meta content="width=device-width, initial-scale=1" name="viewport">

    <link href="../../images/icons/gdfgd.png" rel="icon" type="image/png"/>
    <!-- Bootstrap -->
    <link href="../../vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="../../vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- Custom Theme Style -->
    <link href="../../build/css/custom.min.css" rel="stylesheet">


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
                        <h3>Food Package Management (${menuItem.name})</h3>
                    </div>
                </div>
            </div>
            <!--Content//////////////////////////////////////////////////////////////////-->
            <div class="col-sm-12 col-md-12 col-lg-12 col-xl-12">
                <div class="col-12 col-sm-12 col-md-12 col-lg-2 col-xl-2">
                    <a href="/manageFoodPacks">
                        <button type="button" class="large-btn btn btn-dark"><i class="fa fa-mail-reply">
                            Back</i>
                        </button>
                    </a>
                </div>
            </div>

            <div class="col-sm-12 col-md-12 col-lg-12 col-xl-12">
                <!--Food item table--------------------------------------------------------------->
                <div class="col-sm-12 col-md-6 col-lg-6 col-xl-6">
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
                                                <table class="table table-striped table-bordered" id="datatable-buttons"
                                                       style="text-align: center">
                                                    <thead class="thead-light">
                                                    <tr>
                                                        <th>Id</th>
                                                        <th>Item Name</th>
                                                        <th>Category</th>
                                                        <th>Unit Price</th>
                                                        <th></th>

                                                    </tr>

                                                    </thead>
                                                    <tbody>
                                                    <c:forEach items="${loadFoodItemTable}" var="item">
                                                        <tr>
                                                            <td>${item.itemId}</td>
                                                            <td>${item.itemName}</td>
                                                            <td>${item.itemCategory}</td>
                                                            <td>${item.unitePrice}</td>
                                                            <td>
                                                                <form action="" method="post">
                                                                <i class="fa fa-plus-square"></i>
                                                                </form>
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
                <!-------------------------------------------------------------------------------->


                <!--Selected food items table----------------------------------------------------->
                <div class="col-sm-12 col-md-6 col-lg-6 col-xl-6">
                    <div class="col-12 col-sm-12 col-md-12 col-lg-12 col-xl-12">
                        <div class="row">
                            <div class="x_panel">
                                <div class="x_title">
                                    <h2>Selected Food Items...<br>Pack: ${menuItem.name}</h2>
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
                                                       id="datatable-buttons1"
                                                       style="text-align: center">
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

                                                            <i class="fa fa-minus-square" style="font-size: 20px"></i>

                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td>002</td>
                                                        <td>Potato2</td>
                                                        <td>

                                                            <i class="fa fa-minus-square" style="font-size: 20px"></i>

                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td>003</td>
                                                        <td>Potato3</td>
                                                        <td>

                                                            <i class="fa fa-minus-square" style="font-size: 20px"></i>

                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td>004</td>
                                                        <td>Potato4</td>
                                                        <td>

                                                            <i class="fa fa-minus-square" style="font-size: 20px"></i>

                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td>005</td>
                                                        <td>Potato5</td>
                                                        <td>

                                                            <i class="fa fa-minus-square" style="font-size: 20px"></i>

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
                <!-------------------------------------------------------------------------------->
            </div>
        </div>

    </div>
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


</body>
</html>
