package example.codeclan.com.playyourcardsright;

/**
 * Created by davidrawson on 28/01/2018.
 */

public class Game {

    private Deck deck;
    private int roundNumber;
    private int roundsTotal;

    public Game(int roundsTotal){
        deck = new Deck();
        deck.shuffleCards();
        this.roundNumber = 1;
        this.roundsTotal = roundsTotal;
    }


    public Deck getDeck() {
        return deck;
    }

    public int getRoundNumber() {
        return roundNumber;
    }

    public int getRoundsTotal() {
        return roundsTotal;
    }


}
