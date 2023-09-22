package logic.card;

import logic.game.CardColor;
import logic.game.CardSymbol;
import logic.game.GameLogic;

import java.util.ArrayList;

//You CAN modify the first line
public class DrawTwoCard extends EffectCard{
    // TODO Implement here
    public DrawTwoCard(CardColor color) {
        super(color, CardSymbol.DRAW_TWO);
    }

    @Override
    public String toString() {
        String s = getColor().toString() + " " + getSymbol().toString();
        return s;
    }

    @Override
    public boolean canPlay() {
        CardColor topCardColor = GameLogic.getInstance().getTopCard().getColor();
        CardSymbol topCardSymbol = GameLogic.getInstance().getTopCard().getSymbol();
        return getColor()==topCardColor || getSymbol() ==topCardSymbol;
    }

    @Override
    public String performEffect() {
        String s = ""; boolean stack = false;
        GameLogic instance = GameLogic.getInstance();
        instance.incrementDrawAmount(2);
        instance.goToNextPlayer();
        while(instance.getCurrentPlayerHand().isEmpty()) instance.goToNextPlayer();
        int n = instance.getCurrentPlayer();
        ArrayList<BaseCard> abc = instance.getCurrentPlayerHand();
        for(BaseCard bc:abc){
            if(bc.getSymbol()==CardSymbol.DRAW_TWO || bc.getSymbol()==CardSymbol.DRAW_FOUR){
                s = "Player "+n+" played "+ bc+". "+(abc.size()-1)+" cards remaining.\n";
                s += bc.play() ; stack = true ;
            }
        }
        if(!stack) {
            instance.draw(instance.getDrawAmount());
            s = "Player " + n + " drew " + instance.getDrawAmount() + " card. " + instance.getCurrentPlayerHand().size() + " cards remaining.\n";
            instance.setDrawAmount(0);
        }
        return s;
    }
}
