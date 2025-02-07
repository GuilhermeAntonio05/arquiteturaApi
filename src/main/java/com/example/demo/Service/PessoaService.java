package com.example.demo.Service;

import com.example.demo.Entity.Pessoa;
import com.example.demo.Repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public void salvar(Pessoa pessoa){
        pessoaRepository.save(pessoa);
    }

    public List<Pessoa> listaPessoa(){
        return pessoaRepository.findAll();
    }

    public Optional<Pessoa> buscarPorId(Long id){
        return pessoaRepository.findById(id);
    }

    public void removerPorId(Long id){
        pessoaRepository.deleteById(id);
    }

}
