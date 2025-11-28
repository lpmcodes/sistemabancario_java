package entities;

import interfaces.Tributavel;

public class Funcionario implements Tributavel {
    private String matricula;
    private String nome;
    private double salario;
    private String cargo;

    public Funcionario(String matricula, String nome, double salario, String cargo) {
        this.matricula = matricula;
        this.nome = nome;
        this.salario = salario;
        this.cargo = cargo;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        if (salario >= 0) {
            this.salario = salario;
        }
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    } 

    @Override
    public double calcularTributo() {
        return salario * 0.11;
    }

    public double calcularSalarioLiquido() {
        return salario - calcularTributo();
    }
    
    @Override
    public String toString() {
        return "Funcionario{matricula='" + matricula + "', nome='" + nome + "', salario=R$" + salario + ", cargo='" + cargo + "'}";
    }
}
