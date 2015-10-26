package BlackJack.controller;

import BlackJack.model.Game;
import BlackJack.model.observer.Observer;
import BlackJack.view.IView;

import static BlackJack.view.IView.Options.*;

public class PlayGame implements Observer {

  private Game a_game;
  private IView a_view;


  public PlayGame(Game a_game, IView a_view) {
    this.a_game = a_game;
    this.a_view = a_view;
    this.a_game.AddObserver(this);
  }

  public void Play() {
    IView.Options option;
    a_view.DisplayWelcomeMessage();


    do {
      if (a_game.IsGameOver()) {
        a_view.DisplayGameOver(a_game.IsDealerWinner());
      }

      option = a_view.GetInput();

      switch (option) {
        case STAND:
          a_game.Stand();
          break;
        case PLAY:
          a_game.NewGame();
          break;
        case HIT:
          a_game.Hit();
          break;
      }
    } while (option != QUIT);
  }

  public void Update() {
    a_view.DisplayDealerHand(a_game.GetDealerHand(), a_game.GetDealerScore());
    a_view.DisplayPlayerHand(a_game.GetPlayerHand(), a_game.GetPlayerScore());
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}