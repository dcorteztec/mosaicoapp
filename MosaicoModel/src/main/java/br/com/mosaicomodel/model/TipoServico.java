package br.com.mosaicomodel.model;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="TB_TIPO_SERVICO")
@AttributeOverride(name = "id", column = @Column(name = "id", nullable = false))
public class TipoServico extends br.com.mosaicomodel.model.abstracts.Entity{

	private static final long serialVersionUID = 1L;

	@NotEmpty
    @Column(name="NOME", nullable=false)
	private String nome;

    @Column(name="DESCRICAO")
	private String descricao;
	
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
	
	
}
