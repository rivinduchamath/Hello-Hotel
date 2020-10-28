<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="../../images/reservation/icons/favicon.png"/>
    <title>Luxury Hotel in Galle | Hotel Hareesha</title>

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--===============================================================================================-->
    <link rel="icon" type="image/png" href="../../images/onlineBookingTable/icons/favicon.png"/>
    <!--===============================================================================================-->
   <!-- <link rel="stylesheet" type="text/css" href="../../vendors/onlineBookingTable/bootstrap/css/bootstrap.min.css"> -->
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="../../fonts/onlineBookingTable/font-awesome-4.7.0/css/font-awesome.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="../../vendors/onlineBookingTable/animate/animate.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="../../vendors/onlineBookingTable/select2/select2.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="../../vendors/onlineBookingTable/perfect-scrollbar/perfect-scrollbar.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="../../css/onlineBookingTable/util.css">
    <link rel="stylesheet" type="text/css" href="../../css/onlineBookingTable/main.css">



    <!-- Bootstrap core CSS -->
    <link href="../../css/onlineRe1/bootstrap.min.css" rel="stylesheet">
    <link href="../../font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
    <!-- Custom styles for this template -->
    <link href="../../css/onlineRe1/style.css" rel="stylesheet">
    <link href="../../fonts/antonio-exotic/stylesheet.css" rel="stylesheet">
    <link rel="stylesheet" href="../../css/onlineRe1/lightbox.min.css">
    <link href="../../css/onlineRe1/responsive.css" rel="stylesheet">

    <!--===============================================================================================-->
</head>
<body>
<div id="page">
    <!---header top---->
    <div class="top-header">
        <div class="container">
            <div class="row">
                <div class="col-md-6">

                </div>
                <div class="col-md-6"><div class="social-grid">
                    <ul class="list-unstyled text-right">
                        <li><a><i class="fa fa-facebook"></i></a></li>
                        <li><a><i class="fa fa-twitter"></i></a></li>
                        <li><a><i class="fa fa-linkedin"></i></a></li>
                        <li><a><i class="fa fa-instagram"></i></a></li>
                    </ul>
                </div></div>
            </div>
        </div>
    </div>
    <!--header--->
    <header class="header-container">
        <div class="container">
            <div class="top-row">
                <div class="row">
                    <div class="col-md-2 col-sm-6 col-xs-6">
                        <div id="logo">
                            <!--<a href="index.html"><img src="images/logo.png" alt="logo"></a>-->
                            <a href="home"><span>Ha</span>reesha</a>
                        </div>
                    </div>
                    <div class="col-sm-6 visible-sm">
                        <div class="text-right"><a href="home" > <button type="button" class="reserved-btn">Submit</button></a></div>
                    </div>
                    <div class="col-md-8 col-sm-12 col-xs-12 remove-padd">
                        <nav class="navbar navbar-default">
                            <div class="navbar-header page-scroll">
                                <button data-target=".navbar-ex1-collapse" data-toggle="collapse" class="navbar-toggle" type="button">
                                    <span class="sr-only">Toggle navigation</span>
                                    <span class="icon-bar"></span>
                                    <span class="icon-bar"></span>
                                    <span class="icon-bar"></span>
                                </button>

                            </div>
                            <div class="collapse navigation navbar-collapse navbar-ex1-collapse remove-space">
                                <ul class="list-unstyled nav1 cl-effect-10">
                                    <li><a  data-hover="Home" href="home"><span>Home</span></a></li>
                                    <li><a data-hover="About"  href="about"><span>About</span></a></li>
                                    <li><a data-hover="Rooms"  class="active"><span>Rooms</span></a></li>
                                    <li><a data-hover="Gallery"  href="gallery"><span>Gallery</span></a></li>
                                    <li><a data-hover="Dinning" href="dinning"><span>Dinning</span></a></li>
                                    <li><a data-hover="News" href="news"><span>News</span></a></li>
                                    <li><a data-hover="Contact Us" href="contact"><span>contact Us</span></a></li>
                                </ul>
                            </div>
                        </nav>
                    </div>

                </div>
                <div class="text-right">
                    <form method="POST" action="saveOnlineRooms" name="saveOnlineRooms">
                        <input style="display: none" readonly required type="text" id="itemPay" name="details">
                        <input style="display: none" readonly required="required" type="date" id="vDate" value="${checkIn}" name="checkIn">
                        <input style="display: none" readonly required ="required"type="date" id="timeIn" value="${checkOut}" name="checkOut">
                        <button type="submit" onclick="getValue()" class="reserved-btn" id="submitButton">Submit</button>
                    </form>
                </div>
            </div>
        </div>
    </header>


    <!--end-->

<div class="limiter">
    <div class="container-table100">
        <div class="wrap-table100">


            <div class="table100 ver2 m-b-110">
                <div class="table100-head">
                    <table>
                        <thead>
                        <tr class="row100 head">
                            <th class="cell100 column1">Room No</th>
                            <th class="cell100 column2">Room Name</th>
                            <th class="cell100 column3">Room Type</th>
                            <th class="cell100 column4">Description</th>
                            <th class="cell100 column5">Room Status</th>

                        </tr>
                        </thead>
                    </table>
                </div>

                <div class="table100-body js-pscroll">
                    <table>
                        <tbody>
                        <c:forEach items="${loadAllTable}" var="a">
                        <tr class="row100 body">
                            <td class="cell100 column1">${a.roomId2}</td>
                            <td class="cell100 column2">${a.roomName}</td>
                            <td class="cell100 column3">${a.type}</td>
                            <td class="cell100 column4">${a.description}</td>
                           <!-- <td class="cell100 column4">${a.status}</td> -->
                            <td class="cell100 column5"><button onclick="myFunction(${a.roomId2})"
                                                                type="button" class="book-now-btn">Book Now</button></td>
                        </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>



            </div>
        </div>
    </div>



<!--===============================================================================================-->
<script src="../../vendors/onlineBookingTable/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
<script src="../../vendors/onlineBookingTable/bootstrap/js/popper.js"></script>
<script src="../../vendors/onlineBookingTable/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
<script src="../../vendors/onlineBookingTable/select2/select2.min.js"></script>
<!--===============================================================================================-->
<script src="../../vendors/onlineBookingTable/perfect-scrollbar/perfect-scrollbar.min.js"></script>
<script>
    $('.js-pscroll').each(function(){
        var ps = new PerfectScrollbar(this);

        $(window).on('resize', function(){
            ps.update();
        })
    });


</script>
<!--===============================================================================================-->
<script src="../../js/onlineBookingTable/main.js"></script>

    <!---footer--->
    <footer>
        <div class="container">
            <div class="row">
                <div class="col-md-3 col-sm-6 col-xs-12 width-set-50">
                    <div class="footer-details">
                        <h4>Get in touch</h4>
                        <ul class="list-unstyled footer-contact-list">
                            <li>
                                <i class="fa fa-map-marker fa-lg"></i>
                                <p> Imduwa Road, Yakkalamulla, Galle, Sri Lanka. </p>
                            </li>
                            <li>
                                <i class="fa fa-phone fa-lg"></i>
                                <p><a href="tel:+94-76-673-7320"> +94-76-6737320 </a></p>
                            </li>
                            <li>
                                <i class="fa fa-envelope-o fa-lg"></i>
                                <p><a href="mailto:mailspringitp@gmail.com"> mailspringitp@gmail.com </a></p>
                            </li>
                        </ul>
                        <div class="footer-social-icon">
                            <a href="https://www.facebook.com/"><i class="fa fa-facebook"></i></a>
                            <a href="https://twitter.com/?lang=en"><i class="fa fa-twitter"></i></a>
                            <a href="https://www.instagram.com/?hl=en"><i class="fa fa-instagram"></i></a>
                            <a href="https://www.google.com/"><i class="fa fa-google-plus"></i></a>
                            <a href="https://www.youtube.com/"><i class="fa fa-youtube-play"></i></a>
                        </div>
                        <div class="input-group" id="subscribe">
                            <input type="text" class="form-control subscribe-box" value="" name="subscribe" placeholder="EMAIL ID">
                            <span class="input-group-btn">
                                        <button type="button" class="btn subscribe-button">
                                            <i class="fa fa-paper-plane fa-lg"></i></button>
                                    </span>
                        </div>
                    </div>
                </div>
                <div class="col-md-3 col-sm-6 col-xs-12 width-50 width-set-50">
                    <div class="footer-details">
                        <h4>explore</h4>
                        <ul class="list-unstyled footer-links">
                            <li><a href="home">Home</a></li>
                            <li><a href="about">About</a></li>
                            <li class="active"><a>Rooms</a></li>
                            <li><a href="gallery">Gallery</a></li>
                            <li><a href="dinning">Dinning</a></li>
                            <li> <a href="news">News</a></li>
                            <li> <a href="contact">Contact</a></li>
                        </ul>
                    </div>
                </div>
                <div class="col-md-6 col-sm-6 col-xs-12">
                    <div class="footer-details">
                        <h4>Now On Instagram</h4>
                        <div class="row">
                            <div class="instagram-images">
                                <div id="instafeed"></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="copyright">
                &copy; 2020 All right reserved. Designed by
                <a href="https://github.com/rivinduchamath/Hello-Hotel" target="_blank">Team Reliance</a>
            </div>

        </div>
    </footer>

    <!--back to top--->
    <a style="display: none;" href="javascript:void(0);" class="scrollTop back-to-top" id="back-to-top">
        <span><i aria-hidden="true" class="fa fa-angle-up fa-lg"></i></span>
        <span>Top</span>
    </a>

</div>
<script>
    var myTableArray = [];
    var selectedRow = null;

    function myFunction(x) {
        selectedRow = $(this)
        if (!myTableArray.includes(x)) {
            alert("Added Table " + x);
            myTableArray.push(x)
        } else {
            alert("Table " + x + " already Booked");
        }
    }

    function getValue() {

      /*  if (vDate == "" || timeIn == "" || timeOut == "") {
            alert("Please Select Room In Table");
            return;
        }
*/
        var str, stre = "";
        var inputArray = []

        for (var i = 0; i < myTableArray.length; i++) {
            if (!inputArray.includes(myTableArray[i])) {
                inputArray.push(myTableArray[i])
                str = myTableArray[i] + " "
                stre += str;
            }
        }
        alert(stre)
        $("#itemPay").val(stre);
    }
</script>
</body>
</html>