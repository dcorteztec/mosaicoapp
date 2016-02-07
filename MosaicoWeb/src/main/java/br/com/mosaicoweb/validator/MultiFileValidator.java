package br.com.mosaicoweb.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.mosaicoweb.util.FileBucket;
import br.com.mosaicoweb.util.MultiFileBucketForm;

@Component
public class MultiFileValidator implements Validator {
    
   public boolean supports(Class<?> clazz) {
       return MultiFileBucketForm.class.isAssignableFrom(clazz);
   }

   public void validate(Object obj, Errors errors) {
       MultiFileBucketForm multiBucket = (MultiFileBucketForm) obj;
        
       int index=0;
        
       for(FileBucket file : multiBucket.getFiles()){
           if(file.getFile()!=null){
               if (file.getFile().getSize() == 0) {
                   errors.rejectValue("files["+index+"].file", "missing.file");
               }
           }
           index++;
       }
        
   }
}