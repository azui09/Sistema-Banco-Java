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
        Random random = new Random();

        while (true) {
            System.out.println("===== MENU =====");
            System.out.println("1 - Cadastrar cliente");
            System.out.println("2 - Criar uma conta");
            System.out.println("3 - Depositar dinheiro");
            System.out.println("4 - Sacar dinheiro");
            System.out.println("5 - Transferir dinheiro");
            System.out.println("6 - Consultar seu saldo");
            System.out.println("7 - Sair");
            System.out.print("Opcao: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> criarCliente(scanner, clientes, random);
                case 2 -> criarConta(scanner, clientes, meuBanco, random);
                case 3 -> depositar(scanner, clientes, meuBanco);
                case 7 -> {
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Opcao invalida, tente novamente");
            }
        }

    }

    public static void criarCliente(Scanner scanner, ArrayList<Cliente> listaClientes, Random random) {
        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();

        System.out.print("Digite sua idade: ");
        int idade = scanner.nextInt();

        int numeroCliente = random.nextInt(10000);

        Cliente cliente = new Cliente(nome, idade, numeroCliente);
        listaClientes.add(cliente);
        System.out.println("Cliente " + nome + " criado com sucesso");
    }

    public static void listarClientes(ArrayList<Cliente> listaCliente) {
        for (Cliente cliente : listaCliente) {
            System.out.println("Numero do cliente: " + cliente.getNumeroConta() + " | Nome: " + cliente.getNome());

            if (cliente.getContas().isEmpty()) {
                System.out.println("Nenhuma conta criada ainda");
            } else {
                for (Conta c : cliente.getContas()) {
                    System.out.println("   -> [Conta Ativa] Número da conta: " + c.getNumeroConta());
                }
            }
        }
    }

    public static Cliente buscarCliente(ArrayList<Cliente> listaCliente, int numeroCliente) {
        for (Cliente cliente : listaCliente) {
            if (numeroCliente == cliente.getNumeroConta()) {
                return cliente;
            }
        }
        return null;
    }

    public static void criarConta(Scanner scanner, ArrayList<Cliente> listaCliente, Banco meuBanco, Random random) {
        if (listaCliente.isEmpty()) {
            System.out.println("Erro: nenhum cliente cadastrado no sistema");
            return;
        }
        System.out.println("===== Lista de clientes =====");
        listarClientes(listaCliente);

        System.out.print("Digite o numero do cliente na qual vc deseja criar uma conta: ");
        int numeroCliente = scanner.nextInt();
        scanner.nextLine();
        Cliente clienteEncontrado = buscarCliente(listaCliente, numeroCliente);

        if (clienteEncontrado != null) {
            System.out.println("Vc deseja criar uma\n1 - Conta Corrente\nou uma\n2 - Conta Poupanca");
            System.out.print("Digite a opcao: ");
            int opcaoConta = scanner.nextInt();
            scanner.nextLine();

            switch (opcaoConta) {
                case 1 -> {
                    int numeroContaCorrente = random.nextInt(10000);
                    Conta novaContaCorrente = new ContaCorrente(0.0, numeroContaCorrente);
                    if (clienteEncontrado.adicionarConta(novaContaCorrente)) {
                        meuBanco.criarConta(novaContaCorrente);
                    }
                    ;
                }
                case 2 -> {
                    int numeroContaPoupanca = random.nextInt(10000);
                    Conta novaContaPoupanca = new ContaPoupanca(0.0, numeroContaPoupanca);
                    if (clienteEncontrado.adicionarConta(novaContaPoupanca)) {
                        meuBanco.criarConta(novaContaPoupanca);
                    }
                    ;
                }
                default -> System.out.println("Vc digitou uma opcao invalida");
            }
        } else {
            System.out.println("Vc digitou um numero de cliente que nao existe");
        }
    }

    public static void depositar(Scanner scanner, ArrayList<Cliente> listaCliente, Banco meuBanco) {
        if (listaCliente.isEmpty()) {
            System.out.println("Erro: nenhum cliente cadastrado no sistema");
            return;
        }
        listarClientes(listaCliente);
        System.out.print("Digite o numero da conta da pessoa na qual vc deseja depositar: ");
        int numeroDaConta = scanner.nextInt();

        Conta contaEncontrada = meuBanco.buscarConta(numeroDaConta);
        if (contaEncontrada != null) {
            System.out.print("Digite o valor do deposito: R$");
            double valorDeposito = scanner.nextDouble();

            contaEncontrada.depositar(valorDeposito);
        } else {
            System.out.println("Erro: nenhuma conta encontrada com esse numero");
        }

    }
}
