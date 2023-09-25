package logic.card;

import logic.game.CardColor;
import logic.game.CardSymbol;
import logic.game.GameLogic;

//You CAN modify the first line
public abstract class EffectCard extends BaseCard{
    // TODO Implement here
    public EffectCard(CardColor color, CardSymbol symbol) {
        super(color, symbol);
    }
    @Override
    public abstract String toString();

    @Override
    public abstract boolean canPlay();

    public String play() {
        GameLogic instance = GameLogic.getInstance();
        instance.setTopCard(this);
        instance.getCurrentPlayerHand().remove(this);
        return performEffect();
    }

    public abstract String performEffect();
}
