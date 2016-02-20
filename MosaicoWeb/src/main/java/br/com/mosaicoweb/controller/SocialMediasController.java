package br.com.mosaicoweb.controller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.mosaicomodel.model.Empresa;
import br.com.mosaicomodel.model.Usuario;
import br.com.mosaicoweb.controller.abstracts.MainController;
import br.com.mosaicoweb.service.interfaces.IEmpresaService;
import br.com.mosaicoweb.service.interfaces.IUsuarioService;

@Controller
public class SocialMediasController extends MainController{

     @Autowired IUsuarioService usuarioService;
	 
	 @Autowired IEmpresaService empresaService;
	 
	 @Autowired IndexController indexController;
	
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
    public String socialMediasForm(@Valid Empresa empresa,
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
}
