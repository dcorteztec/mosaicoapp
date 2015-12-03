package br.com.mosaicoweb.service.interfaces;

import java.util.List;

import br.com.mosaicomodel.model.UsuarioPerfil;

public interface IUsuarioPerfilService {

	List<UsuarioPerfil> findAll();
    
	UsuarioPerfil findByType(String type);
     
	UsuarioPerfil findById(Long id);
}
