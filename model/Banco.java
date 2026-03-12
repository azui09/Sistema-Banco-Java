package projeto_conta_bancaria.model;

import java.util.ArrayList;

public class Banco {
    private String nomeBanco;
    private ArrayList<Conta> banco;

    public Banco(String nomeBanco) {
        this.banco = new ArrayList<>();
        this.nomeBanco = nomeBanco;
    }

    public void criarConta(Conta conta) {
        banco.add(conta);
        System.out.println("Uma nova conta foi adicionada no banco");
    }

    public void removerConta(Conta conta) {
        banco.remove(conta);
        System.out.println("Conta removida com sucesso");
    }

    public Conta buscarConta(int numeroConta) {
        for (Conta conta : banco) {
            if (conta.getNumeroConta() == numeroConta) {
                return conta;
            }
        }
        return null;
    }

    public void transferir(int numeroOrigem, int numeroDestino, double valor) {
        Conta contaOrigem = this.buscarConta(numeroOrigem);
        Conta contaDestino = this.buscarConta(numeroDestino);

        if (contaOrigem != null && contaDestino != null) {
            if (contaOrigem.getSaldo() >= valor) {
                contaOrigem.sacar(valor);
                contaDestino.depositar(valor);
                System.out.println("Transferência de R$ " + valor + " realizada com sucesso!");
            } else {
                System.out.println("Erro: A conta de origem não possui saldo suficiente para a transferência.");
            }
        } else {
            System.out.println("Erro: Conta de origem ou destino não encontrada no banco.");
        }
    }
}
