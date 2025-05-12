
import java.util.Scanner;

public class calcula {

    public static void main(String[] args) {
        Scanner terminal = new Scanner(System.in);

        System.out.println("Digite o saldo inicial da conta:");
        double saldoInicial = terminal.nextDouble();

        System.out.println("Digite o valor da primeira transação (positivo para depósito, negativo para saque):");
        double transacao1 = terminal.nextDouble();

        System.out.println("Digite o valor da segunda transação (positivo para depósito, negativo para saque):");
        double transacao2 = terminal.nextDouble();

        System.out.println("Digite o valor da terceira transação (positivo para depósito, negativo para saque):");
        double transacao3 = terminal.nextDouble();

        // Calculando o saldo final
        double saldoFinal = saldoInicial + transacao1 + transacao2 + transacao3;

        System.out.printf("O saldo final da conta é: %.2f%n", saldoFinal);

        terminal.close();
    }
}
