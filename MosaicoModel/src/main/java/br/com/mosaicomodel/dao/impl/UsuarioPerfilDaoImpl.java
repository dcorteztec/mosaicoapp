package br.com.mosaicomodel.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import br.com.mosaicomodel.dao.AbstractDao;
import br.com.mosaicomodel.dao.interfaces.IUsuarioPerfilDao;
import br.com.mosaicomodel.model.UsuarioPerfil;

@Repository("usuarioPerfilDao")
public class UsuarioPerfilDaoImpl extends AbstractDao<Long, UsuarioPerfil>implements IUsuarioPerfilDao{

	@SuppressWarnings("unchecked")
	@Override
	public List<UsuarioPerfil> findAll() {
		Criteria crit = createEntityCriteria();
        crit.addOrder(Order.asc("tipo"));
        return (List<UsuarioPerfil>)crit.list();
	}

	@Override
	public UsuarioPerfil findByType(String tipo) {
		Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("tipo", tipo));
        return (UsuarioPerfil) crit.uniqueResult();
	}

	@Override
	public UsuarioPerfil findById(Long id) {
		 return getByKey(id);
	}

}
