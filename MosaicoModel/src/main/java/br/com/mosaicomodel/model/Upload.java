package br.com.mosaicomodel.model;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "TB_UPLOADS")
@AttributeOverride(name = "UPLOAD_ID", column = @Column(name = "COD_ID", nullable = false))
public class Upload extends br.com.mosaicomodel.model.abstracts.Entity{

	private static final long serialVersionUID = 1L;

	@Lob 
	@Basic(fetch=FetchType.LAZY)
	@Column(name="URL_IMAGENS")
	private String urlImagem;
	
    @ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "EMPRESA_ID")
	private Empresa empresa;

    @Transient
	private List<MultipartFile> files;

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public String getUrlImagem() {
		return urlImagem;
	}

	public void setUrlImagem(String urlImagem) {
		this.urlImagem = urlImagem;
	}

	public List<MultipartFile> getFiles() {
		return files;
	}

	public void setFiles(List<MultipartFile> files) {
		this.files = files;
	}

	
    
    
}
