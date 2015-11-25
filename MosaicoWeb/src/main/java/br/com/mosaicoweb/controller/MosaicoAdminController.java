package br.com.mosaicoweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.mosaicoweb.service.inter.IUsuarioPerfilService;
import br.com.mosaicoweb.service.inter.IUsuarioService;

@Controller
public class MosaicoAdminController extends MainController{

	@Autowired
    IUsuarioPerfilService usuarioPerfilService;
     
    @Autowired
    IUsuarioService usuarioService;
    
    @RequestMapping(value = "/primeiro_acesso", method = RequestMethod.GET)
    public String prineiroAcesso(ModelMap model) {
        model.addAttribute("usuario", getPrincipal());
        return "mosaicoApp.primeiro_acesso";
    }
}
