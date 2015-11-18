'use strict';
 
App.controller('UsuarioController', ['$scope', 'UsuarioService', function($scope, UsuarioService) {
	var self = this;
    self.usuario={id:null,email:'',senha:''};
    self.usuarios=[];
    
    self.createUser = function(usuario){
    	UsuarioService.createUser(usuario)
               
    };
    self.submit = function() {
        if(self.usuario.id==null){
            console.log('Saving New User', self.usuario);    
            self.createUser(self.usuario);
        }

    };
}]);