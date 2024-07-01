package Projeto.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
// 2 criando a classe funcionario
public class Funcionario extends Pessoa{
    private BigDecimal salario;
    private String funcao;

    public Funcionario(String nome, LocalDate datanasc, BigDecimal salario, String funcao) {
        super(nome, datanasc);
        this.salario = salario;
        this.funcao = funcao;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }
}
