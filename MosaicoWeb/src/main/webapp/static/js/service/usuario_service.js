'use strict';
 
App.factory('UsuarioService', ['$http', '$q','Flash', function($http, $q, Flash){
	return {
		
		createUser: function(usuario){
            return $http.post('/mosaicoDeIdeias/usuarioRest/', usuario)
                    .then(
                            function(response){
                            	 var message = '<strong>Pronto!</strong> Agora só confirmar seu Email.';
                                 Flash.create('success', message, 'custom-class');
                                return response.data;
                               
                            }, 
                            function(errResponse){
                            	if(errResponse.status==409){
	                            	var message = '<strong>Email!</strong> Existente em nossa Base.';
	                                Flash.create('warning', message);
                            	}else if(errResponse.status==500){
                            		var message = '<strong>OOPS!</strong> Algum problema aconteceu.';
	                                Flash.create('error', message);
                            	} 
                                return $q.reject(errResponse);
                            }
                    );
    }
	};

}]);
