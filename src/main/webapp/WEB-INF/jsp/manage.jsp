
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
    <%--Pie Chrat--%>
    <script src="https://www.amcharts.com/lib/4/core.js"></script>
    <script src="https://www.amcharts.com/lib/4/charts.js"></script>
    <script src="https://www.amcharts.com/lib/4/themes/spiritedaway.js"></script>
    <script src="https://www.amcharts.com/lib/4/themes/moonrisekingdom.js"></script>
    <script src="https://www.amcharts.com/lib/4/themes/animated.js"></script>
    <%--/Pie Chrat--%>

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

        #chartdiv {
            position: relative;
            top: 40px;
            width: 100%;
            height: 400px;
        }

        #chartdiv1 {
            position: relative;
            top: 40px;
            width: 100%;
            height: 400px;
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
            <div class="page-title">
                <div class="title_left">
                    <h3>System Manage
                        <small>Welcome To Hotel Hareesha</small>
                    </h3>
                </div>

                <%--Time--%>
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
            <%--/Time--%>

            <%--Button--%>
            <div class="col-sm-12 col-md-12 col-lg-12 col-xl-12">
                <div class="col-sm-12 col-md-3 col-lg-3 col-xl-3">
                    <a href="manageUser">
                        <button type="button" class="large-btn btn btn-dark">User Manage</button></a>
                </div>

                <div class="col-sm-12 col-md-3 col-lg-3 col-xl-3">
                    <a href="hr">
                        <button type="button" class="large-btn btn btn-dark">HR Manage</button></a>
                </div>

                <div class="col-sm-12 col-md-3 col-lg-3 col-xl-3">
                    <a href="manageDailyActivityReport">
                        <button type="button" class="large-btn btn btn-dark">Daily Activity Report</button></a>
                </div>
                <div class="col-sm-12 col-md-3 col-lg-3 col-xl-3">
                    <a href="kitchenReport">
                        <button type="button" class="large-btn btn btn-dark">Kitchen Report</button></a>
                </div>

            </div>
            <%--/Button--%>

            <%--///////////////////////////////////////////////////////////////////////////////////////////////////////////--%>

            <%--Chart Income--%>
            <%--Chart Today--%>
            <div class="col-sm-12 col-md-6 col-lg-6 col-xl-6">

                <div id="chartdiv"></div>
                <br>
                <P><h6>Today Income</h6></P>
            </div>
            <%--/Chart Today--%>
            <%--Chart Yesterday--%>
            <div class="col-sm-12 col-md-6 col-lg-6 col-xl-6">

                <div id="chartdiv1"></div>
                <br>
                <P><h6>Yesterday Income</h6></P>
            </div>
            <%--/Chart Yesterday--%>
            <%--/Chart Income--%>

            <%--/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////--%>


        </div>
    </div>
    <!-- /page content -->

    <!-- footer content -->
    <jsp:include page="footer.jsp"/>
    <!-- /footer content -->
</div>
</div>
<%--Pie Chart 1--%>
<script>
    am4core.ready(function () {

// Themes begin
        am4core.useTheme(am4themes_moonrisekingdom);
        am4core.useTheme(am4themes_animated);
// Themes end

        var chart = am4core.create("chartdiv", am4charts.PieChart3D);
        chart.hiddenState.properties.opacity = 0; // this creates initial fade-in

        chart.legend = new am4charts.Legend();

        chart.data = [
            {
                country: "Reservation",
                litres: 32501.9
            },
            {
                country: "Restaurant",
                litres: 12301.9
            },
            {
                country: "Bar",
                litres: 23201.1
            },
            {
                country: "Banquet",
                litres: 42165.8
            }

        ];

        var series = chart.series.push(new am4charts.PieSeries3D());
        series.dataFields.value = "litres";
        series.dataFields.category = "country";

    });
</script>
<%--/Pie Chart 1--%>

<%--Pie Chart 2--%>
<script>
    am4core.ready(function () {

// Themes begin
        am4core.useTheme(am4themes_spiritedaway);
        am4core.useTheme(am4themes_animated);
// Themes end

        var chart = am4core.create("chartdiv1", am4charts.PieChart3D);
        chart.hiddenState.properties.opacity = 0; // this creates initial fade-in

        chart.legend = new am4charts.Legend();

        chart.data = [
            {
                country: "Reservation",
                litres: 35101.9
            },
            {
                country: "Restaurant",
                litres: 31301.9
            },
            {
                country: "Bar",
                litres: 22101.1
            },

            {
                country: "Banquet",
                litres: 21150
            }
        ];

        var series = chart.series.push(new am4charts.PieSeries3D());
        series.dataFields.value = "litres";
        series.dataFields.category = "country";

    });

</script>
<%--/Pie Chart 2--%>

<!-- jQuery -->
<script src="../../vendors/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap -->
<script src="../../vendors/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
<!-- Custom Theme Scripts -->
<script src="../../build/js/custom.min.js"></script>

</body>
</html>