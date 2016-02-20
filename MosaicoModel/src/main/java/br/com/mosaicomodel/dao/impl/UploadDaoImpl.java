package br.com.mosaicomodel.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import br.com.mosaicomodel.dao.AbstractDao;
import br.com.mosaicomodel.dao.interfaces.IUploadDao;
import br.com.mosaicomodel.model.Upload;

@Repository("uploadDao")
public class UploadDaoImpl extends AbstractDao<Long, Upload> implements IUploadDao{

	@Override
	public void save(Upload upload) {
		persist(upload);
		
	}

	@Override
	public Upload findById(Long id) {
		return getByKey(id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Upload> listUploads() {
		Criteria criteria = createEntityCriteria();
		return (List<Upload>)criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Upload> listUploadsByIdEmpresa(Long id) {
		Criteria criteria = createEntityCriteria().setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		criteria.add(Restrictions.eq("empresa.id", id));
		return (List<Upload>)criteria.list();
	}

	@Override
	public void updateUpload(Upload upload) {
		merge(upload);
		
	}

	@Override
	public void deleteUpload(Upload upload) {		
		delete(upload);
	}
}
