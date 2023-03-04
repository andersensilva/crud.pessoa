package com.crud.pessoa.repository;

import com.crud.pessoa.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

    List<Endereco> findByPessoaId (Long Id);
}
