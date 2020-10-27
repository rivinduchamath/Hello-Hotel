
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
    <!-- NProgress -->
    <link href="../../vendors/nprogress/nprogress.css" rel="stylesheet">

    <!-- Custom styling plus plugins -->
    <link href="../../build/css/custom.min.css" rel="stylesheet">

    <%
        SimpleDateFormat sdf = new SimpleDateFormat ( "dd-MM-yyyy" );
        String date = sdf.format ( new Date ( ) );
    %>
</head>

<body class="nav-md" style="cursor: pointer">
<div class="container body">
    <div class="main_container">
        <!-- Side header -->
        <jsp:include page="sideHeader.jsp" />
        <!-- /Side header -->

        <!-- Top header -->
        <jsp:include page="topHeader.jsp" />
        <!-- /Top header -->

        <!-- page content -->
        <div class="right_col" role="main">
            <div class="">
                <div class="page-title">
                    <div class="title_left">
                        <h3>Report
                            <small>Rooms Income</small>
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

                    </div>

                </div>
                <form action="houseKeepingReport" method="post">
                <div class="form-group">
                    <div class="col-12 col-sm-12 col-md-12 col-lg-3 col-xl-3"> <br>
                        <label for="date">Date from</label>
                        <input type="date" class="form-control"
                               required="required" name="dateIn"
                               id="date" placeholder="Date from"/></div>
                    <br>
                </div>
                <div class="form-group">
                    <div class="col-12 col-sm-12 col-md-12 col-lg-3 col-xl-3"> <br>
                        <label for="date">Date to </label>
                        <input type="date" class="form-control"
                               required="required" name="dateOut"
                               id="date1" placeholder="Date to"/>
                    </div>
                    <br>
                </div>
                    <div class="form-group">
                        <div class="col-12 col-sm-12 col-md-12 col-lg-3 col-xl-3"> <br>
                            <label for="date">Check Report </label>
                            <input type='submit'  class="form-control btn-dark" style="width: 50%; " value="Check">
                        </div>
                        <br>
                    </div>

                </form>

                <div class="clearfix"></div>

                <div class="row">
                    <div class="col-md-12">
                        <div class="x_panel">
                            <div class="x_title">
                                <h2>Invoice Print
                                    <small>Employee invoice</small>
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
                                                <i class="fa fa-globe"></i> Invoice.
                                                <small><%=date%>
                                                </small>
                                            </h1>
                                        </div>
                                    </div>
                                    <!-- info row -->
                                    <div class="row invoice-info">

                                        <!-- /.col -->

                                        <!-- /.col -->
                                        <div class="col-sm-4 invoice-col">
                                            <b>Invoice #007612</b>
                                            <br>
                                            <br>
                                            <b>Order ID:</b> 4F3S8J
                                            <br>
                                            <b>Payment Due:</b><%=date%>
                                            <br>
                                            <b>Account:</b> 968-34567
                                        </div>
                                        <!-- /.col -->
                                    </div>
                                    <!-- /.row -->

                                    <!-- Table row -->
                                    <div class="row">
                                        <div class="  table">
                                            <table id="saq" class="table table-striped" style="text-align: center">
                                                <thead>

                                                <tr>
                                                    <th>Id</th>
                                                    <th>Customer Id</th>
                                                    <th>N Rooms</th>
                                                    <th>Date</th>
                                                </tr>
                                                </thead>
                                                <tbody>

                                                <c:forEach items="${loadHotelRoomTable}" var="e">
                                                    <tr>
                                                        <td>${e.reservationId}</td>
                                                        <td>${e.customer}</td>
                                                        <td>${e.noOfRooms}</td>
                                                        <td>${e.checkIn}</td>

                                                    </tr>
                                                </c:forEach>
                                                </tbody>
                                            </table>
                                        </div>
                                        <!-- /.col -->
                                    </div>


                                    <!-- this row will not appear when printing -->
                                    <div class="row no-print">
                                        <div class=" ">


                                                <input style="display: none" type="text" id="itemPay" name="SalaryId">
                                                <ul class="nav navbar-right panel_toolbox">
                                                    <button type="submit" value="Register"
                                                            style="font-weight: bold;color: white" ; id="name" onclick="window.print();"
                                                            class="btn btn-dark "> Print Report <i class="fa fa-file-image-o"></i>
                                                    </button>
                                                </ul>



                                        </div>
                                    </div>
                                </section>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- /page content -->




        <!-- footer content -->
        <jsp:include page="footer.jsp" />
        <!-- /footer content -->

    </div>
</div>

<!-- jQuery -->
<script src="../../vendors/jquery/dist/jquery.min.js"></script>

<script>
    var rowCount = document.getElementById('saq').rows.length;
    var table = document.getElementById("saq"), sumVal2 = 0.0, sumVal3 = 0.0, sumVal4 = 0.0, sumVal5 = 0.0;
    var sumVal = 0.0;
    var avgTax = 0.0;    var str = '';


    for (var i = 1; i < table.rows.length; i++) {
        str = str+ (table.rows[i].cells[0].innerHTML)+" ";
        sumVal = sumVal + parseFloat(table.rows[i].cells[7].innerHTML);
        sumVal2 = sumVal2 + parseFloat(table.rows[i].cells[3].innerHTML);
        sumVal3 = sumVal3 + parseFloat(table.rows[i].cells[6].innerHTML);
        sumVal5 = sumVal5 + parseFloat(table.rows[i].cells[5].innerHTML);
        sumVal4 = sumVal4 + parseFloat(table.rows[i].cells[4].innerHTML);
        avgTax = sumVal3 / i;
    }


    document.getElementById("val").innerHTML = "Rs: " + sumVal;
    document.getElementById("val2").innerHTML = "Rs: " + sumVal2;
    document.getElementById("val3").innerHTML = "Rs: " + sumVal3;
    document.getElementById("val5").innerHTML = "Rs: " + sumVal5;
    document.getElementById("val4").innerHTML = "Rs: " + sumVal4;
    document.getElementById("val9").innerHTML = "(avg)" + avgTax + "%";
    $("#itemPay").val(str);

</script>

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