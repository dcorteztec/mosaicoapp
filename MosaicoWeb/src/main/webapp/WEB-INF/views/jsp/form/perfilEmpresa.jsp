<!-- Right side column. Contains the navbar and content of the page -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<aside class="right-side strech">
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<h1>
			${empresa.nome} <small>Perfil</small>
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
			<div class="col-md-6">
				<!-- general form elements -->
                <input type="hidden" id="empresaId" value="${empresa.id}">
				<!-- /.box-header -->
				<div ng-controller="PerfilController as ctrl"> 
					<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
					  
					
					  <!-- Wrapper for slides -->
					  <div class="carousel-inner" role="listbox">
					    
						    <div class="item" ng-class="{active:!$index}" ng-repeat="img in ctrl.acervos">
						    <img ng-src="{{img.thumbUrl}}"  id="{{img.id}}" >
						      <div class="carousel-caption">
						        
						      </div>
						    </div>
					    
					  </div>
					
					  <!-- Controls -->
					  <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
					    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
					    <span class="sr-only">Previous</span>
					  </a>
					  <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
					    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
					    <span class="sr-only">Next</span>
					  </a>
					</div>
											
					
                </div>
				<!-- /.box -->
			</div>
		</div>
	</section>
	<!-- /.content -->
</aside>
<!-- /.right-side -->