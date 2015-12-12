package br.com.mosaicomodel.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_EMPRESA")
@AttributeOverride(name = "id", column = @Column(name = "id", nullable = false))
public class Empresa extends br.com.mosaicomodel.model.abstracts.Entity {

	private static final long serialVersionUID = 1L;

	private String nome;
	private String telefone;
	private String celular;
	private String site;
	
	@ManyToOne
	@JoinColumn(name = "USUARIO_ID", nullable = false)
	private Usuario usuario;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "TB_EMPRESA_TIPO_SERVICO", 
			   joinColumns = { @JoinColumn(name = "EMPRESA_ID") }, 
			   inverseJoinColumns = { @JoinColumn(name = "TIPO_SERVICO_ID") })
	private Set<TipoServico> empresaTipoServico = new HashSet<TipoServico>();

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Set<TipoServico> getEmpresaTipoServico() {
		return empresaTipoServico;
	}

	public void setEmpresaTipoServico(Set<TipoServico> empresaTipoServico) {
		this.empresaTipoServico = empresaTipoServico;
	}

	
}
