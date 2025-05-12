
import java.util.Scanner;

public class SudokuGame {

    private static final int SIZE = 9;
    private static int[][] board = new int[SIZE][SIZE];
    private static boolean[][] fixed = new boolean[SIZE][SIZE];
    private static boolean started = false;

    void printMenu() {
        System.out.println("\n--- MENU SUDOKU ---");
        System.out.println("1. Iniciar novo jogo");
        System.out.println("2. Inserir novo número");
        System.out.println("3. Remover número");
        System.out.println("4. Exibir jogo");
        System.out.println("5. Exibir status do jogo");
        System.out.println("6. Resetar jogo");
        System.out.println("7. Finalizar jogo");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    void startNewGame() {
        // Exemplo de tabuleiro inicial (pode ser alterado)
        int[][] initial = {
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = initial[i][j];
                fixed[i][j] = initial[i][j] != 0;
            }
        }
        started = true;
        System.out.println("Novo jogo iniciado!");
        printBoard();
    }

    void insertNumber(Scanner sc) {
        if (!started) {
            System.out.println("Inicie um novo jogo primeiro.");
            return;
        }
        System.out.print("Informe a linha (1-9): ");
        int row = sc.nextInt() - 1;
        System.out.print("Informe a coluna (1-9): ");
        int col = sc.nextInt() - 1;
        System.out.print("Informe o número (1-9): ");
        int num = sc.nextInt();
        if (isValidPosition(row, col) && !fixed[row][col]) {
            if (num >= 1 && num <= 9 && isValidMove(row, col, num)) {
                board[row][col] = num;
                System.out.println("Número inserido com sucesso.");
            } else {
                System.out.println("Movimento inválido.");
            }
        } else {
            System.out.println("Posição inválida ou número fixo.");
        }
    }

    void removeNumber(Scanner sc) {
        if (!started) {
            System.out.println("Inicie um novo jogo primeiro.");
            return;
        }
        System.out.print("Informe a linha (1-9): ");
        int row = sc.nextInt() - 1;
        System.out.print("Informe a coluna (1-9): ");
        int col = sc.nextInt() - 1;
        if (isValidPosition(row, col) && !fixed[row][col]) {
            board[row][col] = 0;
            System.out.println("Número removido.");
        } else {
            System.out.println("Posição inválida ou número fixo.");
        }
    }

    void printBoard() {
        if (!started) {
            System.out.println("Inicie um novo jogo primeiro.");
            return;
        }
        System.out.println("\nTabuleiro Sudoku:");
        for (int i = 0; i < SIZE; i++) {
            if (i % 3 == 0 && i != 0) {
                System.out.println("------+-------+------");
            }
            for (int j = 0; j < SIZE; j++) {
                if (j % 3 == 0 && j != 0) {
                    System.out.print("| ");
                }
                System.out.print(board[i][j] == 0 ? ". " : board[i][j] + " ");
            }
            System.out.println();
        }
    }

    void printStatus() {
        if (!started) {
            System.out.println("Status: Não iniciado");
            return;
        }
        if (isComplete()) {
            System.out.println("Status: Completo");
        } else {
            System.out.println("Status: Incompleto");
        }
    }

    void resetGame() {
        if (!started) {
            System.out.println("Inicie um novo jogo primeiro.");
            return;
        }
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (!fixed[i][j]) {
                    board[i][j] = 0;
                }
            }
        }
        System.out.println("Jogo resetado.");
        printBoard();
    }

    void finishGame() {
        if (!started) {
            System.out.println("Inicie um novo jogo primeiro.");
            return;
        }
        if (isComplete()) {
            System.out.println("Parabéns! Você completou o Sudoku!");
            started = false;
        } else {
            System.out.println("O jogo ainda não está completo.");
        }
    }

    boolean isValidPosition(int row, int col) {
        return row >= 0 && row < SIZE && col >= 0 && col < SIZE;
    }

    private boolean isValidMove(int row, int col, int num) {
        // Verifica linha e coluna
        for (int i = 0; i < SIZE; i++) {
            if (board[row][i] == num || board[i][col] == num) {
                return false;
            }
        }
        // Verifica bloco 3x3
        int startRow = row - row % 3, startCol = col - col % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[startRow + i][startCol + j] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isComplete() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == 0 || !isValidMoveForComplete(i, j, board[i][j])) {
                    return false;
                }
            }
        }
        return true;
    }

    // Para checar se o tabuleiro está correto ao final (ignora a própria posição)
    private boolean isValidMoveForComplete(int row, int col, int num) {
        for (int i = 0; i < SIZE; i++) {
            if (i != col && board[row][i] == num) {
                return false;
            }
            if (i != row && board[i][col] == num) {
                return false;
            }
        }
        int startRow = row - row % 3, startCol = col - col % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int r = startRow + i, c = startCol + j;
                if ((r != row || c != col) && board[r][c] == num) {
                    return false;
                }
            }
        }
        return true;
    }
}
