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
    <title>Employee Management </title>

    <!-- Bootstrap -->
    <link href="../../vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="../../vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="../../vendors/nprogress/nprogress.css" rel="stylesheet">

    <!-- Custom styling plus plugins -->
    <link href="../../build/css/custom.min.css" rel="stylesheet">

    <%
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String date = sdf.format(new Date());
    %>
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
                        <h3>Hotel Hareesha
                            <small>Banquet Bill</small>
                        </h3>
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

                        <!--////////////////////////-->

                        <!--//////////////////////////-->
                    </div>
                </div>

                <div class="clearfix"></div>

                <div class="row">
                    <div class="col-md-12">
                        <div class="x_panel">
                            <div class="x_title">
                                <h2>Banquet Bill Print
                                    <small>Banquet invoice</small>
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

                                <section class="content invoice">
                                    <!-- title row -->
                                    <div class="row">
                                        <div class="  invoice-header">
                                            <h1>
                                                <i class="fa fa-globe"></i> Banquet Bill
                                                <small><%=date%>
                                                </small>
                                            </h1>
                                        </div>
                                    </div>
                                    <!-- info row -->
                                    <div class="row invoice-info">
                                        <div class="col-sm-4 invoice-col">
                                            Address:
                                            <address>
                                                <strong>Hotel Hareesha </strong>
                                                <br>Galle, Sri Lanka
                                                <br>Phone: 0767188591
                                                <br>Email: HotelHareesha@gmail.lk
                                            </address>
                                        </div>

                                        <div class="col-sm-4 invoice-col">
                                            <b>Banquet Bill</b>
                                            <br>
                                            <b>Department:</b> Banquet Department
                                            <br>
                                            <b>Generate Date:</b><%=date%>
                                            <br>

                                        </div>
                                        <!-- /.col -->
                                    </div>
                                    <!-- /.row -->

                                    <!-- Table row -->
                                    <div class="row">
                                        <div class="col-md-5">
                                        <div class="  table">
                                            <table id="saq" class="table table-striped">
                                                <tbody>

                                                    <tr>
                                                        <th >Banquet Bill Id</th>
                                                        <th width="60%">:${data.banquetBillId}</th>

                                                    </tr>
                                                    <tr>
                                                        <th>Customer Name</th>
                                                        <th width="60%">:${data.name}</th>
                                                    </tr>
                                                    <tr>
                                                        <th>Customer Address</th>
                                                        <th width="60%">:${data.address}</th>
                                                    </tr>
                                                    <tr>
                                                        <th>Banquet Order Id</th>
                                                        <th width="60%">:${data.orderId}</th>
                                                    </tr>
                                                    <tr>
                                                        <th>Banquet Date</th>
                                                        <th width="60%">:${data.date}</th>
                                                    </tr>
                                                    <tr>
                                                        <th>Hall No</th>
                                                        <th width="60%">:${data.hallId}</th>
                                                    </tr>
                                                    <tr>
                                                        <th>Advance Fee</th>
                                                        <th width="60%">:${data.advanceFee}</th>
                                                    </tr>
                                                    <tr>
                                                        <th>Food price</th>
                                                        <th width="60%">:${data.foodPrice}</th>
                                                    </tr>
                                                    <tr>
                                                        <th>Extra Charges</th>
                                                        <th width="60%">:${data.otherPrice}</th>
                                                    </tr>

                                                    <tr>
                                                        <th>Order Status</th>
                                                        <th width="60%">:${data.orderState}</th>
                                                    </tr>






                                                </tbody>
                                            </table>
                                        </div>
                                        </div>
                                        <!-- /.col -->
                                        <div class="col-md-7">
                                            <p class="lead">Total Bill  <%=date%></p>
                                            <div class="table-responsive">
                                                <table class="table">
                                                    <tbody>

                                                    <tr>
                                                        <th style="width:50%">No.Plates&nbsp;:${data.noOfPlates}</th>
                                                        <td><span id="val2"></span></td>
                                                    </tr>
                                                    <tr>
                                                        <th>Basic Tot&nbsp;&nbsp;:${data.total}
                                                            <small style="font-weight: bold"><span id="val9"></span>
                                                            </small>
                                                        </th>
                                                        <td><span id="val3"></span></td>
                                                    </tr>

                                                    <tr>
                                                        <th>Total&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:${data.total}</th>
                                                        <td><span id="val"></span></td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                            </div>
                                            <p class="lead">Payment Methods:</p>
                                            <img src="../../images/visa.png" alt="Visa">
                                            <img src="../../images/mastercard.png" alt="Mastercard">
                                            <img src="../../images/american-express.png" alt="American Express">
                                            <img src="../../images/paypal.png" alt="Paypal">
                                            <p class="text-muted well well-sm no-shadow" style="margin-top: 10px;">
                                                Hotel Hareesha is a guest house grade A hotel Which is situated in Galle.
                                                Over the years they have come a long way in winning the hearts of local as well as foreign tourists.

                                            </p>
                                        </div>

                                    </div>
                                    <!-- /.row -->



                                    <!-- this row will not appear when printing -->
                                    <div class="row no-print">
                                        <div class=" ">

                                            <form method="POST" action=""
                                                  name="deleteInvoiceSalary">
                                                <input style="display: none" type="text" id="itemPay" name="SalaryId">
                                                <ul class="nav navbar-right panel_toolbox">
                                                    <button type="submit" value="Register"
                                                            style="font-weight: bold;color: white" ; id="name"
                                                            onclick="window.print();"
                                                            class="btn btn-success "> Print Bill <i
                                                            class="fa fa-file-image-o"></i>
                                                    </button>
                                                </ul>

                                            </form>

                                        </div>
                                    </div>
                                </section>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

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

<!-- Custom Theme Scripts -->
<script src="../../build/js/custom.min.js"></script>

</body>
</html>