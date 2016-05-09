package br.com.mosaicoweb.controller.abstracts;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;

import br.com.mosaicomodel.model.Usuario;
import br.com.mosaicoweb.service.interfaces.IUsuarioService;

@Controller
public abstract class MainController {
	@Autowired
    IUsuarioService usuarioService;
	  
    public String getPrincipal(){
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
 
        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }
    
    public Usuario getUsuario(){
        
        Usuario usuario = usuarioService.findByEmail(getPrincipal());
        
        return usuario;
    }
	
    public String isoToUtf8(String descricao) throws UnsupportedEncodingException{
    	
    	String descr = new String(descricao.getBytes("ISO-8859-1"), "UTF-8");
		return descr;
    }
}
