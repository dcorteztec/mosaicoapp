package br.com.mosaicomodel.dao.interfaces;

import java.util.List;

import br.com.mosaicomodel.model.TipoServico;

public interface ITipoServicoDao {

	void save(TipoServico tipo);

	TipoServico findById(Long id);

	List<TipoServico> listTipoServicos();
}
