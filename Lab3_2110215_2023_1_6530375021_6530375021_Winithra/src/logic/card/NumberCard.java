package logic.card;

import logic.game.CardSymbol;
import logic.game.CardColor;
import logic.game.GameLogic;

//You CAN modify the first line
public class NumberCard extends BaseCard{
    // TODO Implement here
    public NumberCard(CardColor color, CardSymbol symbol) {
        super(color, symbol);
    }

    @Override
    public String toString() {
        return getColor().toString()+" "+getSymbol().toString();
    }

    @Override
    public boolean canPlay() {
        CardColor topCardColor = GameLogic.getInstance().getTopCard().getColor();
        CardSymbol topCardSymbol = GameLogic.getInstance().getTopCard().getSymbol();
        return getColor()==topCardColor || getSymbol() ==topCardSymbol;
    }

    @Override
    public String play() {
        GameLogic instance = GameLogic.getInstance();
        instance.setTopCard(this);
        instance.getCurrentPlayerHand().remove(this);
        return null;
    }



}
