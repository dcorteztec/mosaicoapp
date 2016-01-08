'use strict';
 
//(function() {
//
	AppAdmin.controller("demoController", demoController);
	  //demoController.$inject = ["NgTableParams", "$resource"];

	  function demoController($scope,$resource,$http, ngTableParams) {
	    // tip: to debug, open chrome dev tools and uncomment the following line 
	    //debugger;
	    
		  $http.get('http://localhost:8080/mosaicoDeIdeias/admin/tipoServico/')
		  .success(function(data, status) {
			  $scope.data = data;
		 $scope.tableParams = new ngTableParams({
		    page: 1,            // show first page
		    count: 10,          // count per page
		    sorting: { nome: "asc" } ,
		    filter: { nome: "T" } 
		}, {
		    total: data.length, // length of data
		    getData: function($defer, params) {
		        // use build-in angular filter
		        var orderedData = data;

		    $defer.resolve(orderedData.slice((params.page() - 1) * params.count(),     params.page() *    params.count()));
		}
		  });
		  });
	  }
//	})();