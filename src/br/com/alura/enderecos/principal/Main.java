package br.com.alura.enderecos.principal;

import br.com.alura.enderecos.modelos.EnderecoViaCep;
import br.com.alura.enderecos.modelos.Enderecos;
import br.com.alura.enderecos.utils.ConsultarCep;
import br.com.alura.enderecos.utils.GeradorDeArquivos;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws IOException {
        boolean continuar = true;
        ConsultarCep consultarCep = new ConsultarCep();
        Scanner leitor = new Scanner(System.in);
        String cep;
        List<Enderecos> listagem = new ArrayList<>();

        while (continuar) {
            System.out.println("Digite um cep válido para adicionar o novo endereço ou 'sair' para finalizar");
            cep = leitor.nextLine();
            if (cep.toLowerCase().compareTo("sair") == 0) {
                System.out.println("Até a próxima");
                GeradorDeArquivos geradorDeArquivos = new GeradorDeArquivos();
                geradorDeArquivos.salvarJson(listagem);
                break;
            }
            try {
                EnderecoViaCep endApi = consultarCep.buscaEndereco(cep);

                Enderecos endereco = new Enderecos(endApi);

                listagem.add(endereco);

                for (Enderecos item : listagem) {
                    item.fichaDados();
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}