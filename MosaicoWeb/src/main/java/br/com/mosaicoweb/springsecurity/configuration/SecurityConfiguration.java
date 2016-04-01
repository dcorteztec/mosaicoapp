package br.com.mosaicoweb.springsecurity.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.social.security.SpringSocialConfigurer;

import br.com.mosaicoweb.springsecurity.service.SimpleSocialUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Autowired
    @Qualifier("customUserDetailsService")
    UserDetailsService userDetailsService;
    
	@Autowired
	CustomSuccessHandler customSuccessHandler;
     
    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
        auth.authenticationProvider(authenticationProvider());
    }
     
     
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
     
    @Bean
    public SocialUserDetailsService socialUserDetailsService() {
        return new SimpleSocialUserDetailsService(userDetailsService);
    }
     
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }
     
    @Override
    protected void configure(HttpSecurity http) throws Exception {
      http.authorizeRequests()
        .antMatchers("/","/home","/newuser","/usuarioRest/**","/auth/**","/signup/**","/signin/**").permitAll()
        .antMatchers("/admin/**").access("hasRole('ADMIN')")
        .antMatchers("/primeiro_acesso/**","/painel/**").access("hasRole('ADMIN') or hasRole('USUARIO')")
        .and().formLogin().loginPage("/home").successHandler(customSuccessHandler).loginProcessingUrl("/home/authenticate")
        .usernameParameter("email").passwordParameter("senha")
        .and().exceptionHandling().accessDeniedPage("/Access_Denied")
        .and().apply(new SpringSocialConfigurer());
         http.csrf().disable();       
    }
}
