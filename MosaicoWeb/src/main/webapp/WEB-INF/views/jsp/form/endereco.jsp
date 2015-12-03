<!-- Right side column. Contains the navbar and content of the page -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<aside class="right-side">
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<h1>
			Cadastre sua Empresa <small>Painel de Controle</small>
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
			<div class="col-md-6">
				<!-- general form elements -->

				<!-- /.box-header -->
				<!-- form start -->
				<form:form method="POST" modelAttribute="endereco" role="form">
				<div  ng-controller="Cep"> 
						<div class="box box-success">
							<div class="box-header">
								<h3 class="box-title">Endereço</h3>
							</div>
							<div class="box-body"></div>
							<div class="col-xs-5">
								<div class="form-group">
									<label for="cepId">CEP</label> <input type="text"
										class="form-control" id="cepId" ng-model="cep" placeholder="CEP"
										required="required" ng-blur="cepRest()">
								</div>
							</div>
							<div class="col-xs-9">
								<div class="form-group">
									<label for="logradouro">Logradouro</label> <input type="text"
										class="form-control" id="logradouro" placeholder="Logradouro"
										required="required" value="{{end.logradouro}}">
								</div>
							</div>
							<div class="col-xs-3">
								<div class="form-group">
									<label for="numero">Número</label> <input type="text"
										class="form-control" id="numero" placeholder="Número"
										required="required" >
								</div>
							</div>
							<div class="col-xs-10">
								<div class="form-group">
									<label for="complemento">Complemento</label> <input type="text"
										class="form-control" id="complemento"
										placeholder="Complemento">
								</div>
							</div>
							<div class="col-xs-3">
								<div class="form-group">
									<label for="estado">Estado</label> <input type="text"
										class="form-control" id="estado" placeholder="Estado"
										readonly="readonly" value="RJ">
								</div>
							</div>
							<div class="col-xs-5">
								<div class="form-group">
									<label for="cidade">Cidade</label> <input type="text"
										class="form-control" id="cidade" placeholder="Cidade"
										required="required" value={{end.cidade}}>
								</div>
							</div>
							<div class="col-xs-5">
								<div class="form-group">
									<label for="bairro">Bairro</label> <input type="text"
										class="form-control" id="bairro" placeholder="Bairro"
										required="required" value={{end.bairro}}>
								</div>
							</div>
							<div class="col-xs-5">
								<div class="form-group">
									 <input type="hidden"
										class="form-control" id="latitude" placeholder="Latitude"
										required="required" value={{geo.results[0].geometry.location.lat}}>
								</div>
							</div>
							<div class="col-xs-5">
								<div class="form-group">
									<input type="hidden"
										class="form-control" id="longitude" placeholder="Longitude"
										required="required" value={{geo.results[0].geometry.location.lng}}>
								</div>
							</div>
						</div>
					
					<div class="col-xs-8">
						<div class="form-group">
							<button type="submit" ng-click="getLatLng()" class="btn btn-primary">Enviar</button>
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