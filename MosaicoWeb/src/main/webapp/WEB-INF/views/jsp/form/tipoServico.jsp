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
			<div class="col-md-6" ng-app="mosaicoAppAdmin">
				<!-- general form elements -->

				<!-- /.box-header -->
				<!-- form start -->

				<div class="generic-container">

					<div ng-controller="TipoServicoController as ctrl">
						<form ng-submit="ctrl.submit()" name="myForm"
							class="form-horizontal">
							<input type="hidden" ng-model="ctrl.tipoServico.id" />

							<div class="box box-primary" style="height: 400px">
								<div class="box-header">
									<h3 class="box-title">Tipos De Serviços</h3>
								</div>
								<div flash-message="5000" ></div> 
								<div class="box-body">
									<div class="col-xs-12">
										<div class="form-group">
											<label for="nome"><spring:message code="campo.nome"/></label> <input type="text"
												class="form-control" ng-model="ctrl.tipoServico.nome"
												name="nome" placeholder="Nome" required ng-minlength="3" />
											<div class="has-error" ng-show="myForm.$dirty">
												<span ng-show="myForm.descricao.$error.required"><spring:message code="campo.obrigatorio"/></span> 
												<span ng-show="myForm.descricao.$error.minlength">O minimo para é esse campo é tamanho 3</span> 
<!-- 												<span ng-show="myForm.descricao.$invalid">This field isinvalid </span> -->
											</div>
										</div>
									</div>
									<div class="col-xs-4">
										<div class="form-group">
											<label for="descricao">Descrição</label>
											<textarea rows="10" cols="60"
												ng-model="ctrl.tipoServico.descricao" name="descricao"></textarea>
											<div class="has-error" ng-show="myForm.$dirty">
												<span ng-show="myForm.descricao.$error.required"><spring:message code="campo.obrigatorio"/></span> 
<!-- 												<span ng-show="myForm.descricao.$error.minlength"></span>  -->
<!-- 												<span ng-show="myForm.descricao.$invalid">This field isinvalid </span> -->

											</div>
										</div>
									</div>
								</div>

								<div class="col-xs-8">
									<div class="form-group">
									
									
										<div class="form-actions floatRight">
											<input type="submit"
												value="{{!ctrl.tipoServico.id ? '<spring:message code="campo.add"/>' : '<spring:message code="campo.update"/>'}}"
												class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid">
											<button type="button" ng-click="ctrl.reset()"
												class="btn btn-warning btn-sm"
												ng-disabled="myForm.$pristine"><spring:message code="campo.resetar"/></button>
										</div>
									</div>
								</div>
							</div>
						</form>


						<div class="panel panel-default">
							<!-- Default panel contents -->
						</div>


												
													<div class="tablecontainer">

														<div class="box-body table-responsive">
															<table class="table table-condensed table-bordered table-striped">
																<thead>
																	<tr>
																	<td>
																		<spring:message code="campo.cod"/>
																		<input type="text" class="form-control" ng-model="search.id" name="cod" placeholder="Cod"/>
																	</td>
																	<td>
																		<spring:message code="campo.nome"/>
																		<input type="text" class="form-control" ng-model="search.nome" name="nome" placeholder="Nome"/>
																	</td>
																	<td>
																		<spring:message code="campo.descricao"/>
																		<input type="text" class="form-control" ng-model="search.descricao" name="desc" placeholder="Descrição"/>
																	</td>
																</tr>
																</thead>
																<tbody>
																	<tr dir-paginate="t in ctrl.tServicos | filter:search | itemsPerPage:5">
																		<td><span ng-bind="t.id"></span></td>
																		<td><span ng-bind="t.nome"></span></td>
																		<td><span ng-bind="t.descricao"></span></td>
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

					</div>
				</div>
			</div>
			<!-- /.box -->
	</section>

	<!-- /.content -->
</aside>
<!-- /.right-side -->