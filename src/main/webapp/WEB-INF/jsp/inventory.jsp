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

        .btnq2:hover {
            transform: scale(1.05, 1.1);
            transition: 0.8s ease;
            -webkit-transition: 0.8s ease;
            -moz-transition: 0.8s ease;
        }

        .btnq3:hover {
            transform: scale(1.3, 1.3);
            transition: 0.8s ease;
            -webkit-transition: 0.8s ease;
            -moz-transition: 0.8s ease;
        }
        #chartdiv {
            width: 100%;
            height: 500px;
        }

        #chartdiv1 {
            width: 100%;
            height: 500px;
        }

        .large-btn:hover {
            color: #cebbbb;
        }
        /*//////////////////////////////////////////////////////////////*/

        .containerx {
            display: flex;

        }

        .btnq {
            text-decoration: none;
            border: 5px solid rgb(174, 182, 203);
            position: relative;
            overflow: hidden;
            height: 90px;
            width: 100%;
            font-size: 1.5rem;
            text-align: center;
            border-radius: 5px 5px;
        }

        .btnq:before {
            content: "";
            position: absolute;
            top: 0;
            left: -00%;
            text-align: center;
            width: 100%;
            height: 100%;
            background: linear-gradient(
                    120deg,
                    transparent,
                    rgba(135, 141, 156, 0.4),
                    transparent
            );
            transition: all .8s;
        }

        .btnq:hover:before {
            left: 100%;
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
                                    <button style=" border: 5px solid rgb(174, 182, 203);background-color: #45526e;
                                    color: #c6d4d3;font-weight: bolder" type="button"  class="btnq2 btn"><i class="fa fa-bookmark">
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
                        <div class="containerx">
                            <a style=" font-family: Playfair Display, Georgia, Times New Roman, serif;
                             background-color:#3d495f; color: #ffffff;font-weight: bolder"
                               href="manageSupplier" class="btnq"><h2
                                    style="position: relative; letter-spacing: 1px;
                                     margin-top: 30px">Supplier Manage</h2></a>
                        </div>
                        <br>
                    </div>

                    <div class="col-sm-12 col-md-3 col-lg-3 col-xl-3">
                        <div class="containerx">
                            <a style=" font-family: Playfair Display, Georgia, Times New Roman, serif;
                             background-color:#3d495f; color: #ffffff;font-weight: bolder"
                               href="barStock" class="btnq"><h2
                                    style="position: relative; letter-spacing: 1px;
                                     margin-top: 30px">Kitchen Stock</h2></a>
                        </div>
                        <br>
                    </div>

                    <div class="col-sm-12 col-md-3 col-lg-3 col-xl-3">
                        <div class="containerx">
                            <a style=" font-family: Playfair Display, Georgia, Times New Roman, serif;
                             background-color:#3d495f; color: #ffffff;font-weight: bolder"
                               href="barStock" class="btnq"><h2
                                    style="position: relative; letter-spacing: 1px;
                                     margin-top: 30px">F&B Stock</h2></a>
                        </div>
                        <br>
                    </div>

                    <div class="col-sm-12 col-md-3 col-lg-3 col-xl-3">
                        <div class="containerx">
                            <a style=" font-family: Playfair Display, Georgia, Times New Roman, serif;
                             background-color:#3d495f; color: #ffffff;font-weight: bolder"
                               href="restaurantStock" class="btnq"><h2
                                    style="position: relative; letter-spacing: 1px;
                                     margin-top: 30px">All Inventory</h2></a>
                        </div>
                        <br>
                    </div>

                </div>
                <%--                    /////////////////////////////////////////////////////--%>
                <div class="col-sm-12 col-md-12 col-lg-12 col-xl-12">

                    <div class="x_panel">
                        <div class="x_title">
                            <h2> Inventory Notice
                                <small>Day After Tomorrow</small>

                            </h2>
                            <ul class="nav navbar-right panel_toolbox">

                                <li>
                                    <a type='submit' class="img__wrap" href="/addInventoryType" value="Register">
                                        <i style="font-size: 18px"  class="fa fa-gear img__img"><label class="img__description" style=" font-size: 15px"> &nbsp;&nbsp;Settings</label> </i>
                                    </a>

                                </li>
                            </ul>

                            <div class="clearfix"></div>
                        </div>
                        <div class="x_content">
                            <div class="row">

                                        <a href="inventoryToday">
                                            <button style="float: left;font-weight: bolder" class="btn btn-dark">
                                                Today
                                            </button>
                                        </a>
                                        <a href="inventoryTomorrow">
                                            <button style="float: left;font-weight: bolder" class="btn btn-dark">
                                                Tomorrow
                                            </button>
                                        </a>
                                        <a href="inventory">
                                            <button style="float: left;font-weight: bolder"
                                                    class=" active btn btn-dark">Day After Tomorrow
                                            </button>
                                        </a>
                                <a style="right: 55px; position:absolute !important;" href="allInventoryNotice" class="img__wrap">
                                    <i style="  font-weight: bolder"
                                            class="active fa fa-list img__img">

                                        <label style=" font-size: 15px" class="img__description">&nbsp;All&nbsp;Notice </label>
                                    </i>
                                </a>

                                <div class="col-sm-12">
                                    <div class="card-box table-responsive">
                                        <table  style="text-align: center" id="datatable-buttons" class="table table-striped table-bordered">
                                            <thead class="thead-light">
                                            <tr>

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
                                            <c:forEach items="${findDayAfterTomorrowNotice}" var="e">
                                                <tr>

                                                    <td>${e.inventoryId}</td>
                                                    <td>${e.text}</td>
                                                    <td>${e.department}</td>
                                                    <td>${e.orderQty}</td>
                                                    <td>${e.qtyOnHand}</td>
                                                    <td> ${Double.parseDouble(e.requiredQty > 0.0 ? e.requiredQty : 0.0) }</td>
                                                    <td>${e.date}</td>
                                                    <td>${e.expDate}</td>
                                                    <td>${e.orderHolder}</td>
                                                    <td style="width: 20%" >
                                                            <form action="updateQty" method="post">
                                                                <div class="input-group" >
                                                                    <input style="display: none" value="${e.inventoryId}" type="text" class="form-control" name="inventoryId">
                                                                    <input required type="number" class="form-control" name="orderQty">
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
                                                      <%--  <c:url value="/inventory" var="url">
                                                            <c:param name="state" value="${e.state}"/>
                                                        </c:url> <a href="updateStateDayAfterTomorrow/${e.noticeId }"
                                                                    class="checkbox">--%>
                                                              ${1.0 > e.requiredQty ? "Complete" : "InComplete"}
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