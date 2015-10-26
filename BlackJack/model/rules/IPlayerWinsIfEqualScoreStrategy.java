package BlackJack.model.rules;

import BlackJack.model.Dealer;
import BlackJack.model.Player;

/**
 * Created by otto on 2015-10-25.
 */
public interface IPlayerWinsIfEqualScoreStrategy {
    boolean IsDealerWinner(Dealer a_dealer, Player a_player);
}
