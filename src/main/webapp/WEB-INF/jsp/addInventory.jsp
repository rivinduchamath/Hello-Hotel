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


        <c:choose>
            <c:when test="${mode=='MODE_REGISTER' }">
                <!-- page content -->
                <div class="right_col" role="main">
                    <div class="">
                        <div class="page-title">
                            <div class="title_left">
                                <h3>Add Item <small>Hotel Hareesha</small></h3>
                                <div class="col-6 col-sm-6 col-md-6 col-lg-4 col-xl-4">
                                    <a href="/inventory">
                                        <button type="button" class="large-btn btn btn-dark"><i
                                                class="fa fa-mail-reply">
                                            Back</i>
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
                                <%--Start Form Data Size 12--%>
                            <div class="col-md-12 col-sm-12 ">
                                <div class="x_panel">
                                    <div class="x_title">
                                        <h2>Inventory<small>Manage</small></h2>
                                        <ul class="nav navbar-right panel_toolbox">
                                            <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                                            </li>
                                            <li class="dropdown">
                                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                                                   aria-expanded="false"><i class="fa fa-wrench"></i></a>
                                                <ul class="dropdown-menu" role="menu">
                                                    <li><a href="#">Settings 1</a>
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
                                        <div id="" class="form_wizard wizard_horizontal">

                                            <div id="step-1">
                                                <form class="form-horizontal form-label-left" method="post"
                                                      action="inventoryItemSave"
                                                      name="inventoryItemSave">
                                                        <%--Form Divide to 2 parts Size 6 LEFT SIDE--%>
                                                    <div class="col-md-6 col-sm-6 ">
                                                            <%--Item Id Auto Fill--%>
                                                        <div class="form-group row">
                                                            <label class="col-form-label col-md-11 col-sm-11"
                                                                   for="itemId">Item Id<span class="required">*</span>
                                                            </label>
                                                            <div class="col-md-11 col-sm-11 ">
                                                                <input type="text" value="${itemId}" id="itemId"
                                                                       name="inventoryId" required="required"
                                                                       class="form-control  ">
                                                            </div>
                                                        </div>
                                                            <%--Item Name--%>
                                                        <div class="form-group row">
                                                            <label class="col-form-label col-md-11 col-sm-11 "
                                                                   for="title">Title<span
                                                                    class="required">*</span>
                                                            </label>
                                                            <div class="col-md-11 col-sm-11 ">
                                                                <input type="text" id="title" name="text"
                                                                       required="required"
                                                                       class="form-control ">
                                                            </div>
                                                        </div>

                                                            <%--Item Description--%>
                                                        <div class="form-group row">
                                                            <label class="col-form-label col-md-11 col-sm-11 "
                                                                   for="title">Description<span
                                                                    class="required">*</span>
                                                            </label>
                                                            <div class="col-md-11 col-sm-11 ">
                                                        <textarea type="text" class="form-control"
                                                                  style="height: 70px !important;"
                                                                  required="required" name="description"
                                                                  id="description"></textarea>
                                                            </div>
                                                        </div>
                                                            <%--Item Qty Now In--%>
                                                        <div class="form-group row">
                                                            <label class="col-form-label col-md-11 col-sm-11"
                                                                   for="title">Qty On Hand<span
                                                                    class="required">*</span>
                                                            </label>
                                                            <div class="col-md-11 col-sm-11 ">
                                                                <input type="text" class="form-control"
                                                                       required="required" name="orderQty"
                                                                       id="qty"/>
                                                            </div>
                                                        </div>

                                                        <div class="form-group row">
                                                            <label class="col-form-label col-md-11 col-sm-11"
                                                                   for="title">Item Type<span
                                                                    class="required">*</span>
                                                            </label>
                                                            <div class="col-md-11 col-sm-11 ">
                                                                <select id="setType" class="form-control"
                                                                        style="width: 100%; border-color: lightgray"
                                                                        name="type">
                                                                    <c:forEach items="${loadItemType}" var="category">
                                                                        <option value="${category.userType}"
                                                                                <c:if test="${category.id eq p}">selected="selected"</c:if> >
                                                                                ${category.userType}
                                                                        </option>
                                                                    </c:forEach>
                                                                </select>
                                                            </div>
                                                        </div>
                                                    </div>
                                                        <%--Form Divide to 2 parts Size 6 RIGHT SIDE--%>
                                                    <div class="col-md-6 col-sm-6 ">
                                                            <%--Limit to Auto Notify--%>
                                                        <div class="form-group row">
                                                            <label class="col-form-label col-md-11 col-sm-11"
                                                                   for="title">Limit<span
                                                                    class="required">*</span>
                                                            </label>
                                                            <div class="col-md-11 col-sm-11 ">
                                                                <input type="text" class="form-control"
                                                                       required="required" name="orderLimit"
                                                                       id="limit"/>
                                                            </div>
                                                        </div>

                                                        <div class="form-group row">
                                                            <label class="col-form-label col-md-11 col-sm-11 "
                                                                   for="title">Price<span
                                                                    class="required">*</span>
                                                            </label>
                                                            <div class="col-md-11 col-sm-11 ">
                                                                <input type="text" id="price" name="getPrice"
                                                                       required="required"
                                                                       class="form-control ">
                                                            </div>
                                                        </div>


                                                        <div class="form-group row">
                                                            <label class="col-form-label col-md-11 col-sm-11 "
                                                                   for="title">Selling
                                                                Price<span
                                                                        class="required">*</span>
                                                            </label>
                                                            <div class="col-md-11 col-sm-11 ">
                                                                <input type="text" class="form-control"
                                                                       required="required" name="sellingPrice"
                                                                       id="sellingPrice"/>
                                                            </div>
                                                        </div>

                                                        <div class="form-group row">
                                                            <label class="col-form-label col-md-11 col-sm-11"
                                                                   for="date">Date</label>
                                                            <div class="col-md-11 col-sm-11 ">
                                                                <input id="date" class="date-picker form-control"
                                                                       type="date"
                                                                       name="date">
                                                            </div>
                                                        </div>
                                                    </div>

                                                    <button type='submit' class="btn btn-primary"
                                                            style="margin-left: 1.5%; width: 12%" value="Register">
                                                        Save
                                                    </button>

                                                </form>
                                            </div>
                                        </div>
                                        <!-- End SmartWizard Content -->
                                    </div>
                                </div>
                            </div>


                            <div class="x_content">

                                <table id="datatable-buttons" class="table table-striped table-bordered">
                                    <thead>
                                    <tr style="text-align: center">
                                        <th>#</th>
                                        <th>Title</th>
                                        <th>Description</th>
                                        <th>Qty</th>
                                        <th>Type</th>
                                        <th>Limit</th>
                                        <th>Price</th>
                                        <th>Selling Price</th>
                                        <th>Date</th>
                                        <th>#Edit</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${loadInventoryItemTable}" var="a">
                                        <tr style="text-align: center">
                                            <td>${a.inventoryId}</td>
                                            <td style="font-weight: bold">${a.text}</td>
                                            <td>${a.description}</td>
                                            <td>${a.orderQty}</td>
                                            <td>${a.type}</td>
                                            <td>${a.orderLimit}</td>
                                            <td>${a.getPrice}</td>
                                            <td>${a.sellingPrice}</td>
                                            <td>${a.date}</td>
                                            <td>
                                                <a style="color: white;font-weight: bold" onclick="getValue();"
                                                   class="btn  btn-xs">
                                                    <i style="color: #0b2e13" class="fa fa-pencil"></i> </a>
                                                <a href="/delete?noticeId=${a.inventoryId}" class="btn btn-xs">
                                                    <i class="fa fa-trash-o"></i></a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>


                            </div>
                        </div>
                    </div>
                </div>


            </c:when>
            <c:when test="${mode=='MODE_UPDATE' }">
                <link rel="stylesheet"
                      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
                <style>


                    .topnav a {
                        float: left;
                    }

                    .topnav a:hover {
                        background-color: #ddd;
                        color: black;
                    }

                    .topnav a.active {
                        background-color: #2196F3;
                        color: white;
                    }

                    .topnav .search-container {
                        float: right;
                    }

                    .topnav input[type=text] {
                        padding: 6px;
                        margin-top: 8px;
                        font-size: 17px;
                        border: none;
                    }

                    .topnav .search-container button {
                        float: right;
                        padding: 6px 10px;
                        margin-top: 8px;
                        margin-right: 16px;
                        background: #ddd;
                        font-size: 17px;
                        border: none;
                        cursor: pointer;
                    }

                    .topnav .search-container button:hover {
                        background: #ccc;
                    }

                    @media screen and (max-width: 600px) {
                        .topnav .search-container {
                            float: none;
                        }

                        .topnav a, .topnav input[type=text], .topnav .search-container button {
                            float: none;
                            display: block;
                            text-align: left;
                            width: 100%;
                            margin: 0;
                            padding: 14px;
                        }

                        .topnav input[type=text] {
                            border: 1px solid #ccc;
                        }
                    }
                </style>
                <div class="right_col" role="main">
                    <div class="topnav">
                        <div class="search-container">
                            <form action="/action_page.php">
                                <input type="text" placeholder="Search.." name="search">
                                <button type="submit"><i class="fa fa-search"></i></button>
                            </form>
                        </div>
                    </div>

                </div>
            </c:when>

<%--%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%--%>
            <c:when test="${mode=='MODE_WATCH' }">
        <div class="right_col" role="main">


                <div class="col-sm-12 col-md-12 col-lg-12 col-xl-12">

                    <div class="x_panel">
                        <div class="x_title">
                            <h2>All Notice
                                <small>Notice</small>
                            </h2>
                            <div class="col-12 col-sm-12 col-md-12 col-lg-12 col-xl-12">
                                <div class="col-6 col-sm-6 col-md-6 col-lg-6 col-xl-3">
                                    <a href="inventory">
                                        <button type="button" class="btn btn-dark"><i class="fa fa-mail-reply"> Back</i>
                                        </button>
                                    </a>

                                </div>
                            </div>
                            <ul class="nav navbar-right panel_toolbox">

                            </ul>
                            <div class="clearfix"></div>
                        </div>
                        <div class="x_content">
                            <div class="row">
                                <div class="col-sm-12">
                                    <div class="card-box table-responsive">

                                        <table style="text-align: center" id="datatable-buttons"
                                               class="table table-striped table-bordered">
                                            <thead class="thead-light">
                                            <tr>

                                                <th>Item Id</th>
                                                <th>Item Name</th>
                                                <th>Department</th>
                                                <th>Order Qty</th>
                                                <th>Qty On Hand</th>
                                                <th>Required Qty</th>
                                                <th>Date</th>
                                                <th>Expected Date</th>
                                                <th>Order Holder</th>
                                                <th>Add Item</th>
                                                <th>State</th>
                                            </tr>


                                            </thead>
                                            <tbody>
                                            <c:forEach items="${loadInventoryNoticeItemTable}" var="e">
                                                <tr>

                                                    <td>${e.inventoryId}</td>
                                                    <td>${e.text}</td>
                                                    <td>${e.department}</td>
                                                    <td>${e.orderQty}</td>
                                                    <td>${e.qtyOnHand}</td>
                                                    <td>
                                                            ${e.qtyOnHand > e.orderQty ? 0.0 : e.orderQty-e.qtyOnHand}
                                                    </td>
                                                    <td>${e.date}</td>
                                                    <td>${e.expDate}</td>
                                                    <td>${e.orderHolder}</td>
                                                    <td style="width: 20%" >
                                                        <form action="updateQtyToday1" method="post">
                                                            <div class="input-group" >
                                                                <input style="display: none" value="${e.inventoryId}" type="text" class="form-control" name="inventoryId">
                                                                <input required type="number" class="form-control" name="orderQty">
                                                                <span class="input-group-btn">
                                                                     <button type="submit" style="font-weight: bolder;
                                                                      background-color: white; color: #b3adad;
                                                                      border: #0f0f0f solid 1px"
                                                                             class="btn">+</button>
                                                                    </span>
                                                            </div>
                                                        </form>
                                                    </td>
                                                    <td>
                                                                     ${e.qtyOnHand < e.orderQty ? "Incomplete" : "Complete"}

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
<%--                ///////////////////////////////////////////////////////////////////--%>
                  </c:when>
        </c:choose>
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
            $("#itemId").val($(this).find("td:first-child").text());
            $("#title").val($(this).find("td:nth-child(2)").text());
            $("#description").val($(this).find("td:nth-child(3)").text());
            $("#qty").val($(this).find("td:nth-child(4)").text());
            $("#setType").val($(this).find("td:nth-child(5)").text());
            $("#limit").val($(this).find("td:nth-child(6)").text());
            $("#price").val($(this).find("td:nth-child(7)").text());
            $("#sellingPrice").val($(this).find("td:nth-child(8)").text());
            $("#date").val($(this).find("td:nth-child(9)").text());
            selectedRow.addClass('row-selected');
        });
    }
</script>


<!-- Datatables -->
<script src="../../vendors/datatables.net/js/jquery.dataTables.min.js"></script>
<script src="../../vendors/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
<script src="../../vendors/datatables.net-buttons/js/dataTables.buttons.min.js"></script>


<script src="../../vendors/datatables.net-buttons/js/buttons.html5.min.js"></script>
<script src="../../vendors/datatables.net-buttons/js/buttons.print.min.js"></script>
<script src="../../vendors/datatables.net-fixedheader/js/dataTables.fixedHeader.min.js"></script>
<script src="../../vendors/datatables.net-keytable/js/dataTables.keyTable.min.js"></script>

</body>
</html>