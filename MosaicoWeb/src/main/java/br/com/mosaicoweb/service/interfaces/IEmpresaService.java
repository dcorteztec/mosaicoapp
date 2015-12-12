package br.com.mosaicoweb.service.interfaces;

import java.util.List;

import br.com.mosaicomodel.model.Empresa;

public interface IEmpresaService {

    void save(Empresa empresa);
    
    Empresa findById(Long id);

    Empresa findByName(String nome);
    
    public List<Empresa> listEmpresasByIdUsuario(Long idUser);
    
    public List<Empresa> listEmpresas();
}
