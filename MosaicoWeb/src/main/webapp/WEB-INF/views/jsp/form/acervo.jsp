<!-- Right side column. Contains the navbar and content of the page -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<aside class="right-side">
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<h1>
			Acervo de Imagens <small>Painel de Controle</small>
		</h1>
		<ol class="breadcrumb">
			<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
			<li class="active">Blank page</li>
		</ol>
	</section>

	<!-- Main content -->
	<section class="content">
		<div class="row">
			<!-- left column -->
			<div class="col-md-6"  ng-app="mosaicoAppAdmin" id="divID">
				<!-- general form elements -->

				<!-- /.box-header -->
				<!-- form start -->
				<div ng-controller="AcervoController as ctrl" >
				<form ng-submit="ctrl.submit()" name="myForm"
							class="form-horizontal">
				<ul class="gallery gallery1" id="ulID">			
				<li ng-repeat="image in acervos" class="dropdown notifications-menu">
				    <a ng-click="openLightboxModal($index)">
				      <img ng-src="{{image.thumbUrl}}"  class="img-circle">
				    </a>
				    
				 </li>			
				</ul>			
			
                </form>
				</div>
				<!-- /.box -->
			</div>
		</div>
	</section>
	<!-- /.content -->
</aside>
<!-- /.right-side -->