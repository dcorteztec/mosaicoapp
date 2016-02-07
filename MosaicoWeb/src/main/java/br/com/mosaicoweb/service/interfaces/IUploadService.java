package br.com.mosaicoweb.service.interfaces;

import java.util.List;

import br.com.mosaicomodel.model.Upload;

public interface IUploadService {

    void save(Upload upload);
    
    Upload findById(Long id);
	
	List<Upload> listUploads();
		
	List<Upload> listUploadsByIdEmpresa(Long id);
	
	void updateUpload(Upload upload);

	void deleteUpload(Upload upload);
}
