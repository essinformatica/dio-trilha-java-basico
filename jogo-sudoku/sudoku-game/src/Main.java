// Para ler e escrever dados em Java, aqui na DIO padronizamos da seguinte forma: 
// - new Scanner(System.in): cria um leitor de Entradas, com métodos úteis com prefixo "next";
// - System.out.println:.imprime um texto de Saída (Output) e pulando uma linha.

import java.util.Scanner;

abstract class Conta {

    protected double saldo;

    public Conta(double saldo) {
        this.saldo = saldo;
    }

    public abstract void sacar(double valor);

    public void exibirSaldo() {
        System.out.printf("Saldo Atual: %.2f%n", saldo);
    }
}

class ContaCorrente extends Conta {

    private double limite;

    public ContaCorrente(double saldo, double limite) {
        super(saldo);
        this.limite = limite;
    }

    @Override
    public void sacar(double valor) {
        if (saldo - valor >= -limite) {
            saldo -= valor;
            System.out.printf("Saque realizado: %.2f%n", valor);
        } else {
            System.out.printf("Saque invalido: Excede limite%n");
        }
        exibirSaldo(); // Exibe o saldo atualizado
    }
}

class ContaPoupanca extends Conta {

    public ContaPoupanca(double saldo) {
        super(saldo);
    }

    // Implementação do método sacar para Conta Poupança
    @Override
    public void sacar(double valor) {
        // Dica: Se saldo >= valor, o saque é permitido.
        if (saldo >= valor) {
            saldo -= valor;
            exibirSaldo();
        } else {
            System.out.println("Saque invalido: Saldo insuficiente");
            exibirSaldo(); // Exibe o saldo atualizado
        }
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String tipoConta = scanner.next();
        scanner.nextLine();
        scanner.nextLine();
        scanner.next();
        double saldoInicial = scanner.nextDouble();

        Conta conta = null;

        if (tipoConta.equals("Corrente")) {
            double limiteChequeEspecial = scanner.nextDouble();
            conta = new ContaCorrente(saldoInicial, limiteChequeEspecial); // Exemplo de limite de cheque especial
        } else if (tipoConta.equals("Poupanca")) {
            conta = new ContaPoupanca(saldoInicial);
        }

        while (scanner.hasNextDouble()) {
            double valorSaque = scanner.nextDouble();
            conta.sacar(valorSaque);
        }

        scanner.close();
    }
}
