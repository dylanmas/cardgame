/*
Date:
    2/14/2021
Coder name:
    Dylan Masulis
Project name:
    Card Game
*/

//import all of java.util
import java.util.*;

public class Player {

    //declaration of the player name
    private String name = "";
    
    //declaration of the cards that the player posesses
    private ArrayList<Card> inventory;
    
    //constructor initializes the player's inventory and assigns a name
    public Player(String nameIn){
        inventory = new ArrayList<Card>();   
        name = nameIn;
    }

    //----------------------------------------------------------getter and setter methods:

    //getPlayerCard returns the card at the specified index
    public Card getPlayerCard(int index){
        return inventory.get(index);
    }

    //addPlayerCard adds a specified card onto the top of the deck
    public void addPlayerCard(Card adder){
        inventory.add(adder);
    }

    //addPlayerCardAt adds a specified card into a specified index of the array
    //likely going to be only for debugging
    public void addPlayerCardAt(Card adder, int index){
        inventory.add(index, adder);
    }

    //removePlayerCardAt removes a card at a specific index
    //this won't be independently used i think
    public void removePlayerCardAt(int index){
        inventory.remove(index);
    }

    //removePlayerCard removes the top card
    //i dont think this will be independently called either
    public void removePlayerCard(){
        inventory.remove(inventory.size() - 1);
    }

    //getDeckSize won't ever be used, but it's there just in case
    //returns the size of the player's inventory
    public int getDeckSize(){
        return inventory.size();
    }
    
    //----------------------------------------------------------toString method:

    public String toString(){
        String output = name + "\n";
        for (int i = 0; i < inventory.size(); i++) {
            output += inventory.get(i) + "\n";
        }
        return output;
    }

    //----------------------------------------------------------unique methods:

    //the deal methods would ideally have their calls be assigned to a variable.
    //that's because you need to assign it to a variable to store the removed card.
    
    //dealTop removes the top card and returns the removed card (ideally into a variable)
    public Card dealTop(){
        //creates output variable as a temp
        Card output;
        //assigns the card being removed to the temp
        output = inventory.get(inventory.size() - 1);
        //removes top the card from the inventory
        inventory.remove(inventory.size() - 1);
        //returns the output
        return output;
    }

    //dealBottom removes the bottom card and returns the removed card (ideally into a variable)
    public Card dealBottom(){
        //creates output variable as a temp
        Card output;
        //assigns the card being removed to the temp
        output = inventory.get(0);
        //removes top the card from the inventory
        inventory.remove(0);
        //returns the output
        return output;
    }

    //dealIndex removes a card at a specified index and returns the removed card (ideally into a variable)
    public Card dealIndex(int index){
        //creates output variable as a temp
        Card output;
        //assigns the card being removed to the temp
        output = inventory.get(index);
        //removes the card at the specific index from the inventory
        inventory.remove(index);
        //returns the output
        return output;
    }

}