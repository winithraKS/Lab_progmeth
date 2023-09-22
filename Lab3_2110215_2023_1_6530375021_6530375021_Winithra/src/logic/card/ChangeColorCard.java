package logic.card;

import logic.game.CardColor;
import logic.game.CardSymbol;
import logic.game.GameLogic;

import java.util.ArrayList;

//You CAN modify the first line
public class ChangeColorCard extends EffectCard{
    // TODO Implement here
    public ChangeColorCard() {
        super(null, CardSymbol.CHANGE_COLOR);
    }

    @Override
    public String toString() {
        if(getColor()==null) return "CHANGE COLOR";
        return "CHANGE COLOR (" + getColor()+" color selected).";
    }

    @Override
    public boolean canPlay() {
        return true;
    }

    @Override
    public String performEffect() {
        GameLogic instance = GameLogic.getInstance();
        ArrayList<BaseCard> abc = instance.getCurrentPlayerHand();
        setColor((abc.isEmpty() || abc.get(0).getColor() == null) ? CardColor.RED:abc.get(0).getColor());
        return "Set color to "+getColor()+"\n";
    }
}
