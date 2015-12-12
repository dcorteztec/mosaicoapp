package br.com.mosaicoweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.mosaicomodel.model.Empresa;
import br.com.mosaicomodel.model.Endereco;
import br.com.mosaicomodel.model.Usuario;
import br.com.mosaicoweb.controller.abstracts.MainController;
import br.com.mosaicoweb.service.interfaces.IEmpresaService;
import br.com.mosaicoweb.service.interfaces.IUsuarioPerfilService;
import br.com.mosaicoweb.service.interfaces.IUsuarioService;

@Controller
public class EmpresaAdminController extends MainController{

	@Autowired
    IUsuarioPerfilService usuarioPerfilService;
     
    @Autowired
    IUsuarioService usuarioService;
    
    @Autowired IEmpresaService empresaService;
    
    @RequestMapping(value = "/admin/endereco", method = RequestMethod.GET)
    public String enderecoForm(ModelMap model) {
    	Endereco endereco = new Endereco();
    	 Usuario usuario = usuarioService.findByEmail(getPrincipal());
        model.addAttribute("usuario", getPrincipal());
        model.addAttribute("endereco", endereco);
        List<Empresa> empresas = empresaService.listEmpresasByIdUsuario(usuario.getId());
        model.addAttribute("empresas", empresas);
        return "mosaicoApp.endereco";
    }
    
}
