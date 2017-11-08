package model.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import model.enums.Enum_Aux_Tipo_Logradouro;

@SuppressWarnings("serial")
@Entity
@Table(name="Logradouro")
public class Logradouro extends GenericDomain implements Serializable {
	
	@Id
	@SequenceGenerator(name="pk_logradouro",sequenceName="messsounds_logradouro", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="pk_logradouro")
	private Long id;
	
	@Enumerated(EnumType.STRING)
	@Column(name="enum_Aux_Tipo_Logradouro")	
	private Enum_Aux_Tipo_Logradouro enum_Aux_Tipo_Logradouro ;
	
	@Column(name="descricao", length = 90, nullable=false)
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name = "id_Cidade")
	private Cidade id_Cidade;
	
	@ManyToOne
	@JoinColumn ( name ="id_Pessoa_Registro")	
	private Pessoa id_Pessoa_Registro;
	
	public Logradouro(){
		super();
		setEnum_Aux_Tipo_Logradouro(Enum_Aux_Tipo_Logradouro.RUA);
		
	}
	
	public Logradouro(Cidade cidade){
		super();
		setEnum_Aux_Tipo_Logradouro(Enum_Aux_Tipo_Logradouro.RUA);	
		
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Enum_Aux_Tipo_Logradouro getEnum_Aux_Tipo_Logradouro() {
		return enum_Aux_Tipo_Logradouro;
	}

	public void setEnum_Aux_Tipo_Logradouro(Enum_Aux_Tipo_Logradouro enum_Aux_Tipo_Logradouro) {
		this.enum_Aux_Tipo_Logradouro = enum_Aux_Tipo_Logradouro;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Cidade getId_Cidade() {
		return id_Cidade;
	}

	public void setId_Cidade(Cidade id_Cidade) {
		this.id_Cidade = id_Cidade;
	}

	public Pessoa getId_Pessoa_Registro() {
		return id_Pessoa_Registro;
	}

	public void setId_Pessoa_Registro(Pessoa id_Pessoa_Registro) {
		this.id_Pessoa_Registro = id_Pessoa_Registro;
	}

		
}	
