'use strict';
 
App.factory('UsuarioService', ['$http', '$q','Flash','SweetAlert', function($http, $q, Flash,SweetAlert){
	return {
		
		createUser: function(usuario){
            return $http.post('/mosaicoDeIdeias/usuarioRest/', usuario)
                    .then(
                            function(response){
                            	SweetAlert.swal({
                      			   title: "Pronto! Agora só confirmar seu Email",
                      			   type: "success"        			  
                      			});
//                            	 var message = '<strong>Pronto!</strong> Agora só confirmar seu Email.';
//                                 Flash.create('success', message, 'custom-class');
                                return response.data;
                               
                            }, 
                            function(errResponse){
                            	if(errResponse.status==409){
                            		SweetAlert.swal({
                           			   title: "Email Existente em nossa Base",
                           			   type: "warning"        			  
                           			});
//	                            	var message = '<strong>Email!</strong> Existente em nossa Base.';
//	                                Flash.create('warning', message);
                            	}else if(errResponse.status==500){
                            		SweetAlert.swal({
                            			   title: "OOPS! Algum problema aconteceu",
                            			   type: "error"        			  
                            			});
//                            		var message = '<strong>OOPS!</strong> Algum problema aconteceu.';
//	                                Flash.create('error', message);
                            	} 
                                return $q.reject(errResponse);
                            }
                    );
    }
	};

}]);
