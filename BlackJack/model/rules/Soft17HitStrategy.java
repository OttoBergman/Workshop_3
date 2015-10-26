package BlackJack.model.rules;

import BlackJack.model.Card;
import BlackJack.model.Player;

class Soft17HitStrategy implements IHitStrategy {
    private final int g_hitLimit = 17;
    private boolean hasAce = false;
    private int handValue = 0;

    public boolean DoHit(Player a_dealer) {

        int cardScores[] = {
                2, 3, 4, 5, 6, 7, 8, 9, 10, 10 ,10 ,10, 11
        };
        assert (cardScores.length == Card.Value.Count.ordinal()) : "Card Scores array size does not match number of card values";

        for (Card c : a_dealer.GetHand()) {
            if (c.GetValue() == Card.Value.Ace) {
                hasAce = true;
            }
            else {
                if (c.GetValue() != Card.Value.Hidden) {
                    handValue += cardScores[c.GetValue().ordinal()];
                }
            }
        }
        return a_dealer.CalcScore() == 17 && hasAce && handValue == 6 || a_dealer.CalcScore() < g_hitLimit;

    }
}