<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> --%>
<!-- start header -->
        <header>
            <div class="container">
                <div class="row">
                    <div class="col-md-5 col-sm-4 col-xs-12">
                        <ul class="social-icon">
                            <li><span>Meet us on</span></li>
                            <li><a href="#" class="fa fa-facebook"></a></li>
                            <li><a href="#" class="fa fa-twitter"></a></li>
                            <li><a href="#" class="fa fa-instagram"></a></li>
                            <li><a href="#" class="fa fa-apple"></a></li>
                        </ul>
                    </div>
                    <div class="col-md-6 col-sm-4 col-xs-12  wow fadeInLeft" data-wow-offset="50" data-wow-delay="0.9s">
	                   <c:url var="loginUrl" value="/home" />
                        <form action="${loginUrl}" method="post" class="form-horizontal">
                             <c:if test="${param.error != null}">
                                <div class="alert alert-danger">
                                    <p>Invalid username and password.</p>
                                </div>
                            </c:if>
<%--                             <c:if test="${param.error == null}"> --%>
<!--                                 <div class="alert alert-success"> -->
<!--                                     <p>You have been logged out successfully.</p> -->
<!--                                 </div> -->
<%--                             </c:if> --%>
		                        <ul  class="social-icon">
		                            <li><input placeholder="Email" name="email" required="required" type="text" class="form-controlCustom" id="email" ></li>
		                            <li><input placeholder="Senha" name="senha" required="required" type="password" class="form-controlCustom" id="senha" ></li>
		                             <li>  <input type="hidden" name="${_csrf.parameterName}"
                                value="${_csrf.token}" />
		                            <li> <input type="submit" class="form-controlCustom" value="Login"></li>
		                         
		                        </ul>
	                    </form>    
                    </div>
                </div>
            </div>
        </header>
        <!-- end header -->
        <!-- start navigation -->
		<nav class="navbar navbar-default templatemo-nav" role="navigation">
			<div class="container">
				<div class="navbar-header">
					<button class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
						<span class="icon icon-bar"></span>
						<span class="icon icon-bar"></span>
						<span class="icon icon-bar"></span>
					</button>
					<a href="#" class="navbar-brand">Awesome</a>
				</div>
				<div class="collapse navbar-collapse">
					<ul class="nav navbar-nav navbar-right">
						<li><a href="#top">HOME</a></li>
						<li><a href="#about">SOBRE</a></li>
						<li><a href="#cadastroUsuario">REGISTRO</a></li>
						<li><a href="#service">SERVICE</a></li>
						<li><a href="#portfolio">PORTFOLIO</a></li>
						<li><a href="#contact">CONTACT</a></li>
					</ul>
				</div>
			</div>
		</nav>
		<!-- end navigation -->
		<!-- start home -->
    	<section id="home">
    		<div class="container">
    			<div class="row">
    				<div class="col-md-offset-2 col-md-8">
    					<h1 class="wow fadeIn" data-wow-offset="50" data-wow-delay="0.9s">We make templates that are <span>awesome</span></h1>
    					<div class="element">
                            <div class="sub-element">Hello, this is Typed.js</div>
                            <div class="sub-element">Awesome Template is provided by templatemo.com website for everyone</div>
                            <div class="sub-element">Download, edit and apply this awesome template for your websites</div>
                        </div>
    					<a data-scroll href="#cadastroUsuario" class="btn btn-default wow fadeInUp" data-wow-offset="50" data-wow-delay="0.6s">Vamos Começar ?</a>
    				</div>
    			</div>
    		</div>
    	</section>
    	<!-- end home -->