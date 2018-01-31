package example.codeclan.com.playyourcardsright;

/**
 * Created by davidrawson on 26/01/2018.
 */

public class Card {

    private Suit suit;
    private Rank rank;
    private String imageFile;

    public Card(Suit suit, Rank rank, String imageFile) {

        this.suit = suit;
        this.rank = rank;
        this.imageFile = imageFile;
    }

    public Suit getSuit(){
        return this.suit;
    }

    public Rank getRank(){
        return this.rank;
    }

    public String getImageFile(){
        return this.imageFile;
    }

}