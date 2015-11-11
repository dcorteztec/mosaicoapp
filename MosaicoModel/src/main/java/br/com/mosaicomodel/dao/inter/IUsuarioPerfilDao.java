package br.com.mosaicomodel.dao.inter;

import java.util.List;

import br.com.mosaicomodel.model.UsuarioPerfil;

public interface IUsuarioPerfilDao {

	List<UsuarioPerfil> findAll();
     
	UsuarioPerfil findByType(String type);
	   
	UsuarioPerfil findById(Long id);
}
