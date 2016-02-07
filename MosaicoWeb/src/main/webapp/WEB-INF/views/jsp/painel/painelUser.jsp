<!-- Right side column. Contains the navbar and content of the page -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<aside class="right-side">
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<h1>
			Painel Empresa <small>Painel de Controle</small>
		</h1>
		<ol class="breadcrumb">
			<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
			<li class="active">Blank page</li>
		</ol>
	</section>

	<!-- Main content -->
	<section class="content">
		<div class="row" ng-app="mosaicoAppAdmin">
			<!-- left column -->
			
			<div class="col-md-6" ng-controller="PainelController as vm" >
			<h3>
			Localizacão dos Endereços cadastrados
			</h3>
				<ng-map zoom="7" center="[-22.18 , -43.23]" street-view-control="true">
			      <marker ng-repeat="p in vm.enderecos"
			        position="{{p.lat}},{{p.lng}}"
			        data="{{data[$index]}}"
			        title="pos: {{p.logradouro}}"
			        on-click="vm.showDetail(p)"
			        ></marker>
			       
			    </ng-map>
			    	
			</div>
		</div>
	</section>
	<!-- /.content -->
</aside>
<!-- /.right-side -->