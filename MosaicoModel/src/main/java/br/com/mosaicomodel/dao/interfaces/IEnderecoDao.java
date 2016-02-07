package br.com.mosaicomodel.dao.interfaces;

import java.util.List;

import br.com.mosaicomodel.model.Endereco;

public interface IEnderecoDao {

	void save(Endereco endereco);

	Endereco findById(Long id);

	List<Endereco> listEnderecos();
	
	Endereco findByCep(String cep);

	void updateEndereco(Endereco endereco);

	void deleteEndereco(Endereco endereco);
	
	List<Endereco> listEnderecosByIdEmpresa(List<Long> idsEmpresa);
}
