'use strict';
 
App.controller('IndexController', ['$scope', 'IndexService','SweetAlert','ngDialog', function($scope, IndexService,SweetAlert,ngDialog) {
	
	var self = this;
	self.empresa={id:null,nome:'',telefone:'',site:'',urlLogo:'',servicos:'', descricao:''};
	self.tipoServico={id:null,nome:'',descricao:''};
    self.tServicos=[];
    self.empresas=[];     
   
    self.fetchAllServices = function(){
    	IndexService.fetchAllServices()
            .then(
                         function(d) {
                              self.tServicos = d;
                         },
                          function(errResponse){
                              console.error('Error while fetching Service');
                          }
                 );
    };
    
    self.fetchAllEmpresas = function(){
    	IndexService.fetchAllEmpresas()
            .then(
                         function(d) {
                              self.empresas = d;
                         },
                          function(errResponse){
                              console.error('Error while fetching Service');
                          }
                 );
    };
    
    $scope.open = function (empresa) {
		    
			ngDialog.open({
				
				template: 	' <h2>'+ empresa.nome +'</h2>  <p><img src='+empresa.urlLogo+' alt="" align="left" height="150" width="150">'+empresa.descricao+'</p>'
				+'<a href="'+'/mosaicoDeIdeias/perfil/'+empresa.id+'">'+ 'Saiba mais' +'</a>',
				
				plain: true,
				className: 'ngdialog-theme-default ngdialog-theme-custom'
	});
		
	};
  
    self.fetchAllEmpresas();
    self.fetchAllServices();
	
}]);