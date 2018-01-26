package example.codeclan.com.playyourcardsright;

/**
 * Created by davidrawson on 26/01/2018.
 */

public enum Suit {
    SPADES("s"),
    HEARTS("h"),
    CLUBS("c"),
    DIAMONDS("d");


    private final String suitInitial;

    Suit(String suitInitial){
        this.suitInitial = suitInitial;
    }

    public String getSuitInitial() {
        return this.suitInitial;
    }

}
