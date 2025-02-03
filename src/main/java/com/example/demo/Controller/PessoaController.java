package com.example.demo.Controller;

import java.util.List;
import java.util.Optional;

import com.example.demo.Service.*;
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
	private PessoaService pessoaService;

	@Autowired
	private SetorService setorService;

	@Autowired
	private ContatoService contatoService;

	@Autowired
	private EnderecoService enderecoService;

	@Autowired
	private DocumentoService documentoService;

	@GetMapping
	public List<Pessoa> listarPessoas() {
		List<Pessoa> pessoa = pessoaService.listaPessoa();
		return pessoa;
	}

	@GetMapping("/{id}")
	public Optional<Pessoa> listarPessoa(@PathVariable(name = "id") Long id) {
		Optional<Pessoa> pessoa = pessoaService.buscarPorId(id);
		return pessoa;
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public void criarPessoa(@RequestBody Pessoa pessoa) {
		documentoService.salvarTodos(pessoa.getDocumento());
		enderecoService.salvarTodos(pessoa.getEndereco());
		contatoService.salvarTodos(pessoa.getContato());
		setorService.salvar(pessoa.getSetor());
		pessoaService.salvar(pessoa);

	}

	@DeleteMapping("/{id}")
	public void removerPessoa(@PathVariable(name = "id") Long id) {
		pessoaService.removerPorId(id);
	}

	@PutMapping("/{id}")
	public void atualizarPessoa(@PathVariable("id") Long id, @RequestBody Pessoa pessoa) {
		Optional<Pessoa> pessoaById = pessoaService.buscarPorId(id);

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

		contatoService.salvarTodos(pessoaExistente.getContato());
		enderecoService.salvarTodos(pessoaExistente.getEndereco());
		setorService.salvar(pessoaExistente.getSetor());
		documentoService.salvarTodos(pessoaExistente.getDocumento());
		pessoaService.salvar(pessoaExistente);
	}

}
