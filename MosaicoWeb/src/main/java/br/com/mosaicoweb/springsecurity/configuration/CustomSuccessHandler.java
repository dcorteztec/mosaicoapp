package br.com.mosaicoweb.springsecurity.configuration;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import br.com.mosaicomodel.model.Usuario;
import br.com.mosaicoweb.service.inter.IUsuarioService;

@Component
public class CustomSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	@Autowired
	IUsuarioService usuarioService;
	
	@Override
	protected void handle(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws IOException {
		String targetUrl = determineUrldeAcesso(authentication);

		if (response.isCommitted()) {
			System.out.println("Can't redirect");
			return;
		}

		redirectStrategy.sendRedirect(request, response, targetUrl);
	}

	private String determineUrldeAcesso(Authentication authentication) {
		Usuario usuario = usuarioService.findByEmail(getPrincipal().getUsername());
		String url = "";
		
		if(usuario.getPrimeiroAcesso()!=null){
			url="/admin";
		}else{
			//usuarioService.updatePrimeiroAcesso(usuario.getId());
			url="/primeiro_acesso";
		}
		
		return url;
	}

	public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
		this.redirectStrategy = redirectStrategy;
	}

	protected RedirectStrategy getRedirectStrategy() {
		return redirectStrategy;
	}
	
	private User getPrincipal(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
 
        
        return (User) principal;
    }
}
