package example.codeclan.com.playyourcardsright;

import java.util.ArrayList;
import java.util.Collections;

import example.codeclan.com.playyourcardsright.Card;

/**
 * Created by davidrawson on 26/01/2018.
 */

public class Deck {

    private ArrayList<Card> cards;

    public Deck(){

        cards = new ArrayList<>();

        for (Rank rank: Rank.values()){
            for (Suit suit: Suit.values()){
                String imageFile = suit.getSuitInitial() + rank.getStringValue(); // I feel this should be toString()
                Card card = new Card(suit, rank, imageFile);
                cards.add(card);
            }
        }
        this.shuffleCards();
    }

    public int countCards() {
        return cards.size();
    }

    public void shuffleCards(){
        Collections.shuffle(cards);
    }

    public Card removeCard(){
        return this.cards.remove(0);
    }

}
