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
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <%
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String date = sdf.format(new Date());
    %>
    <%--Chrat--%>

    <script src="https://www.amcharts.com/lib/4/core.js"></script>
    <script src="https://www.amcharts.com/lib/4/charts.js"></script>
    <script src="https://www.amcharts.com/lib/4/themes/spiritedaway.js"></script>
    <script src="https://www.amcharts.com/lib/4/themes/animated.js"></script>
    <%--/Pie Chrat--%>

    <!-- Datatables -->
    <link href="../../vendors/datatables.net-bs/css/dataTables.bootstrap.min.css" rel="stylesheet">
    <link href="../../vendors/datatables.net-buttons-bs/css/buttons.bootstrap.min.css" rel="stylesheet">
    <link href="../../vendors/datatables.net-fixedheader-bs/css/fixedHeader.bootstrap.min.css" rel="stylesheet">
    <link href="../../vendors/datatables.net-responsive-bs/css/responsive.bootstrap.min.css" rel="stylesheet">

    <style>
        .large-btn {
            height: 40px;
            width: 100%;
            font-family: "Playfair Display", Georgia, "Times New Roman", serif;
            font-weight: bolder;

        }

        .large-btn:hover {
            color: #0f0f0f;
        }

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
            <div class="page-title">
                <div class="title_left">
                    <h3>Edit Menu</h3>
                    <div class="col-12 col-sm-12 col-md-12 col-lg-12 col-xl-12">
                        <div class="col-6 col-sm-6 col-md-6 col-lg-2 col-xl-2">
                            <a href="/kitchen">
                                <button type="button" class="large-btn btn btn-dark"><i class="fa fa-mail-reply">
                                    Back</i>
                                </button>
                            </a>
                        </div>
                        <div class="col-6 col-sm-6 col-md-6 col-lg-6 col-xl-6">
                            <a href="/manageFoodPacks">
                                <button type="button" class="large-btn btn btn-dark">Manage Food Packages</button>
                            </a>
                        </div>
                    </div>
                </div>

                <%--Time--%>
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
            <%--/Time--%>

            <%--Input Feilds--%>

            <%--/Input Feilds--%>
            <!--Content//////////////////////////////////////////////////////////////////-->
            <div class="col-sm-12 col-md-12 col-lg-12 col-xl-12">

                <div class="col-sm-12 col-md-12 col-lg-6 col-xl-6">
                    <!--Add food items form-------------------------------------------------------------------->

                    <div class="row">
                        <div class="col-md-12 col-sm-12 ">
                            <div class="x_panel">
                                <div class="x_title">
                                    <h2>Add/Update Food Item...</h2>
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

                                    <form:form action="saveFoodItem" method="post" modelAttribute="foodItemDTO">
                                        <input class="form-control" name="itemId" value="0" id="itemId" type="hidden" >


                                        <div class=" form-group">
                                            <label class=" label-align"
                                                   for="itemName">Item Name:
                                                <span class="required">*  &nbsp;</span>
                                            </label>
                                            <div class=" ">
                                                <input class="form-control" name="itemName" id="itemName"
                                                       required="required" type="text">
                                            </div>
                                        </div>
                                        <div class=" form-group">
                                            <label class="label-align">Category: <span class="required">* &nbsp; &nbsp; &nbsp;</span>
                                            </label>
                                            <select class="form-control" required="required" name="itemCategory"
                                                    id="itemCat" data-placeholder="Select Category">

                                                <c:forEach items="${foodItemCategories}" var="item">
                                                    <option>${item}</option>
                                                </c:forEach>

                                            </select>
                                        </div>
                                        <div class=" form-group">
                                            <label class="label-align"
                                                   for="unitPrice">Unit Price: <span class="required">* &nbsp; &nbsp; &nbsp;</span>
                                            </label>
                                            <div class="">
                                                <input class="form-control" id="unitPrice" name="unitePrice"
                                                       required="required" type="number">
                                            </div>
                                        </div>
                                        <div class=" form-group">
                                            <div class="col-12 col-sm-12 col-md-12 col-lg-6 col-xl-6"><br>
                                                <div class="col-md-5 col-lg-5 col-xl-5">

                                                    <label for="img-preview">Image</label>
                                                    <div class="img-upload-card ">
                                                        <c:choose>
                                                            <c:when test="${empty foodItemDTO.src}">
                                                                <img src="../../images/icons/food.jpg" id="img-preview"
                                                                     style="width: 100%; height: 40px"/>
                                                            </c:when>
                                                            <c:otherwise>
                                                                <img src="${foodItemDTO.src}" id="img-preview"
                                                                     style="width: 100%;height: 40px"/>
                                                            </c:otherwise>
                                                        </c:choose>
                                                        <label class="file-upload-container" for="file-upload"
                                                               style="font-size: 13px; padding: -10px 5px 0px 5px; height: 30px">
                                                            <input id="file-upload" type="file" style="display:none;">
                                                            Select
                                                        </label>
                                                    </div>
                                                </div>
                                            </div>
                                            <br>
                                            <br>
                                        </div>
                                        <form:hidden id="imgUrl" path="src" value="../../images/icons/food.jpg"/>
                                        <div class=" form-group">
                                            <div class=" ">
                                                <button class="btn btn-dark" type="submit" value="Register">+Add /
                                                    Update
                                                </button>
                                                <button class="btn btn-outline-dark" type="reset">Reset</button>

                                            </div>
                                        </div>
                                    </form:form>
                                </div>
                            </div>
                        </div>
                    </div>

                    <!--/Order items form------------------------------------------------------------------->

                </div>
                <div class="col-sm-12 col-md-12 col-lg-6 col-xl-6">
                    <div class="col-12 col-sm-12 col-md-12 col-lg-12 col-xl-12">
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
                                                <table class="table table-striped table-bordered" id="datatable-buttons"
                                                       style="text-align: center">
                                                    <thead class="thead-light">
                                                    <tr>
                                                        <th>Id</th>
                                                        <th>Item Name</th>
                                                        <th>img</th>
                                                        <th>Category</th>
                                                        <th>Unit Price</th>
                                                        <th></th>

                                                    </tr>

                                                    </thead>
                                                    <tbody>
                                                    <c:forEach items="${loadFoodItemTable}" var="item">
                                                        <tr>
                                                            <td>${item.itemId}</td>
                                                            <td>${item.itemName}</td>
                                                            <td><img src="${item.src}"
                                                                     class="avatar" alt="Avatar"></td>
                                                            <td>${item.itemCategory}</td>
                                                            <td>${item.unitePrice}</td>
                                                            <td><a href="deleteFoodItem/${item.itemId}">
                                                                <i class="fa fa-trash"></i>
                                                            </a></td>
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

        </div>
        <!--/Ordered Food Item list table--------------------------------------------------------------->

        <!--/Content/////////////////////////////////////////////////////////////////-->

    </div>

</div>

<jsp:include page="footer.jsp"/>

<!-- jQuery -->
<script src="../../vendors/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap -->
<script src="../../vendors/bootstrap/dist/js/bootstrap.bundle.min.js"></script>

<!-- Datatables -->
<script src="../../vendors/datatables.net/js/jquery.dataTables.min.js"></script>
<script src="../../vendors/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
<%--Show Print Buttons--%>
<script src="../../vendors/datatables.net-buttons/js/dataTables.buttons.min.js"></script>
<script src="../../vendors/datatables.net-buttons-bs/js/buttons.bootstrap.min.js"></script>
<script src="../../vendors/datatables.net-buttons/js/buttons.flash.min.js"></script>
<script src="../../vendors/datatables.net-buttons/js/buttons.html5.min.js"></script>
<script src="../../vendors/datatables.net-buttons/js/buttons.print.min.js"></script>
<script src="../../vendors/datatables.net-fixedheader/js/dataTables.fixedHeader.min.js"></script>
<script src="../../vendors/datatables.net-keytable/js/dataTables.keyTable.min.js"></script>
<%--Responsive Table--%>
<script src="../../vendors/datatables.net-responsive/js/dataTables.responsive.min.js"></script>
<script src="../../vendors/datatables.net-responsive-bs/js/responsive.bootstrap.js"></script>
<%--<script src="../../vendors/datatables.net-scroller/js/dataTables.scroller.min.js"></script>--%>
<%--Print--%>
<script src="../../vendors/jszip/dist/jszip.min.js"></script>
<!-- Custom Theme Scripts -->
<script src="../../build/js/custom.min.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<script>

    var selectedRow = null;
    $("#datatable-buttons tbody").on('click', 'tr', function () {
        selectedRow = $(this);
        $("#itemId").val($(this).find("td:first-child").text());
        $("#itemName").val($(this).find("td:nth-child(2)").text());
        $("#itemCat").val($(this).find("td:nth-child(4)").text());
        $("#unitPrice").val($(this).find("td:nth-child(5)").text());
        selectedRow.addClass('row-selected');
    });


    let imgPreview = document.getElementById('img-preview');
    let fileUpload = document.getElementById('file-upload');
    let imgUrl = document.getElementById("imgUrl");
    let CLOUDINARY_API_URL = 'https://api.cloudinary.com/v1_1/dwdv5hhga/upload';
    let CLOUDINARY_UPLOAD_PRESET = 'sqdn7zkx';

    fileUpload.addEventListener('change', function (event) {

        let file = event.target.files[0];

        let formData = new FormData();

        formData.append('file', file);

        console.log("form-data", file);

        formData.append('upload_preset', CLOUDINARY_UPLOAD_PRESET);

        axios({
            url: CLOUDINARY_API_URL, method: 'POST', headers: {

                'Content-Type': 'application/x-www-form-urlencoded'
            }, data:

            formData
        }).then(function (res) {
            imgPreview.src = res.data.secure_url;
            imgUrl.value = res.data.secure_url;
        }).catch(function (err) {

            console.error(err);
        });


    });
</script>

</body>
</html>