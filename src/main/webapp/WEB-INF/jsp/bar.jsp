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
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.6.0/Chart.min.js"></script>
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
        #backImg{
            background-image: url("../../images/picture.jpg");
        }
        #myVideo {
            position: fixed;
            right: 0;
            bottom: 0;
            top: 110px;
            min-width: 100%;
            min-height: 100%;
        }


        #myBtn {
            width: 200px;
            font-size: 18px;
            padding: 10px;
            border: none;
            background: #000;
            color: #fff;
            cursor: pointer;
        }

        #myBtn:hover {
            background: #ddd;
            color: black;
        }
    </style>
</head>

<body class="nav-md" style="cursor: pointer">
<div class="container body">
    <div class="main_container">
        <div class="col-md-3 left_col">
            <div class="left_col scroll-view">
                <div class="navbar nav_title" style="border: 0;">
                    <a href="dashboard" class="site_title"> <img style="margin-top: -0px; width: 40px;height: 40px"
                                                                 src="../../images/favicon.ico"><span
                            style="margin-top: 20px;">&nbsp;Hotel Hareesha!</span></a>
                </div>

                <div class="clearfix"></div>

                <!-- menu profile quick info -->
                <div class="profile clearfix">
                    <div class="profile_pic" style=" width: 80px;height: 80px">
                        <img src="../../images/icons/${loggerName.pic}" alt="..." class="img-circle profile_img">
                    </div>
                    <div class="profile_info">
                        <span>Welcome,</span>
                        <h2> ${loggerName.name}</h2>
                    </div>
                </div>
                <!-- /menu profile quick info -->

                <br/>

                <!-- sidebar menu -->
                <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
                    <div class="menu_section">
                        <h3>General</h3>
                        <ul class="nav side-menu">
                            <li><a><i class="fa fa-home"></i> Home <span class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu">
                                    <li><a href="dashboard">Dashboard</a></li>
                                </ul>
                            </li>
                            <li><a><i class="fa fa-tasks"></i> Front Desk <span class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu">
                                    <li><a href="reservations">Reservation</a></li>
                                    <li><a href="banquets">BanquetManagement</a></li>
                                </ul>
                            </li>
                            <li><a><i class="fa fa-cutlery"></i> Food and Beverage<span
                                    class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu">
                                    <li><a href="restaurant"> Restaurant </a></li>
                                    <li><a href="bar">Bar Manage</a></li>
                                </ul>
                            </li>
                            <li><a><i class="fa fa-life-buoy"></i> House Keeping <span class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu">
                                    <li><a href="rooms">Room Manage</a></li>
                                </ul>
                            </li>
                            <li><a><i class="fa fa-paw"></i> Kitchen<span
                                    class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu">
                                    <li><a href="kitchen">Kitchen Manage</a></li>
                                </ul>
                            </li>
                            <li><a><i class="fa fa-shopping-cart"></i> Inventory<span
                                    class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu">
                                    <li><a href="inventory">Inventory Manage</a></li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                    <div class="menu_section">
                        <h3>Live On</h3>
                        <ul class="nav side-menu">
                            <li><a><i class="fa fa-gear"></i> Manage System<span
                                    class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu">
                                    <li><a href="notice">Notice Manage</a></li>
                                    <li><a href="manage">Manager</a></li>
                                    <li><a href="hr">HR</a></li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                    <div class="menu_section">
                        <h3>Live On</h3>
                        <ul class="nav side-menu">
                            <li><a><i class="fa fa-anchor"></i> Additional Pages <span
                                    class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu">
                                    <li><a href="contacts">Contacts</a></li>
                                    <li><a href="profile">Profile</a></li>
                                </ul>
                            </li>
                            <li><a><i class="fa fa-ge"></i> Extras <span class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu">
                                    <li><a href="login">Login Page</a></li>
                                    <li><a href="pricing">Pricing Tables</a></li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="sidebar-footer hidden-small">
                    <a data-toggle="tooltip" data-placement="top" title="Settings">
                        <span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
                    </a>
                    <a data-toggle="tooltip" data-placement="top" title="FullScreen">
                        <span class="glyphicon glyphicon-fullscreen" aria-hidden="true"></span>
                    </a>
                    <a data-toggle="tooltip" data-placement="top" title="Lock">
                        <span class="glyphicon glyphicon-eye-close" aria-hidden="true"></span>
                    </a>
                    <a data-toggle="tooltip" data-placement="top" title="Logout" href="login">
                        <span class="glyphicon glyphicon-off" aria-hidden="true"></span>
                    </a>
                </div>
                <!-- /menu footer buttons -->
            </div>
        </div>

        <!-- top navigation -->
        <div class="top_nav">
            <div class="nav_menu">
                <div class="nav toggle">
                    <a id="menu_toggle"><i class="fa fa-bars"></i></a>
                </div>
                <nav class="nav navbar-nav">
                    <ul class=" navbar-right">
                        <li class="nav-item dropdown open" style="padding-left: 15px;">
                            <a href="javascript:;" class="user-profile dropdown-toggle" aria-haspopup="true"
                               id="navbarDropdown" data-toggle="dropdown" aria-expanded="false">
                                <img src="../../images/icons/${loggerName.pic}" alt="">${loggerName.name}
                            </a>
                            <div class="dropdown-menu dropdown-usermenu pull-right" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="javascript:;"> Profile</a>
                                <a class="dropdown-item" href="javascript:;">
                                    <span class="badge bg-red pull-right">50%</span>
                                    <span>Settings</span>
                                </a>
                                <a class="dropdown-item" href="javascript:;">Help</a>
                                <a class="dropdown-item" href="/"><i class="fa fa-sign-out pull-right"></i> Log Out</a>
                            </div>
                        </li>

                    </ul>
                </nav>
            </div>
        </div>
        <!-- /top navigation -->

        <!-- page content -->
        <video autoplay muted loop id="myVideo">
            <source src="../../images/video/red%20wine%20pouring.mp4" type="video/mp4">
        </video>
<%--/////////aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa--%>
        <div id="" class="right_col " role="main" >

            <div class="">
                <div class="page-title">
                    <div class="title_left">
                        <h3>Bar Manage
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

                <%-- ////////////////////////////////////////////// BODY /////////////////////////////////////////////////////////////--%>
                <div class="col-sm-12 col-md-12 col-lg-12 col-xl-12">


                    <div class="col-sm-12 col-md-3 col-lg-3 col-xl-3">
                        <a href="barOrder">
                            <button type="button" class="large-btn btn btn-primary">Order</button></a>
                    </div>

                    <div class="col-sm-12 col-md-3 col-lg-3 col-xl-3">
                        <a href="barStock">
                            <button type="button" class="large-btn btn btn-info">Stock</button></a>
                    </div>

                    <div class="col-sm-12 col-md-3 col-lg-3 col-xl-3">
                        <a href="barBill">
                            <button type="button" class="large-btn btn btn-success">Bills</button></a>
                    </div>

                    <div class="col-sm-12 col-md-3 col-lg-3 col-xl-3">
                        <button type="button" class="large-btn btn btn-danger">Income</button>
                    </div>

                </div>
                <%--%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% Chart Income %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%--%>
                <div class="col-sm-12 col-md-6 col-lg-6 col-xl-6">

                    <div class="container">
                        <canvas id="myChart"></canvas>
                    </div>

                    <script>
                        let myChart = document.getElementById('myChart').getContext('2d');

                        // Global Options
                        Chart.defaults.global.defaultFontFamily = 'Lato';
                        Chart.defaults.global.defaultFontSize = 18;
                        Chart.defaults.global.defaultFontColor = '#4A2D27';

                        let massPopChart = new Chart(myChart, {
                            type: 'line', // bar, horizontalBar, pie, line, doughnut, radar, polarArea
                            data: {
                                labels: ['Sun', 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat'],
                                datasets: [{
                                    label: 'Population',
                                    data: [
                                        2,
                                        4,
                                        6,
                                        65,
                                        6,
                                        43,
                                        23
                                    ],
                                    //backgroundColor:'green',
                                    backgroundColor: [
                                        'rgba(55, 99, 132, 0.6)',
                                        'rgba(54, 162, 235, 0.6)',
                                        'rgba(25, 206, 86, 0.6)',
                                        'rgba(75, 192, 192, 0.6)',
                                        'rgba(13, 102, 255, 0.6)',
                                        'rgba(55, 159, 64, 0.6)',
                                        'rgba(55, 99, 132, 0.6)'
                                    ],
                                    borderWidth: 1,
                                    borderColor: '#4A2D27',
                                    hoverBorderWidth: 3,
                                    hoverBorderColor: '#000'
                                }]
                            },
                            options: {
                                title: {
                                    display: true,
                                    text: 'Last Week Income',
                                    fontSize: 20
                                },
                                legend: {
                                    display: false,
                                    position: 'right',
                                    labels: {
                                        fontColor: ' #ff5733 '
                                    }
                                },
                                layout: {
                                    padding: {
                                        left: 50,
                                        right: 0,
                                        bottom: 0,
                                        top: 0
                                    }
                                },
                                tooltips: {
                                    enabled: true
                                }
                            }
                        });
                    </script>


                </div>
            </div>
            <%--                /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////--%>


            <%--////////////////////////////////////////////////////////////--%>
        </div>
    </div>

    <!-- /page content -->

    <!-- footer content -->
    <footer>
        <div class="pull-right">
            Copyright © Hotel Management 2020.<a href="https://rivinduchamath.github.io/pro/">Created by Rivindu
            Wijayarathna</a>
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
<!-- Custom Theme Scripts -->
<script src="../../build/js/custom.min.js"></script>

</body>
</html>