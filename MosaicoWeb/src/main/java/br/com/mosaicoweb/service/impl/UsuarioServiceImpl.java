package br.com.mosaicoweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.mosaicomodel.dao.inter.IUsuarioDao;
import br.com.mosaicomodel.model.Usuario;
import br.com.mosaicoweb.service.inter.IUsuarioService;

@Service("usuarioService")
@Transactional
public class UsuarioServiceImpl implements IUsuarioService{

	@Autowired
    private IUsuarioDao dao;
     
    @Autowired
    private PasswordEncoder passwordEncoder;
 
     
    public void save(Usuario usuario){
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        dao.save(usuario);
    }
     
    public Usuario findById(Long id) {
        return dao.findById(id);
    }

	@Override
	public Usuario findByEmail(String email) {
		return dao.findByEmail(email);
	}

	
 
}
