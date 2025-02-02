package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Contato;
import com.example.demo.Entity.Pessoa;
import com.example.demo.Entity.Setor;
import com.example.demo.Repository.ContatoRepository;
import com.example.demo.Repository.PessoaRepository;
import com.example.demo.Repository.SetorRepository;

@RestController
@RequestMapping("/api")
public class PessoaController {

	@Autowired
	private PessoaRepository pessoaRepository;

	@Autowired
	private SetorRepository setorRepository;
	
	@Autowired
	private  ContatoRepository contatoRepository;

	@GetMapping
	public List<Pessoa> listarPessoas() {
		List<Pessoa> pessoa = pessoaRepository.findAll();
		return pessoa;
	}

	@GetMapping("/{id}")
	public Optional<Pessoa> listarPessoa(@PathVariable(name = "id") Long id) {
		Optional<Pessoa> pessoa = pessoaRepository.findById(id);
		return pessoa;
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public void criarPessoa(
			//@RequestBody Pessoa pessoa
			) {
		Setor setor = new Setor("Gerente","8");
		List<Contato> contatos = new ArrayList<Contato>();
		contatos.add(new Contato("Email","guilhermeantonio@gmail.com"));
		contatos.add(new Contato("Telefone","47 997660815"));
		Pessoa pessoa = new Pessoa("Guilherme",setor,2000,"05/04/2007","123456","123","123","inscFederal",contatos);
		contatoRepository.saveAll(contatos);
		setorRepository.save(pessoa.getSetor());
		pessoaRepository.save(pessoa);
	}

	@DeleteMapping("/{id}")
	public void removerPessoa(@PathVariable(name = "id") Long id) {
		pessoaRepository.deleteById(id);
	}

	@PutMapping("/{id}")
	public void atualizarPessoa(@PathVariable("id") Long id, @RequestBody Pessoa pessoa) {
		Optional<Pessoa> pessoaById = pessoaRepository.findById(id);

		if (pessoaById.isPresent()) {
			Pessoa pessoaExistente = pessoaById.get();
			getPessoa(pessoaExistente, pessoa);
		} else {
			Pessoa novaPessoa = new Pessoa();
			getPessoa(novaPessoa, pessoa);
		}
	}

	private void getPessoa(Pessoa PessoaExistente, Pessoa NovaPessoa) {
		PessoaExistente.setCnh(NovaPessoa.getCnh());
		PessoaExistente.setCpf(NovaPessoa.getCpf());
		PessoaExistente.setDataNascimento(NovaPessoa.getDataNascimento());
		PessoaExistente.setInscricaoFederal(NovaPessoa.getInscricaoFederal());
		PessoaExistente.setNome(NovaPessoa.getNome());
		PessoaExistente.setOab(NovaPessoa.getOab());
		PessoaExistente.setSalario(NovaPessoa.getSalario());
		PessoaExistente.setSetor(NovaPessoa.getSetor());
		setorRepository.save(PessoaExistente.getSetor());
		pessoaRepository.save(PessoaExistente);
	}

}
