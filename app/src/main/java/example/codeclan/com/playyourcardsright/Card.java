package example.codeclan.com.playyourcardsright;

/**
 * Created by davidrawson on 26/01/2018.
 */

public class Card {

    private Suit suit;
    private Rank rank;

    public Card(Suit suit, Rank rank) {

        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit(){

        return this.suit;
    }

    public Rank getRank(){
        return this.rank;
    }

}