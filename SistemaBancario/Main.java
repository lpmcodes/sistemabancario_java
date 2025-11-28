import entities.*;
import services.BancoService;

public class Main {
    public static void main(String[] args) {
        System.out.println("🏦 SISTEMA BANCÁRIO - DEMONSTRAÇÃO POO\n");
        
        // Criando serviço do banco
        BancoService banco = new BancoService();
        
        // Criando clientes
        System.out.println("=== CRIANDO CLIENTES ===");
        Cliente cliente1 = new Cliente("123.456.789-00", "João Silva", "joao@email.com");
        Cliente cliente2 = new Cliente("987.654.321-00", "Maria Santos", "maria@email.com");
        Cliente cliente3 = new Cliente("111.222.333-44", "Pedro Oliveira", "pedro@email.com");
        
        System.out.println(cliente1);
        System.out.println(cliente2);
        System.out.println(cliente3);
        
        // Criando contas (HERANÇA)
        System.out.println("\n=== CRIANDO CONTAS ===");
        ContaCorrente cc1 = new ContaCorrente("CC-001", cliente1, 1000.0);
        ContaPoupanca cp1 = new ContaPoupanca("CP-001", cliente2, 0.005); // 0.5%
        ContaCorrente cc2 = new ContaCorrente("CC-002", cliente3, 500.0);
        ContaPoupanca cp2 = new ContaPoupanca("CP-002", cliente1, 0.003); // 0.3%
        
        // Adicionando contas ao banco
        banco.adicionarConta(cc1);
        banco.adicionarConta(cp1);
        banco.adicionarConta(cc2);
        banco.adicionarConta(cp2);
        
        // Criando funcionários
        System.out.println("\n=== CONTRATANDO FUNCIONÁRIOS ===");
        Funcionario gerente = new Funcionario("FUNC-001", "Carlos Andrade", 5000.0, "Gerente");
        Funcionario atendente = new Funcionario("FUNC-002", "Ana Costa", 2500.0, "Atendente");
        
        banco.adicionarFuncionario(gerente);
        banco.adicionarFuncionario(atendente);
        
        // Operações bancárias
        System.out.println("\n=== OPERAÇÕES BANCÁRIAS ===");
        cc1.depositar(1000.0);
        cp1.depositar(2000.0);
        cc2.depositar(500.0);
        
        cc1.sacar(200.0);
        cc1.transferir(cp1, 300.0);
        
        System.out.println("\n=== DEMONSTRANDO POLIMORFISMO ===");
        
        // 1. Taxas mensais - cada conta se comporta diferente
        banco.aplicarTaxasMensais();
        
        // 2. Tributos - cada objeto calcula seu próprio tributo
        banco.calcularTributosGeral();
        
        // Listando tudo
        banco.listarContas();
        banco.listarFuncionarios();
        
        System.out.println("\n=== DEMONSTRANDO ENCAPSULAMENTO ===");
        
        // Tentativa de acesso direto (não permitido - comentado)
        // System.out.println(cc1.saldo); // ❌ ERRO: saldo é privado!
        // cc1.saldo = 1000000;         // ❌ ERRO: não podemos modificar diretamente!
        
        // Acesso controlado via métodos (✅ PERMITIDO)
        System.out.println("Saldo da CC-001: R$" + cc1.getSaldo());
        System.out.println("Cliente da CP-001: " + cp1.getCliente().getNome());
        
        System.out.println("\n=== DEMONSTRANDO HERANÇA ===");
        System.out.println("Todas as contas herdam de: " + cc1.getClass().getSuperclass().getSimpleName());
        System.out.println("CC1 é uma Conta? " + (cc1 instanceof Conta));
        System.out.println("CP1 é uma Conta? " + (cp1 instanceof Conta));
        
        System.out.println("\n SISTEMA BANCÁRIO FINALIZADO COM SUCESSO!");
    }
}