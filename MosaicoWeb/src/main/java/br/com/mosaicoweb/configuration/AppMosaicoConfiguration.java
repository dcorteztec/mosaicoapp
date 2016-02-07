package br.com.mosaicoweb.configuration;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

import br.com.mosaicoweb.springsecurity.configuration.RoleToUsuarioPerfilConverter;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "br.com")
public class AppMosaicoConfiguration extends WebMvcConfigurerAdapter{
	 
	@Autowired
	 RoleToUsuarioPerfilConverter roleToUsuarioPerfilConverter;
	
	
	 @Bean
	    TilesViewResolver viewResolver(){
	        TilesViewResolver viewResolver = new TilesViewResolver();
	        return viewResolver;
	    }

	    @Bean
	    TilesConfigurer tilesConfigurer(){
	        TilesConfigurer tilesConfigurer = new TilesConfigurer();
	        tilesConfigurer.setDefinitions(new String[] {"WEB-INF/views/jsp/tiles/admin.xml","WEB-INF/views/jsp/tiles/tiles.xml"});
	        tilesConfigurer.setPreparerFactoryClass(org.springframework.web.servlet.view.tiles3.SpringBeanPreparerFactory.class);
	        return tilesConfigurer;    
	    }
	    
	    @Bean(name = "multipartResolver")
	    public CommonsMultipartResolver resolver() {
	        return new CommonsMultipartResolver();
	    }
	    
	    @Bean
	    public static MessageSource messageSource() {
	       ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
	       messageSource.setBasename("classpath:mensagem");
	       //messageSource.setFallbackToSystemLocale(false);
	       return messageSource;
	    }
	    
	    @Bean
	    public LocaleResolver localeResolver(){
			CookieLocaleResolver resolver = new CookieLocaleResolver();
			resolver.setDefaultLocale(new Locale("pt_br"));
			resolver.setCookieName("myLocaleCookie");
			resolver.setCookieMaxAge(4800);
			return resolver;
	    }
	    @Override
	    public void addInterceptors(InterceptorRegistry registry) {
			LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
			interceptor.setParamName("mylocale");
			registry.addInterceptor(interceptor);
	    }
	    
	    /*
	     * Configure ResourceHandlers to serve static resources like CSS/ Javascript etc...
	     *
	     */
	    @Override
	    public void addResourceHandlers(ResourceHandlerRegistry registry) {
	        registry.addResourceHandler("/static/**").addResourceLocations("/static/");
	    }
	     
	    /*
	     * Configure Converter to be used.
	     * In our example, we need a converter to convert string values[Roles] to UserProfiles in newUser.jsp
	     */
	    @Override
	    public void addFormatters(FormatterRegistry registry) {
	        registry.addConverter(roleToUsuarioPerfilConverter);
	    }
 
}