'use strict';
 
App.controller('UsuarioController', ['$scope', 'UsuarioService','Flash', function($scope, UsuarioService,Flash) {
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
            
//                var message = '<strong> Well done!</strong>  You successfully read this important alert message.';
//                Flash.create('success', message, 'custom-class');
                
             
        }

    };
}]);