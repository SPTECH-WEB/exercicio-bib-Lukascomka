package com.school.sptech;


public class Biblioteca {
    //atributos
    private String nome;
    private Double multaDiaria;
    private Integer qtdLivros;
    private Boolean ativa;
    //construtor
    public Biblioteca(String nome, Double multaDiaria) {
        this.nome = nome;
        this.multaDiaria = multaDiaria;
        this.qtdLivros = 0;
        this.ativa = true;
    }

    //get e set

    //set nome
    public void setNome(String nome) {
        this.nome = nome;
    }
    //metodo get
    public Double getMultaDiaria() {
        return multaDiaria;
    }
    //metodo get
    public Integer getQtdLivros() {
        return qtdLivros;
    }
    //mmetodo get
    public Boolean getAtiva() {
        return ativa;
    }
    //metodo get
    public String getNome() {
        return nome;
    }
    //metodo registrar livro
    public void registrarLivro(Integer quantidade) {
        if (quantidade > 0 && quantidade != null && getAtiva() == true) {
            this.qtdLivros += quantidade;
        }
    }
    // metodo de empresar
    public Integer emprestar(Integer quantidade) {
        if (getAtiva() == true && quantidade > 0 && quantidade <= getQtdLivros() && quantidade != null) {
            this.qtdLivros -=quantidade;
            return quantidade;

        } else {

            return null;

        }
    }
    // metodo devolver
    public Integer devolver(Integer quantidade) {
        if (getAtiva() == true && quantidade > 0 && quantidade != null) {
            this.qtdLivros+=quantidade;
            return quantidade;
        } else {
            return null;
        }
    }
    //metodo desativar
    public Integer desativar() {
        if (getAtiva() == false) {
            return null;
        } else {
            Integer qtdAnterior =this.qtdLivros;
            this.ativa = false;
            this.qtdLivros = 0;
            return qtdAnterior;
        }

    }
    //metodo transferir
    public void transferir(Biblioteca destino, Integer quantidade) {
        if (getAtiva() == true && destino.getAtiva() == true && quantidade > 0 && quantidade != null && quantidade <= getQtdLivros()) {

            this.qtdLivros -= quantidade;
            destino.qtdLivros += quantidade;

        }
    }
    // metodo reajustarMulta
    public Boolean reajustarMulta(Double percentual) {

        Double multaAtual = getMultaDiaria();

        if (percentual <=0.0 || percentual == null) {
            return false;
        } else {
            this.multaDiaria = multaAtual * (1 + percentual / 100);
            return true;
        }

    }


}
