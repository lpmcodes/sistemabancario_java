package entities;

public class ContaPoupanca extends Conta {
    private double taxaRendimento;

    public ContaPoupanca(String numero, Cliente cliente, double taxaRendimento) {
        super(numero, cliente);
        this.taxaRendimento = taxaRendimento;
    }

    @Override
    public void aplicarTaxaMensal() {
        double rendimento = getSaldo() * taxaRendimento;   
        System.out.println("Rendimento de R$" + rendimento + " aplicado na Conta Poupança " + getNumero());
    }

    @Override
    public double calcularTributo() {
        return 0.0; // em poupança não há tributo
    }

    public double getTaxaRendimento() {
        return taxaRendimento;
    }

    public void setTaxaRendimento(double taxaRendimento) {
        if (taxaRendimento >= 0) {
            this.taxaRendimento = taxaRendimento;
        }
    }
    
    @Override
    public String toString() {
        return "Conta Poupança{" + super.toString() + ", taxaRendimento" + (taxaRendimento * 100) + "%";
    }
}
