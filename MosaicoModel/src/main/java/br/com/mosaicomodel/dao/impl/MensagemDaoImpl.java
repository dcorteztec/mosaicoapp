package br.com.mosaicomodel.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import br.com.mosaicomodel.dao.AbstractDao;
import br.com.mosaicomodel.dao.interfaces.IMensagemDao;
import br.com.mosaicomodel.model.Mensagem;

@Repository("mensagemDao")
public class MensagemDaoImpl extends AbstractDao<Long, Mensagem> implements IMensagemDao{

	@Override
	public void save(Mensagem mensagem) {
		persist(mensagem);
		
	}

	@Override
	public Mensagem findById(Long id) {
		return getByKey(id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Mensagem> listMensagens() {
		Criteria criteria = createEntityCriteria().setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return (List<Mensagem>)criteria.list();
	}

	@Override
	public void updateMensagem(Mensagem mensagem) {
		merge(mensagem);
		
	}

	@Override
	public void deleteMensagem(Mensagem mensagem) {
		merge(mensagem);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Mensagem> listMensagensByIdEmpresa(Long idEmpresa) {
		Criteria criteria = createEntityCriteria().setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		criteria.add(Restrictions.eq("empresa.id", idEmpresa));
		criteria.add(Restrictions.isNull("admin.id"));
		criteria.add(Restrictions.eq("status", "A"));
		return (List<Mensagem>)criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Mensagem> listMensagensByIdUsuarioAdmin(Long idUsuario) {
		Criteria criteria = createEntityCriteria().setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		criteria.add(Restrictions.eq("admin.id", idUsuario));
		criteria.add(Restrictions.eq("status", "A"));
		return (List<Mensagem>)criteria.list();
	}

}
