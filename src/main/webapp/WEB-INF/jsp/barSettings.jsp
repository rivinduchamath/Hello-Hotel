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
                </div>
            </c:when>
            <c:when test="${mode=='MODE_UPDATE' }">

            </c:when>

<%--%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%--%>
            <c:when test="${mode=='MODE_SETTINGS1' }">
        <div class="right_col" role="main">


                <div class="col-sm-12 col-md-12 col-lg-12 col-xl-12">

                    <div class="x_panel">
                        <div class="x_title">
                            <h2>Beverage
                                <small>Settings</small>
                            </h2>
                            <div class="col-12 col-sm-12 col-md-12 col-lg-12 col-xl-12">
                                <div class="col-6 col-sm-6 col-md-6 col-lg-6 col-xl-3">
                                    <a href="bar">
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
                                                <th>Description</th>
                                                <th>Order</th>
                                                <th>Date</th>
                                                <th>Price</th>

                                            </tr>


                                            </thead>
                                            <tbody>
                                            <c:forEach items="${loadInventoryBeverage}" var="e">
                                                <tr>

                                                    <td>${e.inventoryId}</td>
                                                    <td>${e.text}</td>
                                                    <td>${e.description}</td>
                                                    <td>${e.orderQty}</td>
                                                    <td>${e.date}</td>
                                                    <td>${e.getPrice}</td>

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