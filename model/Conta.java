package projeto_conta_bancaria.model;

public abstract class Conta {
    private double saldo;
    private int numeroConta;
    public Conta(double saldo, int numeroConta) {
        this.saldo = saldo;
        this.numeroConta = numeroConta;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }
}
