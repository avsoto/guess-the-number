import java.util.ArrayList;

public abstract class Player {
    //Atributos (name, guesses)
    //Métodos: makeGuess(), getName(), getGuesses()

    private String name;
    protected ArrayList<Integer> guesses;

    public Player(String name) {
        this.name = name;
    }

    public abstract int makeGuess();

    public String getName() {
        return name;
    }

    public ArrayList<Integer> getGuesses() {
        return guesses;
    }




}
