package logic.card;

import logic.game.CardColor;
import logic.game.CardSymbol;
import logic.game.GameLogic;

import java.util.ArrayList;

//You CAN modify the first line
public class DrawFourCard extends EffectCard{
    // TODO Implement here
    public DrawFourCard() {
        super(null, CardSymbol.DRAW_FOUR);
    }
    @Override
    public String toString() {
        if(getColor()==null) return "DRAW FOUR";
        return "DRAW FOUR ("+getColor()+" color selected)";
    }

    @Override
    public boolean canPlay() {return true;}

    @Override
    public String performEffect() {
        boolean stack = false;
        GameLogic instance = GameLogic.getInstance();
        ArrayList<BaseCard> abc = instance.getCurrentPlayerHand();
        setColor((abc.isEmpty() || abc.get(0).getColor() == null) ? CardColor.RED : abc.get(0).getColor());
        String s = "Set color to "+getColor()+"\n";
        instance.incrementDrawAmount(4); instance.goToNextPlayer();
        while(instance.getCurrentPlayerHand().isEmpty()) instance.goToNextPlayer();
        int n = instance.getCurrentPlayer();
        abc = instance.getCurrentPlayerHand();
        for(BaseCard bc:abc){
            if(bc.getSymbol()==CardSymbol.DRAW_FOUR){
                s += "Player "+n+" played "+ bc+". "+(abc.size()-1)+" cards remaining.\n";
                s += bc.play() ; stack = true ; break;
            }
        }
        if(!stack) {
            instance.draw(instance.getDrawAmount());
            s += "Player " + n + " drew " + instance.getDrawAmount() + " cards. " + instance.getCurrentPlayerHand().size() + " cards remaining.";
            instance.setDrawAmount(0);
        }
        return s;
    }

}
