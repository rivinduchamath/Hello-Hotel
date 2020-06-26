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

    <title>Hotel Management </title>
    <link rel="icon" type="image/png" href="../../images/icons/gdfgd.png"/>
    <!-- Bootstrap -->
    <link href="../../vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="../../vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- Custom Theme Style -->
    <link href="../../build/css/custom.min.css" rel="stylesheet">

    <%
        SimpleDateFormat sdf = new SimpleDateFormat ( "dd-MM-yyyy" );
        String date = sdf.format ( new Date ( ) );
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
                        <h3>Kitchen Manage
                            <small>Banquet Order</small>
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
<%--/////////////////////////////////// Page Body ////////////////////////////////////////--%>
<%--  Tables--%>


                    <div class="col-sm-12 col-md-6 col-lg-6 col-xl-6">

                                    <div >
                                        <a href="/kitchen">
                                            <button style="position: relative;margin-right: 0" type="button"
                                                    class=" btn btn-secondary"><i
                                                    class="fa fa-backward"></i> Back
                                            </button>
                                        </a>
                                        <div class="x_panel">
                                            <div class="x_title">
                                                <h2> Food Pack
                                                    <small>Food Pack</small>
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
                                                        <div class="card-box datatable-responsive">
                                                            <p class="text-muted font-13 m-b-30">
                                                               lorem
                                                            </p>
                                                            <table id="datatable-responsive1"
                                                                   class="table table-striped table-bordered">
                                                                <tbody>
                                                                <%--   <c:forEach items="${listEmployeesTableSalarya}" var="e">--%>
                                                                <tr>
                                                                    <td>main Rice${e.foodId}</td>
                                                                </tr>
                                                                <tr>
                                                                    <td>chicken Rice${e.foodId}</td>
                                                                </tr>
                                                                <%--    </c:forEach>--%>
                                                                </tbody>
                                                            </table>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>


                    </div>



<%--Second Table--%>
                <div class="col-sm-12 col-md-6 col-lg-6 col-xl-6">
                        <form style="top: 40px;position: relative"  method="POST" action="/addNewFoodItems" name="projectController">
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="x_panel">
                                        <div class="x_title">
                                            <h2>Food List</h2>
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

                                            <p style="font-weight: bold; font-size: 14px">Click Here To Submit  >>
                                                &emsp;
                                                <button class="btn-outline-info" style="width: 16%;font-weight: bolder;color: black;
                          height:36px; " href="/"
                                                        onMouseOver="this.style.color='white'; this.style.fontWeight='bold'"
                                                        onMouseOut="this.style.color='black'; "
                                                >Submit
                                                </button>

                                            </p>

                                            <!-- start project list -->
                                            <table id="datatable-buttons" class="table table-striped table-bordered">
                                                <thead>
                                                <tr>
                                                    <th>Item Id</th>
                                                    <th>Item Name</th>
                                                    <th ></th>
                                                </tr>
                                                </thead>
                                                <tbody>
                                                <%--                                            <c:forEach items="${lias}" var="a">--%>
                                                <tr>
                                                    <td>C001${a.itemId}</td>
                                                    <td>
                                                        <a>Namee}</a>

                                                    </td>
                                                    <td><input />
                                                    </td>
                                                </tr>
                                                <%--                                            </c:forEach>--%>
                                                </tbody>
                                            </table>
                                            <!-- end project list -->

                                        </div>
                                    </div>
                                </div>
                            </div>
                        </form>
                </div>


            <%-- End Tables--%>

<%--//////////////////////////////////////////////////////////////////////////////////////////////--%>
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
<!-- Bootstrap -->
<script src="../../vendors/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
<!-- Custom Theme Scripts -->
<script src="../../build/js/custom.min.js"></script>

</body>
</html>