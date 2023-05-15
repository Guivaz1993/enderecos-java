package br.com.alura.enderecos.modelos;

public class Enderecos {
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private int numero;

    public Enderecos(EnderecoViaCep endApi){
        if(endApi.cep().length()>7 && endApi.cep().length()<10) {
            this.cep = endApi.cep();
            this.logradouro = endApi.logradouro();
            this.cidade = endApi.localidade();
            this.bairro = endApi.bairro();
            this.estado = endApi.uf();
        } else {
            System.out.println("Não foi possível encontrar esse endereço");
        }
    }

    public String getCep() {
        return cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void fichaDados(){
        System.out.println(String.format( """
                Endereço: %s , %d
                Bairro: %s 
                Cidade: %s (%s)                
                """,this.logradouro,this.numero,this.bairro, this.cidade, this.estado)
        );
    }
}
