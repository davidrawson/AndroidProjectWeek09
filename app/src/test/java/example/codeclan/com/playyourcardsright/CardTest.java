package example.codeclan.com.playyourcardsright;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by davidrawson on 26/01/2018.
 */
public class CardTest {

    Card card;

    @Before
    public void Before(){
        card = new Card(Suit.DIAMONDS, Rank.JACK);
    }

    @Test
    public void canGetSuit(){
        assertEquals(Suit.DIAMONDS, card.getSuit());
    }

    @Test
    public void canGetRank(){
        assertEquals(Rank.JACK, card.getRank());
    }
}

