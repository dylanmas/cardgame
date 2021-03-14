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
        
        System.out.println("When you see (e) at the end of the text, press enter to continue.\n(e)");
        cont = input.nextLine();

        System.out.println("The game is starting...\nPlease welcome Player 1 and Player 2!\nBoth players will be competing to see who wins!\n(e)");
        cont = input.nextLine();

        Player p1 = new Player("Player 1");
        Player p2 = new Player("Player 2");
        
        System.out.println("The deck will be made and shuffled.\n(e)");
        cont = input.nextLine();

        Deck centerDeck = new Deck(1);

        centerDeck.shuffleCards();

        System.out.println("Here's the cards in the deck:\n" + centerDeck + "\nThe cards will be dealt to both players.\n(e)");
        cont = input.nextLine();

        centerDeck.deal(p1, p2);
        
        System.out.println("Here is player 1's deck:\n" + p1.toString() + "\n\nAnd here is player 2's deck:\n" + p2.toString() + "\n(e)");
        cont = input.nextLine();

        System.out.println(prediction(p1, p2) + "\n(e)");
        cont = input.nextLine();

        boolean win = false;

        while (win == false) {
            //remove 1 card from each player
            Card p1card = p1.dealBottom();
            Card p2card = p2.dealBottom();
            //p1card and p2card will store the single cards pulled from each player

            //add to the central deck
            centerDeck.addCard(p1card);
            centerDeck.addCard(p2card);

            System.out.println("Player 1 has drawn their card. It is a " + p1card);
            System.out.println("Player 2 has drawn their card. It is a " + p2card + "\n(e)");
            cont = input.nextLine();

            switch (cardComp(p1card, p2card)) {
                case 1:
                    System.out.println("Player 1 has the higher value card.\nThey will be adding both drawn cards to their deck.\n(e)");
                    cont = input.nextLine();

                    centerDeck.removeCard();
                    centerDeck.removeCard();

                    p1.addPlayerCard(p1card);
                    p1.addPlayerCard(p2card);

                    System.out.println("Player 1 now has " + p1.getDeckSize() + " cards.\n(e)");
                    //System.out.println("Player 1 now has " + p1.toString() + " cards.\n(e)");
                    cont = input.nextLine();

                    break;
                
                case 2:
                    System.out.println("Player 2 has the higher value card.\nThey will be adding both drawn cards to their deck.\n(e)");
                    cont = input.nextLine();

                    centerDeck.removeCard();
                    centerDeck.removeCard();

                    p2.addPlayerCard(p2card);
                    p2.addPlayerCard(p1card);

                    System.out.println("Player 2 now has " + p2.getDeckSize() + " cards.\n(e)");
                    //System.out.println("Player 1 now has " + p2.toString() + " cards.\n(e)");
                    cont = input.nextLine();

                    break;

                //war
                case 0:
                    System.out.println("Both players drew equal-value cards.\n~~ A war has now commenced! ~~ \n(e)");
                    cont = input.nextLine();

                    //step 1: both players draw 1 card from their deck, which doesn't count.

                    //step 2: both players draw 1 more card from the deck, which counts.
                    //whoever has the higher card takes all 6 cards.

                    break;

                default:
                    System.out.println("Well, this is awkward.\nThe game ran into an unhandled exception.\nError: Impossible Card Comparison Result");
                    break;
            }
        }
    }

    private String prediction(Player p1, Player p2){
        int p1result = 0;
        int p2result = 0;

        for (int i = 0; i < p1.getDeckSize(); i++) {
            p1result += p1.getPlayerCard(i).getValue();
            p2result += p2.getPlayerCard(i).getValue();
        }

        if (p1result - p2result < 0) {
            return "Based on total values in the deck for both players, player 2 likely wins by " + ((int)(((double)p1result / (double)p2result) * 1000) / 10.0) + "%";
        } else if (p1result - p2result > 0){
            return "Based on total values in the deck for both players, player 1 likely wins by " + ((int)(((double)p2result / (double)p1result) * 1000) / 10.0) + "%";
        } else {
            return "Based on total values in the deck for both players, a tie is likely.";
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