package com.crud.pessoa.service;

import com.crud.pessoa.event.Event;
import com.crud.pessoa.model.Endereco;
import com.crud.pessoa.model.Pessoa;
import com.crud.pessoa.repository.PessoaRepository;
import com.crud.pessoa.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ApplicationEventPublisher publisher;

    public Pessoa save(Pessoa pessoa, HttpServletResponse response){
        Pessoa pessoaSave = pessoaRepository.save(pessoa);
        List<Endereco> getEndereco = pessoaSave.getEndereco();
        for(Endereco enderecos : getEndereco){
          String endereco = String.valueOf(enderecos);
          enderecos.setPessoa(pessoa);
          pessoaRepository.save(pessoa);
        }
        publisher.publishEvent(new Event(this, response, pessoaSave.getId()));
        return pessoaSave;
    }

    public Pessoa update(Pessoa pessoa, HttpServletResponse response){
        Pessoa pessoaSave = null;
        List<Endereco> getEndereco = pessoa.getEndereco();
        for(Endereco enderecos : getEndereco){
            String endereco = String.valueOf(enderecos);
            enderecos.setPessoa(pessoa);
            pessoaSave = pessoaRepository.save(pessoa);
        }

        return pessoaSave;
    }

    public Pessoa getPessoa(Pessoa pessoa){
        if(pessoa.getId() == null){
            Pessoa findPessoa = pessoaRepository.findByNome(pessoa.getNome());
            if(findPessoa != null){
                pessoa.setId(findPessoa.getId());
            }else{
                return null;
            }
        }
        return pessoa;
    }

    public Pessoa atualizarAtivo(Long id, Boolean ativo){
        Pessoa pessoaSalva = pessoaRepository.findById(id).get();
        if(pessoaSalva == null){
            throw new EmptyResultDataAccessException(1);
        }
        pessoaSalva.setAtivo(ativo);
        pessoaRepository.save(pessoaSalva);
        return pessoaSalva;
    }

}
