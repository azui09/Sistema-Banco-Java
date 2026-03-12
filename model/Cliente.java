package projeto_conta_bancaria.model;

public class Cliente extends Pessoa {
    private int numeroConta;

    public Cliente(String nome, int idade, int numeroConta) {
        super(nome, idade);
        this.numeroConta = numeroConta;
    }

    public int getNumeroConta() {
        return numeroConta;
    }
}
