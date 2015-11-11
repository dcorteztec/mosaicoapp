package br.com.mosaicoweb.service.inter;

import br.com.mosaicomodel.model.Usuario;

public interface IUsuarioService {

	void save(Usuario user);
    
	Usuario findById(Long id);

	Usuario findByEmail(String email);
}
