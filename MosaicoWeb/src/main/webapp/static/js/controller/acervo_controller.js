'use strict';
 
AppAdmin.controller('AcervoController', ['$scope', 'AcervoService','Lightbox','SweetAlert', function($scope, AcervoService, Lightbox,SweetAlert) {
          var self = this;
          self.acervo={id:null,url:'',thumbUrl:''};
          self.acervos=[];
          $scope.showA = true;
          $scope.acervo={id:null,url:'',thumbUrl:''};
          $scope.acervos=[];
         
          
          self.fetchAllImages = function(){
        	  AcervoService.fetchAllImages()
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
          
         
            
          
          $scope.add = function(){
        	  if($scope.counter <= 14){
	        	  var table = window.document.getElementById("fuTable");
	        	  var rowCount = table.rows.length;
	        	  var row = table.insertRow(rowCount);
	        	  var col1 = row.insertCell(0);
		      	  var colInput = document.createElement("input");
		      	  colInput.type = "file";
		      	  colInput.name = "files";
		      	  col1.appendChild(colInput);
		      	  $scope.counter++
        	  }else{
        		  SweetAlert.swal({
        			   title: "Limite de 15 imagens Atingidos",
        			   type: "warning"        			  
        			});
        			
        	  }
     	    };
          
         self.deleteImagem = function(id){
        	 var modal;
        	 var backdrop;
        	 var timer;
        	 var element;
        	 AcervoService.deleteImagem(id)
                      .then(                           
                    		  modal = angular.element(document.querySelector('.modal')),
                    		  modal.remove(),
                    		  backdrop = angular.element(document.querySelector('.modal-backdrop')),
                    		  backdrop.remove(),
                    		  window.document.getElementById(id).style.visibility = "hidden",
                    		  //window.location.href = '/mosaicoDeIdeias/painel/acervo',
                    		  self.fetchAllImages(),
                              function(errResponse){
                                   console.error('Error while deleting image.');
                              } 
                  );
          };
          
          self.fetchAllImages();
           
          self.remove = function(id){
              console.log('id to be deleted', id);
              for(var i = 0; i < self.acervos.length; i++){//clean form if the user to be deleted is shown there.
                  if(self.acervos[i].id == id) {
                     self.reset();
                     break;
                  }
              }
              self.deleteImagem(id);
          };
          
          $scope.openLightboxModal = function (index) {
        	    Lightbox.openModal(self.acervos, index);
          };
          
          self.reset = function(){
        	  self.acervo={id:null,urlImagem:''};
              $scope.myForm.$setPristine(); //reset Form
          };
 
      }]);