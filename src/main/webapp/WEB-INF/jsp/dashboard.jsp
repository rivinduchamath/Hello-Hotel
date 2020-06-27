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


    <script src="https://www.amcharts.com/lib/4/core.js"></script>
    <script src="https://www.amcharts.com/lib/4/charts.js"></script>
    <script src="https://www.amcharts.com/lib/4/themes/spiritedaway.js"></script>
    <script src="https://www.amcharts.com/lib/4/themes/animated.js"></script>
    <%
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String date = sdf.format(new Date());
    %>
    <style>

        #chartdiv {
            position: relative;
            top: 40px;
            width: 100%;
            height: 500px;
        }

        #chartdiv1 {
            position: relative;
            top: 40px;
            width: 100%;
            height: 500px;
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
                        <h3>Dashboard
                            <small>Welcome To Hotel Hareesha</small>
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
                <%--//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////--%>

                <div class="col-sm-12 col-md-12 col-lg-12 col-xl-12">

                    <div class="row">

                        <div class="col-md-12 col-sm-12 ">
                            <div class="x_panel">
                                <div class="row" style="display: inline-block;">
                                    <div class="tile_count">
                                        <div class="col-md-2 col-sm-4 tile_stats_count">
                                            <span class="count_top"><i class="fa fa-user"></i> Total Users</span>

                                            <div class="count green">
                                                32
                                            </div>

                                            <!--/////////////////////////////////////////////-->
                                            <span class="count_bottom"><i class="green">4% </i> From last Week</span>
                                        </div>
                                        <div class="col-md-2 col-sm-4 tile_stats_count">
                                            <span class="count_top"><i class="fa fa-clock-o"></i> Total Time</span>
                                            <div class="count">2332 hrs</div>
                                            <span class="count_bottom"><i class="green"><i
                                                    class="fa fa-sort-asc"></i>3% </i> From Attendance</span>
                                        </div>
                                        <div class="col-md-2 col-sm-4 tile_stats_count">
                                            <span class="count_top"><i class="fa fa-user"></i> Total Males</span>
                                            <div class="count"> 22</div>
                                            <span class="count_bottom"><i class="green"><i
                                                    class="fa fa-sort-asc"></i>34% </i> From last Week</span>
                                        </div>
                                        <div class="col-md-2 col-sm-4 tile_stats_count">
                                            <span class="count_top"><i class="fa fa-user"></i> Total Females</span>
                                            <div class="count"> 42</div>
                                            <span class="count_bottom"><i class="red"><i
                                                    class="fa fa-sort-desc"></i>12% </i> From last Week</span>
                                        </div>
                                        <div class="col-md-2 col-sm-4 tile_stats_count">
                                            <span class="count_top"><i class="fa fa-user"></i> Total Projects</span>
                                            <div class="count">22</div>
                                            <span class="count_bottom"><i class="green"><i
                                                    class="fa fa-sort-asc"></i>34% </i> From last Week</span>
                                        </div>
                                        <div class="col-md-2 col-sm-4 tile_stats_count">
                                            <span class="count_top"><i class="fa fa-user"></i> Today Attendance</span>
                                            <div class="count">22</div>
                                            <span class="count_bottom"><i class="green"><i
                                                    class="fa fa-sort-asc"></i>22%</i> Attendance</span>
                                        </div>
                                    </div>
                                </div>


                            </div>
                        </div>
                    </div>
                </div>
<%--                ////////////////////////////////////////////////////////////////////////////////////--%>
                <div class="col-md-6 col-sm-6  ">
                    <div class="x_panel">
                        <div class="x_title">
                            <h2>Daily active users
                                <small>Sessions</small>
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
                            <ul class="list-unstyled timeline">
                                <c:forEach items="${todayAttendance}" var="e">
                                    <li>
                                        <div class="block">
                                            <div class="tags">
                                                <a href="" class="tag">
                                                    <span><img style="height: 50px;width: 50px;border-radius: 10%"
                                                               src="../../images/icons/${e.employeeID.pic}"></span>
                                                </a>
                                            </div>
                                            <div class="block_content">
                                                <h2 class="title">
                                                    <a>${e.employeeID.name}</a>
                                                </h2>
                                                <div class="byline">
                                                    <span>Position :-</span> <a>${e.employeeID.occupation}</a>
                                                </div>
                                                <p class="excerpt">In Time :- ${e.inTime} <br> OutTime
                                                    :- ${e.outTime}<a></a>
                                                </p>
                                            </div>
                                        </div>
                                    </li>
                                </c:forEach>
                            </ul>

                        </div>
                    </div>
                </div>
<%--                /////////////////////////////////////////////////////////////////////////////////////--%>
                <div class="col-md-6">
                    <div class="x_panel">
                        <div class="x_title">
                            <h2 style="cursor: auto"> Notice
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
                            <ul class="list-unstyled msg_list">
                                <c:forEach items="${loadNoticeTable}" var="q">
                                    <li>
                                        <a>
                        <span class="image">
                        Notice ID :  ${q.noticeId}
                        </span><br>
                                            <span>
                            <span style="font-size: 16px;font-weight: bold">Title : ${q.title}</span><br>
                             <span style="font-size: 14px;font-weight: bold"
                                   class="message">Description : ${q.description}</span>
                       </span>
                                            <span class="">Date : ${q.date}</span>
                                        </a>
                                    </li>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>
                </div>
<%--                ////////////////////////////////////////////////////////////////////////////////--%>
                <div class="col-sm-12 col-md-12 col-lg-12 col-xl-12">
                    <div class="col-sm-12 col-md-7 col-lg-7 col-xl-7">
                        <div id="chartdiv"></div>
                        <br>
                        <P><h6>Today Active Users</h6></P>
                    </div>
                </div>

                <%--///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////--%>
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


<%--Pie Chart 2--%>
<script>
    am4core.ready(function () {

// Themes begin
        am4core.useTheme(am4themes_spiritedaway);
        am4core.useTheme(am4themes_animated);
// Themes end

        /**
         * Chart design taken from Samsung health app
         */

        var chart = am4core.create("chartdiv", am4charts.XYChart);
        chart.hiddenState.properties.opacity = 0; // this creates initial fade-in

        chart.paddingRight = 40;

        chart.data = [{
            "name": "Joey",
            "steps": 35781,
            "href": "https://www.amcharts.com/wp-content/uploads/2019/04/joey.jpg"
        }, {
            "name": "Ross",
            "steps": 25464,
            "href": "https://www.amcharts.com/wp-content/uploads/2019/04/ross.jpg"
        }, {
            "name": "Phoebe",
            "steps": 18788,
            "href": "https://www.amcharts.com/wp-content/uploads/2019/04/phoebe.jpg"
        }, {
            "name": "Rachel",
            "steps": 15465,
            "href": "https://www.amcharts.com/wp-content/uploads/2019/04/rachel.jpg"
        }, {
            "name": "Chandler",
            "steps": 11561,
            "href": "https://www.amcharts.com/wp-content/uploads/2019/04/chandler.jpg"
        }];

        var categoryAxis = chart.yAxes.push(new am4charts.CategoryAxis());
        categoryAxis.dataFields.category = "name";
        categoryAxis.renderer.grid.template.strokeOpacity = 0;
        categoryAxis.renderer.minGridDistance = 10;
        categoryAxis.renderer.labels.template.dx = -40;
        categoryAxis.renderer.minWidth = 120;
        categoryAxis.renderer.tooltip.dx = -40;

        var valueAxis = chart.xAxes.push(new am4charts.ValueAxis());
        valueAxis.renderer.inside = true;
        valueAxis.renderer.labels.template.fillOpacity = 0.3;
        valueAxis.renderer.grid.template.strokeOpacity = 0;
        valueAxis.min = 0;
        valueAxis.cursorTooltipEnabled = false;
        valueAxis.renderer.baseGrid.strokeOpacity = 0;
        valueAxis.renderer.labels.template.dy = 20;

        var series = chart.series.push(new am4charts.ColumnSeries);
        series.dataFields.valueX = "steps";
        series.dataFields.categoryY = "name";
        series.tooltipText = "{valueX.value}";
        series.tooltip.pointerOrientation = "vertical";
        series.tooltip.dy = -30;
        series.columnsContainer.zIndex = 100;

        var columnTemplate = series.columns.template;
        columnTemplate.height = am4core.percent(50);
        columnTemplate.maxHeight = 50;
        columnTemplate.column.cornerRadius(60, 10, 60, 10);
        columnTemplate.strokeOpacity = 0;

        series.heatRules.push({
            target: columnTemplate,
            property: "fill",
            dataField: "valueX",
            min: am4core.color("#e5dc36"),
            max: am4core.color("#5faa46")
        });
        series.mainContainer.mask = undefined;

        var cursor = new am4charts.XYCursor();
        chart.cursor = cursor;
        cursor.lineX.disabled = true;
        cursor.lineY.disabled = true;
        cursor.behavior = "none";

        var bullet = columnTemplate.createChild(am4charts.CircleBullet);
        bullet.circle.radius = 30;
        bullet.valign = "middle";
        bullet.align = "left";
        bullet.isMeasured = true;
        bullet.interactionsEnabled = false;
        bullet.horizontalCenter = "right";
        bullet.interactionsEnabled = false;

        var hoverState = bullet.states.create("hover");
        var outlineCircle = bullet.createChild(am4core.Circle);
        outlineCircle.adapter.add("radius", function (radius, target) {
            var circleBullet = target.parent;
            return circleBullet.circle.pixelRadius + 10;
        })

        var image = bullet.createChild(am4core.Image);
        image.width = 60;
        image.height = 60;
        image.horizontalCenter = "middle";
        image.verticalCenter = "middle";
        image.propertyFields.href = "href";

        image.adapter.add("mask", function (mask, target) {
            var circleBullet = target.parent;
            return circleBullet.circle;
        })

        var previousBullet;
        chart.cursor.events.on("cursorpositionchanged", function (event) {
            var dataItem = series.tooltipDataItem;

            if (dataItem.column) {
                var bullet = dataItem.column.children.getIndex(1);

                if (previousBullet && previousBullet != bullet) {
                    previousBullet.isHover = false;
                }

                if (previousBullet != bullet) {

                    var hs = bullet.states.getKey("hover");
                    hs.properties.dx = dataItem.column.pixelWidth;
                    bullet.isHover = true;

                    previousBullet = bullet;
                }
            }
        })

    }); // end am4core.ready()
</script>

<%--/Pie Chart 2--%>
</body>
</html>