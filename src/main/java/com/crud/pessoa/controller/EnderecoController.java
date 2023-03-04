package com.crud.pessoa.controller;

import com.crud.pessoa.model.Endereco;
import com.crud.pessoa.model.Pessoa;
import com.crud.pessoa.repository.EnderecoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/endereco")
@Api(value = "Endereco")
public class EnderecoController {

    @Autowired
    EnderecoRepository enderecoRepository;

    @ApiOperation(value = "Mostra lista de endereco pelo codigo de cadastro da pessoa")
    @GetMapping("/{id}")
    public List<Endereco> listarEnderecoPorPessoaId(@PathVariable Long id){
        return enderecoRepository.findByPessoaId(id);
    }
}
