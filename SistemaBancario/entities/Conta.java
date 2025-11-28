package entities;

import interfaces.Tributavel;

public abstract class Conta implements Tributavel {
    private String numero;
    private double saldo;
    private Cliente cliente;
    protected boolean ativa;

    protected Conta(String numero, Cliente cliente) {
        this.numero = numero;
        this.cliente = cliente;
        this.saldo = 0.0;
        this.ativa = true;
    }

    public String getNumero() {
        return numero;
    }
    
    public double getSaldo() {
        return saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }
    
    public boolean isAtiva() {
        return ativa;
    }

    public void depositar(double valor) {
        if (valor > 0 && ativa) {
            saldo += valor;
            System.out.println("Depósito de R$ " + valor + " realizado na conta " + numero);
        } else {
            System.out.println("Depósito não realizado!");
        }
    }

    public boolean sacar(double valor) {
        if (valor > 0 && saldo >= valor && ativa) {
            saldo -= valor;
            System.out.println("Saque de R$" + valor + " realizado na conta" + numero);
            return true;
        }
        System.out.println("Saque não realizado! Saldo insuficiente ou conta inativa.");
        return false;
    }
    
    public void transferir(Conta destino, double valor) {
        if (this.sacar(valor)) {
            destino.depositar(valor);
            System.out.println("Transferência de R$" + valor + " para conta " + destino.getNumero());
        }
    }
    
    public abstract void aplicarTaxaMensal();
    
    @Override
    public String toString() {
        return "Conta{numero='" + numero + "', saldo=R$" + saldo + ", cliente=" + cliente.getNome() + ", ativa=" + ativa + "}";
    }
}
