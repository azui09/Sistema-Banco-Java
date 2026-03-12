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

    public void depositar(double valor) {
        saldo += valor;
        System.out.println("Valor de R$ " + valor + " depositado com sucesso");
    }

    public void sacar(double valor) {
        if(saldo < valor) {
            System.out.println("Você não possui saldo suficiente para sacar um valor de R$ " + valor);
        } else {
            saldo -= valor;
            System.out.println("O saque no valor de R$ " + valor + " foi realizado com sucesso");
        }
    }
}
