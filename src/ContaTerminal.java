import java.util.InputMismatchException;
import java.util.Scanner;

public class ContaTerminal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome do Cliente");
        String nomeCliente = scanner.nextLine();

        System.out.println("Digite o Agência:");
        String agencia = scanner.nextLine();

        System.out.println("Digite o Numero da Conta:");
        Integer numero = scanner.nextInt();

        System.out.println("\nSeja bem vindo! " + nomeCliente + " Agencia " + agencia + " Numero Conta:" + numero);

        System.out.println("\nPara continuar, pressione Enter...");
        scanner.nextLine();

        Conta conta = new Conta(nomeCliente, agencia, numero);

        boolean executando = true;
        while (executando) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Depositar");
            System.out.println("2. Sacar");
            System.out.println("3. Verificar Saldo");
            System.out.println("4. Sair");

            try {
                int opcao = scanner.nextInt();
                scanner.nextLine(); // Limpar o buffer do scanner

                if (opcao == 1) {
                    System.out.println("Digite o valor a depositar:");
                    double valorDeposito = scanner.nextDouble();
                    scanner.nextLine(); // Limpar o buffer do scanner
                    conta.depositar(valorDeposito);
                } else if (opcao == 2) {
                    System.out.println("Digite o valor a sacar:");
                    double valorSaque = scanner.nextDouble();
                    scanner.nextLine(); // Limpar o buffer do scanner
                    conta.sacar(valorSaque);
                } else if (opcao == 3) {
                    System.out.println("Saldo atual: " + conta.getSaldo());
                } else if (opcao == 4) {
                    System.out.println("Volte Sempre : " + nomeCliente);
                    executando = false;
                } else {
                    System.out.println("Opção inválida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
                scanner.nextLine(); // Limpar o buffer do scanner
            }
        }

        scanner.close();
    }
}
