package projeto_conta_bancaria.model;

public class ContaCorrente extends Conta{
    private double taxaCorrente;
    public ContaCorrente(double saldo, int numeroConta, double taxaCorrente) {
        super(saldo, numeroConta);
        this.taxaCorrente = taxaCorrente;
    }

    public double getTaxaCorrente() {
        return taxaCorrente;
    }
}
