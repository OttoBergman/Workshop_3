package BlackJack.view;

import java.io.IOException;
import java.util.Scanner;

public class SimpleView implements IView
{

  public void DisplayWelcomeMessage()
        {
          for(int i = 0; i < 50; i++) {System.out.print("\n");}
          System.out.println("Hello Black Jack World");
          System.out.println("Type 'p' to Play, 'h' to Hit, 's' to Stand or 'q' to Quit\n");
        }

        public Options GetInput()
        {
            Scanner sc = new Scanner(System.in);
            while (true) {
                try {
                    String input = sc.next();

                    switch (input) {
                        case "h":
                            return Options.HIT;
                        case "q":
                            return Options.QUIT;
                        case "p":
                            return Options.PLAY;
                        case "s":
                            return Options.STAND;

                        default:
                            throw new IllegalArgumentException("Not a valid choice");
                    }
                } catch (IllegalArgumentException e) {

                    System.out.println(e.getMessage() + "Please try again");
                }
            }
        }

        public void DisplayCard(BlackJack.model.Card a_card)
        {
            System.out.println("" + a_card.GetValue() + " of " + a_card.GetColor());
        }

        public void DisplayPlayerHand(Iterable<BlackJack.model.Card> a_hand, int a_score)
        {
            DisplayHand("Player", a_hand, a_score);
        }

        public void DisplayDealerHand(Iterable<BlackJack.model.Card> a_hand, int a_score)
        {
            DisplayHand("Dealer", a_hand, a_score);
        }

        private void DisplayHand(String a_name, Iterable<BlackJack.model.Card> a_hand, int a_score)
        {
            System.out.println(a_name + " Has: ");
            for(BlackJack.model.Card c : a_hand)
            {
                DisplayCard(c);
            }
            System.out.println("Score: " + a_score);
            System.out.println("");
        }

        public void DisplayGameOver(boolean a_dealerIsWinner)
        {
            System.out.println("GameOver: ");
            if (a_dealerIsWinner)
            {
                System.out.println("Dealer Won!");
            }
            else
            {
                System.out.println("You Won!");
            }
            
        }
}