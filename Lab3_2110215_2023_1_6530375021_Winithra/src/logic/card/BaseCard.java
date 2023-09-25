package logic.card;

import logic.game.CardSymbol;
import logic.game.CardColor;

//You CAN modify the first line
public abstract class BaseCard {
    // TODO Implement here
    private CardColor color;
    private CardSymbol symbol;

    //constructor
    public BaseCard(CardColor color,CardSymbol symbol){setSymbol(symbol); setColor(color);}

    //getter & setter
    public CardColor getColor() {return color;}
    public void setColor(CardColor color) {this.color = color;}

    public CardSymbol getSymbol() {return symbol;}
    public void setSymbol(CardSymbol symbol) {this.symbol = symbol;}

    @Override
    public abstract String toString();

    public abstract boolean canPlay();

    public abstract String play();
}
