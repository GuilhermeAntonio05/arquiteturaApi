package com.example.demo.Controller;

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

import com.example.demo.Entity.Pessoa;
import com.example.demo.Repository.ContatoRepository;
import com.example.demo.Repository.DocumentoRepository;
import com.example.demo.Repository.EnderecoRepository;
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
	private ContatoRepository contatoRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private DocumentoRepository documentoRepository;

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
			@RequestBody Pessoa pessoa
			) {
		documentoRepository.saveAll(pessoa.getDocumento());
		enderecoRepository.saveAll(pessoa.getEndereco());
		contatoRepository.saveAll(pessoa.getContato());
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

	private void getPessoa(Pessoa pessoaExistente, Pessoa novaPessoa) {
		pessoaExistente.setDataNascimento(novaPessoa.getDataNascimento());
		pessoaExistente.setInscricaoFederal(novaPessoa.getInscricaoFederal());
		pessoaExistente.setNome(novaPessoa.getNome());
		pessoaExistente.setSalario(novaPessoa.getSalario());
		pessoaExistente.setSetor(novaPessoa.getSetor());
		pessoaExistente.setContato(novaPessoa.getContato());
		pessoaExistente.setEndereco(novaPessoa.getEndereco());
		pessoaExistente.setDocumento(novaPessoa.getDocumento());
		
		contatoRepository.saveAll(pessoaExistente.getContato());
		enderecoRepository.saveAll(pessoaExistente.getEndereco());
		setorRepository.save(pessoaExistente.getSetor());
		documentoRepository.saveAll(pessoaExistente.getDocumento());
		pessoaRepository.save(pessoaExistente);
	}

}
