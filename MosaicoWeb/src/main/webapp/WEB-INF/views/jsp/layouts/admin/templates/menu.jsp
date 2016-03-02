<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

 <div class="user-panel">
                        <div class="pull-left image">
                            <img src="<c:url value='/static/admin/img/avatar3.png'/>"class="img-circle" alt="User Image" />
                        </div>
                        <div class="pull-left info">
                            <p>Hello, ${usuario} </p>

                            <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
                        </div>
                    </div>
                    <!-- search form -->
                    <form action="#" method="get" class="sidebar-form">
                        <div class="input-group">
                            <input type="text" name="q" class="form-control" placeholder="Search..."/>
                            <span class="input-group-btn">
                                <button type='submit' name='seach' id='search-btn' class="btn btn-flat"><i class="fa fa-search"></i></button>
                            </span>
                        </div>
                    </form>
                    <!-- /.search form -->
                    <!-- sidebar menu: : style can be found in sidebar.less -->
                    <ul class="sidebar-menu">
                    <sec:authorize access="hasRole('USUARIO')">
                        <li class="active">
                            <a href="<c:url value='/painel'/>"> 
                                <i class="fa fa-dashboard"></i> <span>Dashboard</span>
                           </a> 
                        </li>
                    </sec:authorize>
                    <sec:authorize access="hasRole('ADMIN')">
                        <li class="active">
                            <a href="<c:url value='/admin'/>"> 
                                <i class="fa fa-dashboard"></i> <span>Dashboard</span>
                           </a> 
                        </li>
                    </sec:authorize>
                     <c:if test="${empresa.nome ne null}">
                        
 					<sec:authorize access="hasRole('USUARIO')">
                        <li class="treeview">
                            <a href="#">
                                <i class="fa fa-edit"></i> <span>Dados Gerais</span>
                                <i class="fa fa-angle-left pull-right"></i>
                            </a>
                            <ul class="treeview-menu">
                                <li><a href="<c:url value='/painel/endereco'/>"><i class="fa fa-angle-double-right"></i> Endereço</a></li>                            
                            </ul>
                        </li>
                        <li class="treeview">
                            <a href="#">
                                <i class="fa fa-laptop"></i> <span>Midias</span>
                                <i class="fa fa-angle-left pull-right"></i>
                            </a>
                            <ul class="treeview-menu">
                                <li><a href="<c:url value='/painel/uploads'/>"><i class="fa fa-angle-double-right"></i>Uploads de Fotos</a></li>
                                <li><a href="<c:url value='/painel/acervo'/>"><i class="fa fa-angle-double-right"></i>Acervo de Fotos</a></li> 
                                <li><a href="<c:url value='/painel/socialMedias'/>"><i class="fa fa-angle-double-right"></i>Midias Sociais</a></li>
                                                             
                            </ul>
                        </li>
                        <li>
                            <a href="<c:url value='/painel/mensagem'/>">
                                <i class="fa fa-envelope"></i> <span>Mensagem</span>
<!--                                 <small class="badge pull-right bg-yellow">12</small> -->
                            </a>
                        </li>
                    </sec:authorize>
                    </c:if>
                        <sec:authorize access="hasRole('ADMIN')">
                         <li class="treeview">
                            <a href="#">
                                <i class="fa fa-edit"></i> <span>Administração</span>
                                <i class="fa fa-angle-left pull-right"></i>
                            </a>
                            <ul class="treeview-menu">
                                <li><a href="<c:url value='/admin/tipoServico'/>"><i class="fa fa-angle-double-right"></i> Tipos de Serviços</a></li>                            
                            </ul>
                        </li>
                        <li>
                            <a href="<c:url value='/admin/mensagem'/>">
                                <i class="fa fa-envelope"></i> <span>Mensagem</span>
<!--                                 <small class="badge pull-right bg-yellow">12</small> -->
                            </a>
                        </li>
                        </sec:authorize>
                    </ul>