package projeto_conta_bancaria.main;

import projeto_conta_bancaria.model.*;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Banco meuBanco = new Banco("Banco Java");
        ArrayList<Cliente> clientes = new ArrayList<>();

        while (true) {
            System.out.println("===== MENU =====");
            System.out.println("1 - Cadastrar cliente");
            System.out.println("2 - Criar uma conta");
            System.out.println("3 - Depositar dinheiro");
            System.out.println("4 - Sacar dinheiro");
            System.out.println("5 - Transferir dinheiro");
            System.out.println("6 - Consultar seu saldo");
            System.out.println("7 - Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> criarCliente(scanner, clientes);
                case 7 -> {
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Opcao invalida, tente novamente");
            }
        }

    }

    public static void criarCliente(Scanner scanner, ArrayList<Cliente> listaClientes) {
        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();

        System.out.print("Digite sua idade: ");
        int idade = scanner.nextInt();

        Random random = new Random();
        int numeroConta = random.nextInt(10000);

        Cliente cliente = new Cliente(nome, idade, numeroConta);
        listaClientes.add(cliente);
        System.out.println("Cliente " + nome + " criado com sucesso");
    }

    public static void listarClientes(ArrayList<Cliente> listaCliente) {
        for (Cliente cliente : listaCliente) {
            System.out.println("Numero de conta: " + cliente.getNumeroConta() + " | Nome: " + cliente.getNome());
        }
    }

    public static void criarConta(Scanner scanner, ArrayList<Cliente> listaCliente, Banco meuBanco) {
        if (listaCliente.isEmpty()) {
            System.out.println("Erro: nenhum cliente cadastrado no sistema");
        }


    }
}
