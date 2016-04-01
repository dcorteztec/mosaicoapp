'use strict';
 
App.controller('IndexController', ['$scope', 'IndexService','SweetAlert','Lightbox', function($scope, IndexService,SweetAlert) {
	
	var self = this;
	self.empresa={id:null,nome:'',telefone:'',site:'',urlLogo:'',servicos:''};
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
  
    self.fetchAllEmpresas();
    self.fetchAllServices();
	
}]);