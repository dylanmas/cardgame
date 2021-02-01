/*
Date:
    1/17/2021
Coder name:
    Dylan Masulis
Project name:
    Card Game
*/

//import all of java.util
import java.util.*;

public class Deck {
    
    //declaration of the deck
    private ArrayList<Card> deck;

    //initialize the deck w/ new ArrayList
    public Deck(){
        deck = new ArrayList<>(); 
    }

    //if a number is added as a parameter, a deck will be created and the cards will be automatically added. (calling makeDeck)
    //basically done to save time (probably doesnt do much to save time honestly)
    public Deck(int foo){
        deck = new ArrayList<>();
        //the difference is that this calls makeDeck() to save a step.
        this.makeDeck();
    }

    //----------------------------------------------------------getter and setter methods:

    //the purpose of getDeck(int pos) is to list a specific card in the deck.
    //likely only used for debugging.
    public String getDeck(int pos){
        return deck.get(pos).toString();
    }

    //getDeckSize() just retreives the size.
    //likely only used for debugging.
    public int getDeckSize(){
        return deck.size();
    }

    //addCard() inserts specific data at a certain index of the deck.
    public void addCard(int pos, Card insert){
        deck.add(pos, insert);
    }

    //wipeDeck() clears the entire deck of all cards.
    //likely going to be used for starting new games?
    public void wipeDeck(){
        deck.clear();
    }

    //----------------------------------------------------------toString method:
    public String toString(){
        //the purpose of getDeck() is to list the entire deck.
        //good for debugging if you want to see what cards are left.
        String output = "";

        //utilizes the exotic for-each loop.
        for (Card foo : deck) {
            //adds each result to the output.
            output += foo + "\n";
        }

        //returns the final output after being through the loop.
        return output;
    }

    //----------------------------------------------------------unique methods:

    //makeDeck() fills the arraylist with all of the cards in a standard deck of cards in nice order.
    public void makeDeck() {
        //uses for loop to generate all cards in the deck
        //i will determine suits
        for (int i = 1; i <= 4; i++) {
            //j determines the value
            for(int j = 1; j <= 13; j++){
                //adds the new card based on the two values j and i.
                deck.add(new Card(j, i));
            }
        }
    }

    //shuffleCards() uses java.util.Collections' shuffle method to scramble the entire deck.
    public void shuffleCards(){
        //the idea to use collections.shuffle came from Mr. O'Brien. Thanks for the suggestion!
        Collections.shuffle(deck);
    }

    //deal() deals one half of the deck to each player.
    //should be used after calling shuffleCards() 
    public void deal(Player p1, Player p2){
        //must have two players initialized to use
        for (int i = 1; i <= 26; i++) {
            //adds index "i" card to each player.
            p1.addPlayerCard(deck.get(i));
            //p2 has 26 added to the index to access the other half of the cards.
            p2.addPlayerCard(deck.get(i + 26));
        }
        
    }
}