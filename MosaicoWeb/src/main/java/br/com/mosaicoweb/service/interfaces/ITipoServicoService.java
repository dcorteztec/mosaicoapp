package br.com.mosaicoweb.service.interfaces;

import java.util.List;

import br.com.mosaicomodel.model.TipoServico;

public interface ITipoServicoService {

	   void save(TipoServico tipoServico);
	    
	   TipoServico findById(Long id);
	    
	   List<TipoServico> listTipoServicos();

	   boolean isTipoExist(TipoServico tipoServico);

	   void updateTipoService(TipoServico currentTipo);

	   void deleteTipoServico(TipoServico servico);
	   
	   List<Long> listIdTipoServicos();

}
