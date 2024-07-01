package Projeto.domain;

import java.time.LocalDate;
// 1 criando a classe pessoa
public class Pessoa {
    private String nome;
    private LocalDate dataNasc;

    public Pessoa(String nome, LocalDate dataNasc) {
        this.nome = nome;
        this.dataNasc = dataNasc;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNasc() {
        return dataNasc;
    }

}
