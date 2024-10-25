import java.util.ArrayList;
import java.util.Scanner;

public class HumanPlayer extends Player {
    private ArrayList<Integer> guesses;
    private Scanner scanner;

    public HumanPlayer(String name, Scanner scanner) {
        super(name);
        this.guesses = new ArrayList<>();
        this.scanner = scanner; // Inicializa el Scanner
    }

    // Métodos makeGuess()
    @Override
    public int makeGuess() {
        System.out.print("Enter your guess: ");

        // Intenta leer la entrada y convertirla a un número
        try {
            int guess = Integer.parseInt(scanner.nextLine()); // Lee el input del jugador desde la consola
            if (checkGuess(guess)){
                guesses.add(guess); // Almacena la adivinanza en la lista
                return guess;
            } else {
                System.out.println("You are out of range. Please enter a number between 1 and 100.");
                return makeGuess(); // Llama a la función de nuevo si el número está fuera de rango
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
            return makeGuess(); // Pide la adivinanza nuevamente si hay un error
        }
    }

    public boolean checkGuess(int guess) {
        return guess >= 1 && guess <= 100;
    }

    public ArrayList<Integer> getGuesses() {
        return guesses;
    }
}
