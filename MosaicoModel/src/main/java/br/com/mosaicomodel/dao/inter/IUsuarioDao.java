package br.com.mosaicomodel.dao.inter;

import java.util.List;

import br.com.mosaicomodel.model.Usuario;

public interface IUsuarioDao {

	void save(Usuario user);
    
	Usuario findById(Long id);

	Usuario findByEmail(String email);
	
	List<Usuario> listUsuarios();
    
}
