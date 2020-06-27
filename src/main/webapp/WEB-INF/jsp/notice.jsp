<%--
  Created by IntelliJ IDEA.
  User: Rivindu Chamath
  Date: 21-May-20
  Time: 3:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
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
                        <h3>Manage Notice <small>Hotel Hareesha</small></h3>
                        <div class="col-6 col-sm-6 col-md-6 col-lg-4 col-xl-4">
                            <a href="/manageUser">
                                <button type="button" class="large-btn btn btn-dark"><i class="fa fa-mail-reply"> Back</i>
                                </button>
                            </a>

                        </div>
                    </div>

                    <div class="title_right">
                        <div class="col-md-12 col-sm-12  form-group row pull-right top_search">

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
                                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                                           aria-expanded="false"><i class="fa fa-wrench"></i></a>
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
                                <p>This is a basic form wizard example that inherits the colors from the selected
                                    scheme.</p>
                                <div id="wizard" class="form_wizard wizard_horizontal">
                                    <ul class="wizard_steps">
                                        <li>
                                            <a href="#step-1">
                                                <span class="step_no">1</span>
                                                <span class="step_descr">
                                              Step 1<br/>
                                              <small>Step 1 description</small>
                                          </span>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="#step-2">
                                                <span class="step_no">2</span>
                                                <span class="step_descr">
                                              Step 2<br/>
                                              <small>Step 2 description</small>
                                          </span>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="#step-3">
                                                <span class="step_no">3</span>
                                                <span class="step_descr">
                                              Step 3<br/>
                                              <small>Step 3 description</small>
                                          </span>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="#step-4">
                                                <span class="step_no">4</span>
                                                <span class="step_descr">
                                              Step 4<br/>
                                              <small>Step 4 description</small>
                                          </span>
                                            </a>
                                        </li>
                                    </ul>
                                    <div id="step-1">
                                        <form class="form-horizontal form-label-left" method="post" action="noticSave"
                                              name="noticSave">

                                            <div class="form-group row">
                                                <label class="col-form-label col-md-3 col-sm-3 label-align"
                                                       for="noticeId">Notice Id<span class="required">*</span>
                                                </label>
                                                <div class="col-md-6 col-sm-6 ">
                                                    <input type="text" value="${noticeID}" readonly id="noticeId"
                                                           name="noticeId" required="required" class="form-control  ">
                                                </div>
                                            </div>

                                            <div class="form-group row">
                                                <label class="col-form-label col-md-3 col-sm-3 label-align" for="title">Title<span
                                                        class="required">*</span>
                                                </label>
                                                <div class="col-md-6 col-sm-6 ">
                                                    <input type="text" id="title" name="title" required="required"
                                                           class="form-control ">
                                                </div>
                                            </div>


                                            <div class="form-group row">
                                                <label class="col-form-label col-md-3 col-sm-3 label-align" for="title">Description<span
                                                        class="required">*</span>
                                                </label>
                                                <div class="col-md-6 col-sm-6 ">
                                                    <input type="text" class="form-control"
                                                           style="height: 70px !important;"
                                                           required="required" name="description"
                                                           id="description"/>
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <label class="col-form-label col-md-3 col-sm-3 label-align" for="date">Date</label>
                                                <div class="col-md-6 col-sm-6 ">
                                                    <input id="date" class="date-picker form-control" type="date"
                                                           name="date">
                                                </div>
                                            </div>
                                            <button type='submit' class="btn btn-primary"
                                                    style=";margin-left: 60%; width: 15%" value="Register">
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
                                        <th width="30%">Title</th>
                                        <th width="40%">Description</th>
                                        <th>Date</th>
                                        <th>#Edit</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${loadNoticeTable}" var="a">
                                        <tr>
                                            <td>${a.noticeId}</td>
                                            <td style="font-weight: bold">${a.title}</td>
                                            <td>${a.description}</td>
                                            <td>${a.date}</td>

                                            <td>
                                                <a style="color: white;font-weight: bold" onclick="getValue();"
                                                   class="btn btn-info btn-xs">
                                                    Update </a>
                                                <a href="delete/${a.noticeId }" class="btn btn-danger btn-xs"><i
                                                        class="fa fa-trash-o"></i>
                                                    Delete </a>

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