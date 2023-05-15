package br.com.alura.enderecos.utils;

import br.com.alura.enderecos.modelos.Enderecos;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GeradorDeArquivos {

    public void salvarJson(List<Enderecos> listagem) throws IOException {
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();
        FileWriter escritor = new FileWriter("enderecos.json");
        escritor.write(gson.toJson(listagem));

        escritor.close();
    }

}
