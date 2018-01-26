package example.codeclan.com.playyourcardsright;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by davidrawson on 26/01/2018.
 */

public class DeckTest {

    Deck deck;

    @Before
    public void Before(){
        deck = new Deck();
    }

    @Test
    public void has52Cards(){
        assertEquals(52, deck.countCards());
    }

    @Test
    public void has52CardsAfterShuffle(){
        deck.shuffleCards();
        assertEquals(52, deck.countCards());
    }

    @Test
    public void canRemoveCard(){
        deck.removeCard();
        assertEquals(51, deck.countCards());
    }
}
