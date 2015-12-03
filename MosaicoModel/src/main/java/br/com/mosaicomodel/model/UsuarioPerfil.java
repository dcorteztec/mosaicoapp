package br.com.mosaicomodel.model;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="TB_USUARIO_PERFIL")
@AttributeOverride(name = "id", column = @Column(name = "id", nullable = false))
public class UsuarioPerfil extends br.com.mosaicomodel.model.abstracts.Entity {

	private static final long serialVersionUID = 1L;

 
    @Column(name="TIPO", length=15, unique=true, nullable=false)
    private String tipo = UsuarioPerfilTipo.USER.getUsuarioPerfilTipo();


	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	
}
