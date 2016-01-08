'use strict';
 
AppAdmin.controller('TipoServicoController', ['$scope', 'TipoServicoService', function($scope, TipoServicoService) {
          var self = this;
          self.tipoServico={id:null,nome:'',descricao:''};
          self.tServicos=[];
               
         
          self.fetchAllServices = function(){
        	  TipoServicoService.fetchAllServices()
                  .then(
                               function(d) {
                                    self.tServicos = d;
                               },
                                function(errResponse){
                                    console.error('Error while fetching Currencies');
                                }
                       );
          };
            
          self.createService = function(tServico){
        	  TipoServicoService.createService(tServico)
                      .then(
                      self.fetchAllServices, 
                              function(errResponse){
                                   console.error('Error while creating User.');
                              } 
                  );
          };
 
         self.updateService = function(tServico, id){
        	 TipoServicoService.updateService(tServico, id)
                      .then(
                              self.fetchAllServices, 
                              function(errResponse){
                                   console.error('Error while updating User.');
                              } 
                  );
          };
 
         self.deleteService = function(id){
        	 TipoServicoService.deleteService(id)
                      .then(
                              self.fetchAllServices, 
                              function(errResponse){
                                   console.error('Error while deleting User.');
                              } 
                  );
          };
 
          self.fetchAllServices();
 
          self.submit = function() {
              if(self.tipoServico.id==null){
                  console.log('Saving New User', self.tipoServico);    
                  self.createService(self.tipoServico);
              }else{
                  self.updateService(self.tipoServico, self.tipoServico.id);
                  console.log('User updated with id ', self.tipoServico.id);
              }
              self.reset();
          };
               
          self.edit = function(id){
              console.log('id to be edited', id);
              for(var i = 0; i < self.tServicos.length; i++){
                  if(self.tServicos[i].id == id) {
                     self.tipoServico = angular.copy(self.tServicos[i]);
                     break;
                  }
              }
          };
               
          self.remove = function(id){
              console.log('id to be deleted', id);
              for(var i = 0; i < self.tServicos.length; i++){//clean form if the user to be deleted is shown there.
                  if(self.tServicos[i].id == id) {
                     self.reset();
                     break;
                  }
              }
              self.deleteService(id);
          };
 
           
          self.reset = function(){
              self.tipoServico={id:null,nome:'',descricao:''};
              $scope.myForm.$setPristine(); //reset Form
          };
 
      }]);