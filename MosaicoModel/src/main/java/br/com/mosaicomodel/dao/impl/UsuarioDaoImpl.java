package br.com.mosaicomodel.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import br.com.mosaicomodel.dao.AbstractDao;
import br.com.mosaicomodel.dao.inter.IUsuarioDao;
import br.com.mosaicomodel.model.Usuario;

@Repository("usuarioDao")
public class UsuarioDaoImpl extends AbstractDao<Long, Usuario> implements IUsuarioDao  {

	@Override
	public void save(Usuario usuario) {
		persist(usuario);
		
	}

	@Override
	public Usuario findById(Long id) {
		 return getByKey(id);
	}

	@Override
	public Usuario findByEmail(String email) {
		 Criteria crit = createEntityCriteria();
	     crit.add(Restrictions.eq("email", email));
	     return (Usuario) crit.uniqueResult();
	}

	
}
