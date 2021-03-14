/*
Date:
    3/1/2021
Coder name:
    Dylan Masulis
Project name:
    Card Game
*/
import java.util.*;

public class War {
    public War (){
        Scanner input = new Scanner(System.in);
        String cont = "d";
        
        System.out.println("When you see (e) at the end of the text, press enter to continue. (e)");
        cont = input.nextLine();

        System.out.println("The game is starting...\nPlease welcome Player 1 and Player 2!\nBoth players will be competing to see who wins! (e)");
        cont = input.nextLine();

        Player p1 = new Player("Player 1");
        Player p2 = new Player("Player 2");
        
        System.out.println("The deck will be made and shuffled. (e)");
        cont = input.nextLine();

        Deck centerDeck = new Deck(1);

        centerDeck.shuffleCards();

        System.out.println("Here's the cards in the deck:\n" + centerDeck + "\nThe cards will be dealt to both players. (e)");
        cont = input.nextLine();

        centerDeck.deal(p1, p2);
        
        System.out.println("Here is player 1's deck:\n" + p1.toString() + "\n\nAnd here is player 2's deck:\n" + p2.toString() + "\n(e)");
        cont = input.nextLine();

        boolean int == false;

        while (win == false) {
            Card p1card = p1.dealTop();
            Card p2card = p2.dealTop();

            centerDeck.addCard(p1card);
            centerDeck.addCard(p2card);

            System.out.println("Player 1 has drawn their first card. It is a " + p1card);
            System.out.println("Player 2 has drawn their first card. It is a " + p2card + "\n(e)");
            cont = input.nextLine();

            switch (cardComp(p1card, p2card)) {
                case 1:
                    System.out.println("Player 1 has the higher value card.\nThey will be adding both drawn cards to their deck. (e)");
                    cont = input.nextLine();


                    centerDeck.

                    break;
                
                case 2:
                    System.out.println("Player 2 has the higher value card.\nThey will be adding both drawn cards to their deck. (e)");
                    cont = input.nextLine();
                    break;

                //war
                case 0:
                    System.out.println("Both players drew equal-value cards.\nThis means WAR! (e)");
                    cont = input.nextLine();
                    break;

                default:
                    System.out.println("Well, this is awkward.\nThe game ran into an unhandled exception.\nError: Impossible Card Comparison Result");
                    break;
            }
        }
    }

    private int cardComp(Card p1card, Card p2card){
        if (p1card.compareTo(p2card) < 0) {
            return 2;
        } else if (p1card.compareTo(p2card) > 0){
            return 1;
        } else if (p1card.compareTo(p2card) == 0){
            return 0;
        } else {
            return -1;
        }
    }
}