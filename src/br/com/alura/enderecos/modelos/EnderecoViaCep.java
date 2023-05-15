package br.com.alura.enderecos.modelos;

public record EnderecoViaCep(String cep,
                             String logradouro,
                             String bairro,
                             String localidade,
                             String uf
) {
}
