package br.com.mosaicoweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.mosaicomodel.dao.interfaces.IEnderecoDao;
import br.com.mosaicomodel.model.Endereco;
import br.com.mosaicoweb.service.interfaces.IEnderecoService;

@Service("enderecoService")
@Transactional
public class EnderecoServiceImpl implements IEnderecoService{

	@Autowired IEnderecoDao dao;
	
	@Override
	public void save(Endereco endereco) {
		dao.save(endereco);
		
	}

	@Override
	public Endereco findById(Long id) {
		return dao.findById(id);
	}

	@Override
	public Endereco findByCep(String cep) {
		return dao.findByCep(cep);
	}

	@Override
	public List<Endereco> listEnderecoByIdEmpresa(Long idEmpresa) {
		return null;
	}

	@Override
	public List<Endereco> listEnderecos() {
		return dao.listEnderecos();
	}

	@Override
	public boolean isCepExist(Endereco endereco) {
		return dao.findByCep(endereco.getCep())!=null;
	}

	@Override
	public void updateEndereco(Endereco endereco) {
		dao.updateEndereco(endereco);
		
	}

	@Override
	public void deleteEndereco(Endereco endereco) {
		dao.deleteEndereco(endereco);
		
	}

	@Override
	public List<Endereco> listEnderecosByIdEmpresa(List<Long> idsEmpresa) {
		return dao.listEnderecosByIdEmpresa(idsEmpresa);
	}

}
