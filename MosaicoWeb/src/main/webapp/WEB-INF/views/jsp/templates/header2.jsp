 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <header id="header" role="banner">
        <div class="container">
            <div id="navbar" class="navbar navbar-default">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="index.html"></a>
                </div>
                <div class="collapse navbar-collapse">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="#main-slider"><i class="icon-home"></i></a></li>
                        <li><a href="#services">Destaques</a></li>
                        <li><a href="#portfolio">Serviços</a></li>
                        <li><a href="#pricing">Preços</a></li>
                        <li><a href="#about-us">Sobre</a></li>
                        <li><a href="#contact">Contato</a></li>
                        <li><a href="#" data-toggle="modal" data-target="#login-modal">Login</a></li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="modal fade" id="login-modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
    	<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header" align="center">
					<img class="img-circle" id="img_logo" src="http://bootsnipp.com/img/logo.jpg">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
					</button>
				</div>
                
                <!-- Begin # DIV Form -->
                <div id="div-forms">
                
                    <!-- Begin # Login Form -->
                    <c:url var="loginUrl" value="/home" />
                     <form action="${pageContext.request.contextPath}/home/authenticate" method="post" class="form-horizontal" id="login-form"> 
		                <div class="modal-body">
				    		
				    		<input id="email" class="form-control"  name="email" required="required" type="text" type="text" placeholder="Email" required>
				    		<input id="senha" class="form-control" type="password" placeholder="Senha" required name="senha">
                            
        		    	</div>
				        <div class="modal-footer">
                            <div>
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                                <button type="submit" class="btn btn-primary btn-lg btn-block">Login</button>
                            </div>
				    	    <div>
				    	        
<!--                                 <button id="login_lost_btn" type="button" class="btn btn-link">Lost Password?</button> -->
                                <button id="login_register_btn" type="button" class="btn btn-link">Registrar</button>
                            </div>
				        </div>
                    </form>
                    <!-- End # Login Form -->
                    
                    <!-- Begin | Lost Password Form -->
                    <form  id="lost-form" style="display:none;">
    	    		    <div class="modal-body">
		    				<div id="div-lost-msg">
                                <div id="icon-lost-msg" class="glyphicon glyphicon-chevron-right"></div>
                                <span id="text-lost-msg">Type your e-mail.</span>
                            </div>
		    				<input id="lost_email" class="form-control" type="text" placeholder="E-Mail (type ERROR for error effect)" required>
            			</div>
		    		    <div class="modal-footer">
                            <div>
                                <button type="submit" class="btn btn-primary btn-lg btn-block">Send</button>
                            </div>
                            <div>
                                <button id="lost_login_btn" type="button" class="btn btn-link">Log In</button>
                                <button id="lost_register_btn" type="button" class="btn btn-link">Registrar</button>
                            </div>
		    		    </div>
                    </form>
                    <!-- End | Lost Password Form -->
                    
                    <!-- Begin | Register Form -->
                    <div  ng-controller="UsuarioController as ctrl">
                    <form ng-submit="ctrl.submit()" name="myForm" id="register-form" style="display:none;">
            		    <div class="modal-body">
		    				
                            <input ng-model="ctrl.usuario.email" name="email" id="register_email" class="form-control" type="text" placeholder="E-Mail" required>
                            <input ng-model="ctrl.usuario.senha" name="senha" id="register_password" class="form-control" type="password" placeholder="Password" required>
            			</div>
		    		    <div class="modal-footer">
                            <div>
                                <button type="submit" class="btn btn-primary btn-lg btn-block" ng-disabled="myForm.$invalid">Registrar</button>
                            </div>
                            <div>
                                <button id="register_login_btn" type="button" class="btn btn-link">Log In</button>
<!--                                 <button id="register_lost_btn" type="button" class="btn btn-link">Lost Password?</button> -->
                            </div>
		    		    </div>
                    </form>
                    </div>
                    <!-- End | Register Form -->
                    
                </div>
                <!-- End # DIV Form -->
                
			</div>
		</div>
	</div>
    </header><!--/#header-->

    <section id="main-slider" class="carousel">
        <div class="carousel-inner">
            <div class="item active">
                <div class="container">
                    <div class="carousel-content">
                        <h1>Venha fazer parte desse time</h1>
                        <p class="lead">Registre seu negócio, vamos mostrar seu trabalho</p>
                    </div>
                </div>
            </div><!--/.item-->
            <div class="item">
                <div class="container">
                    <div class="carousel-content">
                        <h1>Procure os Melhores Profissionais</h1>
                        <p class="lead">Fotos, endereços e comentários de clientes tudo para sua melhor escolha</p>   
                    </div>
                </div>
            </div><!--/.item-->
        </div><!--/.carousel-inner-->
        <a class="prev" href="#main-slider" data-slide="prev"><i class="icon-angle-left"></i></a>
        <a class="next" href="#main-slider" data-slide="next"><i class="icon-angle-right"></i></a>
    </section>