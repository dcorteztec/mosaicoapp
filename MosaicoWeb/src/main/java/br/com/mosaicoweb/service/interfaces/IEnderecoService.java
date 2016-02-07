package br.com.mosaicoweb.service.interfaces;

import java.util.List;

import br.com.mosaicomodel.model.Endereco;

public interface IEnderecoService {

	 void save(Endereco endereco);
	    
	 Endereco findById(Long id);

	 Endereco findByCep(String cep);
	    
	 List<Endereco> listEnderecoByIdEmpresa(Long idEmpresa);
	    
	 List<Endereco> listEnderecos();

	 boolean isCepExist(Endereco endereco);

	 void updateEndereco(Endereco endereco);

	 void deleteEndereco(Endereco endereco);

	 List<Endereco> listEnderecosByIdEmpresa(List<Long> idsEmpresa);
}
