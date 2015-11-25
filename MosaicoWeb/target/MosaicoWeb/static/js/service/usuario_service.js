'use strict';
 
App.factory('UsuarioService', ['$http', '$q','Flash', function($http, $q, Flash){
	return {
		
		createUser: function(usuario){
            return $http.post('http://localhost:8080/mosaicoDeIdeias/usuarioRest/', usuario)
                    .then(
                            function(response){
                            	 var message = '<strong>Pronto!</strong> Agora só confirmar seu Email.';
                                 Flash.create('success', message, 'custom-class');
                                return response.data;
                               
                            }, 
                            function(errResponse){
                            	if(errResponse.status==409)
	                            	var message = '<strong>Email!</strong> Existente em nossa Base.';
	                                Flash.create('warning', message);
                                return $q.reject(errResponse);
                            }
                    );
    }
	};

}]);
