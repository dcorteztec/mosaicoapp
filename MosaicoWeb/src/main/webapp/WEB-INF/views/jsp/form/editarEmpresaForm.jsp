<!-- Right side column. Contains the navbar and content of the page -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<aside class="right-side">
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<h1>
			Edite sua Empresa <small>Painel de Controle</small>
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
				<form:form method="POST" action="/mosaicoDeIdeias/primeiro_acesso" modelAttribute="empresa" enctype="multipart/form-data">
				<div > 
					<div class="box box-primary" style="height: 200px" >
						<div class="box-header">
							<h3 class="box-title">Dados Gerais</h3>
						</div>
						<div class="box-body">
							<div class="col-xs-12">
								<div class="form-group">
									<label for="nomeEmpresa">Nome da Empresa</label> <input
										type="text" class="form-control" id="nomeEmpresa"
										placeholder="Nome da Empresa" name="nome" required="required" value="${empresa.nome}">
								</div>
							</div>
							<div class="col-xs-4">
								<div class="form-group">
									<label for="telefone">Telefone</label>
									<div class="input-group">
                                            <div class="input-group-addon">
                                                <i class="fa fa-phone"></i>
                                            </div> 
										<input type="text"
											class="form-control" id="telefone" name="telefone" placeholder="Telefone"
											required="required" data-inputmask='"mask": "9999-9999"' data-mask value="${empresa.telefone}">
									</div>	
								</div>
							</div>
							<div class="col-xs-4">
								<div class="form-group">
									<label for="cel">Celular</label> 
									<div class="input-group">
                                            <div class="input-group-addon">
                                                <i class="fa fa-phone"></i>
                                            </div> 
										<input type="text"
											class="form-control" id="cel" name="celular" placeholder="Celular" data-inputmask='"mask": "99999-9999"' data-mask value="${empresa.celular}">
									</div>	
								</div>
							</div>
							<div class="col-xs-6">
								<div class="form-group">
									<label for="site">Site</label> <input type="text"
										class="form-control" id="site" name="site" placeholder="Site" value="${empresa.site}">
								</div>
							</div>
							<div class="col-xs-6">
								<div class="form-group">
									<label for="site">Upload Logo</label> <input type="file"
										class="form-control" id="file" name="file" />
								</div>
							</div>
							
							<div class="col-xs-6">
								<div class="form-group">
								 <label for="check">Serviços Atendidos</label>
								  <div class="row-fluid" data-channel-checkboxes="#" style="row-fluid1">
									<table>
									    <c:forEach items="${tServicos}" var="filter" varStatus="status">
									        <tr>
									            <td><form:checkbox 
								                        path="tServicos" 
								                        label="${filter.nome}" 
								                        value="${filter.id}" 
								                        checked="${filter.check ? 'true' : ''}" />
									            </td>
									        </tr>
									    </c:forEach>
									</table>
                                   </div>
								</div>
							</div>
						</div>
						</div>
											
					<div class="col-xs-8">
						<div class="form-group">
							<button type="submit" class="btn btn-primary">Enviar</button>
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