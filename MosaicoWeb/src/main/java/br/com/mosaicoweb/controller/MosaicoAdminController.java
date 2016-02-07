package br.com.mosaicoweb.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import br.com.mosaicomodel.model.Empresa;
import br.com.mosaicomodel.model.TipoServico;
import br.com.mosaicomodel.model.Usuario;
import br.com.mosaicomodel.util.Constantes;
import br.com.mosaicoweb.controller.abstracts.MainController;
import br.com.mosaicoweb.service.interfaces.IEmpresaService;
import br.com.mosaicoweb.service.interfaces.ITipoServicoService;
import br.com.mosaicoweb.service.interfaces.IUsuarioPerfilService;
import br.com.mosaicoweb.service.interfaces.IUsuarioService;
import br.com.mosaicoweb.validator.FileValidator;
import br.com.mosaicoweb.validator.MultiFileValidator;

@Controller
public class MosaicoAdminController extends MainController{
	
	@Autowired IUsuarioPerfilService usuarioPerfilService;
     
    @Autowired IUsuarioService usuarioService;
    
    @Autowired IEmpresaService empresaService;
     
    @Autowired EmpresaAdminController empresaController;
    
    @Autowired ITipoServicoService tipoSService;
    
    @Autowired ServletContext context;
    
    @Autowired MultiFileValidator multiFileValidator;
    
    @Autowired FileValidator fileValidator;
    
    @InitBinder("empresa")
    protected void initBinderFileBucket(WebDataBinder binder) {
        binder.setValidator(fileValidator);
    }
 
    @InitBinder("upload")
    protected void initBinderMultiFileBucket(WebDataBinder binder) {
        binder.setValidator(multiFileValidator);
    }
 
    
    @RequestMapping(value = "/primeiro_acesso", method = RequestMethod.GET)
    public String prineiroAcesso(ModelMap model) {
        Empresa empresa = new Empresa();
        List<TipoServico> tipoList = tipoSService.listTipoServicos();
        model.addAttribute("tServicos", tipoList);
        model.addAttribute("usuario", getPrincipal());
        model.addAttribute("empresa", empresa);
        return "mosaicoApp.primeiro_acesso";
    }
    
    @RequestMapping(value = "/primeiro_acesso", method = RequestMethod.POST)
    public String prineiroAcesso(@Valid Empresa empresa,
           BindingResult result, ModelMap model) throws IOException {
       Usuario usuario = usuarioService.findByEmail(getPrincipal());
       empresa.setUsuario(usuario);
       if (result.hasErrors()) {
           
       } else {
 	     	   
          MultipartFile multipartFile = empresa.getFile();
          //String pasta = context.getRealPath("/");
          String nomeFile = empresa.getNome().replaceAll(" ","");  
          File diretorioEmpresa = new File(Constantes.UPLOAD_LOCATION+nomeFile);
          if(!diretorioEmpresa.exists()){
        	  diretorioEmpresa.mkdirs();
          }
         
          FileCopyUtils.copy(empresa.getFile().getBytes(),  new File(diretorioEmpresa +"/"+empresa.getFile().getOriginalFilename()));
          
          
          String fileName = multipartFile.getOriginalFilename();
          model.addAttribute("fileName", fileName);
          empresa.setUrlLogo(Constantes.UPLOAD_LOCATION_IMAGEM+"/"+empresa.getNome()+"/"+empresa.getFile().getOriginalFilename().replace(" ", ""));
          empresa.setDataCadastro(new Date());
          // SERVIÇOS
          for (int i = 0; i < empresa.gettServicos().length; i++) {
			TipoServico servico = tipoSService.findById(empresa.gettServicos()[i]);
			empresa.getEmpresaTipoServico().add(servico);
          }
          
          
          empresaService.save(empresa);
          usuarioService.updatePrimeiroAcesso(usuario.getId());
          List<Empresa> empresas = empresaService.listEmpresasByIdUsuario(usuario.getId());
          model.addAttribute("empresas", empresas);
         
       } 
       
       return empresaController.enderecoForm(model);
    }
    
}
