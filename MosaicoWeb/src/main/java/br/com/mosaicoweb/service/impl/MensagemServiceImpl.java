package br.com.mosaicoweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.mosaicomodel.dao.interfaces.IMensagemDao;
import br.com.mosaicomodel.model.Mensagem;
import br.com.mosaicoweb.service.interfaces.IMensagemService;

@Service("mensagemService")
@Transactional
public class MensagemServiceImpl implements IMensagemService{

	@Autowired IMensagemDao dao;
	
	@Override
	public void save(Mensagem mensagem) {
		dao.save(mensagem);
		
	}

	@Override
	public Mensagem findById(Long id) {
		return dao.findById(id);
	}

	@Override
	public List<Mensagem> listMensagens() {
		return dao.listMensagens();
	}

	@Override
	public void updateMensagem(Mensagem mensagem) {
		dao.updateMensagem(mensagem);
		
	}

	@Override
	public void deleteMensagem(Mensagem mensagem) {
		dao.deleteMensagem(mensagem);
		
	}

	@Override
	public List<Mensagem> listMensagensByIdEmpresa(Long idEmpresa) {
		return dao.listMensagensByIdEmpresa(idEmpresa);
	}

	@Override
	public List<Mensagem> listMensagensByIdUsuarioAdmin(Long idUsuario) {
		return dao.listMensagensByIdUsuarioAdmin(idUsuario);
	}

}
