angular.module('mosaicoApp', [])
.controller('Cep', function($scope, $http) {
	
	
	$scope.cepRest = function()
	   {
		var cep = $scope.cep;
		
		$http.get('http://api.postmon.com.br/v1/cep/'+cep).
	    success(function(data) {
	        $scope.end = data;
	    });
		
		
     }
	$scope.getLatLng = function()
	   
	   {
		$http.get('https://maps.googleapis.com/maps/api/geocode/json?address=377+Av.+Getúlio+Vargas+-+Vila+Columbia,+Sãoo+João+de+Meriti+-+RJ&key=AIzaSyAnmO6vHzFxet1Mu27N19UkoIihVczGPoM').
	    success(function(data) {
	        $scope.geo = data;
	    });
	   }
	
});