package br.com.mosaicomodel.dao.interfaces;

import java.util.List;

import br.com.mosaicomodel.model.Mensagem;

public interface IMensagemDao {

	void save(Mensagem mensagem);

	Mensagem findById(Long id);

	List<Mensagem> listMensagens();

	void updateMensagem(Mensagem mensagem);

	void deleteMensagem(Mensagem mensagem);
	
	List<Mensagem> listMensagensByIdEmpresa(Long idEmpresa);
	
	List<Mensagem> listMensagensByIdUsuarioAdmin(Long idUsuario);
}
