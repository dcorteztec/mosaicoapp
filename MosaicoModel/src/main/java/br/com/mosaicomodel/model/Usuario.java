package br.com.mosaicomodel.model;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="TB_USUARIO")
@AttributeOverride(name = "id", column = @Column(name = "id", nullable = false))
public class Usuario extends br.com.mosaicomodel.model.abstracts.Entity{

	
	private static final long serialVersionUID = 1L;

	@NotEmpty
    @Column(name="SENHA", nullable=false)
    private String senha;
          
    @NotEmpty
    @Column(name="EMAIL", nullable=false)
    private String email;
 
    @NotEmpty
    @Column(name="STATUS", nullable=false)
    private String status=Status.ATIVO.getStatus();
 
    @Column(name="PRIMEIRO_ACESSO", nullable=true)
    private Date primeiroAcesso;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "TB_USUARIO_USUARIO_PERFIL", 
             joinColumns = { @JoinColumn(name = "USUARIO_ID") }, 
             inverseJoinColumns = { @JoinColumn(name = "USUARIO_PERFIL_ID") })
    private Set<UsuarioPerfil> usuarioPerfis = new HashSet<UsuarioPerfil>();

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set<UsuarioPerfil> getUsuarioPerfis() {
		return usuarioPerfis;
	}

	public void setUsuarioPerfis(Set<UsuarioPerfil> usuarioPerfis) {
		this.usuarioPerfis = usuarioPerfis;
	}

	public Date getPrimeiroAcesso() {
		return primeiroAcesso;
	}

	public void setPrimeiroAcesso(Date primeiroAcesso) {
		this.primeiroAcesso = primeiroAcesso;
	}

   
    
}
