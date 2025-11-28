package services;

import entities.*;
import interfaces.Tributavel;
import java.util.ArrayList;
import java.util.List;

public class BancoService {
    private List<Conta> contas;
    private List<Funcionario> funcionarios;
    
    public BancoService() {
        this.contas = new ArrayList<>();
        this.funcionarios = new ArrayList<>();
    }
    
    public void adicionarConta(Conta conta) {
        contas.add(conta);
        System.out.println("✅ Conta " + conta.getNumero() + " adicionada ao banco.");
    }
    
    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
        System.out.println("✅ Funcionário " + funcionario.getNome() + " contratado.");
    }
    
    public Conta buscarConta(String numero) {
        for (Conta conta : contas) {
            if (conta.getNumero().equals(numero)) {
                return conta;
            }
        }
        return null;
    }
    
    public void aplicarTaxasMensais() {
        System.out.println("\n💸 Aplicando taxas mensais em todas as contas...");
        for (Conta conta : contas) {
            conta.aplicarTaxaMensal();  // Cada conta aplica sua própria taxa
        }
    }
    
    public void calcularTributosGeral() {
        System.out.println("\n💰 Calculando tributos...");
        
        List<Tributavel> tributaveis = new ArrayList<>();
        
        // Adiciona todas as contas (que implementam Tributavel)
        tributaveis.addAll(contas);
        
        // Adiciona todos os funcionários (que implementam Tributavel)
        tributaveis.addAll(funcionarios);
        
        double totalTributos = 0;
        for (Tributavel tributavel : tributaveis) {
            double tributo = tributavel.calcularTributo();
            totalTributos += tributo;
            
            if (tributavel instanceof Conta) {
                Conta conta = (Conta) tributavel;
                System.out.println("📊 Conta " + conta.getNumero() + ": R$" + tributo);
            } else if (tributavel instanceof Funcionario) {
                Funcionario func = (Funcionario) tributavel;
                System.out.println("👨‍💼 Funcionário " + func.getNome() + ": R$" + tributo);
            }
        }
        
        System.out.println("💵 TOTAL DE TRIBUTOS: R$" + totalTributos);
    }
    
    public void listarContas() {
        System.out.println("\n📋 CONTAS DO BANCO:");
        for (Conta conta : contas) {
            System.out.println("  " + conta);
        }
    }
    
    public void listarFuncionarios() {
        System.out.println("\n👥 FUNCIONÁRIOS DO BANCO:");
        for (Funcionario func : funcionarios) {
            System.out.println("  " + func + " | Salário Líquido: R$" + func.calcularSalarioLiquido());
        }
    }
}
