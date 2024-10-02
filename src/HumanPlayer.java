import javax.swing.*;
import java.util.ArrayList;

public class HumanPlayer extends Player {
    private ArrayList<Integer> guesses;

    public HumanPlayer(String name) {
        super(name);
        this.guesses = new ArrayList<>();
    }

    //Métodos makeGuess()
    @Override
    public int makeGuess() {
        String input = JOptionPane.showInputDialog(null, "Enter your guess:");

        // Verifica si el input es nulo (cuadro de diálogo cerrado)
        if (input == null) {
            System.out.println("Input was canceled. Exiting the game.");
            System.exit(0); // Salir del juego si el usuario cancela
        }

        // Intenta convertir la entrada a un número
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
            return makeGuess(); // Pide la adivinanza nuevamente si hay un error
        }
    }



}
