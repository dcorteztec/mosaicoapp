<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html >
    <head>
        <meta charset="UTF-8">
  
        <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
        <!-- bootstrap 3.0.2 -->
        <link href="<c:url value='/static/admin/css/bootstrap.min.css'/>" rel="stylesheet" type="text/css" />
        <!-- font Awesome -->
        <link href="<c:url value='/static/admin/css/font-awesome.min.css'/>" rel="stylesheet" type="text/css" />
        <!-- Ionicons -->
        <link href="<c:url value='/static/admin/css/ionicons.min.css'/>" rel="stylesheet" type="text/css" />
        
        <link href="<c:url value='/static/admin/css/ng-table.css'/>" rel="stylesheet" type="text/css" />
        <!-- Theme style -->
       
        <link href="<c:url value='/static/admin/css/AdminLTE.css'/>" rel="stylesheet" type="text/css" />
        
        <link href="<c:url value='/static/admin/css/custom.css'/>" rel="stylesheet" type="text/css" />
        
        <link href="<c:url value='/static/admin/css/ng-grid-panel.css'/>" rel="stylesheet" type="text/css" />
        
        <link href="<c:url value='/static/admin/css/sweetalert.css'/>" rel="stylesheet" type="text/css" />
        
        <link href="<c:url value='/static/admin/css/angular-bootstrap-lightbox.css'/>" rel="stylesheet" type="text/css" />
        
        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
          <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
        <![endif]-->
    </head>
    <body class="skin-blue">
        <!-- header logo: style can be found in header.less -->
        <header class="header">
                    <sec:authorize access="hasRole('ADMIN')">
                        <a href="<c:url value='/admin'/>" class="logo">
                        Mosaico
                        </a>
                    </sec:authorize>
                    <sec:authorize access="hasRole('USUARIO')">
                        <a href="<c:url value='/painel'/>" class="logo">
                        Mosaico
                        </a>
                    </sec:authorize>
           
           <nav class="navbar navbar-static-top" role="navigation">
                <!-- Sidebar toggle button-->
                <a href="#" class="navbar-btn sidebar-toggle" data-toggle="offcanvas" role="button">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </a>
                <div class="navbar-right">
                    <ul class="nav navbar-nav">
                        <!-- Messages: style can be found in dropdown.less-->
                        <li class="dropdown messages-menu">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <i class="fa fa-envelope"></i>
                                <span class="label label-success">4</span>
                            </a>
                            <ul class="dropdown-menu">
                                <li class="header">You have 4 messages</li>
                                <li>
                                    <!-- inner menu: contains the actual data -->
                                    <ul class="menu">
                                        <li><!-- start message -->
                                            <a href="#">
                                                <div class="pull-left">
                                                    <img src="../../img/avatar3.png" class="img-circle" alt="User Image"/>
                                                </div>
                                                <h4>
                                                    Support Team
                                                    <small><i class="fa fa-clock-o"></i> 5 mins</small>
                                                </h4>
                                                <p>Why not buy a new awesome theme?</p>
                                            </a>
                                        </li><!-- end message -->
                                        <li>
                                            <a href="#">
                                                <div class="pull-left">
                                                    <img src="../../img/avatar2.png" class="img-circle" alt="user image"/>
                                                </div>
                                                <h4>
                                                    AdminLTE Design Team
                                                    <small><i class="fa fa-clock-o"></i> 2 hours</small>
                                                </h4>
                                                <p>Why not buy a new awesome theme?</p>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="#">
                                                <div class="pull-left">
                                                    <img src="../../img/avatar.png" class="img-circle" alt="user image"/>
                                                </div>
                                                <h4>
                                                    Developers
                                                    <small><i class="fa fa-clock-o"></i> Today</small>
                                                </h4>
                                                <p>Why not buy a new awesome theme?</p>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="#">
                                                <div class="pull-left">
                                                    <img src="../../img/avatar2.png" class="img-circle" alt="user image"/>
                                                </div>
                                                <h4>
                                                    Sales Department
                                                    <small><i class="fa fa-clock-o"></i> Yesterday</small>
                                                </h4>
                                                <p>Why not buy a new awesome theme?</p>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="#">
                                                <div class="pull-left">
                                                    <img src="../../img/avatar.png" class="img-circle" alt="user image"/>
                                                </div>
                                                <h4>
                                                    Reviewers
                                                    <small><i class="fa fa-clock-o"></i> 2 days</small>
                                                </h4>
                                                <p>Why not buy a new awesome theme?</p>
                                            </a>
                                        </li>
                                    </ul>
                                </li>
                                <li class="footer"><a href="#">See All Messages</a></li>
                            </ul>
                        </li>
                        <!-- Notifications: style can be found in dropdown.less -->
                        <li class="dropdown notifications-menu">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <i class="fa fa-warning"></i>
                                <span class="label label-warning">10</span>
                            </a>
                            <ul class="dropdown-menu">
                                <li class="header">You have 10 notifications</li>
                                <li>
                                    <!-- inner menu: contains the actual data -->
                                    <ul class="menu">
                                        <li>
                                            <a href="#">
                                                <i class="ion ion-ios7-people info"></i> 5 new members joined today
                                            </a>
                                        </li>
                                        <li>
                                            <a href="#">
                                                <i class="fa fa-warning danger"></i> Very long description here that may not fit into the page and may cause design problems
                                            </a>
                                        </li>
                                        <li>
                                            <a href="#">
                                                <i class="fa fa-users warning"></i> 5 new members joined
                                            </a>
                                        </li>

                                        <li>
                                            <a href="#">
                                                <i class="ion ion-ios7-cart success"></i> 25 sales made
                                            </a>
                                        </li>
                                        <li>
                                            <a href="#">
                                                <i class="ion ion-ios7-person danger"></i> You changed your username
                                            </a>
                                        </li>
                                    </ul>
                                </li>
                                <li class="footer"><a href="#">View all</a></li>
                            </ul>
                        </li>
                        <!-- Tasks: style can be found in dropdown.less -->
                        <li class="dropdown tasks-menu">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <i class="fa fa-tasks"></i>
                                <span class="label label-danger">9</span>
                            </a>
                            <ul class="dropdown-menu">
                                <li class="header">You have 9 tasks</li>
                                <li>
                                    <!-- inner menu: contains the actual data -->
                                    <ul class="menu">
                                        <li><!-- Task item -->
                                            <a href="#">
                                                <h3>
                                                    Design some buttons
                                                    <small class="pull-right">20%</small>
                                                </h3>
                                                <div class="progress xs">
                                                    <div class="progress-bar progress-bar-aqua" style="width: 20%" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">
                                                        <span class="sr-only">20% Complete</span>
                                                    </div>
                                                </div>
                                            </a>
                                        </li><!-- end task item -->
                                        <li><!-- Task item -->
                                            <a href="#">
                                                <h3>
                                                    Create a nice theme
                                                    <small class="pull-right">40%</small>
                                                </h3>
                                                <div class="progress xs">
                                                    <div class="progress-bar progress-bar-green" style="width: 40%" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">
                                                        <span class="sr-only">40% Complete</span>
                                                    </div>
                                                </div>
                                            </a>
                                        </li><!-- end task item -->
                                        <li><!-- Task item -->
                                            <a href="#">
                                                <h3>
                                                    Some task I need to do
                                                    <small class="pull-right">60%</small>
                                                </h3>
                                                <div class="progress xs">
                                                    <div class="progress-bar progress-bar-red" style="width: 60%" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">
                                                        <span class="sr-only">60% Complete</span>
                                                    </div>
                                                </div>
                                            </a>
                                        </li><!-- end task item -->
                                        <li><!-- Task item -->
                                            <a href="#">
                                                <h3>
                                                    Make beautiful transitions
                                                    <small class="pull-right">80%</small>
                                                </h3>
                                                <div class="progress xs">
                                                    <div class="progress-bar progress-bar-yellow" style="width: 80%" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">
                                                        <span class="sr-only">80% Complete</span>
                                                    </div>
                                                </div>
                                            </a>
                                        </li><!-- end task item -->
                                    </ul>
                                </li>
                                <li class="footer">
                                    <a href="#">View all tasks</a>
                                </li>
                            </ul>
                        </li>
                        <!-- User Account: style can be found in dropdown.less -->
                        <li class="dropdown user user-menu">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <i class="glyphicon glyphicon-user"></i>
                                <span> ${usuario} <i class="caret"></i></span>
                            </a>
                            <ul class="dropdown-menu">
                                <!-- User image -->
                                <li class="user-header bg-light-blue">

                                    <img src="${empresa.urlLogo}" class="img-circle" alt="User Image" />
                                    <p>
                                       ${empresa.nome}
                                        <small> ${empresa.dataFormatada}</small>
                                    </p>
                                </li>
                                <!-- Menu Body -->
                                <li class="user-body">
                                    <div class="col-xs-4 text-center">
                                        <a href="#">Followers</a>
                                    </div>
                                    <div class="col-xs-4 text-center">
                                        <a href="#">Sales</a>
                                    </div>
                                    <div class="col-xs-4 text-center">
                                        <a href="#">Friends</a>
                                    </div>
                                </li>
                                <!-- Menu Footer-->
                                <li class="user-footer">
                                    <div class="pull-left">
                                        <a href="#" class="btn btn-default btn-flat">Profile</a>
                                    </div>
                                    <div class="pull-right">
                                        <a href="<c:url value='/logout'/>" class="btn btn-default btn-flat">Sign out</a>
                                    </div>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </nav>
        </header>
        <div class="wrapper row-offcanvas row-offcanvas-left">
            <!-- Left side column. contains the logo and sidebar -->
            <aside class="left-side sidebar-offcanvas">                
                <!-- sidebar: style can be found in sidebar.less -->
                <section class="sidebar">
                    <!-- Sidebar user panel -->
                  <tiles:insertAttribute name="menu" />
                </section>
                <!-- /.sidebar -->
            </aside>
           <tiles:insertAttribute name="body" />
            
        </div><!-- ./wrapper -->


    </body>
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
<%--         <script src="<c:url value='/static/js/dataTable/dataTables.bootstrap.js'/>"></script> --%>
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
        <script src="<c:url value='/static/js/appAdmin.js' />"></script>
        
        <!-- Bootstrap -->
        <script src="<c:url value='/static/admin/js/bootstrap.min.js'/>" type="text/javascript"></script>
        <!-- AdminLTE App -->
        <script src="<c:url value='/static/admin/js/AdminLTE/app.js'/>" type="text/javascript"></script>
       
        <script src="https://cdnjs.cloudflare.com/ajax/libs/angular-ui-bootstrap/1.1.2/ui-bootstrap-tpls.js"></script>
        <script src="<c:url value='/static/js/controller/utilController.js' />"></script>
        <script src="<c:url value='/static/js/service/endereco_service.js' />"></script>
        <script src="<c:url value='/static/js/controller/endereco_controller.js' />"></script>
        <script src="<c:url value='/static/js/service/tipoServico_service.js' />"></script>
        <script src="<c:url value='/static/js/controller/tipoServico_controller.js' />"></script>
        <script src="<c:url value='/static/js/service/acervo_service.js' />"></script>
        <script src="<c:url value='/static/js/controller/acervo_controller.js' />"></script>
        <script src="<c:url value='/static/js/config/acervo_config.js' />"></script>
        <script src="<c:url value='/static/js/controller/painel_controller.js' />"></script>
        <script src="<c:url value='/static/js/angular-flash.min.js'/>"></script>
        <script src="<c:url value='/static/js/googleMaps/ng-map.min.js'/>"></script>
        <script src=" http://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular-resource.js"></script>     
        <script src="<c:url value='/static/js/dataTable/dirPagination.js'/>"></script>
        <script src="<c:url value='/static/js/controller/table_controller.js' />"></script>
        <script src="<c:url value='/static/admin/js/plugins/input-mask/jquery.inputmask.js'/>" type="text/javascript"></script>
        <script src="<c:url value='/static/admin/js/plugins/input-mask/jquery.inputmask.extensions.js'/>" type="text/javascript"></script>
        <script src="<c:url value='/static/admin/js/ng-grid-panel.js'/>"></script>
        <script src="<c:url value='/static/admin/js/angular-animate.js'/>"></script>
        <script src="<c:url value='/static/admin/js/angular-bootstrap-lightbox.min.js'/>"></script>
        <script src="<c:url value='/static/admin/js/sweetalert.min.js'/>"></script>
        <script src="<c:url value='/static/admin/js/SweetAlert.js'/>"></script>
        <script src="<c:url value='/static/admin/js/functions.js'/>"></script>
        <script src="http://maps.google.com/maps/api/js"></script>
          
       <script type="text/javascript">
			$(document).ready(function(){
			 	 $(":input").inputmask();
			});
		</script>
 
        
</html>