import java.util.ArrayList;
import java.util.Random;

public class ComputerPlayer extends Player {
    private final Random computerRandom;

    // Constructor: Recibe una instancia de Random para generar las adivinanzas aleatorias.
    // El nombre del jugador es "Computer".
    public ComputerPlayer(Random computerRandom) {
        super("Computer");
        this.computerRandom = computerRandom;
        this.guesses = new ArrayList<>();
    }

    // Método randomNumber: Genera un número aleatorio entre 1 y 100 usando la instancia de Random.
    public static int randomNumber(Random random) {
        return random.nextInt(100) + 1;
    }

    // Método makeGuess: Sobrescribe el método makeGuess de Player.
    // Genera una adivinanza aleatoria, la imprime y la guarda en la lista de adivinanzas.
    @Override
    public int makeGuess() {
        int guess = randomNumber(computerRandom);
        System.out.println("Computer's guess: " + guess);
        guesses.add(guess);
        return guess;
    }
}
