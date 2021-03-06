'use strict';
 
AppAdmin.factory('AcervoService', ['$http', '$q','Flash', function($http, $q,Flash){
 	
    return {
         
            fetchAllImages: function() {
                    return $http.get('/mosaicoDeIdeias/painel/acervos')
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
            
            fetchAllImagesPerfil: function(id) {
                return $http.get('/mosaicoDeIdeias/acervos/'+id)
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
             
//            createService: function(tipoServico){
//                    return $http.post('/mosaicoDeIdeias/admin/tipoServico/', tipoServico)
//                            .then(
//                                    function(response){
//                                    	 var message = '<strong>Pronto!</strong> Tipo de Serviço Cadastrado com sucesso.';
//                                         Flash.create('success', message, 'custom-class');
//                                        return response.data;
//                                    }, 
//                                    function(errResponse){
//                                    	if(errResponse.status==500){
//        	                            	var message = '<strong>OOPS!</strong> Algum problema aconteceu.';
//        	                                Flash.create('danger', message);
//                                    	}
//                                        console.error('Error while creating user');
//                                        return $q.reject(errResponse);
//                                    }
//                            );
//            },
//             
//            updateService: function(tipoServico, id){
//                    return $http.put('/mosaicoDeIdeias/admin/tipoServico/'+id, tipoServico)
//                            .then(
//                                    function(response){
//                                    	var message = '<strong>Pronto!</strong> Tipo de Serviço Editado com sucesso.';
//                                        Flash.create('success', message, 'custom-class');
//                                        return response.data;
//                                    }, 
//                                    function(errResponse){
//                                    	if(errResponse.status==500){
//        	                            	var message = '<strong>OOPS!</strong> Algum problema aconteceu.';
//        	                                Flash.create('danger', message);
//                                    	}
//                                        console.error('Error while updating user');
//                                        return $q.reject(errResponse);
//                                    }
//                            );
//            },
//             
//            
//            
            deleteImagem: function(id){
                    return $http.delete('/mosaicoDeIdeias/painel/acervo/'+id)
                            .then(
                                    function(response){
                                    	var message = '<strong>Pronto!</strong> Imagem Excluído com sucesso.';
                                        Flash.create('success', message, 'custom-class');
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                    	if(errResponse.status==500){
        	                            	var message = '<strong>OOPS!</strong> Algum problema aconteceu.';
        	                                Flash.create('danger', message);
                                    	}
                                        console.error('Error while deleting user');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
            
            
            
         
    };
 
}]);