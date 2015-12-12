package br.com.mosaicoweb.service.interfaces;

import java.util.List;

import br.com.mosaicomodel.model.TipoServico;

public interface ITipoServicoService {

	   void save(TipoServico tipoServico);
	    
	   TipoServico findById(Long id);
	    
	   public List<TipoServico> listTipoServicos();
}
