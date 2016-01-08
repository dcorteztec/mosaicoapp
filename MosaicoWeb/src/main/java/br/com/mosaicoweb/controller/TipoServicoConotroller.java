package br.com.mosaicoweb.controller;

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

import br.com.mosaicomodel.model.TipoServico;
import br.com.mosaicoweb.controller.abstracts.MainController;
import br.com.mosaicoweb.service.interfaces.ITipoServicoService;

@Controller
public class TipoServicoConotroller  extends MainController{

	 @Autowired ITipoServicoService tipoServicoService;
	
	@RequestMapping(value = "/admin/tipoServico", method = RequestMethod.GET)
    public String tipoServico(ModelMap model) {
        model.addAttribute("usuario", getPrincipal());
        TipoServico servico = new TipoServico();
        model.addAttribute("tipoServico", servico);
        return "mosaicoApp.tipoServico";
    }
    
    @RequestMapping(value = "/admin/tipoServico/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TipoServico> getTipoServico(@PathVariable("id") long id) {
        System.out.println("Fetching User with id " + id);
        TipoServico tipoServico = tipoServicoService.findById(id);
        if (tipoServico == null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<TipoServico>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<TipoServico>(tipoServico, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/admin/tipoServico/", method = RequestMethod.POST)
    public ResponseEntity<Void> createTipoServico(@RequestBody TipoServico tipoServico,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating User " + tipoServico.getNome());
  
        if (tipoServicoService.isTipoExist(tipoServico)) {
            System.out.println("A User with name " + tipoServico.getNome() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
  
        tipoServicoService.save(tipoServico);
  
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/admin/tipoServico/{id}").buildAndExpand(tipoServico.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/admin/tipoServico/{id}", method = RequestMethod.PUT)
    public ResponseEntity<TipoServico> updateTipoServico(@PathVariable("id") long id, @RequestBody TipoServico tipoServico) {
        System.out.println("Updating User " + id);
          
        TipoServico currentTipo = tipoServicoService.findById(id);
          
        if (currentTipo==null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<TipoServico>(HttpStatus.NOT_FOUND);
        }
  
        currentTipo.setNome(tipoServico.getNome());
        currentTipo.setDescricao(tipoServico.getDescricao());
          
        tipoServicoService.updateTipoService(currentTipo);
        return new ResponseEntity<TipoServico>(currentTipo, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/admin/tipoServico/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<TipoServico> deleteTipoServico(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting User with id " + id);
  
        TipoServico tipoServico = tipoServicoService.findById(id);
        if (tipoServico == null) {
            System.out.println("Unable to delete. User with id " + id + " not found");
            return new ResponseEntity<TipoServico>(HttpStatus.NOT_FOUND);
        }
  
        tipoServicoService.deleteTipoServico(tipoServico);
        return new ResponseEntity<TipoServico>(HttpStatus.NO_CONTENT);
    }
  
    
    @RequestMapping(value = "/admin/tipoServico/", method = RequestMethod.GET)
    public ResponseEntity<List<TipoServico>> listTipoServicos() {
        List<TipoServico> tServicos = tipoServicoService.listTipoServicos();
        if(tServicos.isEmpty()){
            return new ResponseEntity<List<TipoServico>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<TipoServico>>(tServicos, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/admin/tipoServicoJson", method = RequestMethod.GET)
    public ResponseEntity<List<TipoServico>> listTipoServicosJson() {
        List<TipoServico> tServicos = tipoServicoService.listTipoServicos();
        if(tServicos.isEmpty()){
            return new ResponseEntity<List<TipoServico>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<TipoServico>>(tServicos, HttpStatus.OK);
    }
}
