package br.com.mosaicomodel.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import br.com.mosaicomodel.dao.AbstractDao;
import br.com.mosaicomodel.dao.interfaces.ITipoServicoDao;
import br.com.mosaicomodel.model.TipoServico;

@Repository("tipoServicoDao")
public class TipoServicoDaoImpl extends AbstractDao<Long, TipoServico> implements ITipoServicoDao{

	@Override
	public void save(TipoServico tipo) {
		persist(tipo);
		
	}

	@Override
	public TipoServico findById(Long id) {
		return getByKey(id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TipoServico> listTipoServicos() {
		Criteria criteria = createEntityCriteria();
		return (List<TipoServico>)criteria.list();
	}
	
	

}
