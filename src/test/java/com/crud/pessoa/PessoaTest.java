package com.crud.pessoa;

import com.crud.pessoa.model.Endereco;
import com.crud.pessoa.model.Pessoa;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.*;

public class PessoaTest {

    @Test
    public void testCadastrarPessoa() {
        // given
        String formatoEsperado = "dd/MM/yyyy";
        Endereco endereco = new Endereco("nova petropolis","92990000", "1149", "Eldorado do Sul", false);
        Pessoa pessoa = new Pessoa("Andersen", new Date(1000000000),new ArrayList<Endereco>(Collections.singleton(endereco)), false);

        SimpleDateFormat sdf = new SimpleDateFormat(formatoEsperado);
        String dataNascimentoFormatada = sdf.format(pessoa.getDataNascimento());

        Assertions.assertEquals("Andersen", pessoa.getNome());
        Assertions.assertEquals("12/01/1970", dataNascimentoFormatada);
        Assertions.assertEquals("nova petropolis", endereco.getLogradouro());
        Assertions.assertEquals("92990000", endereco.getCep());
        Assertions.assertEquals("1149", endereco.getNumero());
        Assertions.assertEquals("Eldorado do Sul", endereco.getCidade());
        Assertions.assertEquals(false, endereco.getEnderecoPrincipal());
    }

    @Test
    public void testEditarPessoa() {
        // given
        String formatoEsperado = "dd/MM/yyyy";
        Endereco endereco = new Endereco("nova petropolis","92990000", "1149", "Eldorado do Sul", false);
        Pessoa pessoa = new Pessoa("Andersen", new Date(1000000000),new ArrayList<Endereco>(Collections.singleton(endereco)), false);
        pessoa.setNome("Joao");
        SimpleDateFormat sdf = new SimpleDateFormat(formatoEsperado);
        String dataNascimentoFormatada = sdf.format(pessoa.getDataNascimento());

        Assertions.assertEquals("Joao", pessoa.getNome());
        Assertions.assertEquals("12/01/1970", dataNascimentoFormatada);
        Assertions.assertEquals("nova petropolis", endereco.getLogradouro());
        Assertions.assertEquals("92990000", endereco.getCep());
        Assertions.assertEquals("1149", endereco.getNumero());
        Assertions.assertEquals("Eldorado do Sul", endereco.getCidade());
        Assertions.assertEquals(false, endereco.getEnderecoPrincipal());
    }


}
