'use strict';
 
AppAdmin.controller('MensagemController', ['$scope', 'MensagemService','SweetAlert', function($scope, MensagemService,SweetAlert) {
          var self = this;
          self.mensagem={id:null,tipo:'',texto:'',status:'',classe:'',idEmpresa:null};
          self.mensagens=[];
          self.mensagemUser={id:null,tipo:'',texto:'',status:'',classe:'',idEmpresa:null};
          self.mensagensUser=[];
          
          var perfilId = window.document.getElementById("perfil").value;     
         
          self.fetchAllMensagensAdmin = function(){
        	  MensagemService.fetchAllMensagensAdmin()
                  .then(
                               function(d) {
                                    self.mensagens = d;
                               },
                                function(errResponse){
                                    console.error('Error while fetching Mensagem');
                                }
                       );
          };
          
          self.fetchAllMensagens = function(){
        	  MensagemService.fetchAllMensagens()
                  .then(
                               function(d) {
                                    self.mensagensUser = d;
                               },
                                function(errResponse){
                                    console.error('Error while fetching Mensagem');
                                }
                       );
          };
          
            
          self.createMensagem = function(mensagem){
        	  MensagemService.createMensagem(mensagem)
                      .then(
                    		  
                              function(errResponse){
                                   console.error('Error while creating Mensagem.');
                              } 
                  );
          };
          
          self.createMensagemAdmin = function(mensagem){
        	  MensagemService.createMensagemAdmin(mensagem)
                      .then(
                    		  SweetAlert.swal({
                    			   title: "Mensagem Enviada !!",
                    			   type: "success"        			  
                    			}),
                              function(errResponse){
                                   console.error('Error while creating Mensagem.');
                              } 
                  );
          };
          
          
         self.updateMensagem = function(mensagem, id){
        	 MensagemService.updateMensagem(mensagem, id)
                      .then(
                              self.fetchAllMensagensAdmin, 
                              function(errResponse){
                                   console.error('Error while updating Mensagem.');
                              } 
                  );
          };
 
         self.deleteMensagem = function(id){
        	 MensagemService.deleteMensagem(id)
                      .then(
                    		  self.listByPerfil, 
                              function(errResponse){
                                   console.error('Error while deleting Mensagem.');
                              } 
                  );
          };
 
          if(perfilId == 1){
        	  self.fetchAllMensagensAdmin();
          }else{
        	  self.fetchAllMensagens();
          }
          
          self.listByPerfil = function() {
        	 
        	  if(perfilId == 1){
        		  window.location.href = '/mosaicoDeIdeias/admin'
            	  self.fetchAllMensagensAdmin();
              }else{
            	  window.location.href = '/mosaicoDeIdeias/painel'
            	  self.fetchAllMensagens();
              }
          }
          
          self.submit = function() {
              if(self.mensagem.id==null){
                  if(perfilId==1){
                	  self.createMensagemAdmin(self.mensagem);
                  }else{
                	  self.createMensagem(self.mensagem);
                  }
                  
              }else{
                  self.updateMensagem(self.mensagem, self.mensagem.id);
                  console.log('Mensagem updated with id ', self.mensagem.id);
              }
              self.reset();
          };
               
          self.edit = function(id){
              console.log('id to be edited', id);
              for(var i = 0; i < self.mensagens.length; i++){
                  if(self.mensagens[i].id == id) {
                     self.mensagem = angular.copy(self.mensagens[i]);
                     break;
                  }
              }
          };
               
          self.remove = function(id){
              console.log('id to be deleted', id);
              for(var i = 0; i < self.mensagens.length; i++){//clean form if the user to be deleted is shown there.
                  if(self.mensagens[i].id == id) {
                     self.reset();
                     break;
                  }
              }
              self.deleteMensagem(id);
          };
 
           
          self.reset = function(){
              self.mensagem={id:null,tipo:'',texto:'',status:''};
              $scope.myForm.$setPristine(); //reset Form
          };
 
      }]);