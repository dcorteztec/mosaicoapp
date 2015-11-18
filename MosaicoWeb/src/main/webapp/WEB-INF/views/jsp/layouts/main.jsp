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
		<link rel="stylesheet" href="<c:url value='/static/css/font-awesome.min.css'/>">
		<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700' rel='stylesheet' type='text/css'>
		<link rel="stylesheet" href="<c:url value='/static/css/templatemo-style.css'/>">
		<script src="<c:url value='/static/js/jquery.js'/>"></script>
		<script src="<c:url value='/static/js/bootstrap.min.js'/>"></script>
        <script src="<c:url value='/static/js/jquery.singlePageNav.min.js'/>"></script>
		<script src="<c:url value='/static/js/typed.js'/>"></script>
		<script src="<c:url value='/static/js/wow.min.js"'/>"></script>
		<script src="<c:url value='/static/js/custom.js"'/>"></script>
		<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
        <script src="<c:url value='/static/js/app.js' />"></script>
        <script src="<c:url value='/static/js/service/usuario_service.js' />"></script>
        <script src="<c:url value='/static/js/controller/usuario_controller.js' />"></script>
	</head>
  <body id="top"  ng-app="mosaicoApp">
  <!-- start preloader -->
		<div class="preloader">
			<div class="sk-spinner sk-spinner-wave">
     	 		<div class="sk-rect1"></div>
       			<div class="sk-rect2"></div>
       			<div class="sk-rect3"></div>
      	 		<div class="sk-rect4"></div>
      			<div class="sk-rect5"></div>
     		</div>
    	</div>
    
                <tiles:insertAttribute name="header" />
         
                <tiles:insertAttribute name="body" />
        
                <tiles:insertAttribute name="footer" />
          

   
  </body>
</html>