package br.com.mosaicoweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.mosaicomodel.dao.interfaces.IUploadDao;
import br.com.mosaicomodel.model.Upload;
import br.com.mosaicoweb.service.interfaces.IUploadService;

@Service("uploadService")
@Transactional
public class UploadServiceImpl implements IUploadService{
    
	@Autowired
	IUploadDao dao;
	
	@Override
	public void save(Upload upload) {
		dao.save(upload);
		
	}

	@Override
	public Upload findById(Long id) {
		return dao.findById(id);
	}

	@Override
	public List<Upload> listUploads() {
		return dao.listUploads();
	}

	@Override
	public List<Upload> listUploadsByIdEmpresa(Long id) {
		return dao.listUploadsByIdEmpresa(id);
	}

	@Override
	public void updateUpload(Upload upload) {
		updateUpload(upload);
		
	}

	@Override
	public void deleteUpload(Upload upload) {
		deleteUpload(upload);
		
	}

}
