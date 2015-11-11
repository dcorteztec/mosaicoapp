package br.com.mosaicomodel.dao.inter;

import br.com.mosaicomodel.model.Usuario;

public interface IUsuarioDao {

	void save(Usuario user);
    
	Usuario findById(Long id);

	Usuario findByEmail(String email);
    
}
