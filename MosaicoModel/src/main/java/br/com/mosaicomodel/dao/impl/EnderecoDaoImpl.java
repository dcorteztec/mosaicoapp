package br.com.mosaicomodel.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import br.com.mosaicomodel.dao.AbstractDao;
import br.com.mosaicomodel.dao.interfaces.IEnderecoDao;
import br.com.mosaicomodel.model.Endereco;

@Repository("enderecoDao")
public class EnderecoDaoImpl extends AbstractDao<Long, Endereco> implements IEnderecoDao{

	@Override
	public void save(Endereco endereco) {
		persist(endereco);
		
	}

	@Override
	public Endereco findById(Long id) {
		return getByKey(id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Endereco> listEnderecos() {
		Criteria criteria = createEntityCriteria();
		return (List<Endereco>)criteria.list();
	}

}
