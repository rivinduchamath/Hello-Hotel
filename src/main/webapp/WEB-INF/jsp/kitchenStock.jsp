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

    <%
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String date = sdf.format(new Date());
    %>
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
    <title>Kitchen Stock </title>
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
                        <h3>Kitchen Stock
                            <small>Welcome To Hotel Hareesha</small>
                        </h3>
                        <div class="col-12 col-sm-12 col-md-12 col-lg-12 col-xl-12">
                            <div class="col-6 col-sm-6 col-md-6 col-lg-6 col-xl-6">
                                <a href="/inventory">
                                    <button style=" border: 5px solid rgb(174, 182, 203);background-color: #45526e;
                                    color: #c6d4d3;font-weight: bolder" type="button" class="btnq2 btn"><i
                                            class="fa fa-reply">
                                        Back</i>
                                    </button>
                                </a>
                                <a href="/inventory">
                                    <button style=" border: 5px solid rgb(174, 182, 203);background-color: #45526e;
                                    color: #c6d4d3;font-weight: bolder" type="button" class="btnq2 btn"><i
                                            class="fa fa-sticky-note">
                                        Report</i>
                                    </button>
                                </a>

                            </div>
                        </div>
                    </div>

                    <div class="title_right">
                        <script>

                            function formatTime() {
                                now = new Date();
                                hour = now.getHours();
                                min = now.getMinutes();
                                sec = now.getSeconds();

                                if (document.clock.sivamtime[0].checked) {
                                    if (min <= 9) {
                                        min = "0" + min;
                                    }
                                    if (sec <= 9) {
                                        sec = "0" + sec;
                                    }
                                    if (hour > 12) {
                                        hour = hour - 12;
                                        add = " p.m.";
                                    } else {
                                        hour = hour;
                                        add = " a.m.";
                                    }
                                    if (hour == 12) {
                                        add = " p.m.";
                                    }
                                    if (hour == 0) {
                                        hour = "12";
                                    }

                                    document.clock.sivam.value = ((hour <= 9) ? "0" + hour : hour) + ":" + min + ":" + sec + add;
                                }

                                if (document.clock.sivamtime[1].checked) {
                                    if (min <= 9) {
                                        min = "0" + min;
                                    }
                                    if (sec <= 9) {
                                        sec = "0" + sec;
                                    }
                                    if (hour < 10) {
                                        hour = "0" + hour;
                                    }
                                    document.clock.sivam.value = hour + ':' + min + ':' + sec;
                                }

                                setTimeout("formatTime()", 1000);
                            }

                            window.onload = formatTime;

                        </script>
                        <form name="clock" style="float: right">
                            <table class="clock" width="135">
                                <tr>
                                    <td class="clock2">
                                    </td>
                                </tr>
                                <tr>
                                    <h6 style="color:#73879C; float:right;border: none;background-color: #f6f6f6">
                                        <input style="color:#73879C; float:right;border: none;background-color: #f6f6f6"
                                               class="clock2" type="text" name="sivam" size="12"><br>
                                        <p><%=date%>
                                        </p>
                                    </h6>

                                </tr>
                                <tr>
                                    <td>
                                        <label class="clock3" for="1"><input type="radio" style="display: none" id="1"
                                                                             name="sivamtime" checked></label><br>
                                        <label class="clock3" for="2"><input type="radio" style="display: none" id="2"
                                                                             name="sivamtime"></label>
                                    </td>
                                </tr>
                            </table>

                        </form>
                    </div>
                </div>
                <%--//////////////////////////////////////////////////////////////////////////////////////////////////--%>
                <div class="col-sm-12 col-md-12 col-lg-12 col-xl-12">


                    <%--                    /////////////////////////////////////////////////////--%>
                    <!--////////////////////////////////////////////-->
                    <div class="col-md-6 col-sm-6" style="position: relative;display: inline-block">
                        <div class="x_panel">
                            <div class="x_title">
                                <h2>Kitchen
                                    <small>Stock Details</small>
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
                                        <div class="card-box table-responsive1">
                                            <p class="text-muted font-13 m-b-30">

                                            </p>

                                            <table id="datatable-responsive"
                                                   class="table table-striped table-bordered dt-responsive nowrap"
                                                   cellspacing="0" width="100%">
                                                <thead class="thead-dark">
                                                <tr>
                                                    <th>ItemName</th>
                                                    <th>QtyOnHand</th>
                                                    <th>Price</th>

                                                </tr>
                                                </thead>
                                                <tbody>
                                              <c:forEach items="${listAllKitchenStock}" var="e">
                                                <tr>
                                                    <td>${e.text}</td>
                                                    <td>${e.orderQty}</td>
                                                    <td>${e.sellingPrice}</td>

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

                    <%--                ///////////////////////////////////Second Table--%>
                    <!--/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////-->

                    <div class="col-md-6 col-sm-6" style="float: right; position: relative;display: inline-block">
                        <div class="x_panel">
                            <div class="x_title">
                                <h2>Kitchen
                                    <small>Orders
                                    </small>
                                </h2>
                                <form method="POST" action="/invoice" name="invoice">
                                    <input style="display: none" type="text" id="itemPay" name="SalaryId">
                                    <ul class="nav navbar-right panel_toolbox">
                                        <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                                        </li>

                                    </ul>

                                </form>


                                <div class="clearfix"></div>
                            </div>

                            <div class="x_content">

                                <div class="row">

                                    <div class="col-sm-12">

                                        <div class="card-box table-responsive">

                                            <table id="datatable-buttons"
                                                   class="table table-striped jambo_table bulk_action table-bordered">
                                                <thead class="thead-dark">

                                                <tr>
                                                    <th>Item</th>
                                                    <th>Supplier</th>
                                                    <th>price</th>
                                                    <th>Qty</th>
                                                    <th>Date</th>
                                                </tr>
                                                </thead>

                                                <tbody>
                                                <c:forEach items="${listTodayOrders}" var="e">
                                                    <tr>
                                                    <tr>
                                                        <td>${e.inventory}</td>
                                                        <td>${e.supplier}</td>
                                                        <td>${e.price}</td>
                                                        <td>${e.quantity}</td>
                                                        <td>${e.date}</td>


                                                    </tr>
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
                <div class="col-md-12 col-sm-12" style="position: relative;display: inline-block">
                    <div class="x_panel">
                        <div class="x_title">
                            <h2>Kitchen
                                <small>Notices</small>
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

                                        </p>

                                        <table id="datatable-responsive1"
                                               class="table table-striped table-bordered dt-responsive nowrap"
                                               cellspacing="0" width="100%">
                                            <thead class="thead-dark">
                                            <tr>
                                                <th> ItemName</th>
                                                <th> OrderQty</th>
                                                <th> ExpDate</th>
                                                <th> Date</th>

                                                <th> OrderHolder</th>

                                            </tr>
                                            </thead>
                                            <tbody>
                                               <c:forEach items="${listKitchenNotice}" var="e">
                                            <tr>
                                                   <tr>
                                                       <td>${e.text}</td>
                                                       <td>${e.orderQty}</td>
                                                       <td>${e.expDate}</td>
                                                       <td>${e.date}</td>
                                                       <td>${e.orderHolder}</td>


                                                   </tr>
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
                <%--/////////////////////////////////////////////    /////////////////////////////////////////////--%>
            </div>
        </div>
        <!-- /page content -->


        <!-- footer content -->
        <jsp:include page="footer.jsp"/>
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
<!-- iCheck -->
<script src="../../vendors/iCheck/icheck.min.js"></script>

<!-- jQuery -->
<script src="../../vendors/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap -->
<script src="../../vendors/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
<!-- FastClick -->
<script src="../../vendors/fastclick/lib/fastclick.js"></script>
<!-- NProgress -->
<script src="../../vendors/nprogress/nprogress.js"></script>
<!-- iCheck -->
<script src="../../vendors/iCheck/icheck.min.js"></script>


<!-- Bootstrap -->
<script src="../../vendors/datatables.net/js/jquery.dataTables.min.js"></script>
<script src="../../vendors/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
<script src="../../vendors/datatables.net-buttons/js/dataTables.buttons.min.js"></script>
<script src="../../vendors/datatables.net-buttons-bs/js/buttons.bootstrap.min.js"></script>
<script src="../../vendors/datatables.net-buttons/js/buttons.flash.min.js"></script>
<script src="../../vendors/datatables.net-buttons/js/buttons.html5.min.js"></script>
<script src="../../vendors/datatables.net-buttons/js/buttons.print.min.js"></script>
<script src="../../vendors/datatables.net-fixedheader/js/dataTables.fixedHeader.min.js"></script>
<script src="../../vendors/datatables.net-keytable/js/dataTables.keyTable.min.js"></script>
<script src="../../vendors/datatables.net-responsive/js/dataTables.responsive.min.js"></script>
<script src="../../vendors/datatables.net-responsive-bs/js/responsive.bootstrap.js"></script>
<script src="../../vendors/datatables.net-scroller/js/dataTables.scroller.min.js"></script>
<script src="../../vendors/jszip/dist/jszip.min.js"></script>
<script src="../../vendors/iCheck/icheck.min.js"></script>
<!-- Custom Theme Scripts -->
<script src="../../build/js/custom.min.js"></script>


</body>
</html>