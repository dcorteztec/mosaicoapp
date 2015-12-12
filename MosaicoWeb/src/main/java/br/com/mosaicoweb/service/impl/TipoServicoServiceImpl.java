package br.com.mosaicoweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.mosaicomodel.dao.interfaces.ITipoServicoDao;
import br.com.mosaicomodel.model.TipoServico;
import br.com.mosaicoweb.service.interfaces.ITipoServicoService;

public class TipoServicoServiceImpl implements ITipoServicoService{

	@Autowired ITipoServicoDao dao;	
	
	@Override
	public void save(TipoServico tipoServico) {
		dao.save(tipoServico);
		
	}

	@Override
	public TipoServico findById(Long id) {
		return dao.findById(null);
	}

	@Override
	public List<TipoServico> listTipoServicos() {
		return dao.listTipoServicos();
	}

}
