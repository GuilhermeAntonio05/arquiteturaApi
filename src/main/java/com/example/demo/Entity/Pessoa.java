package com.example.demo.Entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_pessoa")

public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@PrimaryKeyJoinColumn
	private long id;
	
	@Column
	private String nome;

	@OneToOne
	private Setor setor;
	
	@OneToMany
	@JoinColumn(name = "PESSOA_ID ")
	private List<Contato> contato;
	
	@OneToMany
	@JoinColumn(name = "PESSOA_ID ")
	private List<Endereco> endereco;
	
	@Column
	private double salario;
	
	@Column
	private String dataNascimento;
	
	@Column
	private String cpf;
	
	@Column
	private String cnh;
	
	@Column
	private String oab;
	
	@Column
	private String inscricaoFederal;
	
	public Pessoa() {
	}
	
	public Pessoa(String nome, Setor setor, double salario, String dataNascimento, String cpf, String cnh, String oab,
			String inscricaoFederal, List<Contato> contato, List<Endereco> endereco) {
		super();
		this.endereco = endereco;
		this.contato = contato;
		this.nome = nome;
		this.setor = setor;
		this.salario = salario;
		this.dataNascimento = dataNascimento;
		this.cpf = cpf;
		this.cnh = cnh;
		this.oab = oab;
		this.inscricaoFederal = inscricaoFederal;
	}

	public Pessoa(long id, String nome, Setor setor, double salario, String dataNascimento, String cpf, String cnh,
			String oab, String inscricaoFederal, List<Contato> contato, List<Endereco> endereco) {
		super();
		this.endereco = endereco;
		this.contato = contato;
		this.id = id;
		this.nome = nome;
		this.setor = setor;
		this.salario = salario;
		this.dataNascimento = dataNascimento;
		this.cpf = cpf;
		this.cnh = cnh;
		this.oab = oab;
		this.inscricaoFederal = inscricaoFederal;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCnh() {
		return cnh;
	}

	public void setCnh(String cnh) {
		this.cnh = cnh;
	}

	public String getOab() {
		return oab;
	}

	public void setOab(String oab) {
		this.oab = oab;
	}

	public String getInscricaoFederal() {
		return inscricaoFederal;
	}

	public void setInscricaoFederal(String inscricaoFederal) {
		this.inscricaoFederal = inscricaoFederal;
	}

	public long getId() {
		return id;
	}

	public List<Contato> getContato() {
		return contato;
	}
	
	public void setContato(List<Contato> contato) {
		this.contato = contato;
	}
	
	public void setEndereco(List<Endereco> endereco) {
		this.endereco = endereco;
	}
	
	public List<Endereco> getEndereco() {
		return endereco;
	}

	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + nome + ", setor=" + setor + ", contato=" + contato + ", endereco="
				+ endereco + ", salario=" + salario + ", dataNascimento=" + dataNascimento + ", cpf=" + cpf + ", cnh="
				+ cnh + ", oab=" + oab + ", inscricaoFederal=" + inscricaoFederal + "]";
	}
	
}
