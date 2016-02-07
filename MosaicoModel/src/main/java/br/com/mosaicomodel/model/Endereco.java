package br.com.mosaicomodel.model;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="TB_ENDERECO")
@AttributeOverride(name = "ENDERECO_ID", column = @Column(name = "COD_ID", nullable = false))
public class Endereco extends br.com.mosaicomodel.model.abstracts.Entity{

	private static final long serialVersionUID = 1L;

	@NotEmpty
    @Column(name="CEP", nullable=false)
	private String cep;
	
	@NotEmpty
    @Column(name="LOGRADOURO", nullable=false)
	private String logradouro;
	
	@NotEmpty
    @Column(name="NUMERO", nullable=false)
	private String numero;
	
    @Column(name="COMPLEMENTO")
	private String complemento;
	
    @NotEmpty
    @Column(name="ESTADO", nullable=false)
	private String estado;
	
    @NotEmpty
    @Column(name="CIDADE", nullable=false)
	private String cidade;
	
    @NotEmpty
    @Column(name="BAIRRO", nullable=false)
	private String bairro;
	
    @NotEmpty
    @Column(name="LATITUDE", nullable=false)
	private String lat;
	
    @NotEmpty
    @Column(name="LONGITUDE", nullable=false)
	private String lng;
	
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "EMPRESA_ID")
	private Empresa empresa;
    
    @Transient
    private String nomeEmpresa;
    
    @Transient
    private Long empresaId;
    
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	public String getNomeEmpresa() {
		return nomeEmpresa;
	}
	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	public Long getEmpresaId() {
		return empresaId;
	}
	public void setEmpresaId(Long empresaId) {
		this.empresaId = empresaId;
	}
	
	
}
