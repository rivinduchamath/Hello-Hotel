
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import = "java.util.Date" %>
<%@ page import = "java.text.SimpleDateFormat" %>
<html lang="en">

<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <!-- Meta, title, CSS, favicons, etc. -->
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <title>Employee Management</title>

  <!-- Bootstrap -->
  <link href="../../vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
  <!-- Font Awesome -->
  <link href="../../vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
  <!-- NProgress -->
  <link href="../../vendors/nprogress/nprogress.css" rel="stylesheet">
  <link rel="icon" type="image/png" href="../../images/icons/gdfgd.png"/>
  <!-- Custom Theme Style -->
  <link href="../../build/css/custom.min.css" rel="stylesheet">
  <%
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    String date = sdf.format(new Date());
  %>
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
            <h3>Contacts Design</h3>
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

                  document.clock.sivam.value = ((hour<=9) ? "0" + hour : hour) + ":" + min + ":" + sec + add;
                }

                if (document.clock.sivamtime[1].checked) {
                  if (min <= 9) {
                    min = "0" + min; }
                  if (sec <= 9) {
                    sec = "0" + sec; }
                  if (hour < 10) {
                    hour = "0" + hour; }
                  document.clock.sivam.value = hour + ':' + min + ':' + sec;
                }

                setTimeout("formatTime()", 1000);
              }

              window.onload=formatTime;

            </script>
            <form name="clock" style="float: right">
              <table class="clock" width="135">
                <tr>
                  <td class="clock2">
                  </td>
                </tr>
                <tr >
                  <h6  style="color:#73879C; float:right;border: none;background-color: #f6f6f6">
                    <input style="color:#73879C; float:right;border: none;background-color: #f6f6f6" class="clock2" type="text" name="sivam" size="12"><br>
                    <p > <%=date%></p>
                  </h6>

                </tr>
                <tr>
                  <td>
                    <label class="clock3" for="1"><input type="radio"style="display: none" id="1" name="sivamtime" checked></label><br>
                    <label class="clock3" for="2"><input type="radio" style="display: none" id="2" name="sivamtime"></label>
                  </td>
                </tr>
              </table>

            </form>
          </div>
        </div>

        <div class="clearfix"></div>

        <div class="row">
          <div class="x_panel">
            <div class="x_content">
              <div class="col-md-12 col-sm-12  text-center">
                <ul class="pagination pagination-split">
                  <li><a href="#">A</a></li>
                  <li><a href="#">B</a></li>
                  <li><a href="#">C</a></li>
                  <li><a href="#">D</a></li>
                  <li><a href="#">E</a></li>
                  <li>...</li>
                  <li><a href="#">W</a></li>
                  <li><a href="#">X</a></li>
                  <li><a href="#">Y</a></li>
                  <li><a href="#">Z</a></li>
                </ul>
              </div>

              <div class="clearfix"></div>

              <c:forEach items="${countEmployee}" var="e">


                <div class="col-md-4 col-sm-4  profile_details">
                  <div class="well profile_view">
                    <div class="col-sm-12">
                      <h4 class="brief"><i>${e.occupation}</i></h4>
                      <div class="left col-md-7 col-sm-7">
                        <h2>${e.name}</h2>
                        <p><strong>Phone: </strong> ${e.mobileNumber} </p>
                        <ul class="list-unstyled">
                          <li><i class="fa fa-building"></i> Address: ${e.address}</li>
                          <li><i class="fa fa-phone"></i> email: ${e.email} </li>
                        </ul>
                      </div>
                      <div class="right col-md-5 col-sm-5 text-center">
                        <img src="../../images/icons/${e.pic}" width="100" height="100" alt="" class="img-circle img-fluid">
                      </div>
                    </div>
                    <div class=" profile-bottom text-center">
                      <div class=" col-sm-6 emphasis">
                        <p class="ratings">
                          <a>4.0</a>
                          <a href="#"><span class="fa fa-star"></span></a>
                          <a href="#"><span class="fa fa-star"></span></a>
                          <a href="#"><span class="fa fa-star"></span></a>
                          <a href="#"><span class="fa fa-star"></span></a>
                          <a href="#"><span class="fa fa-star-o"></span></a>
                        </p>
                      </div>
                      <div class=" col-sm-6 emphasis">
                        <button type="button" class="btn btn-success btn-sm"> <i class="fa fa-user">
                        </i> <i class="fa fa-comments-o"></i> </button>
                        <button type="button" class="btn btn-primary btn-sm">
                          <i class="fa fa-user"> </i>  <a href="/profiles?idNo=${e.idNo }" style="color: white">View Profile </a>
                        </button>
                      </div>
                    </div>
                  </div>
                </div>
              </c:forEach>


            </div>
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

<!-- Custom Theme Scripts -->
<script src="../../build/js/custom.min.js"></script>
</body>
</html>