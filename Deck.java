import java.util.*;

/*
Date:
    1/17/2021
Coder name:
    Dylan Masulis
Project name:
    Card Game
*/

public class Deck {
    
    private ArrayList<Card> deck;

    //initialize the deck
    public Deck(){
        deck = new ArrayList<>(); 
        //going to use a sorting algorithm to shuffle.
    }

    //if a number is added, a deck will be created and the cards will be automatically added. (calling makeDeck)
    public Deck(int diff){
        deck = new ArrayList<>();
        this.makeDeck();
    }

    //accessor methods:
    public String getDeck(int pos){
        //the purpose of getDeck(int pos) is to list a specific card in the deck.
        //once again, likely only used for debugging.

        return deck.get(pos).toString();
    }

    public int getDeckSize(){
        return deck.size();
    }

    //mutator methods

    public void addCard(int pos, Card insert){
        deck.add(pos, insert);
    }

    public void wipeDeck(){
        deck.clear();
    }

    public void makeDeck() {
        //uses for loop to generate all cards in the deck
        //i will determine suits
        for (int i = 1; i <= 4; i++) {
            //j determines the value
            for(int j = 1; j <= 13; j++){
                deck.add(new Card(j, i));
            }
        }
    }

    //toString:
    public String toString(){
        //the purpose of getDeck() is to list the entire deck.
        //good for debugging if you want to see what cards are left.
        
        String output = "";
        
        for (int i = 0; i < deck.size(); i++) {
            output += deck.get(i).toString() + "\n";
        }

        return output;
    }

    //the good stuff: the shuffle and deal method!

    public void shuffle(){
        Collections.shuffle(deck);
    }

    public void deal(Player p1, Player p2){
        //must have two players initialized to write
        for (int i = 1; i <= 26; i++) {
            p1.addCard(deck.get(i));
            p2.addCard(deck.get(i + 26));
        }
        
    }
}