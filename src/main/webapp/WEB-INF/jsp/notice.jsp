<%--
  Created by IntelliJ IDEA.
  User: Rivindu Chamath
  Date: 21-May-20
  Time: 3:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import = "java.util.Date" %>
<%@ page import = "java.text.SimpleDateFormat" %>
<html lang="en">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Employee Management </title>
    <link rel="icon" type="image/png" href="../../images/icons/gdfgd.png"/>
    <!-- Bootstrap -->
    <link href="../../vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="../../vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="../../vendors/nprogress/nprogress.css" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="../../build/css/custom.min.css" rel="stylesheet">

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
                <li><a><i class="fa fa-cutlery"></i> Restaurant<span
                        class="fa fa-chevron-down"></span></a>
                  <ul class="nav child_menu">
                    <li><a href="foodAndBev">F&B</a></li>
                  </ul>
                </li>
                <li><a><i class="fa fa-life-buoy"></i> House Keeping <span class="fa fa-chevron-down"></span></a>
                  <ul class="nav child_menu">
                    <li><a href="rooms">Room Manage</a></li>
                  </ul>
                </li>
                <li><a><i class="fa fa-glass"></i> Bar<span
                        class="fa fa-chevron-down"></span></a>
                  <ul class="nav child_menu">
                    <li><a href="bar">Bar Manage</a></li>
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
        <div class="right_col" role="main">
          <div class="">
            <div class="page-title">
              <div class="title_left">
                <h3>Notice</h3>
              </div>

              <div class="title_right">
                <div class="col-md-5 col-sm-5  form-group row pull-right top_search">
                  <div class="input-group">
                    <input type="text" class="form-control" placeholder="Search for...">
                    <span class="input-group-btn">
                              <button class="btn btn-secondary" type="button">Go!</button>
                          </span>
                  </div>
                </div>
              </div>
            </div>
            <div class="clearfix"></div>

            <div class="row">

              <div class="col-md-12 col-sm-12 ">
                <div class="x_panel">
                  <div class="x_title">
                    <h2>Notice<small>Manage</small></h2>
                    <ul class="nav navbar-right panel_toolbox">
                      <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                      </li>
                      <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a>
                        <ul class="dropdown-menu" role="menu">
                          <li><a href="#">Settings 1</a>
                          </li>
                          <li><a href="#">Settings 2</a>
                          </li>
                        </ul>
                      </li>
                      <li><a class="close-link"><i class="fa fa-close"></i></a>
                      </li>
                    </ul>
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">


                    <!-- Smart Wizard -->
                    <p>This is a basic form wizard example that inherits the colors from the selected scheme.</p>
                    <div id="wizard" class="form_wizard wizard_horizontal">
                      <ul class="wizard_steps">
                        <li>
                          <a href="#step-1">
                            <span class="step_no">1</span>
                            <span class="step_descr">
                                              Step 1<br />
                                              <small>Step 1 description</small>
                                          </span>
                          </a>
                        </li>
                        <li>
                          <a href="#step-2">
                            <span class="step_no">2</span>
                            <span class="step_descr">
                                              Step 2<br />
                                              <small>Step 2 description</small>
                                          </span>
                          </a>
                        </li>
                        <li>
                          <a href="#step-3">
                            <span class="step_no">3</span>
                            <span class="step_descr">
                                              Step 3<br />
                                              <small>Step 3 description</small>
                                          </span>
                          </a>
                        </li>
                        <li>
                          <a href="#step-4">
                            <span class="step_no">4</span>
                            <span class="step_descr">
                                              Step 4<br />
                                              <small>Step 4 description</small>
                                          </span>
                          </a>
                        </li>
                      </ul>
                      <div id="step-1">
                        <form class="form-horizontal form-label-left" method="post" action="noticSave"  name="noticSave" >

                          <div class="form-group row">
                            <label class="col-form-label col-md-3 col-sm-3 label-align" for="noticeId">Notice Id<span class="required">*</span>
                            </label>
                            <div class="col-md-6 col-sm-6 ">
                              <input type="text" value="${noticeID}" readonly  id="noticeId" name="noticeId" required="required" class="form-control  ">
                            </div>
                          </div>

                          <div class="form-group row">
                            <label class="col-form-label col-md-3 col-sm-3 label-align" for="title">Title<span class="required">*</span>
                            </label>
                            <div class="col-md-6 col-sm-6 ">
                              <input type="text" id="title" name="title" required="required" class="form-control ">
                            </div>
                          </div>


                          <div class="form-group row">
                            <label class="col-form-label col-md-3 col-sm-3 label-align" for="title">Description<span class="required">*</span>
                            </label>
                            <div  class="col-md-6 col-sm-6 ">
                            <input type="text" class="form-control" style="height: 70px !important;"
                                   required="required" name="description"
                                   id="description"/>
                          </div>
                          </div>
                          <div class="form-group row">
                            <label  class="col-form-label col-md-3 col-sm-3 label-align" for="date">Date</label>
                            <div class="col-md-6 col-sm-6 ">
                              <input id="date"  class="date-picker form-control" type="date"  name="date">
                            </div>
                          </div>
                          <button type='submit' class="btn btn-primary" style=";margin-left: 60%; width: 15%" value="Register" >
                            Save
                          </button>

                        </form>

                      </div>



                    </div>
                    <!-- End SmartWizard Content -->






          </div>
                  <div class="x_content">

                    <table id="datatable-buttons" class="table table-striped table-bordered">
                      <thead>
                      <tr>
                        <th style="width: 1%">#</th>
                        <th width="30%" >Title</th>
                        <th width="40%">Description</th>
                        <th>Date</th>
                        <th>#Edit</th>
                      </tr>
                      </thead>
                      <tbody>
                      <c:forEach items="${loadTable}" var="a">
                        <tr>
                          <td>${a.noticeId}</td>
                          <td style="font-weight: bold">${a.title}</td>
                          <td>${a.description}</td>
                          <td>${a.date}</td>

                          <td>
                            <a style="color: white;font-weight: bold" onclick="getValue();" class="btn btn-info btn-xs">
                              Update </a>
                            <a href="/delete/?notId=${a.noticeId}" class="btn btn-danger btn-xs"><i class="fa fa-trash-o"></i>
                              Delete </a>
                          </td>
                        </tr>
</c:forEach>
                      </tbody>
                    </table>


                  </div>
                  <footer>

                    <div class="pull-right">
                      Copyright © Employee Management 2020.<a href="https://rivinduchamath.github.io/pro/">Created by Rivindu Wijayarathna</a>
                    </div>
                    <div class="clearfix"></div>
                  </footer>
          </div>
          </div>
          </div>
          </div>
          </div>
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
    <!-- jQuery Smart Wizard -->
    <script src="../../vendors/jQuery-Smart-Wizard/js/jquery.smartWizard.js"></script>
    <!-- Custom Theme Scripts -->
    <script src="../../build/js/custom.min.js"></script>

  <script>

      getValue()


      function getValue() {
          var selectedRow = null;
          $("#datatable-buttons tbody").on('click', 'tr', function () {
              selectedRow = $(this);
              $("#noticeId").val($(this).find("td:first-child").text());
              $("#title").val($(this).find("td:nth-child(2)").text());
              $("#description").val($(this).find("td:nth-child(3)").text());
              $("#date").val($(this).find("td:nth-child(4)").text());
              selectedRow.addClass('row-selected');
          });
      }
  </script>
  </body>
</html>