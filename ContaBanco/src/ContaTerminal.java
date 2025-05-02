
import java.util.Scanner;

public class ContaTerminal {

    public static void main(String[] args) throws Exception {
        // Criação de variáveis

        Scanner scanner = new Scanner(System.in);
        // Exibição dos dados do cliente
        System.out.println("Digite o Nome do cliente: ");
        String nomeCliente = scanner.nextLine();
        System.out.println("Digite a Agência: ");
        int agencia = scanner.nextInt();
        System.out.println("Digite Número da conta: ");
        int numero = scanner.nextInt();
        System.out.println("Digite o Saldo: R$ ");
        double saldo = scanner.nextDouble();

        System.out.println("Olá ".concat(nomeCliente).concat(", obrigado por criar uma conta em nosso banco, sua agência é ") + agencia + ", conta " + numero + " e seu saldo R$ " + saldo + " já está disponível para saque.");
        scanner.close();
    }

}
