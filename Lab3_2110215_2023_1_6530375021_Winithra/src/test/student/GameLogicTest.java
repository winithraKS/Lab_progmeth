package test.student;

import logic.card.BaseCard;
import logic.card.ChangeColorCard;
import logic.card.NumberCard;
import logic.card.SkipCard;
import logic.game.CardColor;
import logic.game.CardSymbol;
import logic.game.GameLogic;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class GameLogicTest {

    ArrayList<BaseCard> hand0;
    ArrayList<BaseCard> hand1;

    NumberCard c1;
    SkipCard c2;
    NumberCard c3;
    ChangeColorCard c4;

    @BeforeEach
    void setup() {
        c1 = new NumberCard(CardColor.YELLOW, CardSymbol.NINE);
        c2 = new SkipCard(CardColor.YELLOW);
        c3 = new NumberCard(CardColor.RED, CardSymbol.NINE);
        c4 = new ChangeColorCard();
    }

    @AfterEach
    void tearDown() {
        GameLogic.clearInstance();
    }

    @Test
    void testIsHandPlayableTrue() {
        // TODO Implement here
        GameLogic gameInstance = GameLogic.getInstance(2);
        gameInstance.getPlayerHand(0).add(c3);
        gameInstance.getPlayerHand(0).add(c1);
        gameInstance.getPlayerHand(1).add(c4);
        gameInstance.setTopCard(c2);
        assertTrue(gameInstance.isHandPlayable(0));
        assertTrue(gameInstance.isHandPlayable(1));
    }

    @Test
    void testIsHandPlayableFalse() {
        // TODO Implement here
        GameLogic gameInstance = GameLogic.getInstance(2);
        gameInstance.setTopCard(c3);
        gameInstance.getPlayerHand(0).add(c2);
        assertFalse(gameInstance.isHandPlayable(0));
    }

    @Test
    void testDrawLessThanDeck() {
        // TODO Implement here
        GameLogic gameInstance = GameLogic.getInstance(4);
        for (int i=0; i<16; i++)
            gameInstance.getDeck().add(new NumberCard(CardColor.randomColor(), CardSymbol.randomSymbol()));
        gameInstance.draw(4);
        assertEquals(4,gameInstance.getCurrentPlayerHand().size());
        gameInstance.goToNextPlayer();
        gameInstance.getPlayerHand(1).add(c2);
        gameInstance.draw(8);
        assertEquals(9,gameInstance.getCurrentPlayerHand().size());
    }

    @Test
    void testDrawMoreThanDeck() {
        // TODO Implement here
        GameLogic gameInstance = GameLogic.getInstance(4);
        for (int i=0; i<16; i++)
            gameInstance.getDeck().add(new NumberCard(CardColor.randomColor(), CardSymbol.randomSymbol()));
        gameInstance.draw(21);
        assertEquals(16,gameInstance.getCurrentPlayerHand().size());


    }

}
