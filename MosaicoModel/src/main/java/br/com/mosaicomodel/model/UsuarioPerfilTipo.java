package br.com.mosaicomodel.model;

public enum UsuarioPerfilTipo {

	USER("USUARIO"),
    ADMIN("ADMIN");
     
    String usuarioPerfilTipo;
     
    private UsuarioPerfilTipo(String usuarioPerfilTipo){
        this.usuarioPerfilTipo = usuarioPerfilTipo;
    }

	public String getUsuarioPerfilTipo() {
		return usuarioPerfilTipo;
	}    
   
}
