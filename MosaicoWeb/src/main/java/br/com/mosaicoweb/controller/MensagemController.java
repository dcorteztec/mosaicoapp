package br.com.mosaicoweb.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.mosaicomodel.model.Empresa;
import br.com.mosaicomodel.model.Endereco;
import br.com.mosaicomodel.model.Mensagem;
import br.com.mosaicomodel.model.TipoServico;
import br.com.mosaicomodel.model.Usuario;
import br.com.mosaicomodel.util.Constantes;
import br.com.mosaicoweb.controller.abstracts.MainController;
import br.com.mosaicoweb.service.interfaces.IEmpresaService;
import br.com.mosaicoweb.service.interfaces.IMensagemService;
import br.com.mosaicoweb.service.interfaces.IUsuarioService;

@Controller
public class MensagemController extends MainController {

	@Autowired
	IMensagemService mensagemService;
	@Autowired
	IUsuarioService usuarioService;
	@Autowired
	IEmpresaService empresaService;

	@RequestMapping(value = "/painel/mensagem", method = RequestMethod.GET)
	public String mensagemForm(ModelMap model) {
		Mensagem mensagem = new Mensagem();
		Usuario usuario = usuarioService.findByEmail(getPrincipal());
		model.addAttribute("usuario", getPrincipal());
		model.addAttribute("perfil", usuario.getUsuarioPerfis().get(0).getId());
		model.addAttribute("mensagem", mensagem);
		List<Empresa> empresas = empresaService.listEmpresasByIdUsuario(usuario
				.getId());
		model.addAttribute("empresas", empresas);
		model.addAttribute("empresa", empresas.get(0));
		return "mosaicoApp.mensagem";
	}

	@RequestMapping(value = "/admin/mensagem", method = RequestMethod.GET)
	public String mensagemFormAdmin(ModelMap model) {
		Endereco endereco = new Endereco();
		Usuario usuario = usuarioService.findByEmail(getPrincipal());
		List<Empresa> empresas = empresaService.listEmpresas();
		model.addAttribute("usuario", getPrincipal());
		model.addAttribute("endereco", endereco);
		model.addAttribute("perfil", usuario.getUsuarioPerfis().get(0).getId());
		model.addAttribute("empresas", empresas);
		return "mosaicoApp.mensagemAdmin";
	}

	@RequestMapping(value = "/painel/mensagem/", method = RequestMethod.POST)
	public ResponseEntity<Void> createMensagem(@RequestBody Mensagem mensagem,
			UriComponentsBuilder ucBuilder) {

		Usuario admin = usuarioService.findById((long) 1);
		List<Empresa> empresas = empresaService
				.listEmpresasByIdUsuario(getUsuario().getId());
		mensagem.setAdmin(admin);
		mensagem.setStatus("A");
		mensagem.setEmpresa(empresas.get(0));
		mensagem = configurarClasse(mensagem);
		mensagem.setDataHora(new Date());
		mensagemService.save(mensagem);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/painel/mensagem/{id}")
				.buildAndExpand(mensagem.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	private Mensagem configurarClasse(Mensagem mensagem) {
		if(mensagem.getTipo().equals("SU")){
			mensagem.setClasse(Constantes.CLASSE_SUGESTAO);
		}else if(mensagem.getTipo().equals("AV")){
			mensagem.setClasse(Constantes.CLASSE_AVISO);
		}else if(mensagem.getTipo().equals("PR")){
			mensagem.setClasse(Constantes.CLASSE_PROBLEMA);
		}else if(mensagem.getTipo().equals("AG")){
			mensagem.setClasse(Constantes.CLASSE_AGRADECIMENTOS);
		}
		
		return mensagem;
	}

	@RequestMapping(value = "/admin/mensagem/", method = RequestMethod.POST)
	public ResponseEntity<Void> createMensagemAdmin(
			@RequestBody Mensagem mensagem, UriComponentsBuilder ucBuilder) {
        
		Empresa empresa = new Empresa();
		if(mensagem.getIdEmpresa()!=null){
			empresa = empresaService.findById(mensagem.getIdEmpresa());
			mensagem.setEmpresa(empresa);
		}else{
			mensagem.setEmpresa(null);
		}
		mensagem.setAdmin(null);
		mensagem.setStatus("A");
		mensagem.setDataHora(new Date());
		mensagem = configurarClasse(mensagem);
		mensagemService.save(mensagem);


		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/admin/mensagem/{id}")
				.buildAndExpand(mensagem.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/painel/mensagem/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Mensagem> getMensagem(@PathVariable("id") long id) {

		Mensagem mensagem = mensagemService.findById(id);
		if (mensagem == null) {
			return new ResponseEntity<Mensagem>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Mensagem>(mensagem, HttpStatus.OK);
	}

	@RequestMapping(value = "/admin/mensagem/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Mensagem> getMensagemAdmin(@PathVariable("id") long id) {
		Mensagem mensagem = mensagemService.findById(id);
		if (mensagem == null) {

			return new ResponseEntity<Mensagem>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Mensagem>(mensagem, HttpStatus.OK);
	}

	@RequestMapping(value = "/admin/mensagem/", method = RequestMethod.GET)
	public ResponseEntity<List<Mensagem>> listMensagensAdmin() {

		List<Mensagem> mensagens = new ArrayList<Mensagem>();

		mensagens = mensagemService.listMensagensByIdUsuarioAdmin((long) 1);

		if (mensagens.isEmpty()) {
			return new ResponseEntity<List<Mensagem>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Mensagem>>(mensagens, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/painel/mensagens/", method = RequestMethod.GET)
	public ResponseEntity<List<Mensagem>> listMensagens() {

		List<Mensagem> mensagens = new ArrayList<Mensagem>();
        
		Usuario usuario = usuarioService.findByEmail(getPrincipal());
		
		List<Empresa> empresas = empresaService.listEmpresasByIdUsuario(usuario.getId());
		
		mensagens = mensagemService.listMensagensByIdEmpresa(empresas.get(0).getId());

		if (mensagens.isEmpty()) {
			return new ResponseEntity<List<Mensagem>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Mensagem>>(mensagens, HttpStatus.OK);
	}
	
	 @RequestMapping(value = "/painel/mensagem/{id}", method = RequestMethod.DELETE)
	    public ResponseEntity<Mensagem> deleteMensagem(@PathVariable("id") long id) {	  
		     Mensagem mensagem = mensagemService.findById(id);
	        if (mensagem == null) {
	            System.out.println("Unable to delete. User with id " + id + " not found");
	            return new ResponseEntity<Mensagem>(HttpStatus.NOT_FOUND);
	        }
	        mensagem.setStatus("D");
	        mensagemService.deleteMensagem(mensagem);
	        return new ResponseEntity<Mensagem>(HttpStatus.NO_CONTENT);
	    }
}
