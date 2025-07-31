package br.com.exemplo.produtor.model;

import java.time.LocalDate;

public class Pessoa {

    private String nome;
    private Integer idade;
    private LocalDate dataNascimento;

    public Pessoa(String nome, Integer idade, LocalDate dataNascimento) {
        this.nome = nome;
        this.idade = idade;
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String toString() {
        return "Pessoa [nome=" + nome + ", idade=" + idade + ", dataNascimento=" + dataNascimento + "]";
    }
}
