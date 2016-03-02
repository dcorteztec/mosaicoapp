package br.com.mosaicomodel.model;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.com.mosaicomodel.util.FormatProperty;

@Entity
@Table(name = "TB_MENSAGEM")
@AttributeOverride(name = "MENSAGEM_ID", column = @Column(name = "COD_ID", nullable = false))
public class Mensagem extends br.com.mosaicomodel.model.abstracts.Entity {

	private static final long serialVersionUID = 1L;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "EMPRESA_ID", nullable=true)
	private Empresa empresa;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ADMIN_ID", nullable=true)
	private Usuario admin;
	
	@Column(name="MENSAGEM_TXT")
	private String texto;
	
    @Column(name="TIPO", nullable=true)
    private String tipo;
    
    @Column(name="STATUS", nullable=true)
    private String status;
    
    @Column(name="CLASSE", nullable=true)
    private String classe;
    
    @Column(name="DATA_HORA_ENVIO", nullable=false)
    private Date dataHora;
    
    @Transient
    private Long idEmpresa;
    
    @Transient
	public String dataHoraFormatada;
    
	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Usuario getAdmin() {
		return admin;
	}

	public void setAdmin(Usuario admin) {
		this.admin = admin;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

	public Date getDataHora() {
		return dataHora;
	}

	public void setDataHora(Date dataHora) {
		FormatProperty formatProperty = new FormatProperty();
		setDataHoraFormatada(formatProperty.formartarDataHora(dataHora));
		this.dataHora = dataHora;
	}

	public Long getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(Long idEmpresa) {
		this.idEmpresa = idEmpresa;
	}
	
	public String getDataHoraFormatada() {
		if(dataHora!=null){
			FormatProperty formatProperty = new FormatProperty();
			return formatProperty.formartarDataHora(dataHora);
		}
		return dataHoraFormatada;
	}

	public void setDataHoraFormatada(String dataHoraFormatada) {
		this.dataHoraFormatada = dataHoraFormatada;
	}
	
}
