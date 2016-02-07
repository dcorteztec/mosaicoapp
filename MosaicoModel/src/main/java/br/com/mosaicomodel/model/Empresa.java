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
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import br.com.mosaicomodel.util.FormatProperty;

@Entity
@Table(name = "TB_EMPRESA")
@AttributeOverride(name = "EMPRESA_ID", column = @Column(name = "COD_ID", nullable = false))
public class Empresa extends br.com.mosaicomodel.model.abstracts.Entity {

	private static final long serialVersionUID = 1L;

	@Column(name="NOME", nullable=false)
	private String nome;
	
	@Column(name="TELEFONE", nullable=false)
	private String telefone;
	
	@Column(name="CELULAR", nullable=false) 
	private String celular;
	
	@Column(name="SITE", nullable=false)
	private String site;
	
	@Column(name="URL_LOGO", nullable=false)
	private String urlLogo;
	
	@Column(name="DATA_CAD", nullable=false)
	private Date dataCadastro;
	
	@ManyToOne
	@JoinColumn(name = "USUARIO_ID", nullable = false)
	private Usuario usuario;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "TB_EMPRESA_TIPO_SERVICO", 
			   joinColumns = { @JoinColumn(name = "EMPRESA_ID") }, 
			   inverseJoinColumns = { @JoinColumn(name = "TIPO_SERVICO_ID") })
	private Set<TipoServico> empresaTipoServico = new HashSet<TipoServico>();
	
	// SOCIAL MIDIAS
	
	@Column(name="FACEBOOK", nullable=true)
	private String facebook;
	
	@Column(name="INSTAGRAM", nullable=true)
	private String instagram;
	
	@Column(name="TWITTER", nullable=true)
	private String twitter;
	
	@Column(name="PINTREST", nullable=true)
	private String pintRest;
	
	@Transient
	private Long[] tServicos;

	@Transient
	private String dataFormatada;
	
	@Transient
	MultipartFile file;

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}
	
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

	public String getUrlLogo() {
		return urlLogo;
	}

	public void setUrlLogo(String urlLogo) {
		this.urlLogo = urlLogo;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public String getInstagram() {
		return instagram;
	}

	public void setInstagram(String instagram) {
		this.instagram = instagram;
	}

	public String getTwitter() {
		return twitter;
	}

	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}

	public String getPintRest() {
		return pintRest;
	}

	public void setPintRest(String pintRest) {
		this.pintRest = pintRest;
	}

	public Long[] gettServicos() {
		return tServicos;
	}

	public void settServicos(Long[] tServicos) {
		this.tServicos = tServicos;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		FormatProperty formatProperty = new FormatProperty();
		setDataFormatada(formatProperty.formartarData(dataCadastro));
		this.dataCadastro = dataCadastro;
	}

	public String getDataFormatada() {
		if(dataCadastro!=null){
			FormatProperty formatProperty = new FormatProperty();
			return formatProperty.formartarData(dataCadastro);
		}
		return dataFormatada;
	}

	public void setDataFormatada(String dataFormatada) {
		this.dataFormatada = dataFormatada;
	}

    

	
}
