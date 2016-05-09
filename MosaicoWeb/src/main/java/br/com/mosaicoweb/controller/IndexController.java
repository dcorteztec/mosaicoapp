package br.com.mosaicoweb.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

import br.com.mosaicomodel.model.Empresa;
import br.com.mosaicomodel.model.Upload;
import br.com.mosaicomodel.model.Usuario;
import br.com.mosaicomodel.model.UsuarioPerfil;
import br.com.mosaicoweb.controller.abstracts.MainController;
import br.com.mosaicoweb.service.interfaces.IEmpresaService;
import br.com.mosaicoweb.service.interfaces.IUploadService;
import br.com.mosaicoweb.service.interfaces.IUsuarioPerfilService;
import br.com.mosaicoweb.service.interfaces.IUsuarioService;

@Controller
public class IndexController extends MainController{

	@Autowired
    IUsuarioPerfilService usuarioPerfilService;
     
    @Autowired
    IUsuarioService usuarioService;
    
    @Autowired
    IEmpresaService empresaService;
    
    @Autowired 
    IUploadService uploadService;
    
	private final ProviderSignInUtils providerSignInUtils;
    
	@Autowired
	public IndexController(
		                    ConnectionFactoryLocator connectionFactoryLocator,
		                    UsersConnectionRepository connectionRepository) {
		this.providerSignInUtils = new ProviderSignInUtils(connectionFactoryLocator, connectionRepository);
	}
    
    @RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
    public String homePage(ModelMap model) {
    	Usuario usuario = new Usuario();
  	
    	model.addAttribute("usuario", usuario);
        return "mosaicoApp.home";
    }
 
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(ModelMap model) {
    	Usuario usuario = usuarioService.findByEmail(getPrincipal());
        model.addAttribute("usuario", getPrincipal());
        model.addAttribute("perfil", usuario.getUsuarioPerfis().get(0).getId());
        return "mosaicoApp.painelAdmin";	
    }

    @RequestMapping(value = "/painel", method = RequestMethod.GET)
    public String painelUserPage(ModelMap model) {
    	Usuario usuario = usuarioService.findByEmail(getPrincipal());
    	List<Empresa> empresas = empresaService.listEmpresasByIdUsuario(usuario.getId());
    	model.addAttribute("empresa", empresas.get(0));
        model.addAttribute("usuario", getPrincipal());
        model.addAttribute("perfil", usuario.getUsuarioPerfis().get(0).getId());
        return "mosaicoApp.painelUser";
    }
  
    @RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
    public String accessDeniedPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "accessDenied";
    }
 
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(ModelMap model) {
        return "mosaicoApp.admin";
    }
    
    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String redirectFacebook(WebRequest request) {
    	Connection<?> connection = providerSignInUtils.getConnectionFromSession(request);
    	String email = connection.fetchUserProfile().getEmail();
    	String userId = connection.getKey().getProviderUserId();
    	
        return "redirect:/home";
    }
 
    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){    
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";
    }
 
    @RequestMapping(value = "/newUser", method = RequestMethod.POST)
    public String saveRegistration(@Valid Usuario usuario,
            BindingResult result, ModelMap model) {
 
        if (result.hasErrors()) {
            return "newuser";
        }
        usuarioService.save(usuario);
        return "mosaicoApp.home";
    }
 
     
    @ModelAttribute("roles")
    public List<UsuarioPerfil> initializeProfiles() {
        return usuarioPerfilService.findAll();
    }
    
}
