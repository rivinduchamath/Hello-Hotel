<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <title>Hotel Hareesha</title>

    <!-- Google font -->
    <link href="https://fonts.googleapis.com/css?family=Raleway:400,700" rel="stylesheet">

    <!-- Bootstrap -->
    <link type="text/css" rel="stylesheet" href="../../css/onlineReservation/bootstrap.min.css" />

    <!-- Custom stlylesheet -->
    <link type="text/css" rel="stylesheet" href="../../css/onlineReservation/style.css" />

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<body background="../../images/onlineReservation.jpg">
<div id="booking" class="section">
    <div class="section-center">
        <div class="container">
            <div class="row">
                <div class="booking-form">
                    <div class="form-header">
                        <h1>Make your reservation</h1>
                    </div>

                    <form action="customerLogin" name="customerLogin" >


                        <div class="row">
                            <div class="col-md-6">
                                <div class="form-group">
                                    <input class="form-control" type="date" name ="checkIn" required>
                                    <span class="form-label">Check In</span>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <input class="form-control" type="date" name ="checkOut" required>
                                    <span class="form-label">Check out</span>
                                </div>
                            </div>
                        </div>



                        <div class="form-btn">
                            <button class="submit-btn">Check Availability</button></div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="../../js/jquery.min.js"></script>
<script>
    $('.form-control').each(function () {
        floatedLabel($(this));
    });

    $('.form-control').on('input', function () {
        floatedLabel($(this));
    });

    function floatedLabel(input) {
        var $field = input.closest('.form-group');
        if (input.val()) {
            $field.addClass('input-not-empty');
        } else {
            $field.removeClass('input-not-empty');
        }
    }
</script>

<script async src="https://www.googletagmanager.com/gtag/js?id=UA-23581568-13"></script>
<script>
    window.dataLayer = window.dataLayer || [];
    function gtag(){dataLayer.push(arguments);}
    gtag('js', new Date());

    gtag('config', 'UA-23581568-13');
</script>
</body>
</html>