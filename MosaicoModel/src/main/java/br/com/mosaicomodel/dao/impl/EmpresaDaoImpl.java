package br.com.mosaicomodel.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import br.com.mosaicomodel.dao.AbstractDao;
import br.com.mosaicomodel.dao.interfaces.IEmpresaDao;
import br.com.mosaicomodel.model.Empresa;

@Repository("empresaDao")
public class EmpresaDaoImpl extends AbstractDao<Long, Empresa> implements IEmpresaDao{

	@Override
	public void save(Empresa empresa) {
		persist(empresa);
		
	}

	@Override
	public Empresa findById(Long id) {
		 Criteria crit = createEntityCriteria();
		 crit.add(Restrictions.eq("id", id));
	     return (Empresa) crit.uniqueResult();
	}

	@Override
	public Empresa findByName(String nome) {
		 Criteria crit = createEntityCriteria();
	     crit.add(Restrictions.ilike("nome", nome));
	     return (Empresa) crit.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Empresa> listEmpresas() {
		Criteria criteria = createEntityCriteria().setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return (List<Empresa>)criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Empresa> listEmpresasByIdUsuario(Long idUser) {
		Criteria criteria = createEntityCriteria().setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		criteria.add(Restrictions.eq("usuario.id", idUser));
		return (List<Empresa>)criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Long> idsEmpresaByIdUsuario(Long idUser) {
		 Criteria crit = createEntityCriteria().setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
	     crit.setProjection(Projections.property("id"));
	     crit.add(Restrictions.eq("usuario.id", idUser));
	     return (List<Long>)crit.list();
	}

	@Override
	public void updateEmpresa(Empresa emp) {
		merge(emp);
		
	}

}
