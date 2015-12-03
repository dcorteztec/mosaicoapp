package br.com.mosaicoweb.service.interfaces;

import br.com.mosaicomodel.model.Usuario;

public interface IUsuarioService {

	void save(Usuario user);
    
	Usuario findById(Long id);

	Usuario findByEmail(String email);

	boolean isEmailExist(Usuario usuario);
	
	void updatePrimeiroAcesso(Long idUsuario);
}
