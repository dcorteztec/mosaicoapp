package br.com.mosaicoweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.mosaicoweb.controller.abstracts.MainController;
import br.com.mosaicoweb.service.interfaces.IUsuarioPerfilService;
import br.com.mosaicoweb.service.interfaces.IUsuarioService;

@Controller
public class EmpresaAdminController extends MainController{

	@Autowired
    IUsuarioPerfilService usuarioPerfilService;
     
    @Autowired
    IUsuarioService usuarioService;
    
    @RequestMapping(value = "/admin/endereco", method = RequestMethod.GET)
    public String enderecoForm(ModelMap model) {
        model.addAttribute("usuario", getPrincipal());
        return "mosaicoApp.endereco";
    }
    
}
