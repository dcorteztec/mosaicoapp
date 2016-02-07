<!-- Right side column. Contains the navbar and content of the page -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
			<div class="col-md-6"  ng-app="mosaicoAppAdmin">
				<!-- general form elements -->

				<!-- /.box-header -->
				<!-- form start -->
				<div ng-controller="EnderecoController as ctrl" >
				<form ng-submit="ctrl.submit()" name="myForm"
							class="form-horizontal">
					
						<div class="box box-success">
						
							<div class="box-header">
								<h3 class="box-title">Endereço</h3>
							</div>
							<div flash-message="5000" ></div> 
							<div class="box-body"></div>
							<div class="col-xs-5">
								<div class="form-group">
								<input type="hidden"
										class="form-control" id="empresaId" ng-model="ctrl.endereco.empresaId" name="empresaId" value="${empresa.id}">
									<label for="empresaId">Empresa</label>
									<input type="text"
										class="form-control" id="empresa" name="empresa" value="${empresa.nome}" disabled="disabled" >
<%-- 									<form:select path="nomeEmpresa" cssClass="form-control" cssStyle="form-control" disabled="true"> --%>
<%-- 										<form:options items="${empresas}" itemLabel="nome" itemValue="id" disabled="true"/> --%>
<%-- 									</form:select> --%>
								</div>
							</div>
							<div class="col-xs-5">
								<div class="form-group">
									<label for="cepId">CEP</label> <input type="text"
										class="form-control" id="cepId" ng-model="ctrl.endereco.cep" name="cep"
										placeholder="CEP" required="required" ng-blur="cepRest()" data-inputmask='"mask": "99999-999"' data-mask>
								</div>
							</div>
							<div class="col-xs-9">
								<div class="form-group">
									<label for="logradouro">Logradouro</label> <input type="text" ng-model="ctrl.endereco.logradouro"
										class="form-control" id="logradouro" placeholder="Logradouro"
										required="required" name="logradouro"
										value="{{end.logradouro}}">
								</div>
							</div>
							<div class="col-xs-3">
								<div class="form-group">
									<label for="numero">Número</label> <input type="text" ng-blur="cepRest()" ng-model="ctrl.endereco.numero"
										class="form-control" id="numero" placeholder="Número"
										required="required" name="numero">
								</div>
							</div>
							<div class="col-xs-10">
								<div class="form-group">
									<label for="complemento">Complemento</label> <input type="text"
										class="form-control" id="complemento" ng-model="ctrl.endereco.complemento"
										placeholder="Complemento" name="complemento">
								</div>
							</div>
							<div class="col-xs-3">
								<div class="form-group">
									<label for="estado">Estado</label> <input type="text"
										class="form-control" id="estado" placeholder="Estado" ng-model="ctrl.endereco.estado"
										readonly="readonly" value="RJ" name="estado">
								</div>
							</div>
							<div class="col-xs-5">
								<div class="form-group">
									<label for="cidade">Cidade</label> <input type="text"
										class="form-control" id="cidade" placeholder="Cidade" ng-model="ctrl.endereco.cidade"
										required="required" value={{end.cidade}} name="cidade">
								</div>
							</div>
							<div class="col-xs-5">
								<div class="form-group">
									<label for="bairro">Bairro</label> <input type="text"
										class="form-control" id="bairro" placeholder="Bairro"  ng-model="ctrl.endereco.bairro"
										required="required" value={{end.bairro}} name="bairro">
								</div>
							</div>
							<div class="col-xs-5">
								<div class="form-group">
									<input type="hidden" class="form-control" id="latitude"
										placeholder="Latitude"  ng-model="ctrl.endereco.lat"
										value={{geo.results[0].geometry.location.lat}} name="lat">
								</div>
							</div>
							<div class="col-xs-5">
								<div class="form-group">
									<input type="hidden" class="form-control" id="longitude" 
										placeholder="Longitude"  ng-model="ctrl.endereco.lng"
										value={{geo.results[0].geometry.location.lng}} name="lng">
								</div>
							</div>
						</div>

						<div class="col-xs-8">
						<div class="form-group">
						<div class="form-actions floatRight">
											<input type="submit"
												value="{{!ctrl.endereco.id ? '<spring:message code="campo.add"/>' : '<spring:message code="campo.update"/>'}}"
												class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid">
											<button type="button" ng-click="ctrl.reset()"
												class="btn btn-warning btn-sm"
												ng-disabled="myForm.$pristine"><spring:message code="campo.resetar"/></button>
										</div>
							</div>
						</div>
					
				</form>
				<div class="tablecontainer">

								<div class="box-body table-responsive">
									<table class="table table-condensed table-bordered table-striped">
										<thead>
											<tr>
											<td>
												Cod
												<input type="text" class="form-control" ng-model="search.id" name="cod" placeholder="Cod"/>
											</td>
											<td>
												Empresa
												<input type="text" class="form-control" ng-model="search.empresa" name="nome" placeholder="Empresa"/>
											</td>
											<td>
												CEP
												<input type="text" class="form-control" ng-model="search.cep" name="desc" placeholder="CEP" data-inputmask='"mask": "99999-999"' data-mask/>
											</td>
										</tr>
										</thead>
										<tbody>
											<tr dir-paginate="t in ctrl.enderecos | filter:search | itemsPerPage:5">
												<td><span ng-bind="t.id"></span></td>
												<td><span ng-bind="t.empresa.nome"></span></td>
												<td><span ng-bind="t.cep"></span></td>
												<td>
													<button type="button" ng-click="ctrl.edit(t.id)"
														class="btn btn-success custom-width"><spring:message code="campo.update"/></button>
													<button type="button" ng-click="ctrl.remove(t.id)"
														class="btn btn-danger custom-width"><spring:message code="campo.remover"/></button>
												</td>
											</tr>
										</tbody>
									</table>
									 <dir-pagination-controls
								        max-size="5"
								        direction-links="true"
								        boundary-links="true" >
								    </dir-pagination-controls>
								</div>


							</div>
				</div>
				<!-- /.box -->
			</div>
		</div>
	</section>
	<!-- /.content -->
</aside>
<!-- /.right-side -->