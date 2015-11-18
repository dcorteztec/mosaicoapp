'use strict';
 
App.factory('UsuarioService', ['$http', '$q', function($http, $q){
	return {
		
		createUser: function(usuario){
            return $http.post('http://localhost:8080/mosaicoDeIdeias/usuarioRest/', usuario)
                    .then(
                            function(response){
                                return response.data;
                            }, 
                            function(errResponse){
                                console.error('Error while creating user');
                                return $q.reject(errResponse);
                            }
                    );
    }
	};

}]);
