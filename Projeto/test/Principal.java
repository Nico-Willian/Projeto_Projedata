package Projeto.test;

import Projeto.domain.Funcionario;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.text.NumberFormat;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.*;
//3 Classe principal
public class Principal {
    public static void main(String[] args) {

//3.1 Criando e adicionando os funcionarios em uma lista
        List<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador"));
        funcionarios.add(new Funcionario("João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), "Operador"));
        funcionarios.add(new Funcionario("Caio", LocalDate.of(1961, 5, 2), new BigDecimal("9836.14"), "Coordenador"));
        funcionarios.add(new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor"));
        funcionarios.add(new Funcionario("Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"), "Recepcionista"));
        funcionarios.add(new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador"));
        funcionarios.add(new Funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), "Contador"));
        funcionarios.add(new Funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), "Gerente"));
        funcionarios.add(new Funcionario("Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), "Eletricista"));
        funcionarios.add(new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), "Gerente"));
        System.out.println("Tabela criada com sucesso.");
        System.out.println("----------------------------------------------------------------------");


//3.2 Removendo João da tabela
        boolean removejoao = funcionarios.removeIf(funcionario -> funcionario.getNome().equals("João"));
        if (removejoao){
            System.out.println("Funcionário removido com sucesso.");
        }else{
            System.out.println("Falha ao remover o funcionário.");
        }

        System.out.println("----------------------------------------------------------------------");

//3.3 Mostrar os funcionarios
        funcionarios.forEach(funcionario -> {
            String dataNascFormat = funcionario.getDataNasc().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            Locale localePT = new Locale("pt", "BR");
            NumberFormat formartarnumero = NumberFormat.getInstance(localePT);
            String salFormat = formartarnumero.format(funcionario.getSalario());
            System.out.println("Nome = "+ funcionario.getNome() + " | Data Nascimento = " + dataNascFormat + " | Salário = " + salFormat + " | Função = "+ funcionario.getFuncao());
        });

//3.4 Atualizando os salários dos funcionários de 10%
        funcionarios.forEach(funcionario -> {
            BigDecimal aumentoPorcentagem = funcionario.getSalario().multiply(new BigDecimal("0.1"));
            BigDecimal novoSal = funcionario.getSalario().add(aumentoPorcentagem);
            funcionario.setSalario(novoSal);
            System.out.println("Nome: "+ funcionario.getNome());
            System.out.println("Salário: "+ funcionario.getSalario());
        });

//3.5 Não sei utilizar o map
//3.6 Não conseguir
//3.7 Não conseguir

        System.out.println("----------------------------------------------------------------------");

//3.8 Aniversariantes de Outubro e Dezembro
        List<Funcionario> aniversariantesOutubroDezembro = new ArrayList<>();

        for (Funcionario funcionario : funcionarios){
            Month mesNas = funcionario.getDataNasc().getMonth();

            if (mesNas == Month.OCTOBER || mesNas == Month.DECEMBER){
                aniversariantesOutubroDezembro.add(funcionario);
            }
        }

        System.out.println("Aniversariantes em Outubro e Dezembro: ");
        Locale localePT = new Locale("pt", "BR");
        NumberFormat formartarnumero = NumberFormat.getInstance(localePT);
        aniversariantesOutubroDezembro.forEach(funcionario -> {
            String dataNascFormat = funcionario.getDataNasc().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            String salFormat = formartarnumero.format(funcionario.getSalario());
            System.out.println("Nome = "+ funcionario.getNome() + " | Data Nascimento = " + dataNascFormat + " | Salário = " + salFormat + " | Função = "+ funcionario.getFuncao());
        });

        System.out.println("----------------------------------------------------------------------");

//3.9 Funcionário com maior idade
        Funcionario funcionarioMaisVelho = null;

        for (Funcionario funcionario : funcionarios) {
            if (funcionarioMaisVelho == null || funcionario.getDataNasc().isBefore(funcionarioMaisVelho.getDataNasc())) {
                funcionarioMaisVelho = funcionario;
            }
        }
        if (funcionarioMaisVelho != null) {
            int idade = LocalDate.now().getYear() - funcionarioMaisVelho.getDataNasc().getYear();
            System.out.println("Funcionário com Maior Idade:");
            System.out.println("Nome: " + funcionarioMaisVelho.getNome());
            System.out.println("Idade: " + idade);
        } else {
            System.out.println("Não há funcionários cadastrados.");
        }

        System.out.println("----------------------------------------------------------------------");

//3.10 Ordenar os funcionarios em ordem Alfabética
        Collections.sort(funcionarios, (f1, f2) -> f1.getNome().compareTo(f2.getNome()));
        System.out.println("Funcionário em ordem Alfabética:");
        funcionarios.forEach(funcionario -> {
            System.out.println(funcionario.getNome());
        });

        System.out.println("----------------------------------------------------------------------");

// 3.11 Total dos salarios

        BigDecimal totalSal = BigDecimal.ZERO;
        for (Funcionario funcionario : funcionarios) {
            totalSal = totalSal.add(funcionario.getSalario());
        }
        System.out.println("Saldo total:"+formartarnumero.format(totalSal));

        System.out.println("----------------------------------------------------------------------");

//3.12 Salários minimos para cada funcionário
        BigDecimal salarioMinimo = new BigDecimal("1212.00");

        funcionarios.forEach(funcionario -> {
            BigDecimal salarioEmSalariosMinimos = funcionario.getSalario().divide(salarioMinimo, 2, RoundingMode.HALF_UP);
            System.out.println(funcionario.getNome() + ": " + formartarnumero.format(salarioEmSalariosMinimos) + " salários mínimos.");
        });
    }

}