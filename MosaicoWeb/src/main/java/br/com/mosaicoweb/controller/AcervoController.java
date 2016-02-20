package br.com.mosaicoweb.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import br.com.mosaicomodel.model.Empresa;
import br.com.mosaicomodel.model.Upload;
import br.com.mosaicomodel.model.Usuario;
import br.com.mosaicomodel.util.Constantes;
import br.com.mosaicoweb.controller.abstracts.MainController;
import br.com.mosaicoweb.service.interfaces.IEmpresaService;
import br.com.mosaicoweb.service.interfaces.IUploadService;
import br.com.mosaicoweb.service.interfaces.IUsuarioService;

@Controller
public class AcervoController extends MainController{

	 @Autowired IUsuarioService usuarioService;
	 
	 @Autowired IEmpresaService empresaService;
	 
	 @Autowired IUploadService uploadService;
	
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
	 
	 @RequestMapping(value = "/painel/acervo", method = RequestMethod.GET)
	    public String paginaAcervo(ModelMap model) {
	        Usuario usuario = usuarioService.findByEmail(getPrincipal());
	        Upload upload = new Upload();
	        model.addAttribute("usuario", getPrincipal());
	        List<Empresa> empresas = empresaService.listEmpresasByIdUsuario(usuario.getId());
	        model.addAttribute("empresas", empresas);
	        model.addAttribute("empresa", empresas.get(0));
	        model.addAttribute("upload", upload);
	        return "mosaicoApp.acervo";
	    }
	 
	 @RequestMapping(value = "/painel/acervos", method = RequestMethod.GET)
	    public ResponseEntity<List<Upload>> listImagens() {
		    Usuario usuario = usuarioService.findByEmail(getPrincipal());
	        List<Empresa> empresas = empresaService.listEmpresasByIdUsuario(usuario.getId());
	        List<Upload> imagens = uploadService.listUploadsByIdEmpresa(empresas.get(0).getId());
	        if(imagens.isEmpty()){
	            return new ResponseEntity<List<Upload>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
	        }
	        return new ResponseEntity<List<Upload>>(imagens, HttpStatus.OK);
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
	    	          up.setThumbUrl(Constantes.UPLOAD_LOCATION_IMAGEM+"/"+empresas.get(0).getId()+"/"+multipartFile.getOriginalFilename().replace(" ", ""));
	    	          up.setUrl(Constantes.UPLOAD_LOCATION_IMAGEM+"/"+empresas.get(0).getId()+"/"+multipartFile.getOriginalFilename().replace(" ", ""));
	    	          uploadService.save(up);
	    	          
			}
	    	   
	       }
		  
	       return paginaAcervo(model);
	      
	    }
	    
	    @RequestMapping(value = "/painel/acervo/{id}", method = RequestMethod.DELETE)
	    public ResponseEntity<Upload> deleteImagem(@PathVariable("id") long id) {
	   
	        Upload upload = uploadService.findById(id);
	        if (upload == null) {
	            System.out.println("Unable to delete. User with id " + id + " not found");
	            return new ResponseEntity<Upload>(HttpStatus.NOT_FOUND);
	        }
	  
	        uploadService.deleteUpload(upload);
	        return new ResponseEntity<Upload>(HttpStatus.NO_CONTENT);
	    }
	    
	    @RequestMapping(value = "/painel/lightbox-modal", method = RequestMethod.GET)
	    public String lightBox(ModelMap model) {
	    	return "mosaicoApp.lightBox";
	    }
}
