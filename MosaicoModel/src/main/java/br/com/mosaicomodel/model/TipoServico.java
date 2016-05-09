package br.com.mosaicomodel.model;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="TB_TIPO_SERVICO")
@AttributeOverride(name = "TIPOSERVICO_ID", column = @Column(name = "COD_ID", nullable = false))
public class TipoServico extends br.com.mosaicomodel.model.abstracts.Entity{

	private static final long serialVersionUID = 1L;

	@NotEmpty
    @Column(name="NOME", nullable=false)
	private String nome;

    @Column(name="DESCRICAO")
	private String descricao;
    
    @Transient
    private boolean check = false;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public boolean isCheck() {
		return check;
	}
	public void setCheck(boolean check) {
		this.check = check;
	}
	
	
	
	
}
