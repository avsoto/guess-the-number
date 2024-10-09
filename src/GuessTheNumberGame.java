import java.util.Random;
import java.util.Scanner;

public class GuessTheNumberGame {
    // Maneja la lógica principal, decide qué jugador asume el próximo turno

    private static final int MAX_NUMBER = 100;
    private final Player player1;
    private final Player player2;
    private final Random random;
    private int targetNumber;
    private final Scanner scanner;

    public GuessTheNumberGame(Player player1, Player player2, Random random) {
        this.player1 = player1;
        this.player2 = player2;
        this.random = random;
        this.targetNumber = generateTargetNumber();
        this.scanner = new Scanner(System.in); // Inicializa el Scanner
    }

    public static void main(String[] args) {
        Random random = new Random();
        Player player1 = createHumanPlayer();
        Player player2 = new ComputerPlayer(random);
        GuessTheNumberGame game = new GuessTheNumberGame(player1, player2, random);

        game.startGame();
    }

    public void startGame() {
        boolean playAgain;

        do {
            this.targetNumber = generateTargetNumber();
            boolean guessedCorrectly = false;

            // Empieza el jugador humano
            Player currentPlayer = player1;

            while (!guessedCorrectly) {
                int guess = checkGuess(currentPlayer);
                guessedCorrectly = checkIfGuessCorrect(guess);

                // Alterna entre los jugadores después de cada turno
                currentPlayer = (currentPlayer == player1) ? player2 : player1;
            }

            playAgain = askToPlayAgain();
        } while (playAgain);

        System.out.println("\n*** Thank you for playing! Goodbye! ***");
        scanner.close(); // Cierra el Scanner al finalizar el juego
    }

    public int checkGuess(Player player) {
        System.out.println("-- Player: " + player.getName() + " ---");
        int guess = player.makeGuess();
        return guess;
    }

    protected static HumanPlayer createHumanPlayer() {
        System.out.println("*** Welcome to the Ultimate Guessing Showdown! ***");
        System.out.println("Get ready to flex those brain muscles! In this game, you and your opponent will take turns guessing a secret number between 1 and 100.");
        System.out.println("Each time you guess, I'll give you a hint: 'Too high!', 'Too low!', or if you're spot on, 'Bingo!'.");
        System.out.println("Will you outsmart the computer and prove your guessing prowess? Let's find out! Good luck, and may the best guesser win!");
        System.out.print("Step right up! What’s your name, brave guesser? ");
        Scanner scanner = new Scanner(System.in); // Crear un nuevo Scanner para la entrada
        String name = scanner.nextLine(); // Leer el nombre del jugador
        System.out.println("Welcome to the game, " + name + "! Ready to put your guessing skills to the test? Let's go!");
        return new HumanPlayer(name);
    }

    protected int generateTargetNumber() {
        return random.nextInt(MAX_NUMBER) + 1;
    }

    private boolean checkIfGuessCorrect(int guess) {
        if (guess > targetNumber) {
            System.out.println("Ugh, you're too far away!");
            return false;
        } else if (guess < targetNumber) {
            System.out.println("Oops! You're digging too deep!");
            return false;
        } else {
            System.out.println("Correct! The player has proven to be a guessing master!: " + targetNumber);
            return true;
        }
    }

    private boolean askToPlayAgain() {
        System.out.print("Are you ready to test your luck again? (yes/no):");
        String response = scanner.nextLine().trim().toLowerCase();
        return response.equals("yes");
    }
}

