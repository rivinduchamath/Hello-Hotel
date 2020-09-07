<%--
  Created by IntelliJ IDEA.
  User: Chanuka
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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

    <script>
        function myFunction() {
            // Declare variables
            var input, filter, table, tr, td, i, txtValue;
            input = document.getElementById("myInput");
            filter = input.value.toUpperCase();
            table = document.getElementById("datatable-buttons");
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
                        <h3>Employee Salary >
                            <small>Monthly Salary Manage</small>
                        </h3>
                    </div>

                    <div class="title_right">
                        <div class="col-md-5 col-sm-5   form-group pull-right top_search">
                            <a href="/allSalary">
                            <button  type='submit' class="btn btn-secondary" style="width: 50%;float: right" value="Register" >
                                List All salary
                            </button>
                            </a>
                        </div>
                    </div>
                </div>

                <div class="clearfix"></div>
                 <div class=" ">
                     <div class="col-md-4 col-sm-4 " style="float: left">
                    <form method="POST" action="/salarySave" name="salary">



                            <div class="form-group">
                                <label for="itemCode">Employee Id</label>
                                <input type="text" class="form-control"
                                       required="required" name="employeeID"
                                       id="itemCode" placeholder="Employee Id" />
                            </div>

                            <div class="form-group">
                                <label for="itemCode">Basic Salary</label>
                                <input type="text" class="form-control"
                                       required="required" name="basicSalary"
                                       id="BasicSalary" placeholder="Basic Salary" />
                            </div>

                            <div class="form-group">
                                <label for="itemCode">OT Rate</label>
                                <input type="text" class="form-control"
                                       required="required" name="otRate"
                                       id="OTRate" placeholder="OT Rate" />
                            </div>
                            <div class="form-group">
                                <label for="itemCode">OT Hrs</label>
                                <input type="text" class="form-control"
                                       required="required" name="otHours"
                                       id="OTHrs" placeholder="OT Hrs" />
                            </div>

                            <div class="form-group">
                                <label for="itemCode">Monthly Bonus</label>
                                <input type="text" class="form-control"
                                       required="required" name="bonus"
                                       id="MonthlyBonus"  placeholder="Monthly Bonus" />
                            </div>
                            <div class="form-group">
                                <label for="itemCode">Income Tax</label>
                                <input type="text" class="form-control"
                                       required="required" name="incomeTax"
                                       id="IncomeTax" placeholder="Income Tax" />
                            </div>
                           <input style="display: none" type="text" id="itemPay1" name="SalaryId">
                            <button type='submit' class="btn btn-primary" style="width: 50%" value="Register" >
                                Submit
                            </button>
                            <button onclick="document.getElementsByClassName('form-control').value = ''" type='reset' class="btn btn-outline-success" value="">Reset</button>

                    </form>

                         <a href="/updateSalary"> <button  class="btn btn-info" style="width: 50%" >
                             Update
                         </button></a> </div>
                    <!--////////////////////////////////////////////-->
                    <div class="col-md-8 col-sm-8" style="position: relative;display: inline-block">
                        <div class="x_panel">
                            <div class="x_title">
                                <h2>Employees
                                    <small>Users</small>
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
                                <div class="row">
                                    <div class="col-sm-12">
                                        <div class="card-box table-responsive">
                                            <p class="text-muted font-13 m-b-30">

                                            </p>

                                            <table id="datatable-responsive"
                                                   class="table table-striped table-bordered dt-responsive nowrap"
                                                   cellspacing="0" width="100%">
                                                <thead class="thead-dark">
                                                <tr>
                                                    <th>Employee Name</th>
                                                    <th>Employee ID</th>

                                                </tr>
                                                </thead>
                                                <tbody>
                                                <c:forEach items="${listEmployeesTable}" var="e">
                                                    <tr>
                                                        <td>${e.name}</td>
                                                        <td>${e.idNo}</td>
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

<!--/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////-->

                     <div class="col-md-8 col-sm-8" style="float: right; position: relative;display: inline-block">
                        <div class="x_panel">
                            <div class="x_title">
                                <h2>Employee Monthly Salary
                                    <small>Click CheckBox And Pay Salary
                                    </small>
                                </h2>
                                <form method="POST" action="/invoice" name="invoice">
                                    <input style="display: none" type="text" id="itemPay" name="SalaryId">
                                    <ul class="nav navbar-right panel_toolbox">
                                        <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                                        </li>
                                        <button type="submit" value="Register" disabled="true"
                                                style="font-weight: bold;color: white" ; id="name"
                                                class="btn btn-success "> Pay <i class="fa fa-file-image-o"></i>
                                        </button>
                                    </ul>
                                </form>

                                <button onclick="getValue();return false" ; style="float: right; font-weight: bold;color: white" ;
                                id="btn_enable" class="btn btn-success ">Add Payment
                                    <i class="fa fa-plus-circle"></i></button>

                                <!--href="/invoice"-->
                                <div class="clearfix"></div>
                            </div>

                            <div class="x_content">

                                <div class="row">

                                    <div class="col-sm-12">

                                        <div class="card-box table-responsive">

                                            <table id="datatable-buttons"
                                                   class="table table-striped jambo_table bulk_action table-bordered">
                                                <thead class="thead-dark">

                                                <tr>
                                                    <th>EmpId</th>
                                                    <th>Name</th>
                                                    <th>Total Salary</th>
                                                    <th>Delete</th>
                                                    <th><input type="checkbox" id="check-all" class="flat"></th>
                                                </tr>
                                                </thead>

                                                <tbody>
                                                <c:forEach items="${listEmployeesTableSalary}" var="e">
                                                    <tr>
                                                        <td>${e.employeeID.idNo}</td>
                                                        <td>${e.employeeID.name}</td>
                                                        <td>${((e.basicSalary+e.bonus)+(e.otRate*e.otHours))-e.incomeTax}</td>
                                                        <td><a href="/deleteSalary?idNo=${e.salaryId}"><span
                                                                class="glyphicon glyphicon-trash"></span></a></td>
                                                        <td class="a-center ">
                                                            <input type="checkbox" class="flat checks"
                                                                   value="${e.salaryId}" name="table_records">
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
                    <!--///////////////////////////////////////////////////////-->

                </div>
                </div>

            </div>
        </div>
        <!-- /page content -->


        <script>
            function getValue() {
                var checks = document.getElementsByClassName('checks');
                var str = '';

                for (i = 0; i < ${countEmployee2}; i++) {
                    if (checks[i].checked === true) {
                        str += checks[i].value + " ";
                    }
                }
                $("#itemPay").val(str);
            }
        </script>
        <!-- footer content -->
    <footer>
        <div class="pull-right">
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            Copyright © Employee Management 2020.<a href="https://github.com/rivinduchamath/Hello-Hote/l">
            Created by ITP SLIIT &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  </a>
<%--            Copyright © Employee Management 2020.<a href="https://rivinduchamath.github.io/pro/">Created by Chanuka Mullevidana</a>--%>
        </div>
        <div class="clearfix"></div>
    </footer>
    <!-- /footer content -->
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
    $("#datatable-responsive tbody").on('click', 'tr', function () {
        var date = new Date();
        var date2 = new Date();
        var today = date.getHours() + ":" + (date.getMinutes()) + ":" + date.getSeconds();
        date2.setHours(date.getHours() + 8);
        var today2 = date2.getHours() + ":" + (date.getMinutes()) + ":" + date.getSeconds();
        selectedRow = $(this);
        $("#itemCode").val($(this).find("td:nth-child(2)").text());
        $("#datatable-responsive tbody tr").removeClass('row-selected');
        selectedRow.addClass('row-selected');
    });
</script>

<script> $(document).ready(function () {
    $("#btn_enable").click(function () {
        $("#name").prop("disabled", false);
    });
});
</script>
<!-- Datatables -->
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
