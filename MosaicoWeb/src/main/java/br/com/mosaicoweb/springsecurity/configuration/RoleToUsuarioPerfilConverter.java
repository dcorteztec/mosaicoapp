package br.com.mosaicoweb.springsecurity.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.com.mosaicomodel.model.UsuarioPerfil;
import br.com.mosaicoweb.service.interfaces.IUsuarioPerfilService;

@Component
public class RoleToUsuarioPerfilConverter implements Converter<Object, UsuarioPerfil>{

	@Autowired
	IUsuarioPerfilService usuarioPerfilService;
	
	@Override
	public UsuarioPerfil convert(Object element) {
		 Long id = Long.parseLong((String)element);
		 UsuarioPerfil perfil= usuarioPerfilService.findById(id);
	     System.out.println("Profile : "+perfil);
	     return perfil;
	}

}
