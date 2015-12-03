package br.com.mosaicoweb.springsecurity.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.mosaicomodel.model.Usuario;
import br.com.mosaicomodel.model.UsuarioPerfil;
import br.com.mosaicoweb.service.interfaces.IUsuarioService;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService{

	 @Autowired
	 private IUsuarioService userService;
	     
	    @Transactional(readOnly=true)
	    public UserDetails loadUserByUsername(String email)
	            throws UsernameNotFoundException {
	        Usuario usuario = userService.findByEmail(email);
	        System.out.println("User : "+usuario);
	        if(usuario==null){
	            System.out.println("User not found");
	            throw new UsernameNotFoundException("Username not found"); 
	        }else{
	            return new org.springframework.security.core.userdetails.User(usuario.getEmail(), usuario.getSenha(), 
	                 usuario.getStatus().equals("A"), true, true, true, getGrantedAuthorities(usuario));
	        } 
	    }
	 
	     
	    private List<GrantedAuthority> getGrantedAuthorities(Usuario usuario){
	        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
	         
	        for(UsuarioPerfil usuarioPerfil : usuario.getUsuarioPerfis()){
	            System.out.println("UsuarioPerfil : "+usuarioPerfil);
	            authorities.add(new SimpleGrantedAuthority("ROLE_"+usuarioPerfil.getTipo()));
	        }
	        System.out.print("authorities :"+authorities);
	        return authorities;
	    }

}
