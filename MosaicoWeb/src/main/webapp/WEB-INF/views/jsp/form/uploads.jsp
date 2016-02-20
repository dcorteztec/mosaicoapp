<!-- Right side column. Contains the navbar and content of the page -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<aside class="right-side">
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<h1>
			Upload de Imagens <small>Painel de Controle</small>
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
			<div class="col-md-6"  ng-app="mosaicoAppAdmin">
				<!-- general form elements -->

				<!-- /.box-header -->
				<!-- form start -->
				<form:form method="POST" action="/mosaicoDeIdeias/painel/uploads"
					modelAttribute="upload" enctype="multipart/form-data">
					<div class="box box-primary" style="height: 200px" ng-controller="AcervoController as ctrl">
					<div ng-repeat='item in filtered = (ctrl.acervos | filter:filterExpr)'></div>
						<div class="box-header">
							<h3 class="box-title">Upload de Imagens - Quantidade de imagens armazenada {{counter}} limite de 15</h3>
							
						</div>
						<form:input type="hidden" path="id" id="id"/>
						<div class="box-body">

							<TABLE id="fuTable" class="table table-bordered">
								<TR>
									<td><input type="file" id="files"
										name="files" /></td>
								</TR>
							</TABLE>

						
						<div class="col-xs-12">
							<div class="form-group">
								<a ng-click="add()">Mais Fotos</a>
							</div>
						</div>
						
						<div class="col-xs-8">
							<div class="form-group">
								<button type="submit" class="btn btn-primary">Enviar</button>
							</div>
						</div>
						</div>
					</div>
				</form:form>
				<!-- /.box -->
			</div>
		</div>
		
	</section>
	<!-- /.content -->
</aside>
<!-- /.right-side -->