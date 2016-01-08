'use strict';
 
AppAdmin.factory('TipoServicoService', ['$http', '$q', function($http, $q){
 
    return {
         
            fetchAllServices: function() {
                    return $http.get('http://localhost:8080/mosaicoDeIdeias/admin/tipoServico/')
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while fetching users');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
             
            createService: function(tipoServico){
                    return $http.post('http://localhost:8080/mosaicoDeIdeias/admin/tipoServico/', tipoServico)
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while creating user');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
             
            updateService: function(tipoServico, id){
                    return $http.put('http://localhost:8080/mosaicoDeIdeias/admin/tipoServico/'+id, tipoServico)
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while updating user');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
             
            
            
            deleteService: function(id){
                    return $http.delete('http://localhost:8080/mosaicoDeIdeias/admin/tipoServico/'+id)
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while deleting user');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
            
            
            
         
    };
 
}]);