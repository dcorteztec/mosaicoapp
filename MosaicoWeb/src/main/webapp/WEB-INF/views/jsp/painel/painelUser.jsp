<!-- Right side column. Contains the navbar and content of the page -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<aside class="right-side">
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<h1>
			Painel Empresa <small>Painel de Controle</small>
		</h1>
		<ol class="breadcrumb">
			<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
			<li class="active">Blank page</li>
		</ol>
	</section>
	<input type="hidden" id="perfil" value="${perfil}" />

	<!-- Main content -->
	<section class="content">
		<div ng-app="mosaicoAppAdmin">
			<!-- left column -->
			<input type="hidden" id="perfil" value="${perfil}" />
			<div ng-controller="PainelController as vm">

				<div class="row">
				
					<div class="col-md-4" ng-repeat="text in vm.mensagensUser" >
					
						<!-- Warning box -->
                           <div class="{{text.classe}}" id="{{text.id}}">
                           	<h3>Mensagem do Administrador</h3>
                                <div class="box-header">
                                    <h3 class="box-title">Data de envio {{text.dataHoraFormatada}}</h3>
                                    <div class="box-tools pull-right">
                                        <button type="button" class="{{text.classe}}"  data-toggle="tooltip" ng-click="vm.remove(text.id)" title="Remover"><i class="fa fa-times"></i></button>
                                    </div>
                                </div>
                                <div class="box-body">
                                   
                                    <p>
                                        {{text.texto}}
                                    </p>
                                </div><!-- /.box-body -->
                            </div><!-- /.box -->
					</div>
				</div>


				<div class="row">
					<div class="col-md-6">
						<h3>Localizacão dos Endereços cadastrados</h3>
						<ng-map zoom="7" center="[-22.18 , -43.23]"
							street-view-control="true"> <marker
							ng-repeat="p in vm.enderecos" position="{{p.lat}},{{p.lng}}"
							data="{{data[$index]}}" title="pos: {{p.logradouro}}"
							on-click="vm.showDetail(p)"></marker> </ng-map>

					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- /.content -->
</aside>
<!-- /.right-side -->