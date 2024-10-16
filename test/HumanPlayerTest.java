import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;
import static org.mockito.Mockito.*;



class HumanPlayerTest {
    private HumanPlayer humanPlayer;
    private Scanner mockScanner;


    @BeforeEach
    void setUp() {
        // Inicializa el objeto HumanPlayer antes de cada prueba
        mockScanner = mock(Scanner.class); // Crea un mock de Scanner
        humanPlayer = new HumanPlayer("Ana", mockScanner);
    }

    @Test
    void testMakeGuess_ValidInput() {
        // Simula una entrada de usuario con el número 50
        String simulatedInput = "50\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        // Crea un nuevo Scanner con la entrada simulada
        humanPlayer = new HumanPlayer("Ana", new Scanner(System.in));

        // Ejecuta makeGuess() y verifica que el valor retornado es el esperado
        int guess = humanPlayer.makeGuess();
        assertEquals(50, guess, "The guessed number should be 50.");
    }

    @Test
    void testMakeGuess_OutOfRangeInput() {
        // Simula entradas de usuario: primero fuera de rango (200), luego válida (60)
        String simulatedInput = "200\n60\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        // Crea un nuevo Scanner con la entrada simulada
        humanPlayer = new HumanPlayer("Ana", new Scanner(System.in));

        // Ejecuta makeGuess() y verifica que el valor retornado es el válido
        int guess = humanPlayer.makeGuess();
        assertEquals(60, guess, "The guessed number should be 60.");
    }

    @Test
    void testCheckGuess() {
        // Verifica si checkGuess() devuelve false para números fuera de rango
        assertFalse(humanPlayer.checkGuess(0), "The guess should be out of range.");
        assertFalse(humanPlayer.checkGuess(101), "The guess should be out of range.");

        // Verifica que checkGuess() devuelva true para un número dentro del rango
        assertTrue(humanPlayer.checkGuess(50), "The guess should be valid and within range.");
    }

    @Test
    void testGetGuesses() {
        // Simulamos varias entradas válidas: 25 y 75
        when(mockScanner.nextLine()).thenReturn("25", "75");

        // Ejecuta makeGuess() dos veces
        humanPlayer.makeGuess();
        humanPlayer.makeGuess();

        // Verifica que las adivinanzas están en la lista de guesses
        assertEquals(2, humanPlayer.getGuesses().size(), "There should be 2 guesses stored.");
        assertEquals(25, humanPlayer.getGuesses().get(0), "The first guess should be 25.");
        assertEquals(75, humanPlayer.getGuesses().get(1), "The second guess should be 75.");
    }
}