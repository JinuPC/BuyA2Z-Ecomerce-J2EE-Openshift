<%@ page import="com.buya2z.config.Config" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String baseUrl = Config.getBaseUrl(); %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <link rel="icon" type="image/png" href="assets/img/favicon.png">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <title>BuyA2Z Shop Online</title>
    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport'/>
    <!--     Fonts and icons     -->
    <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700"/>
    <!-- CSS Files -->
    <link href="<%= baseUrl %>/assets/css/font-awesome.min.css" rel="stylesheet">
    <link href="<%= baseUrl %>/assets/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="<%= baseUrl %>/assets/css/material-kit.css" rel="stylesheet" type="text/css"/>
    <link href="<%= baseUrl %>/assets/css/scrolling-nav.css" rel="stylesheet"/>
    <link href="<%= baseUrl %>/assets/css/w3.css" rel="stylesheet"/>
    <link href="<%= baseUrl %>/assets/css/style.css" rel="stylesheet"/>
    <style>
    </style>
</head>

<body id="page-top" data-spy="scroll" class="remove-all-margin"
      data-target=".navbar-fixed-top">

<!-- Navigation -->
<nav class="container-fluid navbar navbar-primary navbar-fixed-top" role="navigation">
    <div class="container-fluid ">
        <div class="navbar-header page-scroll">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a style="font-size: 30px; margin-bottom: 20px; padding-bottom: 20px;" class="navbar-brand page-scroll"
               href="#">
                <i style="font-size: 50px;" class="fa fa-shopping-cart w3-text-pink" aria-hidden="true"></i>
                Buy A<span class="material-red-color">2</span>Z
            </a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse  navbar-collapse navbar-ex1-collapse">
            <ul class="nav navbar-nav navbar-right">
                <!-- Hidden li included to remove active class from about link when scrolled up past about section -->
                <!--<li class=" ">-->
                <!--<a class="page-scroll" href="#page-top"><br></a>-->
                <!--</li>-->
                <!--<li class="active" style="padding: 3px;">-->
                <!--<a href="#">-->
                <!--<i class="material-icons">explore</i>-->
                <!--Electronics-->
                <!--</a>-->
                <!--</li>-->
                <li class="active" style="padding: 3px;">
                    <a href="#vc" class=" w3-medium active">
                        <i class="fa fa-heart" aria-hidden="true"></i> WishList 1

                    </a>
                </li>
                <li class="active" style="padding: 3px;">
                    <a href="#cvb" class=" w3-medium  ">
                        <i class="fa fa-shopping-basket" aria-hidden="true"></i>
                        Cart <span class="w3-text-white " style="padding-left: 3px;">2</span>
                    </a>
                </li>

                <li class="dropdown active" style="padding: 3px;">
                    <a href="#" class="dropdown-toggle w3-medium " data-toggle="dropdown">
                        <i class="fa fa-user-circle-o" aria-hidden="true"></i> JINU P C <b
                            class=" pull-right caret hidden-sm hidden-md hidden-lg"></b></a>
                    <ul class="dropdown-menu w3-xxlarge">
                        <li><a href="#" class="w3-medium account w3-hover-text-white">
                            <i class="fa fa-address-card pull-right" aria-hidden="true"></i>Account</a>
                        </li>
                        <li><a href="#" class="w3-medium account w3-hover-text-white">
                            <i class="fa fa-shopping-bag pull-right" aria-hidden="true"></i>Orders</a>
                        </li>
                        <li><a href="#" class="w3-medium account w3-hover-text-white">
                            <i class="fa fa-sign-out pull-right" aria-hidden="true"></i>Logout</a>
                        </li>
                    </ul>
                </li>
            </ul>

            <form class="navbar-form" id="search">
                <div class="form-group" style="display:inline;">
                    <div class="input-group input-group-lg mater">
                        <span class="input-group-addon" style="width:1%;"><i
                                class="glyphicon glyphicon-search"></i></span>
                        <input style="text-align: center; line-height: 30px;" class="form-control input-group-lg "
                               name="search"
                               placeholder="Search Products" autocomplete="off" autofocus="autofocus" type="text">
                    </div>
                </div>
            </form>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container -->
</nav>
<!-- /Navigation bar -->
<!-- Category Navigation bar -->
<div class="row ">
    <div id="navbar">
        <div class="navigation-example">
            <!-- Navbar Primary  -->
            <nav class="navbar w3-white remove-bottom-margin">
                <div class="container-fluid w3-center">
                    <div class="navbar-header ">
                        <button type="button" class="navbar-toggle" data-toggle="collapse"
                                data-target="#example-navbar-primary">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand hidden-lg hidden-sm hidden-md" href="#">MENU</a>
                    </div>
                    <div class="collapse navbar-collapse" id="example-navbar-primary">
                        <ul class="nav nav-pills  w3-text-purple nav-justified" role="tablist">

                            <!-- Category List -->
                            <li class="dropdown">
                                <a href="#" class="w3-text-purple w3-medium">
                                    <i class="fa fa-television" aria-hidden="true"></i>
                                    APPLIANCES
                                </a>
                                <!-- List Menu -->
                                <ul class="dropdown-menu product-list-1 remove-all-padding">
                                    <li class="category-list">
                                        <div class="container">
                                            <!--  Content Area-->
                                            <div class="row remove-all-margin-padding">
                                                <div class="col-md-4 col-sm-4 col-lg-4">
                                                    <p class="category-list-row"><a class="w3-text-blue w3-hover-purple" href="">TVs </a></p>
                                                    <p class="category-list-row"><a href="">Full HD</a></p>
                                                    <p class="category-list-row"><a href="">Ultra HD </a></p>
                                                    <p class="category-list-row"><a href="">LED </a></p>
                                                </div>
                                                <div class="col-md-4 col-sm-4 col-lg-4">
                                                    sosdlkfj
                                                </div>
                                                <div class="col-md-4 col-sm-4 col-lg-4">
                                                    sosdlkfj
                                                </div>
                                            </div>
                                            <!-- /Content Area -->
                                        </div>
                                    </li>
                                </ul>
                                <!-- /List Menu -->
                            </li>
                            <!-- /Category List  -->


                            <!-- Category List -->
                            <li class="dropdown">
                                <a href="#" class="w3-text-purple w3-medium">
                                    <i class="fa fa-male " aria-hidden="true"></i>
                                    MEN
                                </a>
                                <!-- List Menu -->
                                <ul class="dropdown-menu product-list-2 remove-all-padding">
                                    <li class="remove-all-margin-padding">
                                        <div class="container">
                                            <!--  Content Area-->
                                            <div class="row remove-all-margin-padding">
                                                <div class="col-md-4 col-sm-4 col-lg-4">
                                                    sosdlkfj
                                                </div>
                                                <div class="col-md-4 col-sm-4 w3-light-gray">
                                                    <p>sdfdklsjfjlkkkkkkkkkkkkkkkkkkkk</p>

                                                </div>
                                                <div class="col-md-4 col-sm-4 col-lg-4 ">
                                                    sosdlkfj
                                                </div>
                                            </div>
                                            <!-- /Content Area -->
                                        </div>
                                    </li>
                                </ul>
                                <!-- /List Menu -->
                            </li>
                            <!-- /Category List  -->



                            <!-- Category List -->
                            <li class="dropdown">
                                <a href="#" class="w3-text-purple w3-medium">
                                    <i class="fa fa-female" aria-hidden="true"></i>
                                    WOMEN
                                </a>
                                <!-- List Menu -->
                                <ul class="dropdown-menu product-list-3 remove-all-padding">
                                    <li class="category-list">
                                        <div class="container">
                                            <!--  Content Area-->
                                            <div class="row remove-all-margin-padding">
                                                <div class="col-md-4 col-sm-4 col-lg-4">
                                                    sosdlkfj
                                                </div>
                                                <div class="col-md-4 w3-light-gray col-sm-4 col-lg-4">
                                                    <p>sdfdklsjfjlkkkkkkkkkkkkkkkkkkkk</p>

                                                </div>
                                                <div class="col-md-4 col-sm-4 col-lg-4">
                                                    sosdlkfj
                                                </div>
                                            </div>
                                            <!-- /Content Area -->
                                        </div>
                                    </li>
                                </ul>
                                <!-- /List Menu -->
                            </li>
                            <!-- /Category List  -->



                            <!-- Category List -->
                            <li class="dropdown">
                                <a href="#" class="w3-text-purple w3-medium">
                                    <i class="fa fa-mobile" aria-hidden="true"></i>
                                    ELECTRONICS
                                </a>
                                <!-- List Menu -->
                                <ul class="dropdown-menu product-list-4 remove-all-padding">
                                    <li class="remove-all-margin-padding">
                                        <div class="container">
                                            <!--  Content Area-->
                                            <div class="row remove-all-margin-padding">
                                                <div class="col-md-4 col-sm-4 col-lg-4">
                                                    sosdlkfj
                                                </div>
                                                <div class="col-md-4 col-sm-4 col-lg-4 w3-light-gray">
                                                    <p>sdf</p>

                                                </div>
                                                <div class="col-md-4 col-sm-4 col-lg-4">
                                                    sosdlkfj
                                                </div>
                                            </div>
                                            <!-- /Content Area -->
                                        </div>
                                    </li>
                                </ul>
                                <!-- /List Menu -->
                            </li>
                            <!-- /Category List  -->


                            <!-- Category List -->
                            <li class="dropdown">
                                <a href="#" class="w3-text-purple w3-medium">
                                    <i class="fa fa-child" aria-hidden="true"></i>
                                    BABY & KIDS
                                </a>
                                <!-- List Menu -->
                                <ul class="dropdown-menu product-list-5 remove-all-padding">
                                    <li class="remove-all-margin-padding">
                                        <div class="container">
                                            <!--  Content Area-->
                                            <div class="row remove-all-margin-padding">
                                                <div class="col-md-4 col-sm-4 col-lg-4">
                                                    sosdlkfj
                                                </div>
                                                <div class="col-md-4 col-sm-4 col-lg-4 w3-light-gray">
                                                    <p>sdfdklsjfjlkkkkkkkkkkkkkkkkkkkk</p>

                                                </div>
                                                <div class="col-md-4 col-sm-4 col-lg-4">
                                                    sosdlkfj
                                                </div>
                                            </div>
                                            <!-- /Content Area -->
                                        </div>
                                    </li>
                                </ul>
                                <!-- /List Menu -->
                            </li>
                            <!-- /Category List  -->



                            <!-- Category List -->
                            <li class="dropdown">
                                <a href="#" class="w3-text-purple w3-medium">
                                    <i class="fa fa-bed" aria-hidden="true"></i>
                                    HOME&FURNITURE
                                </a>
                                <!-- List Menu -->
                                <ul class="dropdown-menu product-list-6 remove-all-padding">
                                    <li class="remove-all-margin-padding">
                                        <div class="container">
                                            <!--  Content Area-->
                                            <div class="row remove-all-margin-padding">
                                                <div class="col-md-4 col-sm-4 col-lg-4">
                                                    sosdlkfj
                                                </div>
                                                <div class="col-md-4 col-sm-4 col-lg-4 w3-light-gray">
                                                    <p>sdfdklsjfjlkkkkkkkkkkkkkkkkkkkk</p>

                                                </div>
                                                <div class="col-md-4 col-sm-4 col-lg-4">
                                                    sosdlkfj
                                                </div>
                                            </div>
                                            <!-- /Content Area -->
                                        </div>
                                    </li>
                                </ul>
                                <!-- /List Menu -->
                            </li>
                            <!-- /Category List  -->


                            <!-- Category List -->
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle  w3-text-purple" data-toggle="dropdown">
                                    <i class="fa fa-coffee" aria-hidden="true"></i>Dropdown</a>
                                <!-- List Menu -->
                                <ul class="dropdown-menu product-list-7 remove-all-padding">
                                    <li class="remove-all-margin-padding">
                                        <div class="container">
                                            <!--  Content Area-->
                                            <div class="row remove-all-margin-padding">
                                                <div class="col-md-4 col-sm-4 col-lg-4">
                                                    sosdlkfj
                                                </div>
                                                <div class="col-md-4 col-sm-4 col-lg-4 w3-light-gray">
                                                    <p>sdfdklsjfjlkkkkkkkkkkkkkkkkkkkk</p>

                                                </div>
                                                <div class="col-md-4 col-sm-4 col-lg-4">
                                                    sosdlkfj
                                                </div>
                                            </div>
                                            <!-- /Content Area -->
                                        </div>
                                    </li>
                                </ul>
                                <!-- /List Menu -->
                            </li>
                            <!-- /Category List  -->
                        </ul>
                    </div>
                </div>
            </nav>
        </div>
    </div>
</div>
<!-- /Category Navigation Bar -->
<!-- Carousel Layout -->
<div class="row remove-all-padding">
    <div class="section remove-all-padding" id="carousel">
        <div class="container-fluid">
            <div class="row">
                <div class="">
                    <!-- Carousel Card -->
                    <div class="card card-raised card-carousel ">
                        <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                            <div class="carousel slide" data-ride="carousel">

                                <!-- Indicators -->
                                <ol class="carousel-indicators">
                                    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                                    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                                    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                                </ol>

                                <!-- Wrapper for slides -->
                                <div class="carousel-inner ">
                                    <div class="item active">
                                        <img class="hidden-xs" src="assets/img/slider/slider1.jpg" alt="Awesome Image">
                                        <img class="hidden-md hidden-lg hidden-sm"
                                             src="assets/img/slider/slider1_xs.jpg" alt="Awesome Image">
                                        <div class="carousel-caption">
                                            <h4>New Offers for you </h4><a class="btn btn-primary">Click Here</a>
                                        </div>
                                    </div>
                                    <div class="item">
                                        <img class="hidden-xs" src="assets/img/slider/slider2.jpg" alt="Awesome Image">
                                        <img class="hidden-md hidden-lg hidden-sm"
                                             src="assets/img/slider/slider2_xs.jpg" alt="Awesome Image">
                                        <div class="carousel-caption">
                                            <h4>New Offers for you </h4><a class="btn btn-primary">Click Here</a>
                                        </div>
                                    </div>
                                    <div class="item">
                                        <img class="hidden-xs" src="assets/img/slider/slider3.jpg" alt="Awesome Image">
                                        <img class="hidden-md hidden-lg hidden-sm"
                                             src="assets/img/slider/slider3_xs.jpg" alt="Awesome Image">
                                        <div class="carousel-caption">
                                            <h4>New Offers for you </h4><a href="something" class="btn btn-primary">Click
                                            Here</a>
                                        </div>
                                    </div>
                                </div>
                                <!-- Controls -->
                                <!--<a class="left carousel-control" href="#carousel-example-generic" data-slide="prev">-->
                                <!--<i class="material-icons">keyboard_arrow_left</i>-->
                                <!--</a>-->
                                <!--<a class="right carousel-control" href="#carousel-example-generic" data-slide="next">-->
                                <!--<i class="material-icons">keyboard_arrow_right</i>-->
                                <!--</a>-->
                            </div>
                        </div>
                    </div>
                    <!-- End Carousel Card -->
                </div>
            </div>
        </div>
    </div>
</div>
<!-- /Carousel layout -->

<!-- List of products -->
<div class="row">
    <div class="container-fluid" style="margin-top: 10px;">
        <!-- Main Card Starting poing -->
        <div class="card">
            <!-- card Header -->
            <div class="col-sm-3 w3-center col-md-2 col-lg-2">
                <div class="hidden-xs" style="padding-top: 80px;"></div>
                <div class="">
                    <h2>Mobile Phones</h2>
                    <a href="dfks" class="btn btn-primary">Browse</a>
                </div>
            </div>
            <!-- /Card Header -->
            <!-- Card Body -->
            <div class="col-sm-9 col-md-10 col-lg-10">
                <!-- Product Card -->
                <div class="set-product-padding-margin col-sm-4 col-md-3 col-lg-3">
                    <div class="my-product-card">
                        <header class="w3-container w3-center">
                            <div class="ratings ">
                                <i class="fa fa-heart-o pull-left w3-large w3-text-blue-gray "></i>
                                <!--<i class="fa fa-heart pull-left w3-large w3-text-pink"></i>-->
                                <span class="label label-inverse pull-right">10% Off</span></p>
                            </div>
                        </header>
                        <a href="kdsjf">
                            <div class="w3-container w3-center img-hover ">
                                <img src="assets/img/mobile2.jpeg" class="w3-round  w3-image"
                                     style="max-height: 150px; min-height: 150px;"
                                     alt="kessel">
                            </div>
                        </a>

                        <footer class="w3-container  w3-center">
                            <p class="w3-text-black w3-medium" style="padding-top: 10px">Samsung Galaxy S6</p>
                            <p class=" w3-text-amber">
                                <i class="fa fa-star" aria-hidden="true"></i>
                                <i class="fa fa-star" aria-hidden="true"></i>
                                <i class="fa fa-star" aria-hidden="true"></i>
                                <i class="fa fa-star-half-o" aria-hidden="true"></i>
                                <i class="fa fa-star-o" aria-hidden="true"></i>
                            </p>
                            <p class="w3-text-light-gray w3-large"><s class="">Rs. 344</s>
                                <span class="w3-center w3-text-blue-gray">Rs. 300</span>

                        </footer>
                    </div>
                </div>
                <!-- /Product Card -->

                <!-- Product Card -->
                <div class="set-product-padding-margin col-sm-4 col-md-3 col-lg-3">
                    <div class="my-product-card">
                        <header class="w3-container w3-center">
                            <div class="ratings ">
                                <i class="fa fa-heart-o pull-left w3-large w3-text-blue-gray "></i>
                                <!--<i class="fa fa-heart pull-left w3-large w3-text-pink"></i>-->
                                <span class="label label-inverse pull-right"></span></p>
                            </div>
                        </header>
                        <a href="kdsjf">
                            <div class="w3-container w3-center img-hover ">
                                <img src="assets/img/mobile1.jpeg" class="w3-round  w3-image"
                                     style="max-height: 150px; min-height: 150px;"
                                     alt="kessel">
                            </div>
                        </a>

                        <footer class="w3-container  w3-center">
                            <p class="w3-text-black w3-medium" style="padding-top: 10px">Samsung Galaxy S6</p>
                            <p class=" w3-text-amber">
                                <i class="fa fa-star" aria-hidden="true"></i>
                                <i class="fa fa-star" aria-hidden="true"></i>
                                <i class="fa fa-star" aria-hidden="true"></i>
                                <i class="fa fa-star-half-o" aria-hidden="true"></i>
                                <i class="fa fa-star-o" aria-hidden="true"></i>
                            </p>
                            <p class="w3-text-light-gray w3-large"><s class="">Rs. 344</s>
                                <span class="w3-center w3-text-blue-gray">Rs. 300</span>

                        </footer>
                    </div>
                </div>
                <!-- /Product Card -->

                <!-- Product Card -->
                <div class="set-product-padding-margin col-sm-4 col-md-3 col-lg-3">
                    <div class="my-product-card">
                        <header class="w3-container w3-center">
                            <div class="ratings ">
                                <i class="fa fa-heart-o pull-left w3-large w3-text-blue-gray "></i>
                                <!--<i class="fa fa-heart pull-left w3-large w3-text-pink"></i>-->
                                <span class="label label-inverse pull-right"></span></p>
                            </div>
                        </header>
                        <a href="kdsjf">
                            <div class="w3-container w3-center img-hover ">
                                <img src="assets/img/mobile3.jpeg" class="w3-round  w3-image"
                                     style="max-height: 150px; min-height: 150px;"
                                     alt="kessel">
                            </div>
                        </a>

                        <footer class="w3-container  w3-center">
                            <p class="w3-text-black w3-medium" style="padding-top: 10px">Samsung Galaxy S6</p>
                            <p class=" w3-text-amber">
                                <i class="fa fa-star" aria-hidden="true"></i>
                                <i class="fa fa-star" aria-hidden="true"></i>
                                <i class="fa fa-star" aria-hidden="true"></i>
                                <i class="fa fa-star-half-o" aria-hidden="true"></i>
                                <i class="fa fa-star-o" aria-hidden="true"></i>
                            </p>
                            <p class="w3-text-light-gray w3-large"><s class="">Rs. 344</s>
                                <span class="w3-center w3-text-blue-gray">Rs. 300</span>

                        </footer>
                    </div>
                </div>
                <!-- /Product Card -->

                <!-- Product Card -->
                <div class="set-product-padding-margin hidden-sm col-sm-4 col-md-3 col-lg-3">
                    <div class="my-product-card">
                        <header class="w3-container w3-center">
                            <div class="ratings ">
                                <i class="fa fa-heart-o pull-left w3-large w3-text-blue-gray "></i>
                                <!--<i class="fa fa-heart pull-left w3-large w3-text-pink"></i>-->
                                <span class="label label-inverse pull-right"></span></p>
                            </div>
                        </header>
                        <a href="kdsjf">
                            <div class="w3-container w3-center img-hover ">
                                <img src="assets/img/mobile4.jpeg" class="w3-round w3-image"
                                     style="max-height: 150px; min-height: 150px;"
                                     alt="kessel">
                            </div>
                        </a>

                        <footer class="w3-container  w3-center">
                            <p class="w3-text-black w3-medium" style="padding-top: 10px">Samsung Galaxy S6</p>
                            <p class=" w3-text-amber">
                                <i class="fa fa-star" aria-hidden="true"></i>
                                <i class="fa fa-star" aria-hidden="true"></i>
                                <i class="fa fa-star" aria-hidden="true"></i>
                                <i class="fa fa-star-half-o" aria-hidden="true"></i>
                                <i class="fa fa-star-o" aria-hidden="true"></i>
                            </p>
                            <p class="w3-text-light-gray w3-large"><s class="">Rs. 344</s>
                                <span class="w3-center w3-text-blue-gray">Rs. 300</span>

                        </footer>
                    </div>
                </div>
                <!-- /Product Card -->
            </div>
            <!-- /Card Body -->
        </div>
        <!-- /Main Card Ending poing -->
    </div>
</div>
<!-- /List of products -->


<!-- List of products -->
<div class="row">
    <div class="container-fluid" style="margin-top: 10px;">
        <!-- Main Card Starting poing -->
        <div class="card">
            <!-- card Header -->
            <div class="col-sm-3 w3-center col-md-2 col-lg-2">
                <div class="hidden-xs" style="padding-top: 75px;"></div>
                <div class="">
                    <h2>Televisions</h2>
                    <a href="dfks" class="btn btn-primary">Browse</a>
                </div>
            </div>
            <!-- /Card Header -->
            <!-- Card Body -->
            <div class="col-sm-9 col-md-10 col-lg-10">

                <!-- Product Card -->
                <div class="set-product-padding-margin col-sm-4 col-md-3 col-lg-3">
                    <div class="my-product-card">
                        <header class="w3-container w3-center">
                            <div class="ratings ">
                                <i class="fa fa-heart-o pull-left w3-large w3-text-blue-gray "></i>
                                <!--<i class="fa fa-heart pull-left w3-large w3-text-pink"></i>-->
                                <span class="label label-inverse pull-right">23% off</span></p>
                            </div>
                        </header>
                        <a href="kdsjf">
                            <div class="w3-container w3-center img-hover ">
                                <img src="assets/img/tv3.jpeg" class="w3-round  w3-image"
                                     style="max-height: 150px; min-height: 150px;"
                                     alt="kessel">
                            </div>
                        </a>

                        <footer class="w3-container  w3-center">
                            <p class="w3-text-black w3-medium" style="padding-top: 10px">Samsung Galaxy S6</p>
                            <p class=" w3-text-amber">
                                <i class="fa fa-star" aria-hidden="true"></i>
                                <i class="fa fa-star" aria-hidden="true"></i>
                                <i class="fa fa-star" aria-hidden="true"></i>
                                <i class="fa fa-star-half-o" aria-hidden="true"></i>
                                <i class="fa fa-star-o" aria-hidden="true"></i>
                            </p>
                            <p class="w3-text-light-gray w3-large"><s class="">Rs. 344</s>
                                <span class="w3-center w3-text-blue-gray">Rs. 300</span>

                        </footer>
                    </div>
                </div>
                <!-- /Product Card -->


                <!-- Product Card -->
                <div class="set-product-padding-margin col-sm-4 col-md-3 col-lg-3">
                    <div class="my-product-card">
                        <header class="w3-container w3-center">
                            <div class="ratings ">
                                <!--<i class="fa fa-heart-o pull-left w3-large w3-text-blue-gray "></i>-->
                                <i class="fa fa-heart pull-left w3-large w3-text-pink"></i>
                                <span class="label label-inverse pull-right"></span></p>
                            </div>
                        </header>
                        <a href="kdsjf">
                            <div class="w3-container w3-center img-hover ">
                                <img src="assets/img/tv1.jpeg" class="w3-round  w3-image"
                                     style="max-height: 150px; min-height: 150px;"
                                     alt="kessel">
                            </div>
                        </a>

                        <footer class="w3-container  w3-center">
                            <p class="w3-text-black w3-medium" style="padding-top: 10px">Samsung Galaxy S6</p>
                            <p class=" w3-text-amber">
                                <i class="fa fa-star" aria-hidden="true"></i>
                                <i class="fa fa-star" aria-hidden="true"></i>
                                <i class="fa fa-star" aria-hidden="true"></i>
                                <i class="fa fa-star-half-o" aria-hidden="true"></i>
                                <i class="fa fa-star-o" aria-hidden="true"></i>
                            </p>
                            <p class="w3-text-light-gray w3-large"><s class="">Rs. 344</s>
                                <span class="w3-center w3-text-blue-gray">Rs. 300</span>

                        </footer>
                    </div>
                </div>
                <!-- /Product Card -->


                <!-- Product Card -->
                <div class="set-product-padding-margin col-sm-4 col-md-3 col-lg-3">
                    <div class="my-product-card">
                        <header class="w3-container w3-center">
                            <div class="ratings ">
                                <i class="fa fa-heart-o pull-left w3-large w3-text-blue-gray "></i>
                                <!--<i class="fa fa-heart pull-left w3-large w3-text-pink"></i>-->
                                <span class="label label-inverse pull-right"></span></p>
                            </div>
                        </header>
                        <a href="kdsjf">
                            <div class="w3-container w3-center img-hover ">
                                <img src="assets/img/tv2.jpeg" class="w3-round  w3-image"
                                     style="max-height: 150px; min-height: 150px;"
                                     alt="kessel">
                            </div>
                        </a>

                        <footer class="w3-container  w3-center">
                            <p class="w3-text-black w3-medium" style="padding-top: 10px">Samsung Galaxy S6</p>
                            <p class=" w3-text-amber">
                                <i class="fa fa-star" aria-hidden="true"></i>
                                <i class="fa fa-star" aria-hidden="true"></i>
                                <i class="fa fa-star" aria-hidden="true"></i>
                                <i class="fa fa-star-half-o" aria-hidden="true"></i>
                                <i class="fa fa-star-o" aria-hidden="true"></i>
                            </p>
                            <p class="w3-text-light-gray w3-large"><s class="">Rs. 344</s>
                                <span class="w3-center w3-text-blue-gray">Rs. 300</span>

                        </footer>
                    </div>
                </div>
                <!-- /Product Card -->


                <!-- Product Card -->
                <div class="set-product-padding-margin hidden-sm col-sm-4 col-md-3 col-lg-3">
                    <div class="my-product-card">
                        <header class="w3-container w3-center">
                            <div class="ratings ">
                                <i class="fa fa-heart-o pull-left w3-large w3-text-blue-gray "></i>
                                <!--<i class="fa fa-heart pull-left w3-large w3-text-pink"></i>-->
                                <span class="label label-inverse pull-right"></span></p>
                            </div>
                        </header>
                        <a href="kdsjf">
                            <div class="w3-container w3-center img-hover ">
                                <img src="assets/img/tv3.jpeg" class="w3-round  w3-image"
                                     style="max-height: 150px; min-height: 150px;"
                                     alt="kessel">
                            </div>
                        </a>

                        <footer class="w3-container  w3-center">
                            <p class="w3-text-black w3-medium" style="padding-top: 10px">Samsung Galaxy S6</p>
                            <p class=" w3-text-amber">
                                <i class="fa fa-star" aria-hidden="true"></i>
                                <i class="fa fa-star" aria-hidden="true"></i>
                                <i class="fa fa-star" aria-hidden="true"></i>
                                <i class="fa fa-star-half-o" aria-hidden="true"></i>
                                <i class="fa fa-star-o" aria-hidden="true"></i>
                            </p>
                            <p class="w3-text-light-gray w3-large"><s class="">Rs. 344</s>
                                <span class="w3-center w3-text-blue-gray">Rs. 300</span>

                        </footer>
                    </div>
                </div>
                <!-- /Product Card -->
            </div>
            <!-- /Card Body -->
        </div>
        <!-- /Main Card Ending poing -->
    </div>
</div>
<!-- /List of products -->


<!-- List of products -->
<div class="row">
    <div class="container-fluid" style="margin-top: 10px;">
        <!-- Main Card Starting poing -->
        <div class="card">
            <!-- card Header -->
            <div class="col-sm-3 w3-center col-md-2 col-lg-2">
                <div class="hidden-xs" style="padding-top: 75px;"></div>
                <div class="">
                    <h2>Sports Shoes</h2>
                    <a href="dfks" class="btn btn-primary">Browse</a>
                </div>
            </div>
            <!-- /Card Header -->
            <!-- Card Body -->
            <div class="col-sm-9 col-md-10 col-lg-10">

                <!-- Product Card -->
                <div class="set-product-padding-margin col-sm-4 col-md-3 col-lg-3">
                    <div class="my-product-card">
                        <header class="w3-container w3-center">
                            <div class="ratings ">
                                <i class="fa fa-heart-o pull-left w3-large w3-text-blue-gray "></i>
                                <!--<i class="fa fa-heart pull-left w3-large w3-text-pink"></i>-->
                                <span class="label label-inverse pull-right"></span></p>
                            </div>
                        </header>
                        <a href="kdsjf">
                            <div class="w3-container w3-center img-hover ">
                                <img src="assets/img/sports%20shoes.jpeg" class="w3-round  w3-image"
                                     style="max-height: 150px; min-height: 150px;"
                                     alt="kessel">
                            </div>
                        </a>

                        <footer class="w3-container  w3-center">
                            <p class="w3-text-black w3-medium" style="padding-top: 10px">Samsung Galaxy S6</p>
                            <p class=" w3-text-amber">
                                <i class="fa fa-star" aria-hidden="true"></i>
                                <i class="fa fa-star" aria-hidden="true"></i>
                                <i class="fa fa-star" aria-hidden="true"></i>
                                <i class="fa fa-star-half-o" aria-hidden="true"></i>
                                <i class="fa fa-star-o" aria-hidden="true"></i>
                            </p>
                            <p class="w3-text-light-gray w3-large"><s class="">Rs. 344</s>
                                <span class="w3-center w3-text-blue-gray">Rs. 300</span>

                        </footer>
                    </div>
                </div>
                <!-- /Product Card -->

                <!-- Product Card -->
                <div class="set-product-padding-margin col-sm-4 col-md-3 col-lg-3">
                    <div class="my-product-card">
                        <header class="w3-container w3-center">
                            <div class="ratings ">
                                <i class="fa fa-heart-o pull-left w3-large w3-text-blue-gray"></i>
                                <!--<i class="fa fa-heart pull-left w3-large w3-text-pink"></i>-->
                                <span class="label label-inverse pull-right"></span></p>
                            </div>
                        </header>
                        <a href="kdsjf">
                            <div class="w3-container w3-center img-hover ">
                                <img src="assets/img/sports%20shoes2.jpeg" class="w3-round  w3-image"
                                     style="max-height: 150px; min-height: 150px;"
                                     alt="kessel">
                            </div>
                        </a>

                        <footer class="w3-container  w3-center">
                            <p class="w3-text-black w3-medium" style="padding-top: 10px">Samsung Galaxy S6</p>
                            <p class=" w3-text-amber">
                                <i class="fa fa-star" aria-hidden="true"></i>
                                <i class="fa fa-star" aria-hidden="true"></i>
                                <i class="fa fa-star" aria-hidden="true"></i>
                                <i class="fa fa-star-half-o" aria-hidden="true"></i>
                                <i class="fa fa-star-o" aria-hidden="true"></i>
                            </p>
                            <p class="w3-text-light-gray w3-large"><s class="">Rs. 344</s>
                                <span class="w3-center w3-text-blue-gray">Rs. 300</span>

                        </footer>
                    </div>
                </div>
                <!-- /Product Card -->

                <!-- Product Card -->
                <div class="set-product-padding-margin col-sm-4 col-md-3 col-lg-3">
                    <div class="my-product-card">
                        <header class="w3-container w3-center">
                            <div class="ratings ">
                                <!--<i class="fa fa-heart-o pull-left w3-xlarge w3-text-blue-gray "></i>-->
                                <i class="fa fa-heart pull-left w3-large w3-text-pink"></i>
                                <span class="label label-inverse pull-right">30% off</span></p>
                            </div>
                        </header>
                        <a href="kdsjf">
                            <div class="w3-container w3-center img-hover ">
                                <img src="assets/img/sportsshoes3.jpeg" class="w3-round  w3-image"
                                     style="max-height: 150px; min-height: 150px;"
                                     alt="kessel">
                            </div>
                        </a>

                        <footer class="w3-container  w3-center">
                            <p class="w3-text-black w3-medium" style="padding-top: 10px">Samsung Galaxy S6</p>
                            <p class=" w3-text-amber">
                                <i class="fa fa-star" aria-hidden="true"></i>
                                <i class="fa fa-star" aria-hidden="true"></i>
                                <i class="fa fa-star" aria-hidden="true"></i>
                                <i class="fa fa-star-half-o" aria-hidden="true"></i>
                                <i class="fa fa-star-o" aria-hidden="true"></i>
                            </p>
                            <p class="w3-text-light-gray w3-large"><s class="">Rs. 344</s>
                                <span class="w3-center w3-text-blue-gray">Rs. 300</span>

                        </footer>
                    </div>
                </div>
                <!-- /Product Card -->

                <!-- Product Card -->
                <div class="set-product-padding-margin hidden-sm  col-sm-4 col-md-3 col-lg-3">
                    <!-- Product Card Starts Here -->
                    <div class="my-product-card">
                        <header class="w3-container w3-center">
                            <div class="ratings ">
                                <!--<i class="fa fa-heart-o pull-left w3-xlarge w3-text-blue-gray "></i>-->
                                <i class="fa fa-heart pull-left w3-large w3-text-pink "></i>
                                <span class="label label-primary pull-right"></span></p>
                            </div>
                        </header>
                        <a href="kdsjf">
                            <div class="w3-container w3-center img-hover ">
                                <img src="assets/img/sportsshoes3.jpeg" class="w3-round  w3-image"
                                     style="max-height: 150px; min-height: 150px;"
                                     alt="kessel">
                            </div>
                        </a>

                        <footer class="w3-container  w3-center">
                            <p class="w3-text-black w3-medium" style="padding-top: 10px">Samsung Galaxy S6</p>
                            <p class=" w3-text-amber">
                                <i class="fa fa-star" aria-hidden="true"></i>
                                <i class="fa fa-star" aria-hidden="true"></i>
                                <i class="fa fa-star" aria-hidden="true"></i>
                                <i class="fa fa-star-half-o" aria-hidden="true"></i>
                                <i class="fa fa-star-o" aria-hidden="true"></i>
                            </p>
                            <p class="w3-text-light-gray w3-large"><s class="">Rs. 344</s>
                                <span class="w3-center w3-text-blue-gray">Rs. 300</span>
                        </footer>
                    </div>
                </div>
                <!-- /Product Card -->
            </div>
            <!-- /Card Body -->
        </div>
        <!-- /Main Card Ending poing -->
    </div>
</div>
<!-- /List of products -->


<!-- footer Layout -->
<div class="container-fluid text-center w3-white ">
    <hr/>
    <div class="row">
        <div class="col-lg-12">
            <div class="col-md-3 col-xs-6">
                <ul class="nav nav-pills nav-stacked">
                    <li><a href="#">Category 1</a></li>
                    <li><a href="#">Category 1</a></li>
                </ul>
            </div>
            <div class="col-md-3 col-xs-6">
                <ul class="nav nav-pills nav-stacked">
                    <li><a href="#">Category 1</a></li>
                    <li><a href="#">Category 1</a></li>
                </ul>
            </div>
            <div class="col-md-3 col-xs-6">
                <ul class="nav nav-pills nav-stacked">
                    <li><a href="#">Category 1</a></li>
                    <li><a href="#">Category 1</a></li>
                </ul>
            </div>
            <div class="col-md-3 col-xs-6">
                <ul class="nav nav-pills nav-stacked">
                    <li><a href="#">Category 1</a></li>
                    <li><a href="#">Category 6</a></li>
                </ul>
            </div>
        </div>
    </div>
    <hr>
    <div class="row">
        <div class="col-lg-12">
            <ul class="nav nav-pills nav-justified">
                <li><a href="/">© 2016 BuyA2Z.</a></li>
                <li><a href="#">Terms of Service</a></li>
                <li><a href="#">About Us</a></li>
            </ul>
        </div>
    </div>
</div>

<!--   Core JS Files   -->
<script src="<%= baseUrl %>/assets/js/jquery.min.js" type="text/javascript"></script>
<script src="<%= baseUrl %>/assets/js/jquery.easing.min.js" type="text/javascript"></script>
<script src="<%= baseUrl %>/assets/js/scrolling-nav.js" type="text/javascript"></script>
<script src="<%= baseUrl %>/assets/js/bootstrap.min.js" type="text/javascript"></script>
<script src="<%= baseUrl %>/assets/js/material.min.js"></script>
<!-- Control Center for Material Kit: activating the ripples, parallax effects, scripts from the example pages etc -->
<script src="<%= baseUrl %>/assets/js/material-kit.js" type="text/javascript"></script>
<script>
    $(function () {
        $(".dropdown").hover(
            function () {
                $('.dropdown-menu', this).stop(true, true).fadeIn("fast");
                $(this).toggleClass('open');
                $('b', this).toggleClass("caret caret-up");
            },
            function () {
                $('.dropdown-menu', this).stop(true, true).fadeOut("fast");
                $(this).toggleClass('open');
                $('b', this).toggleClass("caret caret-up");
            });
    });

    $('.carousel').carousel({
        interval: 5000 //changes the speed
    })
</script>

</body>
</html>
