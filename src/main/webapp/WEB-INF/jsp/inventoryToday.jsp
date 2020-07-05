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
                        <h3>Inventory Manage
                            <small>Welcome To Hotel Hareesha</small>
                        </h3>
                        <div class="col-12 col-sm-12 col-md-12 col-lg-12 col-xl-12">
                            <div class="col-6 col-sm-6 col-md-6 col-lg-6 col-xl-3">
                                <a href="/addInventory">
                                    <button type="button" class="btn btn-dark"><i class="fa fa-bookmark">
                                        +New</i>
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


                    <div class="col-sm-12 col-md-3 col-lg-3 col-xl-3">
                        <a href="barStock">
                            <button type="button" class="large-btn btn btn-dark">Beverage Stock</button>
                        </a>
                    </div>

                    <div class="col-sm-12 col-md-3 col-lg-3 col-xl-3">
                        <button type="button" class="large-btn btn btn-dark">Kitchen Stock</button>
                    </div>

                    <div class="col-sm-12 col-md-3 col-lg-3 col-xl-3">
                        <button type="button" class="large-btn btn btn-dark">Items Stock</button>
                    </div>

                    <div class="col-sm-12 col-md-3 col-lg-3 col-xl-3">
                        <a href="restaurantStock">
                            <button type="button" class="large-btn btn btn-dark">Restaurant Stock</button>
                        </a>
                    </div>

                </div>
                <%--                    /////////////////////////////////////////////////////--%>
                <div class="col-sm-12 col-md-12 col-lg-12 col-xl-12">

                    <div class="x_panel">
                        <div class="x_title">
                            <h2>Notice Dashboard
                                <small>Notice</small>
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
                                        <a href="inventoryToday">
                                            <button style="float: left;font-weight: bolder"
                                                    class="active btn btn-primary">Today
                                            </button>
                                        </a>
                                        <a href="inventoryTomorrow">
                                            <button style="float: left;font-weight: bolder" class=" btn btn-primary">
                                                Tomorrow
                                            </button>
                                        </a>
                                        <a href="inventory">
                                            <button style="float: left;font-weight: bolder" class=" btn btn-primary">Day
                                                After Tomorrow
                                            </button>
                                        </a>
                                        <a type='submit' href="/addInventoryType"
                                           style="margin-left: 1.5%; width: 12%" value="Register"><img
                                                style="width: 30%" src="../../images/lg.triple-gears-loading-icon.gif">

                                        </a>
                                        <table style="text-align: center" id="datatable-buttons"
                                               class="table table-striped table-bordered">
                                            <thead class="thead-light">
                                            <tr>
                                                <th>Notice Id</th>
                                                <th>Item Id</th>
                                                <th>Item Name</th>
                                                <th>Department</th>
                                                <th>Order Qty</th>
                                                <th>Qty On Hand</th>
                                                <th>Required Qty</th>
                                                <th>Date</th>
                                                <th>Expected Date</th>
                                                <th>Order Holder</th>
                                                <th>Add Item</th>
                                                <th>State</th>
                                            </tr>


                                            </thead>
                                            <tbody>
                                            <c:forEach items="${findTodayNotice}" var="e">
                                                <tr>
                                                    <td>${e.noticeId}</td>
                                                    <td>${e.inventoryId}</td>
                                                    <td>${e.text}</td>
                                                    <td>${e.department}</td>
                                                    <td>${e.orderQty}</td>
                                                    <td>${e.qtyOnHand}</td>
                                                    <td>
                                                            ${e.qtyOnHand > e.orderQty ? 0.0 : e.orderQty-e.qtyOnHand}
                                                    </td>
                                                    <td>${e.date}</td>
                                                    <td>${e.expDate}</td>
                                                    <td>${e.orderHolder}</td>
                                                    <td style="width: 20%" >
                                                        <form action="updateQty" method="post">
                                                            <div class="input-group" >
                                                                <input style="display: none" value="${e.inventoryId}" type="text" class="form-control" name="inventoryId">
                                                                <input type="number" class="form-control" name="orderQty">
                                                                <span class="input-group-btn">
                                                                     <button type="submit" style="font-weight: bolder;
                                                                      background-color: white; color: #b3adad;
                                                                      border: #0f0f0f solid 1px"
                                                                             class="btn">+</button>
                                                                    </span>
                                                            </div>
                                                        </form>
                                                    </td>
                                                    <td>
                                                     <%--   <c:url value="/inventoryToday" var="url">
                                                            <c:param name="state" value="${e.state}"/>
                                                        </c:url> <a href="updateStateToday/${e.noticeId }"
                                                                    class="checkbox">--%>
                                                             ${e.qtyOnHand < e.orderQty ? "Incomplete" : "Complete"}

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
<!-- Custom Theme Scripts -->
<script src="../../build/js/custom.min.js"></script>

<!-- Datatables -->
<script src="../../vendors/datatables.net/js/jquery.dataTables.min.js"></script>
<script src="../../vendors/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
<script src="../../vendors/datatables.net-buttons/js/dataTables.buttons.min.js"></script>


<script src="../../vendors/datatables.net-buttons/js/buttons.html5.min.js"></script>
<script src="../../vendors/datatables.net-buttons/js/buttons.print.min.js"></script>
<script src="../../vendors/datatables.net-fixedheader/js/dataTables.fixedHeader.min.js"></script>
<script src="../../vendors/datatables.net-keytable/js/dataTables.keyTable.min.js"></script>


</body>
</html>