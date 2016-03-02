<!-- Right side column. Contains the navbar and content of the page -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<aside class="right-side">
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<h1>Enviar Mensagem para o painel de controle do Administrador</h1>
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

					<div ng-controller="MensagemController as ctrl">
						<form ng-submit="ctrl.submit()" name="myForm"
							class="form-horizontal">
							<input type="hidden" ng-model="ctrl.mensagem.id" /> <input
								type="hidden" id="perfil" value="${perfil}" />

							<div class="box box-primary" style="height: 400px">

								<div class="box-body">
									<div class="col-xs-10">
										<div class="form-group">
											<label for="texto">Mensagem</label>
											<div class='box'>
												<div class='box-header'>
													
													<!-- /. tools -->
												</div>
												<!-- /.box-header -->
												<div class="col-xs-5">
													<div class="form-group">
														<label for="cepId">Tipo</label> 
														<select ng-model="ctrl.mensagem.tipo" class="form-control" name="tipo" required>
			                                                <option value="SU">Sugestões</option>
			                                                <option value="AV">Aviso</option>
			                                                <option value="PR">Problemas</option>
			                                                <option value="AG">Agradecimentos</option>
														</select>
														<div class="has-error" ng-show="myForm.$dirty">
														<span ng-show="myForm.tipo.$error.required"><spring:message
																code="campo.obrigatorio" /></span> 
													</div>
													</div>
												</div>
												
                                                  
													<textarea ng-model="ctrl.mensagem.texto" required
														ng-minlength="10" name="texto" ng-maxlength="500"  class="textarea"
														placeholder="Escreva sua Mensagem"
														style="width: 100%; height: 200px; font-size: 14px; line-height: 18px; border: 1px solid #dddddd; padding: 10px;"></textarea>
													<div class="has-error" ng-show="myForm.$dirty">
														<span ng-show="myForm.texto.$error.required"><spring:message
																code="campo.obrigatorio" /></span> <span
															ng-show="myForm.texto.$error.minlength">O
															minimo para esse campo é tamanho 10</span>
															<span
															ng-show="myForm.texto.$error.maxlength">O
															máximo para esse campo é tamanho 500</span>
															
													</div>
												
											</div>


										</div>
									</div>
									<div class="col-xs-8">
									<div class="form-group">
										<div class="form-actions floatRight">
											<input type="submit"
												value="{{!ctrl.mensagem.id ? '<spring:message code="campo.add"/>' : '<spring:message code="campo.update"/>'}}"
												class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid">
											<button type="button" ng-click="ctrl.reset()"
												class="btn btn-warning btn-sm"
												ng-disabled="myForm.$pristine">
												<spring:message code="campo.resetar" />
											</button>
										</div>
									</div>
								</div>
								</div>

								
							</div>
						</form>
					</div>
				</div>
			</div>
			<!-- /.box -->
	</section>

	<!-- /.content -->
</aside>
<!-- /.right-side -->