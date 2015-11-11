package br.com.mosaicoweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.mosaicomodel.dao.inter.IUsuarioPerfilDao;
import br.com.mosaicomodel.model.UsuarioPerfil;
import br.com.mosaicoweb.service.inter.IUsuarioPerfilService;

@Service("usuarioPerfilService")
@Transactional
public class UsuarioPerfilServiceImpl implements IUsuarioPerfilService{

	@Autowired
	IUsuarioPerfilDao dao;
	
	@Override
	public List<UsuarioPerfil> findAll() {
		 return dao.findAll();
	}

	@Override
	public UsuarioPerfil findByType(String type) {
		 return dao.findByType(type);
	}

	@Override
	public UsuarioPerfil findById(Long id) {
		 return dao.findById(id);
	}

}
