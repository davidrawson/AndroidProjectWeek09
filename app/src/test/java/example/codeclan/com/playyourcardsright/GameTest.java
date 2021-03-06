package example.codeclan.com.playyourcardsright;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by davidrawson on 28/01/2018.
 */

public class GameTest {
    Game game;

    @Before
    public void Before(){
        game = new Game(1);
    }


    @Test
    public void hasDeck(){
        // The Game contructor draws two cards from the deck, so 50 cards left.
        assertEquals(50, game.getDeck().countCards());
    }

    @Test
    public void hasRoundNumber(){
        assertEquals(1, game.getRoundNumber() );
    }


    @Test
    public void hasRoundsTotal(){
        assertEquals(1, game.getRoundsTotal());
    }

}


