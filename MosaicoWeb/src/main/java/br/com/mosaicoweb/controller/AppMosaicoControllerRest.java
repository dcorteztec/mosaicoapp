package br.com.mosaicoweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.mosaicomodel.model.Usuario;
import br.com.mosaicoweb.service.inter.IUsuarioService;

@RestController
public class AppMosaicoControllerRest {

	@Autowired
	IUsuarioService usuarioService;
	
	 //-------------------Create a User--------------------------------------------------------
    
    @RequestMapping(value = "/usuarioRest/", method = RequestMethod.POST)
    public ResponseEntity<Void> createUser(@RequestBody Usuario usuario,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating User " + usuario.getEmail());
  
        if (usuarioService.isEmailExist(usuario)) {
            System.out.println("A User with name " + usuario.getEmail() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
  
        usuarioService.save(usuario);
  
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/usuarioRest/{id}").buildAndExpand(usuario.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
}
