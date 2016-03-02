'use strict';
 
AppAdmin.controller('PainelController', ['$scope','$http','EnderecoService','NgMap','MensagemService', function($scope,$http,EnderecoService,NgMap,MensagemService) {
	 var self = this;
	 self.endereco={id:null,empresaId:'',empresaNome:'',cep:'',logradouro:'',numero:'',complemento:'',estado:'',cidade:'',bairro:'',lat:'',lng:''};
	 self.enderecos=[];
	 self.mensagem={id:null,tipo:'',texto:'',status:'',classe:'',idEmpresa:null,dataHora:'',empresa:'',dataHoraFormatada:''};
	 self.mensagens=[];
	 self.mensagemUser={id:null,tipo:'',texto:'',status:'',classe:'',idEmpresa:null,dataHora:'',empresa:'',dataHoraFormatada:''};
     self.mensagensUser=[];
	 var perfilId = window.document.getElementById("perfil").value;     
	 
	 NgMap.getMap().then(function(map) {
		    console.log('map', map);
		    self.map = map;
	 });
	 self.showDetail = function(e, end) {
		 
		 var infowindow = new google.maps.InfoWindow();
         var center = new google.maps.LatLng(end.lat,end.lng);

         infowindow.setContent(
             '<h4>' + end.empresa.nome + '</h4><br/>'+
              '' + end.logradouro       +'<br/>'+
              '' + end.empresa.telefone +'<br/>'+
              '' + end.empresa.celular  +'<br/>'
              );

         infowindow.setPosition(center);
         infowindow.open(self.map);
	  };
	 
	 
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
      
	  
	 self.fetchAllEnderecos = function(){
   	  EnderecoService.fetchAllEnderecos()
             .then(
                          function(d) {
                               self.enderecos = d;
                          },
                           function(errResponse){
                               console.error('Error while fetching Endereco');
                           }
                  );
     };
     
     self.deleteMensagem = function(id){
    	 MensagemService.deleteMensagem(id)
                  .then(
                		  window.document.getElementById(id).style.visibility = "hidden",
                          function(errResponse){
                               console.error('Error while deleting Mensagem.');
                          } 
              );
      };
      
      self.listByPerfil = function() {
     	 
    	  if(perfilId == 1){
    		  window.location.href = '/mosaicoDeIdeias/admin'
        	  self.fetchAllMensagensAdmin();
          }else{
        	  window.location.href = '/mosaicoDeIdeias/painel'
        	  self.fetchAllMensagens();
          }
      }
     
     self.remove = function(id){
         console.log('id to be deleted', id);
//         for(var i = 0; i < self.mensagens.length; i++){//clean form if the user to be deleted is shown there.
//             if(self.mensagens[i].id == id) {
//                self.reset();
//                break;
//             }
//         }
         self.deleteMensagem(id);
     };

     
     self.fetchAllEnderecos();
     
     if(perfilId==1){
    	 self.fetchAllMensagensAdmin();
     }else{
    	 self.fetchAllMensagens();
     }
    
	 

}]);