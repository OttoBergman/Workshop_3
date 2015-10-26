package BlackJack.model.rules;

import BlackJack.model.Dealer;
import BlackJack.model.Player;

/**
 * Created by otto on 2015-10-25.
 */
public class PlayerWinsIfEqualScoreRule implements IPlayerWinsIfEqualScoreStrategy {

    protected final int maxScore = 21;
    @Override
    public boolean IsDealerWinner(Dealer a_dealer, Player a_player) {
        if (a_player.CalcScore() > maxScore) {
            return true;
        } else if (a_dealer.CalcScore() > maxScore) {
            return false;
        }
        return a_dealer.CalcScore() > a_player.CalcScore();
    }
}
