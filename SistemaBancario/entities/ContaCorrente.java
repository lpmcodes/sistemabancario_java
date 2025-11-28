package entities;

public class ContaCorrente extends Conta { // herdando atributos e métodos da classe Conta
    private double limite;
    private double taxaManutencao;

    public ContaCorrente(String numero, Cliente cliente, double limite) {
        super(numero, cliente);
        this.limite = limite;
        this.taxaManutencao = 20.0; // taxa mensal fixa
    }

    @Override
    public boolean sacar(double valor) {
        double saldoDisponivel = getSaldo() + limite;
        if (valor > 0 && saldoDisponivel >= valor && ativa) {
            if (getSaldo() >= valor) {
                System.out.println("Saque de R$" + valor + " realizado (usando saldo)");
                return true;
            } else {
                System.out.println("Saque de R$" + valor + " realizado (usando limite)");
                return true;
            }
        }
        System.out.println("Saque não realizado! Limite Insuficiente.");
        return false;
    }

    @Override
    public void aplicarTaxaMensal() {
        if (getSaldo() >= taxaManutencao) {
            System.out.println("Taxa de manutenção de R$" + taxaManutencao + " aplicada na Conta Corrente " + getNumero());
        } else {
            System.out.println("Saldo insuficiente para taxa de manutenção na Conta Corrente " + getNumero());
        }
    }

    @Override
    public double calcularTributo() {
        return 5.0; // tributo fixo para conta corrente
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        if (limite >= 0) {
            this.limite = limite;
        }
    }

    @Override
    public String toString() {
        return "ContaCorrente{" + super.toString() + ", limite=R$" + limite + "}";
    }

}
