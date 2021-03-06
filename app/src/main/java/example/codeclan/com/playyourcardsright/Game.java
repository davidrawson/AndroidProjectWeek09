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
    private String result;
    private int score;

    public Game(int roundsTotal){
        deck = new Deck();
        deck.shuffleCards();
        this.score = 0;
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

    public int getScore(){
        return score;
    }

    public int getRoundNumber() {
        return roundNumber;
    }

    public int getRoundsTotal() {
        return roundsTotal;
    }

    public String getResult(){
        return this.result;
    }

    public String checkForRoundWin(Object tag) {

        boolean cardIsHigher = this.nextCard.getRank().getValue() > this.firstCard.getRank().getValue();
        boolean cardIsEqual = this.nextCard.getRank().getValue() == this.firstCard.getRank().getValue();
        boolean cardIsLower = this.nextCard.getRank().getValue() < this.firstCard.getRank().getValue();

        if (tag == "higher"){

            if (cardIsHigher){
                result = "win";
                this.score ++;
            }else{
                if (cardIsEqual){
                    result = "draw";
                }else{
                    result = "lose";
                }
            }
        }
        if (tag == "lower") {
            if (cardIsLower) {
                result = "win";
                this.score ++;
            } else {
                if (cardIsEqual) {
                    result = "draw";
                } else {
                    result = "lose";
                }
            }
        }
        return this.result;
    }

    public boolean checkGameOver() {
        if (this.roundNumber == this.roundsTotal) {
            return true;
        } else {
            return false;
        }
    }

    public void changeFirstCard() {
        this.firstCard = deck.removeCard();
    }

    public void moveCards(){
        this.firstCard = this.nextCard;
        this.nextCard = deck.removeCard();
        this.roundNumber ++;
    }

}
