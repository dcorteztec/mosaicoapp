package br.com.mosaicoweb.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.mosaicomodel.model.Empresa;
import br.com.mosaicomodel.model.Endereco;
import br.com.mosaicomodel.model.Upload;
import br.com.mosaicomodel.model.Usuario;
import br.com.mosaicomodel.util.Constantes;
import br.com.mosaicoweb.controller.abstracts.MainController;
import br.com.mosaicoweb.service.interfaces.IEmpresaService;
import br.com.mosaicoweb.service.interfaces.IEnderecoService;
import br.com.mosaicoweb.service.interfaces.IUploadService;
import br.com.mosaicoweb.service.interfaces.IUsuarioPerfilService;
import br.com.mosaicoweb.service.interfaces.IUsuarioService;

@Controller
public class EmpresaAdminController extends MainController{

	@Autowired
    IUsuarioPerfilService usuarioPerfilService;
     
    @Autowired
    IUsuarioService usuarioService;
    
    @Autowired IEmpresaService empresaService;
    
    @Autowired IEnderecoService enderecoService;
    
    @Autowired IndexController indexController;
    
    @Autowired IUploadService uploadService;
    
    @RequestMapping(value = "/painel/endereco", method = RequestMethod.GET)
    public String enderecoForm(ModelMap model) {
    	Endereco endereco = new Endereco();
        Usuario usuario = usuarioService.findByEmail(getPrincipal());
        model.addAttribute("usuario", getPrincipal());
        model.addAttribute("endereco", endereco);
        List<Empresa> empresas = empresaService.listEmpresasByIdUsuario(usuario.getId());
        model.addAttribute("empresas", empresas);
        model.addAttribute("empresa", empresas.get(0));
        return "mosaicoApp.endereco";
    }
    
    @RequestMapping(value = "/painel/endereco/", method = RequestMethod.GET)
    public ResponseEntity<List<Endereco>> listEnderecos() {
    	Usuario usuario = getUsuario();
    	List<Endereco> enderecos = new ArrayList<Endereco>();
    	if(usuario.getUsuarioPerfis().get(0).getTipo().equals(Constantes.PERFIL_ADMIN)){
    		enderecos = enderecoService.listEnderecos();
    	}else{
    		List<Long> idsEmpresa = empresaService.idsEmpresaByIdUsuario(usuario.getId());
    		enderecos = enderecoService.listEnderecosByIdEmpresa(idsEmpresa);
    	}
        if(enderecos.isEmpty()){
            return new ResponseEntity<List<Endereco>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Endereco>>(enderecos, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/painel/endereco/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Endereco> getEndereco(@PathVariable("id") long id) {
    	Endereco endereco = enderecoService.findById(id);
        if (endereco == null) {
            return new ResponseEntity<Endereco>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Endereco>(endereco, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/painel/endereco/", method = RequestMethod.POST)
    public ResponseEntity<Void> createEndereco(@RequestBody Endereco endereco,    UriComponentsBuilder ucBuilder) {
        if (enderecoService.isCepExist(endereco)) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        Empresa empresa = empresaService.findById(endereco.getEmpresaId());
        endereco.setEmpresa(empresa);
        enderecoService.save(endereco);
  
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/admin/endereco/{id}").buildAndExpand(endereco.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/painel/endereco/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Endereco> updateEndereco(@PathVariable("id") long id, @RequestBody Endereco endereco) {
          
        Endereco currentEndereco = enderecoService.findById(id);
          
        if (currentEndereco==null) {
            return new ResponseEntity<Endereco>(HttpStatus.NOT_FOUND);
        }
  
        currentEndereco.setCep(endereco.getCep());
        currentEndereco.setLogradouro(endereco.getLogradouro());
        currentEndereco.setBairro(endereco.getBairro());
        currentEndereco.setCidade(endereco.getCidade());
        currentEndereco.setComplemento(endereco.getComplemento());
        currentEndereco.setEstado(endereco.getEstado());
        currentEndereco.setNumero(endereco.getNumero());
        Empresa empresa = empresaService.findById(endereco.getEmpresaId());
        currentEndereco.setEmpresa(empresa);
        enderecoService.updateEndereco(currentEndereco);
        return new ResponseEntity<Endereco>(currentEndereco, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/painel/endereco/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Endereco> deleteEndereco(@PathVariable("id") long id) {

        Endereco endereco = enderecoService.findById(id);
        if (endereco == null) {;
            return new ResponseEntity<Endereco>(HttpStatus.NOT_FOUND);
        }
  
        enderecoService.deleteEndereco(endereco);
        return new ResponseEntity<Endereco>(HttpStatus.NO_CONTENT);
    }
    
    @RequestMapping(value = "/painel/socialMedias", method = RequestMethod.GET)
    public String socialMediasForm(ModelMap model) {
        Usuario usuario = usuarioService.findByEmail(getPrincipal());
        model.addAttribute("usuario", getPrincipal());
        List<Empresa> empresas = empresaService.listEmpresasByIdUsuario(usuario.getId());
        model.addAttribute("empresas", empresas);
        model.addAttribute("empresa", empresas.get(0));
        return "mosaicoApp.socialMedias";
    }
    
    
    @RequestMapping(value = "/painel/socialMedias", method = RequestMethod.POST)
    public String prineiroAcesso(@Valid Empresa empresa,
           BindingResult result, ModelMap model) throws IOException {
          
    	  Empresa emp = empresaService.findById(empresa.getId());
          emp.setFacebook(empresa.getFacebook());
    	  emp.setInstagram(empresa.getInstagram());
    	  emp.setTwitter(empresa.getTwitter());
    	  emp.setPintRest(empresa.getPintRest());
    	  
          empresaService.updateEmpresa(emp);
          List<Empresa> empresas = empresaService.listEmpresasByIdUsuario(emp.getUsuario().getId());
          model.addAttribute("empresas", empresas);
 
       return indexController.painelUserPage(model);
    }
    
    @RequestMapping(value = "/painel/uploads", method = RequestMethod.GET)
    public String uploadsForm(ModelMap model) {
        Usuario usuario = usuarioService.findByEmail(getPrincipal());
        Upload upload = new Upload();
        model.addAttribute("usuario", getPrincipal());
        List<Empresa> empresas = empresaService.listEmpresasByIdUsuario(usuario.getId());
        model.addAttribute("empresas", empresas);
        model.addAttribute("empresa", empresas.get(0));
        model.addAttribute("upload", upload);
        return "mosaicoApp.uploads";
    }
    
    @RequestMapping(value = "/painel/uploads", method = RequestMethod.POST)
    public String uploadsForm(@Valid Upload upload,
           BindingResult result, ModelMap model) throws IOException {
       Usuario usuario = usuarioService.findByEmail(getPrincipal());
       List<Empresa> empresas = empresaService.listEmpresasByIdUsuario(usuario.getId());
       
       if (result.hasErrors()) {
           
       } else {
    	   List<MultipartFile> multipartFiles = upload.getFiles();
    	   for (MultipartFile multipartFile : multipartFiles) {
    		  
    		      Upload up = new Upload();
    	          File diretorioEmpresa = new File(Constantes.UPLOAD_LOCATION+empresas.get(0).getId());
    	          if(!diretorioEmpresa.exists()){
    	        	  diretorioEmpresa.mkdirs();
    	          }
    	         
    	          FileCopyUtils.copy(multipartFile.getBytes(),  new File(diretorioEmpresa +"/"+multipartFile.getOriginalFilename()));
    	          up.setEmpresa(empresas.get(0));
    	          up.setUrlImagem(Constantes.UPLOAD_LOCATION_IMAGEM+"/"+empresas.get(0).getId()+"/"+multipartFile.getOriginalFilename().replace(" ", ""));
    	          uploadService.save(up);
    	          
		}
    	   
       }
	  
       return null;
      
    }
       
}
