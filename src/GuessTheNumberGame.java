import javax.swing.*;
import java.util.Random;

public class GuessTheNumberGame {
    //Maneja la lógica principal, decide qué jugador asume el próximo turno

    private static final int MAX_NUMBER = 100;
    private final Player player1;
    private final Random random;
    private int targetNumber;

    public GuessTheNumberGame(Player player1, Random random) {
        this.player1 = player1;
        this.random = random;
        this.targetNumber = generateTargetNumber();
    }

    public static void main(String[] args){
        Random random = new Random();
        Player player1 = createHumanPlayer();
        GuessTheNumberGame game = new GuessTheNumberGame(player1, random);

        game.startGame();

    }

    public void startGame(){
        boolean playAgain;

        do{
            this.targetNumber = generateTargetNumber();
            boolean guessedCorrectly = false;


            while(!guessedCorrectly){
                int guess = checkGuess(player1);
                guessedCorrectly = checkIfGuessCorrect(guess);
        }

            playAgain = askToPlayAgain();
        }
        while (playAgain);

        System.out.println("\n*** Thank you for playing! Goodbye! ***");
    }

    public int checkGuess(Player player){
        System.out.println("-- Player: " + player.getName() + " ---");
        int guess = player.makeGuess();
        return guess;

    }

    protected static HumanPlayer createHumanPlayer(){
        System.out.println("*** Welcome to the game Guess The Number! ***");
        System.out.println("What is your name?");
        String name = JOptionPane.showInputDialog(null, "Enter your name");
        System.out.println("Bienvenido/a " + name);
        return new HumanPlayer(name);
    }

    protected int generateTargetNumber(){
        return random.nextInt(MAX_NUMBER) + 1;
    }

    private boolean checkIfGuessCorrect(int guess) {
        if (guess > targetNumber) {
            System.out.println("Too high!");
            return false;
        } else if (guess < targetNumber) {
            System.out.println("Too low!");
            return false;
        } else {
            System.out.println("Correct! You guessed the number: " + targetNumber);
            return true;
        }
    }

    private boolean askToPlayAgain() {
        int response = JOptionPane.showConfirmDialog(null, "Do you want to play again?", "Play Again", JOptionPane.YES_NO_OPTION);
        return response == JOptionPane.YES_OPTION;
    }

}
