package com.crud.pessoa.controller;

import com.crud.pessoa.event.Event;
import com.crud.pessoa.model.Pessoa;
import com.crud.pessoa.repository.PessoaRepository;
import com.crud.pessoa.service.PessoaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pessoas")
@Api(value = "Pessoas")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private ApplicationEventPublisher publisher;

    @ApiOperation(value = "Lista todas as pessoas")
    @GetMapping
    public List<Pessoa> listarPessoas() {
        return pessoaRepository.findAll();
    }

    @ApiOperation(value = "Lista pessoa pelo seu codigo de cadastro")
    @GetMapping("/{id}")
    public Pessoa listarPessoaId(@PathVariable Long id){
        return pessoaRepository.findById(id).get();
    }

    @ApiOperation(value = "Cadastra pessoas")
    @PostMapping
    public ResponseEntity<Pessoa> cadastrarPessoa(
            @Valid @RequestBody Pessoa pessoa,
            HttpServletResponse response
    ){
        Pessoa pessoaSave = pessoaService.save(pessoa, response);

        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaSave);
    }

    @ApiOperation(value = "Atualiza se essa pessoa está ativa ou não pelo seu código")
    @PutMapping("/{id}/ativo")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarAtivo(@PathVariable Long id, @RequestBody Boolean ativo) {
        pessoaService.atualizarAtivo(id, ativo);
    }

    @ApiOperation(value = "Atualiza pessoas")
    @PutMapping
    public ResponseEntity<Pessoa> editarPessoa(
            @Valid @RequestBody Pessoa pessoa,
            HttpServletResponse response
    ){
        Pessoa pessoaUpdate = pessoaService.getPessoa(pessoa);
        if(pessoaUpdate != null) {
            Pessoa pessoaSave = pessoaService.update(pessoaUpdate, response);
            publisher.publishEvent(new Event(this, response, pessoaSave.getId()));
            return ResponseEntity.status(HttpStatus.CREATED).body(pessoaSave);
        }else {
            return new ResponseEntity(new Erro("Pessoa não encontrada"), HttpStatus.NOT_FOUND);
        }
    }

    class Erro{
        public String message;

        public Erro(String message) {
            this.message = message;
        }
    }
}
