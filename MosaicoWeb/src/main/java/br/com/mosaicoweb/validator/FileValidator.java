package br.com.mosaicoweb.validator;


import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.mosaicomodel.model.Empresa;
import br.com.mosaicoweb.util.FileBucket;

@Component
public class FileValidator implements Validator {
    
   public boolean supports(Class<?> clazz) {
       return Empresa.class.isAssignableFrom(clazz);
   }

   public void validate(Object obj, Errors errors) {
	   Empresa file = (Empresa) obj;
        
       if(file.getFile()!=null){
           if (file.getFile().getSize() == 0) {
               errors.rejectValue("file", "missing.file");
           }
       }
   }
}