'use strict';
 
App.factory('IndexService', ['$http', '$q','Flash','SweetAlert', function($http, $q, Flash,SweetAlert){
	
	 return {
         
         fetchAllServices: function() {
                 return $http.get('/mosaicoDeIdeias/tipoServico/')
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
	 
		 fetchAllEmpresas: function() {
	         return $http.get('/mosaicoDeIdeias/listEmpresas/')
	                 .then(
	                         function(response){
	                             return response.data;
	                         }, 
	                         function(errResponse){
	                             console.error('Error while fetching users');
	                             return $q.reject(errResponse);
	                         }
	                 );
		 	}
	 }
	
}]);
