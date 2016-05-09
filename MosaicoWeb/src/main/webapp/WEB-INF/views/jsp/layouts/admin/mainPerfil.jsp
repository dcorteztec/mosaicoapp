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
        
        <link href="<c:url value='/static/admin/css/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css'/>" rel="stylesheet" type="text/css" />
        
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
                   
                  
                        <a href="<c:url value='/painel'/>" class="logo">
                        Mosaico
                        </a>
                 
           
           <nav class="navbar navbar-static-top" role="navigation">
                <!-- Sidebar toggle button-->
                <a href="#" class="navbar-btn sidebar-toggle" data-toggle="offcanvas" role="button">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </a>
                
            </nav>
        </header>
        <div class="wrapper row-offcanvas row-offcanvas-left">
            <!-- Left side column. contains the logo and sidebar -->
            <aside class="left-side sidebar-offcanvas collapse-left">                
                <!-- sidebar: style can be found in sidebar.less -->
<%--                 <section class="sidebar"> --%>
                    <!-- Sidebar user panel -->
<%--                   <tiles:insertAttribute name="menu" /> --%>
<%--                 </section> --%>
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
        <script src="<c:url value='/static/js/service/mensagem_service.js' />"></script>
        <script src="<c:url value='/static/js/controller/mensagem_controller.js' />"></script>
        <script src="<c:url value='/static/js/controller/perfilController.js' />"></script>
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
         <script src="<c:url value='/static/admin/js/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js'/>" charset="utf-8"></script>
        <script src="http://maps.google.com/maps/api/js"></script>
          
       <script type="text/javascript">
			$(document).ready(function(){
			 	 $(":input").inputmask();
			});
		</script>
 
        
</html>