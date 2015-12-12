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
                        <li class="active">
                            <a href=""> 
                                <i class="fa fa-dashboard"></i> <span>Dashboard</span>
                           </a> 
                        </li>
<!--                         <li class="treeview"> -->
<!--                             <a href="#"> -->
<!--                                 <i class="fa fa-bar-chart-o"></i> -->
<!--                                 <span>Charts</span> -->
<!--                                 <i class="fa fa-angle-left pull-right"></i> -->
<!--                             </a> -->
<!--                             <ul class="treeview-menu"> -->
<!--                                 <li><a href="pages/charts/morris.html"><i class="fa fa-angle-double-right"></i> Morris</a></li> -->
<!--                                 <li><a href="pages/charts/flot.html"><i class="fa fa-angle-double-right"></i> Flot</a></li> -->
<!--                                 <li><a href="pages/charts/inline.html"><i class="fa fa-angle-double-right"></i> Inline charts</a></li> -->
<!--                             </ul> -->
<!--                         </li> -->
<!--                         <li class="treeview"> -->
<!--                             <a href="#"> -->
<!--                                 <i class="fa fa-laptop"></i> -->
<!--                                 <span>Dados Gerais</span> -->
<!--                                 <i class="fa fa-angle-left pull-right"></i> -->
<!--                             </a> -->
<!--                             <ul class="treeview-menu"> -->
<!--                                 <li><a href="pages/UI/general.html"><i class="fa fa-angle-double-right"></i> General</a></li> -->
<!--                                 <li><a href="pages/UI/icons.html"><i class="fa fa-angle-double-right"></i> Icons</a></li> -->
<!--                             </ul> -->
<!--                         </li> -->
                        <li class="treeview">
                            <a href="#">
                                <i class="fa fa-edit"></i> <span>Dados Gerais</span>
                                <i class="fa fa-angle-left pull-right"></i>
                            </a>
                            <ul class="treeview-menu">
                                <li><a href="<c:url value='/admin/endereco'/>"><i class="fa fa-angle-double-right"></i> Endereço</a></li>                            
                            </ul>
                        </li>
                         <li class="treeview">
                            <a href="#">
                                <i class="fa fa-edit"></i> <span>Administração</span>
                                <i class="fa fa-angle-left pull-right"></i>
                            </a>
                            <ul class="treeview-menu">
                                <li><a href="<c:url value='/admin/tipoServico'/>"><i class="fa fa-angle-double-right"></i> Tipos de Serviços</a></li>                            
                            </ul>
                        </li>
                     
                    </ul>