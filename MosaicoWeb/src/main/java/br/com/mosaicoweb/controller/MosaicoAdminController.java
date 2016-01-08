package br.com.mosaicoweb.controller;

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
import br.com.mosaicoweb.service.interfaces.IUsuarioPerfilService;
import br.com.mosaicoweb.service.interfaces.IUsuarioService;

@Controller
public class MosaicoAdminController extends MainController{

	@Autowired IUsuarioPerfilService usuarioPerfilService;
     
    @Autowired IUsuarioService usuarioService;
    
    @Autowired IEmpresaService empresaService;
     
    @Autowired EmpresaAdminController empresaController;
    
    
    @RequestMapping(value = "/primeiro_acesso", method = RequestMethod.GET)
    public String prineiroAcesso(ModelMap model) {
        model.addAttribute("usuario", getPrincipal());
        return "mosaicoApp.primeiro_acesso";
    }
    
    @RequestMapping(value = "/primeiro_acesso", method = RequestMethod.POST)
    public String prineiroAcesso(@Valid Empresa empresa, BindingResult result,
            ModelMap model) {
       Usuario usuario = usuarioService.findByEmail(getPrincipal());
       empresa.setUsuario(usuario);
       empresaService.save(empresa);
       List<Empresa> empresas = empresaService.listEmpresasByIdUsuario(usuario.getId());
       model.addAttribute("empresas", empresas);
       
       return empresaController.enderecoForm(model);
    }
    
}
