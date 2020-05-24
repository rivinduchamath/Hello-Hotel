<%--
  Created by IntelliJ IDEA.
  User: Rivindu Chamath
  Date: 21-May-20
  Time: 4:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import = "java.util.Date" %>
<%@ page import = "java.text.SimpleDateFormat" %>
<html lang="en">
<head>
	<title>Hotel Management</title>
	<link rel="icon" type="image/png" href="../../images/icons/gdfgd.png"/>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" type="text/css" href="../../fonts/font-awesome-4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="../../fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
	<link rel="stylesheet" type="text/css" href="../../css/util.css">
	<link rel="stylesheet" type="text/css" href="../../css/main.css">
	
	<%
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String date = sdf.format(new Date());
	%>
</head>
<body style="background-color: #666666; cursor: pointer">

	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">

				<form class="login100-form validate-form" action="Dashboard">

					<span class="login100-form-title p-b-43" style="font-family: 'Arial Black';margin-top: 20px">
						Login to continue
					</span>

					<div class="wrap-input100 validate-input" data-validate = "Valid Id is required">
						<input class="input100" type="text" name="idNo"/>
						<span class="focus-input100"></span>
						<span class="label-input100">User Id</span>
					</div>
					<div class="wrap-input100 validate-input" data-validate="Password is required">
						<input class="input100" type="password" name="password"  />
						<span class="focus-input100"></span>
						<span class="label-input100">Password</span>
					</div>
					<div class="flex-sb-m w-full p-t-3 p-b-32">
						<div class="contact100-form-checkbox">
							<input class="input-checkbox100" id="ckb1" type="checkbox" name="remember-me">
							<label class="label-checkbox100" for="ckb1">
								Remember me
							</label>
						</div>
						<div>
							<a href="#" class="txt1">
								Forgot Password?
							</a>
						</div>
					</div>

					<div class="container-login100-form-btn">

						<button  class="login100-form-btn">
							Login
									</button>
					</div>

					<div class="text-center p-t-46 p-b-20">
						<span class="txt2">SignIn as a Visitor
						</span>
					</div>

					<div class="login100-form-social flex-c-m">
						<a href="#" class="login100-form-social-item flex-c-m bg1 m-r-5">
							<i class="fa fa-facebook-f" aria-hidden="true"></i>
						</a>

						<a href="#" class="login100-form-social-item flex-c-m bg2 m-r-5">
							<i class="fa fa-twitter" aria-hidden="true"></i>
						</a>
					</div>
				</form>

				<div class="login100-more" style="background-image: url('../../images/log.png');">
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
					<form name="clock" style="">
						<table class="" >

							<tr >
								<h5 style="color:#73879C; border: none;position: absolute;margin-top: 430px;text-align: center">
									<p style="font-size: 40px;font-weight: bold;font-family: Cambria;margin-left: 250px;"> <%=date%></p>
									<input style="color:#73879C; width: 45%;font-size: 33px;font-weight: bold;font-family: Cambria; border: none;margin-left: 250px;background : none !important;text-align: center" class="" type="text" name="sivam" size="12"><br>

								</h5>

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
		</div>
	</div>

	<script src="../../js/main.js"></script>

</body>
</html>