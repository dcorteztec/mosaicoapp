'use strict';
 
App.controller('UsuarioController', ['$scope', 'UsuarioService','SweetAlert', function($scope, UsuarioService,SweetAlert) {
	var self = this;
    self.usuario={id:null,email:'',senha:''};
    self.usuarios=[];
    
    
    
    self.createUser = function(usuario){
    	UsuarioService.createUser(usuario)
               
    };
    self.submit = function() {
        if(self.usuario.id==null){  
            self.createUser(self.usuario);  
        }

    };
}]);