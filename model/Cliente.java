package projeto_conta_bancaria.model;

import java.util.ArrayList;

public class Cliente extends Pessoa {
    private int numeroConta;
    private ArrayList<Conta> contas = new ArrayList<>();

    public Cliente(String nome, int idade, int numeroConta) {
        super(nome, idade);
        this.numeroConta = numeroConta;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public ArrayList<Conta> getContas() {
        return contas;
    }

    public boolean adicionarConta(Conta conta) {
        for (Conta contaExistente : contas) {
            if (conta instanceof ContaCorrente && contaExistente instanceof ContaCorrente) {
                System.out.println("Aviso: Você ja possui uma conta corrente ativa.");
                return false;
            } else if (conta instanceof ContaPoupanca && contaExistente instanceof ContaPoupanca) {
                System.out.println("Aviso: Você ja possui uma conta poupanca ativa");
                return false;
            }
        }

        this.contas.add(conta);
        System.out.println("Conta vinculada com sucesso à pasta do cliente " + this.getNome());
        return true;
    }
}
