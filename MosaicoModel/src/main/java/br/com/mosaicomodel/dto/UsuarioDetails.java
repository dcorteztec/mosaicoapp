package br.com.mosaicomodel.dto;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.social.security.SocialUser;

public class UsuarioDetails extends SocialUser{

	public UsuarioDetails(String username, String password, boolean enabled,
			boolean accountNonExpired, boolean credentialsNonExpired,
			boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired,
				accountNonLocked, authorities);
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;

	
}
