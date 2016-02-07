'use strict';
 
AppAdmin.factory('EnderecoService', ['$http', '$q','Flash', function($http, $q,Flash){
 
    return {
         
            fetchAllEnderecos: function() {
                    return $http.get('/mosaicoDeIdeias/painel/endereco/')
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while fetching enderecos');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
             
            createEndereco: function(endereco){
                    return $http.post('/mosaicoDeIdeias/painel/endereco/', endereco)
                            .then(
                                    function(response){
                                    	 var message = '<strong>Pronto!</strong> Endereço Cadastrado com sucesso.';
                                         Flash.create('success', message, 'custom-class');
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                    	if(errResponse.status==500){
        	                            	var message = '<strong>OOPS!</strong> Algum problema aconteceu.';
        	                                Flash.create('danger', message);
                                    	}
                                        console.error('Error while creating endereco');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
             
            updateEndereco: function(endereco, id){
                    return $http.put('/mosaicoDeIdeias/painel/endereco/'+id, endereco)
                            .then(
                                    function(response){
                                    	 var message = '<strong>Pronto!</strong> Endereço Editado com sucesso.';
                                         Flash.create('success', message, 'custom-class');
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                    	if(errResponse.status==500){
        	                            	var message = '<strong>OOPS!</strong> Algum problema aconteceu.';
        	                                Flash.create('danger', message);
                                    	}
                                        console.error('Error while updating Endereco');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
             
            
            
            deleteEndereco: function(id){
                    return $http.delete('/mosaicoDeIdeias/painel/endereco/'+id)
                            .then(
                                    function(response){
                                    	 var message = '<strong>Pronto!</strong> Endereço Excluído com sucesso.';
                                         Flash.create('success', message, 'custom-class');
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                    	if(errResponse.status==500){
        	                            	var message = '<strong>OOPS!</strong> Algum problema aconteceu.';
        	                                Flash.create('danger', message);
                                    	}
                                        console.error('Error while deleting Endereco');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
            
            
            
         
    };
 
}]);