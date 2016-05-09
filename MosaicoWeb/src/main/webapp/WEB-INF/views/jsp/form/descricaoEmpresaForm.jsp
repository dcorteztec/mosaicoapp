<!-- Right side column. Contains the navbar and content of the page -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<aside class="right-side">
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<h1>
			Crie a Descrição da sua Empresa <small>Painel de Controle</small>
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
				<form:form method="POST" action="/mosaicoDeIdeias/painel/criarDescricao"
					modelAttribute="empresa" enctype="multipart/form-data">
                     
                    <input type="hidden" name="id" value="${empresa.id}"/> 
                    
					<div class="box box-primary" style="height: 200px">
						
						<div class='box-header'>
							<h3 class='box-title'>
								Uma descrição Simples, mas eficaz, para seu cliente identificar o seu negócio.
							</h3>
							<!-- /. tools -->
						</div>
						<!-- /.box-header -->
						<div class='box-body pad'>
							<form>
								<textarea class="textarea" placeholder="Sua Descrição" name="descricao" id="descricao" required="required"
									style="width: 100%; height: 200px; font-size: 14px; line-height: 18px; border: 1px solid #dddddd; padding: 10px;" >
									${empresa.descricao}
									</textarea>
							</form>
						</div>

						<div class="col-xs-8">
							<div class="form-group">
								<button type="submit" class="btn btn-primary">Enviar</button>
							</div>
						</div>
					</div>
				</form:form>
			</div>



		</div>

		<!-- /.box -->
	</section>
	<!-- /.content -->
</aside>
<!-- /.right-side -->