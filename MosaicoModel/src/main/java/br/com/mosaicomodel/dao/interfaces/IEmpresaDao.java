package br.com.mosaicomodel.dao.interfaces;

import java.util.List;

import br.com.mosaicomodel.model.Empresa;

public interface IEmpresaDao {

    void save(Empresa empresa);
    
    Empresa findById(Long id);

    Empresa findByName(String nome);
	
	List<Empresa> listEmpresas();
	
	List<Empresa> listEmpresasByIdUsuario(Long idUser);
}
