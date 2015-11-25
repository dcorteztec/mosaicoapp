<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
  
        <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
        <!-- bootstrap 3.0.2 -->
        <link href="<c:url value='/static/admin/css/bootstrap.min.css'/>" rel="stylesheet" type="text/css" />
        <!-- font Awesome -->
        <link href="<c:url value='/static/admin/css/font-awesome.min.css'/>" rel="stylesheet" type="text/css" />
        <!-- Ionicons -->
        <link href="<c:url value='/static/admin/css/ionicons.min.css'/>" rel="stylesheet" type="text/css" />
        <!-- Theme style -->
       
        <link href="<c:url value='/static/admin/css/AdminLTE.css'/>" rel="stylesheet" type="text/css" />

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
            <a href="index.html" class="logo">
                <!-- Add the class icon to your logo image or logo icon to add the margining -->
                Mosaico
            </a>
           
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
        <!-- Bootstrap -->
        <script src="<c:url value='/static/admin/js/plugins/bootstrap.min.js'/>" type="text/javascript"></script>
        <!-- AdminLTE App -->
        <script src="<c:url value='/static/admin/js/plugins/AdminLTE/app.js'/>" type="text/javascript"></script>
</html>