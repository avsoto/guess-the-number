import java.util.ArrayList;
import java.util.Scanner;

public class HumanPlayer extends Player {
    private ArrayList<Integer> guesses;
    private Scanner scanner;

    public HumanPlayer(String name) {
        super(name);
        this.guesses = new ArrayList<>();
        this.scanner = new Scanner(System.in); // Inicializa el Scanner
    }

    // Métodos makeGuess()
    @Override
    public int makeGuess() {
        System.out.print("Enter your guess: ");

        // Intenta leer la entrada y convertirla a un número
        try {
            int guess = Integer.parseInt(scanner.nextLine()); // Lee el input del jugador desde la consola
            guesses.add(guess); // Almacena la adivinanza en la lista
            return guess;
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
            return makeGuess(); // Pide la adivinanza nuevamente si hay un error
        }
    }
}
