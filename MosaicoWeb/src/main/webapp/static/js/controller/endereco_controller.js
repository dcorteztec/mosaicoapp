'use strict';
 
AppAdmin.controller('EnderecoController', ['$scope','$http','EnderecoService', function($scope,$http,EnderecoService) {
          var self = this;
          self.endereco={id:null,empresaId:'',empresaNome:'',cep:'',logradouro:'',numero:'',complemento:'',estado:'',cidade:'',bairro:'',lat:'',lng:''};
          self.enderecos=[];
            
          $scope.cepRest = function(){
	   		var cep = self.endereco.cep;
	   		
	   		$http.get('http://api.postmon.com.br/v1/cep/'+cep).
	   	    success(function(data) {
	   	        self.endereco.logradouro = data.logradouro;
	   	        self.endereco.estado = data.estado;
	   	        self.endereco.bairro = data.bairro;
	   	        self.endereco.cidade = data.cidade;
	   	        
	   	    
   	    });
   		
	   	 $http.get('https://maps.googleapis.com/maps/api/geocode/json?address='+self.endereco.numero +' '+self.endereco.logradouro +'-'+self.endereco.bairro+' '+self.endereco.cidade+'-'+ self.endereco.estado+'&key=AIzaSyAnmO6vHzFxet1Mu27N19UkoIihVczGPoM').
	   	    success(function(geoData) {
	   	    	$scope.geo = geoData;
	   	        self.endereco.lat = geoData.results[0].geometry.location.lat;
	   	        self.endereco.lng = geoData.results[0].geometry.location.lng;
	   	    });
        }
//          $scope.getLatLng = function() {
//	   		$http.get('https://maps.googleapis.com/maps/api/geocode/json?address=377+Av.+Getúlio+Vargas+-+Vila+Columbia,+Sãoo+João+de+Meriti+-+RJ&key=AIzaSyAnmO6vHzFxet1Mu27N19UkoIihVczGPoM').
//	   	    success(function(data) {
//	   	        $scope.geo = data;
//	   	        self.endereco.latitude = data.results[0].geometry.location.lat();
//	   	        self.endereco.longitude = data.results[0].geometry.location.lng();
//	   	    });
//   	   }
          
         
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
            
          self.createEndereco = function(endereco){
        	  var idEmpresa = angular.element($('#empresaId')).val();
        	  self.endereco.empresaId = idEmpresa;   
        	  EnderecoService.createEndereco(endereco)
                      .then(
                      self.fetchAllEnderecos, 
                              function(errResponse){
                                   console.error('Error while creating Endereco.');
                              } 
                  );
          };
 
         self.updateEndereco = function(endereco, id){
        	 var idEmpresa = angular.element($('#empresaId')).val();
       	     self.endereco.empresaId = idEmpresa;   
        	 EnderecoService.updateEndereco(endereco, id)
                      .then(
                              self.fetchAllEnderecos, 
                              function(errResponse){
                                   console.error('Error while updating Endereco.');
                              } 
                  );
          };
 
         self.deleteEndereco = function(id){
        	 EnderecoService.deleteEndereco(id)
                      .then(
                              self.fetchAllEnderecos, 
                              function(errResponse){
                                   console.error('Error while deleting Endereco.');
                              } 
                  );
          };
 
          self.fetchAllEnderecos();
 
          self.submit = function() {
              if(self.endereco.id==null){
                  console.log('Saving New Endereco', self.endereco);    
                  self.createEndereco(self.endereco);
              }else{
                  self.updateEndereco(self.endereco, self.endereco.id);
                  console.log('Endereco updated with id ', self.endereco.id);
              }
              self.reset();
          };
               
          self.edit = function(id){
              console.log('id to be edited', id);
              for(var i = 0; i < self.enderecos.length; i++){
                  if(self.enderecos[i].id == id) {
                     self.endereco = angular.copy(self.enderecos[i]);
                     break;
                  }
              }
          };
               
          self.remove = function(id){
              console.log('id to be deleted', id);
              for(var i = 0; i < self.enderecos.length; i++){//clean form if the user to be deleted is shown there.
                  if(self.enderecos[i].id == id) {
                     self.reset();
                     break;
                  }
              }
              self.deleteService(id);
          };
 
           
          self.reset = function(){
              self.endereco={id:null,nome:'',descricao:''};
              $scope.myForm.$setPristine(); //reset Form
          };
 
      }]);