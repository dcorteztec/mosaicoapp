package br.com.mosaicomodel.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
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

	@Override
	public TipoServico findByName(String nome) {
		 Criteria crit = createEntityCriteria();
	     crit.add(Restrictions.eq("nome", nome));
	     return (TipoServico) crit.uniqueResult();
	}

	@Override
	public void updateTipoService(TipoServico tipoServico) {
		merge(tipoServico);
		
	}

	@Override
	public void deleteTipoServico(TipoServico tipoServico) {		
		delete(tipoServico);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Long> listIdTipoServicos() {
		 Criteria crit = createEntityCriteria();
	     crit.setProjection(Projections.property("id"));
	     return (List<Long>)crit.list();
	}
	
	

}
