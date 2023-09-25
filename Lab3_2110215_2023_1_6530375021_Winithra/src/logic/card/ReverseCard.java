package logic.card;

import logic.game.CardColor;
import logic.game.CardSymbol;
import logic.game.GameLogic;
import logic.game.PlayDirection;

//You CAN modify the first line
public class ReverseCard extends EffectCard{
    // TODO Implement here

    public ReverseCard(CardColor color) {super(color, CardSymbol.REVERSE);}

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
        PlayDirection pd = GameLogic.getInstance().getPlayDirection();
        GameLogic.getInstance().setPlayDirection(pd.getOpposite());
        return "Set direction to "+GameLogic.getInstance().getPlayDirection().toString();
    }



}
