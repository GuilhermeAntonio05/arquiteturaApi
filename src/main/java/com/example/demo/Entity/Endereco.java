package com.example.demo.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_endereco")
public class Endereco {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column
	private String numero;
	
	@Column
	private String rua;
	
	@Column
	private String bairro;
	
	@Column
	private String complemento;
	
	@Column
	private String estado;
	
	@Column
	private String cep;
	
	public Endereco() {
	}

	public Endereco( String numero, String rua, String bairro, String complemento, String estado,
			String cep) {
	//	this.pessoa = pessoa;
		this.numero = numero;
		this.rua = rua;
		this.bairro = bairro;
		this.complemento = complemento;
		this.estado = estado;
		this.cep = cep;
	}

	public Endereco(long id, String numero, String rua, String bairro, String complemento, String estado,
			String cep) {
		this.id = id;
//		this.pessoa = pessoa;
		this.numero = numero;
		this.rua = rua;
		this.bairro = bairro;
		this.complemento = complemento;
		this.estado = estado;
		this.cep = cep;
	}

	public long getId() {
		return id;
	}

//	public Pessoa getPessoa() {
//		return pessoa;
//	}

//	public void setPessoa(Pessoa pessoa) {
///		this.pessoa = pessoa;
///	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
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

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	@Override
	public String toString() {
		return "Endereco [id=" + id +", numero=" + numero + ", rua=" + rua + ", bairro="
				+ bairro + ", complemento=" + complemento + ", estado=" + estado + ", cep=" + cep + "]";
	}
}
