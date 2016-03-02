'use strict';
 
AppAdmin.factory('MensagemService', ['$http', '$q','SweetAlert', function($http, $q,SweetAlert){
 
    return {
         
            fetchAllMensagens: function() {
                    return $http.get('/mosaicoDeIdeias/painel/mensagens/')
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
            
            fetchAllMensagensAdmin: function() {
                return $http.get('/mosaicoDeIdeias/admin/mensagem/')
                        .then(
                                function(response){
                                    return response.data;
                                }, 
                                function(errResponse){
                                    console.error('Error while fetching Mensagens');
                                    return $q.reject(errResponse);
                                }
                        );
        },
             
            createMensagem: function(mensagem){
                    return $http.post('/mosaicoDeIdeias/painel/mensagem/', mensagem)
                            .then(
                                    function(response){
                                    	SweetAlert.swal({
                             			   title: "Mensagem Enviada !!",
                             			   type: "success"        			  
                             			})
                                        return response.data;
                                        
                                    }, 
                                    function(errResponse){
                                    	SweetAlert.swal({
                             			   title: "Aconceteu alguma coisa!!",
                             			   type: "danger"        			  
                             			}),
                                        console.error('Error while creating Mensagem');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
            
            createMensagemAdmin: function(mensagem){
                return $http.post('/mosaicoDeIdeias/admin/mensagem/', mensagem)
                        .then(
                                function(response){
                                	
                                    return response.data;
                                    SweetAlert.swal({
                         			   title: "Mensagem Enviada !!",
                         			   type: "success"        			  
                         			});
                                }, 
                                function(errResponse){
                                	
                                    console.error('Error while creating Mensagem');
                                    return $q.reject(errResponse);
                                }
                        );
        },
             
            updateMensagem: function(mensagem, id){
                    return $http.put('/mosaicoDeIdeias/painel/mensagem/'+id, mensagem)
                            .then(
                                    function(response){
                                    	
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                    	
                                        console.error('Error while updating Mensagem');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
             
            
            
            deleteMensagem: function(id){
                    return $http.delete('/mosaicoDeIdeias/painel/mensagem/'+id)
                            .then(
                                    function(response){
                                    	 SweetAlert.swal({
                               			   title: "Mensagem Visualizada e Deletada !!",
                               			   type: "success"        			  
                               			});
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