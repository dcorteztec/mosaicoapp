<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
 <head>
		<meta charset="utf-8">
	
		<meta name="keywords" content="">
		<meta name="description" content="">
		<meta http-equiv="X-UA-Compatible" content="IE=Edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		
		<link rel="stylesheet" href="<c:url value='/static/css/animate.min.css' />">
		<link rel="stylesheet" href="<c:url value='/static/css/bootstrap.css' />">
		<link rel="stylesheet" href="<c:url value='/static/css/custom.css' />">
		<link rel="stylesheet" href="<c:url value='/static/css/main.css' />">
		<link rel="stylesheet" href="<c:url value='/static/css/prettyPhoto.css' />">
		<link rel="stylesheet" href="<c:url value='/static/css/font-awesome.min.css'/>">
		<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700' rel='stylesheet' type='text/css'>
		<link rel="stylesheet" href="<c:url value='/static/css/angular-flash.min.css'/>">
		<link href="<c:url value='/static/admin/css/angular-bootstrap-lightbox.css'/>" rel="stylesheet" type="text/css" />
		<link href="<c:url value='/static/admin/css/sweetalert.css'/>" rel="stylesheet" type="text/css" />
		<link rel="shortcut icon" href="images/ico/favicon.ico">
	    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="images/ico/apple-touch-icon-144-precomposed.png">
	    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="images/ico/apple-touch-icon-114-precomposed.png">
	    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="images/ico/apple-touch-icon-72-precomposed.png">
	    <link rel="apple-touch-icon-precomposed" href="images/ico/apple-touch-icon-57-precomposed.png">
	    </head>
  <body id="top" data-spy="scroll" data-target="#navbar" data-offset="0"  ng-app="mosaicoApp" class="ng-cloak">
  <!-- start preloader -->
		
                <tiles:insertAttribute name="header" />
         
                <tiles:insertAttribute name="body" />
        
                <tiles:insertAttribute name="footer" />
          

        <script src="<c:url value='/static/js/jquery.js'/>"></script>
		
		<script src="<c:url value='/static/js/bootstrap.min.js'/>"></script>
        <script src="<c:url value='/static/js/jquery.singlePageNav.min.js'/>"></script>
        <script src="<c:url value='/static/js/jquery.isotope.min.js'/>"></script>
        <script src="<c:url value='/static/js/jquery.prettyPhoto.js'/>"></script>
        <script src="<c:url value='/static/js/main.js'/>"></script>
        <script src="<c:url value='/static/js/login.js'/>"></script>
		<script src="<c:url value='/static/js/typed.js'/>"></script>
		<script src="<c:url value='/static/js/wow.min.js"'/>"></script>
		<script src="<c:url value='/static/js/custom.js"'/>"></script>
		<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
        <script src="<c:url value='/static/js/app.js' />"></script>
        <script src="<c:url value='/static/js/angular-isotope.min.js' />"></script>
         <script src="<c:url value='/static/js/config/index_config.js' />"></script>
        <script src="<c:url value='/static/js/service/usuario_service.js' />"></script>
        <script src="<c:url value='/static/js/controller/usuario_controller.js' />"></script>
        <script src="<c:url value='/static/js/angular-flash.min.js'/>"></script>
        <script src="<c:url value='/static/admin/js/angular-bootstrap-lightbox.min.js'/>"></script>
        <script src="<c:url value='/static/admin/js/sweetalert.min.js'/>"></script>
        <script src="<c:url value='/static/admin/js/SweetAlert.js'/>"></script>
        <script src="<c:url value='/static/js/sweet-alert-dev.js'/>"></script>
        <script src="<c:url value='/static/js/service/index_service.js' />"></script>
        <script src="<c:url value='/static/js/controller/index_controller.js' />"></script>
	
  </body>
</html>