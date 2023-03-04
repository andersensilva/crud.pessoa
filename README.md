Projeto consiste em uma API para cadastro de Pessoa.<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;    Pessoa tem os seguintes dados.<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;        - Nome<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;        - Data de Nascimento<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;        - Endereco<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;            * logradouro<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;            * CEP<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;            * Numero<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;            * Cidade<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;        - Ativo(sim ou não)<br>

Foi desenvolvida uma API para cadastrar, listar, editar uma ou mais pessoas, uma
pessoa pode ter um ou mais endereços e pondendo selecionar qual endereço é o principal


Usamos as seguintes tecnologias no projeto<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;    - Spring Boot 2.4.0<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;   - Java 11<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;    - Spring Security<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;    - Flyway<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;   - Swagger<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;   - Teste Unitário<br>

Segue Endpoints disponíveis<br><br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;    Pessoa:<br>
<table border="1">
    <tr>
        <th> Metodo</th>
        <th> URL</th>
    </tr>
    <tr>
        <td>GET</td>
        <td>/pessoas</td>
    </tr>
    <tr>
        <td>GET</td>
        <td>/pessoas/{id}</td>
    </tr>
    <tr>
        <td>POST</td>
        <td>/pessoas</td>
    </tr>
    <tr>
        <td>PUT</td>
        <td>/ṕessoas</td>
    </tr>
    <tr>
        <td>PUT</td>
        <td>/pessoas/{id}/ativo</td>
    </tr>
</table>
     
    Exemplo Json de Pessoa
    [
        {
            "id": 1,
            "nome": "Andersen",
            "dataNascimento": 604810800000,
            "endereco": [
                {
                    "id": 1,
                    "logradouro": "São Borja",
                    "cep": "92990000",
                    "numero": "1171",
                    "cidade": "Eldorado do Sul",
                    "enderecoPrincipal": true
                }
            ],
            "ativo": true
        }
    ]

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;    Endereco:<br>
<table border="1">
    <tr>
        <th> Metodo</th>
        <th> URL</th>
    </tr>
    <tr>
        <td>GET</td>
        <td>/endereco/{id}</td>
    </tr>
</table>


Segue link para teste da api via Swagger:<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  http://{suaUrl}/swagger-ui.html#