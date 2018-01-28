package example.codeclan.com.playyourcardsright;

import android.util.Log;

/**
 * Created by davidrawson on 28/01/2018.
 */

public class Game {

    private Deck deck;
    private int roundNumber;
    private int roundsTotal;
    private Card firstCard;
    private Card nextCard;
    private boolean roundWin;

    public Game(int roundsTotal){
        deck = new Deck();
        deck.shuffleCards();
        this.roundNumber = 1;
        this.roundsTotal = roundsTotal;
        this.firstCard = deck.removeCard();
        this.nextCard = deck.removeCard();

    }


    public Deck getDeck() {
        return deck;
    }

    public Card getFirstCard(){
        return this.firstCard;
    }

    public Card getNextCard(){
        return nextCard;
    }

    public int getRoundNumber() {
        return roundNumber;
    }

    public int getRoundsTotal() {
        return roundsTotal;
    }


    public boolean checkForRoundWin(Object tag) {
        if (tag == "higher"){
            if (this.nextCard.getRank().getValue() > this.firstCard.getRank().getValue()){
                roundWin = true;
            }else{
                roundWin = false;
            }
        }
        if (tag == "lower"){
            if (this.nextCard.getRank().getValue() < this.firstCard.getRank().getValue()){
                roundWin = true;
            }else{
                roundWin = false;
            }
        }
        Log.d(getClass().toString(), "Correct guess? " +roundWin);
        return this.roundWin;
    }

    public void changeFirstCard() {
        this.firstCard = deck.removeCard();
    }

    public void moveCards(){
        this.firstCard = this.nextCard;
        this.nextCard = deck.removeCard();
    }
}
