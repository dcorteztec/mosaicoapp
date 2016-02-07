<!-- Right side column. Contains the navbar and content of the page -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<aside class="right-side">
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<h1>
			Social Medias <small>Painel de Controle</small>
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
				<form:form method="POST" action="/mosaicoDeIdeias/painel/socialMedias" modelAttribute="empresa" enctype="multipart/form-data">
				<div > 
					
						<div class="box-header">
							<h3 class="box-title">Social Medias</h3>
						</div>
						<form:input type="hidden" path="id" id="id"/>
						 
							<div class="box">

                                <div class="box-body">
                                     <a class="btn btn-block btn-social btn-facebook">
                                        <i class="fa fa-facebook"></i> O nome da sua pagina ex: www.facebook.com/teste/ somente teste
                                    </a>
                                    <div class="col-xs-12">
								    <div class="form-group">
	                                    <form:input
											type="text" class="form-control" id="facebook" 
											placeholder="Facebook" name="facebook" required="required" path="facebook" maxlength="50"/>                     
                                    </div>
                                    </div>
                                    <a class="btn btn-block btn-social btn-instagram">
	                                        <i class="fa fa-instagram"></i> O nome da sua pagina ex: www.instagram.com/teste/ somente teste
	                                    </a>
	                                <div class="col-xs-12">
								    <div class="form-group">    
	                                    <form:input
											type="text" class="form-control" id="instagram" 
											placeholder="Instagram" name="instagram" required="required" path="instagram" maxlength="50"/>
                                    </div>
                                    </div>
                                    <a class="btn btn-block btn-social btn-twitter">
	                                        <i class="fa fa-twitter"></i> O nome da sua pagina ex: www.twitter.com/teste somente teste
	                                </a>
                                    <div class="col-xs-12">
								    <div class="form-group">
                                     <form:input
										type="text" class="form-control" id="twitter" 
										placeholder="Twitter" name="twitter" required="required" path="twitter" maxlength="50"/>
									</div>
                                    </div>
									<a class="btn btn-block btn-social btn-pinterest">
                                        <i class="fa fa-pinterest"></i> O nome da sua pagina ex: br.pinterest.com/teste somente teste
                                    </a>
                                    <div class="col-xs-12">
								    <div class="form-group">
								        <form:input
											type="text" class="form-control" id="pintRest" 
											placeholder="Pintrest" name="pintRest" required="required" path="pintRest" maxlength="50"/>
									</div>
                                    </div>		
                                </div>
                            </div><!-- /.box -->
								
							
						</div>
						
											
					<div class="col-xs-8">
						<div class="form-group">
							<button type="submit" class="btn btn-primary"><spring:message code="campo.add"/></button>
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