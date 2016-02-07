'use strict';
 
AppAdmin.controller('PainelController', ['$scope','$http','EnderecoService','NgMap', function($scope,$http,EnderecoService,NgMap) {
	 var self = this;
	 self.endereco={id:null,empresaId:'',empresaNome:'',cep:'',logradouro:'',numero:'',complemento:'',estado:'',cidade:'',bairro:'',lat:'',lng:''};
	 self.enderecos=[]
	

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
     
     self.fetchAllEnderecos();
	 

}]);