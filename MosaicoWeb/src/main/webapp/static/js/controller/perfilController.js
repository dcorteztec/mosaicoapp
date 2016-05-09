'use strict';
 
AppAdmin.controller('PerfilController', ['$scope', 'AcervoService','Lightbox','SweetAlert', function($scope, AcervoService, Lightbox,SweetAlert) {
          var self = this;
          self.acervo={id:null,url:'',thumbUrl:''};
          self.acervos=[];
          $scope.showA = true;
          $scope.acervo={id:null,url:'',thumbUrl:''};
          $scope.acervos=[];
          var empresaId = window.document.getElementById("empresaId").value;
          
          self.fetchAllImagesPerfil = function(empresaId){
        	  AcervoService.fetchAllImagesPerfil(empresaId)
                  .then(
                               function(d) {
                                    self.acervos = d;
                                    $scope.acervos = d;
                                    $scope.counter = $scope.acervos.length;
                               },
                                function(errResponse){
                                    console.error('Error while fetching Service');
                                }
                       );
          };
          
         
            
          self.fetchAllImagesPerfil(empresaId);
         
 
      }]);