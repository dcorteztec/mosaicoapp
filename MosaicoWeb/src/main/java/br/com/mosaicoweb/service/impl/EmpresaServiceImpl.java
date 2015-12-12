package br.com.mosaicoweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.mosaicomodel.dao.interfaces.IEmpresaDao;
import br.com.mosaicomodel.model.Empresa;
import br.com.mosaicoweb.service.interfaces.IEmpresaService;

@Service("empresaService")
@Transactional
public class EmpresaServiceImpl implements IEmpresaService{

	@Autowired
	IEmpresaDao dao;
	
	@Override
	public void save(Empresa empresa) {
		dao.save(empresa);
	}

	@Override
	public Empresa findById(Long id) {
		return dao.findById(id);
	}

	@Override
	public Empresa findByName(String nome) {
		return dao.findByName(nome);
	}

	@Override
	public List<Empresa> listEmpresasByIdUsuario(Long idUser) {
		return dao.listEmpresasByIdUsuario(idUser);
	}

	@Override
	public List<Empresa> listEmpresas() {
		return dao.listEmpresas();
	}

}
