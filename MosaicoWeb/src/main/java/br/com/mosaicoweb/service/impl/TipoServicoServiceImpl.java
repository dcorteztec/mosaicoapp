package br.com.mosaicoweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.mosaicomodel.dao.interfaces.ITipoServicoDao;
import br.com.mosaicomodel.model.TipoServico;
import br.com.mosaicoweb.service.interfaces.ITipoServicoService;

@Service("tipoServicoService")
@Transactional
public class TipoServicoServiceImpl implements ITipoServicoService{

	@Autowired ITipoServicoDao dao;	
	
	@Override
	public void save(TipoServico tipoServico) {
		dao.save(tipoServico);
		
	}

	@Override
	public TipoServico findById(Long id) {
		return dao.findById(id);
	}

	@Override
	public List<TipoServico> listTipoServicos() {
		return dao.listTipoServicos();
	}

	@Override
	public boolean isTipoExist(TipoServico tipoServico) {
		return dao.findByName(tipoServico.getNome())!=null;
	}

	@Override
	public void updateTipoService(TipoServico currentTipo) {
		dao.updateTipoService(currentTipo);
		
	}

	@Override
	public void deleteTipoServico(TipoServico tipoServico) {
		dao.deleteTipoServico(tipoServico);
		
	}

}
