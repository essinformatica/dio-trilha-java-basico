
import java.util.Scanner;

public class IniciaJogo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SudokuGame game = new SudokuGame();
        int option;
        do {
            game.printMenu();
            option = sc.nextInt();
            switch (option) {
                case 1:
                    game.startNewGame();
                    break;
                case 2:
                    game.insertNumber(sc);
                    break;
                case 3:
                    game.removeNumber(sc);
                    break;
                case 4:
                    game.printBoard();
                    break;
                case 5:
                    game.printStatus();
                    break;
                case 6:
                    game.resetGame();
                    break;
                case 7:
                    game.finishGame();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (option != 0);
        sc.close();
    }
}
