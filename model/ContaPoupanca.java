package projeto_conta_bancaria.model;

public class ContaPoupanca extends Conta{
    private double taxaPoupanca;
    public ContaPoupanca(double saldo, int numeroConta, double taxaPoupanca) {
        super(saldo, numeroConta);
        this.taxaPoupanca = taxaPoupanca;
    }

    public double getTaxaPoupanca() {
        return taxaPoupanca;
    }
}
