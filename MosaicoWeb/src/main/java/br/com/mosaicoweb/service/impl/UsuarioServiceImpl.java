package br.com.mosaicoweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.mosaicomodel.dao.interfaces.IUsuarioDao;
import br.com.mosaicomodel.model.Usuario;
import br.com.mosaicomodel.model.UsuarioPerfil;
import br.com.mosaicomodel.util.Constantes;
import br.com.mosaicoweb.service.interfaces.IUsuarioPerfilService;
import br.com.mosaicoweb.service.interfaces.IUsuarioService;

@Service("usuarioService")
@Transactional
public class UsuarioServiceImpl implements IUsuarioService{

	@Autowired
    private IUsuarioDao dao;
     
    @Autowired
    private PasswordEncoder passwordEncoder;
 
    @Autowired
    private IUsuarioPerfilService usuarioPerfilService;
     
    public void save(Usuario usuario){
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        UsuarioPerfil usuarioPerfil = usuarioPerfilService.findById(Constantes.ID_USUARIOPERFIL_USER);
        List<UsuarioPerfil> usuarioPerfis = new ArrayList<UsuarioPerfil>();
        usuarioPerfis.add(usuarioPerfil);
        usuario.setUsuarioPerfis(usuarioPerfis);
        dao.save(usuario);
    }
     
    public Usuario findById(Long id) {
        return dao.findById(id);
    }

	@Override
	public Usuario findByEmail(String email) {
		return dao.findByEmail(email);
	}

	@Override
	public boolean isEmailExist(Usuario usuario) {
		 return findByName(usuario.getEmail())!=null;
	}

	public Usuario findByName(String name) {
		List<Usuario> usuarios = dao.listUsuarios();
        for(Usuario usuario : usuarios){
            if(usuario.getEmail().equalsIgnoreCase(name)){
                return usuario;
            }
        }
        return null;
    }

	@Override
	public void updatePrimeiroAcesso(Long idUsuario) {
		dao.updatePrimeiroAcesso(idUsuario);
		
	}

	
 
}
