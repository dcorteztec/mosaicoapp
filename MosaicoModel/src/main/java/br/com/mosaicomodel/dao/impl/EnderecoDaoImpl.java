package br.com.mosaicomodel.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;
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
		Criteria criteria = createEntityCriteria().setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return (List<Endereco>)criteria.list();
	}

	@Override
	public Endereco findByCep(String cep) {
		Criteria crit = createEntityCriteria();
	    crit.add(Restrictions.eq("cep", cep));
	    return (Endereco) crit.uniqueResult();
	}

	@Override
	public void updateEndereco(Endereco endereco) {
		merge(endereco);
		
	}

	@Override
	public void deleteEndereco(Endereco endereco) {
		delete(endereco);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Endereco> listEnderecosByIdEmpresa(List<Long> idsEmpresa) {
		Criteria criteria = createEntityCriteria();
		Disjunction orConditions = Restrictions.disjunction();
		orConditions.add(Restrictions.in("empresa.id", idsEmpresa));
		criteria.add(orConditions).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);;
		return (List<Endereco>)criteria.list();
	}

}
