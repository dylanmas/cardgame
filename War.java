/*
Date:
    3/1/2021
Coder name:
    Dylan Masulis
Project name:
    Card Game
*/
import java.util.*;

import jdk.vm.ci.meta.Constant;

public class War {

    Player p1, p2;
    Scanner input = new Scanner(System.in);
    Deck centerDeck;
    String cont = "";
    boolean fastmodeEnabled = false;

    /*
        NOTES TO SELF:
        REMOVE REVEALING OF DECK TO VIEWER.
        MAKE IT DRAW FROM TOP, NOT BOTTOM AND SUCH.
        CREATE COMMANDS (!FASTMODE SKIPS ALL ENTER PROMPTS.)
    */

    public War (){

        System.out.println("When you see (e) at the end of the text, press enter to continue.\n(e)");
        cont = input.nextLine();

        System.out.println("At any time, you can type in \"fastmode\" to skip all enter prompts, saving you time.\n(e)");
        checkCommand();

        System.out.println("The game is starting...\nPlease welcome Player 1 and Player 2!\nBoth players will be competing to see who wins!\n(e)");
        checkCommand();

        p1 = new Player("Player 1");
        p2 = new Player("Player 2");
        
        System.out.println("The deck will be made and shuffled.\n(e)");
        checkCommand();

        centerDeck = new Deck(1);

        centerDeck.shuffleCards();

        System.out.println("Here's the cards in the deck:\n" + centerDeck + "\nThe cards will be dealt to both players.\n(e)");
        checkCommand();

        centerDeck.deal(p1, p2);
        centerDeck.wipeDeck();
        
        System.out.println("Here is player 1's deck:\n" + p1.toString() + "\n\nAnd here is player 2's deck:\n" + p2.toString() + "\n(e)");
        checkCommand();

        System.out.println(prediction() + "\n(e)");
        checkCommand();

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
            checkCommand();

            switch (cardComp(p1card, p2card)) {
                case 1:
                    System.out.println("Player 1 has the higher value card.\nThey will be adding both drawn cards to their deck.\n(e)");
                    checkCommand();

                    centerDeck.removeCard();
                    centerDeck.removeCard();

                    p1.addPlayerCard(p1card);
                    p1.addPlayerCard(p2card);

                    System.out.println("Player 1 now has " + p1.getDeckSize() + " cards.\n(e)");
                    //System.out.println("Player 1 now has " + p1.toString() + " cards.\n(e)");
                    checkCommand();

                    break;
                
                case 2:
                    System.out.println("Player 2 has the higher value card.\nThey will be adding both drawn cards to their deck.\n(e)");
                    checkCommand();

                    centerDeck.removeCard();
                    centerDeck.removeCard();

                    p2.addPlayerCard(p2card);
                    p2.addPlayerCard(p1card);

                    System.out.println("Player 2 now has " + p2.getDeckSize() + " cards.\n(e)");
                    //System.out.println("Player 1 now has " + p2.toString() + " cards.\n(e)");
                    checkCommand();

                    break;

                //war
                case 0:
                    System.out.println("Both players drew equal-value cards.\n~~ A war has now commenced! ~~ \n(e)");
                    checkCommand();

                    doWar();
                    
                    System.out.println("Player 1 now has " + p1.getDeckSize() + " cards.\n(e)");
                    System.out.println("Player 2 now has " + p2.getDeckSize() + " cards.\n(e)");
                    
                    //the steps are made into a method

                    //step 1: both players draw 1 card from their deck, which doesn't count.

                    //step 2: both players draw 1 more card from the deck, which counts.
                    
                    //make an if statement.
                    //if p1 has the higher card, they take all 6 cards.
                    //if p2 has the higher card, they take all 6 cards.
                    //else, if both cards are equal, step 1 is repeated.
                    
                    

                    break;

                default:
                    System.out.println("Well, this is awkward.\nThe game ran into an unhandled exception.\nError: Impossible Card Comparison Result");
                    break;
            }
        }
    }

    private String prediction(){
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

    private void doWar(){
        //the steps are made into a method

        //step 1: both players draw 1 card from their deck, which doesn't count.
        Card p1card = p1.dealBottom();
        Card p2card = p2.dealBottom();
        System.out.println("p1card is " + p1card + "\np2card is " + p2card);
        
        centerDeck.wipeDeck();

        centerDeck.addCard(p1card);
        centerDeck.addCard(p2card);
        //step 2: both players draw 1 more card from the deck, which counts.
        p1card = p1.dealBottom();
        p2card = p2.dealBottom();

        centerDeck.addCard(p1card);
        centerDeck.addCard(p2card);

        //make an if statement.
        if (cardComp(p1card, p2card) == 1) {
            //player 1 takes all from deck
            System.out.println(centerDeck + "         0f0f0f0f0f");
            centerDeck.deal(p1);
        } else if (cardComp(p1card, p2card) == 2){
            //player 2 takes all from deck
            System.out.println(centerDeck + "              ff");
            centerDeck.deal(p2);
        } else {
            //if equal, war is declared again.
            System.out.println(centerDeck);
            doWar();
        }
        //if p1 has the higher card, they take all 6 cards.
        //if p2 has the higher card, they take all 6 cards.
        //else, if both cards are equal, step 1 is repeated.
    }

    private void checkCommand(){
        if (fastmodeEnabled == false && cont.equals("fastmode")) {
            fastmodeEnabled = true;
        } else if (fastmodeEnabled == false){
            cont = input.nextLine();
            switch (cont) {
                case "help":
                    System.out.println("Help is not working at this time.\n(e)");
                    checkCommand();
                    break;
                
                case "p1cards":
                    System.out.println("Here are the cards for Player 1:\n(e)");
                    checkCommand();
                    break;

                case "p2cards":
                    System.out.println("Here are the cards for Player 2:\n(e)");
                    checkCommand();
                    break;

                case "p1decksize":
                    System.out.println("Here is the size of Player 1's deck:\n(e)");
                    checkCommand();
                    break;

                case "p2decksize":
                    System.out.println("Here is the size of Player 2's deck:\n(e)");
                    checkCommand();
                    break;

                case "":
                    break;

                default:
                    System.out.println("I can't recognize what you typed. Try typing it in again.\n¬");
                    checkCommand();
                    break;
            }
        } else {
            //do nothing
        }
    }
}