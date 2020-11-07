
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

    <!--Alert box-->
    <script>
        function alertBox(){
            var x = "${alert}";
            if (!(x.trim().length === 0)){
                alert(x);
            }
        }
    </script>

    <!-- Datatables -->
    <link href="../../vendors/datatables.net-bs/css/dataTables.bootstrap.min.css" rel="stylesheet">
    <link href="../../vendors/datatables.net-buttons-bs/css/buttons.bootstrap.min.css" rel="stylesheet">
    <link href="../../vendors/datatables.net-fixedheader-bs/css/fixedHeader.bootstrap.min.css" rel="stylesheet">
    <link href="../../vendors/datatables.net-responsive-bs/css/responsive.bootstrap.min.css" rel="stylesheet">

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
                        <h3>Kitchen Management Dashboard
                            <small>Welcome To Hotel Hareesha</small>
                        </h3>
                    </div>
                </div>
            </div>

            <!--Content//////////////////////////////////////////////////////////////////-->

            <div class="col-sm-12 col-md-12 col-lg-12 col-xl-12">


                <div class="col-sm-12 col-md-3 col-lg-3 col-xl-3">
                    <a href="manageMenu">
                        <button type="button" class="large-btn btn btn-dark">Menu Management</button>
                    </a>
                </div>

                <div class="col-sm-12 col-md-3 col-lg-3 col-xl-3">
                    <a href="banquetFoodOrder">
                        <button type="button" class="large-btn btn btn-dark">Banquet Orders</button>
                    </a>
                </div>

                <div class="col-sm-12 col-md-3 col-lg-3 col-xl-3">
                    <a href="restaurantOrders">
                        <button type="button" class="large-btn btn btn-dark">Restaurant Orders</button>
                    </a>
                </div>

                <div class="col-sm-12 col-md-3 col-lg-3 col-xl-3">
                    <a href="/kitchenReport">
                        <button type="button" class="large-btn btn btn-dark">Daily Food Order Report</button>
                    </a>
                </div>
                <div class="col-sm-12 col-md-12 col-lg-12 col-xl-12">
                    <hr>
                </div>
            </div>

            <div class="col-12 col-sm-12 col-md-12 col-lg-12 col-xl-12">
                <div class="col-12 col-sm-12 col-md-4 col-lg-4 col-xl-4">
                    <div class="row">
                        <div class="x_panel">
                            <div class="x_title">
                                <h2>Food Items on Menu:<br>${breakfast.name} <small>(Breakfast)</small></h2>
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
                                    <div class="col-sm-12" >
                                        <div class="card-box table-responsive">
                                            <table class="table table-striped table-bordered"
                                                   id="datatable-buttons4"
                                                   style="text-align: center">
                                                <thead class="thead-light">
                                                <tr>
                                                    <th>Name</th>
                                                    <th>Type</th>
                                                </tr>

                                                </thead>
                                                <tbody>

                                                <c:forEach items="${breakfastTable}" var="item">
                                                    <tr>
                                                        <td>${item.itemName}</td>
                                                        <td>${item.itemCategory}</td>
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
                <div class="col-12 col-sm-12 col-md-4 col-lg-4 col-xl-4">
                    <div class="row">
                        <div class="x_panel">
                            <div class="x_title">
                                <h2>Food Items on Menu:<br>${lunch.name} <small>(Lunch)</small></h2>
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
                                                   id="datatable-buttons5"
                                                   style="text-align: center">
                                                <thead class="thead-light">
                                                <tr>
                                                    <th>Name</th>
                                                    <th>Type</th>
                                                </tr>

                                                </thead>
                                                <tbody>
                                                <c:forEach items="${lunchTable}" var="item">
                                                    <tr>
                                                        <td>${item.itemName}</td>
                                                        <td>${item.itemCategory}</td>
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
                <div class="col-12 col-sm-12 col-md-4 col-lg-4 col-xl-4">
                    <div class="row">
                        <div class="x_panel">
                            <div class="x_title">
                                <h2>Food Items on Menu:<br>${dinner.name} <small>(Dinner)</small></h2>
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
                                                   id="datatable-buttons3"
                                                   style="text-align: center">
                                                <thead class="thead-light">
                                                <tr>
                                                    <th>Name</th>
                                                    <th>Type</th>
                                                </tr>

                                                </thead>
                                                <tbody>
                                                <c:forEach items="${dinnerTable}" var="item">
                                                    <tr>
                                                        <td>${item.itemName}</td>
                                                        <td>${item.itemCategory}</td>
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

            <div class="col-sm-12 col-md-12 col-lg-12 col-xl-12">
                <!--Order items form-------------------------------------------------------------------->
                <div class="col-sm-12 col-md-12 col-lg-4 col-xl-4">
                    <div class="row">
                        <div class="col-md-12 col-sm-12 ">
                            <div class="x_panel">
                                <div class="x_title">
                                    <h2>Order Food Items Form <small>(Daily food item orders)</small></h2>
                                    <ul class="nav navbar-right panel_toolbox">
                                        <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                                        </li>
                                        <li class="dropdown">
                                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                                               aria-haspopup="true" aria-expanded="false"><i
                                                    class="fa fa-wrench"></i></a>
                                        </li>
                                    </ul>
                                    <div class="clearfix"></div>
                                </div>
                                <div class="x_content">
                                    <br/>
                                    <form action="/kitchen" method="post" id="demo-form2" data-parsley-validate
                                          class="form-horizontal form-label-left">
                                        <input type="hidden" id="foodItemId12" name="foodItemId">
                                        <input type="hidden" name="itemName">

                                        <table style="border: none">

                                            <tr>
                                                <td>
                                                    <div class="item form-group">
                                                        <label class=" label-align">Item ID: <span class="required">*  &nbsp;</span>
                                                        </label>
                                                    </div>
                                                </td>

                                                <td>
                                                    <div class="item form-group">
                                                        <div class=" ">
                                                            <input type="number" disabled id="foodItemId" name="foodItemId" required="required" class="form-control ">
                                                        </div>
                                                    </div>
                                                </td>
                                            </tr>
                                            <!--------Name------------->
                                            <tr>
                                                <td>
                                                    <div class="item form-group">
                                                        <label class=" label-align">Item Name: <span class="required">*  &nbsp;</span>
                                                        </label>
                                                    </div>
                                                </td>

                                                <td>
                                                    <div class="item form-group">
                                                        <div class=" ">
                                                            <input type="text" disabled id="itemName" name="itemName" required="required" class="form-control ">
                                                        </div>
                                                    </div>
                                                </td>
                                            </tr>
                                            <!--------Quantity--------->
                                            <tr>
                                                <td>
                                                    <div class="item form-group">
                                                        <label class="label-align">
                                                            Quantity:<span class="required">* &nbsp;</span>
                                                        </label>
                                                    </div>
                                                </td>

                                                <td>
                                                    <div class="item form-group">
                                                        <div class="">
                                                            <input type="number" id="itemQuantity" name="amount"
                                                                   required="required"
                                                                   class="form-control">
                                                        </div>
                                                    </div>
                                                </td>
                                            </tr>
                                            <!--------Exp date--------->
                                            <tr>

                                                <td>
                                                    <div class="item form-group">
                                                        <label class=" label-align">Expected Date: <span class="required">*  &nbsp;</span>
                                                        </label>
                                                    </div>
                                                </td>

                                                <td>
                                                    <div class="item form-group">
                                                        <div class=" ">
                                                            <input type="date" name="expectedDate"  id="expectedDate" required="required" class="form-control ">
                                                        </div>
                                                    </div>
                                                </td>

                                            </tr>
                                        </table>

                                        <input type="hidden" value="${dailyOrderType}" name="description">

                                        <div class="item form-group">
                                            <div class=" offset-md-3">
                                                <button class="btn btn-primary" type="reset">Reset</button>
                                                <button type="submit" class="btn btn-success">Order</button>
                                            </div>
                                        </div>

                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!--/Order items form------------------------------------------------------------------->

                <!--Food Item list table---------------------------------------------------------------->
                <div class="col-12 col-sm-12 col-md-12 col-lg-4 col-xl-4">
                    <div class="row">
                        <div class="x_panel">
                            <div class="x_title">
                                <h2>Find Food Items
                                    <small>list</small>
                                </h2>
                                <ul class="nav navbar-right panel_toolbox">
                                    <li><a class="collapse-link"></a>
                                    </li>
                                    <li class="dropdown">
                                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                                           aria-expanded="false"><i class="fa fa-wrench"></i></a>
                                    </li>
                                </ul>
                                <div class="clearfix"></div>
                            </div>
                            <div class="x_content">
                                <div class="row">
                                    <div class="col-sm-12">
                                        <div class="card-box table-responsive">
                                            <table id="datatable-foodItem"
                                                   class="table table-striped table-bordered">
                                                <thead class="thead-light">
                                                <tr>
                                                    <th>Id</th>
                                                    <th>Item Name</th>
                                                </tr>

                                                </thead>
                                                <tbody>
                                                <c:forEach items="${loadFoodItemTable}" var="item">
                                                    <tr>
                                                        <td>${item.inventoryId}</td>
                                                        <td>${item.text}</td>
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
                <!--/Food Item list table--------------------------------------------------------------->


                <!--Ordered Food Item list table---------------------------------------------------------------->
                <div class="col-12 col-sm-12 col-md-4 col-lg-4 col-xl-4">
                    <div class="row">
                        <div class="x_panel">
                            <div class="x_title">
                                <h2>Ordered Food Items
                                    <small>list</small>
                                </h2>
                                <ul class="nav navbar-right panel_toolbox">
                                    <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                                    </li>
                                    <li class="dropdown">
                                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                                           aria-expanded="false"><i class="fa fa-wrench"></i></a>
                                    </li>
                                </ul>
                                <div class="clearfix"></div>
                            </div>
                            <div class="x_content">
                                <div class="row">
                                    <div class="col-sm-12">
                                        <div class="card-box table-responsive">
                                            <table id="datatable-orders"
                                                   class="table table-striped table-bordered">
                                                <thead class="thead-light">
                                                <tr>
                                                    <th>Id</th>
                                                    <th>Item Name</th>
                                                    <th>Quantity</th>
                                                    <th>Expected Date</th>
                                                    <th></th>

                                                </tr>

                                                </thead>
                                                <tbody>
                                                <c:forEach items="${loadOrderTable}" var="item">
                                                    <tr>
                                                        <td>${item.foodItemId}</td>
                                                        <td>${item.itemName}</td>
                                                        <td>${item.amount}</td>
                                                        <td>${item.expectedDate}</td>

                                                        <td>
                                                            <form action="/deleteDailyOrder" method="post">
                                                                <input type="hidden" name="orderId" value="${item.orderId}">
                                                                <input type="hidden" name="foodItemId" value="${item.foodItemId}">
                                                                <input type="hidden" name="amount" value="${item.amount}">
                                                                <input type="hidden" name="expectedDate" value="${item.expectedDate}">
                                                                <input type="hidden" name="description" value="${item.description}">

                                                                <label class="btn"
                                                                       data-toggle-class=""
                                                                       data-toggle-passive-class="btn-default">
                                                                    <input type="submit" name="gender" value="-Remove"
                                                                           class="join-btn"><i class="fa fa-trash"></i>
                                                                </label>

                                                            </form>

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
        </div>
        <!--/Ordered Food Item list table--------------------------------------------------------------->


        <!--/Content/////////////////////////////////////////////////////////////////-->


    </div>
    <!-- /page content -->


    <!-- footer content -->
    <jsp:include page="footer.jsp"/>
</div>

<!------/autofill form script ------------------------------------------------->

<!-- jQuery -->
<script src="../../vendors/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap -->
<script src="../../vendors/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
<!-- Custom Theme Scripts -->
<script src="../../build/js/custom.min.js"></script>
<!------autofill form script ------------------------------------------------->
<script>

    var selectedRow = null;
    $("#datatable-foodItem tbody").on('click', 'tr', function () {
        selectedRow = $(this);
        $("#foodItemId").val($(this).find("td:first-child").text());
        $("#foodItemId12").val($(this).find("td:first-child").text());
        $("#itemName").val($(this).find("td:nth-child(2)").text());
        selectedRow.addClass('row-selected');
    });

    $("#datatable-orders tbody").on('click', 'tr', function () {
        selectedRow = $(this);
        $("#foodItemId").val($(this).find("td:first-child").text());
        $("#foodItemId12").val($(this).find("td:first-child").text());
        $("#itemName").val($(this).find("td:nth-child(2)").text());
        $("#itemQuantity").val($(this).find("td:nth-child(3)").text());
        $("#expectedDate").val($(this).find("td:nth-child(4)").text());
        selectedRow.addClass('row-selected');
    });



</script>
<!-- Datatables -->
<script src="../../vendors/datatables.net/js/jquery.dataTables.min.js"></script>
<script src="../../vendors/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>

<!--%--Responsive Table--%-->
<script src="../../vendors/datatables.net-responsive/js/dataTables.responsive.min.js"></script>
<script src="../../vendors/datatables.net-responsive-bs/js/responsive.bootstrap.js"></script>
</body>
</html>