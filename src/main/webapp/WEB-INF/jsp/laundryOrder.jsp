<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="lk.sliit.hotelManagement.dto.beverage.BarOrderDTO" %>
<%@ page import="java.awt.*" %>

<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="../../vendors/iCheck/skins/flat/green.css" rel="stylesheet">
    <!-- Bootstrap -->
    <link href="../../vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="../../vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="../../vendors/nprogress/nprogress.css" rel="stylesheet">
    <!-- iCheck -->
    <link href="../../vendors/iCheck/skins/flat/green.css" rel="stylesheet">
    <link rel="icon" type="image/png" href="../../images/icons/gdfgd.png"/>
    <!-- Bootstrap -->
    <link href="../../vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="../../vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="../../vendors/nprogress/nprogress.css" rel="stylesheet">
    <!-- iCheck -->
    <link href="../../vendors/iCheck/skins/flat/green.css" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="../../build/css/custom.min.css" rel="stylesheet">
    <link href="cdn.datatables.net/1.10.20/css/jquery.dataTables.min.css">
    <link href="../../vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="../../vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="../../vendors/nprogress/nprogress.css" rel="stylesheet">
    <!-- iCheck -->
    <link href="../../vendors/iCheck/skins/flat/green.css" rel="stylesheet">
    <!-- Datatables -->

    <link href="../../vendors/datatables.net-bs/css/dataTables.bootstrap.min.css" rel="stylesheet">
    <link href="../../vendors/datatables.net-buttons-bs/css/buttons.bootstrap.min.css" rel="stylesheet">
    <link href="../../vendors/datatables.net-fixedheader-bs/css/fixedHeader.bootstrap.min.css" rel="stylesheet">
    <link href="../../vendors/datatables.net-responsive-bs/css/responsive.bootstrap.min.css" rel="stylesheet">
    <link href="../../vendors/datatables.net-scroller-bs/css/scroller.bootstrap.min.css" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="../../build/css/custom.min.css" rel="stylesheet">
    <link href="../../css/common.css" rel="stylesheet">
    <!-- Custom Theme Style -->
    <link href="../../build/css/custom.min.css" rel="stylesheet">
    <%
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String date = sdf.format(new Date());
    %>

    <%
        if(request.getAttribute("notSelectCustomer") != null){
    %>
    <script>alert("Please Select Customer From Table")</script>
    <%
        }
    %>
    <c:if test="${not empty loginError}">
        <script>
            window.addEventListener("load", function () {
                alert("${loginError}");
            })
        </script>
    </c:if>
    <script>
        function myFunction() {
            // Declare variables
            var input, filter, table, tr, td, i, txtValue;
            input = document.getElementById("search");
            filter = input.value.toUpperCase();
            table = document.getElementById("dataTablesButton1");
            tr = table.getElementsByTagName("tr");
            // Loop through all table rows, and hide those who don't match the search query
            for (i = 0; i < tr.length; i++) {
                td = tr[i].getElementsByTagName("td")[0];
                if (td) {
                    txtValue = td.textContent || td.innerText;
                    if (txtValue.toUpperCase().indexOf(filter) > -1) {
                        tr[i].style.display = "";
                    } else {
                        tr[i].style.display = "none";
                    }
                }
            }
        }
    </script>


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
                        <h3>Laundry Orders
                            <small> +New Order</small>
                        </h3>
                        <div class="col-12 col-sm-12 col-md-12 col-lg-12 col-xl-12">
                            <div class="col-6 col-sm-6 col-md-6 col-lg-6 col-xl-3">
                                <a href="/housekeeping">
                                    <button type="button" class="large-btn btn btn-dark"><i class="fa fa-mail-reply">
                                        Back</i>
                                    </button>
                                </a>

                            </div>
                        </div>
                    </div>

                    <div class="title_right">
                        <div class="col-md-5 col-sm-5   form-group pull-right top_search">
                            <a href="/allLaundryOrders">
                                <button type='submit' class="btn btn-secondary" style="width: 50%;float: right"
                                        value="Register">
                                    List All Payment
                                </button>
                            </a>
                        </div>
                    </div>
                </div>

                <div class="clearfix"></div>
                <div class=" ">
                    <div class="col-sm-12 col-md-12 col-lg-3 col-xl-3" style="float: left">
                        <form method="POST" action="laundryOrder" name="addLaundry">

                            <div class="form-group">
                                <input type="hidden" class="form-control"
                                       required="required" name="laundryId"value="0"
                                       id="laundryId"/>
                                <label >Customer Id</label>
                                <input type="text" class="form-control"
                                       required name="customerId" readonly  value="0"
                                       id="itemCode" placeholder="Customer Id"/>
                                <label >Customer Name</label>
                                <input type="text" class="form-control" readonly
                                       required name="customerName"
                                       id="name" placeholder="Customer Name"/>

                                <label>Number of pieces</label>
                                <input type="number" class="form-control"
                                       required="required" name="pieces"
                                       id="pieces" placeholder="Number of pieces"/>
                            </div>

                            <div class="form-group">
                                <label >Expected Date</label>
                                <input type="date" class="form-control"
                                       required="required" name="expectedDate"
                                       placeholder="Expected Date"/>


                            </div>



                            <button type='submit' class="btn btn-dark" style="width: 50%; top: 20px; position: relative" id="btnAdd"
                                    value="Register">
                                Submit
                            </button>
                            <button type='reset' class="btn btn-outline-success" style="top: 20px; position: relative"
                                    value="">Reset
                            </button>

                        </form>

                    </div>
                    <!--////////////////////////////////////////////-->
                    <div class="col-sm-12 col-md-12 col-lg-3 col-xl-3" style="position: relative;display: inline-block">
                        <div class="x_panel">
                            <div class="x_title">
                                <h2>Items
                                    <small>Click row</small>
                                </h2>
                                <ul class="nav navbar-right panel_toolbox">
                                    <li>
                                        <a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                                    </li>
                                </ul>
                                <div class="clearfix"></div>
                            </div>
                            <div class="x_content">
                                <div class="row">
                                    <div class="col-sm-12">
                                        <div class="card-box table-responsive">
                                            <p class="text-muted font-13 m-b-30">

                                            </p>

                                            <table style="text-align: center" id="dataTablesButton1"
                                                   class="table table-hover table-striped">
                                                <thead class="thead-dark">
                                                <tr>
                                                    <th scope="col">Name</th>
                                                    <th scope="col">Id</th>
                                                </tr>
                                                </thead>
                                                <tbody>
                                                <c:forEach items="${customerAllIn}" var="e">

                                                    <tr>
                                                        <td>${e.name}</td>
                                                        <td scope="row">${e.customerId}</td>

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

                    <div class="col-sm-12 col-md-12 col-lg-6 col-xl-6"
                         style="float: right; position: relative;display: inline-block">
                        <div class="x_panel">
                            <div class="x_title">
                                <h2>Processing Orders
                                    <small>
                                    </small>

                                </h2>

                                <div class="clearfix"></div>
                            </div>
                            <div class="x_content">
                                <div class="row">
                                    <div class="col-sm-12">
                                        <div class="card-box table-responsive">
                                            <table style="text-align: center"
                                                   class="table table-striped jambo_table bulk_action table-bordered">
                                                <thead class="thead-dark">
                                                <tr>
                                                    <th>Customer Id</th>
                                                    <th>Pieces</th>
                                                    <th>Expected Date</th>
                                                    <th>Date</th>
                                                    <th>Order Holder</th>

                                                </tr>
                                                </thead>

                                                <tbody id="tblOrder">
                                      <c:forEach items="${viewProcessing}" var="e">
                                          <tr>
                                              <td>${e.customerId}</td>
                                              <td>${e.pieces}</td>
                                              <td>${e.expectedDate}</td>
                                              <td>${e.date}</td>
                                              <td scope="row">${e.orderHolder}</td>

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
                    <!--///////////////////////////////////////////////////////-->
                </div>
            </div>

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
<!-- FastClick -->
<script src="../../vendors/fastclick/lib/fastclick.js"></script>
<!-- NProgress -->
<script src="../../vendors/nprogress/nprogress.js"></script>
<!-- iCheck -->
<script src="../../vendors/iCheck/icheck.min.js"></script>
<!-- jQuery -->
<script src="../../vendors/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap -->
<script src="../../vendors/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
<!-- FastClick -->
<script src="../../vendors/fastclick/lib/fastclick.js"></script>
<!-- NProgress -->
<script src="../../vendors/nprogress/nprogress.js"></script>
<!-- iCheck -->
<script src="../../vendors/iCheck/icheck.min.js"></script>

<script>
    var selectedRow = null;
    $("#dataTablesButton1 tbody").on('click', 'tr', function () {
        var date = new Date();
        var date2 = new Date();
        var today = date.getDate() + ":" + (date.getMonth()) + ":" + date.getFullYear();
        selectedRow = $(this);
        $("#name").val($(this).find("td:nth-child(1)").text());
        $("#itemCode").val($(this).find("td:nth-child(2)").text());

        $("#dataTablesButton1 tbody tr").removeClass('row-selected');
        selectedRow.addClass('row-selected');
    });
</script>



<script> $(document).ready(function () {
    $("#btn_enable").click(function () {
        $("#name").prop("disabled", false);
    });
});
</script>
<script>


    $("#btnAdd").click(function () {
        var itemCode = $('#itemCode').val();
        if (itemCode == "") {
            alert("Please Select Item In Table");
            return;
        }
    })
</script>

<script src="../../vendors/datatables.net/js/jquery.dataTables.min.js"></script>
<script src="../../vendors/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
<script src="../../vendors/datatables.net-buttons/js/dataTables.buttons.min.js"></script>
<script src="../../vendors/datatables.net-buttons-bs/js/buttons.bootstrap.min.js"></script>
<script src="../../vendors/datatables.net-buttons/js/buttons.flash.min.js"></script>
<script src="../../vendors/datatables.net-buttons/js/buttons.html5.min.js"></script>
<script src="../../vendors/datatables.net-buttons/js/buttons.print.min.js"></script>
<script src="../../vendors/datatables.net-fixedheader/js/dataTables.fixedHeader.min.js"></script>
<script src="../../vendors/datatables.net-keytable/js/dataTables.keyTable.min.js"></script>
<script src="../../vendors/datatables.net-responsive/js/dataTables.responsive.min.js"></script>
<script src="../../vendors/datatables.net-responsive-bs/js/responsive.bootstrap.js"></script>
<script src="../../vendors/datatables.net-scroller/js/dataTables.scroller.min.js"></script>
<script src="../../vendors/jszip/dist/jszip.min.js"></script>
<script src="../../vendors/iCheck/icheck.min.js"></script>

<!-- Custom Theme Scripts -->
<script src="../../build/js/custom.min.js"></script>
</body>
</html>