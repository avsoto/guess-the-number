import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class ComputerPlayerTest {
//test -> checkGuess

    private ComputerPlayer computerPlayer;
    private Random mockRandom;


    @BeforeEach
    void setUp(){
        //Método se ejecuta antes de cada prueba individual
        //El uso de una semilla fija garantiza que los NA sean consistentes
        mockRandom = new Random(42);
        computerPlayer = new ComputerPlayer(mockRandom);
    }

    @Test
    void testMakeGuessWithinRange(){
        int guess = computerPlayer.makeGuess();

        //Verifica que la adivinanza esté entre 1 y 100
        assertTrue(guess >= 1 && guess <= 100, "La adivinanza debe estar entre 1 y 100");
    }

    @Test
    void testMakeGuessAddsToGuessList() {
        int initialSize = computerPlayer.getGuesses().size();

        computerPlayer.makeGuess();

        // Verifica que el tamaño de la lista de adivinanzas haya aumentado en 1
        assertEquals(initialSize + 1, computerPlayer.getGuesses().size(), "La adivinanza debe ser agregada a la lista");
    }


}