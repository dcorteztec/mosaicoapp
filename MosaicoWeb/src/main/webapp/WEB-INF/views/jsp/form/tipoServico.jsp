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
				<form:form method="POST" modelAttribute="tipoServico" role="form">
				<div > 
					<div class="box box-primary" style="height: 200px" >
						<div class="box-header">
							<h3 class="box-title">Tipos De Serviços</h3>
						</div>
						<div class="box-body">
							<div class="col-xs-12">
								<div class="form-group">
									<label for="nome">Nome</label> <input
										type="text" class="form-control" id="nome"
										placeholder="Nome" name="nome" required="required">
								</div>
							</div>
							<div class="col-xs-4">
								<div class="form-group">
									<label for="descricao">Descrição</label> <input type=""
										class="form-control" id="descricao" name="descricao" placeholder="Descrição"
										required="required">
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