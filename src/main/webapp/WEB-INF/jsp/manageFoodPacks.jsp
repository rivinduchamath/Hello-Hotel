
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<html lang="en">
<head>
    <meta content="text/html; charset=UTF-8" http-equiv="Content-Type">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta content="IE=edge" http-equiv="X-UA-Compatible">
    <meta content="width=device-width, initial-scale=1" name="viewport">

    <link href="../../images/icons/gdfgd.png" rel="icon" type="image/png"/>
    <!-- Bootstrap -->
    <link href="../../vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="../../vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- Custom Theme Style -->
    <link href="../../build/css/custom.min.css" rel="stylesheet">


    <!-- Datatables -->
    <link href="../../vendors/datatables.net-bs/css/dataTables.bootstrap.min.css" rel="stylesheet">
    <link href="../../vendors/datatables.net-buttons-bs/css/buttons.bootstrap.min.css" rel="stylesheet">
    <link href="../../vendors/datatables.net-fixedheader-bs/css/fixedHeader.bootstrap.min.css" rel="stylesheet">
    <link href="../../vendors/datatables.net-responsive-bs/css/responsive.bootstrap.min.css" rel="stylesheet">

    <!--Alert box-->
    <script>
        function alertBox(){
            var x = "${alert}";
            if (!(x.trim().length === 0)){
                alert(x);
            }
        }
    </script>

</head>

<body class="nav-md" style="cursor: pointer" onload="alertBox()">
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
                        <h3>Menu Management <small>(Food Package Management)</small></h3>
                    </div>
                </div>
            </div>


            <!--Content//////////////////////////////////////////////////////////////////-->
            <div class="col-sm-12 col-md-12 col-lg-12 col-xl-12">
                <div class="col-6 col-sm-6 col-md-6 col-lg-2 col-xl-2">
                    <a href="/manageMenu">
                        <button type="button" class="large-btn btn btn-dark"><i class="fa fa-mail-reply">
                            Back</i>
                        </button>
                    </a>
                </div>
            </div>

            <div class="col-sm-12 col-md-12 col-lg-12 col-xl-12">
                <!--Add food pack form and food pack table---------------------------------------->

                    <div class="col-sm-12 col-md-6 col-lg-5 col-xl-5">
                        <!--Add food packages form-------------------------------------------------------------------->
                        <div class="row">
                            <div class="col-md-12 col-sm-12 ">
                                <div class="x_panel">
                                    <div class="x_title">
                                        <h2>Add/Update Food Package...</h2>
                                        <ul class="nav navbar-right panel_toolbox">
                                            <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                                            </li>
                                            <li class="dropdown">
                                                <a aria-expanded="false" aria-haspopup="true" class="dropdown-toggle"
                                                   data-toggle="dropdown"
                                                   href="#" role="button"><i
                                                        class="fa fa-wrench"></i></a>
                                            </li>
                                        </ul>
                                        <div class="clearfix"></div>
                                    </div>
                                    <div class="x_content">
                                        <br/>
                                        <form action="FoodPacks" method="post" class="form-horizontal form-label-left"
                                              data-parsley-validate
                                              id="demo-form3">

                                            <input type="hidden" id="packId" value="0" name="menuId">
                                            <div class=" form-group">
                                                <label class=" label-align">Package Name: <span
                                                        class="required">*  &nbsp;</span>
                                                </label>
                                                <div class=" ">
                                                    <input class="form-control " name="name" id="packName"
                                                           required="required"
                                                           type="text">
                                                </div>
                                            </div>
                                            <div class=" form-group">
                                                <label class="label-align">Category: <span class="required">* &nbsp; &nbsp; &nbsp;</span>
                                                </label>
                                                <select class="form-control" required="required" name="type"
                                                        id="packCat">
                                                    <c:forEach items="${menuCategories}" var="item">
                                                        <option>${item}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                            <div class=" form-group">
                                                <label class="label-align">Unit Price: <span class="required">* &nbsp; &nbsp; &nbsp;</span>
                                                </label>
                                                <div class="">
                                                    <input class="form-control" id="unitPrice" name="unitPrice" value="0"
                                                           required="required"
                                                           type="number">
                                                </div>
                                            </div>
                                            <div class=" form-group">
                                                <label class="label-align">Image: <span
                                                        class="required">* &nbsp; &nbsp; &nbsp;</span>
                                                </label>
                                                <br>
                                                <input type="file" name="picture" id="src" style="margin: 5px">
                                                <br><br>
                                            </div>

                                            <div class=" form-group">
                                                <div class=" ">

                                                    <button class="btn btn-dark" type="submit">+ Add / Update</button>
                                                    <button class="btn btn-outline-dark" type="reset">Reset</button>

                                                </div>
                                            </div>

                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-------------------------------------------------------------------------------------------->
                    </div>

                    <!-------------------------------------------------------------------------------->
                    <div class="col-12 col-sm-12 col-md-12 col-lg-7 col-xl-7">
                        <div class="row">
                            <div class="x_panel">
                                <div class="x_title">
                                    <h2>Select Food Package</h2>
                                    <ul class="nav navbar-right panel_toolbox">
                                        <li><a class="collapse-link"></a>
                                        </li>
                                        <li class="dropdown">
                                            <a aria-expanded="false" class="dropdown-toggle" data-toggle="dropdown"
                                               href="#"
                                               role="button"><i class="fa fa-wrench"></i></a>
                                        </li>
                                    </ul>
                                    <div class="clearfix"></div>
                                </div>
                                <div class="x_content">
                                    <div class="row">
                                        <div class="col-sm-12">
                                            <div class="card-box table-responsive">
                                                <table class="table table-striped table-bordered"
                                                       id="datatable-buttons2"
                                                       style="text-align: center">
                                                    <thead class="thead-light">
                                                    <tr>
                                                        <th>Id</th>
                                                        <th>Name</th>
                                                        <th>Type</th>
                                                        <th>Unit Price</th>
                                                        <th></th>

                                                    </tr>

                                                    </thead>
                                                    <tbody>
                                                    <c:forEach items="${loadMenuItemTable}" var="item">
                                                        <tr>
                                                            <td>${item.menuId}</td>
                                                            <td>${item.name}</td>
                                                            <td>${item.type}</td>
                                                            <td>${item.unitPrice}</td>
                                                            <td>
                                                                <form action="editFoodPack" >
                                                                    <input type="hidden" name ="menuId"  value="${item.menuId}">
                                                                    <input type="submit"  value="Manage">
                                                                </form>
                                                            </td>

                                                            <td>
                                                                <a href="deleteFoodPackage/${item.menuId}">
                                                                    <i class="fa fa-trash" style="font-size: 20px"></i>
                                                                </a>
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
                    </div>
                </div>
                <!--Food item table--------------------------------------------------------------->

                <!-------------------------------------------------------------------------------->

            </div>
        </div>
        <!--/Ordered Food Item list table--------------------------------------------------------------->

        <!--/Content/////////////////////////////////////////////////////////////////-->


    </div>
    <!-- /page content -->


    <!-- footer content -->
    <!--jsp:include page="footer.jsp"/-->
    <footer>
        <div class="pull-right">
            Copyright © Hotel Management 2020.<a href="https://rivinduchamath.github.io/pro/">Created by Rivindu
            Wijayarathna</a>
        </div>
        <div class="clearfix">

            <!-- /footer content -->


        </div>
    </footer>
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

<!--%--Responsive Table--%-->
<script src="../../vendors/datatables.net-responsive/js/dataTables.responsive.min.js"></script>
<script src="../../vendors/datatables.net-responsive-bs/js/responsive.bootstrap.js"></script>

<script>

    var selectedRow = null;
    $("#datatable-buttons2 tbody").on('click', 'tr', function () {
        selectedRow = $(this);
        $("#packId").val($(this).find("td:first-child").text());
        $("#packName").val($(this).find("td:nth-child(2)").text());
        $("#packCat").val($(this).find("td:nth-child(3)").text());
        $("#unitPrice").val($(this).find("td:nth-child(4)").text());
        $("#src").val($(this).find("td:nth-child(5)").text());
        selectedRow.addClass('row-selected');
    });
</script>
</body>
</html>