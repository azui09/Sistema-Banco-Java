package projeto_conta_bancaria.model;
import java.util.ArrayList;

public class Banco {
    private String nomeBanco;
    private ArrayList<Conta> banco;

    public Banco(String nomeBanco) {
        this.nomeBanco = nomeBanco;
        this.banco = new ArrayList<>();
    }

    public String getNomeBanco() {
        return nomeBanco;
    }

    public void criarConta(Conta conta) {
        banco.add(conta);
        System.out.println("Uma nova conta foi adicionada no banco " + nomeBanco);
    }

    public void removerConta(Conta conta) {
        banco.remove(conta);
        System.out.println("Conta removida com sucesso");
    }

    public Conta buscarConta(int numeroConta) {
        for(Conta conta : banco) {
            if(conta.getNumeroConta() == numeroConta) {
                return conta;
            }
        }
        return null;
    }
}
