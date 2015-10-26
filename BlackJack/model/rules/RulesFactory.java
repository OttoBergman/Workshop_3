package BlackJack.model.rules;

import BlackJack.model.Dealer;

public class RulesFactory {

  public IHitStrategy GetHitRule() {
    return new Soft17HitStrategy();
  }

  public INewGameStrategy GetNewGameRule() {
    return new AmericanNewGameStrategy();
  }

  public IPlayerWinsIfEqualScoreStrategy GetWinnerRule() {
    return new PlayerWinsIfEqualScoreRule();
  }
}