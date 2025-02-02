package com.example.demo.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_setor")
public class Setor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@PrimaryKeyJoinColumn
	private Long id;

	@OneToOne
	private Pessoa pessoa;

	@Column
	private String cargaHoraria;

	public Setor() {
	}

	public Setor(String cargaHoraria) {
		super();
		this.cargaHoraria = cargaHoraria;
	}

	public Setor(Long id, Pessoa pessoa, String cargaHoraria) {
		super();
		this.id = id;
		this.pessoa = pessoa;
		this.cargaHoraria = cargaHoraria;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public String getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(String cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Setor [id=" + id + ", pessoa=" + pessoa + ", cargaHoraria=" + cargaHoraria + "]";
	}

}
