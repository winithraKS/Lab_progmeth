package logic.card;

import logic.game.CardColor;
import logic.game.CardSymbol;
import logic.game.GameLogic;

//You CAN modify the first line
public class SkipCard extends EffectCard{
    // TODO Implement here

    public SkipCard(CardColor color) {
        super(color, CardSymbol.SKIP);
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

    public String performEffect(){
        GameLogic instance = GameLogic.getInstance();
        instance.goToNextPlayer();
        while(instance.getCurrentPlayerHand().isEmpty()) instance.goToNextPlayer();
        return "Skipped player "+instance.getCurrentPlayer();
    }


}
